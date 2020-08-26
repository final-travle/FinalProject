package com.kh.FinalProject.notice.controller;

import java.io.File;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import com.kh.FinalProject.notice.model.exception.NoticeException;
import com.kh.FinalProject.notice.model.service.NoticeService;
import com.kh.FinalProject.notice.model.vo.Notice;




@Controller
public class NoticeController {
	
	@Autowired
	NoticeService nService;	
	
	public static final int LIMIT = 5;
	
		
	@RequestMapping(value="nlist.do", method=RequestMethod.GET)
	public ModelAndView noticeListService(
				@RequestParam(name = "page",  required = false, defaultValue="1") int page,
				@RequestParam(name = "keyword", required = false) String keyword, 
								ModelAndView mv ) {
		
		try {
			
			
			int currentPage = page;
				
			int listCount = nService.totalCount();
			int maxPage = (int)((double)listCount/LIMIT + 0.9);
						
	
						
			if(keyword != null) 
				mv.addObject("list", nService.selectSearch(keyword))
				  .addObject("currentPage", page)
				  .addObject("listCount", listCount)
				  .setViewName("notice/noticeListView");
			else 	
				mv.addObject("list", nService.selectList(currentPage, LIMIT));
				mv.addObject("currentPage", page);
				mv.addObject("maxPage", maxPage); 
				mv.addObject("listCount", listCount);
				mv.setViewName("notice/noticeListView");
		  }catch(Exception e) {
			  mv.addObject("msg", e.getMessage());
		  }
				
		return mv;
	}
	
	
	
	@RequestMapping("nWriterView.do")
	public String nWriterView() {
		return "notice/noticeWriteForm";
	}
	
	@RequestMapping(value="ninsert.do", method=RequestMethod.POST)
	public String noticeInsert(Notice n, HttpServletRequest request,
			@RequestParam(name="uploadFile", required=false) MultipartFile file) {
		

				   
		 // required=false라는 속성을 주고 uploadFile이 없어도 에러가 나지 않게 처리 함 
		 // (반드시 필요한 값이 아니라는 얘기)
		
		if(!file.getOriginalFilename().contentEquals("")) { // 빈 파일이 아닐 때
			String savePath = saveFile(file, request);
			
				if(savePath != null) { // 파일이 잘 저장된 경우 
					n.setFileName(file.getOriginalFilename());
					
				}
			}
		
		int result = nService.insertNotice(n);
		if(result > 0) {
			return "redirect:nlist.do";
		}else {
			throw new NoticeException("공지사항 등록 실패!");
		}

	}
	
		public String saveFile(MultipartFile file, HttpServletRequest request) {
			// 파일이 저장될 경로를 설정하는 메소드 
			
			String root = request.getSession().getServletContext().getRealPath("resources");
			// request.getSession().getServletContext() ==> 경로를 모두 뽑아줄 수 있기 때문에 사용한 것
			
			String savePath = root + "\\nuploadFiles";
			
			File folder = new File(savePath);
			//	java.io.File로 import 해야한다. 
			
			if(!folder.exists()) {
				
				folder.mkdirs();
				// 폴더가 없으면 만들라는 뜻
			}
			
			// 공지글  파일명 중복 제거 x
			String filePath = folder + "\\" + file.getOriginalFilename();
			// 실제 저장 될 파일 경로 + 파일명 
			
			try {
				file.transferTo(new File(filePath)); // 이 때 파일이 저장된다.  transferTo를 통해 file을 filePath에 집어 넣는다.
				// 단, 이상태로는 파일 업로드가 되지 않는다. 왜냐하면 파일 제한크기에 대한 설정이 없기 때문에 
				// 그래서 파일 크기 지정을 root-context.xml에서 해준다. 				
			} catch (Exception e) {			
				
			} 
						
			return filePath;
		}
	
	@RequestMapping("ndetail.do")
	public ModelAndView noticeDetail(ModelAndView mv, int postNo,
									@RequestParam("page") Integer page) {
		
		int currentPage = 1;
		if(page != null) {
			currentPage = page;
		}
		
		int result = nService.addReadCount(postNo);
		
		if(result > 0) {
			Notice notice = nService.selectNotice(postNo);
			
			if(notice != null) {
				mv.addObject("notice", notice)
				.addObject("currentPage", currentPage)
				.setViewName("notice/noticeDetailView");
			
			}else {
				throw new NoticeException("게시글 조회 실패");
			}
			
		}else {
			throw new NoticeException("게시글 조회수 증가 실패");
		}
		return mv;		
	}
	
	@RequestMapping("nupView.do")
	public ModelAndView noticeUpdateView(ModelAndView mv, int postNo, 
											@RequestParam("page") Integer page) {
		
		mv.addObject("notice", nService.selectNotice(postNo))
			.addObject("currentPage", page)
			.setViewName("notice/noticeUpdateForm");
		
		return mv;
	}
	
	@RequestMapping("nupView2.do")
	public ModelAndView noticeUpdateView2(ModelAndView mv, int postNo, 
											@RequestParam("page") Integer page) {
		
			mv.addObject("notice", nService.selectNotice2(postNo))
			.addObject("currentPage", page)
			.setViewName("notice/noticeUpdateForm2");
		
		return mv;
	}
	
	@RequestMapping("nupdate.do")
	public String noticeUpdate(HttpServletRequest request, Notice n, 
									@RequestParam(value="reuploadFile", required=false)
									  MultipartFile reuploadFile) {
		
		if(reuploadFile != null) { // 새로 업로드한 파일이 있다면 
			if(n.getFileName() != null) {
				deleteFile(n.getFileName(), request); 
			}
		}
		
		String savePath = saveFile(reuploadFile, request);
		
		if(savePath != null) { // 잘 저장 되었다면 
			n.setFileName(reuploadFile.getOriginalFilename());				
		}
		
		int result = nService.updateNotice(n);
		
		if(result > 0) {
			
			return "redirect:nlist.do";
		}else {
			throw new NoticeException("공지사항 수정 실패!");
		}
	}

	private void deleteFile(String fileName, HttpServletRequest request) {
		String root = request.getSession().getServletContext().getRealPath("resources");
		String savePath = root + "\\nuploadFiles";
		
		File f = new File(savePath + "\\" + fileName);
		
		if(f.exists()) {
			f.delete();
		}
		
	}
	
	@RequestMapping("ndelete.do")
	public String noticeDelete(int postNo, HttpServletRequest request) {
		Notice n = nService.selectNotice(postNo);
		
		if(n.getFileName() != null) {
			deleteFile(n.getFileName(), request);
		}
		
		int result = nService.deleteNotice(postNo);
		
		if(result > 0) {
			return "redirect:nlist.do";			
		}else {
			throw new NoticeException("게시물 삭제 실패");
		}
				
	}
	
}

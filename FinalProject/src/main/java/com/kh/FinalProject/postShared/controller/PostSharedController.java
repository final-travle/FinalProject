package com.kh.FinalProject.postShared.controller;

import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kh.FinalProject.common.Pagination;
import com.kh.FinalProject.common.Pagination2;
import com.kh.FinalProject.member.model.service.MemberService;
import com.kh.FinalProject.member.model.vo.Friends;
import com.kh.FinalProject.member.model.vo.Member;
import com.kh.FinalProject.postShared.model.service.PostSharedService;
import com.kh.FinalProject.postShared.model.vo.PostShared;
import com.kh.FinalProject.travel.model.service.TravelService;
import com.kh.FinalProject.travel.model.vo.Board;
import com.kh.FinalProject.travel.model.vo.PageInfo;
import com.kh.FinalProject.travel.model.vo.PostTag;

@Controller
public class PostSharedController {

	
	@Autowired
	private MemberService mService;
	
	
	@Autowired
	private PostSharedService pService;

	 @Autowired
	 TravelService ts;
	
	@RequestMapping("memberplanList.do")
	public ModelAndView planListView(HttpSession session,ModelAndView mv,
			@RequestParam(value="page", required=false) Integer page) {
		
		
		
		Member mb = (Member) session.getAttribute("loginUser");
		int currentPage = 1;
		if(page != null) {
			currentPage = page;
		}
		
		int listCount = ts.getListCount();
		
		PageInfo pi2 = Pagination2.getPageInfo2(currentPage, listCount);
		
		ArrayList<Board> list = pService.selectList(pi2,mb.getId());
		ArrayList<PostTag> tl = pService.selectListTag();
		
		if(list != null) {
			mv.addObject("tl", tl);
			mv.addObject("list", list);
			mv.addObject("pi", pi2);
			mv.setViewName("member/myPageMyPost");
		}else {
			
		}
		
		return mv;
		
	}
	
	@RequestMapping("mypageSharedme.do")
	public ModelAndView mypageSharedme(HttpSession session,ModelAndView mv,
			@RequestParam(value="page", required=false) Integer page) {
		
		
		
		Member mb = (Member) session.getAttribute("loginUser");
		ArrayList<PostShared> psd = pService.selectShare(mb.getId());
				
		
//		int listCount = ts.getListCount();
		ArrayList<Board> list = new ArrayList<Board>(); 
				for(int i =0;i<psd.size();i++) {
					list.add(pService.selectsharedList(psd.get(i)) );
					
				}
				
		ArrayList<PostTag> tl = pService.selectListTag();
		
		if(list != null) {
			mv.addObject("tl", tl);
			mv.addObject("list", list);
			mv.setViewName("member/mypageSharedme");
		}
		
		return mv;
		
	}
	

	@RequestMapping("memberdeleteShared.do")
	public ModelAndView memberdeleteShared(@RequestParam(value="searchInput", required=false) String search,
			Integer postNo,String postType,String id,
			HttpSession session,ModelAndView mv, @RequestParam(value="page", required=false) Integer page) {						
		
		String idd =id.replace(" ","");
		PostShared ps = new PostShared();
		ps.setPost_no(postNo);
		ps.setPost_type(postType);
		ps.setShare_id(idd);
		pService.deleteShared(ps);		
		Member m = (Member) session.getAttribute("loginUser");
		ArrayList<Friends> fal = mService.realfriendsShared(m.getId(),search); //내가 db에 내가 들어있는 친구 목록을 다뽑아옴(왼쪽에 내 아이디면 오른쪽 컬럼값 오른쪽 내아이디면 왼쪽컬럼)
		ArrayList<String> al = new ArrayList<String>();//목록중 친구아이디을 다뽑아옴
		ArrayList<String> sharedfd = mService.sharedfd(postNo,postType,m.getId()); //공유된 친구 아이디
		
		
		for(int i=0;i<fal.size();i++) {
			if(fal.get(i).getfId().equals(m.getId())) {//친구 아이디 컬럼에 로그인된 아이디랑 같으면 userid에 있는 것을 가져와라
				al.add(fal.get(i).getUserId());
			}else if(fal.get(i).getUserId().equals(m.getId())) {//userId 컬럼와 로그인된 아이디가 같으면 fid에있는것을 al에 넣어라
				al.add(fal.get(i).getfId());
			}
		}
		
		
		
		ArrayList<Member> mal =new ArrayList<Member>(); //친구의 member 정보값 이거 이용
		ArrayList<Member> mal2 =new ArrayList<Member>(); //공유된 친구의 정보값 
		for(int i =0;i<al.size();i++) {
			mal.add(mService.friendsInfo(al.get(i)));
		}
		for(int i =0;i<sharedfd.size();i++) {
			mal2.add(mService.friendsInfo(sharedfd.get(i)));
		}
		
		mv.addObject("friendsshared",mal2);
		mv.addObject("postNo",postNo);
		mv.addObject("postType",postType);
		mv.addObject("allshared",sharedfd);
		mv.addObject("friends",mal);
		mv.setViewName("member/myPageSharedpost");
//		공유되는 테이블에서 공유되는 것을 가져와야됨
			
		return mv;
		
	}
	
	
	@RequestMapping("memberplanListShared.do")
	public ModelAndView planListSharedView(@RequestParam(value="searchInput", required=false) String search,
			Integer postNo,String postType,
			HttpSession session,ModelAndView mv, @RequestParam(value="page", required=false) Integer page) {
		
		Member m = (Member) session.getAttribute("loginUser");
		ArrayList<Friends> fal = mService.realfriendsShared(m.getId(),search); //내가 db에 내가 들어있는 친구 목록을 다뽑아옴(왼쪽에 내 아이디면 오른쪽 컬럼값 오른쪽 내아이디면 왼쪽컬럼)
		ArrayList<String> al = new ArrayList<String>();//목록중 친구아이디을 다뽑아옴
		ArrayList<String> sharedfd = mService.sharedfd(postNo,postType,m.getId()); //공유된 친구 아이디
		
		
		for(int i=0;i<fal.size();i++) {
			if(fal.get(i).getfId().equals(m.getId())) {//친구 아이디 컬럼에 로그인된 아이디랑 같으면 userid에 있는 것을 가져와라
				al.add(fal.get(i).getUserId());
			}else if(fal.get(i).getUserId().equals(m.getId())) {//userId 컬럼와 로그인된 아이디가 같으면 fid에있는것을 al에 넣어라
				al.add(fal.get(i).getfId());
			}
		}
		
		
		
		ArrayList<Member> mal =new ArrayList<Member>(); //친구의 member 정보값 이거 이용
		ArrayList<Member> mal2 =new ArrayList<Member>(); //공유된 친구의 정보값 
		for(int i =0;i<al.size();i++) {
			mal.add(mService.friendsInfo(al.get(i)));
		}
		for(int i =0;i<sharedfd.size();i++) {
			mal2.add(mService.friendsInfo(sharedfd.get(i)));
		}
		
		mv.addObject("friendsshared",mal2);
		mv.addObject("postNo",postNo);
		mv.addObject("postType",postType);
		mv.addObject("allshared",sharedfd);
		mv.addObject("friends",mal);
		mv.setViewName("member/myPageSharedpost");
//		공유되는 테이블에서 공유되는 것을 가져와야됨
			
		return mv;
		
	}
	
	
	@RequestMapping("memberSharedInsert.do")
	public ModelAndView memberSharedInsert(@RequestParam(value="searchInput", required=false) String search,
			Integer postNo,String postType,String id,
			HttpSession session,ModelAndView mv, @RequestParam(value="page", required=false) Integer page) {
		
		
		Member m = (Member) session.getAttribute("loginUser");
	
		
		int num = pService.SharedInsert(m.getId(),id,postNo,postType);
		
		if(num>0) {

		
			ArrayList<Friends> fal = mService.realfriendsShared(m.getId(),search); //내가 db에 내가 들어있는 친구 목록을 다뽑아옴(왼쪽에 내 아이디면 오른쪽 컬럼값 오른쪽 내아이디면 왼쪽컬럼)
			ArrayList<String> al = new ArrayList<String>();//목록중 친구아이디을 다뽑아옴
			ArrayList<String> sharedfd = mService.sharedfd(postNo,postType,m.getId()); //공유된 친구 아이디
			System.out.println(sharedfd);
			
			for(int i=0;i<fal.size();i++) {
				if(fal.get(i).getfId().equals(m.getId())) {//친구 아이디 컬럼에 로그인된 아이디랑 같으면 userid에 있는 것을 가져와라
					al.add(fal.get(i).getUserId());
				}else if(fal.get(i).getUserId().equals(m.getId())) {//userId 컬럼와 로그인된 아이디가 같으면 fid에있는것을 al에 넣어라
					al.add(fal.get(i).getfId());
				}
			}
			
			
		
			ArrayList<Member> mal =new ArrayList<Member>(); //친구의 member 정보값 이거 이용
			ArrayList<Member> mal2 =new ArrayList<Member>(); //공유된 친구의 정보값 
			for(int i =0;i<al.size();i++) {
				mal.add(mService.friendsInfo(al.get(i)));
			}
			for(int i =0;i<sharedfd.size();i++) {
				mal2.add(mService.friendsInfo(sharedfd.get(i)));
			}
			System.out.println(mal2);
			mv.addObject("friendsshared",mal2);
			mv.addObject("postNo",postNo);
			mv.addObject("postType",postType);
			mv.addObject("allshared",sharedfd);
			mv.addObject("friends",mal);
			mv.setViewName("member/myPageSharedpost");
		}else {
			mv.setViewName("member/myPageSharedpost");
		}
		return mv;
	}
		
	
}

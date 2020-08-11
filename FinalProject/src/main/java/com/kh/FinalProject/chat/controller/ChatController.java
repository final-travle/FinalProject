package com.kh.FinalProject.chat.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kh.FinalProject.chat.model.service.ChatService;
import com.kh.FinalProject.chat.model.vo.Chatroom;
import com.kh.FinalProject.chat.model.vo.OneToOne;
import com.kh.FinalProject.member.model.service.MemberService;
import com.kh.FinalProject.member.model.vo.Friends;
import com.kh.FinalProject.member.model.vo.Member;


@SessionAttributes("loginUser")

@Controller
public class ChatController {

	@Autowired
	private ChatService cService;
	
	 @RequestMapping("friendList.do") 
	 public ModelAndView friendList(ModelAndView mv,HttpSession session) {
		 
		Member m =  (Member)session.getAttribute("loginUser");
		String id =  m.getId();
		
		 System.out.println(id);
//		 ArrayList<Member> friendList = new ArrayList();
//		 friendList = cService.friendList(id);
//		 System.out.println("친구 목록 : " + friendList);
		 ArrayList<Friends> friendList = new ArrayList();
		 friendList = cService.friendList(id);
		 ArrayList<String> al = new ArrayList<String>();//목록중 친구아이디을 다뽑아옴
			for(int i=0;i<friendList.size();i++) {
				if(friendList.get(i).getfId().equals(m.getId())) {//친구 아이디 컬럼에 로그인된 아이디랑 같으면 userid에 있는 것을 가져와라
					al.add(friendList.get(i).getUserId());
				}else if(friendList.get(i).getUserId().equals(m.getId())) {//userId 컬럼와 로그인된 아이디가 같으면 fid에있는것을 al에 넣어라
					al.add(friendList.get(i).getfId());
				}
			}
			ArrayList<Member> mal =new ArrayList<Member>();
			for(int i =0;i<al.size();i++) {
				mal.add(cService.friendsInfo(al.get(i)));
			}
			System.out.println("친구 정보" + mal);
		 
		 ArrayList<Chatroom> chatroomList = new ArrayList();
		 chatroomList = cService.selectChatroomList();
		 System.out.println("채팅방 목록 : ");
		 
		 if(mal != null) {
			 mv.addObject("friendList", mal);
			 mv.setViewName("chat/friendList");
		 }else {
			 mv.addObject("friendList", mal);
			 mv.setViewName("chat/friendList");
		 }
		 
		 if(chatroomList != null) {
				mv.addObject("chatroomList",chatroomList);
				mv.setViewName("chat/friendList");
			}else {
				mv.addObject("chatroomList",chatroomList);
				mv.setViewName("chat/friendList");
			}
		 
		 
		 return mv;
	 }
	 
	 @RequestMapping("openChatroomList.do") 
	 public ModelAndView openChatroomList(ModelAndView mv,HttpSession session) {
		 
		Member m =  (Member)session.getAttribute("loginUser");
		String id =  m.getId();
		
		 System.out.println(id);
//		 ArrayList<Member> friendList = new ArrayList();
//		 friendList = cService.friendList(id);
//		 System.out.println("친구 목록 : " + friendList);
		 ArrayList<Friends> friendList = new ArrayList();
		 friendList = cService.friendList(id);
		 ArrayList<String> al = new ArrayList<String>();//목록중 친구아이디을 다뽑아옴
			for(int i=0;i<friendList.size();i++) {
				if(friendList.get(i).getfId().equals(m.getId())) {//친구 아이디 컬럼에 로그인된 아이디랑 같으면 userid에 있는 것을 가져와라
					al.add(friendList.get(i).getUserId());
				}else if(friendList.get(i).getUserId().equals(m.getId())) {//userId 컬럼와 로그인된 아이디가 같으면 fid에있는것을 al에 넣어라
					al.add(friendList.get(i).getfId());
				}
			}
			ArrayList<Member> mal =new ArrayList<Member>();
			for(int i =0;i<al.size();i++) {
				mal.add(cService.friendsInfo(al.get(i)));
			}
		 
		 ArrayList<Chatroom> chatroomList = new ArrayList();
		 chatroomList = cService.selectChatroomList();
		 System.out.println("채팅방 목록 : ");
		 
		 if(mal != null) {
			 mv.addObject("friendList", mal);
			 mv.setViewName("chat/openChatroomList");
		 }else {
			 mv.addObject("friendList", mal);
			 mv.setViewName("chat/openChatroomList");
		 }
		 
		 if(chatroomList != null) {
				mv.addObject("chatroomList",chatroomList);
				mv.setViewName("chat/openChatroomList");
			}else {
				mv.addObject("chatroomList",chatroomList);
				mv.setViewName("chat/openChatroomList");
			}
		 
		 
		 return mv;
	 }
	 
	 
	 @RequestMapping("chatroomjoin.do")
	 public ModelAndView chatroomjoin(ModelAndView mv,HttpSession session,
				@RequestParam(value = "chatroomnumber", required = false) String chatroomnumber,
				@RequestParam(value="chatroomname", required = false) String chatroomname) {
		 
		 Chatroom cr = new Chatroom();
			cr.setChatroom_no(chatroomnumber);
			cr.setChatroomname(chatroomname);
			System.out.println("방번호  : " + cr.getChatroom_no());
			System.out.println("방 이름 : " + cr.getChatroomname());
			
			mv.addObject("cr", cr).setViewName("chat/chatroomdetail");
			
			Member loginUser = (Member)session.getAttribute("loginUser");
			loginUser.setChatroom_no(chatroomnumber);
			
			session.setAttribute("chatRoomnumber", loginUser.getChatroom_no());
			session.setAttribute("nickname", loginUser.getNickname());
		 
		 return mv;
	 }
	 
	 
	 @RequestMapping("makeOpenChatroom.do")
		public ModelAndView makeOpenChatroom(HttpServletRequest request, Chatroom cr, HttpSession session, ModelAndView mv) {
			
			System.out.println(cr);
			int result = cService.makeOpenChatroom(cr);
			
			if(result > 0) {
				cr = cService.selectOpenChatroom(cr.getChatroomname());
				System.out.println("번호까지 다조회해와서 " + cr);
				mv.addObject("cr", cr).setViewName("redirect:openChatroomList.do");
				mv.addObject("<script>window.close();</script>");
				
				Member loginUser = (Member)session.getAttribute("loginUser");
				session.setAttribute("userId", loginUser.getId());
				
				return mv;
				
			}else {
				mv.addObject("<script> alert('채팅방 생성이 실패했습니다.');  history.back(); </script>");
				return mv;			
			}
			
		}
	 
	 @RequestMapping("updateprofile.do")
	 public String updateProfile(HttpServletRequest request,Member m, HttpSession session,
			 									@RequestParam(value="update_myprofile", required=false) MultipartFile file) {
		 
		 System.out.println("사진 = " + m.getProfile());
			 if(m.getProfile() != "noprofile.png") {
				 deleteFile(m.getProfile(), request);
			 }
		 
		 
		 String profileFileName = saveFile(file, request);
		 
		 if(profileFileName != null) {
			 m.setProfile(profileFileName);
		 }
		 
		 int result = cService.updateProfile(m);
		 
		 Member m2 = (Member) session.getAttribute("loginUser");
		 
		 m2.setProfile(profileFileName);
		 
		 session.setAttribute("loginUser", m2);
		 
		 if(result > 0) {
			 System.out.println("프로필 수정 성공");
			  return "redirect:friendList.do";
		 }
		 else {
			System.out.println("수정 실패");
			return "redirect:friendList.do";
		 }
		
	 }
	 
	 public void deleteFile(String fileName, HttpServletRequest request) {
			String root = request.getSession().getServletContext().getRealPath("resources");
			
			String savePath = root + "\\profile";
			
			File f = new File(savePath + "\\" + fileName);
			if(f.exists()) {
				f.delete();
			}
			
		}
	 public String saveFile(MultipartFile file, HttpServletRequest request) {
			//파일이 저장될 경로를 설정하는 메소드
			
			String root = request.getSession().getServletContext().getRealPath("resources");
			
			String savePath = root + "//profile";
			
			File folder = new File(savePath);
			//java.io.File로 import 하자
			
			if(!folder.exists()) {
				folder.mkdirs();
			}
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			String originFileName = file.getOriginalFilename();
			String profileFileName = sdf.format(new java.sql.Date(System.currentTimeMillis()))+
					"." + originFileName.substring(originFileName.lastIndexOf(".") + 1);
			
			String filePath = folder + "\\" + profileFileName;
			
			try {
				file.transferTo(new File(filePath));		//이 때 파일이 저장된다.
				//이 상태로는 파일 업로드가 되지 않는다.
				//왜냐하면 파일 제한크기에 대한 설정이 없기 때문이다.
				//그래서 파일 크기 지정을 root-context.xml에서 해준다.
			} catch (Exception e) {
				System.out.println("파일 전송 에러" + e.getMessage());
			}	
			
			
			return profileFileName;
		}
	 
		
		  @RequestMapping("insertOneToOneChatroom.do")
		  public ModelAndView insertOneToOneChatroom(ModelAndView mv, HttpServletRequest request, HttpSession session,
				  																	@RequestParam(value="friendId", required=false) String friendId) {
			  
			  Member loginUser = (Member)session.getAttribute("loginUser");
			  
			  HashMap <String, String> map = new HashMap<>();
			  map.put("myId", loginUser.getId());
			  map.put("friendId", friendId);
			  
			  OneToOne oto = new OneToOne();
			  oto = cService.selectOneToOneRoom(map);
			  System.out.println("1대1방 검색 결과 : " + oto);
			  
			  if(oto == null) {
				  int result = cService.insertOneToOneRoom(map);
				  
				  oto=cService.selectOneToOneRoom(map);
				  if(result > 0) {
					  session.setAttribute("co_no", oto.getCo_no());
					  mv.addObject("oto",oto).setViewName("chat/oneToOneDetail");
				  }
				  
			  }else {
				  session.setAttribute("co_no", oto.getCo_no());
				  mv.addObject("oto",oto).setViewName("chat/oneToOneDetail");
			  }
			  
			  return mv;
		  }
		 
		  
}
























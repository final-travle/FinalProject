package com.kh.FinalProject.chat.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.kh.FinalProject.chat.model.service.ChatService;
import com.kh.FinalProject.chat.model.vo.Chatroom;
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
	 
	 
}
























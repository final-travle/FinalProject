package com.kh.FinalProject.chat.controller;

import java.util.ArrayList;

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
		 ArrayList<Member> friendList = new ArrayList();
		 friendList = cService.friendList(id);
		 System.out.println("친구 목록 : " + friendList);
		 
		 ArrayList<Chatroom> chatroomList = new ArrayList();
		 chatroomList = cService.selectChatroomList();
		 System.out.println("채팅방 목록 : ");
		 
		 if(friendList != null) {
			 mv.addObject("friendList", friendList);
			 mv.setViewName("chat/friendList");
		 }else {
			 mv.addObject("friendList", friendList);
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
	 
	
}
























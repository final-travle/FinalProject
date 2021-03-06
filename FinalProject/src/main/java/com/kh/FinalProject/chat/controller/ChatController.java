package com.kh.FinalProject.chat.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.kh.FinalProject.chat.model.service.ChatService;
import com.kh.FinalProject.chat.model.vo.Chatroom;
import com.kh.FinalProject.chat.model.vo.ChatroomMsg;
import com.kh.FinalProject.chat.model.vo.OneToOne;
import com.kh.FinalProject.chat.model.vo.OneToOneMsg;
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
		
		
		System.out.println("111" + id);
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
		 
//		 ArrayList<Chatroom> chatroomList = new ArrayList();
//		 chatroomList = cService.selectChatroomList();
//		 
//		 ArrayList<OneToOne> onetooneList = new ArrayList();
//		 onetooneList = cService.OneToOneList(id);
//		 System.out.println("1대1 채팅방 목록 = " + onetooneList);
//		 
//		 ArrayList<OneToOneMsg> readynCountList = new ArrayList();
//		 readynCountList = cService.ReadYNCountList();
//		 System.out.println("안읽은 메시지 갯수 = " + readynCountList);
//		 
//		 for(int i = 0; i < onetooneList.size(); i++) {
//			 for(int j = 0; j < readynCountList.size(); j++) {
//				 if(onetooneList.get(i).getCo_no().equals(readynCountList.get(j).getCo_no())) {
//					 if(!m.getId().equals(readynCountList.get(j).getChatId())) {
//						 onetooneList.get(i).setCount(readynCountList.get(j).getCount());
//					 }
//				 }
//			 }
//		 }
		 
		 if(mal != null) {
			 mv.addObject("friendList", mal);
			 mv.setViewName("chat/friendList");
		 }else {
			 mv.addObject("friendList", mal);
			 mv.setViewName("chat/friendList");
		 }
		 
//		 if(chatroomList != null) {
//				mv.addObject("chatroomList",chatroomList);
//				mv.setViewName("chat/friendList");
//			}else {
//				mv.addObject("chatroomList",chatroomList);
//				mv.setViewName("chat/friendList");
//			}
//		 
//		 if(onetooneList != null) {
//			 mv.addObject("onetooneList", onetooneList);
//			 mv.setViewName("chat/friendList");
//		 }else {
//			 mv.addObject("onetooneList", onetooneList);
//			 mv.setViewName("chat/friendList");
//		 }
//		 
//		 if(readynCountList != null) {
//			 mv.addObject("readynCountList", readynCountList);
//			 mv.setViewName("chat/friendList");
//		 }else {
//			 mv.addObject("readynCountList", readynCountList);
//			 mv.setViewName("chat/friendList");
//		 }
//		 
//		 
		 return mv;
	 }
	 
	 @RequestMapping("otoList.do") 
	 public ModelAndView otoList(ModelAndView mv,HttpSession session) {
		 
		Member m =  (Member)session.getAttribute("loginUser");
		String id =  m.getId();
		
		
//		System.out.println("111" + id);
//		 ArrayList<Member> friendList = new ArrayList();
//		 friendList = cService.friendList(id);
//		 System.out.println("친구 목록 : " + friendList);
//		 ArrayList<Friends> friendList = new ArrayList();
//		 friendList = cService.friendList(id);
//		 ArrayList<String> al = new ArrayList<String>();//목록중 친구아이디을 다뽑아옴
//			for(int i=0;i<friendList.size();i++) {
//				if(friendList.get(i).getfId().equals(m.getId())) {//친구 아이디 컬럼에 로그인된 아이디랑 같으면 userid에 있는 것을 가져와라
//					al.add(friendList.get(i).getUserId());
//				}else if(friendList.get(i).getUserId().equals(m.getId())) {//userId 컬럼와 로그인된 아이디가 같으면 fid에있는것을 al에 넣어라
//					al.add(friendList.get(i).getfId());
//				}
//			}
//			ArrayList<Member> mal =new ArrayList<Member>();
//			for(int i =0;i<al.size();i++) {
//				mal.add(cService.friendsInfo(al.get(i)));
//			}
		 
//		 ArrayList<Chatroom> chatroomList = new ArrayList();
//		 chatroomList = cService.selectChatroomList();
//		 
		 ArrayList<OneToOne> onetooneList = new ArrayList();
		 onetooneList = cService.OneToOneList(id);
		 System.out.println("1대1 채팅방 목록 = " + onetooneList);
		 
		 ArrayList<OneToOneMsg> readynCountList = new ArrayList();
		 readynCountList = cService.ReadYNCountList();
		 System.out.println("안읽은 메시지 갯수 = " + readynCountList);
		 
		 for(int i = 0; i < onetooneList.size(); i++) {
			 for(int j = 0; j < readynCountList.size(); j++) {
				 if(onetooneList.get(i).getCo_no().equals(readynCountList.get(j).getCo_no())) {
					 if(!m.getId().equals(readynCountList.get(j).getChatId())) {
						 onetooneList.get(i).setCount(readynCountList.get(j).getCount());
					 }
				 }
			 }
		 }
		 
//		 if(mal != null) {
//			 mv.addObject("friendList", mal);
//			 mv.setViewName("chat/friendList");
//		 }else {
//			 mv.addObject("friendList", mal);
//			 mv.setViewName("chat/friendList");
//		 }
		 
//		 if(chatroomList != null) {
//				mv.addObject("chatroomList",chatroomList);
//				mv.setViewName("chat/friendList");
//			}else {
//				mv.addObject("chatroomList",chatroomList);
//				mv.setViewName("chat/friendList");
//			}
//		 
		 if(onetooneList != null) {
			 mv.addObject("onetooneList", onetooneList);
			 mv.setViewName("chat/oneToOneList");
		 }else {
			 mv.addObject("onetooneList", onetooneList);
			 mv.setViewName("chat/oneToOneList");
		 }
		 
		 if(readynCountList != null) {
			 mv.addObject("readynCountList", readynCountList);
			 mv.setViewName("chat/oneToOneList");
		 }else {
			 mv.addObject("readynCountList", readynCountList);
			 mv.setViewName("chat/oneToOneList");
		 }
//		 
//		 
		 return mv;
	 }
	 
	 @RequestMapping("openChatroomList.do") 
	 public ModelAndView openChatroomList(ModelAndView mv,HttpSession session) {
		 
		 Member m =  (Member)session.getAttribute("loginUser");
			String id =  m.getId();
			
			
			System.out.println("111" + id);
//			 ArrayList<Member> friendList = new ArrayList();
//			 friendList = cService.friendList(id);
//			 System.out.println("친구 목록 : " + friendList);
//			 ArrayList<Friends> friendList = new ArrayList();
//			 friendList = cService.friendList(id);
//			 ArrayList<String> al = new ArrayList<String>();//목록중 친구아이디을 다뽑아옴
//				for(int i=0;i<friendList.size();i++) {
//					if(friendList.get(i).getfId().equals(m.getId())) {//친구 아이디 컬럼에 로그인된 아이디랑 같으면 userid에 있는 것을 가져와라
//						al.add(friendList.get(i).getUserId());
//					}else if(friendList.get(i).getUserId().equals(m.getId())) {//userId 컬럼와 로그인된 아이디가 같으면 fid에있는것을 al에 넣어라
//						al.add(friendList.get(i).getfId());
//					}
//				}
//				ArrayList<Member> mal =new ArrayList<Member>();
//				for(int i =0;i<al.size();i++) {
//					mal.add(cService.friendsInfo(al.get(i)));
//				}
//				System.out.println("친구 정보" + mal);
			 
			 ArrayList<Chatroom> chatroomList = new ArrayList();
			 chatroomList = cService.selectChatroomList();
			 
//			 ArrayList<OneToOne> onetooneList = new ArrayList();
//			 onetooneList = cService.OneToOneList(id);
//			 System.out.println("1대1 채팅방 목록 = " + onetooneList);
//			 
//			 ArrayList<OneToOneMsg> readynCountList = new ArrayList();
//			 readynCountList = cService.ReadYNCountList();
//			 System.out.println("안읽은 메시지 갯수 = " + readynCountList);
//			 
//			 for(int i = 0; i < onetooneList.size(); i++) {
//				 for(int j = 0; j < readynCountList.size(); j++) {
//					 if(onetooneList.get(i).getCo_no().equals(readynCountList.get(j).getCo_no())) {
//						 if(!m.getId().equals(readynCountList.get(j).getChatId())) {
//							 onetooneList.get(i).setCount(readynCountList.get(j).getCount());
//						 }
//					 }
//				 }
//			 }
			 
//			 if(mal != null) {
//				 mv.addObject("friendList", mal);
//				 mv.setViewName("chat/openChatroomList");
//			 }else {
//				 mv.addObject("friendList", mal);
//				 mv.setViewName("chat/openChatroomList");
//			 }
			 
			 if(chatroomList != null) {
					mv.addObject("chatroomList",chatroomList);
					mv.setViewName("chat/openChatroomList");
				}else {
					mv.addObject("chatroomList",chatroomList);
					mv.setViewName("chat/openChatroomList");
				}
			 
//			 if(onetooneList != null) {
//				 mv.addObject("onetooneList", onetooneList);
//				 mv.setViewName("chat/openChatroomList");
//			 }else {
//				 mv.addObject("onetooneList", onetooneList);
//				 mv.setViewName("chat/openChatroomList");
//			 }
//			 
//			 if(readynCountList != null) {
//				 mv.addObject("readynCountList", readynCountList);
//				 mv.setViewName("chat/openChatroomList");
//			 }else {
//				 mv.addObject("readynCountList", readynCountList);
//				 mv.setViewName("chat/openChatroomList");
//			 }
			 
			 
			 return mv;
	 }
	 
	 @RequestMapping("searchOpenChatroom.do")
	 public ModelAndView searchOpenChatroom(ModelAndView mv,HttpSession session,
			 															@RequestParam(value="searchOpenChatroom",required=false)String searchOpenChatroom) {
		 
		 ArrayList<Chatroom> chatroomList = new ArrayList();
		 chatroomList = cService.searchChatroomListResult(searchOpenChatroom);
		 
		 if(chatroomList != null) {
				mv.addObject("chatroomList",chatroomList);
				mv.setViewName("chat/searchOpenChatroomList");
			}else {
				mv.addObject("chatroomList",chatroomList);
				mv.setViewName("chat/searchOpenChatroomList");
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
			
			String notice = cService.selectOpenChatNotice(chatroomnumber);
			
			ArrayList<ChatroomMsg> crmsg = new ArrayList();
			crmsg = cService.selectOpenMessageList(chatroomnumber);
			
			ArrayList<Chatroom> openChatroomBackground = new ArrayList();
			openChatroomBackground = cService.selectOpenChatroomBackground(chatroomnumber);
			
			mv.addObject("notice", notice).setViewName("chat/chatroomdetail");
			mv.addObject("cr", cr).setViewName("chat/chatroomdetail");
			mv.addObject("crmsg", crmsg).setViewName("chat/chatroomdetail");
			mv.addObject("openChatroomBackground", openChatroomBackground).setViewName("chat/chatroomdetail");
			
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
			 									@RequestParam(value="update_myprofile", required=false) MultipartFile file, String nickname) {
		 
		 System.out.println("사진 = " + m.getProfile());
		 
			 if(!m.getProfile().equals("noprofile.png")) {
				 deleteFile(m.getProfile(), request);
			 }
		 
		 
		 String profileFileName = saveFile(file, request);
		 
		 if(profileFileName != null) {
			 m.setProfile(profileFileName);
		 }
		 
		 int result = cService.updateProfile(m);
		 
		 Member m2 = (Member) session.getAttribute("loginUser");
		 
		 m2.setProfile(profileFileName);
		 m2.setNickname(nickname);
		 
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
			  System.out.println("인서트 시 배경화면정보 = " + loginUser.getId() + ", " + friendId);
			  
			  OneToOne oto = new OneToOne();
			  oto = cService.selectOneToOneRoom(map);
			  System.out.println("1대1방 검색 결과 : " + oto);
			  
			  OneToOne oto2 = new OneToOne();
			  oto2 = cService.selectOneToOneRoom2(map);
			  System.out.println("1대1방 검색 결과2 : " + oto2);
			  
			  
			  if(oto == null && oto2 == null) {
				  int result = cService.insertOneToOneRoom(map);
				  
				  oto=cService.selectOneToOneRoom(map);
				  oto2=cService.selectOneToOneRoom2(map);
				  if(result > 0) {
					  if(oto2 == null) {
						  session.setAttribute("co_no", oto.getCo_no());
						  session.setAttribute("friendId", oto.getFriendId());
						  mv.addObject("oto",oto).setViewName("chat/oneToOneDetail");
					  }else if(oto == null) {
						  session.setAttribute("co_no", oto2.getCo_no());
						  session.setAttribute("friendId", oto2.getFriendId());
						  mv.addObject("oto",oto2).setViewName("chat/oneToOneDetail");
					  }
				  }
				  
			  }else {
				  if(oto2 == null) {
					  ArrayList<OneToOneMsg> otomsg = new ArrayList();
					  otomsg=cService.selectMessageList(oto.getCo_no());
					  System.out.println("메시지목록 = " + otomsg);
					  
					  ArrayList<OneToOne> otoBackgroundInfo3 = new ArrayList();
					  otoBackgroundInfo3 = cService.selectOtoBackgroundInfo3(map);
					  
					  String notice = cService.selectChatNotice(oto.getCo_no());
					  System.out.println("insertonetooneChatroom.do 에서의 notice = " + notice);
					  
					  session.setAttribute("co_no", oto.getCo_no());
					  session.setAttribute("friendId", oto.getFriendId());
					  mv.addObject("notice", notice).setViewName("chat/oneToOneDetail");
					  mv.addObject("oto",oto).setViewName("chat/oneToOneDetail");
					  mv.addObject("otomsg", otomsg).setViewName("chat/oneToOneDetail");
					  mv.addObject("otoBackgroundInfo", otoBackgroundInfo3).setViewName("chat/oneToOneDetail");
				  }else if(oto == null) {
					  ArrayList<OneToOneMsg> otomsg2 = new ArrayList();
					  otomsg2=cService.selectMessageList2(oto2.getCo_no());
					  System.out.println("메시지목록 = " + otomsg2);
					  
					  ArrayList<OneToOne> otoBackgroundInfo4 = new ArrayList();
					  otoBackgroundInfo4 = cService.selectOtoBackgroundInfo4(map);
					  
					  String notice = cService.selectChatNotice(oto2.getCo_no());
					  System.out.println("insertonetooneChatroom.do 에서의 notice = " + notice);
					  
					  session.setAttribute("co_no", oto2.getCo_no());
					  session.setAttribute("friendId", oto2.getFriendId());
					  mv.addObject("notice", notice).setViewName("chat/oneToOneDetail");
					  mv.addObject("oto",oto2).setViewName("chat/oneToOneDetail");
					  mv.addObject("otomsg", otomsg2).setViewName("chat/oneToOneDetail");
					  mv.addObject("otoBackgroundInfo", otoBackgroundInfo4).setViewName("chat/oneToOneDetail");
				  }
			  }
			  
			  return mv;
		  }
		 
		  @RequestMapping("enterOneToOneChatroom.do")
		  public ModelAndView enterOneToOneChatroom(ModelAndView mv,HttpSession session,
					@RequestParam(value = "co_no", required = false) String co_no,
					@RequestParam(value = "friendId", required = false) String friendId) {
			 
			  Member loginUser = (Member)session.getAttribute("loginUser");
			  HashMap <String, String> map = new HashMap<>();
			  map.put("id", loginUser.getId());
			  map.put("co_no", co_no);
			  map.put("friendId", friendId);
			  
			  System.out.println("배경관련 확인 - " + loginUser.getId() + friendId);
			  
			  int result = cService.updateReadYN(map);
			  
			  OneToOne oto = new OneToOne();
			  
			  ArrayList<OneToOne> otoBackgroundInfo = new ArrayList();
			  ArrayList<OneToOne> otoBackgroundInfo2 = new ArrayList();
			  otoBackgroundInfo = cService.selectOtoBackgroundInfo(map);
			  otoBackgroundInfo2 = cService.selectOtoBackgroundInfo2(map);
			  System.out.println("배경정보 : " + otoBackgroundInfo);
			  System.out.println("배경정보 : " + otoBackgroundInfo2);
			  
			  ArrayList<OneToOneMsg>  otomsg = new ArrayList();
			  otomsg=cService.selectMessageList(co_no);
			  System.out.println("메시지목록 = " + otomsg);
			  
			  String notice = cService.selectChatNotice(co_no);
			  
			  oto.setCo_no(co_no);
			  oto.setFriendId(friendId);
				System.out.println("방번호  : " + oto.getCo_no());
				
				if(otoBackgroundInfo.size() != 0) {
						mv.addObject("otoBackgroundInfo", otoBackgroundInfo).setViewName("chat/oneToOneDetail");
				}else {
						mv.addObject("otoBackgroundInfo", otoBackgroundInfo2).setViewName("chat/oneToOneDetail");
				}
				mv.addObject("notice", notice).setViewName("chat/oneToOneDetail");
				mv.addObject("oto", oto).setViewName("chat/oneToOneDetail");
				mv.addObject("otomsg",otomsg).setViewName("chat/oneToOneDetail");
				
				
				loginUser.setChatroom_no(co_no);
				
				session.setAttribute("friendId", oto.getFriendId());
				session.setAttribute("co_no", loginUser.getChatroom_no());
				session.setAttribute("nickname", loginUser.getNickname());
				session.setAttribute("profile", loginUser.getProfile());
			 
			 return mv;
		  }
		  
		  @RequestMapping("updateNickname.do")
		  public ModelAndView updateNickname(HttpServletResponse response,HttpSession session,ModelAndView mv,
				  										@RequestParam(value="inputNickname", required=false) String nickname) {
			  System.out.println("넘어옴?" + nickname);
			  
			  int check = cService.checkNickname(nickname);
			  
			  System.out.println("check = " + check);
			  
			  if(check == 0) {
				  Member loginUser = (Member)session.getAttribute("loginUser");
				  String id = loginUser.getId();
				  
				  HashMap <String, String> map = new HashMap<>();
				  map.put("nickname", nickname);
				  map.put("id", id);
				  System.out.println("nickname, id = " +nickname + "," + id);
				  
				  int result = cService.updateNickname(map);
				  
				  if(result > 0) {
					  Member m2 = (Member) session.getAttribute("loginUser");
						 
						 m2.setNickname(nickname);
						 
						 session.setAttribute("loginUser", m2);
					  
					  mv.setViewName("redirect:friendList.do");
					  return mv;
				  }else {
					  response.setContentType("text/html; charset=UTF-8");
			            PrintWriter out;
						try {
							out = response.getWriter();
							out.println("<script>alert('닉네임 변경 실패'); history.go(-1);</script>");
							out.flush();
							out.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
						
				  }
			  }else{
				  response.setContentType("text/html; charset=UTF-8");
		            PrintWriter out;
					try {
						out = response.getWriter();
						out.println("<script>alert('이미 사용중인 닉네임입니다'); history.go(-1);</script>");
						out.flush();
						out.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
			  }
			  return mv;
		  }
		  
	  @RequestMapping("SaveSendImage.do")
		  public void SaveSendImage(HttpServletRequest request,HttpServletResponse response,  HttpSession session,
				@RequestParam(value="ChatroomSendImage", required=false) MultipartFile file) throws IOException {
		  
		  
		String sendImageName = saveFile2(file, request);
		
		PrintWriter out = response.getWriter();
		
		if(!sendImageName.equals("")) {
			out.print(sendImageName);
			out.flush();
			out.close();
		}else {
			out.append("실패");
			out.flush();
			out.close();
		}
	  }
		  
	  public String saveFile2(MultipartFile file, HttpServletRequest request) {
			//파일이 저장될 경로를 설정하는 메소드
			
			String root = request.getSession().getServletContext().getRealPath("resources");
			
			String savePath = root + "//ChatroomSendImage";
			
			double dValue = Math.random();
			char cValue = (char)((dValue * 26) + 97);
			
			double dValue2 = Math.random();
			char cValue2 = (char)((dValue2 * 26) + 97);
			
			double dValue3 = Math.random();
			int iValue = (int)(dValue3 * 1000);
			
			File folder = new File(savePath);
			//java.io.File로 import 하자
			
			if(!folder.exists()) {
				folder.mkdirs();
			}
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			String originFileName = file.getOriginalFilename();
			String sendImageName = "OneToOne" + cValue + iValue + cValue2 + sdf.format(new java.sql.Date(System.currentTimeMillis()))+
					"." + originFileName.substring(originFileName.lastIndexOf(".") + 1);
			
			String filePath = folder + "\\" + sendImageName;
			
			try {
				file.transferTo(new File(filePath));		//이 때 파일이 저장된다.
				//이 상태로는 파일 업로드가 되지 않는다.
				//왜냐하면 파일 제한크기에 대한 설정이 없기 때문이다.
				//그래서 파일 크기 지정을 root-context.xml에서 해준다.
			} catch (Exception e) {
				System.out.println("파일 전송 에러" + e.getMessage());
			}	
			
			
			return sendImageName;
		}
		  
		  
	  @RequestMapping("SaveSendImage_OpenChat.do")
	  public void SaveSendImage_OpenChat(HttpServletRequest request,HttpServletResponse response,  HttpSession session,
			@RequestParam(value="ChatroomSendImage", required=false) MultipartFile file) throws IOException {
	  
	String sendImageName = saveFile3(file, request);
	
	PrintWriter out = response.getWriter();
	
	if(!sendImageName.equals("")) {
		out.print(sendImageName);
		out.flush();
		out.close();
	}else {
		out.append("실패");
		out.flush();
		out.close();
	}
  }
	  public String saveFile3(MultipartFile file, HttpServletRequest request) {
			//파일이 저장될 경로를 설정하는 메소드
			
			String root = request.getSession().getServletContext().getRealPath("resources");
			
			String savePath = root + "//OpenChatroomSendImage";
			
			double dValue = Math.random();
			char cValue = (char)((dValue * 26) + 97);
			
			double dValue2 = Math.random();
			char cValue2 = (char)((dValue2 * 26) + 97);
			
			double dValue3 = Math.random();
			int iValue = (int)(dValue3 * 1000);
			
			File folder = new File(savePath);
			//java.io.File로 import 하자
			
			if(!folder.exists()) {
				folder.mkdirs();
			}
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			String originFileName = file.getOriginalFilename();
			String sendImageName = "Open" + cValue + iValue + cValue2 +  sdf.format(new java.sql.Date(System.currentTimeMillis()))+
					"." + originFileName.substring(originFileName.lastIndexOf(".") + 1);
			
			String filePath = folder + "\\" + sendImageName;
			
			try {
				file.transferTo(new File(filePath));		//이 때 파일이 저장된다.
				//이 상태로는 파일 업로드가 되지 않는다.
				//왜냐하면 파일 제한크기에 대한 설정이 없기 때문이다.
				//그래서 파일 크기 지정을 root-context.xml에서 해준다.
			} catch (Exception e) {
				System.out.println("파일 전송 에러" + e.getMessage());
			}	
			
			
			return sendImageName;
		}
	  
	  @RequestMapping(value = "updateChatNotice.do",produces ="application/text; charset=utf8")
	  public void updateChatNotice(HttpServletRequest request,HttpServletResponse response,  HttpSession session,
				@RequestParam(value="notice", required=false) String notice, String co_no) throws IOException {
		  
		  System.out.println("공지방번호 = " + co_no);
		  System.out.println("공지내용 = " + notice);
		  
		  HashMap <String, String> map = new HashMap<>();
		  map.put("co_no", co_no);
		  map.put("notice", notice);
		  
		  int updateNotice = cService.updateChatNotice(map);
		  
		  PrintWriter out = response.getWriter();
		  
		  if(updateNotice > 0) {
			  	String currentNotice = cService.selectChatNotice(co_no);
			  	URLEncoder.encode(currentNotice , "UTF-8");
			  	out.print(currentNotice);
				out.flush();
				out.close();
		  }else {
			  out.print("공지 등록 실패");
				out.flush();
				out.close();
		  }
		  
	  }
	  
	  
	  @RequestMapping("enrollBackground.do")
	  public void enrollBackground(HttpServletRequest request,HttpServletResponse response,  HttpSession session,
				@RequestParam(value="enrollBackground", required=false) MultipartFile file,
				@RequestParam(value="co_no", required=false)String co_no,
				@RequestParam(value="friendid",required=false)String friendid) throws IOException {
		  
		  System.out.println("값이 잘 넘어오나?" +co_no + "," + friendid );
		  
		  String sendImageName = saveBackgroundFile(file, request);
		  
		  Member loginUser = (Member)session.getAttribute("loginUser");
		  String myId = loginUser.getId();
		  System.out.println("내아이디?" + myId);
		  
		  HashMap <String, String> map = new HashMap<>();
		  map.put("co_no", co_no);
		  map.put("myId", myId);
		  map.put("image", sendImageName);
		

			int result = cService.updateMyBackgroundImage(map);
			int result2 = cService.updateFrBackgroundImage(map);
			
			PrintWriter out = response.getWriter();
			
			if(!sendImageName.equals("")) {
				out.print(sendImageName);
				out.flush();
				out.close();
			}else {
				out.append("실패");
				out.flush();
				out.close();
			}
		  
	  }

	private String saveBackgroundFile(MultipartFile file, HttpServletRequest request) {
		
		String root = request.getSession().getServletContext().getRealPath("resources");
		
		String savePath = root + "//chatroomBackground";
		
		double dValue = Math.random();
		char cValue = (char)((dValue * 26) + 97);
		
		double dValue2 = Math.random();
		char cValue2 = (char)((dValue2 * 26) + 97);
		
		double dValue3 = Math.random();
		int iValue = (int)(dValue3 * 1000);
		
		File folder = new File(savePath);
		//java.io.File로 import 하자
		
		if(!folder.exists()) {
			folder.mkdirs();
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String originFileName = file.getOriginalFilename();
		String sendImageName = "background" + cValue + iValue + cValue2 +  sdf.format(new java.sql.Date(System.currentTimeMillis()))+
				"." + originFileName.substring(originFileName.lastIndexOf(".") + 1);
		
		String filePath = folder + "\\" + sendImageName;
		
		try {
			file.transferTo(new File(filePath));		//이 때 파일이 저장된다.
			//이 상태로는 파일 업로드가 되지 않는다.
			//왜냐하면 파일 제한크기에 대한 설정이 없기 때문이다.
			//그래서 파일 크기 지정을 root-context.xml에서 해준다.
		} catch (Exception e) {
			System.out.println("파일 전송 에러" + e.getMessage());
		}	
		
		
		return sendImageName;
	}
	  
	
	@RequestMapping("selectBaseBackground.do")
	public void selectBaseBackground(HttpServletRequest request,HttpServletResponse response,  HttpSession session,
			@RequestParam(value="backgroundname", required=false) String backgroundname,
			@RequestParam(value="co_no", required=false)String co_no,
			@RequestParam(value="friendid",required=false)String friendid) {
		
		System.out.println("값 넘어와? " + backgroundname + co_no + friendid);
		
		Member loginUser = (Member)session.getAttribute("loginUser");
		  String myId = loginUser.getId();
		
		HashMap <String, String> map = new HashMap<>();
		  map.put("co_no", co_no);
		  map.put("myId", myId);
		  map.put("image", backgroundname);
		

		  int result = cService.updateMyBackgroundImage(map);
		  int result2 = cService.updateFrBackgroundImage(map);
		  
	}
	
	
	@RequestMapping("updateOpenChatNotice.do")
	 public void updateOpenChatNotice(HttpServletRequest request,HttpServletResponse response,  HttpSession session,
				@RequestParam(value="notice", required=false) String notice, String co_no) throws IOException {
		  
		  System.out.println("오픈공지방번호 = " + co_no);
		  System.out.println("오픈공지내용 = " + notice);
		  
		  HashMap <String, String> map = new HashMap<>();
		  map.put("co_no", co_no);
		  map.put("notice", notice);
		  
		  int updateNotice = cService.updateOpenChatNotice(map);
		  
		  PrintWriter out = response.getWriter();
		  
		  if(updateNotice > 0) {
			  	String currentNotice = cService.selectOpenChatNotice(co_no);
			  	URLEncoder.encode(currentNotice , "UTF-8");
			  	out.print(currentNotice);
				out.flush();
				out.close();
		  }else {
			  out.print("공지 등록 실패");
				out.flush();
				out.close();
		  }
		  
	  }
	
	@RequestMapping("enrollOpenBackground.do")
	public void enrollOpenBackground(HttpServletRequest request,HttpServletResponse response,  HttpSession session,
			@RequestParam(value="enrollBackground", required=false) MultipartFile file,
			@RequestParam(value="cr_no", required=false)String cr_no) throws IOException {
	  
	  System.out.println("값이 잘 넘어오나?" +cr_no);
	  
	  String sendImageName = saveOpenBackgroundFile(file, request);
	  
	  HashMap <String, String> map = new HashMap<>();
	  map.put("cr_no", cr_no);
	  map.put("image", sendImageName);
	

		int result = cService.updateOpenBackgroundImage(map);
		
		PrintWriter out = response.getWriter();
		
		if(!sendImageName.equals("")) {
			out.print(sendImageName);
			out.flush();
			out.close();
		}else {
			out.append("실패");
			out.flush();
			out.close();
		}
	  
  }
	
private String saveOpenBackgroundFile(MultipartFile file, HttpServletRequest request) {
		
		String root = request.getSession().getServletContext().getRealPath("resources");
		
		String savePath = root + "//openChatroomBackground";
		
		double dValue = Math.random();
		char cValue = (char)((dValue * 26) + 97);
		
		double dValue2 = Math.random();
		char cValue2 = (char)((dValue2 * 26) + 97);
		
		double dValue3 = Math.random();
		int iValue = (int)(dValue3 * 1000);
		
		File folder = new File(savePath);
		//java.io.File로 import 하자
		
		if(!folder.exists()) {
			folder.mkdirs();
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String originFileName = file.getOriginalFilename();
		String sendImageName = "openbackground" + cValue + iValue + cValue2 +  sdf.format(new java.sql.Date(System.currentTimeMillis()))+
				"." + originFileName.substring(originFileName.lastIndexOf(".") + 1);
		
		String filePath = folder + "\\" + sendImageName;
		
		try {
			file.transferTo(new File(filePath));		//이 때 파일이 저장된다.
			//이 상태로는 파일 업로드가 되지 않는다.
			//왜냐하면 파일 제한크기에 대한 설정이 없기 때문이다.
			//그래서 파일 크기 지정을 root-context.xml에서 해준다.
		} catch (Exception e) {
			System.out.println("파일 전송 에러" + e.getMessage());
		}	
		
		
		return sendImageName;
	}
	

	@RequestMapping("selectOpenBaseBackground.do")
	public void selectOpenBaseBackground(HttpServletRequest request,HttpServletResponse response,  HttpSession session,
			@RequestParam(value="backgroundname", required=false) String backgroundname,
			@RequestParam(value="cr_no", required=false)String cr_no) {
		
		System.out.println("값 넘어와? " + backgroundname + cr_no);
		
		HashMap <String, String> map = new HashMap<>();
		  map.put("cr_no", cr_no);
		  map.put("image", backgroundname);
		

		  int result = cService.updateOpenBackgroundImage(map);
		  
	}
	
//	@RequestMapping("friendSearch.do")
//	public void friendSearch(HttpServletRequest request,HttpServletResponse response,  HttpSession session,
//															@RequestParam(value="words", required=false) String words) {
//		
//		System.out.println("친구검색 검색어 = " + words);
//		
//		Member m =  (Member)session.getAttribute("loginUser");
//		String id =  m.getId();
//		
//		ArrayList<Friends> friendList = new ArrayList();
//		 friendList = cService.friendList(id);
//		 ArrayList<String> al = new ArrayList<String>();//목록중 친구아이디을 다뽑아옴
//			for(int i=0;i<friendList.size();i++) {
//				if(friendList.get(i).getfId().equals(m.getId())) {//친구 아이디 컬럼에 로그인된 아이디랑 같으면 userid에 있는 것을 가져와라
//					al.add(friendList.get(i).getUserId());
//				}else if(friendList.get(i).getUserId().equals(m.getId())) {//userId 컬럼와 로그인된 아이디가 같으면 fid에있는것을 al에 넣어라
//					al.add(friendList.get(i).getfId());
//				}
//			}
//			ArrayList<Member> mal =new ArrayList<Member>();
//			for(int i =0;i<al.size();i++) {
//				mal.add(cService.friendsInfo(al.get(i)));
//			}
//			System.out.println("친구 정보" + mal);
//			
//			ArrayList<Member> list = new ArrayList<Member>();
//			
//			for(int i = 0; i < mal.size(); i++) {
//				if(mal.get(i).getNickname().contains(words)) {
//					list.add(mal.get(i));
//				}
//			}
//			System.out.println("뽑음...." + list);
//			Gson gson = new Gson();
//			String jsonPlace = gson.toJson(list);
//			
//			response.setContentType("text/html; charset=UTF-8");
//            PrintWriter out;
//			try {
//				out = response.getWriter();
//				out.println(jsonPlace);
//				out.flush();
//				out.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		
//	}
	
}










package com.kh.FinalProject;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.websocket.OnOpen;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kh.FinalProject.chat.model.service.ChatService;
import com.kh.FinalProject.member.model.vo.Member;

@Component
@Controller
public class EchoRoomHandler extends TextWebSocketHandler{
	
	@Autowired ChatService cService;
	
	// (<"bang_id", 방ID>, <"session", 세션>) - (<"bang_id", 방ID>, <"session", 세션>) - (<"bang_id", 방ID>, <"session", 세션>) 형태 
		private List<Map<String, Object>> sessionList = new ArrayList<Map<String, Object>>();
		
		private static Logger logger = LoggerFactory.getLogger(EchoHandler.class);
		
		
		//클라이언트와 연결 된 후
		@Override
		public void afterConnectionEstablished(WebSocketSession session) throws IOException {
		//List 를 사용했으니..
			Map<String,Object> sessionmap = session.getAttributes();
			String chatRoomnumber = (String)sessionmap.get("chatRoomnumber");
			
			  Map<String, Object> map = new HashMap<String, Object>();
			  map.put("chatroom_no",chatRoomnumber);
			  map.put("session", session);
			  
			
			  sessionList.add(map);
			  
			  System.out.println("방번호 : " +chatRoomnumber);
			
			
			  logger.info("{} 연결됨", session.getId()); 
			
			  
//			  Map<String,Object> map2 = session.getAttributes();
//		         String nickname = (String)map2.get("nickname");
//		         System.out.println("로그인 한 닉네임 : " + nickname);
//		         
//		         session.sendMessage(new TextMessage (nickname));
			
		}
	
		
		//웹 소켓 서버로 데이터를 전송했을 경우
		 @Override
		 protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
			  
			   logger.info("{}로 부터 {} 받음!!", session.getId(), message.getPayload());
			 
			   //JSON --> MAP으로 변환
			   ObjectMapper objectMapper = new ObjectMapper();
			   Map<String, String> mapReceive = objectMapper.readValue(message.getPayload(), Map.class);

			
			   
			   Map<String, Object> map = new HashMap<String, Object>();
			   map.put("chatroom_no", mapReceive.get("chatroom_no"));
			   map.put("session", session);
			   System.out.println(" 닉네임 확인 : " + session.getAttributes().get("nickname"));
			   
		
			   
			   for(int i=0; i<sessionList.size(); i++) {
					Map<String, Object> mapSessionList = sessionList.get(i);
					
					//sessionList에 담긴 Map에 값 가져옴 
					String chatroom_no = (String)mapSessionList.get("chatroom_no");
					WebSocketSession sess = (WebSocketSession)mapSessionList.get("session");
					
					

					//만약 Map값을 불러왔는데 방번호가 같다면?
					if(chatroom_no.equals(mapReceive.get("chatroom_no"))) {
						
						Map<String,Object> userNicknamemap = session.getAttributes();
		                  Member m = (Member)userNicknamemap.get("loginUser");
						
		                  String nickname = m.getNickname();
		                  String id = m.getId();
		                  String profile = m.getProfile();
		                  
		                  HashMap<String,Object> dbmap = new HashMap<String,Object>();
		                  
		                  if(mapReceive.containsKey("image")) {
		                	  dbmap.put("chatroom_no", chatroom_no);
			                  dbmap.put("id", id);
		                      dbmap.put("message",String.valueOf(mapReceive.get("msg")));
		                	  dbmap.put("image", mapReceive.get("image"));
		                	  
		                	  if(session.getId() == sess.getId()) {
			                	  int result = cService.insertOpenchatSendImage(dbmap);
			                	  
			                	  if(result > 0) {
			                		  String jsonStr = chatroom_no + "|" + profile +"|" +nickname+ "|" + mapReceive.get("msg") + "|" + mapReceive.get("image");
			                		  System.out.println("디비저장 성공 : " + jsonStr);
			                	  }else {
			                		  System.out.println("디비 저장 실패");
			                	  }
			                	}
		                	  String jsonStr = chatroom_no + "|" + profile +"|" +nickname+ "|" + mapReceive.get("msg") + "|" + mapReceive.get("image");
				               sess.sendMessage(new TextMessage(jsonStr));
		                  }else {
			                	  if(session.getId() == sess.getId()) {
				                  dbmap.put("chatroom_no", chatroom_no);
				                  dbmap.put("id", id);
				                  dbmap.put("message", mapReceive.get("msg"));
				                  
				                  int result = cService.insertOpenchatMsg(dbmap);
				                  
				                  if(result > 0) {
				                	  	String jsonStr2 = chatroom_no + "|" + profile + "|" +nickname + "|" + mapReceive.get("msg");
										System.out.println("디비저장 성공 : " + jsonStr2);
				                  }else {
				                	  System.out.println("디비저장실패");
				                  }
				               }
			                String jsonStr2 = chatroom_no + "|" + profile + "|" +nickname + "|" + mapReceive.get("msg");
				            sess.sendMessage(new TextMessage(jsonStr2));
		                  }
						
					}
			   }
			   
		   }
		






		@Override
		public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws IOException {
			//여기서 Db를 등록하면 되지않을까?
			//List 삭제
			ObjectMapper objectMapper = new ObjectMapper();
			String now_bang_id = "";
			logger.info("{} 연결 끊김",session.getId());
		
			for (int i = 0; i < sessionList.size(); i++) {
				Map<String, Object> map = sessionList.get(i);
				String chatroom_no = (String)map.get("chatroom_no");
				WebSocketSession sess = (WebSocketSession)map.get("session");
				
				if(session.equals(sess)) {
					chatroom_no = chatroom_no;
					sessionList.remove(map);
					break;
				}	
				Map<String,Object> userNicknamemap = session.getAttributes();
				
                String nickname = (String)userNicknamemap.get("nickname");

				
				String jsonStr2 = chatroom_no + "|" + nickname + "|" + "믜댜퇴장듀틔";
				sess.sendMessage(new TextMessage(jsonStr2));
		}
}
		
		
		
		
		
	      @RequestMapping("enteruserlist.do")
	      public void userlist(HttpServletResponse response ,String roomnumber) throws IOException {
	         response.setContentType("application/json;charset=utf-8");
	            ArrayList list = new ArrayList();
	            System.out.println("roomnumber" + roomnumber);
	           for(int i=0; i<sessionList.size(); i++) {
	              Map<String, Object> mapSessionList = sessionList.get(i);
	               
	               //sessionList에 담긴 Map에 값 가져옴 
	               String chatroom_no = (String)mapSessionList.get("chatroom_no");
	               WebSocketSession sess = (WebSocketSession)mapSessionList.get("session");
	                 
	               if(chatroom_no.equals(roomnumber)) {
	                  String str = (String)sess.getAttributes().get("nickname");
	                  list.add(str);
	                  
	               }
	           }
	           JSONArray jarr = new JSONArray();
	           
	           for(Object str : list) {
	              JSONObject jUser = new JSONObject();
	              jUser.put("nickname", str);
	              
	              jarr.add(jUser);
	              
	           }
	           JSONObject sendJson = new JSONObject();
	           
	           sendJson.put("list",jarr);
	           
	           PrintWriter out = response.getWriter();
	           
	           out.print(sendJson);
	           out.flush();
	           out.close();
	           
	      }

		
		
		
}





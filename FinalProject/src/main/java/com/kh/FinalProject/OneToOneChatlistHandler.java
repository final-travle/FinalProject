package com.kh.FinalProject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kh.FinalProject.chat.model.service.ChatService;
import com.kh.FinalProject.chat.model.vo.OneToOne;
import com.kh.FinalProject.member.model.vo.Member;

@Component
public class OneToOneChatlistHandler extends TextWebSocketHandler {
   
   
     @Autowired ChatService cService;
    
     private List<Map<String,Object>> sessionList = new ArrayList<Map<String, Object>>();
      
      private List<OneToOne> myco_noList = new ArrayList<OneToOne>();
      private static Logger logger = LoggerFactory.getLogger(OneToOneChatlistHandler.class);

      
      //클라이언트와 연결 된 후
      @Override
      public void afterConnectionEstablished(WebSocketSession session) {
      //채팅방 번호와 보낸이 아이디
    	  System.out.println("리스트핸들러 연결");
         Map<String,Object> sessionmap = session.getAttributes();
         
         Member m = (Member)sessionmap.get("loginUser");
         String  loginUserid =m.getId();
         System.out.println("id : " + loginUserid);
         
         //자신의 채팅반번호를 가진 리스트 가져오기
         myco_noList = cService.selectMyChatRoomNo(loginUserid);
         
         System.out.println("myco_noList : " + myco_noList);
           
           System.out.println("session 접속 : " + session.getId());
           
           Map<String, Object> map = new HashMap<String, Object>();
           map.put("loginUser",loginUserid);
           map.put("session", session);
           
           sessionList.add(map);
            logger.info("{} 연결됨", session.getId()); 
            System.out.println("sessionList : " + sessionList);
         //연결 완료.
      }
      
      //웹 소켓 서버로 데이터를 전송했을 경우
       @Override
       protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
          logger.info("{}로 부터 {} 받음", session.getId(), message.getPayload());
           System.out.println("list handler입니다.");
            //JSON --> MAP으로 변환
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, String> mapReceive = objectMapper.readValue(message.getPayload(), Map.class);
            
            Map<String,Object> sessionmap = session.getAttributes();
            
            Member m = (Member)sessionmap.get("loginUser");
            String  loginUserid =m.getId();
            System.out.println("id : " + loginUserid);
            
            
            
            //이거 왜넣었을까?
            HashMap<String, Object> dbmap = new HashMap<String, Object>();
            dbmap.put("co_no", mapReceive.get("co_no"));
            dbmap.put("loginUserid", loginUserid);
            
           
            System.out.println("방번호오ㅗㅇ : " + mapReceive.get("co_no"));
            System.out.println("친구 아이디이ㅣㅣㅇ : " + mapReceive.get("friendid"));
            //메세지 뿌려주기
            System.out.println("sessionList 확인..123.:" + sessionList);
            
            int dbcount = cService.ReadYnCount(dbmap);
                        System.out.println("안읽은 메시지 갯수 ==== " + dbcount);
                        int count = dbcount + 1;
         
                     for(int i=0;i<sessionList.size();i++) {
                        Map<String, Object> mapSessionList = sessionList.get(i);
                        
                        String loginUser = String.valueOf(mapSessionList.get("loginUser"));
                        String friendid = mapReceive.get("friendid");
                        System.out.println("loginUser : " + loginUser);
                        System.out.println("friendid : " +friendid);
                        
                           WebSocketSession sess = (WebSocketSession)mapSessionList.get("session");
                           
                           String jsonstr = mapReceive.get("co_no") + "|" + mapReceive.get("friendid") +"|" + mapReceive.get("msg") + "|" + count;
                           System.out.println("보내기전 확인 : " +jsonstr);
                           sess.sendMessage(new TextMessage(jsonstr));

                     }
                     
                  }
            
         
      
      @Override
      public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
         //여기서 Db를 등록하면 되지않을까?
         //List 삭제
            
         logger.info("{} 연결 끊김",session.getId());
          
          for (int i = 0; i < sessionList.size(); i++) {
               Map<String, Object> map = sessionList.get(i);
               String loginUser = String.valueOf(map.get("loginUser"));
               WebSocketSession sess = (WebSocketSession)map.get("session");
               
               if(session.equals(sess)) {
                  
                  for(int j=0;j<myco_noList.size();j++) {
                      OneToOne oto = myco_noList.get(j);
                      if(loginUser == oto.getMyId()) {
                         myco_noList.remove(oto);
                      }
                  }
                  
                  sessionList.remove(map);
               
               }
               
      }
             System.out.println("sessionList : " + sessionList);
      }
      
      
}
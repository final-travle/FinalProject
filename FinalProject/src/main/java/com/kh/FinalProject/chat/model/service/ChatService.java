package com.kh.FinalProject.chat.model.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.kh.FinalProject.chat.model.vo.Chatroom;
import com.kh.FinalProject.chat.model.vo.ChatroomMsg;
import com.kh.FinalProject.chat.model.vo.OneToOne;
import com.kh.FinalProject.chat.model.vo.OneToOneMsg;
import com.kh.FinalProject.member.model.vo.Friends;
import com.kh.FinalProject.member.model.vo.Member;

public interface ChatService {

	ArrayList<Friends> friendList(String id);

	ArrayList<Chatroom> selectChatroomList();

	Member friendsInfo(String string);

	int makeOpenChatroom(Chatroom cr);

	Chatroom selectOpenChatroom(String chatroomname);

	int updateProfile(Member m);

	OneToOne selectOneToOneRoom(HashMap<String, String> map);

	int insertOneToOneRoom(HashMap<String, String> map);

	int insertOneToOnemsg(HashMap<String, Object> dbmap);

	ArrayList<OneToOne> OneToOneList(String id);

	OneToOne selectOneToOneRoom2(HashMap<String, String> map);

	ArrayList<OneToOneMsg> selectMessageList(String co_no);

	ArrayList<OneToOneMsg> selectMessageList2(String co_no);

	int checkNickname(String nickname);

	int updateNickname(HashMap<String, String> map);

	int insertOpenchatMsg(HashMap<String, Object> dbmap);

	ArrayList<ChatroomMsg> selectOpenMessageList(String chatroomnumber);

	int insertOneToOnemsg2(HashMap<String, Object> dbmap);

	int updateReadYN(HashMap<String, String> map);

}

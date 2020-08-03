package com.kh.FinalProject.chat.model.service;

import java.util.ArrayList;

import com.kh.FinalProject.chat.model.vo.Chatroom;
import com.kh.FinalProject.member.model.vo.Friends;
import com.kh.FinalProject.member.model.vo.Member;

public interface ChatService {

	ArrayList<Friends> friendList(String id);

	ArrayList<Chatroom> selectChatroomList();

	Member friendsInfo(String string);

	int makeOpenChatroom(Chatroom cr);

	Chatroom selectOpenChatroom(String chatroomname);

}

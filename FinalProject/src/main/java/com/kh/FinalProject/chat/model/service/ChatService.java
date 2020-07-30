package com.kh.FinalProject.chat.model.service;

import java.util.ArrayList;

import com.kh.FinalProject.chat.model.vo.Chatroom;
import com.kh.FinalProject.member.model.vo.Member;

public interface ChatService {

	ArrayList<Member> friendList(String id);

	ArrayList<Chatroom> selectChatroomList();

}

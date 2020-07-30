package com.kh.FinalProject.chat.model.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.FinalProject.chat.model.dao.ChatDao;
import com.kh.FinalProject.chat.model.vo.Chatroom;
import com.kh.FinalProject.member.model.dao.MemberDao;
import com.kh.FinalProject.member.model.vo.Member;

@Service("cService")
public class ChatServiceImpl implements ChatService{

	
	@Autowired
	ChatDao cDao;

	@Override
	public ArrayList<Member> friendList(String id) {
		// TODO Auto-generated method stub
		return cDao.friendList(id);
	}

	@Override
	public ArrayList<Chatroom> selectChatroomList() {
		// TODO Auto-generated method stub
		return cDao.selectChatroomList();
	}

	
}

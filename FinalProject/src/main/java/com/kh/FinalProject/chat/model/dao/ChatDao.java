package com.kh.FinalProject.chat.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.FinalProject.chat.model.vo.Chatroom;
import com.kh.FinalProject.member.model.vo.Member;

@Repository("cDao")
public class ChatDao {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public ArrayList<Member> friendList(String id) {
		// TODO Auto-generated method stub
		return (ArrayList)sqlSessionTemplate.selectList("chatmapper.friendList", id);
	}

	public ArrayList<Chatroom> selectChatroomList() {
		// TODO Auto-generated method stub
		return (ArrayList)sqlSessionTemplate.selectList("chatmapper.chatroomList");
	}

}

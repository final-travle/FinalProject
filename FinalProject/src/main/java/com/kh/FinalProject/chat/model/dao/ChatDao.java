package com.kh.FinalProject.chat.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.FinalProject.chat.model.vo.Chatroom;
import com.kh.FinalProject.chat.model.vo.ChatroomMsg;
import com.kh.FinalProject.chat.model.vo.OneToOne;
import com.kh.FinalProject.chat.model.vo.OneToOneMsg;
import com.kh.FinalProject.member.model.vo.Friends;
import com.kh.FinalProject.member.model.vo.Member;

@Repository("cDao")
public class ChatDao {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public ArrayList<Friends> friendList(String id) {
		// TODO Auto-generated method stub
		return (ArrayList)sqlSessionTemplate.selectList("chatmapper.friendList", id);
	}

	public ArrayList<Chatroom> selectChatroomList() {
		// TODO Auto-generated method stub
		return (ArrayList)sqlSessionTemplate.selectList("chatmapper.chatroomList");
	}

	public Member friendsInfo(String string) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("chatmapper.friendsInfo", string);
	}

	public int makeOpenChatroom(Chatroom cr) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.insert("chatmapper.makeOpenChatroom", cr);
	}

	public Chatroom selectOpenChatroom(String chatroomname) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("chatmapper.selectOpenChatroom", chatroomname);
	}

	public int updateProfile(Member m) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.update("chatmapper.updateProfile",m);
	}

	public OneToOne selectOneToOneRoom(HashMap<String, String> map) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("chatmapper.selectOneToOneRoom",map);
	}

	public int insertOneToOneRoom(HashMap<String, String> map) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.insert("chatmapper.insertOneToOneRoom", map);
	}

	public int insertOneToOnemsg(HashMap<String, Object> dbmap) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.insert("chatmapper.insertOneToOnemsg",dbmap);
	}

	public ArrayList<OneToOne> OneToOneList(String id) {
		// TODO Auto-generated method stub
		return (ArrayList)sqlSessionTemplate.selectList("chatmapper.OneToOneList", id);
	}

	public OneToOne selectOneToOneRoom2(HashMap<String, String> map) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("chatmapper.selectOneToOneRoom2",map);
	}

	public ArrayList<OneToOneMsg> selectMessageList(String co_no) {
		// TODO Auto-generated method stub
		return (ArrayList) sqlSessionTemplate.selectList("chatmapper.selectMessageList",co_no);
	}

	public ArrayList<OneToOneMsg> selectMessageList2(String co_no) {
		// TODO Auto-generated method stub
		return (ArrayList) sqlSessionTemplate.selectList("chatmapper.selectMessageList2",co_no);
	}

	public int checkNickname(String nickname) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("chatmapper.checkNickname",nickname);
	}

	public int updateNickname(HashMap<String, String> map) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.update("chatmapper.updateNickname",map);
	}

	public int insertOpenchatMsg(HashMap<String, Object> dbmap) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.insert("chatmapper.insertOpenchatMsg",dbmap);
	}

	public ArrayList<ChatroomMsg> selectOpenMessageList(String cr_no) {
		// TODO Auto-generated method stub
		return (ArrayList)sqlSessionTemplate.selectList("chatmapper.selectOpenMessageList", cr_no);
	}

	public int insertOneToOnemsg2(HashMap<String, Object> dbmap) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.insert("chatmapper.insertOneToOnemsg2",dbmap);
	}

	public int updateReadYN(HashMap<String, String> map) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.update("chatmapper.updateReadYN",map);
	}

	public List<OneToOne> selectMyChatRoomNo(String loginUserid) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("chatmapper.selectMyChatRoomNo",loginUserid);
	}

	public ArrayList<OneToOneMsg> ReadYNCountList() {
		// TODO Auto-generated method stub
		return (ArrayList)sqlSessionTemplate.selectList("chatmapper.ReadYNCount");
	}

}

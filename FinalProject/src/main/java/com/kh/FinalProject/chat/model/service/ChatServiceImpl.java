package com.kh.FinalProject.chat.model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.FinalProject.chat.model.dao.ChatDao;
import com.kh.FinalProject.chat.model.vo.Chatroom;
import com.kh.FinalProject.chat.model.vo.ChatroomMsg;
import com.kh.FinalProject.chat.model.vo.OneToOne;
import com.kh.FinalProject.chat.model.vo.OneToOneMsg;
import com.kh.FinalProject.member.model.dao.MemberDao;
import com.kh.FinalProject.member.model.vo.Friends;
import com.kh.FinalProject.member.model.vo.Member;

@Service("cService")
public class ChatServiceImpl implements ChatService{

	
	@Autowired
	ChatDao cDao;

	@Override
	public ArrayList<Friends> friendList(String id) {
		// TODO Auto-generated method stub
		return cDao.friendList(id);
	}

	@Override
	public ArrayList<Chatroom> selectChatroomList() {
		// TODO Auto-generated method stub
		return cDao.selectChatroomList();
	}

	@Override
	public Member friendsInfo(String string) {
		// TODO Auto-generated method stub
		return cDao.friendsInfo(string);
	}

	@Override
	public int makeOpenChatroom(Chatroom cr) {
		// TODO Auto-generated method stub
		return cDao.makeOpenChatroom(cr);
	}

	@Override
	public Chatroom selectOpenChatroom(String chatroomname) {
		// TODO Auto-generated method stub
		return cDao.selectOpenChatroom(chatroomname);
	}

	@Override
	public int updateProfile(Member m) {
		// TODO Auto-generated method stub
		return cDao.updateProfile(m);
	}

	@Override
	public OneToOne selectOneToOneRoom(HashMap<String, String> map) {
		// TODO Auto-generated method stub
		return cDao.selectOneToOneRoom(map);
	}

	@Override
	public int insertOneToOneRoom(HashMap<String, String> map) {
		// TODO Auto-generated method stub
		return cDao.insertOneToOneRoom(map);
	}

	@Override
	public int insertOneToOnemsg(HashMap<String, Object> dbmap) {
		// TODO Auto-generated method stub
		return cDao.insertOneToOnemsg(dbmap);
	}

	@Override
	public ArrayList<OneToOne> OneToOneList(String id) {
		// TODO Auto-generated method stub
		return cDao.OneToOneList(id);
	}

	@Override
	public OneToOne selectOneToOneRoom2(HashMap<String, String> map) {
		// TODO Auto-generated method stub
		return cDao.selectOneToOneRoom2(map);
	}

	@Override
	public ArrayList<OneToOneMsg> selectMessageList(String co_no) {
		// TODO Auto-generated method stub
		return cDao.selectMessageList(co_no);
	}

	@Override
	public ArrayList<OneToOneMsg> selectMessageList2(String co_no) {
		// TODO Auto-generated method stub
		return cDao.selectMessageList2(co_no);
	}

	@Override
	public int checkNickname(String nickname) {
		// TODO Auto-generated method stub
		return cDao.checkNickname(nickname);
	}

	@Override
	public int updateNickname(HashMap<String, String> map) {
		// TODO Auto-generated method stub
		return cDao.updateNickname(map);
	}

	@Override
	public int insertOpenchatMsg(HashMap<String, Object> dbmap) {
		// TODO Auto-generated method stub
		return cDao.insertOpenchatMsg(dbmap);
	}

	@Override
	public ArrayList<ChatroomMsg> selectOpenMessageList(String cr_no) {
		// TODO Auto-generated method stub
		return cDao.selectOpenMessageList(cr_no);
	}

	@Override
	public int insertOneToOnemsg2(HashMap<String, Object> dbmap) {
		// TODO Auto-generated method stub
		return cDao.insertOneToOnemsg2(dbmap);
	}

	@Override
	public int updateReadYN(HashMap<String, String> map) {
		// TODO Auto-generated method stub
		return cDao.updateReadYN(map);
	}

	@Override
	public List<OneToOne> selectMyChatRoomNo(String loginUserid) {
		// TODO Auto-generated method stub
		return cDao.selectMyChatRoomNo(loginUserid);
	}

	@Override
	public ArrayList<OneToOneMsg> ReadYNCountList() {
		// TODO Auto-generated method stub
		return cDao.ReadYNCountList();
	}

	@Override
	public int insertOneToOneSendImage(HashMap<String, Object> dbmap) {
		// TODO Auto-generated method stub
		return cDao.insertOneToOneSendImage(dbmap);
	}

	@Override
	public int insertOneToOneSendImage2(HashMap<String, Object> dbmap) {
		// TODO Auto-generated method stub
		return cDao.insertOneToOneSendImage2(dbmap);
	}

	@Override
	public int insertOpenchatSendImage(HashMap<String, Object> dbmap) {
		// TODO Auto-generated method stub
		return cDao.insertOpenchatSendImage(dbmap);
	}

	


	
}

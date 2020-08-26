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

	@Override
	public int ReadYnCount(HashMap<String, Object> dbmap) {
		// TODO Auto-generated method stub
		return cDao.ReadYnCount(dbmap);
	}

	@Override
	public int updateChatNotice(HashMap<String, String> map) {
		// TODO Auto-generated method stub
		return cDao.updateChatNotice(map);
	}

	@Override
	public String selectChatNotice(String co_no) {
		// TODO Auto-generated method stub
		return cDao.selectChatNotice(co_no);
	}

	@Override
	public int updateMyBackgroundImage(HashMap<String, String> map) {
		// TODO Auto-generated method stub
		return cDao.updateMyBackgroundImage(map);
	}

	@Override
	public int updateFrBackgroundImage(HashMap<String, String> map) {
		// TODO Auto-generated method stub
		return cDao.updateFrBackgroundImage(map);
	}

	@Override
	public ArrayList<OneToOne> selectOtoBackgroundInfo(HashMap<String, String> map) {
		// TODO Auto-generated method stub
		return cDao.selectOtoBackgroundInfo(map);
	}

	@Override
	public ArrayList<OneToOne> selectOtoBackgroundInfo2(HashMap<String, String> map) {
		// TODO Auto-generated method stub
		return cDao.selectOtoBackgroundInfo2(map);
	}

	@Override
	public ArrayList<OneToOne> selectOtoBackgroundInfo3(HashMap<String, String> map) {
		// TODO Auto-generated method stub
		return cDao.selectOtoBackgroundInfo3(map);
	}

	@Override
	public ArrayList<OneToOne> selectOtoBackgroundInfo4(HashMap<String, String> map) {
		// TODO Auto-generated method stub
		return cDao.selectOtoBackgroundInfo4(map);
	}

	@Override
	public int updateOpenChatNotice(HashMap<String, String> map) {
		// TODO Auto-generated method stub
		return cDao.updateOpenChatNotice(map);
	}

	@Override
	public String selectOpenChatNotice(String chatroomnumber) {
		// TODO Auto-generated method stub
		return cDao.selectOpenChatNotice(chatroomnumber);
	}

	@Override
	public int updateOpenBackgroundImage(HashMap<String, String> map) {
		// TODO Auto-generated method stub
		return cDao.updateOpenBackgroundImage(map);
	}

	@Override
	public ArrayList<Chatroom> selectOpenChatroomBackground(String chatroomnumber) {
		// TODO Auto-generated method stub
		return cDao.selectOpenChatroomBackground(chatroomnumber);
	}

	@Override
	public ArrayList<Chatroom> searchChatroomListResult(String searchOpenChatroom) {
		// TODO Auto-generated method stub
		return cDao.searchChatroomListResult(searchOpenChatroom);
	}

	

	

	


	
}

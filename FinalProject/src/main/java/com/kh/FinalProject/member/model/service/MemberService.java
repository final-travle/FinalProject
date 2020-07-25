package com.kh.FinalProject.member.model.service;

import java.util.ArrayList;

import com.kh.FinalProject.member.model.vo.Friends;
import com.kh.FinalProject.member.model.vo.Member;
import com.kh.FinalProject.member.model.vo.PageInfo;
import com.kh.FinalProject.member.model.vo.Time;
import com.kh.FinalProject.member.model.vo.Ttype;

public interface MemberService {

	int insertMember(Member m);

	Member loginMember(Member m);

	Member searchPwd(Member m);

	Member searchId(Member m);

	int change(Member m, Member mb);

	int checkIdDup(String id);

	int insertTtype(String parameter, String string, Ttype tp);

	ArrayList<Friends> friends(String id,String search);
	ArrayList<Friends> friends(String id);
	ArrayList<Friends> friends(String id,String search,PageInfo pi);
	
	Member friendsInfo(String string);

	ArrayList<Member> allMember(String string);

	int addFriends(String id, String string);

	ArrayList<Friends> friendsadd(String string, String id);

	int accfriends(String id, String string);



	int getListCount(String search,String userId);

	int getaddListCount(String search, String string);

	ArrayList<Member> allMember(String string, String search, PageInfo pi);

	int okfriendsCount(String search, String string, String id);

	ArrayList<Friends> friendsacc(String id, String string);

	int dltfriends(String id, String string);

	int dltmember(String id, String pwd);

	int fCount(String id);

	ArrayList<Friends> realfriends(String id, String search, PageInfo pi);

	int loginTime(String id);

	int setloginTime(String id);

	Integer friendsTime(String id);

	void changeTtype(String parameter, String string, Ttype tp);

	void deleteTtype(String id);

	int refusefriends(String id, String id2);

	int logoutTime(String id);

	int setlogoutTime(String id);

	Integer friendsLoginTime(String id);

}

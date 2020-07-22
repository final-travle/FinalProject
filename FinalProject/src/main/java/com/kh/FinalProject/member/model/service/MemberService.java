package com.kh.FinalProject.member.model.service;

import java.util.ArrayList;

import com.kh.FinalProject.member.model.vo.Friends;
import com.kh.FinalProject.member.model.vo.Member;
import com.kh.FinalProject.member.model.vo.PageInfo;
import com.kh.FinalProject.member.model.vo.Ttype;

public interface MemberService {

	int insertMember(Member m);

	Member loginMember(Member m);

	Member searchPwd(Member m);

	Member searchId(Member m);

	int change(Member m);

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

}

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

   ArrayList<Member> searchId(Member m);

   int change(Member m, Member mb);

   int checkIdDup(String id);

   int insertTtype(String parameter, String string, Ttype tp);

   ArrayList<Friends> friends(String id,String search);
   ArrayList<Friends> friends(String id);
   ArrayList<Friends> friends(String id,String search,PageInfo pi);
   
   Member friendsInfo(String string);

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

   ArrayList<Friends> realfriends(String id, String search,PageInfo pi);

   int loginTime(String id);

   int setloginTime(String id);

   Integer friendsTime(String id);

   void changeTtype(String parameter, String string, Ttype tp);

   void deleteTtype(String id);

   int refusefriends(String id, String id2);

   int logoutTime(String id);

   int setlogoutTime(String id);

   Integer friendsLoginTime(String id);

   int adminMemberDelete(String id);

   void dltmemberfriends(String id);

   void dltTime(String id);

   Member memberinfo(String id);

   ArrayList<String> memberinfoType(String id);

   int addFriends(String id, String id2);

   Member search(String member);

   int membercount(Member m);

   ArrayList<Friends> rlfriends(String id);

   ArrayList<Friends> realfriendsShared(String id, String search);

   ArrayList<String> sharedfd(Integer postNo, String postType, String id);

   ArrayList<Member> allMember2(String id);

   int fCount2(String id);

   int pCount(String id);

   void deleteShar(Integer postNo);

   int sCount(String id);

   int accfriendsCount(String id);

   ArrayList<String> mtype(String id);

   int changepass(Member m);

   String sid(String search);


}
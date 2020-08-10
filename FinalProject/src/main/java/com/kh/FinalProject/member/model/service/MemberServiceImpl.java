package com.kh.FinalProject.member.model.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.FinalProject.member.model.dao.MemberDao;
import com.kh.FinalProject.member.model.vo.Friends;
import com.kh.FinalProject.member.model.vo.FriendsPage;
import com.kh.FinalProject.member.model.vo.Member;
import com.kh.FinalProject.member.model.vo.PageInfo;
import com.kh.FinalProject.member.model.vo.Time;
import com.kh.FinalProject.member.model.vo.Ttype;



@Service("mService")
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberDao mDao;
	
	
	@Override
	public int insertMember(Member m) {
		// TODO Auto-generated method stub
		return mDao.insertMember(m);
	}


	@Override
	public Member loginMember(Member m) {
		// TODO Auto-generated method stub
		System.out.println(m);
		return mDao.loginMember(m);
	}


	@Override
	public Member searchPwd(Member m) {
		// TODO Auto-generated method stub
		return mDao.searchPwd(m);
	}


	@Override
	public Member searchId(Member m) {
		// TODO Auto-generated method stub
		return mDao.searchId(m);
	}


	@Override
	public int change(Member m,Member mb) {
		// TODO Auto-generated method stub
//		return mDao.change(m,mb);
		int a =0;
		if(m.getId().equals(mb.getId())) {
			m.setJob(mb.getJob());
			m.setWithd_yn(mb.getWithd_yn());
			m.setJoin_date(mb.getJoin_date());
			a=mDao.change(m);
		}
		return a;
	}


	@Override
	public int checkIdDup(String id) {
		// TODO Auto-generated method stub
		return mDao.checkIdDup(id);
	}


	@Override
	public int insertTtype(String parameter, String string, Ttype tp) {
		// TODO Auto-generated method stub
		tp.setId(parameter);
		tp.setSye(string);
		return mDao.insertTtype(tp);
		
	}

	@Override
	public int getListCount(String search,String userId) {
		// TODO Auto-generated method stub
		System.out.println("쉬벌 여기까진 들어가냐 ");
		System.out.println(search);
		System.out.println(userId);
		int count =0;
		if(search =="" || search ==null ) {
			
			System.out.println("하 쉬이벌 존나 하기싫네");
			count=mDao.getListCount(userId);
		}else {
			FriendsPage fp = new FriendsPage();
			fp.setSearch(search);
			fp.setUserId(userId);
			System.out.println("하 쉬이벌 존온나 하기싫네");
			count=mDao.getListCount2(fp);
		}
		
		return count;
	}

	
	@Override
	public ArrayList<Member> allMember(String string, String search, PageInfo pi) {
		ArrayList<Member> al = new ArrayList<Member>();
		if(search ==null || search =="") {
			
			al=mDao.allMember2(string,pi);
		}else {
			FriendsPage fp = new FriendsPage();
			fp.setSearch(search);//이름
			fp.setUserId(string); 
			al =mDao.allMember(fp,pi);
		}
		
		return al;

	}
	
	@Override
	public ArrayList<Friends> friends(String id) {
		// TODO Auto-generated method stub
		return mDao.friends(id);
	}


	@Override
	public Member friendsInfo(String string) {
		// TODO Auto-generated method stub
		return mDao.friendsInfo(string);
	}


	



	@Override
	public ArrayList<Friends> friendsadd(String id, String string) {
		Friends fr = new Friends();
		fr.setfId(id);
		fr.setUserId(string);
		fr.setAcceptYn("N");
		return mDao.friendsadd(fr);
	}


	@Override
	public int accfriends(String id, String string) {
		// TODO Auto-generated method stub
		Friends fr = new Friends();
		fr.setfId(id);
		fr.setUserId(string);
		fr.setAcceptYn("Y");
		return mDao.accfriends(fr);
	}




	

	@Override
	public ArrayList<Friends> friends(String id, String search) {
		// TODO Auto-generated method stub
		System.out.println("여기까지는 오냐");
		System.out.println(search);
		ArrayList<Friends> al = new ArrayList<Friends>();
		if(search !=null  || search=="") {
			FriendsPage fp = new FriendsPage();
			fp.setSearch(search);
			fp.setUserId(id);
			al =mDao.friends(fp);			
		}else {
			al=mDao.friends(id);
		}
		
		return al;
	}


	@Override
	public ArrayList<Friends> friends(String id,String search, PageInfo pi) {
		// TODO Auto-generated method stub
		ArrayList<Friends> al = new ArrayList<Friends>();
		if(search ==null || search=="") {			
			al=mDao.friends(id,pi);
		}else {
			FriendsPage fp = new FriendsPage();
			fp.setSearch(search);
			fp.setUserId(id);
			al =mDao.friends(fp,pi);
		}
		
		return al;
	}


	@Override
	public int getaddListCount(String search, String userId) {
		System.out.println("쉬벌 여기까진 들어가냐 ");
		System.out.println(search);
		System.out.println(userId);
		int count =0;
		if(search ==null || search=="") {
			count=mDao.getaddListCount(userId);
		}else {
			FriendsPage fp = new FriendsPage();
			fp.setSearch(search);
			fp.setUserId(userId);
			count=mDao.getaddListCount2(fp);
		}
		
		return count;
	}





	@Override
	public ArrayList<Member> allMember(String string) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int okfriendsCount(String search, String string, String id) {
		// TODO Auto-generated method stub
		
		 
			
		
		
		return mDao.okfriendsCount(string);
	}


	@Override
	public ArrayList<Friends> friendsacc(String id, String string) {
		// TODO Auto-generated method stub
		Friends fr = new Friends();
		fr.setfId(id);
		fr.setUserId(string);
		fr.setAcceptYn("N");
		return mDao.friendsacc(fr);
	}


	@Override
	public int dltfriends(String id, String string) {
		// TODO Auto-generated method stub
		Friends fr = new Friends();
		fr.setfId(id);
		fr.setUserId(string);
		return mDao.dltfriends(fr);
	}


	@Override
	public int dltmember(String id, String pwd) {
		// TODO Auto-generated method stub
		Member m = new Member();
		m.setId(id);
		m.setPwd(pwd);
		return mDao.dltmember(m);
	}


	@Override
	public int fCount(String id) {
		// TODO Auto-generated method stub
		return mDao.fCount(id);
	}


	@Override
	public ArrayList<Friends> realfriends(String id, String search, PageInfo pi) {
		ArrayList<Friends> al = new ArrayList<Friends>();
		if(search !=null  || search=="") {
			FriendsPage fp = new FriendsPage();
			fp.setSearch(search);
			fp.setUserId(id);
			al =mDao.realfriends(fp);			
		}else {
			al=mDao.realfriends(id);
		}
		
		return al;
	}


	@Override
	public int loginTime(String id) {
		// TODO Auto-generated method stub
		return mDao.loginTime(id);
	}


	@Override
	public int setloginTime(String id) {
		// TODO Auto-generated method stub
		return mDao.setloginTime(id);
	}


	@Override
	public Integer friendsTime(String id) {
		// TODO Auto-generated method stub
		return mDao.friendsTime(id);
	}


	@Override
	public void changeTtype(String parameter, String string, Ttype tp) {
		tp.setId(parameter);
		tp.setSye(string);
		mDao.changeTtype(tp);	
	}


	@Override
	public void deleteTtype(String id) {
		// TODO Auto-generated method stub
		mDao.deleteTtype(id);
	}


	@Override
	public int refusefriends(String id, String id2) {
		// TODO Auto-generated method stub
		Friends fr = new Friends();
		fr.setUserId(id2);
		fr.setfId(id);
		return mDao.refusefriends(fr);
	}


	@Override
	public int logoutTime(String id) {
		// TODO Auto-generated method stub
		return mDao.logoutTime(id);
	}


	@Override
	public int setlogoutTime(String id) {
		// TODO Auto-generated method stub
		return mDao.setlogoutTime(id);
	}


	@Override
	public Integer friendsLoginTime(String id) {
		// TODO Auto-generated method stub
		return mDao.friendsLoginTime(id);
	}


	@Override
	public int adminMemberDelete(String id) {
		// TODO Auto-generated method stub
		return mDao.adminMemberDelete(id);
	}


	@Override
	public void dltmemberfriends(String id) {
		// TODO Auto-generated method stub
		 mDao.dltmemberfriends(id);
	}


	@Override
	public void dltTime(String id) {
		// TODO Auto-generated method stub
		mDao.dltTime(id);
	}


	@Override
	public Member memberinfo(String id) {
		// TODO Auto-generated method stub
		return mDao.memberinfo(id);
	}


	@Override
	public ArrayList<String> memberinfoType(String id) {
		// TODO Auto-generated method stub
		return mDao.memberinfoType(id);
	}


	@Override
	public int addFriends(String id, String id2) {
		// TODO Auto-generated method stub
		Friends fr = new Friends();
		fr.setfId(id);
		fr.setUserId(id2);
		fr.setAcceptYn("N");
		return mDao.addFriends(fr);
	}


	@Override
	public Member search(String member) {
		// TODO Auto-generated method stub
		return mDao.search(member);
	}


	@Override
	public int membercount(Member m) {
		// TODO Auto-generated method stub
		return mDao.membercount(m);
	}


	@Override
	public ArrayList<Friends> rlfriends(String id) {
		// TODO Auto-generated method stub
		return mDao.rlfriends(id);
	}


	@Override
	public ArrayList<Friends> realfriendsShared(String id, String search) {
		
		ArrayList<Friends> al = new ArrayList<Friends>();
		if(search !=null  || search=="") {
			FriendsPage fp = new FriendsPage();
			fp.setSearch(search);
			fp.setUserId(id);
			al =mDao.realfriendsShared(fp);			
		}else {
			al=mDao.realfriendsShared(id);
		}
		
		return al;
	}


	@Override
	public ArrayList<String> sharedfd(Integer postNo, String postType, String id) {
		// TODO Auto-generated method stub
		return mDao.sharedfd(postNo,postType,id);
	}


	@Override
	public ArrayList<Member> allMember2(String id) {
		// TODO Auto-generated method stub
		return mDao.allMember2(id);
	}

	}






	







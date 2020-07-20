package com.kh.FinalProject.member.model.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.FinalProject.member.model.dao.MemberDao;
import com.kh.FinalProject.member.model.vo.Friends;
import com.kh.FinalProject.member.model.vo.FriendsPage;
import com.kh.FinalProject.member.model.vo.Member;
import com.kh.FinalProject.member.model.vo.PageInfo;
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
	public int change(Member m) {
		// TODO Auto-generated method stub
		return mDao.change(m);
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
	public int addFriends(String id, String string) {
		// TODO Auto-generated method stub
		Friends fr = new Friends();
		fr.setfId(id);
		fr.setUserId(string);
		fr.setAcceptYn("N");
		return mDao.addFriends(fr);
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



	


	




}


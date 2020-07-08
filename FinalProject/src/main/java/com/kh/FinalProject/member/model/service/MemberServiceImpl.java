package com.kh.FinalProject.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.FinalProject.member.model.dao.MemberDao;
import com.kh.FinalProject.member.model.vo.Member;
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


	




}


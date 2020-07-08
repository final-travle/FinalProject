package com.kh.FinalProject.member.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.kh.FinalProject.member.model.vo.Member;
import com.kh.FinalProject.member.model.vo.Ttype;

@Repository("mDao")
public class MemberDao {

	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public int insertMember(Member m) {
		// TODO Auto-generated method stub
		System.out.println("member : "+m);
		return sqlSessionTemplate.insert("memberMapper.insertMember",m);
	}

	public Member loginMember(Member m) {
		// TODO Auto-generated method stub
		System.out.println("member : "+m);
		return sqlSessionTemplate.selectOne("memberMapper.selectMember",m);
	}

	public Member searchPwd(Member m) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("memberMapper.searchPwd",m);
	}

	public Member searchId(Member m) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("memberMapper.searchId",m);
	}

	public int change(Member m) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.update("memberMapper.searchId",m);
	}

	public int checkIdDup(String id) {
		// TODO Auto-generated method stub
		System.out.println(id);
		return sqlSessionTemplate.selectOne("memberMapper.checkIdDup",id);
	}


	public int insertTtype(Ttype tp) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.insert("memberMapper.insertTtype",tp);
	}

}


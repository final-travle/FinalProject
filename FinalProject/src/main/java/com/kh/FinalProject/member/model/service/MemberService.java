package com.kh.FinalProject.member.model.service;

import com.kh.FinalProject.member.model.vo.Member;
import com.kh.FinalProject.member.model.vo.Ttype;

public interface MemberService {

	int insertMember(Member m);

	Member loginMember(Member m);

	Member searchPwd(Member m);

	Member searchId(Member m);

	int change(Member m);

	int checkIdDup(String id);

	int insertTtype(String parameter, String string, Ttype tp);

}

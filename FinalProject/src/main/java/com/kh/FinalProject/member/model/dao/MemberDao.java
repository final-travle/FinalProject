package com.kh.FinalProject.member.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.kh.FinalProject.member.model.vo.Friends;
import com.kh.FinalProject.member.model.vo.FriendsPage;
import com.kh.FinalProject.member.model.vo.Member;
import com.kh.FinalProject.member.model.vo.PageInfo;
import com.kh.FinalProject.member.model.vo.Time;
import com.kh.FinalProject.member.model.vo.Ttype;
import com.kh.FinalProject.postShared.model.vo.PostShared;

@Repository("mDao")
public class MemberDao {

	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public int insertMember(Member m) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.insert("memberMapper.insertMember",m);
	}

	public Member loginMember(Member m) {
		// TODO Auto-generated method stub
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
		return sqlSessionTemplate.update("memberMapper.change",m);
	}

	public int checkIdDup(String id) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("memberMapper.checkIdDup",id);
	}


	public int insertTtype(Ttype tp) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.insert("memberMapper.insertTtype",tp);
	}

	public ArrayList<Friends> friends(String id) {
		// TODO Auto-generated method stub
		return (ArrayList)sqlSessionTemplate.selectList("friends.friends",id);
	}
	
	public ArrayList<Friends> friends(FriendsPage fp) {
		// TODO Auto-generated method stub
		return (ArrayList)sqlSessionTemplate.selectList("friends.friends2",fp);
	}

	public Member friendsInfo(String string) {
		// TODO Auto-generated method stub
		return  sqlSessionTemplate.selectOne("memberMapper.friendsInfo",string);
	}

	public ArrayList<Member> allMember(String string) {
		// TODO Auto-generated method stub
		return (ArrayList)sqlSessionTemplate.selectList("memberMapper.allMember",string);
	}

	public int addFriends(Friends fr) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.insert("friends.addFriends",fr);
	}

	public ArrayList<Friends> friendsadd(Friends fr) {
		// TODO Auto-generated method stub
		return (ArrayList)sqlSessionTemplate.selectList("friends.friendsadd",fr);
	}

	public int accfriends(Friends fr) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.update("friends.accfriends",fr);
	}

	public int getListCount(String userId) {
		// TODO Auto-generated method stub
		return	sqlSessionTemplate.selectOne("friends.getListCount",userId);
	}

	public int getListCount2(FriendsPage fp) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("friends.getListCount2",fp);
	}

	public ArrayList<Friends> friends(FriendsPage fp, PageInfo pi) {
		// TODO Auto-generated method stub
		int offset = (pi.getCurrentPage()-1)*pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		return (ArrayList)sqlSessionTemplate.selectList("friends.friends2",fp,rowBounds);
	}

	public ArrayList<Friends> friends(String id, PageInfo pi) {
		// TODO Auto-generated method stub
		int offset = (pi.getCurrentPage()-1)*pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		return (ArrayList)sqlSessionTemplate.selectList("friends.friends",id,rowBounds);
	}

	public int getaddListCount(String userId) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("memberMapper.allMemberCount",userId);
	}

	public int getaddListCount2(FriendsPage fp) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("memberMapper.allMemberCount2",fp);
	}

	public ArrayList<Member> allMember(FriendsPage fp, PageInfo pi) {
		// TODO Auto-generated method stub
		int offset = (pi.getCurrentPage()-1)*pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		return (ArrayList)sqlSessionTemplate.selectList("memberMapper.allMember",fp,rowBounds);
	}

	public ArrayList<Member> allMember2(String string, PageInfo pi) {
		// TODO Auto-generated method stub
		int offset = (pi.getCurrentPage()-1)*pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		return (ArrayList)sqlSessionTemplate.selectList("memberMapper.allMember2",string,rowBounds);
	}



	public int okfriendsCount(String string) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("friends.getListCount",string);
	}

	public ArrayList<Friends> friendsacc(Friends fr) {
		// TODO Auto-generated method stub
		return (ArrayList)sqlSessionTemplate.selectList("friends.friendsacc",fr);
	}

	public int dltfriends(Friends fr) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.delete("friends.dltfriends",fr);
	}

	public int dltmember(Member m) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.update("memberMapper.dltmember",m);
	}

	public int fCount(String id) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("friends.fCount",id);
	}

	public ArrayList<Friends> realfriends(FriendsPage fp) {
		// TODO Auto-generated method stub
		return (ArrayList)sqlSessionTemplate.selectList("friends.realfriends",fp);
	}

	public ArrayList<Friends> realfriends(String id) {
		// TODO Auto-generated method stub
		return (ArrayList)sqlSessionTemplate.selectList("friends.realfriends2",id);
	}

	public int loginTime(String id) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.update("memberMapper.loginTime",id); //업데이트안되면 넣기
	}

	public int setloginTime(String id) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.insert("memberMapper.setloginTime",id);
	}

	public Integer friendsTime(String id) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("memberMapper.friendsTime",id);
	}

	public void changeTtype(Ttype tp) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.update("memberMapper.changeTtype",tp);
	}

	public void deleteTtype(String id) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.delete("memberMapper.deleteTtype",id);
		
	}
	public void dltTime(String id) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.delete("friends.dltTime",id);
		
	}
	
	public int refusefriends(Friends fr) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.delete("friends.refusefriends",fr);
	}

	public int logoutTime(String id) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.update("memberMapper.logoutTime",id);
	}

	public int setlogoutTime(String id) {
		// TODO Auto-generated method stub
		return  sqlSessionTemplate.insert("memberMapper.setlogoutTime",id);
	}

	public Integer friendsLoginTime(String id) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("memberMapper.friendsLoginTime",id);
	}

	public int adminMemberDelete(String id) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.update("memberMapper.adminMemberDelete",id);
	}
	public int dltmemberfriends(String id) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.delete("friends.dltmemberfriends",id);
	}

	public Member memberinfo(String id) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("memberMapper.memberinfo",id);
	}

	public ArrayList<String> memberinfoType(String id) {
		// TODO Auto-generated method stub
		return (ArrayList)sqlSessionTemplate.selectList("memberMapper.memberinfoType",id);
	}

	public Member search(String member) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("memberMapper.search",member);
	}

	public int membercount(Member m) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("memberMapper.membercount",m);
	}

	public ArrayList<Friends> rlfriends(String id) {
		// TODO Auto-generated method stub
		return (ArrayList)sqlSessionTemplate.selectList("friends.rlfriends",id);
	}

	public ArrayList<Friends> realfriendsShared(FriendsPage fp) {
		// TODO Auto-generated method stub
		return (ArrayList)sqlSessionTemplate.selectList("friends.realfriendsShared",fp);
	}

	public ArrayList<Friends> realfriendsShared(String id) {
		// TODO Auto-generated method stub
		return (ArrayList)sqlSessionTemplate.selectList("friends.realfriendsShared2",id);
	}

	public ArrayList<String> sharedfd(Integer postNo, String postType, String id) {
		// TODO Auto-generated method stub
		PostShared ps = new PostShared();
		ps.setPost_no(postNo);
		ps.setPost_type(postType);
		ps.setUser_id(id);
		return (ArrayList)sqlSessionTemplate.selectList("friends.sharedfd",ps);
	}

	public ArrayList<Member> allMember2(String id) {
		// TODO Auto-generated method stub
		return (ArrayList)sqlSessionTemplate.selectList("memberMapper.allMember2",id);
	}
	
	
}


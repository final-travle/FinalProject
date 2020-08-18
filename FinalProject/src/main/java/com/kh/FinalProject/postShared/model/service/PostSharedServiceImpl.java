package com.kh.FinalProject.postShared.model.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.FinalProject.member.model.dao.MemberDao;
import com.kh.FinalProject.member.model.service.MemberService;
import com.kh.FinalProject.postShared.model.dao.PostSharedDao;
import com.kh.FinalProject.postShared.model.vo.PostShared;
import com.kh.FinalProject.travel.model.vo.Board;
import com.kh.FinalProject.travel.model.vo.PageInfo;
import com.kh.FinalProject.travel.model.vo.PostTag;



@Service("pService")
public class PostSharedServiceImpl implements PostSharedService{

	
	@Autowired
	private PostSharedDao pDao;
	
	@Override
	public ArrayList<Board> selectList(PageInfo pi2,String id) {
		// TODO Auto-generated method stub
		return pDao.selectList(pi2,id);
	}

	@Override
	public ArrayList<PostTag> selectListTag() {
		// TODO Auto-generated method stub
		return pDao.selectListTag();
	}

	@Override
	public int SharedInsert(String id, String id2, Integer postNo, String postType) {
		// TODO Auto-generated method stub
		
		PostShared ps = new PostShared();
		ps.setPost_no(postNo);
		ps.setUser_id(id);
		ps.setShare_id(id2);
		ps.setPost_type(postType);
		
		return pDao.sharedInsert(ps);
	}

	@Override
	public ArrayList<PostShared> selectShare(String id) {
		// TODO Auto-generated method stub
		return pDao.selectShare(id);
	}

	@Override
	public Board selectsharedList(PostShared postShared) {
		// TODO Auto-generated method stub
		return pDao.selectsharedList(postShared);
	}

	@Override
	public int deleteShared(PostShared ps) {
		// TODO Auto-generated method stub
		return pDao.deleteShared(ps);
	}

	@Override
	public int getListCount(String id) {
		// TODO Auto-generated method stub
		return pDao.getListCount(id);
	}

	@Override
	public void planDelete(String id, Integer postNo) {
		PostShared ps = new PostShared();
		ps.setPost_no(postNo);
		ps.setUser_id(id);
		pDao.planDelete(ps);
		
	}

	@Override
	public void memberSharedDelete(String id, Integer postNo) {
		PostShared ps = new PostShared();
		ps.setPost_no(postNo);
		ps.setUser_id(id);
		pDao.memberSharedDelete(ps);
		
	}
	
	@Override
	public int getListAllCount() {
		// TODO Auto-generated method stub
		return pDao.getListAllCount();
	}

	@Override
	public ArrayList<Board> selectAllList(PageInfo pi2) {
		// TODO Auto-generated method stub
		return pDao.selectAllList(pi2);
	}

}

package com.kh.FinalProject.postShared.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.FinalProject.postShared.model.vo.PostShared;
import com.kh.FinalProject.travel.model.vo.Board;
import com.kh.FinalProject.travel.model.vo.PageInfo;
import com.kh.FinalProject.travel.model.vo.PostTag;

@Repository("pDao")
public class PostSharedDao {


	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	
	public ArrayList<Board> selectList(PageInfo pi2 ,String id) {
		int offset = (pi2.getCurrentPage() - 1) * pi2.getBoardLimit();
		//(1 - 1) * 12
		RowBounds rowBounds = new RowBounds(offset, pi2.getBoardLimit());
		
		return (ArrayList)sqlSessionTemplate.selectList("travelMapper.memberselectList", id, rowBounds);
	}

	public ArrayList<PostTag> selectListTag() {
		// TODO Auto-generated method stub
		return (ArrayList)sqlSessionTemplate.selectList("travelMapper.selectListTag");
	}

	public int sharedInsert(PostShared ps) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.insert("travelMapper.sharedInsert", ps);
	}

	public ArrayList<PostShared> selectShare(String id) {
		// TODO Auto-generated method stub
		return (ArrayList)sqlSessionTemplate.selectList("travelMapper.selectShare", id);
	}

	public Board selectsharedList(PostShared postShared) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("travelMapper.selectsharedList",postShared);
	}

	public int deleteShared(PostShared ps) {
		// TODO Auto-generated method stub
		System.out.println("여기까진 오냐");
		return sqlSessionTemplate.delete("travelMapper.deleteShared",ps);
	}

	public int getListCount(String id) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("travelMapper.getListCount2",id);
	}

	public void planDelete(PostShared ps) {
		sqlSessionTemplate.update("travelMapper.planDelete2",ps);
		
	}

	public void memberSharedDelete(PostShared ps) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.delete("travelMapper.memberSharedDelete",ps);
	}

	public int getListAllCount() {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("travelMapper.getListAllCount");
	}

	public ArrayList<Board> selectAllList(PageInfo pi2) {
		// TODO Auto-generated method stub
		int offset = (pi2.getCurrentPage() - 1) * pi2.getBoardLimit();
		//(1 - 1) * 12
		RowBounds rowBounds = new RowBounds(offset, pi2.getBoardLimit());
		
		return (ArrayList)sqlSessionTemplate.selectList("travelMapper.memberselectAllList",  rowBounds);
				
	}

}

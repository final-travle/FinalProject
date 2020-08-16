package com.kh.FinalProject.review.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.FinalProject.travel.model.vo.Board;
import com.kh.FinalProject.travel.model.vo.PageInfo;
import com.kh.FinalProject.travel.model.vo.PostTag;
import com.kh.FinalProject.travel.model.vo.Tag;
import com.kh.FinalProject.travel.model.vo.Travel;

@Repository("rd")
public class ReviewDao {

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	public int getListCount() {
		return sqlSessionTemplate.selectOne("reviewMapper.getListCount");
	}

	public ArrayList<Board> selectList(PageInfo pi2) {
		int offset = (pi2.getCurrentPage() - 1) * pi2.getBoardLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi2.getBoardLimit());
		
		return (ArrayList) sqlSessionTemplate.selectList("reviewMapper.selectList", pi2, rowBounds);
	}

	public ArrayList<PostTag> selectListTag() {
		return (ArrayList)sqlSessionTemplate.selectList("reviewMapper.selectListTag");
	}

	public ArrayList<Tag> getTagList() {
		return (ArrayList)sqlSessionTemplate.selectList("travelMapper.getTagList");
	}

	public int reviewInsert(Board b) {
		return sqlSessionTemplate.insert("reviewMapper.insertReivew", b);
	}

	public int reviewLikeThumbupInsert() {
		return sqlSessionTemplate.insert("reviewMapper.insertLT");
	}

	public int insertTag(Tag tg) {
		return sqlSessionTemplate.insert("reviewMapper.insertTag", tg);
	}

	public int reviewDayInsert(int i) {
		return sqlSessionTemplate.insert("reviewMapper.insertDay", i);
	}

	public int reviewInsertPoint(Travel tv) {
		return sqlSessionTemplate.insert("reviewMapper.InsertPoint", tv);
	}
	
}

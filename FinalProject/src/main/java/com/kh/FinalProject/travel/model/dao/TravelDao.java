package com.kh.FinalProject.travel.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.FinalProject.travel.model.vo.Board;
import com.kh.FinalProject.travel.model.vo.MapBoard;
import com.kh.FinalProject.travel.model.vo.PageInfo;
import com.kh.FinalProject.travel.model.vo.PostTag;
import com.kh.FinalProject.travel.model.vo.Tag;
import com.kh.FinalProject.travel.model.vo.Travel;

@Repository("td")
public class TravelDao {

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public int getListCount() {
		return sqlSessionTemplate.selectOne("travelMapper.getListCount");
	}

	public ArrayList<Board> selectList(PageInfo pi2) {
		int offset = (pi2.getCurrentPage() - 1) * pi2.getBoardLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi2.getBoardLimit());
		
		return (ArrayList)sqlSessionTemplate.selectList("travelMapper.selectList", null, rowBounds);
	}

	public int planInsert(Board b) {
		return sqlSessionTemplate.insert("travelMapper.insertPlanB", b);
	}

	public int planLikeThumbupInsert() {
		return sqlSessionTemplate.insert("travelMapper.insertLT");
	}

	public int planDayInsert(int i) {
		return sqlSessionTemplate.insert("travelMapper.insertDay", i);
	}

	public int planInsertPoint(Travel tv) {
		return sqlSessionTemplate.insert("travelMapper.insertPoint", tv);
	}

	public ArrayList<Tag> getTagList() {
		return (ArrayList)sqlSessionTemplate.selectList("travelMapper.getTagList", null);
	}

	public int insertTag(Tag tg) {
		return sqlSessionTemplate.insert("travelMapper.insertTag", tg);
	}

	public ArrayList<PostTag> selectListTag() {
		return (ArrayList)sqlSessionTemplate.selectList("travelMapper.selectListTag");
	}

	public int hitsUp(int postNo) {
		return sqlSessionTemplate.update("travelMapper.hitsUp", postNo);
	}

	public Board selectPostView(int postNo) {
		return sqlSessionTemplate.selectOne("travelMapper.selectPostView", postNo);
	}

	public ArrayList<Travel> selectTravelList(int postNo) {
		return (ArrayList) sqlSessionTemplate.selectList("travelMapper.selectTravelList", postNo);
	}

	public MapBoard likeVoteView(int postNo) {
		return sqlSessionTemplate.selectOne("travelMapper.likeVoteView", postNo);
	}

	public Board selectPlan(int postNo) {
		return sqlSessionTemplate.selectOne("travelMapper.selectPlan", postNo);
	}


}

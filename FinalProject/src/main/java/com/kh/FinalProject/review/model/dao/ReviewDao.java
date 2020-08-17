package com.kh.FinalProject.review.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.FinalProject.travel.model.vo.Board;
import com.kh.FinalProject.travel.model.vo.LikedPost;
import com.kh.FinalProject.travel.model.vo.MapBoard;
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
		System.out.println("여기까지는? " + tv);
		return sqlSessionTemplate.insert("reviewMapper.insertPoint", tv);
	}

	public int hitsUp(int postNo) {
		return sqlSessionTemplate.update("reviewMapper.hitsUp", postNo);
	}

	public LikedPost likedView(LikedPost lp) {
		return sqlSessionTemplate.selectOne("reviewMapper.likedPost", lp);
	}

	public MapBoard likeVoteView(int postNo) {
		return sqlSessionTemplate.selectOne("reviewMapper.likeVoteView", postNo);
	}

	public Board selectPostView(int postNo) {
		return sqlSessionTemplate.selectOne("reviewMapper.selectPostView", postNo);
	}

	public ArrayList<Travel> selectTravelList(int postNo) {
		return (ArrayList) sqlSessionTemplate.selectList("reviewMapper.selectTravelList", postNo);
	}

	public ArrayList<PostTag> getPostTagList(int postNo) {
		return (ArrayList) sqlSessionTemplate.selectList("reviewMapper.getPostTagList", postNo);
	}

	public Board selectReview(int postNo) {
		return sqlSessionTemplate.selectOne("reviewMapper.selectReview", postNo);
	}

	public int reviewModifyPost(Board b) {
		return sqlSessionTemplate.update("reviewMapper.reviewModifyPost", b);
	}

	public int reviewModifyB(int postNo) {
		return sqlSessionTemplate.delete("reviewMapper.reviewModifyB", postNo);
	}

	public int reviewMoidfyPoint(Travel tv) {
		return sqlSessionTemplate.insert("reviewMapper.modifyPoint", tv);
	}

	public int reviewModifyPT(int postNo) {
		return sqlSessionTemplate.delete("reviewMapper.reviewModifyPT", postNo);
	}

	public int ModifyTag(PostTag tg) {
		return sqlSessionTemplate.insert("reviewMapper.modifyTag", tg);
	}

	public int reviewDelete(int postNo) {
		return sqlSessionTemplate.update("reviewMapper.reviewDelete", postNo);
	}
	
}

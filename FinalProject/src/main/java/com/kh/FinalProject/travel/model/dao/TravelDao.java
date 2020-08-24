package com.kh.FinalProject.travel.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.FinalProject.travel.model.vo.Board;
import com.kh.FinalProject.travel.model.vo.Comments;
import com.kh.FinalProject.travel.model.vo.LikedPost;
import com.kh.FinalProject.travel.model.vo.MapBoard;
import com.kh.FinalProject.travel.model.vo.PageInfo;
import com.kh.FinalProject.travel.model.vo.PostTag;
import com.kh.FinalProject.travel.model.vo.ReComments;
import com.kh.FinalProject.travel.model.vo.Tag;
import com.kh.FinalProject.travel.model.vo.Travel;
import com.kh.FinalProject.travel.model.vo.Vote;

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

	public MapBoard likeVoteView(LikedPost lp) {
		return sqlSessionTemplate.selectOne("travelMapper.likeVoteView", lp);
	}

	public Board selectPlan(int postNo) {
		return sqlSessionTemplate.selectOne("travelMapper.selectPlan", postNo);
	}

	public ArrayList<PostTag> getPostTagList(int postNo) {
		return (ArrayList) sqlSessionTemplate.selectList("travelMapper.getPostTagList", postNo);
	}

	public int planModifyB(int postNo) {
		return sqlSessionTemplate.delete("travelMapper.planModifyB", postNo);
	}
	
	public int planModifyPT(int postNo) {
		return sqlSessionTemplate.delete("travelMapper.planModifyPT", postNo);
	}

	public int ModifyTag(PostTag tg) {
		return sqlSessionTemplate.insert("travelMapper.modifyTag", tg);
	}
		
	public int planMoidfyPoint(Travel tv) {
		return sqlSessionTemplate.insert("travelMapper.modifyPoint", tv);
	}
	
	public int planModifyPost(Board b) {
		return sqlSessionTemplate.update("travelMapper.planModifyPost", b);
	}
	
	public int likeUp(LikedPost lp) {
		return sqlSessionTemplate.update("travelMapper.likeUp", lp);
	}

	public LikedPost likedView(LikedPost lp) {
		return sqlSessionTemplate.selectOne("travelMapper.likedPost", lp);
	}

	public int likeUpdate(LikedPost lp) {
		return sqlSessionTemplate.update("travelMapper.likeUpdate", lp);
	}

	public int insertLike(LikedPost lp) {
		return sqlSessionTemplate.insert("travelMapper.insertLike", lp);
	}

	public int planDelete(int postNo) {
		return sqlSessionTemplate.update("travelMapper.planDelete", postNo);
	}

	public Vote voteView(Vote v) {
		return sqlSessionTemplate.selectOne("travelMapper.voteView", v);
	}

	public int insertVote(Vote v) {
		return sqlSessionTemplate.update("travelMapper.insertVote", v);
	}

	public int voteUp(Vote v) {
		return sqlSessionTemplate.update("travelMapper.voteUp", v);
	}

	public int voteUpdate(Vote v) {
		return sqlSessionTemplate.update("travelMapper.voteUpdate", v);
	}

	public MapBoard likeVoteView(Vote v) {
		return sqlSessionTemplate.selectOne("travelMapper.likeVoteView", v);
	}

	public Vote voteView(LikedPost lp) {
		return sqlSessionTemplate.selectOne("travelMapper.voteView", lp);
	}

	public ArrayList<Comments> getComments(Comments cmnt) {
		return (ArrayList) sqlSessionTemplate.selectList("travelMapper.getComments", cmnt);
	}

	public ArrayList<ReComments> getReComments(Comments cmnt) {
		return (ArrayList) sqlSessionTemplate.selectList("travelMapper.getReComments", cmnt);
	}

	public int insertComment(Comments cmnt) {
		return sqlSessionTemplate.insert("travelMapper.insertComment", cmnt);
	}

	public int commentModify(Comments cmnt) {
		return sqlSessionTemplate.update("travelMapper.commentModify", cmnt);
	}

	public ArrayList<ReComments> checkReComments(ReComments recmnt) {
		return (ArrayList) sqlSessionTemplate.selectList("travelMapper.checkReComments", recmnt);
	}

	public int insertReComment(ReComments recmnt) {
		return sqlSessionTemplate.insert("travelMapper.insertReComment", recmnt);
	}

	public int recommentModify(ReComments recmnt) {
		return sqlSessionTemplate.update("travelMapper.recommentModify", recmnt);
	}

	public ArrayList<MapBoard> likeVoteView() {
		return (ArrayList) sqlSessionTemplate.selectList("travelMapper.likeViewList");
	}



}

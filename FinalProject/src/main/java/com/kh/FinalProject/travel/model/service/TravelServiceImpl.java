package com.kh.FinalProject.travel.model.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.FinalProject.travel.model.dao.TravelDao;
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

@Service("ts")
public class TravelServiceImpl implements TravelService {
	@Autowired
	TravelDao td;
	
	@Override
	public int getListCount() {
		return td.getListCount();
	}

	@Override
	public ArrayList<Board> selectList(PageInfo pi2) {
		return td.selectList(pi2);
	}

	@Override
	public int planInsert(Board b) {
		return td.planInsert(b);
	}

	@Override
	public int planLikeThumbupInsert() {
		return td.planLikeThumbupInsert();
	}

	@Override
	public int planDayInsert(int i) {
		return td.planDayInsert(i);
	}

	@Override
	public int planInsertPoint(Travel tv) {
		return td.planInsertPoint(tv);
	}

	@Override
	public ArrayList<Tag> getTagList() {
		return td.getTagList();
	}

	@Override
	public int insertTag(Tag tg) {
		return td.insertTag(tg);
	}

	@Override
	public ArrayList<PostTag> selectListTag() {
		return td.selectListTag();
	}

	@Override
	public int hitsUp(int postNo) {
		return td.hitsUp(postNo);
	}

	@Override
	public Board selectPostView(int postNo) {
		return td.selectPostView(postNo);
	}

	@Override
	public ArrayList<Travel> selectTravelList(int postNo) {
		return td.selectTravelList(postNo);
	}

	@Override
	public MapBoard likeVoteView(LikedPost lp) {
		return td.likeVoteView(lp);
	}

	@Override
	public Board selectPlan(int postNo) {
		return td.selectPlan(postNo);
	}

	@Override
	public ArrayList<PostTag> getPostTagList(int postNo) {
		return td.getPostTagList(postNo);
	}

	@Override
	public int planModifyB(int postNo) {
		return td.planModifyB(postNo);
	}

	@Override
	public int planModifyPT(int postNo) {
		return td.planModifyPT(postNo);
	}
	
	@Override
	public int ModifyTag(PostTag tg) {
		return td.ModifyTag(tg);
	}

	@Override
	public int planModifyPost(Board b) {
		return td.planModifyPost(b);
	}

	@Override
	public int planMoidfyPoint(Travel tv) {
		return td.planMoidfyPoint(tv);
	}

	@Override
	public int likeUp(LikedPost lp) {
		return td.likeUp(lp);
	}

	@Override
	public LikedPost likedView(LikedPost lp) {
		return td.likedView(lp);
	}

	@Override
	public int likeUpdate(LikedPost lp) {
		return td.likeUpdate(lp);
	}

	@Override
	public int insertLike(LikedPost lp) {
		return td.insertLike(lp);
	}

	@Override
	public int planDelete(int postNo) {
		return td.planDelete(postNo);
	}

	@Override
	public Vote voteView(Vote v) {
		return td.voteView(v);
	}

	@Override
	public int insertVote(Vote v) {
		return td.insertVote(v);
	}

	@Override
	public int voteUp(Vote v) {
		return td.voteUp(v);
	}

	@Override
	public int VoteUpdate(Vote v) {
		return td.voteUpdate(v);
	}

	@Override
	public MapBoard likeVoteView(Vote v) {
		return td.likeVoteView(v);
	}

	@Override
	public Vote voteView(LikedPost lp) {
		return td.voteView(lp);
	}

	@Override
	public ArrayList<Comments> getComments(Comments cmnt) {
		return td.getComments(cmnt);
	}

	@Override
	public ArrayList<ReComments> getReComments(Comments cmnt) {
		return td.getReComments(cmnt);
	}


}

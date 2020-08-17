package com.kh.FinalProject.review.model.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.FinalProject.review.model.dao.ReviewDao;
import com.kh.FinalProject.travel.model.vo.Board;
import com.kh.FinalProject.travel.model.vo.LikedPost;
import com.kh.FinalProject.travel.model.vo.MapBoard;
import com.kh.FinalProject.travel.model.vo.PageInfo;
import com.kh.FinalProject.travel.model.vo.PostTag;
import com.kh.FinalProject.travel.model.vo.Tag;
import com.kh.FinalProject.travel.model.vo.Travel;

@Service("rs")
public class ReviewServiceImpl implements ReviewService {
	
	@Autowired
	ReviewDao rd;

	@Override
	public int getListCount() {
		return rd.getListCount();
	}

	@Override
	public ArrayList<Board> selectList(PageInfo pi2) {
		return rd.selectList(pi2);
	}

	@Override
	public ArrayList<PostTag> selectListTag() {
		return rd.selectListTag();
	}

	@Override
	public ArrayList<Tag> getTagList() {
		return rd.getTagList();
	}

	@Override
	public int reviewInsert(Board b) {
		return rd.reviewInsert(b);
	}

	@Override
	public int reviewLikeThumbupInsert() {
		return rd.reviewLikeThumbupInsert();
	}

	@Override
	public int insertTag(Tag tg) {
		return rd.insertTag(tg);
	}

	@Override
	public int reviewDayInsert(int i) {
		return rd.reviewDayInsert(i);
	}

	@Override
	public int reviewInsertPoint(Travel tv) {
		return rd.reviewInsertPoint(tv);
	}

	@Override
	public int hitsUp(int postNo) {
		return rd.hitsUp(postNo);
	}

	@Override
	public LikedPost likedView(LikedPost lp) {
		return rd.likedView(lp);
	}

	@Override
	public MapBoard likeVoteView(int postNo) {
		return rd.likeVoteView(postNo);
	}

	@Override
	public Board selectPostView(int postNo) {
		return rd.selectPostView(postNo);
	}

	@Override
	public ArrayList<Travel> selectTravelList(int postNo) {
		return rd.selectTravelList(postNo);
	}

	@Override
	public ArrayList<PostTag> getPostTagList(int postNo) {
		return rd.getPostTagList(postNo);
	}

	@Override
	public Board selectReview(int postNo) {
		return rd.selectReview(postNo);
	}

	@Override
	public int reviewModifyPost(Board b) {
		return rd.reviewModifyPost(b);
	}

	@Override
	public int reviewModifyB(int postNo) {
		return rd.reviewModifyB(postNo);
	}

	@Override
	public int reviewMoidfyPoint(Travel tv) {
		return rd.reviewMoidfyPoint(tv);
	}

	@Override
	public int reviewModifyPT(int postNo) {
		return rd.reviewModifyPT(postNo);
	}

	@Override
	public int ModifyTag(PostTag tg) {
		return rd.ModifyTag(tg);
	}

	@Override
	public int reviewDelete(int postNo) {
		return rd.reviewDelete(postNo);
	}


}

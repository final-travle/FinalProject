package com.kh.FinalProject.review.model.service;

import java.util.ArrayList;

import com.kh.FinalProject.travel.model.vo.Board;
import com.kh.FinalProject.travel.model.vo.LikedPost;
import com.kh.FinalProject.travel.model.vo.MapBoard;
import com.kh.FinalProject.travel.model.vo.PageInfo;
import com.kh.FinalProject.travel.model.vo.PostTag;
import com.kh.FinalProject.travel.model.vo.Tag;
import com.kh.FinalProject.travel.model.vo.Travel;

public interface ReviewService {

	int getListCount();

	ArrayList<Board> selectList(PageInfo pi2);

	ArrayList<PostTag> selectListTag();

	ArrayList<Tag> getTagList();

	int reviewInsert(Board b);

	int reviewLikeThumbupInsert();

	int insertTag(Tag tg);

	int reviewDayInsert(int i);

	int reviewInsertPoint(Travel tv);

	int hitsUp(int postNo);

	LikedPost likedView(LikedPost lp);

	MapBoard likeVoteView(int postNo);

	Board selectPostView(int postNo);

	ArrayList<Travel> selectTravelList(int postNo);

	ArrayList<PostTag> getPostTagList(int postNo);

	Board selectReview(int postNo);

	int reviewModifyPost(Board b);

	int reviewModifyB(int postNo);

	int reviewMoidfyPoint(Travel tv);

	int reviewModifyPT(int postNo);

	int ModifyTag(PostTag tg);

	int reviewDelete(int postNo);

}

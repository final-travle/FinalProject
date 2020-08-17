package com.kh.FinalProject.travel.model.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.kh.FinalProject.travel.model.vo.PageInfo;
import com.kh.FinalProject.travel.model.vo.PostTag;
import com.kh.FinalProject.travel.model.vo.ReComments;
import com.kh.FinalProject.travel.model.vo.Tag;
import com.kh.FinalProject.travel.model.vo.Travel;
import com.kh.FinalProject.travel.model.vo.Vote;
import com.kh.FinalProject.travel.model.vo.Board;
import com.kh.FinalProject.travel.model.vo.Comments;
import com.kh.FinalProject.travel.model.vo.LikedPost;
import com.kh.FinalProject.travel.model.vo.MapBoard;

public interface TravelService {

	int getListCount();

	ArrayList<Board> selectList(PageInfo pi2);

	int planInsert(Board b);

	int planLikeThumbupInsert();

	int planDayInsert(int i);

	int planInsertPoint(Travel tv);

	ArrayList<Tag> getTagList();

	int insertTag(Tag tg);

	ArrayList<PostTag> selectListTag();

	int hitsUp(int postNo);

	Board selectPostView(int postNo);

	ArrayList<Travel> selectTravelList(int postNo);

	MapBoard likeVoteView(LikedPost lp);

	Board selectPlan(int postNo);

	ArrayList<PostTag> getPostTagList(int postNo);

	int planModifyB(int postNo);

	int planModifyPT(int postNo);

	int ModifyTag(PostTag tg);
	
	int planMoidfyPoint(Travel tv);

	int planModifyPost(Board b);
	

	int likeUp(LikedPost lp);
	
	LikedPost likedView(LikedPost lp);

	int likeUpdate(LikedPost lp);

	int insertLike(LikedPost lp);

	int planDelete(int postNo);

	Vote voteView(Vote v);

	int insertVote(Vote v);

	int voteUp(Vote v);

	int VoteUpdate(Vote v);

	MapBoard likeVoteView(Vote v);

	Vote voteView(LikedPost lp);

	ArrayList<Comments> getComments(Comments cmnt);

	ArrayList<ReComments> getReComments(Comments cmnt);

	int insertComment(Comments cmnt);


}

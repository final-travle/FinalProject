package com.kh.FinalProject.common.model.service;

import java.util.ArrayList;

import com.kh.FinalProject.travel.model.vo.Board;
import com.kh.FinalProject.travel.model.vo.PostTag;

public interface MainService {

	ArrayList<Board> selectPlanList();

	ArrayList<PostTag> selectPostTag();

	ArrayList<Board> selectReviewList();

	ArrayList<Board> selectMonthReview();

}

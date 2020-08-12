package com.kh.FinalProject.review.model.service;

import java.util.ArrayList;

import com.kh.FinalProject.travel.model.vo.Board;
import com.kh.FinalProject.travel.model.vo.PageInfo;
import com.kh.FinalProject.travel.model.vo.PostTag;

public interface ReviewService {

	int getListCount();

	ArrayList<Board> selectList(PageInfo pi2);

	ArrayList<PostTag> selectListTag();

}

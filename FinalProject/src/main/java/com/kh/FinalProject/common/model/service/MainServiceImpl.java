package com.kh.FinalProject.common.model.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.FinalProject.common.model.dao.MainDao;
import com.kh.FinalProject.travel.model.vo.Board;
import com.kh.FinalProject.travel.model.vo.PostTag;

@Service("ms")
public class MainServiceImpl implements MainService {
	@Autowired
	MainDao md;

	@Override
	public ArrayList<Board> selectPlanList() {
		return md.selectPlanList();
	}

	@Override
	public ArrayList<PostTag> selectPostTag() {
		return md.selectPostTag();
	}

	@Override
	public ArrayList<Board> selectReviewList() {
		return md.selectReviewList();
	}

	@Override
	public ArrayList<Board> selectMonthReview() {
		return md.selectMonthReview();
	}

}

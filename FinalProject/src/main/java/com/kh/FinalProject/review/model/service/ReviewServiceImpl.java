package com.kh.FinalProject.review.model.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.FinalProject.review.model.dao.ReviewDao;
import com.kh.FinalProject.travel.model.vo.Board;
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

}

package com.kh.FinalProject.travel.model.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.FinalProject.travel.model.vo.PageInfo;
import com.kh.FinalProject.travel.model.vo.Tag;
import com.kh.FinalProject.travel.model.vo.Travel;
import com.kh.FinalProject.travel.model.dao.TravelDao;
import com.kh.FinalProject.travel.model.vo.Board;

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

}

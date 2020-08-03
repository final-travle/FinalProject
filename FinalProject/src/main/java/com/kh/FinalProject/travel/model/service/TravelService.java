package com.kh.FinalProject.travel.model.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.kh.FinalProject.travel.model.vo.PageInfo;
import com.kh.FinalProject.travel.model.vo.Tag;
import com.kh.FinalProject.travel.model.vo.Travel;
import com.kh.FinalProject.travel.model.vo.Board;

public interface TravelService {

	int getListCount();

	ArrayList<Board> selectList(PageInfo pi2);

	int planInsert(Board b);

	int planLikeThumbupInsert();

	int planDayInsert(int i);

	int planInsertPoint(Travel tv);

	ArrayList<Tag> getTagList();

	int insertTag(Tag tg);

}

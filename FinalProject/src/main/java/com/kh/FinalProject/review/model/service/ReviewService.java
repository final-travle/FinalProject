package com.kh.FinalProject.review.model.service;

import java.util.ArrayList;

import com.kh.FinalProject.travel.model.vo.Board;
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

}

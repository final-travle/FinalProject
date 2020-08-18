package com.kh.FinalProject.search.model.service;

import java.util.ArrayList;

import com.kh.FinalProject.search.model.vo.Board;
import com.kh.FinalProject.search.model.vo.Choice;
import com.kh.FinalProject.search.model.vo.PostTag;
import com.kh.FinalProject.search.model.vo.Tag;
import com.kh.FinalProject.travel.model.vo.PageInfo;

public interface SearchService {

	ArrayList<PostTag> selectListTag();


	int getListCount();

	ArrayList<Board> selectList(PageInfo pi2);

	ArrayList<PostTag> selectChoiceList(Choice choice);
	
	ArrayList<Board> selectThumbnail(Choice choice);



}

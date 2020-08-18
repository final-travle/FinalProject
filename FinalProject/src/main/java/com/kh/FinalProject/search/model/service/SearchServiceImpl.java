package com.kh.FinalProject.search.model.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.FinalProject.search.model.dao.SearchDao;
import com.kh.FinalProject.search.model.vo.Board;
import com.kh.FinalProject.search.model.vo.Choice;
import com.kh.FinalProject.search.model.vo.PostTag;
import com.kh.FinalProject.search.model.vo.Tag;
import com.kh.FinalProject.travel.model.vo.PageInfo;

@Service("sService")
public class SearchServiceImpl implements SearchService {
	
	@Autowired 
	SearchDao sDao;

	@Override
	public ArrayList<PostTag> selectChoiceList(Choice choice) {

		return sDao.selectChoiceList(choice);
	}

	@Override
	public ArrayList<PostTag> selectListTag() {

		return sDao.selectListTag();
	}

	@Override
	public int getListCount() {

		return sDao.getListCount();
	}

	@Override
	public ArrayList<Board> selectList(PageInfo pi2) {

		return sDao.selectList(pi2);
	}

	@Override
	public ArrayList<Board> selectThumbnail(Choice choice) {

		return sDao.selectThumbnail(choice);
	}




}

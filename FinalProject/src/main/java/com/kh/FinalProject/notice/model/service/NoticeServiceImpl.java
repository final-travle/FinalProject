package com.kh.FinalProject.notice.model.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.FinalProject.notice.model.dao.NoticeDao;
import com.kh.FinalProject.notice.model.vo.Notice;



@Service("nService")
public class NoticeServiceImpl implements NoticeService {
	
	@Autowired
	NoticeDao nDao;

	@Override
	public int totalCount() {

		return nDao.listCount();
	}

	@Override
	public int insertNotice(Notice n) {
		
		return nDao.insertNotice(n);
	}

	@Override
	public int addReadCount(int postNo) {
	
		return nDao.addReadCount(postNo);
	}

	@Override
	public Notice selectNotice(int postNo) {
	
		return nDao.selectNotice(postNo);
	}

	@Override
	public int updateNotice(Notice n) {

		return nDao.updateNotice(n);
	}

	@Override
	public int deleteNotice(int postNo) {
	
		return nDao.deleteNotice(postNo);
	}


	@Override
	public List<Notice> selectSearch(String keyword) {

		return nDao.searchList(keyword);
	}

	@Override
	public List<Notice> selectList(int startPage, int limit) {

		return nDao.selectList(startPage, limit);
	}

	

	
}

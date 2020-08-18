package com.kh.FinalProject.notice.model.service;


import java.util.ArrayList;
import java.util.List;

import com.kh.FinalProject.notice.model.vo.Notice;


public interface NoticeService {

	int totalCount();

	int insertNotice(Notice n);

	int addReadCount(int postNo);

	Notice selectNotice(int postNo);

	int updateNotice(Notice n);

	int deleteNotice(int postNo);

	List<Notice> selectSearch(String keyword);
	
	List<Notice> selectList(int startPage, int limit);










}

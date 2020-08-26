package com.kh.FinalProject.notice.model.dao;


import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.FinalProject.notice.model.vo.Notice;


@Repository
public class NoticeDao {
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	

	public int listCount() {

		return sqlSessionTemplate.selectOne("noticeMapper.listCount");
	}

	public int insertNotice(Notice n) {
	
		return sqlSessionTemplate.insert("noticeMapper.insertNotice", n);
	}

	public int addReadCount(int postNo) {
	
		return sqlSessionTemplate.update("noticeMapper.updateCount", postNo);
	}

	public Notice selectNotice(int postNo) {

		return sqlSessionTemplate.selectOne("noticeMapper.selectOne", postNo);
	}
	
	public Notice selectNotice2(int postNo) {
		return sqlSessionTemplate.selectOne("noticeMapper.selectOne2", postNo);
	}
	

	public int updateNotice(Notice n) {
			
		return sqlSessionTemplate.insert("noticeMapper.updateNotice", n);
	}

	public int deleteNotice(int postNo) {
		
		return sqlSessionTemplate.update("noticeMapper.deleteNotice", postNo);
	}


	public List<Notice> searchList(String keyword) {

		return sqlSessionTemplate.selectList("noticeMapper.searchList", keyword);
	}

	public List<Notice> selectList(int startPage, int limit) {

		int startRow = (startPage - 1)*limit;
		RowBounds row = new RowBounds(startRow, limit);
		
		return sqlSessionTemplate.selectList("noticeMapper.selectList", null, row);
	}




	
}

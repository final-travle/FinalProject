package com.kh.FinalProject.common.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.FinalProject.common.model.vo.AD;
import com.kh.FinalProject.common.model.vo.PrefStyle;
import com.kh.FinalProject.travel.model.vo.Board;
import com.kh.FinalProject.travel.model.vo.PostTag;

@Repository("md")
public class MainDao {

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public ArrayList<Board> selectPlanList() {
		return (ArrayList) sqlSessionTemplate.selectList("mainMapper.selectPlanList");
	}

	public ArrayList<PostTag> selectPostTag() {
		return (ArrayList) sqlSessionTemplate.selectList("mainMapper.selectPostTag");
	}

	public ArrayList<Board> selectReviewList() {
		return (ArrayList) sqlSessionTemplate.selectList("mainMapper.selectReviewList");
	}

	public ArrayList<Board> selectMonthReview() {
		return (ArrayList) sqlSessionTemplate.selectList("mainMapper.selectMonthReview");
	}

	public ArrayList<PrefStyle> getPrefStyle(String userId) {
		return (ArrayList) sqlSessionTemplate.selectList("mainMapper.getPrefStyle", userId);
	}

	public ArrayList<AD> getAdList(String prefTagName) {
		return (ArrayList) sqlSessionTemplate.selectList("mainMapper.getAdList", prefTagName);
	}

	public ArrayList<AD> getAdList() {
		return (ArrayList) sqlSessionTemplate.selectList("mainMapper.getAdListNull");
	}


}

package com.kh.FinalProject.review.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kh.FinalProject.common.Pagination2;
import com.kh.FinalProject.review.model.service.ReviewService;
import com.kh.FinalProject.travel.model.vo.Board;
import com.kh.FinalProject.travel.model.vo.PageInfo;
import com.kh.FinalProject.travel.model.vo.PostTag;

@Controller
public class ReviewController {

	@Autowired
	ReviewService rs;
	
	@RequestMapping("reviewListView.do")
	public ModelAndView reviewListView(ModelAndView mv, @RequestParam(value="page", required=false) Integer page) {

		int currentPage = 1;
		if(page != null) {
			currentPage = page;
		}
		
		int listCount = rs.getListCount();
		System.out.println(listCount);
		
		PageInfo pi2 = Pagination2.getPageInfo2(currentPage, listCount);
		
		ArrayList<Board> list = rs.selectList(pi2);
		ArrayList<PostTag> tl = rs.selectListTag();
		
		System.out.println(list);
		System.out.println(tl);
		
		return mv;
	}
}

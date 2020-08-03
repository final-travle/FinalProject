package com.kh.FinalProject.common;

import com.kh.FinalProject.travel.model.vo.PageInfo;

public class Pagination2 {
	public static PageInfo getPageInfo2(int currentPage, int listCount) {
		
		PageInfo pi2 = null;
				
		int pageLimit=10;
		int maxPage;
		int startPage;
		int endPage;
		
		int boardLimit=12;
		
		maxPage = (int)((double)listCount/boardLimit+0.9);
		
		startPage = (int)(((double)(currentPage/pageLimit) + 0.9) - 1)*pageLimit + 1;
		
		endPage = startPage + pageLimit - 1;
		
		if(maxPage < endPage) {
			endPage = maxPage;
		}
		
		pi2 = new PageInfo(currentPage, listCount, pageLimit,
				          maxPage, startPage, endPage, boardLimit);
		
		return pi2;
	}

}

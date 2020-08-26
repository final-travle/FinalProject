package com.kh.FinalProject.search.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.FinalProject.search.model.vo.Board;
import com.kh.FinalProject.search.model.vo.Choice;
import com.kh.FinalProject.search.model.vo.PostTag;
import com.kh.FinalProject.search.model.vo.Tag;
import com.kh.FinalProject.travel.model.vo.PageInfo;

@Repository
public class SearchDao {
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	

	public ArrayList<PostTag> selectChoiceList(Choice choice) {
		
		ArrayList<PostTag> returnList = new ArrayList<>();
				
			if(choice.getCity() != null && choice.getMonth() == null && choice.getTheNumber() == null ) {
					
					  returnList = (ArrayList)sqlSessionTemplate.selectList("searchMapper.selectChoiceList", choice);
												
					}else if(choice.getCity() == null && choice.getMonth() != null && choice.getTheNumber() == null ) {
					
					  returnList = (ArrayList)sqlSessionTemplate.selectList("searchMapper.selectChoiceList1", choice);												
				
					}else if(choice.getCity() == null && choice.getMonth() == null && choice.getTheNumber() != null ) {
							
					  returnList = (ArrayList)sqlSessionTemplate.selectList("searchMapper.selectChoiceList2", choice);
						
					}else if(choice.getCity() != null && choice.getMonth() != null && choice.getTheNumber() == null ) {
						
					  returnList = (ArrayList)sqlSessionTemplate.selectList("searchMapper.selectChoiceList3", choice);
												
					}else if(choice.getCity() != null && choice.getMonth() == null && choice.getTheNumber() != null ) {
						
					  returnList = (ArrayList)sqlSessionTemplate.selectList("searchMapper.selectChoiceList4", choice);
												
					}else if(choice.getCity() == null && choice.getMonth() != null && choice.getTheNumber() != null ) {
						
					  returnList = (ArrayList)sqlSessionTemplate.selectList("searchMapper.selectChoiceList5", choice);
												
					}else if(choice.getCity() != null && choice.getMonth() != null && choice.getTheNumber() != null ) {
						
					  returnList = (ArrayList)sqlSessionTemplate.selectList("searchMapper.selectChoiceList6", choice);					
						
					}
			
				return returnList;
			}	
	

	public ArrayList<PostTag> selectListTag() {

		return (ArrayList)sqlSessionTemplate.selectList("searchMapper.selectListTag");
	}

	public int getListCount() {
	
		return sqlSessionTemplate.selectOne("searchMapper.getListCount");
	}




	public ArrayList<Board> selectThumbnail(Choice choice) {
	
		ArrayList<Board> thumbnailList = new ArrayList<>();
		
		if(choice.getCity() != null && choice.getMonth() == null && choice.getTheNumber() == null ) {
			
			thumbnailList = (ArrayList)sqlSessionTemplate.selectList("searchMapper.selectThumbnail", choice);
										
			}else if(choice.getCity() == null && choice.getMonth() != null && choice.getTheNumber() == null ) {
			
				thumbnailList = (ArrayList)sqlSessionTemplate.selectList("searchMapper.selectThumbnail1", choice);												
		
			}else if(choice.getCity() == null && choice.getMonth() == null && choice.getTheNumber() != null ) {
					
				thumbnailList = (ArrayList)sqlSessionTemplate.selectList("searchMapper.selectThumbnail2", choice);
				
			}else if(choice.getCity() != null && choice.getMonth() != null && choice.getTheNumber() == null ) {
				
				thumbnailList = (ArrayList)sqlSessionTemplate.selectList("searchMapper.selectThumbnail3", choice);
										
			}else if(choice.getCity() != null && choice.getMonth() == null && choice.getTheNumber() != null ) {
				
				thumbnailList = (ArrayList)sqlSessionTemplate.selectList("searchMapper.selectThumbnail4", choice);
										
			}else if(choice.getCity() == null && choice.getMonth() != null && choice.getTheNumber() != null ) {
				
				thumbnailList = (ArrayList)sqlSessionTemplate.selectList("searchMapper.selectThumbnail5", choice);
										
			}else if(choice.getCity() != null && choice.getMonth() != null && choice.getTheNumber() != null ) {
				
				thumbnailList = (ArrayList)sqlSessionTemplate.selectList("searchMapper.selectThumbnail6", choice);					
				
			}
	
		return thumbnailList;
		
		
	}

	public ArrayList<PostTag> selectListTag1() {

		return (ArrayList)sqlSessionTemplate.selectList("searchMapper.selectListTag1");
	}


	public ArrayList<Board> selectList(PageInfo pi2) {
	
		int offset = (pi2.getCurrentPage() - 1) * pi2.getBoardLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi2.getBoardLimit());
				
		return (ArrayList)sqlSessionTemplate.selectList("searchMapper.selectList", null, rowBounds);
	}










}

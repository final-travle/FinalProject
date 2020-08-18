/**
 * 
 */
package com.kh.FinalProject.postShared.model.service;

import java.util.ArrayList;

import com.kh.FinalProject.postShared.model.vo.PostShared;
import com.kh.FinalProject.travel.model.vo.Board;
import com.kh.FinalProject.travel.model.vo.PageInfo;
import com.kh.FinalProject.travel.model.vo.PostTag;

/**
 * @author violi
 *
 */


public interface PostSharedService {

	ArrayList<Board> selectList(PageInfo pi2,String id);

	ArrayList<PostTag> selectListTag();

	int SharedInsert(String id, String id2, Integer postNo, String postType);

	ArrayList<PostShared> selectShare(String id);

	Board selectsharedList(PostShared postShared);

	int deleteShared(PostShared ps);

	int getListCount(String id);

	void planDelete(String id, Integer postNo);

	void memberSharedDelete(String id, Integer postNo);

	int getListAllCount();

	ArrayList<Board> selectAllList(PageInfo pi2);

}

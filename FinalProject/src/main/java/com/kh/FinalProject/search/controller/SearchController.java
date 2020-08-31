package com.kh.FinalProject.search.controller;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kh.FinalProject.common.Pagination2;
import com.kh.FinalProject.search.model.service.SearchService;
import com.kh.FinalProject.search.model.vo.Board;
import com.kh.FinalProject.search.model.vo.Choice;
import com.kh.FinalProject.search.model.vo.PostTag;
import com.kh.FinalProject.travel.model.vo.PageInfo;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
public class SearchController {
   
   @Autowired
   SearchService sService;
   
   @RequestMapping("slist.do")
public ModelAndView planListView(ModelAndView mv, @RequestParam(value="page", required=false) Integer page) {
      
      int currentPage = 1;
         if(page != null) {
            currentPage = page;
         }
      
      int listCount = sService.getListCount();
//      System.out.println("탐색 게시판에 존재하는 플랜 게시판 리스트 갯수 : " + listCount);
      
      
      
      ArrayList<Board> list = sService.selectList();
      
      ArrayList<PostTag> tl = sService.selectListTag();
      
      System.out.println("확인-----" + list);

         
      
      if(list != null) {
         mv.addObject("tl", tl);
         mv.addObject("list", list);
         mv.setViewName("search/searchList");
      }else {
         
      }

      
      return mv;
      
   }
   

   
   
   @RequestMapping(value="conditioncheck.do", method=RequestMethod.POST)
     public void conditionCheck(HttpServletResponse response, String city, String month, String theNumber, Choice choice, 
                                Board b) throws Exception{
      choice.setCity(city);
      choice.setMonth(month);
      choice.setTheNumber(theNumber);
      
      
      JSONArray jarr = new JSONArray();

      
      
      System.out.println("city : " + city + ", month : " + month + ", theNumber : " + theNumber);
      
       ArrayList<PostTag> cList = sService.selectChoiceList(choice);
       System.out.println("라디오 버튼에서 선택된 해당 결과값들 : " + choice);
       
       
       System.out.println("cList : " + cList);
       System.out.println("-----------------------------------------");
       
       
       ArrayList<Board> bList = sService.selectThumbnail(choice);
       System.out.println("bList : " + bList);
       
       ArrayList<PostTag> tl1 = sService.selectListTag1();
       
       System.out.println(tl1);
       
       jarr.add(bList);
       jarr.add(tl1);
          
       response.setContentType("application/json;charset=utf-8");
        
       Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
       gson.toJson(jarr, response.getWriter());
      



             
   }

}   
       


         





   
       

       
              

                
 
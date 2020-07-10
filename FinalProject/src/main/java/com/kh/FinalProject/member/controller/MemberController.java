package com.kh.FinalProject.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.FinalProject.member.model.exception.MemberException;
import com.kh.FinalProject.member.model.service.MemberService;
import com.kh.FinalProject.member.model.vo.Member;
import com.kh.FinalProject.member.model.vo.Ttype;

import net.sf.json.JSONObject;






@Controller
public class MemberController {
	
	@Autowired
	private MemberService mService;
	
	@RequestMapping("minsert.do")
	public String memberInsert(HttpServletRequest request, Model model) {
		Member m = new Member(request.getParameter("id"),
							  request.getParameter("pwd"),
							  request.getParameter("name"),
							  request.getParameter("nicname"),
							  request.getParameter("year")+request.getParameter("mon")+request.getParameter("day"),
							  request.getParameter("sex"),
							  request.getParameter("job"),
							  request.getParameter("email"),
							  request.getParameter("phone"),
							  "N");
		
		System.out.println(m);
		int result = mService.insertMember(m);
		Ttype tp = new Ttype();
		// 이제 서비스로 넘기자
		int result2 = 0;
		
		for(int i=0; i<request.getParameterValues("tType").length;i++) {
			result2+=mService.insertTtype(request.getParameter("id"),request.getParameterValues("tType")[i],tp);
			}
		
		
		if(result>0 &&result2 > 0) {
			
			return "member/login";				
		}else {
			throw new MemberException("회원 가입 실패!");
		}
		
	}
	
	@RequestMapping("mlogin.do")
	public String memberLogin(Member m, Model model) {
		System.out.println(m);
		Member loginUser = mService.loginMember(m);
		System.out.println(loginUser);
		if(loginUser != null) {
			model.addAttribute("loginUser",loginUser);
			return "home";
		}else {
			throw new MemberException("로그인 실패!");
			// 예외를 발생시켜서 에러페이지로 넘어갈 껀데
		// 우선 예외 클래스는 RuntimeException을 상속받자
			// 그리고 나면 예외가 발생했을 때 common에 있는 errorPage에서
			// 처리를 할 수 있도록 web.xml에 공용 에러 페이지를 등록하
			// web.xml 고고씽
		}
	}
	
		
		@RequestMapping("membersearchPwd.do")
		public String membersearchPwd(Member m, Model model) {
		
		
		System.out.println(m);
		
		// 이제 서비스로 넘기자
		Member result = mService.searchPwd(m);
		
		System.out.println(result);
			
			if(result != null) {
				model.addAttribute("loginUser",result);
				return "member/searchResultPwd";
			}else {
				throw new MemberException("로그인 실패!");
				
			}
		
		
	}
		
		
			
		@RequestMapping("membersearchId.do")
		public String membersearchId(Member m, Model model) {
		
		
		System.out.println(m);
		
		// 이제 서비스로 넘기자
		Member result = mService.searchId(m);
		
		System.out.println(result);
			
			if(result != null) {
				model.addAttribute("loginUser",result);
				return "member/searchResultId";
			}else {
				throw new MemberException("로그인 실패!");
				
			}
		
		
	}
		@RequestMapping("mchange.do")	
		public String mchange(Member m, Model model) {
			
			
			System.out.println(m);
			
			// 이제 서비스로 넘기자
			int result = mService.change(m);
			
			System.out.println(result);
				
				if(result > 0) {
					model.addAttribute("result",result);
					return "home";
				}else {
					throw new MemberException("로그인 실패!");
					
				}
			
			
		}
		
	    @RequestMapping("dupid.do")
	      public void idDuplicateCheck(String id, HttpServletResponse response) throws IOException{
	        JSONObject map = new  JSONObject();
	         
	          
	         int count = mService.checkIdDup(id);
	         System.out.println(count);
	         map.put("isUsable",count);
	         
	       
	         PrintWriter out = response.getWriter();
	 		
	 		out.print(map);
	 		out.flush();
	 		out.close();
	         
	         
	      }
	    
	    
	    
	    @RequestMapping(value="logout.do", method=RequestMethod.GET)
		public String logout(HttpSession session){
		session.invalidate();
			
			return "index";
		}
	   
		
}

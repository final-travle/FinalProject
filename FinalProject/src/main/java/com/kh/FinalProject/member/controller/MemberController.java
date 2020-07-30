package com.kh.FinalProject.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.kh.FinalProject.common.Pagination;
import com.kh.FinalProject.member.model.exception.MemberException;
import com.kh.FinalProject.member.model.service.MemberService;
import com.kh.FinalProject.member.model.vo.Friends;
import com.kh.FinalProject.member.model.vo.Member;
import com.kh.FinalProject.member.model.vo.PageInfo;
import com.kh.FinalProject.member.model.vo.Ttype;

import net.sf.json.JSONObject;


@SessionAttributes("loginUser")



@Controller
public class MemberController {
	
	@Autowired
	private MemberService mService;
	
	@RequestMapping("minsert.do")
	public String memberInsert(HttpServletRequest request, Model model) {
		Member m = new Member(request.getParameter("id"),
							  request.getParameter("pwd"),
							  request.getParameter("name"),
							  request.getParameter("nickname"),
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
		}
	}
	
		
		@RequestMapping("membersearchPwd.do")
		public String membersearchPwd(Member m, Model model) {
		
		
		System.out.println(m);
		
		// 이제 서비스로 넘기자
		Member result = mService.searchPwd(m);
		
		System.out.println(result);
			
			if(result != null) {
				model.addAttribute("result",result);
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
				model.addAttribute("result",result);
				return "member/searchResultId";
			}else {
				throw new MemberException("로그인 실패!");
				
			}
		
		
	}
		
		
		@RequestMapping("memberChange.do")
		public String memberChange(Model model,HttpSession session) {
			
			Member mb = (Member) session.getAttribute("loginUser");
			Member loginUser = mService.loginMember(mb);
			System.out.println(loginUser);
			if(loginUser != null) {
				model.addAttribute("member",loginUser);
				return "mypageChange";
			}else {
				throw new MemberException("로그인 실패!");
			}
		}
		@RequestMapping("mchange.do")	
		public String mchange(Member m, Model model,HttpSession session) {
			
			
			System.out.println(m);
			Member mb = (Member) session.getAttribute("loginUser");// 여기해야됨
			// 이제 서비스로 넘기자
			int result = mService.change(m);
			
			System.out.println(result);
				
				if(result > 0) {
					model.addAttribute("result",result);
					return "mypageChange";
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
		public String logout(SessionStatus status){
		status.setComplete();
			
			return "home";
		}
	   
	    @RequestMapping("friends.do")
		public ModelAndView friends(ModelAndView model ,HttpSession session,
													   @RequestParam(value="page",required=false) Integer page,String noticeSearch,
													   @RequestParam(value="search", required=false) String search) {
		
			Member m = (Member) session.getAttribute("loginUser");
			
			
			System.out.println("search : " +search);
			String Search = noticeSearch;
			if(Search != null ||Search!="") {
				model.addObject("search", Search);	
		    }
			 if(noticeSearch==null ||noticeSearch=="") {
		    	 Search = search;
		    }
		   
			
			
//			System.out.println(listCount);
			int currentPage = 1;
			if(page != null) {
				currentPage = page;
			}
			int listCount = mService.getListCount(Search,m.getId());
			System.out.println("listCount"+listCount);
			PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
			System.out.println(pi);

			ArrayList<Friends> fal = mService.friends(m.getId(),Search,pi); //내가 db에 내가 들어있는 친구 목록을 다뽑아옴
			ArrayList<String> al = new ArrayList<String>();//목록중 친구이름을 다뽑아옴
			
			
			
			for(int i=0;i<fal.size();i++) {
				if(fal.get(i).getfId().equals(m.getId())) {
					al.add(fal.get(i).getUserId());
				}else if(fal.get(i).getUserId().equals(m.getId())) {
					al.add(fal.get(i).getfId());
				}
			}
			System.out.println("aaaa"+al);
			ArrayList<Member> mal =new ArrayList<Member>();
			
			for(int i =0;i<al.size();i++) {
				System.out.println("!!");
				mal.add(mService.friendsInfo(al.get(i)));
			}
			
			if(mal != null) {
				
				model.addObject("listCount",listCount);
				model.addObject("friends",mal);
				model.addObject("pi",pi);
				model.setViewName("/member/friends");
				
			}
			return model;
		
		
	}
	 
	    
	    @RequestMapping("friendsadd.do")
		public ModelAndView friendsadd(ModelAndView model ,HttpSession session,@RequestParam(value="page",
				required=false) Integer page,String noticeSearch,@RequestParam(value="search", required=false) String search) {
		
			Member m = (Member) session.getAttribute("loginUser");
			
	    	String Search = noticeSearch;
			if(Search != null || Search!="") {
				model.addObject("search", Search);	
		    }
			 if(noticeSearch==null ||Search=="") {
		    	 Search = null;
		    }
			 System.out.println(Search);
			 int currentPage = 1;
				if(page != null) {
					currentPage = page;
				}
			int listCount = mService.getaddListCount(Search,m.getId());
			System.out.println("listCount : "+listCount);
			PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
			System.out.println(pi);
			ArrayList<Member> mb = mService.allMember(m.getId(),Search,pi);//자기 자신을 제외한 나머지 회원을 불러옴
			ArrayList<Friends> fal = mService.friends(m.getId()); //내가 db에 내가 들어있는 친구 목록을 다뽑아옴
			ArrayList<String> al = new ArrayList<String>();//목록중 친구이름을 다뽑아옴
			
			
			System.out.println("ffff"+fal);
			for(int i=0;i<fal.size();i++) {
				if(fal.get(i).getfId().equals(m.getId())) {
					al.add(fal.get(i).getUserId());
				}else if(fal.get(i).getUserId().equals(m.getId())) {
					al.add(fal.get(i).getfId());
				}
			}
			
			
			
			
			System.out.println("aaaa"+al);
		
			if(mb != null) {
				model.addObject("listCount",listCount);
				model.addObject("allmember",mb);
				model.addObject("allfriends",al);
				model.setViewName("/member/friendsadd");
				model.addObject("pi",pi);
			}
			return model;				
	}    
	    
	    
	        @RequestMapping("hansolhansol.do")
	    		public ModelAndView hansolhansol(ModelAndView model,HttpServletResponse response,HttpSession session,String id) throws IOException {
	    		
	    			Member m = (Member) session.getAttribute("loginUser");
	        	
					System.out.println(id);
				
	        		
	        		int count = mService.addFriends(id,m.getId());
	        		ArrayList<Member> mb = mService.allMember(m.getId());//자기 자신을 제외한 나머지 회원을 불러옴
	    			ArrayList<Friends> fal = mService.friends(m.getId()); //내가 db에 내가 들어있는 친구 목록을 다뽑아옴
	    			ArrayList<String> al = new ArrayList<String>();//목록중 친구이름을 다뽑아옴
	    			
	    			
	    			System.out.println("ffff"+fal);
	    			for(int i=0;i<fal.size();i++) {
	    				if(fal.get(i).getfId().equals(m.getId())) {
	    					al.add(fal.get(i).getUserId());
	    				}else if(fal.get(i).getUserId().equals(m.getId())) {
	    					al.add(fal.get(i).getfId());
	    				}
	    			}
	    			
	    		
	        		if(count >0) {
	        			model.addObject("allmember",mb);
	    				model.addObject("allfriends",al);
	    				model.setViewName("/member/friendsadd");
	    						
	    			}
	    			return model;   	        				
	    	}
	        
	        @RequestMapping("okfriends.do")
    		public ModelAndView okfriends(ModelAndView model,HttpSession session,String id) throws IOException {
					
	        	Member m = (Member) session.getAttribute("loginUser");	
				ArrayList<Friends> fal = mService.friendsadd(id,m.getId());
				String Search =null;//내가 db에 내가 들어있는 친구 목록을 다뽑아
				int listCount = mService.getListCount(Search,m.getId());
				if(fal != null) {
					model.addObject("listCount",listCount);
					model.addObject("falll",fal);
					model.setViewName("/member/accfriends");
					
				}
				return model;   	        				
    	}
	        
	        @RequestMapping("accfriends.do")
    		public ModelAndView accfriends(ModelAndView model,HttpServletResponse response,HttpSession session,String id) throws IOException {
    		String Search=null;
    			Member m = (Member) session.getAttribute("loginUser");
    			int listCount = mService.getListCount(Search,m.getId());
	        	System.out.println(id);
				int fal = mService.accfriends(m.getId(),id); //내가 db에 내가 들어있는 친구 목록을 다뽑아 asde자리가 로그인을 한 사람의 아이디임
				ArrayList<Friends> fall = mService.friendsadd(id,m.getId());
				System.out.println(fall);
				System.out.println(fal);
				if(fal > 0) {
					System.out.println("하 사위벌");
					model.addObject("listCount",listCount);
					model.addObject("falll",fall);
					model.setViewName("/member/accfriends");
					
				}
				return model;   	        				
    	}
	        
	        
	        
	            @RequestMapping("dltfriends.do")
    		public ModelAndView dltfriends(ModelAndView model,HttpServletResponse response,HttpSession session,String id) throws IOException {
    		
    			Member m = (Member) session.getAttribute("loginUser");
	        	System.out.println(id);
				int fal = mService.dltfriends(m.getId(),id); //내가 db에 내가 들어있는 친구 목록을 다뽑아 asde자리가 로그인을 한 사람의 아이디임
				ArrayList<Friends> fall = mService.friendsadd(id,m.getId());
				System.out.println(fall);
				System.out.println(fal);
				if(fal > 0) {
					System.out.println("하 사위벌");
					model.addObject("falll",fall);
					model.setViewName("/member/accfriends");
					
				}
				return model;   	        				
    	}
}

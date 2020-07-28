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
import com.kh.FinalProject.member.model.vo.Time;
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
	public String memberLogin(Member m, Model model,HttpServletResponse response) throws IOException {
		System.out.println(m);
		Member loginUser = mService.loginMember(m);
		
		int timeupdate =mService.loginTime(m.getId());
		int success =0;
		if(timeupdate<1) { //업데이트할게없으면 인서트해라
		success=mService.setloginTime(m.getId());
		}
		
		System.out.println("성공"+success);
		//시간 넣는것  update
		
		System.out.println(loginUser);
		if(loginUser != null) {
			model.addAttribute("loginUser",loginUser);
			return "home";
		}else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('정보를 확인해주세요.'); </script>");
			out.flush();
			return "member/login";
		}
	}
	
		
		@RequestMapping("membersearchPwd.do")
		public String membersearchPwd(Member m, Model model,HttpServletResponse response) throws IOException {
		
		
		System.out.println(m);
		
		// 이제 서비스로 넘기자
		Member result = mService.searchPwd(m);
		
		System.out.println(result);
			
			if(result != null) {
				model.addAttribute("result",result);
				return "member/searchResultPwd";
			}else {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('정보를 확인해주세요.'); </script>");
				out.flush();
				return "member/searchPwd";
			}
		
		
	}
		
		
			
		@RequestMapping("membersearchId.do")
		public String membersearchId(Member m, Model model,HttpServletResponse response) throws IOException {
		
		
		System.out.println(m);
		
		// 이제 서비스로 넘기자
		Member result = mService.searchId(m);
		
		System.out.println(result);
			
			if(result != null) {
				model.addAttribute("result",result);
				return "member/searchResultId";
			}else {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('정보를 확인해주세요.'); </script>");
				out.flush();
				return "member/searchId";
				
			}
		
		
	}
		
		
		@RequestMapping("memberChange.do")
		public String memberChange(Model model,HttpSession session,HttpServletResponse response) throws IOException {
			
			Member mb = (Member) session.getAttribute("loginUser");
			Member loginUser = mService.loginMember(mb);
			int fCount = mService.fCount(mb.getId());
			System.out.println(loginUser);
			if(loginUser != null) {
				model.addAttribute("member",loginUser);
				model.addAttribute("fCount",fCount);
				return "member/mypageChange";
			}else {
				model.addAttribute("member",mb);
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('정보를 확인해주세요.'); </script>");
				out.flush();
				model.addAttribute("fCount",fCount);
				return "member/mypageChange";
				
			}
		}
		@RequestMapping("mchange.do")	
		public String mchange(Member m, Model model,HttpSession session,HttpServletRequest request,HttpServletResponse response) throws IOException {
			
			
			System.out.println(m);
			Member mb = (Member) session.getAttribute("loginUser");// 여기해야됨
			// 이제 서비스로 넘기자
			Ttype tp = new Ttype();
			m.setBirth(request.getParameter("year")+request.getParameter("mon")+request.getParameter("day"));
			int result = mService.change(m,mb);
			mService.deleteTtype(mb.getId());
			int fCount = mService.fCount(mb.getId());
			for(int i=0; i<request.getParameterValues("tType").length;i++) {
				mService.insertTtype(mb.getId(),request.getParameterValues("tType")[i],tp);
				}
			System.out.println(result);
				if(result > 0) {
					model.addAttribute("result",result);
					model.addAttribute("fCount",fCount);
					return "home";
				}else {
					model.addAttribute("member",mb);
					model.addAttribute("fCount",fCount);
					response.setContentType("text/html; charset=UTF-8");
					PrintWriter out = response.getWriter();
					out.println("<script>alert('정보를 확인해주세요.'); </script>");
					out.flush();
					return "member/mypageChange";			
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
		public String logout(HttpSession session,SessionStatus status){
	    	Member m = (Member) session.getAttribute("loginUser");

	    	int a =mService.logoutTime(m.getId());
			
			
			
			status.setComplete();
			
			return "home";
		}
	   
	    @RequestMapping("friends.do")
		public ModelAndView friends(ModelAndView model ,HttpSession session,@RequestParam(value="page",
							required=false) Integer page,String noticeSearch,@RequestParam(value="search", required=false) String search) {
			Member m = (Member) session.getAttribute("loginUser");
			System.out.println("search : " +search);
			String Search = noticeSearch;
			if(Search != null ||Search!="") {
				model.addObject("search", Search);	
		    }
			 if(noticeSearch==null ||noticeSearch=="") {
		    	 Search = search;
		    }
			 int currentPage = 1;
			if(page != null) {
				currentPage = page;
			}
			int listCount = mService.getListCount(Search,m.getId());
			int fCount = mService.fCount(m.getId());
			System.out.println("listCount"+listCount);
			PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
			System.out.println(pi);
			ArrayList<Friends> fal = mService.realfriends(m.getId(),Search,pi); //내가 db에 내가 들어있는 친구 목록을 다뽑아옴
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
				mal.add(mService.friendsInfo(al.get(i)));
			}
			System.out.println("mal : "+mal);
			ArrayList<Integer> time = new ArrayList<Integer>();
			ArrayList<Integer> logintime = new ArrayList<Integer>();
			ArrayList<String> timeresult = new ArrayList<String>();
			for(int i=0;i<mal.size();i++) {
				time.add(mService.friendsTime(mal.get(i).getId()));
				logintime.add(mService.friendsLoginTime(mal.get(i).getId())); //로그아웃시간 - 로그인시간
			}
			System.out.println(logintime);
			for(int i=0;i<time.size();i++) {
				if(logintime.get(i)>=0) {
					if(time.get(i)>=518400) {
						timeresult.add("1년이상");
					}
					if(518400>time.get(i)&&time.get(i)>=43200) {
						timeresult.add("한달이상");
					}
					if(43200>time.get(i)&&time.get(i)>=1440) {
						String day =String.valueOf((time.get(i)/1440));
						timeresult.add(day+"일이상");
					}
					if(1440>time.get(i) && time.get(i)>=60) {
						String hour =String.valueOf((time.get(i)/60));
						timeresult.add(hour+"시간이상");
					}
					if(60>time.get(i)&& time.get(i)>4) {
						String min =String.valueOf(time.get(i));
						timeresult.add(min+"분이상");
					}
					
					if(time.get(i)==0||time.get(i)<=4){
							timeresult.add("최근까지 접속");
					}
					if(time.get(i)==null) {
						timeresult.add("접속기록없음");
					}
				}else {
					timeresult.add("온라인");
				}
			}
			if(mal.size()==timeresult.size()) {
				for(int i =0;i<mal.size();i++) {
					mal.get(i).setTime(timeresult.get(i));	
				}
				
			}
			
				model.addObject("listCount",listCount);
				model.addObject("fCount",fCount);
				model.addObject("friends",mal);
				model.addObject("pi",pi);
				model.setViewName("/member/friends");
			
			return model;
		
		
	}
	 
	    
	    @RequestMapping("friendsadd.do")
		public ModelAndView friendsadd(ModelAndView model ,HttpSession session,@RequestParam(value="page",
				required=false) Integer page,String noticeSearch,@RequestParam(value="search", required=false) String search) {
		
			Member m = (Member) session.getAttribute("loginUser");
			int fCount = mService.fCount(m.getId());
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
			ArrayList<Friends> al = new ArrayList<Friends>();//목록중 친구이름을 다뽑아옴
	
			
			System.out.println("ffff"+fal);
			for(int i=0;i<fal.size();i++) {
				if(fal.get(i).getfId().equals(m.getId())) {
					Friends fs = new Friends();
					fs.setAcceptYn(fal.get(i).getAcceptYn());
					fs.setUserId(fal.get(i).getfId());
					al.add(fs);
				}else if(fal.get(i).getUserId().equals(m.getId())) {
					Friends fs = new Friends();
					fs.setAcceptYn(fal.get(i).getAcceptYn());
					fs.setUserId(fal.get(i).getfId());
					al.add(fs);
				}
			}
			
			
			
			
			System.out.println("aaaa"+al);
		
			if(mb != null) {
				model.addObject("fCount",fCount);
				model.addObject("listCount",listCount);
				model.addObject("allmember",mb);
				model.addObject("allfriends",al);
				model.setViewName("/member/friendsadd");
				model.addObject("pi",pi);
			}
			return model;				
	}    
	    
	    
	        @RequestMapping("hansolhansol.do")
	    		public String hansolhansol(ModelAndView model,HttpServletResponse response,HttpSession session,String id) throws IOException {
	    			//받아온 아이디가 상대쪽아이디
	    			Member m = (Member) session.getAttribute("loginUser");
	    			
					System.out.println(id);
				
	        		
	        		int count = mService.addFriends(id,m.getId()); //친구 요청보냄
	    		
	        		if(count >0) {
	        			return "redirect:/friendsadd.do";			
	    			}else {
						response.setContentType("text/html; charset=UTF-8");
						PrintWriter out = response.getWriter();
						out.println("<script>alert('정보를 확인해주세요.'); </script>");
						out.flush();
						return "member/friendsadd?id"+id;
					}
	    			   	        				
	    	}
	        
	        @RequestMapping("okfriends.do")
    		public ModelAndView okfriends(ModelAndView model,HttpSession session,String id) throws IOException {
					
	        	Member m = (Member) session.getAttribute("loginUser");
	        	int fCount = mService.fCount(m.getId());
				ArrayList<Friends> fal = mService.friendsadd(id,m.getId());
				String Search =null;//내가 db에 내가 들어있는 친구 목록을 다뽑아
				int listCount = mService.getListCount(Search,m.getId());
				if(fal != null) {
					model.addObject("listCount",listCount);
					model.addObject("falll",fal);
					model.addObject("fCount",fCount);
					model.setViewName("/member/accfriends");
					
				}
				return model;   	        				
    	}
	        
	        @RequestMapping("accfriends.do")
    		public ModelAndView accfriends(ModelAndView model,HttpServletResponse response,HttpSession session,String id) throws IOException {
    		String Search=null;
    			Member m = (Member) session.getAttribute("loginUser");
    			int fCount = mService.fCount(m.getId());
    			int listCount = mService.getListCount(Search,m.getId());
	        	System.out.println(id);
				int fal = mService.accfriends(m.getId(),id); //내가 db에 내가 들어있는 친구 목록을 다뽑아 asde자리가 로그인을 한 사람의 아이디임
				ArrayList<Friends> fall = mService.friendsadd(id,m.getId());
				System.out.println(fall);
				System.out.println(fal);
				if(fall != null) {
					System.out.println("하 사위벌");
					model.addObject("fCount",fCount);
					model.addObject("listCount",listCount);
					model.addObject("falll",fall);
					model.setViewName("/member/accfriends");
				}else {
					
					response.setContentType("text/html; charset=UTF-8");
					PrintWriter out = response.getWriter();
					out.println("<script>alert('받은 요청이 없습니다.'); </script>");
					out.flush();
					model.setViewName("/member/accfriends");
			
					
				}
			
				return model;   	        				
    	}
	        
	        
	        
	            @RequestMapping("dltaccfriends.do")
    		public ModelAndView dltaccfriends(ModelAndView model,HttpServletResponse response,HttpSession session,String id) throws IOException {
    		
    			Member m = (Member) session.getAttribute("loginUser");
    			int fCount = mService.fCount(m.getId());
				int fal = mService.dltfriends(m.getId(),id); //내가 db에 내가 들어있는 친구 목록을 다뽑아 asde자리가 로그인을 한 사람의 아이디임
				ArrayList<Friends> fall = mService.friendsadd(id,m.getId());
				System.out.println(fall);
				System.out.println(fal);
				if(fal > 0) {
					System.out.println("하 사위벌");
					model.addObject("falll",fall);
					model.addObject("fCount",fCount);
					model.setViewName("/member/accfriends");
					
				}
				return model;   	        				
    	}
	            @RequestMapping("dltmember.do") //회원 탈퇴
	    		public String dltmember(ModelAndView model,HttpServletResponse response,HttpSession session,String pwd) throws IOException {
	    		
	    			Member m = (Member) session.getAttribute("loginUser");
	    			int fCount = mService.fCount(m.getId());
	    			int fal = 0;
	    			
	    			if(m.getPwd().equals(pwd)) {
	    			fal = mService.dltmember(m.getId(),pwd);	
	    			} 
					if(fal > 0) {
						mService.dltmemberfriends(m.getId());
						mService.dltTime(m.getId());
						model.addObject("fCount",fCount);
						System.out.println("하 사위벌");
						return "logout.do";
					}else {
						model.addObject("fCount",fCount);
						return "mypageDelete.do";
					}
					   	        				
	    	}
	            @RequestMapping("mypageDelete.do") //회원 탈퇴
	    		public String mypageDelete(ModelAndView model,HttpServletResponse response,HttpSession session,String pwd) throws IOException {
	    		
	            	Member m = (Member) session.getAttribute("loginUser");
	    			int fCount = mService.fCount(m.getId());
	    			

						model.addObject("fCount",fCount);
						return "member/mypageDelete";		   	        				
	    	}
	        
	            @RequestMapping("refusefriends.do") //친구신청거절
	    		public ModelAndView refusefriends(ModelAndView model,HttpServletResponse response,HttpSession session,String id) throws IOException {
	    		
	    			Member m = (Member) session.getAttribute("loginUser");
					int fal = mService.refusefriends(m.getId(),id); //내가 db에 내가 들어있는 친구 목록을 다뽑아 asde자리가 로그인을 한 사람의 아이디임
					ArrayList<Friends> fall = mService.friendsadd(id,m.getId());
					int fCount = mService.fCount(m.getId());
					System.out.println(fall);
					System.out.println(fal);
					if(fal > 0) {
						System.out.println("하 사위벌");
						model.addObject("falll",fall);
						model.addObject("fCount",fCount);
						model.setViewName("/member/accfriends");
						
					}
					return model;   	        				
	    	}
	    
	          
	            @RequestMapping("adminMember.do")
	    		public ModelAndView adminMember(ModelAndView model ,HttpSession session,@RequestParam(value="page",
	    				required=false) Integer page,String noticeSearch,@RequestParam(value="search", required=false) String search) {
	    		
	    			Member m = (Member) session.getAttribute("loginUser");
	    			int fCount = mService.fCount(m.getId());
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
	    		
	    			if(mb != null) {
	    				model.addObject("fCount",fCount);
	    				model.addObject("listCount",listCount);
	    				model.addObject("allmember",mb);
	    				model.setViewName("/member/adminMember");
	    				model.addObject("pi",pi);
	    			}
	    			return model;				
	    	}   
	            
	            
	            @RequestMapping("adminMemberDelete.do")
	    		public String adminMemberDelete(ModelAndView model,HttpServletResponse response,HttpSession session,String id) throws IOException {
	        		System.out.println(id);
	        		int count = mService.adminMemberDelete(id); //친구 요청보냄
	        		mService.dltmemberfriends(id);
	        		mService.dltTime(id);
	        		if(count >0) {
	        			return "redirect:/adminMember.do";			
	    			}else {
						response.setContentType("text/html; charset=UTF-8");
						PrintWriter out = response.getWriter();
						out.println("<script>alert('정보를 확인해주세요.'); </script>");
						out.flush();
						return "member/friendsadd?id"+id;
					}
	    			   	        				
	    	}
	            
	            @RequestMapping("adminMemberinfo.do")
	    		public ModelAndView adminMemberinfo(ModelAndView model,HttpServletResponse response,HttpSession session,String id) throws IOException {
	        		Member m = mService.memberinfo(id);
	        		ArrayList<String> als = mService.memberinfoType(id);
	        		//여기해야됨
	        		String a = "";
	        		for(int i =0; i<als.size();i++) {
	        			a+=als.get(i);
	        			a+=", ";
	        		}
	        		model.addObject("member",m);
	        		model.addObject("type",a);
    				model.setViewName("/member/adminMemberinfo");
	            	return model;
	    	}    
}

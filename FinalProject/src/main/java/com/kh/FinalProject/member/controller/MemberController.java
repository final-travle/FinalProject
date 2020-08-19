package com.kh.FinalProject.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

import javax.inject.Inject;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
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
public class MemberController  {
	
	
	@Inject    //서비스를 호출하기 위해서 의존성을 주입
    JavaMailSender mailSender;  
	
	
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
	
		Member loginUser = mService.loginMember(m);
		
		int timeupdate =mService.loginTime(m.getId());
		int success =0;
		if(timeupdate<1) { //업데이트할게없으면 인서트해라
		success=mService.setloginTime(m.getId());
		}
		
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
		
		
		// 이제 서비스로 넘기자
		Member result = mService.searchPwd(m);
		
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
		
		
		
		
		
		@RequestMapping( value = "auth.do" , method=RequestMethod.POST )
        public ModelAndView mailSending(HttpServletRequest request, Member m, HttpServletResponse response_email) throws IOException {
 
            Random r = new Random();
            int dice = r.nextInt(4589362) + 49311; //이메일로 받는 인증코드 부분 (난수)
            
            int count = mService.membercount(m);
            
            if(count>0) {
            String setfrom = "violin7665@gamil.com";
            String tomail = m.getEmail(); // 받는 사람 이메일
            String title = "비밀번호 찾기 인증 이메일 입니다."; // 제목
            String content =
            
            System.getProperty("line.separator")+ //한줄씩 줄간격을 두기위해 작성
            
            System.getProperty("line.separator")+
                    
            "안녕하세요 회원님 저희 I RE VIEW를 찾아주셔서 감사합니다"
            
            +System.getProperty("line.separator")+
            
            System.getProperty("line.separator")+
    
            " 인증번호는 " +dice+ " 입니다. "
            
            +System.getProperty("line.separator")+
            
            System.getProperty("line.separator")+
            
            "받으신 인증번호를 홈페이지에 입력해 주시면 다음으로 넘어갑니다."; // 내용
            
            
            try {
                MimeMessage message = mailSender.createMimeMessage();
                MimeMessageHelper messageHelper = new MimeMessageHelper(message,
                        true, "UTF-8");
 
                messageHelper.setFrom(setfrom); // 보내는사람 생략하면 정상작동을 안함
                messageHelper.setTo(tomail); // 받는사람 이메일
                messageHelper.setSubject(title); // 메일제목은 생략이 가능하다
                messageHelper.setText(content); // 메일 내용 
                mailSender.send(message);
                
            } catch (Exception e) {
                System.out.println(e);
            }
            
            ModelAndView mv = new ModelAndView();    //ModelAndView로 보낼 페이지를 지정하고, 보낼 값을 지정한다.
            mv.setViewName("/member/email");     //뷰의이름
            mv.addObject("dice", dice);
            mv.addObject("member",mService.searchPwd(m));
            
 
            response_email.setContentType("text/html; charset=UTF-8");
            PrintWriter out_email = response_email.getWriter();
            out_email.println("<script>alert('이메일이 발송되었습니다. 인증번호를 입력해주세요.');</script>");
            out_email.flush();
            
            
            return mv;
            }else {
            	ModelAndView mv = new ModelAndView();    //ModelAndView로 보낼 페이지를 지정하고, 보낼 값을 지정한다.
                mv.setViewName("/member/searchPwd");
            	response_email.setContentType("text/html; charset=UTF-8");
                PrintWriter out_email = response_email.getWriter();
                out_email.println("<script>alert('아이디와 이메일이 일치하지 않습니다.');</script>");
                out_email.flush();
                
                
                return mv;
            	
            } 
        }
		
		
	    @RequestMapping(value = "hansolyy.do", method = RequestMethod.GET, produces="text/plain;charset=UTF-8")
	    @ResponseBody
		public String friendsNameSearch(Locale locale,Model model ,HttpSession session,
													   @RequestParam(value="page",required=false) Integer page,String noticeSearch,
													   @RequestParam(value="search", required=false) String search) {
	 
	    	
	    	Member m = (Member) session.getAttribute("loginUser");
	    	ArrayList<Friends> fal = mService.rlfriends(m.getId()); //내가 db에 내가 들어있는 친구 목록을 다뽑아옴(왼쪽에 내 아이디면 오른쪽 컬럼값 오른쪽 내아이디면 왼쪽컬럼)
			ArrayList<String> al = new ArrayList<String>();//목록중 친구아이디을 다뽑아옴
			for(int i=0;i<fal.size();i++) {
				if(fal.get(i).getfId().equals(m.getId())) {//친구 아이디 컬럼에 로그인된 아이디랑 같으면 userid에 있는 것을 가져와라
					al.add(fal.get(i).getUserId());
				}else if(fal.get(i).getUserId().equals(m.getId())) {//userId 컬럼와 로그인된 아이디가 같으면 fid에있는것을 al에 넣어라
					al.add(fal.get(i).getfId());
				}
			}
			ArrayList<Member> mal =new ArrayList<Member>(); //친구의 member 정보값 이거 이용
			for(int i =0;i<al.size();i++) {
				mal.add(mService.friendsInfo(al.get(i)));
			}
			String[] array = new String[mal.size()]; //친구 이름 담김
			for(int i =0; i< mal.size();i++) {
				array[i] = (mal.get(i).getName());
			}
			Gson gson = new Gson();
	    	return gson.toJson(array);  	
	    	}
	    
	    @RequestMapping(value = "Allhansolyy.do", method = RequestMethod.GET, produces="text/plain;charset=UTF-8")
	    @ResponseBody
		public String NameSearch(Locale locale,Model model ,HttpSession session,
													   @RequestParam(value="page",required=false) Integer page,String noticeSearch,
													   @RequestParam(value="search", required=false) String search) {
	 
	    	
	    	Member m = (Member) session.getAttribute("loginUser");
	  
			ArrayList<Member> mal =mService.allMember2(m.getId()); //친구의 member 정보값 이거 이용
			
			String[] array = new String[mal.size()]; //전 맴버 이름 담김
			for(int i =0; i< mal.size();i++) {
				array[i] = (mal.get(i).getName());
			}
			Gson gson = new Gson();
	    	return gson.toJson(array);  	
	    	}
	    
	
	    @RequestMapping(value = "friendshansolyy.do", method = RequestMethod.GET, produces="text/plain;charset=UTF-8")
	    @ResponseBody
		public String friendsIdSearch(Locale locale,Model model ,HttpSession session,
													   @RequestParam(value="page",required=false) Integer page,String noticeSearch,
													   @RequestParam(value="search", required=false) String search) {
	 
	    	
	    	Member m = (Member) session.getAttribute("loginUser");
	    	ArrayList<Friends> fal = mService.rlfriends(m.getId()); //내가 db에 내가 들어있는 친구 목록을 다뽑아옴(왼쪽에 내 아이디면 오른쪽 컬럼값 오른쪽 내아이디면 왼쪽컬럼)
			ArrayList<String> al = new ArrayList<String>();//목록중 친구아이디을 다뽑아옴
			for(int i=0;i<fal.size();i++) {
				if(fal.get(i).getfId().equals(m.getId())) {//친구 아이디 컬럼에 로그인된 아이디랑 같으면 userid에 있는 것을 가져와라
					al.add(fal.get(i).getUserId());
				}else if(fal.get(i).getUserId().equals(m.getId())) {//userId 컬럼와 로그인된 아이디가 같으면 fid에있는것을 al에 넣어라
					al.add(fal.get(i).getfId());
				}
			}
			System.out.println("aaaa"+al);
			ArrayList<Member> mal =new ArrayList<Member>(); //친구의 member 정보값 이거 이용
			for(int i =0;i<al.size();i++) {
				mal.add(mService.friendsInfo(al.get(i)));
			}
			String[] array = new String[mal.size()]; //친구 이름 담김
			for(int i =0; i< mal.size();i++) {
				array[i] = (mal.get(i).getId());
			}
			Gson gson = new Gson();
	    	return gson.toJson(array);  	
	    	}
	    
	    
	 
	    
	    
		
		@RequestMapping(value = "join_injeung.do", method = RequestMethod.POST)
	    public ModelAndView join_injeung(String member,String email_injeung, String dice, HttpServletResponse response_equals) throws IOException {
	     //페이지이동과 자료를 동시에 하기위해 ModelAndView를 사용해서 이동할 페이지와 자료를 담음
	         
	        ModelAndView mv = new ModelAndView();
	        
	        mv.setViewName("/member/join.do");
	        
	        mv.addObject("e_mail",email_injeung);
	        
	        if (email_injeung.equals(dice)) {
	            
	            //인증번호가 일치할 경우 인증번호가 맞다는 창을 출력하고 회원가입창으로 이동함
	            
	            
	            
	            mv.setViewName("member/searchResultPwd");
	            
	            mv.addObject("e_mail",email_injeung);
	            mv.addObject("result",mService.search(member));
	            
	            //만약 인증번호가 같다면 이메일을 회원가입 페이지로 같이 넘겨서 이메일을
	            //한번더 입력할 필요가 없게 한다.
	            
	            response_equals.setContentType("text/html; charset=UTF-8");
	            PrintWriter out_equals = response_equals.getWriter();
	            out_equals.println("<script>alert('인증번호가 일치하였습니다.');</script>");
	            out_equals.flush();
	    
	            return mv;
	            
	            
	        }else if (email_injeung != dice) {
	            
	            
	            ModelAndView mv2 = new ModelAndView(); 
	            
	            mv2.setViewName("member/email_injeung");
	            
	            response_equals.setContentType("text/html; charset=UTF-8");
	            PrintWriter out_equals = response_equals.getWriter();
	            out_equals.println("<script>alert('인증번호가 일치하지않습니다. 인증번호를 다시 입력해주세요.'); history.go(-1);</script>");
	            out_equals.flush();
	            
	    
	            return mv2;
	            
	        }    
	    
	        return mv;
	        
	    }
		
		
			
		@RequestMapping("membersearchId.do")
		public String membersearchId(Member m, Model model,HttpServletResponse response) throws IOException {
		
		
		// 이제 서비스로 넘기자
		Member result = mService.searchId(m);
		
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
			int postCount = mService.pCount(mb.getId());
			if(loginUser != null) {
				model.addAttribute("member",loginUser);
				model.addAttribute("fCount",fCount);
				model.addAttribute("pCount",postCount);
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
			Member mb = (Member) session.getAttribute("loginUser");// 여기해야됨
			// 이제 서비스로 넘기자
			int postCount = mService.pCount(mb.getId());
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
			
			return "redirect:home.do";
		}
	   
	    
	    
	    @RequestMapping("friends.do")
		public ModelAndView friends(ModelAndView model ,HttpSession session,
													   @RequestParam(value="page",required=false) Integer page,String noticeSearch,
													   @RequestParam(value="search", required=false) String search) {
		

			Member m = (Member) session.getAttribute("loginUser");
			int postCount = mService.pCount(m.getId());
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
			
			PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
			
			
			ArrayList<Friends> fal = mService.realfriends(m.getId(),Search,pi); //내가 db에 내가 들어있는 친구 목록을 다뽑아옴(왼쪽에 내 아이디면 오른쪽 컬럼값 오른쪽 내아이디면 왼쪽컬럼)
			ArrayList<String> al = new ArrayList<String>();//목록중 친구아이디을 다뽑아옴
			for(int i=0;i<fal.size();i++) {
				if(fal.get(i).getfId().equals(m.getId())) {//친구 아이디 컬럼에 로그인된 아이디랑 같으면 userid에 있는 것을 가져와라
					al.add(fal.get(i).getUserId());
				}else if(fal.get(i).getUserId().equals(m.getId())) {//userId 컬럼와 로그인된 아이디가 같으면 fid에있는것을 al에 넣어라
					al.add(fal.get(i).getfId());
				}
			}
			
			ArrayList<Member> mal =new ArrayList<Member>(); //친구의 member 정보값 이거 이용
			
			for(int i =0;i<al.size();i++) {
				mal.add(mService.friendsInfo(al.get(i)));
			}
			
			ArrayList<Integer> time = new ArrayList<Integer>();
			ArrayList<Integer> logintime = new ArrayList<Integer>();
			ArrayList<String> timeresult = new ArrayList<String>();
			for(int i=0;i<mal.size();i++) {
				time.add(mService.friendsTime(mal.get(i).getId()));
				logintime.add(mService.friendsLoginTime(mal.get(i).getId())); //로그아웃시간 - 로그인시간
			}
			
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
			
			model.addObject("pCount",postCount);
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
			int postCount = mService.pCount(m.getId());
			int fCount = mService.fCount(m.getId());
	    	String Search = noticeSearch;
			if(Search != null || Search!="") {
				model.addObject("search", Search);	
		    }
			 if(noticeSearch==null ||Search=="") {
		    	 Search = null;
		    }
			 int currentPage = 1;
				if(page != null) {
					currentPage = page;
				}
			int listCount = mService.getaddListCount(Search,m.getId());
			PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
			ArrayList<Member> mb = mService.allMember(m.getId(),Search,pi);//자기 자신을 제외한 나머지 회원을 불러옴
			ArrayList<Friends> fal = mService.friends(m.getId()); //내가 db에 내가 들어있는 친구 목록을 다뽑아옴
			ArrayList<Friends> al = new ArrayList<Friends>();//목록중 친구이름을 다뽑아옴
			for(int i=0;i<fal.size();i++) {
				if(fal.get(i).getfId().equals(m.getId())) {
					Friends fs = new Friends();
					fs.setAcceptYn(fal.get(i).getAcceptYn());
					fs.setUserId(fal.get(i).getUserId());
					al.add(fs);
				}else if(fal.get(i).getUserId().equals(m.getId())) {
					Friends fs = new Friends();
					fs.setAcceptYn(fal.get(i).getAcceptYn());
					fs.setUserId(fal.get(i).getfId());
					al.add(fs);
				}
			}
		
			if(mb != null) {
				model.addObject("pCount",postCount);
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
	        	int postCount = mService.pCount(m.getId());
	        	int fCount = mService.fCount(m.getId());
				ArrayList<Friends> fal = mService.friendsadd(id,m.getId());
				ArrayList<String> al = new ArrayList<String>();//목록중 친구아이디을 다뽑아옴
				for(int i=0;i<fal.size();i++) {
					if(fal.get(i).getfId().equals(m.getId())) {//친구 아이디 컬럼에 로그인된 아이디랑 같으면 userid에 있는 것을 가져와라
						al.add(fal.get(i).getUserId());
					}else if(fal.get(i).getUserId().equals(m.getId())) {//userId 컬럼와 로그인된 아이디가 같으면 fid에있는것을 al에 넣어라
						al.add(fal.get(i).getfId());
					}
				}
				
				ArrayList<Member> mal =new ArrayList<Member>(); //친구의 member 정보값 이거 이용
				
				for(int i =0;i<al.size();i++) {
					mal.add(mService.friendsInfo(al.get(i)));
				}
				
				String Search =null;//내가 db에 내가 들어있는 친구 목록을 다뽑아
				int listCount = mService.getListCount(Search,m.getId());
				if(fal != null) {
					model.addObject("pCount",postCount);
					model.addObject("listCount",listCount);
					model.addObject("falll",mal);
					model.addObject("fCount",fCount);
					model.setViewName("/member/accfriends");
					
				}
				return model;   	        				
    	}
	        
	        @RequestMapping("accfriends.do")
    		public ModelAndView accfriends(ModelAndView model,HttpServletResponse response,HttpSession session,String id) throws IOException {
    		String Search=null;
    			Member m = (Member) session.getAttribute("loginUser");
    			int postCount = mService.pCount(m.getId());
    			int fCount = mService.fCount(m.getId());
    			int listCount = mService.getListCount(Search,m.getId());
	        	System.out.println(id);
				 mService.accfriends(m.getId(),id); //내가 db에 내가 들어있는 친구 목록을 다뽑아 asde자리가 로그인을 한 사람의 아이디임
				ArrayList<Friends> fal = mService.friendsadd(id,m.getId());
				ArrayList<String> al = new ArrayList<String>();//목록중 친구아이디을 다뽑아옴
				for(int i=0;i<fal.size();i++) {
					if(fal.get(i).getfId().equals(m.getId())) {//친구 아이디 컬럼에 로그인된 아이디랑 같으면 userid에 있는 것을 가져와라
						al.add(fal.get(i).getUserId());
					}else if(fal.get(i).getUserId().equals(m.getId())) {//userId 컬럼와 로그인된 아이디가 같으면 fid에있는것을 al에 넣어라
						al.add(fal.get(i).getfId());
					}
				}

				ArrayList<Member> mal =new ArrayList<Member>(); //친구의 member 정보값 이거 이용
				
				for(int i =0;i<al.size();i++) {
					mal.add(mService.friendsInfo(al.get(i)));
				}
				
				
				
				
				if(fal != null) {
					model.addObject("pCount",postCount);
					model.addObject("fCount",fCount);
					model.addObject("listCount",listCount);
					model.addObject("falll",mal);
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
    			int postCount = mService.pCount(m.getId());
    			int fCount = mService.fCount(m.getId());
				int fal = mService.dltfriends(m.getId(),id); //내가 db에 내가 들어있는 친구 목록을 다뽑아 asde자리가 로그인을 한 사람의 아이디임
				ArrayList<Friends> fall = mService.friendsadd(id,m.getId());
				if(fal > 0) {
					model.addObject("pCount",postCount);
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
						return "logout.do";
					}else {
						model.addObject("fCount",fCount);
						return "mypageDelete.do";
					}
					   	        				
	    	}
	            @RequestMapping("mypageDelete.do") //회원 탈퇴
	    		public ModelAndView mypageDelete(ModelAndView model,HttpServletResponse response,HttpSession session,String pwd) throws IOException {
	    		
	            	Member m = (Member) session.getAttribute("loginUser");
	    			int fCount = mService.fCount(m.getId());
	    			
	    				
	    				model.addObject("fCount",fCount);
	    				model.setViewName("/member/mypageDelete");
	    				return model;		
				}
				   	        				
			
	        
	            @RequestMapping("refusefriends.do") //친구신청거절
	    		public ModelAndView refusefriends(ModelAndView model,HttpServletResponse response,HttpSession session,String deleteid) throws IOException {
	    		
	    			Member m = (Member) session.getAttribute("loginUser");
	    			int postCount = mService.pCount(m.getId());
					int fal = mService.refusefriends(m.getId(),deleteid); //내가 db에 내가 들어있는 친구 목록을 다뽑아 asde자리가 로그인을 한 사람의 아이디임
					ArrayList<Friends> fall = mService.friendsadd(deleteid,m.getId());
					int fCount = mService.fCount(m.getId());
					if(fal > 0) {
						model.addObject("pCount",postCount);
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
	    			int postCount = mService.pCount(m.getId());
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
	    			PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
	    			ArrayList<Member> mb = mService.allMember(m.getId(),Search,pi);//자기 자신을 제외한 나머지 회원을 불러옴
	    		
	    			if(mb != null) {
	    				model.addObject("pCount",postCount);
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

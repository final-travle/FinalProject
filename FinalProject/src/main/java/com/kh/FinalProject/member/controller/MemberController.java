package com.kh.FinalProject.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
public class MemberController  {
	
	
	@Inject    //�꽌鍮꾩뒪瑜� �샇異쒗븯湲� �쐞�빐�꽌 �쓽議댁꽦�쓣 二쇱엯
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
		
		System.out.println(m);
		int result = mService.insertMember(m);
		Ttype tp = new Ttype();
		// �씠�젣 �꽌鍮꾩뒪濡� �꽆湲곗옄
		int result2 = 0;
		
		for(int i=0; i<request.getParameterValues("tType").length;i++) {
			result2+=mService.insertTtype(request.getParameter("id"),request.getParameterValues("tType")[i],tp);
			}
		
		
		if(result>0 &&result2 > 0) {
			
			return "member/login";				
		}else {
			throw new MemberException("�쉶�썝 媛��엯 �떎�뙣!");
		}
		
	}
	
	@RequestMapping("mlogin.do")
	public String memberLogin(Member m, Model model,HttpServletResponse response) throws IOException {
		System.out.println(m);
		Member loginUser = mService.loginMember(m);
		
		int timeupdate =mService.loginTime(m.getId());
		int success =0;
		if(timeupdate<1) { //�뾽�뜲�씠�듃�븷寃뚯뾾�쑝硫� �씤�꽌�듃�빐�씪
		success=mService.setloginTime(m.getId());
		}
		
		System.out.println("�꽦怨�"+success);
		//�떆媛� �꽔�뒗寃�  update
		
		System.out.println(loginUser);
		if(loginUser != null) {
			model.addAttribute("loginUser",loginUser);
			return "home";
		}else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('�젙蹂대�� �솗�씤�빐二쇱꽭�슂.'); </script>");
			out.flush();
			return "member/login";
		}
	}
	
		
		@RequestMapping("membersearchPwd.do")
		public String membersearchPwd(Member m, Model model,HttpServletResponse response) throws IOException {
		
		
		System.out.println(m);
		
		// �씠�젣 �꽌鍮꾩뒪濡� �꽆湲곗옄
		Member result = mService.searchPwd(m);
		
		System.out.println(result);
			
			if(result != null) {
				model.addAttribute("result",result);
				return "member/searchResultPwd";
			}else {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('�젙蹂대�� �솗�씤�빐二쇱꽭�슂.'); </script>");
				out.flush();
				return "member/searchPwd";
			}
		
		
	}
		
		
		
		
		
		@RequestMapping( value = "auth.do" , method=RequestMethod.POST )
        public ModelAndView mailSending(HttpServletRequest request, Member m, HttpServletResponse response_email) throws IOException {
 
            Random r = new Random();
            int dice = r.nextInt(4589362) + 49311; //�씠硫붿씪濡� 諛쏅뒗 �씤利앹퐫�뱶 遺�遺� (�궃�닔)
            
            int count = mService.membercount(m);
            
            if(count>0) {
            String setfrom = "violin7665@gamil.com";
            String tomail = m.getEmail(); // 諛쏅뒗 �궗�엺 �씠硫붿씪
            String title = "鍮꾨�踰덊샇 李얘린 �씤利� �씠硫붿씪 �엯�땲�떎."; // �젣紐�
            String content =
            
            System.getProperty("line.separator")+ //�븳以꾩뵫 以꾧컙寃⑹쓣 �몢湲곗쐞�빐 �옉�꽦
            
            System.getProperty("line.separator")+
                    
            "�븞�뀞�븯�꽭�슂 �쉶�썝�떂 ���씗 �솃�럹�씠吏�瑜� 李얠븘二쇱뀛�꽌 媛먯궗�빀�땲�떎"
            
            +System.getProperty("line.separator")+
            
            System.getProperty("line.separator")+
    
            " �씤利앸쾲�샇�뒗 " +dice+ " �엯�땲�떎. "
            
            +System.getProperty("line.separator")+
            
            System.getProperty("line.separator")+
            
            "諛쏆쑝�떊 �씤利앸쾲�샇瑜� �솃�럹�씠吏��뿉 �엯�젰�빐 二쇱떆硫� �떎�쓬�쑝濡� �꽆�뼱媛묐땲�떎."; // �궡�슜
            
            
            try {
                MimeMessage message = mailSender.createMimeMessage();
                MimeMessageHelper messageHelper = new MimeMessageHelper(message,
                        true, "UTF-8");
 
                messageHelper.setFrom(setfrom); // 蹂대궡�뒗�궗�엺 �깮�왂�븯硫� �젙�긽�옉�룞�쓣 �븞�븿
                messageHelper.setTo(tomail); // 諛쏅뒗�궗�엺 �씠硫붿씪
                messageHelper.setSubject(title); // 硫붿씪�젣紐⑹� �깮�왂�씠 媛��뒫�븯�떎
                messageHelper.setText(content); // 硫붿씪 �궡�슜 
                mailSender.send(message);
                
            } catch (Exception e) {
                System.out.println(e);
            }
            
            ModelAndView mv = new ModelAndView();    //ModelAndView濡� 蹂대궪 �럹�씠吏�瑜� 吏��젙�븯怨�, 蹂대궪 媛믪쓣 吏��젙�븳�떎.
            mv.setViewName("/member/email");     //酉곗쓽�씠由�
            mv.addObject("dice", dice);
            mv.addObject("member",mService.searchPwd(m));
            System.out.println("mv : "+mv);
 
            response_email.setContentType("text/html; charset=UTF-8");
            PrintWriter out_email = response_email.getWriter();
            out_email.println("<script>alert('�씠硫붿씪�씠 諛쒖넚�릺�뿀�뒿�땲�떎. �씤利앸쾲�샇瑜� �엯�젰�빐二쇱꽭�슂.');</script>");
            out_email.flush();
            
            
            return mv;
            }else {
            	ModelAndView mv = new ModelAndView();    //ModelAndView濡� 蹂대궪 �럹�씠吏�瑜� 吏��젙�븯怨�, 蹂대궪 媛믪쓣 吏��젙�븳�떎.
                mv.setViewName("/member/searchPwd");
            	response_email.setContentType("text/html; charset=UTF-8");
                PrintWriter out_email = response_email.getWriter();
                out_email.println("<script>alert('�븘�씠�뵒�� �씠硫붿씪�씠 �씪移섑븯吏� �븡�뒿�땲�떎.');</script>");
                out_email.flush();
                
                
                return mv;
            	
            } 
        }
		
		
		
		
		@RequestMapping(value = "join_injeung.do", method = RequestMethod.POST)
	    public ModelAndView join_injeung(String member,String email_injeung, String dice, HttpServletResponse response_equals) throws IOException {
	 
	        
	        
	        
	        System.out.println("留덉�留� : email_injeung : "+email_injeung);
	        
	        System.out.println("留덉�留� : dice : "+dice);
	        
	        
	        //�럹�씠吏��씠�룞怨� �옄猷뚮�� �룞�떆�뿉 �븯湲곗쐞�빐 ModelAndView瑜� �궗�슜�빐�꽌 �씠�룞�븷 �럹�씠吏��� �옄猷뚮�� �떞�쓬
	         
	        ModelAndView mv = new ModelAndView();
	        
	        mv.setViewName("/member/join.do");
	        
	        mv.addObject("e_mail",email_injeung);
	        
	        if (email_injeung.equals(dice)) {
	            
	            //�씤利앸쾲�샇媛� �씪移섑븷 寃쎌슦 �씤利앸쾲�샇媛� 留욌떎�뒗 李쎌쓣 異쒕젰�븯怨� �쉶�썝媛��엯李쎌쑝濡� �씠�룞�븿
	            
	            
	            
	            mv.setViewName("member/searchResultPwd");
	            
	            mv.addObject("e_mail",email_injeung);
	            mv.addObject("result",mService.search(member));
	            
	            //留뚯빟 �씤利앸쾲�샇媛� 媛숇떎硫� �씠硫붿씪�쓣 �쉶�썝媛��엯 �럹�씠吏�濡� 媛숈씠 �꽆寃⑥꽌 �씠硫붿씪�쓣
	            //�븳踰덈뜑 �엯�젰�븷 �븘�슂媛� �뾾寃� �븳�떎.
	            
	            response_equals.setContentType("text/html; charset=UTF-8");
	            PrintWriter out_equals = response_equals.getWriter();
	            out_equals.println("<script>alert('�씤利앸쾲�샇媛� �씪移섑븯���뒿�땲�떎.');</script>");
	            out_equals.flush();
	    
	            return mv;
	            
	            
	        }else if (email_injeung != dice) {
	            
	            
	            ModelAndView mv2 = new ModelAndView(); 
	            
	            mv2.setViewName("member/email_injeung");
	            
	            response_equals.setContentType("text/html; charset=UTF-8");
	            PrintWriter out_equals = response_equals.getWriter();
	            out_equals.println("<script>alert('�씤利앸쾲�샇媛� �씪移섑븯吏��븡�뒿�땲�떎. �씤利앸쾲�샇瑜� �떎�떆 �엯�젰�빐二쇱꽭�슂.'); history.go(-1);</script>");
	            out_equals.flush();
	            
	    
	            return mv2;
	            
	        }    
	    
	        return mv;
	        
	    }
		
		
			
		@RequestMapping("membersearchId.do")
		public String membersearchId(Member m, Model model,HttpServletResponse response) throws IOException {
		
		
		System.out.println(m);
		
		// �씠�젣 �꽌鍮꾩뒪濡� �꽆湲곗옄
		Member result = mService.searchId(m);
		
		System.out.println(result);
			
			if(result != null) {
				model.addAttribute("result",result);
				return "member/searchResultId";
			}else {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('�젙蹂대�� �솗�씤�빐二쇱꽭�슂.'); </script>");
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
				out.println("<script>alert('�젙蹂대�� �솗�씤�빐二쇱꽭�슂.'); </script>");
				out.flush();
				model.addAttribute("fCount",fCount);
				return "member/mypageChange";
				
			}
		}
		@RequestMapping("mchange.do")	
		public String mchange(Member m, Model model,HttpSession session,HttpServletRequest request,HttpServletResponse response) throws IOException {
			
			
			System.out.println(m);
			Member mb = (Member) session.getAttribute("loginUser");// �뿬湲고빐�빞�맖
			// �씠�젣 �꽌鍮꾩뒪濡� �꽆湲곗옄
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
					out.println("<script>alert('�젙蹂대�� �솗�씤�빐二쇱꽭�슂.'); </script>");
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
			 int currentPage = 1;
			if(page != null) {
				currentPage = page;
			}
			int listCount = mService.getListCount(Search,m.getId());
			int fCount = mService.fCount(m.getId());
			System.out.println("listCount"+listCount);
			PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
			System.out.println(pi);
			
			ArrayList<Friends> fal = mService.realfriends(m.getId(),Search,pi); //�궡媛� db�뿉 �궡媛� �뱾�뼱�엳�뒗 移쒓뎄 紐⑸줉�쓣 �떎戮묒븘�샂(�쇊履쎌뿉 �궡 �븘�씠�뵒硫� �삤瑜몄そ 而щ읆媛� �삤瑜몄そ �궡�븘�씠�뵒硫� �쇊履쎌뺄�읆)
			ArrayList<String> al = new ArrayList<String>();//紐⑸줉以� 移쒓뎄�븘�씠�뵒�쓣 �떎戮묒븘�샂
			for(int i=0;i<fal.size();i++) {
				if(fal.get(i).getfId().equals(m.getId())) {//移쒓뎄 �븘�씠�뵒 而щ읆�뿉 濡쒓렇�씤�맂 �븘�씠�뵒�옉 媛숈쑝硫� userid�뿉 �엳�뒗 寃껋쓣 媛��졇���씪
					al.add(fal.get(i).getUserId());
				}else if(fal.get(i).getUserId().equals(m.getId())) {//userId 而щ읆�� 濡쒓렇�씤�맂 �븘�씠�뵒媛� 媛숈쑝硫� fid�뿉�엳�뒗寃껋쓣 al�뿉 �꽔�뼱�씪
					al.add(fal.get(i).getfId());
				}
			}
			System.out.println("aaaa"+al);
			ArrayList<Member> mal =new ArrayList<Member>(); //移쒓뎄�쓽 member �젙蹂닿컪 �씠嫄� �씠�슜
			
			for(int i =0;i<al.size();i++) {
				mal.add(mService.friendsInfo(al.get(i)));
			}
			System.out.println("mal : "+mal);
			ArrayList<Integer> time = new ArrayList<Integer>();
			ArrayList<Integer> logintime = new ArrayList<Integer>();
			ArrayList<String> timeresult = new ArrayList<String>();
			for(int i=0;i<mal.size();i++) {
				time.add(mService.friendsTime(mal.get(i).getId()));
				logintime.add(mService.friendsLoginTime(mal.get(i).getId())); //濡쒓렇�븘�썐�떆媛� - 濡쒓렇�씤�떆媛�
			}
			System.out.println(logintime);
			for(int i=0;i<time.size();i++) {
				if(logintime.get(i)>=0) {
					if(time.get(i)>=518400) {
						timeresult.add("1�뀈�씠�긽");
					}
					if(518400>time.get(i)&&time.get(i)>=43200) {
						timeresult.add("�븳�떖�씠�긽");
					}
					if(43200>time.get(i)&&time.get(i)>=1440) {
						String day =String.valueOf((time.get(i)/1440));
						timeresult.add(day+"�씪�씠�긽");
					}
					if(1440>time.get(i) && time.get(i)>=60) {
						String hour =String.valueOf((time.get(i)/60));
						timeresult.add(hour+"�떆媛꾩씠�긽");
					}
					if(60>time.get(i)&& time.get(i)>4) {
						String min =String.valueOf(time.get(i));
						timeresult.add(min+"遺꾩씠�긽");
					}
					
					if(time.get(i)==0||time.get(i)<=4){
							timeresult.add("理쒓렐源뚯� �젒�냽");
					}
					if(time.get(i)==null) {
						timeresult.add("�젒�냽湲곕줉�뾾�쓬");
					}
				}else {
					timeresult.add("�삩�씪�씤");
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
			ArrayList<Member> mb = mService.allMember(m.getId(),Search,pi);//�옄湲� �옄�떊�쓣 �젣�쇅�븳 �굹癒몄� �쉶�썝�쓣 遺덈윭�샂
			ArrayList<Friends> fal = mService.friends(m.getId()); //�궡媛� db�뿉 �궡媛� �뱾�뼱�엳�뒗 移쒓뎄 紐⑸줉�쓣 �떎戮묒븘�샂
			ArrayList<Friends> al = new ArrayList<Friends>();//紐⑸줉以� 移쒓뎄�씠由꾩쓣 �떎戮묒븘�샂
	
			
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
	    			//諛쏆븘�삩 �븘�씠�뵒媛� �긽��履쎌븘�씠�뵒
	    			Member m = (Member) session.getAttribute("loginUser");
					System.out.println(id);
	        		int count = mService.addFriends(id,m.getId()); //移쒓뎄 �슂泥�蹂대깂 
	        		if(count >0) {
	        			return "redirect:/friendsadd.do";			
	    			}else {
						response.setContentType("text/html; charset=UTF-8");
						PrintWriter out = response.getWriter();
						out.println("<script>alert('�젙蹂대�� �솗�씤�빐二쇱꽭�슂.'); </script>");
						out.flush();
						return "member/friendsadd?id"+id;
					}
	    			   	        				
	    	}
	        
	        @RequestMapping("okfriends.do")
    		public ModelAndView okfriends(ModelAndView model,HttpSession session,String id) throws IOException {
					
	        	Member m = (Member) session.getAttribute("loginUser");
	        	int fCount = mService.fCount(m.getId());
				ArrayList<Friends> fal = mService.friendsadd(id,m.getId());
				String Search =null;//�궡媛� db�뿉 �궡媛� �뱾�뼱�엳�뒗 移쒓뎄 紐⑸줉�쓣 �떎戮묒븘
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
				int fal = mService.accfriends(m.getId(),id); //�궡媛� db�뿉 �궡媛� �뱾�뼱�엳�뒗 移쒓뎄 紐⑸줉�쓣 �떎戮묒븘 asde�옄由ш� 濡쒓렇�씤�쓣 �븳 �궗�엺�쓽 �븘�씠�뵒�엫
				ArrayList<Friends> fall = mService.friendsadd(id,m.getId());
				System.out.println(fall);
				System.out.println(fal);
				if(fall != null) {
					System.out.println("�븯 �궗�쐞踰�");
					model.addObject("fCount",fCount);
					model.addObject("listCount",listCount);
					model.addObject("falll",fall);
					model.setViewName("/member/accfriends");
				}else {
					
					response.setContentType("text/html; charset=UTF-8");
					PrintWriter out = response.getWriter();
					out.println("<script>alert('諛쏆� �슂泥��씠 �뾾�뒿�땲�떎.'); </script>");
					out.flush();
					model.setViewName("/member/accfriends");
			
					
				}
			
				return model;   	        				
    	}
	        
	        
	        
	            @RequestMapping("dltaccfriends.do")
    		public ModelAndView dltaccfriends(ModelAndView model,HttpServletResponse response,HttpSession session,String id) throws IOException {
    		
    			Member m = (Member) session.getAttribute("loginUser");
    			int fCount = mService.fCount(m.getId());
				int fal = mService.dltfriends(m.getId(),id); //�궡媛� db�뿉 �궡媛� �뱾�뼱�엳�뒗 移쒓뎄 紐⑸줉�쓣 �떎戮묒븘 asde�옄由ш� 濡쒓렇�씤�쓣 �븳 �궗�엺�쓽 �븘�씠�뵒�엫
				ArrayList<Friends> fall = mService.friendsadd(id,m.getId());
				System.out.println(fall);
				System.out.println(fal);
				if(fal > 0) {
					System.out.println("�븯 �궗�쐞踰�");
					model.addObject("falll",fall);
					model.addObject("fCount",fCount);
					model.setViewName("/member/accfriends");
					
				}
				return model;   	        				
    	}
	            @RequestMapping("dltmember.do") //�쉶�썝 �깉�눜
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
						System.out.println("�븯 �궗�쐞踰�");
						return "logout.do";
					}else {
						model.addObject("fCount",fCount);
						return "mypageDelete.do";
					}
					   	        				
	    	}
	            @RequestMapping("mypageDelete.do") //�쉶�썝 �깉�눜
	    		public String mypageDelete(ModelAndView model,HttpServletResponse response,HttpSession session,String pwd) throws IOException {
	    		
	            	Member m = (Member) session.getAttribute("loginUser");
	    			int fCount = mService.fCount(m.getId());
	    			

						model.addObject("fCount",fCount);
						return "member/mypageDelete";		   	        				
	    	}
	        
	            @RequestMapping("refusefriends.do") //移쒓뎄�떊泥�嫄곗젅
	    		public ModelAndView refusefriends(ModelAndView model,HttpServletResponse response,HttpSession session,String id) throws IOException {
	    		
	    			Member m = (Member) session.getAttribute("loginUser");
					int fal = mService.refusefriends(m.getId(),id); //�궡媛� db�뿉 �궡媛� �뱾�뼱�엳�뒗 移쒓뎄 紐⑸줉�쓣 �떎戮묒븘 asde�옄由ш� 濡쒓렇�씤�쓣 �븳 �궗�엺�쓽 �븘�씠�뵒�엫
					ArrayList<Friends> fall = mService.friendsadd(id,m.getId());
					int fCount = mService.fCount(m.getId());
					System.out.println(fall);
					System.out.println(fal);
					if(fal > 0) {
						System.out.println("�븯 �궗�쐞踰�");
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
	    			ArrayList<Member> mb = mService.allMember(m.getId(),Search,pi);//�옄湲� �옄�떊�쓣 �젣�쇅�븳 �굹癒몄� �쉶�썝�쓣 遺덈윭�샂
	    		
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
	        		int count = mService.adminMemberDelete(id); //移쒓뎄 �슂泥�蹂대깂
	        		mService.dltmemberfriends(id);
	        		mService.dltTime(id);
	        		if(count >0) {
	        			return "redirect:/adminMember.do";			
	    			}else {
						response.setContentType("text/html; charset=UTF-8");
						PrintWriter out = response.getWriter();
						out.println("<script>alert('�젙蹂대�� �솗�씤�빐二쇱꽭�슂.'); </script>");
						out.flush();
						return "member/friendsadd?id"+id;
					}
	    			   	        				
	    	}
	            
	            @RequestMapping("adminMemberinfo.do")
	    		public ModelAndView adminMemberinfo(ModelAndView model,HttpServletResponse response,HttpSession session,String id) throws IOException {
	        		Member m = mService.memberinfo(id);
	        		ArrayList<String> als = mService.memberinfoType(id);
	        		//�뿬湲고빐�빞�맖
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

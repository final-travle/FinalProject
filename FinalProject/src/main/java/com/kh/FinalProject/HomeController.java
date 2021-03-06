package com.kh.FinalProject;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kh.FinalProject.common.model.service.MainService;
import com.kh.FinalProject.common.model.vo.AD;
import com.kh.FinalProject.common.model.vo.PrefStyle;
import com.kh.FinalProject.member.model.vo.Member;
import com.kh.FinalProject.travel.model.vo.Board;
import com.kh.FinalProject.travel.model.vo.PostTag;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@RequestMapping(value="kakaologin.do")
    public String login() {
        
        return "member/kLogin";
    }

	
	 @Autowired
	 MainService ms;
	 
	@RequestMapping(value = "home.do", method = RequestMethod.GET)
	public ModelAndView homeList(ModelAndView mv, Locale locale, Model model, HttpSession session) {
		ArrayList<Board> mpl = ms.selectPlanList();
		ArrayList<Board> mrl = ms.selectReviewList();
		ArrayList<Board> brl = ms.selectMonthReview();
		
		ArrayList<PostTag> pt = ms.selectPostTag();

		// 로그인 된 유저 아이디 가져온다.
		Member mb = (Member) session.getAttribute("loginUser");
		
		
		if(mb != null) {
			String userId = mb.getId();
			
			ArrayList<PrefStyle> adList = ms.getPrefStyle(userId);

			ArrayList<AD> ali = new ArrayList<>();
			
			ArrayList<AD> all = new ArrayList<>();
			
			// 중복값 제거를 위한 배열 선언
			int check[] = new int[4];
			
			if(adList != null) {
				for(int i = 0; i < adList.size(); i ++) {
					String prefTagName = adList.get(i).getTravStyle();
					
					ArrayList<AD> al = ms.getAdList(prefTagName);
					for(int j = 0; j < al.size(); j ++) {
						AD alparts = al.get(j);
						ali.add(alparts);
					}
					Random rand = new Random();
					AD adsel = al.get(rand.nextInt(al.size()));
					System.out.println(al);
					if(al != null) {
						System.out.println("있음");
						mv.addObject("adsel", adsel);
						mv.addObject("al", al);
					}else {
						System.out.println("없음");
					}
				}
				
				// 랜덤수 구하는 식
				for(int k = 0; k < 4; k ++) {
					int ran = (int)(Math.random() * (ali.size()));
					
					check[k] = ran;
					
					for(int l = 0; l < k; l ++) {
						if(check[k] == check[l]) {
							k --;
						}
					}
				}
				
				for(int m = 0; m < 4; m ++) {
					
					AD adli = ali.get(check[m]);
					all.add(adli);
				}
				
				if(all != null) {
					mv.addObject("al", all);
				}
				
				
			}
			
			
		}else {
			System.out.println("로그인 정보 없음");
			ArrayList<AD> al = ms.getAdList();
			ArrayList<AD> aln = new ArrayList<AD>();

			// 중복값 제거를 위한 배열 선언
			int check[] = new int[4];
			
			int box[] = new int[4];
			for(int i = 0; i < 4; i ++) {
				int ran = (int)(Math.random() * 40) + 1;

				check[i] = ran;
				
				for(int j = 0; j < i; j ++) {
					if(check[i] == check[j]) {
						i --;
					}
				}
				box[i] = ran;
				System.out.println(box[i]);
				if(i==0) {
					AD adList = al.get(ran);				
					aln.add(adList);
				}
				for(int j=0;j<i;j++) {
					if(box[i]==box[j]) {
						i--;
						break;
					}else {
						if(i-1==j) {
							AD adList = al.get(ran);				
							aln.add(adList);
						}
						
					}
				}
			}

			for(int k = 0; k < 4; k ++) {
				AD adList = al.get(check[k]);				
				aln.add(adList);
			}
			
			Random rand = new Random();
			AD adsel = al.get(rand.nextInt(al.size()));
			System.out.println(aln);
			mv.addObject("al", aln);
			mv.addObject("adsel", adsel);
		}
		
		
		mv.addObject("mpl", mpl);
		mv.addObject("mrl", mrl);
		mv.addObject("brl", brl);
		mv.addObject("pt", pt);
		mv.setViewName("home");
		
		return mv;
	}
	
	
	
	@RequestMapping(value = "memberJoin.do", method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpSession session) {

		
		return "member/memberJoin";
	}
	@RequestMapping(value = "login.do", method = RequestMethod.GET)
	public String login(Locale locale, Model model, HttpSession session) {

		
		return "member/login";
	}
	@RequestMapping(value = "searchPwd.do", method = RequestMethod.GET)
	public String searchPwd(Locale locale, Model model, HttpSession session) {

		
		return "member/searchPwd";
	}
	
	@RequestMapping(value = "searchId.do", method = RequestMethod.GET)
	public String searchId(Locale locale, Model model, HttpSession session) {

		
		return "member/searchId";
	}
	@RequestMapping(value = "change.do", method = RequestMethod.GET)
	public String change(Locale locale, Model model, HttpSession session) {

		
		return "change";
	}
	
	@RequestMapping(value = "ex1.do", method = RequestMethod.GET)
	public String ex1(Locale locale, Model model, HttpSession session) {

		
		return "member/ex1";
	}
	@RequestMapping(value = "ex2.do", method = RequestMethod.GET)
	public String ex2(Locale locale, Model model, HttpSession session) {

		
		return "member/ex2";
	}
	@RequestMapping(value = "ex3.do", method = RequestMethod.GET)
	public String ex3(Locale locale, Model model, HttpSession session) {

		
		return "member/ex3";
	}
	@RequestMapping(value = "ex4.do", method = RequestMethod.GET)
	public String ex4(Locale locale, Model model, HttpSession session) {

		
		return "member/ex4";
	}
	@RequestMapping(value = "ex5.do", method = RequestMethod.GET)
	public String ex5(Locale locale, Model model, HttpSession session) {

		
		return "member/ex5";
	}
	@RequestMapping(value = "searchResultId.do", method = RequestMethod.GET)
	public String searchResultId(Locale locale, Model model, HttpSession session) {

		
		return "member/searchResultId";
	}
	@RequestMapping(value = "searchResultPwd.do", method = RequestMethod.GET)
	public String searchResultPwd(Locale locale, Model model, HttpSession session) {

		
		return "member/searchResultPwd";
	}
	
	@RequestMapping("companyInfo.do")
	public String companyInfo(Locale locale, Model model, HttpSession session) {
		return "common/companyInfo";
	}
	
	
}

package com.kh.FinalProject;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	
	@RequestMapping(value = "home.do", method = RequestMethod.GET)
	public String home123(Locale locale, Model model, HttpSession session) {	
		return "home";
	}
	
	@RequestMapping(value = "mypageDelete.do", method = RequestMethod.GET)
	public String mypageDelete(Locale locale, Model model, HttpSession session) {
		return "member/mypageDelete";
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
	
	
	
	
}

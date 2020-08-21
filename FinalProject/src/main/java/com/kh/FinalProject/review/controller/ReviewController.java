package com.kh.FinalProject.review.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kh.FinalProject.common.Pagination2;
import com.kh.FinalProject.member.model.vo.Member;
import com.kh.FinalProject.review.model.service.ReviewService;
import com.kh.FinalProject.travel.model.vo.Board;
import com.kh.FinalProject.travel.model.vo.City;
import com.kh.FinalProject.travel.model.vo.LikedPost;
import com.kh.FinalProject.travel.model.vo.MapBoard;
import com.kh.FinalProject.travel.model.vo.PageInfo;
import com.kh.FinalProject.travel.model.vo.PostTag;
import com.kh.FinalProject.travel.model.vo.Tag;
import com.kh.FinalProject.travel.model.vo.Travel;
import com.kh.FinalProject.travel.model.vo.Vote;

@Controller
public class ReviewController {

	@Autowired
	ReviewService rs;
	
	@RequestMapping("reviewListView.do")
	public ModelAndView reviewListView(ModelAndView mv, @RequestParam(value="page", required=false) Integer page) {

		int currentPage = 1;
		if(page != null) {
			currentPage = page;
		}
		
		System.out.println("page : " + page);
		
		int listCount = rs.getListCount();
		
		PageInfo pi2 = Pagination2.getPageInfo2(currentPage, listCount);
		
		ArrayList<Board> list = rs.selectList(pi2);
		ArrayList<PostTag> tl = rs.selectListTag();
		
		if(list != null) {
			mv.addObject("tl", tl);
			mv.addObject("list", list);
			mv.addObject("pi", pi2);
			mv.setViewName("review/reviewListView");
		}else {
			
		}
		return mv;
	}
	

	@RequestMapping("reviewInsertView.do")
	public ModelAndView travelList(ModelAndView mv) throws Exception  {

        StringBuilder urlBuilder = new StringBuilder("http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaCode"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=e4W6es0aH0BXtgcISZ6LWxPWhmWicUPytTmUJ72zTxJIubFnvgsVrPPGg%2B%2FgJ18tvp7J9W6Mfsih5TwbYosrEw%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + URLEncoder.encode("e4W6es0aH0BXtgcISZ6LWxPWhmWicUPytTmUJ72zTxJIubFnvgsVrPPGg%2B%2FgJ18tvp7J9W6Mfsih5TwbYosrEw%3D%3D (URL - Encode)", "UTF-8")); /*공공데이터포털에서 발급받은 인증키*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("20", "UTF-8")); /*한 페이지 결과수*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*현재 페이지 번호*/
        urlBuilder.append("&" + URLEncoder.encode("MobileOS","UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8")); /*IOS (아이폰), AND (안드로이드), WIN (원도우폰), ETC*/
        urlBuilder.append("&" + URLEncoder.encode("MobileApp","UTF-8") + "=" + URLEncoder.encode("AppTest", "UTF-8")); /*서비스명=어플명*/
//        urlBuilder.append("&" + URLEncoder.encode("areaCode","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*지역코드, 시군구코드*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        
        // 총 갯수 찾기
        Pattern pattern = Pattern.compile("<totalCount>(.+?)</totalCount>");
        Matcher matcher = pattern.matcher(sb);
        matcher.find();
        
        // String > int 변환
        String total = matcher.group(1);        
        int tt =Integer.parseInt(total);
        
        System.out.println(sb);
        
        String[] nameArr = new String[tt];
        String[] codeArr = new String[tt];
        
        
//        System.out.println(tt);
        
    	// 이름값
        Pattern nameTag = Pattern.compile("<name>(.+?)</name>");
        Matcher ctname = nameTag.matcher(sb);
        
        // 지역코드
        Pattern codeTag = Pattern.compile("<code>(.+?)</code>");
        Matcher codeNo = codeTag.matcher(sb);

        
        int matchCount = 0;
        
        // 지역명 배열에 담기
        while (ctname.find()) {
        	String name = ctname.group(1);
        	
        	nameArr[matchCount] = name;
        	
//            System.out.println(matchCount + " : " + name);
            matchCount++;
        }

        // 지역명 배열에 담기
        matchCount = 0;	// 카운트 리셋
        while (codeNo.find()) {
        	String code = codeNo.group(1);
        	
        	codeArr[matchCount] = code;
        	
            matchCount++;
        }
        
        ArrayList<City> city = new ArrayList<City>();
        
        for(int i = 0; i < nameArr.length; i++) {
        	City ct = new City(nameArr[i],codeArr[i]);
        	city.add(ct);
        } 
        
       // 태그
        ArrayList<Tag> tag = rs.getTagList();
        
        mv.addObject("tag", tag);
		mv.addObject("city", city);
		mv.setViewName("review/reviewInsert");
        
        
        
		return mv;
	}
	
	

	@RequestMapping("reviewImgSave.do")
	public void profileUpload(MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws IOException {

		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		String realFolder = request.getSession().getServletContext().getRealPath("\\resources\\reviewImages");

		UUID uuid = UUID.randomUUID();
		

		// 업로드할 파일 이름
		String org_filename = file.getOriginalFilename();
		String str_filename = uuid.toString() + org_filename;
		

		System.out.println("원본 파일명 : " + org_filename);
		System.out.println("저장할 파일명 : " + str_filename);
		

		String filepath = realFolder + "\\" + str_filename;
		System.out.println("파일경로 : " + filepath);

		File f = new File(filepath);
		if (!f.exists()) {
			f.mkdirs();
		}
		file.transferTo(f);
		out.println("resources/reviewImages/"+str_filename);
		out.close();
	}
	
	

	@RequestMapping(value = "rInsert.do", method = RequestMethod.POST, produces = "application/text; charset=utf8")
	@ResponseBody
	public String planInsert(HttpServletResponse response, HttpSession session, @RequestBody List<Object> posex, Board b, Travel tv, Tag tg) {
		response.setContentType("aplication/json; charset=utf-8");


		// 로그인 된 유저 아이디 가져온다.
		Member mb = (Member) session.getAttribute("loginUser");
		
		String userId = mb.getId();
		
		String contents = (String) posex.remove(10);
//		
//		// json에 붙어 온 firstImg 를 저장한다.
		String firstImg = (String) posex.remove(9);
//		
//		// json에 붙어온 제목 가져와 잘라내 저장한다.
		String mtitle = (String)posex.remove(8);
//		
		// json에 붙어온 tagList를 저장한다.
		ArrayList tagList = (ArrayList) posex.remove(7);
		
		
		ArrayList tTypeArr = (ArrayList) tagList.get(0);
		ArrayList tNameArr = (ArrayList) tagList.get(1);
		
		int result = 0;

		
		b.setTitle(mtitle);
		b.setUserId(userId);
		b.setThumbnail(firstImg);
		b.setPostContents(contents);
		
		result = rs.reviewInsert(b);
		

		 String msg = "";
		 if(result > 0) {
			 int result2 = 0;
			 
			 result2 = rs.reviewLikeThumbupInsert();
			 
			// post tag 테이블에 추가
			for(int i = 0; i < tTypeArr.size(); i ++) {
				int tResult = 0;
				
				String tagType = (String) tTypeArr.get(i);
				String tagName = (String) tNameArr.get(i);
				
				tg.setTagType(tagType);
				tg.setTagName(tagName);
				
				System.out.println(tg.getTagName());
				
				tResult = rs.insertTag(tg);
				
			}
			 
			 
			 
			 if(result2 > 0) {
				 System.out.println("tag 잘 들어감");
				 
				 int result3 = 0;
		    	
				// 넘어온 json object를 배열 단위로 풀어준다.
			    for(int i = 0; i < posex.size(); i ++) {
			    	int pDay = i;

			    	// 배열값이 비었는지 확인하기 위하여 먼저 배열화함
			    	ArrayList testli = (ArrayList) posex.get(i);

			    	if(testli.isEmpty() == false) {
			    		result3 = rs.reviewDayInsert(i);
			    
				    	List<Object> mList = (List<Object>) posex.get(i);
	

			    		int ptcode = 0;
				    	// 날짜별 지역을 찍어준다.
				    	for(int j = 0; j < mList.size(); j ++) {
					    	int result4 = 0;
					    	
			//	    		System.out.println("location");
			//	    		System.out.println(mList.get(j));
				    		
				    		// title과 latlng, code 나누기 위한 map 선언
				    		Map<String, Object> mlInfo = (Map<String, Object>) mList.get(j);
			
				    		String pTitle = (String) mlInfo.get("title");
			//	    		System.out.println(pTitle);
			
				    		//int ptcode = Integer.valueOf((String) mlInfo.get("tcode"));
				    		//System.out.println(ptcode);
				    		ptcode += 1;
				    		
				    		// latlng 의 x좌표와 y좌표를 나누기 위한 map 선언
				    		Map<String, Object> latlng = (Map<String, Object>) mlInfo.get("latlng");
			
				    		double xpoint = (Double) latlng.get("Ga");
				    		double ypoint = (Double) latlng.get("Ha");
			//	    		System.out.println(xpoint + ", " + ypoint);
					    		
					    	tv.setNight(i);
					    	tv.settCode(ptcode);
					    	tv.settName(pTitle);
					    	tv.setTxpoint(xpoint);
					    	tv.setTypoint(ypoint);
					    	

					    	System.out.println(tv.getNight());
					    	System.out.println(tv.gettCode());
					    	System.out.println(tv.gettName());
					    	System.out.println(tv.getTxpoint());
					    	System.out.println(tv.getTypoint());
					    	
					    	
					    	
					    	result4 = rs.reviewInsertPoint(tv);
					    	
					    	msg = "글이 정상적으로 등록되었습니다.";
					    	
			    		}
			    		
			    	}

		    	}
			    
    		} // result2 if end

		 }else {
			msg = "데이터 전송 실패";
			 
		 }
		 
		 return msg;
	    
	}
	
	@RequestMapping("reviewDetail.do")
	public ModelAndView reviewDetail(HttpSession session, ModelAndView mv, int postNo, @RequestParam("page") Integer page, LikedPost lp) {
		// 사용자가 보던 페이지(현재 페이지)를 목록 보기 했을 때 다시 보여주게 하게끔 해주는 코드
		int currentPage = 1;
		if(page != null) {
			currentPage = page;
		}
		
		System.out.println(postNo);
		
		// 조회수 올려준다.
		int result = rs.hitsUp(postNo);
		
		// 로그인 된 유저 아이디 가져온다.
		Member m = (Member) session.getAttribute("loginUser");
		if(m != null) {
			lp.setUserId(m.getId());
			lp.setPostNo(postNo);
		
		}
		LikedPost liked = rs.likedView(lp);
		Vote voted = rs.voteView(lp);
		
		System.out.println(liked);
		
		MapBoard mb = rs.likeVoteView(postNo);

		
		if(result > 0) {
			Board b = rs.selectPostView(postNo);
			
			if(b != null){
				ArrayList<Travel> t = rs.selectTravelList(postNo);

				Travel tLast = t.get(t.size() - 1);
				
				System.out.println(" t : " + t);
								
				int dayNum = tLast.getNight();
				
				
				mv.addObject("board", b)
				.addObject("travel", t)
				.addObject("currentPage", currentPage)
				.addObject("dayNum", dayNum)
				.addObject("liked", liked)
				.addObject("voted", voted)
				.addObject("mapList", mb)
				.setViewName("review/reviewDetail");
				
			}
			
			
		}else {
			
		}
		
		return mv;
	}


	@RequestMapping("reviewModifyForm.do")
	public ModelAndView planModify(ModelAndView mv, @RequestParam("postNo") Integer postNo) throws Exception {

        StringBuilder urlBuilder = new StringBuilder("http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaCode"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=e4W6es0aH0BXtgcISZ6LWxPWhmWicUPytTmUJ72zTxJIubFnvgsVrPPGg%2B%2FgJ18tvp7J9W6Mfsih5TwbYosrEw%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + URLEncoder.encode("e4W6es0aH0BXtgcISZ6LWxPWhmWicUPytTmUJ72zTxJIubFnvgsVrPPGg%2B%2FgJ18tvp7J9W6Mfsih5TwbYosrEw%3D%3D (URL - Encode)", "UTF-8")); /*공공데이터포털에서 발급받은 인증키*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("20", "UTF-8")); /*한 페이지 결과수*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*현재 페이지 번호*/
        urlBuilder.append("&" + URLEncoder.encode("MobileOS","UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8")); /*IOS (아이폰), AND (안드로이드), WIN (원도우폰), ETC*/
        urlBuilder.append("&" + URLEncoder.encode("MobileApp","UTF-8") + "=" + URLEncoder.encode("AppTest", "UTF-8")); /*서비스명=어플명*/
//        urlBuilder.append("&" + URLEncoder.encode("areaCode","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*지역코드, 시군구코드*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        
        // 총 갯수 찾기
        Pattern pattern = Pattern.compile("<totalCount>(.+?)</totalCount>");
        Matcher matcher = pattern.matcher(sb);
        matcher.find();
        
        // String > int 변환
        String total = matcher.group(1);        
        int tt =Integer.parseInt(total);
        
        System.out.println(sb);
        
        String[] nameArr = new String[tt];
        String[] codeArr = new String[tt];
        
        
//        System.out.println(tt);
        
    	// 이름값
        Pattern nameTag = Pattern.compile("<name>(.+?)</name>");
        Matcher ctname = nameTag.matcher(sb);
        
        // 지역코드
        Pattern codeTag = Pattern.compile("<code>(.+?)</code>");
        Matcher codeNo = codeTag.matcher(sb);

        
        int matchCount = 0;
        
        // 지역명 배열에 담기
        while (ctname.find()) {
        	String name = ctname.group(1);
        	
        	nameArr[matchCount] = name;
        	
//            System.out.println(matchCount + " : " + name);
            matchCount++;
        }

        // 지역명 배열에 담기
        matchCount = 0;	// 카운트 리셋
        while (codeNo.find()) {
        	String code = codeNo.group(1);
        	
        	codeArr[matchCount] = code;
        	
            matchCount++;
        }
        
        ArrayList<City> city = new ArrayList<City>();
        
        for(int i = 0; i < nameArr.length; i++) {
        	City ct = new City(nameArr[i],codeArr[i]);
        	city.add(ct);
        } 
        
       // 태그
        ArrayList<Tag> tag = rs.getTagList();
        
        // 선택했던 여행지 얻어오기
        ArrayList<Travel> tv = rs.selectTravelList(postNo);

		Travel tLast = tv.get(tv.size() - 1);
		
		System.out.println(tLast.getNight());
		
		int dayNum = tLast.getNight();
        // 선택한 태그 값 얻어오기
        ArrayList<PostTag> pt = rs.getPostTagList(postNo);
        
		Board planOne = rs.selectReview(postNo);
		
		mv.addObject("plan", planOne);
        mv.addObject("tag", tag);
        mv.addObject("pt", pt);
        mv.addObject("tlist", tv);
        mv.addObject("dayNum", dayNum);
		mv.addObject("city", city);
		mv.setViewName("review/reviewModify");
		
		
		return mv;
	}

	@RequestMapping(value = "rModify.do", method = RequestMethod.POST, produces = "application/text; charset=utf8")
	@ResponseBody
	public String reviewModify(HttpServletResponse response, HttpSession session, @RequestBody List<Object> posex, Board b, Travel tv, PostTag tg) {
		response.setContentType("aplication/json; charset=utf-8");

		// 로그인 된 유저 아이디 가져온다.
		Member mb = (Member) session.getAttribute("loginUser");
		
		String userId = mb.getId();
		
		// json에 붙어온 contents를 저장한다
		String contents = (String) posex.remove(11);
		
		// json에 붙어 온 postNo 를 저장한다.
		int postNo = (int) posex.remove(10);
		
		System.out.println("postNo : " + postNo);
		
		// json에 붙어 온 firstImg 를 저장한다.
		String firstImg = (String) posex.remove(9);
		
		// json에 붙어온 제목 가져와 잘라내 저장한다.
		String mtitle = (String)posex.remove(8);
		
		// json에 붙어온 tagList를 저장한다.
		ArrayList tagList = (ArrayList) posex.remove(7);
		
		System.out.println("tag List : " + tagList);
		
		ArrayList tTypeArr = (ArrayList) tagList.get(0);
		ArrayList tNameArr = (ArrayList) tagList.get(1);

		b.setPostNo(postNo);
		b.setTitle(mtitle);
		b.setUserId(userId);
		b.setThumbnail(firstImg);
		b.setPostContents(contents);

		int result = 0;

//		// 제목 수정
		result = rs.reviewModifyPost(b);
		
		// 해당 postNo에 있는 travel 좌표들을 삭제한다.
		int mr = 0;
		mr = rs.reviewModifyB(postNo);
		
		String msg = "글이 정상적으로 수정되었습니다.";
		if(mr > 0) {

    			int ptcode = 0;
    			
				// 넘어온 json object를 배열 단위로 풀어준다.
			    for(int i = 0; i < posex.size(); i ++) {

			    	// 배열값이 비었는지 확인하기 위하여 먼저 배열화함
			    	ArrayList testli = (ArrayList) posex.get(i);

			    	if(testli.isEmpty() == false) {
			    
				    	List<Object> mList = (List<Object>) posex.get(i);
	
				    	System.out.println("mList : " + mList);
				    	
				    	// 날짜별 지역을 찍어준다.
				    	for(int j = 0; j < mList.size(); j ++) {
					    	int piResult = 0;
				    		
				    		// title과 latlng, code 나누기 위한 map 선언
				    		Map<String, Object> mlInfo = (Map<String, Object>) mList.get(j);
			
				    		
				    		
				    		String pTitle = (String) mlInfo.get("title");
			//	    		System.out.println(pTitle);
			
				    		//int ptcode = Integer.valueOf((String) mlInfo.get("tcode"));
				    		//System.out.println(ptcode);
				    		ptcode += 1;
				    		
				    		// latlng 의 x좌표와 y좌표를 나누기 위한 map 선언
				    		Map<String, Object> latlng = (Map<String, Object>) mlInfo.get("latlng");
			
				    		double xpoint = (Double) latlng.get("Ga");
				    		double ypoint = (Double) latlng.get("Ha");
			//	    		System.out.println(xpoint + ", " + ypoint);
					    		
					    	tv.setNight(i);
					    	tv.setPostNo(postNo);
					    	tv.settCode(ptcode);
					    	tv.settName(pTitle);
					    	tv.setTxpoint(xpoint);
					    	tv.setTypoint(ypoint);
					    	
					    	piResult = rs.reviewMoidfyPoint(tv);
					    	
					    	
			    		}
			    		
			    	}

		    	}
			
		}
		
		// POST TAG 삭제
		int ptr = 0;
		ptr = rs.reviewModifyPT(postNo);

		if(ptr > 0) {
			// post tag 테이블에 추가
			for(int i = 0; i < tTypeArr.size(); i ++) {
				int tResult = 0;
				
				String tagType = (String) tTypeArr.get(i);
				String tagName = (String) tNameArr.get(i);
				
				tg.setTagType(tagType);
				tg.setTagName(tagName);
				tg.setPostNo(postNo);
				
				tResult = rs.ModifyTag(tg);
				
			}
		}
		
		 return msg;
	    
	}

	@RequestMapping("reviewDelete.do")
	public String planDelete(@RequestParam("postNo") int postNo) {
		int result = 0;
		result = rs.reviewDelete(postNo);
		
		return "redirect:reviewListView.do";
		
	}
}

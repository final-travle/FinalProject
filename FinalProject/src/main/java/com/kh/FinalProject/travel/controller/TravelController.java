package com.kh.FinalProject.travel.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.kh.FinalProject.common.Pagination2;
import com.kh.FinalProject.member.model.vo.Member;
import com.kh.FinalProject.travel.model.service.TravelService;
import com.kh.FinalProject.travel.model.vo.Board;
import com.kh.FinalProject.travel.model.vo.City;
import com.kh.FinalProject.travel.model.vo.CityInfo;
import com.kh.FinalProject.travel.model.vo.Comments;
import com.kh.FinalProject.travel.model.vo.LikedPost;
import com.kh.FinalProject.travel.model.vo.MapBoard;
import com.kh.FinalProject.travel.model.vo.PageInfo;
import com.kh.FinalProject.travel.model.vo.PostTag;
import com.kh.FinalProject.travel.model.vo.ReComments;
import com.kh.FinalProject.travel.model.vo.Tag;
import com.kh.FinalProject.travel.model.vo.Travel;
import com.kh.FinalProject.travel.model.vo.Vote;

@Controller
public class TravelController {

	 @Autowired
	 TravelService ts;
	
	@RequestMapping("planList.do")
	public ModelAndView planListView(ModelAndView mv, @RequestParam(value="page", required=false) Integer page) {
		
		int currentPage = 1;
		if(page != null) {
			currentPage = page;
		}

		System.out.println("page : " + page);
		
		int listCount = ts.getListCount();
		
		PageInfo pi2 = Pagination2.getPageInfo2(currentPage, listCount);
		
		ArrayList<Board> list = ts.selectList(pi2);
		ArrayList<PostTag> tl = ts.selectListTag();
		
		if(list != null) {
			mv.addObject("tl", tl);
			mv.addObject("list", list);
			mv.addObject("pi", pi2);
			mv.setViewName("travel/planListView");
		}else {
			
		}
		
		return mv;
		
	}
	
	
	@RequestMapping("planInsertView.do")
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
        ArrayList<Tag> tag = ts.getTagList();
        
        mv.addObject("tag", tag);
		mv.addObject("city", city);
		mv.setViewName("travel/planInsert");
        
        
        
		return mv;
	}

//	public static void main(String arg[]) throws Exception {

	@RequestMapping("selectCity.do")
	public void citySelect(HttpServletResponse response, String ctVal) throws Exception {
		response.setContentType("aplication/json; charset=utf-8");
		
		StringBuilder urlBuilder = new StringBuilder("http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaCode"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=e4W6es0aH0BXtgcISZ6LWxPWhmWicUPytTmUJ72zTxJIubFnvgsVrPPGg%2B%2FgJ18tvp7J9W6Mfsih5TwbYosrEw%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + URLEncoder.encode("e4W6es0aH0BXtgcISZ6LWxPWhmWicUPytTmUJ72zTxJIubFnvgsVrPPGg%2B%2FgJ18tvp7J9W6Mfsih5TwbYosrEw%3D%3D (URL - Encode)", "UTF-8")); /*공공데이터포털에서 발급받은 인증키*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("100", "UTF-8")); /*한 페이지 결과수*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*현재 페이지 번호*/
        urlBuilder.append("&" + URLEncoder.encode("MobileOS","UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8")); /*IOS (아이폰), AND (안드로이드), WIN (원도우폰), ETC*/
        urlBuilder.append("&" + URLEncoder.encode("MobileApp","UTF-8") + "=" + URLEncoder.encode("AppTest", "UTF-8")); /*서비스명=어플명*/
        urlBuilder.append("&" + URLEncoder.encode("areaCode","UTF-8") + "=" + URLEncoder.encode(ctVal, "UTF-8")); /*지역코드*/
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

        System.out.println(sb);
        
        // 총 갯수 찾기
        Pattern pattern = Pattern.compile("<totalCount>(.+?)</totalCount>");
        Matcher matcher = pattern.matcher(sb);
        matcher.find();
        
        // String > int 변환
        String total = matcher.group(1);        
        int tt =Integer.parseInt(total);
        
        System.out.println(tt);
        
        ArrayList<City> list = new ArrayList();

        // item 을 나눠 items 배열에 담는다
        Pattern itemPt = Pattern.compile("<item>(.+?)</item>");
        Matcher itemMc = itemPt.matcher(sb);
        
        String[] items = new String[tt];
        
        
        
        for(int i = 0; i < tt; i++) {
	        itemMc.find();
	        String item = itemMc.group(1);
	        
	        items[i] = item;
//	        System.out.println(items[i]);
        
        }
        
        ArrayList<City> city = new ArrayList<City>();
        
        for(int i = 0; i < items.length; i++) {
			// 시군구명 추출
			Pattern namePt = Pattern.compile("<name>(.+?)</name>");
			Matcher namemc = namePt.matcher(items[i]);

			namemc.find();
	        String cityName = namemc.group(1);
//	        System.out.println(cityName);
	        
			// 시군구명 추출
			Pattern codePt = Pattern.compile("<code>(.+?)</code>");
			Matcher codemc = codePt.matcher(items[i]);

			codemc.find();
	        String codeNo = codemc.group(1);
//	        System.out.println(codeNo);
	        
	        City ct = new City(cityName, codeNo);
	        city.add(ct);
	        
        }
        

        Gson gson = new Gson();
        gson.toJson(city, response.getWriter());
        
        
	}
	
	@RequestMapping("selectTravel.do")
	public void tAreaList(HttpServletResponse response, String ctVal, String ctCode) throws Exception {
		response.setContentType("aplication/json; charset=utf-8");
		
        StringBuilder urlBuilder = new StringBuilder("http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=e4W6es0aH0BXtgcISZ6LWxPWhmWicUPytTmUJ72zTxJIubFnvgsVrPPGg%2B%2FgJ18tvp7J9W6Mfsih5TwbYosrEw%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + URLEncoder.encode("e4W6es0aH0BXtgcISZ6LWxPWhmWicUPytTmUJ72zTxJIubFnvgsVrPPGg%2B%2FgJ18tvp7J9W6Mfsih5TwbYosrEw%3D%3D (URL - Encode)", "UTF-8")); /*공공데이터포털에서 발급받은 인증키*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("200", "UTF-8")); /*한 페이지 결과수*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*현재 페이지 번호*/
        urlBuilder.append("&" + URLEncoder.encode("MobileOS","UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8")); /*IOS (아이폰), AND (안드로이드), WIN (원도우폰), ETC*/
        urlBuilder.append("&" + URLEncoder.encode("MobileApp","UTF-8") + "=" + URLEncoder.encode("AppTest", "UTF-8")); /*서비스명=어플명*/
        
        urlBuilder.append("&" + URLEncoder.encode("listYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); /*목록 구분*/
        urlBuilder.append("&" + URLEncoder.encode("contentTypeId","UTF-8") + "=" + URLEncoder.encode("12", "UTF-8")); /*관광 타입 12 = 관광지*/
        urlBuilder.append("&" + URLEncoder.encode("areaCode","UTF-8") + "=" + URLEncoder.encode(ctVal, "UTF-8")); /*지역코드*/
        
        urlBuilder.append("&" + URLEncoder.encode("sigunguCode","UTF-8") + "=" + URLEncoder.encode(ctCode, "UTF-8")); /*시, 군, 구 코드*/
        
        
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
        
        System.out.println("최종 스크립트 : " + sb);

        Pattern ttp = Pattern.compile("<totalCount>(.+?)</totalCount>");
        Matcher mattt = ttp.matcher(sb);
        mattt.find();
        
        // 토탈 구하기
        String ttstr = mattt.group(1);  
        int tt = (Integer.parseInt(ttstr));
        
//        System.out.println(tt);
        
        
        // item 을 나눠 items 배열에 담는다
        Pattern itemPt = Pattern.compile("<item>(.+?)</item>");
        Matcher itemMc = itemPt.matcher(sb);
        
        String[] items = new String[tt];
        for(int i = 0; i < tt; i++) {
	        itemMc.find();
	        String item = itemMc.group(1);
//	        System.out.println(item);
	        
	        items[i] = item;
        
        }
        
//        System.out.println("강남대로 압구정로 161? : " + items[2]);
        
      ArrayList<CityInfo> cityInfo = new ArrayList<CityInfo>();
      
        for(int i = 0; i < items.length; i++) {
			// 관광지명 추출
			Pattern areaPt = Pattern.compile("<title>(.+?)</title>");
			Matcher areaCodemc = areaPt.matcher(items[i]);

	        areaCodemc.find();
	        String cityName = areaCodemc.group(1);
//	        System.out.println(cityName);

	        // 관광지 주소 추출
	        Pattern addrPt = Pattern.compile("<addr1>(.+?)</addr1>");
	        Matcher addrmc = addrPt.matcher(items[i]);

	        String addr;
	        
	        if(addrmc.find() == true) {
	        	addr = addrmc.group(1);	        
//	        	System.out.println(addr);
	        	
	        }else{
	        	addr = "주소 정보 없음";
	        }
	        
	        // 관광지 이미지 추출
	        Pattern timgPt = Pattern.compile("<firstimage>(.+?)</firstimage>");
	        Matcher timgmc = timgPt.matcher(items[i]);

	        String timg;
	        
	        if(timgmc.find() == true) {
	        	timg = timgmc.group(1);	        
//	        	System.out.println(timg);
	        	
	        }else{
	        	timg = "이미지 없음";
	        }
	        
	        // 관광지 x 좌표 추출
	        Pattern xpointPt = Pattern.compile("<mapx>(.+?)</mapx>");
	        Matcher xpointmc = xpointPt.matcher(items[i]);

	        String xpoint;
	        
	        if(xpointmc.find() == true) {
	        	xpoint = xpointmc.group(1);	        
//	        	System.out.println(xpoint);
	        	
	        }else{
	        	xpoint = "x 좌표값 없음";
	        }
	        
	        // 관광지 y 좌표 추출
	        Pattern ypointPt = Pattern.compile("<mapy>(.+?)</mapy>");
	        Matcher ypointmc = ypointPt.matcher(items[i]);

	        String ypoint;
	        
	        if(ypointmc.find() == true) {
	        	ypoint = ypointmc.group(1);	        
//	        	System.out.println(ypoint);
	        	
	        }else{
	        	ypoint = "y 좌표값 없음";
	        }
	        
	        // 관광지 코드 추출
	        Pattern tCodePt = Pattern.compile("<contentid>(.+?)</contentid>");
	        Matcher tCodeMc = tCodePt.matcher(items[i]);
	        
	        String tcode;
	        
	        if(tCodeMc.find() == true) {
	        	tcode = tCodeMc.group(1);	        
//	        	System.out.println(addr);
	        	
	        }else{
	        	tcode = "코드 정보 없음";
	        }
	        
	        CityInfo ctif = new CityInfo(cityName, addr, timg, xpoint, ypoint, tcode);
	        cityInfo.add(ctif);

        }

        
        Gson gson = new Gson();
        gson.toJson(cityInfo, response.getWriter());
	}
	
	

	@RequestMapping(value = "pInsert.do", method = RequestMethod.POST, produces = "application/text; charset=utf8")
	@ResponseBody
	public String planInsert(HttpServletResponse response, HttpSession session, @RequestBody List<Object> posex, Board b, Travel tv, Tag tg) {
		response.setContentType("aplication/json; charset=utf-8");

		// 로그인 된 유저 아이디 가져온다.
		Member mb = (Member) session.getAttribute("loginUser");
		
		String userId = mb.getId();
		
		
		// json에 붙어 온 firstImg 를 저장한다.
		String firstImg = (String) posex.remove(9);
		
		// json에 붙어온 제목 가져와 잘라내 저장한다.
		String mtitle = (String)posex.remove(8);
		
		// json에 붙어온 tagList를 저장한다.
		ArrayList tagList = (ArrayList) posex.remove(7);
		
		
		ArrayList tTypeArr = (ArrayList) tagList.get(0);
		ArrayList tNameArr = (ArrayList) tagList.get(1);
		
		int result = 0;
		

		b.setTitle(mtitle);
		b.setUserId(userId);
		b.setThumbnail(firstImg);
		
		result = ts.planInsert(b);
		

		 String msg = "";
		 if(result > 0) {
			 int result2 = 0;
			 
			 result2 = ts.planLikeThumbupInsert();
			 
			// post tag 테이블에 추가
			for(int i = 0; i < tTypeArr.size(); i ++) {
				int tResult = 0;
				
				String tagType = (String) tTypeArr.get(i);
				String tagName = (String) tNameArr.get(i);
				
				tg.setTagType(tagType);
				tg.setTagName(tagName);
				
				tResult = ts.insertTag(tg);
				
			}
			 
			 
			 
			 if(result2 > 0) {
				 
				 int result3 = 0;
		    	
				// 넘어온 json object를 배열 단위로 풀어준다.
			    for(int i = 0; i < posex.size(); i ++) {
			    	int pDay = i;

			    	// 배열값이 비었는지 확인하기 위하여 먼저 배열화함
			    	ArrayList testli = (ArrayList) posex.get(i);

			    	if(testli.isEmpty() == false) {
			    		result3 = ts.planDayInsert(i);
			    
				    	List<Object> mList = (List<Object>) posex.get(i);
	
				    	
				    	// 날짜별 지역을 찍어준다.
				    	for(int j = 0; j < mList.size(); j ++) {
					    	int result4 = 0;
					    	
			//	    		System.out.println("location");
			//	    		System.out.println(mList.get(j));
				    		
				    		// title과 latlng, code 나누기 위한 map 선언
				    		Map<String, Object> mlInfo = (Map<String, Object>) mList.get(j);
			
				    		String pTitle = (String) mlInfo.get("title");
			//	    		System.out.println(pTitle);
			
				    		int ptcode = Integer.valueOf((String) mlInfo.get("tcode"));
				    		//System.out.println(ptcode);
				    		
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
					    	
					    	result4 = ts.planInsertPoint(tv);
					    	
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
	
	
	@RequestMapping("planDetail.do")
	public ModelAndView planDetail(HttpSession session, ModelAndView mv, String postType, int postNo, @RequestParam("page") Integer page, LikedPost lp) {
		// 사용자가 보던 페이지(현재 페이지)를 목록 보기 했을 때 다시 보여주게 하게끔 해주는 코드
		int currentPage = 1;
		if(page != null) {
			currentPage = page;
		}
		
		System.out.println(postNo);
		
		// 조회수 올려준다.
		int result = ts.hitsUp(postNo);
		
		// 로그인 된 유저 아이디 가져온다.
		Member m = (Member) session.getAttribute("loginUser");
		if(m != null) {
			lp.setUserId(m.getId());
			lp.setPostNo(postNo);
			lp.setPostType(postType);
		
		}
		
		Comments cmnt = new Comments();
		
		cmnt.setPostNo(postNo);
		cmnt.setPostType(postType);
		
		// 댓글 불러오기
		ArrayList<Comments> cmnts = ts.getComments(cmnt);
		
		// 대댓글 불러오기
		ArrayList<ReComments> reCmnts = ts.getReComments(cmnt);
		
		System.out.println("cmnts" + cmnts);
		System.out.println("reCmnts" + reCmnts);
		
		LikedPost liked = ts.likedView(lp);
		Vote voted = ts.voteView(lp);
		
		System.out.println("liked : " + liked);
		System.out.println("voted : " + voted);
		
		
		MapBoard mb = ts.likeVoteView(lp);
		
		if(result > 0) {
			Board b = ts.selectPostView(postNo);
			
			if(b != null){
				ArrayList<Travel> t = ts.selectTravelList(postNo);

				Travel tLast = t.get(t.size() - 1);
				
				System.out.println(tLast.getNight());
				
				int dayNum = tLast.getNight();
				
				
				mv.addObject("board", b)
				.addObject("travel", t)
				.addObject("currentPage", currentPage)
				.addObject("dayNum", dayNum)
				.addObject("liked", liked)
				.addObject("voted", voted)
				.addObject("mapList", mb)
				.addObject("cmnts", cmnts)
				.addObject("reCmnts", reCmnts)
				.setViewName("travel/planDetail");
				
			}
			
			
		}else {
			
		}
		
		return mv;
	}
	
	
	@RequestMapping("likeUp.do")
	public void likeUp(HttpServletResponse response,
						@RequestParam(value="userId") String userId,
						@RequestParam(value="postType") String postType,
						@RequestParam(value="postNo") int postNo,
						LikedPost lp) throws IOException {
		response.setContentType("aplication/json; charset=utf-8");

		JSONObject jso = new JSONObject();
		
		String msg = "";
		
		if(userId.isEmpty()) {
			msg = "error";
		}else {
			msg = "success";
			
			lp.setUserId(userId);
			lp.setPostNo(postNo);
			lp.setPostType(postType);

			int lc = 0;
			int vc = 0;
			String userLiked = null;

			LikedPost lpList = ts.likedView(lp);
			
			if(lpList == null) {
				int lur = 0;
				lur = ts.insertLike(lp);

				lp.setLikeYn("Y");
				
			}else {
				
				lp.setLikeYn(lpList.getLikeYn());
				
				System.out.println("lpList : " + lpList);
				System.out.println("lpList YN : " + lpList.getLikeYn());
				
				int lpr = 0;
				
				lpr = ts.likeUp(lp);
				if(lpList.getLikeYn().equals("Y")) {					
					lp.setLikeYn("N");
				}else {
					lp.setLikeYn("Y");
				}
				
			}
			
			System.out.println("* lp : " + lp);
			int result = 0;

			result = ts.likeUpdate(lp);
			//////
			LikedPost lpv = new LikedPost();
			MapBoard mb = new MapBoard();
			
			lpv = ts.likedView(lp);
			userLiked = lp.getLikeYn();
			
			System.out.println("* userLiked : " + userLiked);
			
			
			lp.setLikeYn(userLiked);
			lp.setPostNo(postNo);
			lp.setPostType(postType);
			
			mb = new MapBoard();
			
			mb = ts.likeVoteView(lp);
			
			lc = mb.getLikeTotal();
			vc = mb.getVoteTotal();

			jso.put("lc", lc);
			
			jso.put("userLiked", userLiked);
			
			response.setContentType("text/html; charset=utf-8");
				
		}
			

		jso.put("msg", msg);
		
		PrintWriter out = response.getWriter();
		out.print(jso.toString());
		out.flush();
		
		
	}

	@RequestMapping("voteUp.do")
	public void voteUp(HttpServletResponse response,
						@RequestParam(value="userId") String userId,
						@RequestParam(value="postType") String postType,
						@RequestParam(value="postNo") int postNo,
						Vote v) throws IOException {
		response.setContentType("aplication/json; charset=utf-8");

		JSONObject jso = new JSONObject();
		
		String msg = "";
		
		if(userId.isEmpty()) {
			msg = "error";
		}else {
			msg = "success";
			
			v.setUserId(userId);
			v.setPostNo(postNo);
			v.setPostType(postType);

			int lc = 0;
			int vc = 0;
			String userVoted = null;

			Vote vpList = ts.voteView(v);
			
			if(vpList == null) {
				int lur = 0;
				lur = ts.insertVote(v);

				v.setPostYn("Y");
				
			}else {
				
				v.setPostYn(vpList.getPostYn());
				
				System.out.println("vpList : " + vpList);
				System.out.println("vpList YN : " + vpList.getPostYn());
				
				int lpr = 0;
				
				lpr = ts.voteUp(v);
				if(vpList.getPostYn().equals("Y")) {					
					v.setPostYn("N");
				}else {
					v.setPostYn("Y");
				}
				
			}
			
			int result = 0;

			result = ts.VoteUpdate(v);
			//////
			Vote vpv = new Vote();
			MapBoard mb = new MapBoard();
			
			vpv = ts.voteView(v);
			userVoted = vpv.getPostYn();
			
			System.out.println("* userVoted : " + userVoted);
			
			
			v.setPostYn(userVoted);
			v.setPostNo(postNo);
			v.setPostType(postType);
			
			mb = new MapBoard();
			
			mb = ts.likeVoteView(v);
			
			lc = mb.getLikeTotal();
			vc = mb.getVoteTotal();

			jso.put("vc", vc);
			
			jso.put("userVoted", userVoted);
			
			response.setContentType("text/html; charset=utf-8");
				
		}
			

		jso.put("msg", msg);
		
		PrintWriter out = response.getWriter();
		out.print(jso.toString());
		out.flush();
		
		
	}
	

	@RequestMapping("planModifyForm.do")
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
        ArrayList<Tag> tag = ts.getTagList();
        
        // 선택했던 여행지 얻어오기
        ArrayList<Travel> tv = ts.selectTravelList(postNo);

		Travel tLast = tv.get(tv.size() - 1);
		
		System.out.println(tLast.getNight());
		
		int dayNum = tLast.getNight();
        // 선택한 태그 값 얻어오기
        ArrayList<PostTag> pt = ts.getPostTagList(postNo);
        
		Board planOne = ts.selectPlan(postNo);
		
		mv.addObject("plan", planOne);
        mv.addObject("tag", tag);
        mv.addObject("pt", pt);
        mv.addObject("tlist", tv);
        mv.addObject("dayNum", dayNum);
		mv.addObject("city", city);
		mv.setViewName("travel/planModify");
		
		
		return mv;
	}

	

	@RequestMapping(value = "pModify.do", method = RequestMethod.POST, produces = "application/text; charset=utf8")
	@ResponseBody
	public String planModify(HttpServletResponse response, HttpSession session, @RequestBody List<Object> posex, Board b, Travel tv, PostTag tg) {
		response.setContentType("aplication/json; charset=utf-8");

		// 로그인 된 유저 아이디 가져온다.
		Member mb = (Member) session.getAttribute("loginUser");
		
		String userId = mb.getId();

		// json에 붙어 온 postNo 를 저장한다.
		int postNo = (int) posex.remove(10);
		
		System.out.println("postNo : " + postNo);
		
		// json에 붙어 온 firstImg 를 저장한다.
		String firstImg = (String) posex.remove(9);
		
		// json에 붙어온 제목 가져와 잘라내 저장한다.
		String mtitle = (String)posex.remove(8);
		
		// json에 붙어온 tagList를 저장한다.
		ArrayList tagList = (ArrayList) posex.remove(7);
		
		
		ArrayList tTypeArr = (ArrayList) tagList.get(0);
		ArrayList tNameArr = (ArrayList) tagList.get(1);

		b.setPostNo(postNo);
		b.setTitle(mtitle);
		b.setUserId(userId);
		b.setThumbnail(firstImg);

		int result = 0;

		// 제목 수정
		result = ts.planModifyPost(b);
		
		// 해당 postNo에 있는 travel 좌표들을 삭제한다.
		int mr = 0;
		mr = ts.planModifyB(postNo);
		String msg = "글이 정상적으로 수정되었습니다.";
		if(mr > 0) {
				// 넘어온 json object를 배열 단위로 풀어준다.
			    for(int i = 0; i < posex.size(); i ++) {

			    	// 배열값이 비었는지 확인하기 위하여 먼저 배열화함
			    	ArrayList testli = (ArrayList) posex.get(i);

			    	if(testli.isEmpty() == false) {
			    
				    	List<Object> mList = (List<Object>) posex.get(i);
	
				    	
				    	// 날짜별 지역을 찍어준다.
				    	for(int j = 0; j < mList.size(); j ++) {
					    	int piResult = 0;
				    		
				    		// title과 latlng, code 나누기 위한 map 선언
				    		Map<String, Object> mlInfo = (Map<String, Object>) mList.get(j);
			
				    		String pTitle = (String) mlInfo.get("title");
			//	    		System.out.println(pTitle);
			
				    		int ptcode = Integer.valueOf((String) mlInfo.get("tcode"));
				    		//System.out.println(ptcode);
				    		
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
					    	
					    	piResult = ts.planMoidfyPoint(tv);
					    	
					    	
			    		}
			    		
			    	}

		    	}
			
		}
		
		// POST TAG 삭제
		int ptr = 0;
		ptr = ts.planModifyPT(postNo);

		if(ptr > 0) {
			// post tag 테이블에 추가
			for(int i = 0; i < tTypeArr.size(); i ++) {
				int tResult = 0;
				
				String tagType = (String) tTypeArr.get(i);
				String tagName = (String) tNameArr.get(i);
				
				tg.setTagType(tagType);
				tg.setTagName(tagName);
				tg.setPostNo(postNo);
				
				tResult = ts.ModifyTag(tg);
				
			}
		}
		
		 return msg;
	    
	}
	
	@RequestMapping("planDelete.do")
	public String planDelete(@RequestParam("postNo") int postNo) {
		int result = 0;
		result = ts.planDelete(postNo);
		
		return "redirect:planList.do";
		
	}
	
	
	@RequestMapping("commInsert.do")
	@ResponseBody
	public String commInsert(HttpSession session, String postType, int postNo, String commCont) {

		// 로그인 된 유저 아이디 가져온다.
		Member mb = (Member) session.getAttribute("loginUser");
		
		String userNickname = mb.getNickname();
		
		int result = 0;

		Comments cmnt = new Comments();
		
		cmnt.setPostNo(postNo);
		cmnt.setPostType(postType);
		cmnt.setCmntWirter(userNickname);
		cmnt.setCmntContents(commCont);
		
		// 댓글 불러오기
		ArrayList<Comments> cmnts = ts.getComments(cmnt);
		
		Comments commLastLine = cmnts.get(cmnts.size() - 1);
		int commlLastNo = commLastLine.getCmntNo();
		
		cmnt.setCmntNo(commlLastNo + 1);
		
		result = ts.insertComment(cmnt);
		
		if(result > 0) {
			System.out.println("insert success");
			return "success";
		}else {
			System.out.println("insert error");
			return "error";
		}

	}
	
	@RequestMapping("commView.do")
	public void getReplyList(ModelAndView mv, HttpServletResponse response, int postNo, String postType) throws JsonIOException, IOException {
		response.setContentType("aplication/json; charset=utf-8");
		JSONObject jso = new JSONObject();
		JSONArray jarr = new JSONArray();
		
		Comments cmnt = new Comments();
		
		cmnt.setPostNo(postNo);
		cmnt.setPostType(postType);
		
		// 댓글 불러오기
		ArrayList<Comments> cmnts = ts.getComments(cmnt);
		
		// 대댓글 불러오기
		ArrayList<ReComments> reCmnts = ts.getReComments(cmnt);

//		jso.put("cmnts", cmnts);
//		jso.put("reCmnts", reCmnts);
		
		jarr.add(cmnts);
		jarr.add(reCmnts);
//		
//		System.out.println(jarr);
//		
//		PrintWriter out = response.getWriter();
//		out.print(jarr.toArray());
//		out.flush();
		

		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
//
		gson.toJson(jarr, response.getWriter());
//		gson.toJson(reCmnts, response.getWriter());

//		mv.addObject("cmnts", cmnts);
//		mv.addObject("reCmnts", reCmnts);
//
//		mv.setViewName("travel/planDetail");
//		
//		return mv;
		
	}
}

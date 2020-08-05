package com.kh.FinalProject.travel.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.kh.FinalProject.common.Pagination2;
import com.kh.FinalProject.member.model.vo.Member;
import com.kh.FinalProject.travel.model.service.TravelService;
import com.kh.FinalProject.travel.model.vo.Board;
import com.kh.FinalProject.travel.model.vo.City;
import com.kh.FinalProject.travel.model.vo.CityInfo;
import com.kh.FinalProject.travel.model.vo.PageInfo;
import com.kh.FinalProject.travel.model.vo.PostTag;
import com.kh.FinalProject.travel.model.vo.Tag;
import com.kh.FinalProject.travel.model.vo.Travel;

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
		
		int listCount = ts.getListCount();
		System.out.println(listCount);
		
		PageInfo pi2 = Pagination2.getPageInfo2(currentPage, listCount);
		
		ArrayList<Board> list = ts.selectList(pi2);
		
		ArrayList<PostTag> tl = ts.selectListTag();
		
		System.out.println(tl);
		System.out.println(list);
		
		
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
}

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=f4f7814c8bb01f8a486031362815520e&libraries=services"></script>

<style>
	ul.dayNight { overflow:auto; height:auto; }
	#map { width:100%; height:720px; }
</style>
</head>
<body>

<jsp:include page="../common/header.jsp" />
    <div id="container" class="cf">
        <div class="titleSec" style="background:url('${board.thumbnail }' )no-repeat 0 20%;  background-size:cover;">
            <p class="planTitle">${board.title }</p>
            <p class="ltSec">
                <span class="likes"><i class="xi-heart-o"></i> 0</span>
                <span class="voting"><i class="xi-star-o"></i> 300</span>
            </p>
            <div class="cover"></div>
        </div>
        <div class="wrap cf">
            <div class="leftSelBox">
                <div class="bottSel">
                    <h3>전체 일정 루트</h3>
                    <ul class="dayNight list">
	                    <c:forEach var="i" begin="0" end="${dayNum }">
						<li>
						<p class="tit">DAY ${i + 1 }</p>
                            <ul class="spot" style="height:auto; overflow:auto;">
							<c:forEach var="tv" items="${travel }">
		                    	<c:set var="night" value="${tv.night }" />
								<c:if test="${i eq night }">
		                                <li>${tv.tName }</li>
								</c:if>
		                    </c:forEach> 
                            </ul>
                        </li>
						</c:forEach>
                    </ul>
                </div><!-- bottSel -->
            </div><!-- // leftSelBox -->
            <div class="rightMapBox">
				<div id="map"></div>
            </div><!-- // rightMapBox -->
            
            <script>
				
	            $(document).on("ready", function(){
	            	// 마커를 표시할 위치와 title 객체 배열입니다 
		        	var positions = [];
		        

		    		// 클릭한 좌표값 담아줌
		    		pea = [];
		    		peb = [];
		    		pec = [];
		    		ped = [];
		    		pee = [];
		    		pef = [];
		    		peg = [];

		    		posex = [pea, peb, pec, ped, pee, pef, peg];
		    		
		            <c:forEach items="${travel }" var="tv">
						var XP = "${tv.txpoint}";
						var YP = "${tv.typoint}";
						var tvDataTit = "${tv.tName}";
						
						var night = "${tv.night}";
	            		
			        // 배열 추가 설정
						var str = {title: tvDataTit, latlng: new kakao.maps.LatLng(YP, XP)};
						switch(night){
							case '0' : pea.push(str); break;
							case '1' : peb.push(str); break;
							case '2' : pec.push(str); break;
							case '3' : ped.push(str); break;
							case '4' : pee.push(str); break;
							case '5' : pef.push(str); break;
							case '6' : peg.push(str); break;
						}
						
			        
						positions.push(str);
	
					</c:forEach>

					console.log(posex);
		        
		        
					
					colors = ['#bc2626', '#9726bc', '#5726bc', '#263ebc', '#267ebc', '#26bcac', '#3bbc26'];
			
					
		            var mapContainer = document.getElementById('map'), // 지도를 표시할 div  
		            mapOption = { 
		                center: new kakao.maps.LatLng(37.497978, 127.027524), // 지도의 중심좌표
		                level: 7 // 지도의 확대 레벨
		            };
		
			        var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
			         
			
			        // 마커 이미지의 이미지 주소입니다
			        var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png"; 

					for(var i = 0; i <= night; i ++){
						
						for (var j = 0; j < posex[i].length; j ++) {
						    
						    // 마커 이미지의 이미지 크기 입니다
						    var imageSize = new kakao.maps.Size(24, 35); 
						    
						    // 마커 이미지를 생성합니다    
						    var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize); 
						    
						    // 마커를 생성합니다
						    marker = new kakao.maps.Marker({
						    	map : map,
						        position: posex[i][j].latlng, // 마커를 표시할 위치
						        title : posex[i][j].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
						        image : markerImage // 마커 이미지 
						    });
						

						    linePath = [];
							   for(var k = 0; k < posex[i].length; k++){
								   linePath.push(posex[i][k].latlng);
							   }
							
							 // 선을 구성하는 좌표 배열입니다. 이 좌표들을 이어서 선을 표시합니다
						    //var linePoint = str.latlng;

						 	
						      // 지도에 표시할 선을 생성합니다
						      polyline = new kakao.maps.Polyline({
						    	  map : map,
						          path: linePath, // 선을 구성하는 좌표배열 입니다
						          strokeWeight: 5, // 선의 두께 입니다
						          strokeColor: colors[i], // 선의 색깔입니다
						          strokeOpacity: 0.5, // 선의 불투명도 입니다 1에서 0 사이의 값이며 0에 가까울수록 투명합니다
						          strokeStyle: 'solid' // 선의 스타일입니다
						      });

						}
						
					}

	            });
			</script>
            
            
        </div><!-- // wrap end -->
    </div><!-- // container end -->
<jsp:include page="../common/footer.jsp" />
</body>
</html>
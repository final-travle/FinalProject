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
	ul.leftSelBox .spot { overflow:auto; height:442px !importent; }
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
                            <ul class="spot">
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
		        
	            	
	            	
		            <c:forEach items="${travel }" var="tv">
						var XP = "${tv.txpoint}";
						var YP = "${tv.typoint}";
						var tvDataTit = "${tv.tName}";
						
						var night = "${tv.night}";
	            		
			        // 배열 추가 설정
						var str = {title: tvDataTit, latlng: new kakao.maps.LatLng(YP, XP)};
						
						positions.push(str);
	
					</c:forEach>
			        
					
					colors = ['#bc2626', '#9726bc', '#5726bc', '#263ebc', '#267ebc', '#26bcac', '#3bbc26'];
			
					
		            var mapContainer = document.getElementById('map'), // 지도를 표시할 div  
		            mapOption = { 
		                center: new kakao.maps.LatLng(37.497978, 127.027524), // 지도의 중심좌표
		                level: 7 // 지도의 확대 레벨
		            };
		
			        var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
			         
			
			        // 마커 이미지의 이미지 주소입니다
			        var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png"; 
			            
			        for (var i = 0; i < positions.length; i ++) {
			            
			            // 마커 이미지의 이미지 크기 입니다
			            var imageSize = new kakao.maps.Size(24, 35); 
			            
			            // 마커 이미지를 생성합니다    
			            var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize); 
			            
			            // 마커를 생성합니다
			            var marker = new kakao.maps.Marker({
			                map: map, // 마커를 표시할 지도
			                position: positions[i].latlng, // 마커를 표시할 위치
			                title : positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
			                image : markerImage // 마커 이미지 
			            });
			        }
	            });
			</script>
            
            
        </div><!-- // wrap end -->
    </div><!-- // container end -->
<jsp:include page="../common/footer.jsp" />
</body>
</html>
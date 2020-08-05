<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=f4f7814c8bb01f8a486031362815520e&libraries=services"></script>
<style>
	body, div, ul, li, p, span, h1, h2, h3, h4 { margin:0; padding:0; list-style:none; }
	html { height:100%; position:relative; }
	
	
	.titleInput { width:100%; text-align:center; padding:20px 0; background:#ddd; }
	.titleInput input { width:98%; height:50px; font-size:26px; }
	 
	.daySelectWrap {  }
	.daySelectWrap .cover { width:100%; height:100%; position:fixed; top:0; left:0;  background:rgba(0,0,0,.7); z-index:10; }
	.daySelectWrap .daySelectBox { position:absolute; top:40%; left:50%; z-index:11; width: 400px; background:#fff; text-align:center; padding:20px 0; margin-left:-200px; }
	.daySelectWrap .daySelectBox select { width:300px; height:30px; font-size:16px; margin:20px 0; }
	
	div.leftSelBox { position:relative; width:10%; }
	.stateWrap {  width:100%; border-right:1px solid #ddd; box-sizing:border-box; }
	.stateWrap ul li.title { background:#bd9dec; color:#fff; }
	.cityWrap { position: absolute; top: 0; left: 100%; z-index: 2; width: 100%; background:#fff; border-right:1px solid #ddd; box-sizing:border-box; }
	.travelAWrap { position: absolute; top: 0; left: 200%; z-index: 2; width: 100%; background:#fff; border-right:1px solid #ddd; box-sizing:border-box; }
	.stateWrap ul li,
	.cityWrap ul li,
	.travelAWrap ul li { border-bottom:1px solid #ddd; box-sizing:border-box; }
	.travelAWrap ul li img { width:100px; }
	.travelAWrap ul li p.title { font-weight:700; }
	.travelAWrap ul li p.addr { color:#666; font-size:12px; }
	
	.rightBox { float:left; width:90%; height:100%; position:relative; }
	.rightBox .btns { position:absolute; z-index:10; right:100px; bottom: 160px; padding:20px; background:rgba(255,255,255,.7);}
	#map { width:100%; height:921px; }
	
	.tagWrap input { display:none; }
	.tagWrap label { display:inline-block; background:#fff; color:#666; box-sizing:border-box; border:2px solid #ddd; padding:2px 10px; border-radius:5px; margin:0 6px 6px 0; font-size:20px; }
	
	.dn1 .dayTit { background:#ddd; };
	.on { background:#bd9dec; color:#fff; font-weight:700; }
</style>
</head>
<body>
<jsp:include page="../common/header.jsp" />
<!-- day night 값 입력 받는 폼 -->

<div id="container" class="cf">
	<div class="titleInput">
		<input type="text" name="mtitle" id="mtitle" placeholder="제목을 입력하세요"/>
	</div>
		<div class="leftSelBox">
			<div class="stateWrap">
				<ul class="state">
					<li class="title">관광지 선택</li>
					<c:forEach var="city" items="${city }">
					<li>
						<span>${city.ctName }</span>
						<input type="hidden" value="${city.ctCode }">
					</li>
					</c:forEach>
				</ul> 
				<ul class="dayNight">
					<li class="title">일정을 체크해주세요!</li>
				</ul>
			</div>
			<div class="cityWrap">
				<ul class="rCity">
				</ul>
			</div>
			<div class="travelAWrap">
				<ul class="rTravel">
				</ul>
			</div>
		</div>
	
	
		<div class="rightBox">
			<div id="map"></div>
			<div class="btns">
				<button type="submit" class="btn colorBtn apply">등록</button>
				<button class="btn">취소</button>
			</div>
			<div class="tagWrap">
			<c:forEach var="tag" items="${tag }">
				<input type="checkbox" name="tag" id="${tag.tagName }" class="${tag.tagType }" value="${tag.tagName }"><label for="${tag.tagName }"># ${tag.tagName }</label>
			</c:forEach>
			</div>
		</div>

</div><!-- // container end -->

<jsp:include page="../common/footer.jsp" />

		<div class="daySelectWrap">
			<div class="daySelectBox">
				<h3 class="title">여행 날짜를 선택해주세요!</h3>
				<form>
				<select id="dnSelect" name="dayNight">
					<option value="2">1박 2일</option>
					<option value="3">2박 3일</option>
					<option value="4">3박 4일</option>
					<option value="5">4박 5일</option>
					<option value="6">5박 6일</option>
					<option value="7">6박 7일</option>
				</select>
				<c:url var="pInsert" value="pInsert.do"/>
				<div class="btns">
					<button type="button" class="btn colorBtn apply">확인</button>
					<button type="button" class="btn">취소</button>
				</div>
				</form>
			</div>
		<div class="cover"></div>
		</div>
		
	<script>
	
	
    // 지도
    var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = { 
        center: new kakao.maps.LatLng(37.497978, 127.027524), // 지도의 중심좌표
        level: 7 // 지도의 확대 레벨
    };

	var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
	

    
    function mapPointView(){

	    // 마커가 지도 위에 표시되도록 설정합니다
	    marker.setMap(map);
		  // 지도에 선을 표시합니다 
	  	polyline.setMap(map);
    }
	
		$(".daySelectBox .apply").on("click", function(){
			dnOption = $("#dnSelect option:selected").val();
			var dnText = $("#dnSelect option:selected").text();
			$(".daySelectWrap").hide();
			
			
			// title에 input hidden으로 value 값을 붙여준다.
			$(".dayNight .title").text(dnText + " 일정").append("<input type='hidden' class='dn' value='"+ dnOption + "' />");
		
			for(var i = 0; i < dnOption; i ++){
				var $li = $("<li class='dayTit'>").text("DAY" + (i + 1));
				var $ul = $("<ul class='dn" + (i + 1) + " dn'>").append($li);
				$(".dayNight").append($ul);
			}
		});
		
		ctVal = "";
		$(".state li").not(".title").on("click", function(){
			// 클릭 시 색깔 바뀜
			$(".state li").removeClass("on");
			$(this).addClass("on");
			$(".cityWrap").css("height", 921);
			
			ctVal = $(this).children("input").val();
			var ctData = $(this).html();
			
			$.ajax({
				url : "selectCity.do",
				data : {ctVal : ctVal},
				success : function(data){
					/* alert("성공"); */
					$ul = $(".cityWrap .rCity");
					
					for(var i in data){
						$li = $("<li>");
						
						$ctName = $("<p>").text(data[i].ctName);
						$ctCode = $("<input type='hidden'>").val(data[i].ctCode);

						$li.append($ctName);
						$li.append($ctCode);
						
						$ul.append($li);
						
					}
					
				},
				error : function(request, status, errorData){
					alert("error code: " + request.status + "\n"
	                          +"message: " + request.responseText
	                          +"error: " + errorData);
				}
				
			});
			
			$(".cityWrap ul").html("");
			$(".travelAWrap .rTravel").html("");

		});
		// 시군구 선택 코드
        $(document).on("click", ".cityWrap .rCity li", function() {
			// 클릭 시 색깔 바뀜
			$(".rCity li").removeClass("on");
			$(this).addClass("on");
			$(".travelAWrap").css({"height": 921, "overflow-y" : "scroll"});
			
			
			var ctCode = $(this).children("input").val();
			
			$.ajax({
				url : "selectTravel.do",
				data : {ctVal : ctVal, ctCode : ctCode},
				success : function(data){
					/* console.log(data[0].cityName); */
					
					$tvul = $(".travelAWrap .rTravel");
					
					for(var i in data){
						$li = $("<li>");
						
						var imgSrc = data[i].cimgSrc;
						if(imgSrc == "이미지 없음"){
							imgSrc = 'https://via.placeholder.com/400x300?text=image+none';
						}
						
						$ctName = $("<p class='title'>").text(data[i].cityName);
						$ctAddr = $("<p class='addr'>").text(data[i].addr);
						$ctImgSrc = $("<img>").attr("src", imgSrc);
						$xpoint = $("<input name='xpoint' class='xpoint' type='hidden'>").val(data[i].xpoint);
						$ypoint = $("<input name='ypoint' class='ypoint' type='hidden'>").val(data[i].ypoint);
						$tcode = $("<input name='tcode' class='tcode' type='hidden'>").val(data[i].tcode);

						$li.append($ctName);
						$li.append($ctAddr);
						$li.append($ctImgSrc);
						$li.append($xpoint);
						$li.append($ypoint);
						$li.append($tcode);
						
						$tvul.append($li);
					}
					
				},
				error : function(request, status, errorData){
					alert("error code: " + request.status + "\n"
	                          +"message: " + request.responseText
	                          +"error: " + errorData);
				}
			});

			$(".travelAWrap .rTravel").html("");
		

        });

		XP = 0;
		YP = 0;
		
		// 클릭한 좌표값 담아줌
		pea = [];
		peb = [];
		pec = [];
		ped = [];
		pee = [];
		pef = [];
		peg = [];

		// 클릭한 애들 포인트 담아줌
		pa = [];
		pb = [];
		pc = [];
		pd = [];
		pe = [];
		pf = [];
		pg = [];

		la = [];
		lb = [];
		lc = [];
		ld = [];
		le = [];
		lf = [];
		lg = [];

		posex = [pea, peb, pec, ped, pee, pef, peg];
		
		lineLine = [la, lb, lc, ld, le, lf, lg];

		posArr = [pa, pb, pc, pd, pe, pf, pg];
		
		var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png"; 
		
		var dnClick = '1';
		dnulClass = "dn1 dn";
		
		$(document).on("click", ".dayNight ul .dayTit", function(){
			dnulClass = $(this).parents("ul").attr("class");
			
			dnClick = dnulClass.replace(/[^0-9]/g,'');		// 숫자만 추출해줌
			// 클릭시 색깔 바뀜
			$(".dayNight .dayTit").css({"background" : "transparent"});
			$(this).css({"background" : "#ddd"});
			

			
		});
		
		// 누른 값의 첫번째만 실행되는 함수 // 처음 누른 값의 이미지만 뽑는다.
        $(document).one("click", ".travelAWrap .rTravel li", function() {
			firstImg = $(this).children("img").attr("src");
			
			console.log(firstImg);
		});
		
         $(document).on("click", ".travelAWrap .rTravel li", function() {
        	 // dayNight 의 마지막 li의 값을 뽑아온다
 			var lastli = $(".dayNight").find(".dn").eq(dnClick).find("li").last().html();
        	 
			var tvDataTit = $(this).find(".title").text();
			XP = parseFloat($(this).find(".xpoint").val());
			YP = parseFloat($(this).find(".ypoint").val());
			tcode = $(this).find(".tcode").val();

			
			var $li = $("<li>");
			
			// 배열 추가 설정
			var str = {title: tvDataTit, latlng: new kakao.maps.LatLng(YP, XP), tcode : tcode};
			
			colors = ['#bc2626', '#9726bc', '#5726bc', '#263ebc', '#267ebc', '#26bcac', '#3bbc26'];

			
			
			// dayNight 의 마지막 li의 title과 방금 누른 title을 비교하는 식 
			if(lastli == tvDataTit){
				alert("중복 선택하셨습니다.");
			}else{
				
				switch(dnClick){
					case '1' : pea.push(str); break;
					case '2' : peb.push(str); break;
					case '3' : pec.push(str); break;
					case '4' : ped.push(str); break;
					case '5' : pee.push(str); break;
					case '6' : pef.push(str); break;
					case '7' : peg.push(str); break;
				}
				
				console.log(posex);
				
				$li.append(tvDataTit).attr("class", "dnCont");
				$(".dayNight .dn").eq(dnClick).append($li);

				for(var i = 0; i < dnClick; i ++){
					
					for (var j = 0; j < posex[i].length; j ++) {
					    
					    // 마커 이미지의 이미지 크기 입니다
					    var imageSize = new kakao.maps.Size(24, 35); 
					    
					    // 마커 이미지를 생성합니다    
					    var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize); 
					    
					    // 마커를 생성합니다
					    marker = new kakao.maps.Marker({
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
					          path: linePath, // 선을 구성하는 좌표배열 입니다
					          strokeWeight: 5, // 선의 두께 입니다
					          strokeColor: colors[i], // 선의 색깔입니다
					          strokeOpacity: 0.5, // 선의 불투명도 입니다 1에서 0 사이의 값이며 0에 가까울수록 투명합니다
					          strokeStyle: 'solid' // 선의 스타일입니다
					      });

					}
					
				}

			    posArr[dnClick - 1].push(marker);
			    lineLine[dnClick - 1].push(polyline);

			    

			}
			mapPointView();

        });
         
      
      

     	// 배열에 추가된 마커들을 지도에 표시하거나 삭제하는 함수입니다
       	// 좌측 경로 삭제
         $(document).on("click", ".stateWrap .dayNight .dnCont", function() {
        	 // dayNight 의 마지막 li의 값을 뽑아온다
  			var lastli = $(".dayNight").find(".dn").eq(dnClick).find("li").last().html();
        	var thisli = $(this).html();
        	 
        	 console.log(lastli);
        	 console.log(thisli);
        	 
        	ck = $(this).parent().index();
        	number = $(this).index();
        	
        	if(thisli == lastli){
	       		pointDelete();
				$(this).remove();
        	}else {
        		alert("마지막 선택한 관광지부터 삭제해주세요!");
        	}
         });
         
         function pointDelete(map){
  			posArr[(ck - 1)][(number - 1)].setMap(map);
  			lineLine[(ck - 1)][(number - 1)].setMap(map);
  			
      		posArr[(ck - 1)].splice((number - 1), 1);
      		lineLine[(ck - 1)].splice((number - 1), 1);
      		posex[(ck - 1)].splice((number - 1), 1);
         }
         

         
        $(".tagWrap input[type='checkbox']").on("change", function(){
        	   if($(this).is(":checked")){
               		$(this).next("label").css({"background" : "#bd9dec", "border-color" : "#bd9dec", "color" : "#fff"});
               }else{
            	   $(this).next("label").css({"background" : "#fff", "border-color" : "#ddd", "color" : "#666"});   
               }
        	   
        	   
        });
        
     	$(".rightBox .btns .apply").on("click", function(){
     		var chkType = [];
     		var chkName = [];
     		var chkArr = [chkType, chkName];
     		$('input:checkbox[name=tag]:checked').each(function () {
     			//chkArr.push($(this).val());
     			chkName.push($(this).val());
     			chkType.push($(this).attr("class"));
     		});
     		
     		posex.push(chkArr);
     		posex.push(firstImg);
     		
     		// 제목 json에 붙여 전송
     		var mtitle = $("#mtitle").val();
     		
     		posex.push(mtitle);

     		 $.ajax({
     	        type: "POST",
     	        url: "pInsert.do",
     	        data: JSON.stringify(posex),
     	        contentType:'application/json; charset=UTF-8',
     	        dataType:"text",
     	        async: false,
     	        success: function(msg) {
     	        	alert(msg);
     	        	// detail page 강제 이동
     	        	location.href="${contextPath}/planList.do";
     	        },
				error : function(request, status, errorData){
					alert("error code: " + request.status + "\n"
	                          +"message: " + request.responseText
	                          +"error: " + errorData);
				}
     	    });
     		
   		});
     	
         
         
	</script>
</body>
</html>
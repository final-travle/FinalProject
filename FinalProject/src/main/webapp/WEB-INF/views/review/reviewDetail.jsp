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
	.leftBox {  }
	div.rightBox { float:left; width:74%; height:100%; position:relative; }
	.rightBox .btns { position:absolute; z-index:10; right:100px; bottom: 50px; padding:20px; background:rgba(255,255,255,.7); }
	.rightBox .btns .delete {color : #bd9dec; font-weight:700; }
	.ltSec span:hover { cursor:pointer; }
	
	.btns a { display:inline-block; }
	
	.reviewContents {  border-top:1px solid #ddd; box-sizing:border-box; line-height:1.8; margin-bottom:30px; }
	.reviewContents img { margin:10px 0; max-width: 1200px; }
	.reviewContents .rvTitle { font-size:26px; background:#bd9dec; color:#fff; text-align:center; padding:10px 0; margin-bottom:30px; }
	.commInsert .not_login { text-align:center; padding:30px 0 20px; border-top:1px solid #666; }
</style>
</head>
<body>
<jsp:include page="../common/header.jsp" />
    <div id="container" class="cf">
        <div class="titleSec" style="background:url('${board.thumbnail }' )no-repeat 0 20%;  background-size:cover;">
            <p class="planTitle">${board.title }</p>
            <p class="ltSec">
                <span class="likes"></span>
                <span class="voting"><i class="xi-star-o"></i> ${mapList.voteTotal}</span>
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
            <div class="rightBox">
				<div id="map"></div>
				<div class="btns">
            	<c:if test="${loginUser.id eq board.userId}">
					<c:url var="reviewModifyForm" value="reviewModifyForm.do">
						<c:param name="postNo" value="${board.postNo }"/>
					</c:url>
					<a href="${reviewModifyForm }" class="btn colorBtn apply">수정</a>
					<a href="#none" class="btn delete">삭제</a>
				</c:if>
					<a onclick="setBounds()" class="btn allViewBtn">전체보기</a>
				</div>
            </div><!-- // rightMapBox -->
        </div><!-- // wrap end -->
        <!-- review contents area -->
        <div class="reviewContents">
	        <div class="rvTitle">
	     	   ${board.title }
	        </div>
	        <div id="content">
	        	${board.postContents }
	        </div>
        </div>        
        <!-- // review contents area end -->
         <div class="commentSec">
             <p class="commCount"></p>
             <table>
             <!-- 댓글 입력 테이블 -->
             </table>
             <div class="commInsert cf">
                 <c:if test="${!empty sessionScope.loginUser}">
                 <p>댓글 입력</p>                 
                 <textarea rows="5" placeholder="리뷰에 예쁜 댓글을 달아주세요 :)"></textarea>
                 <p class="btn colorBtn">댓글 등록</p>
                 </c:if>
                 
                 <c:if test="${empty sessionScope.loginUser}">
                 <p class="not_login">로그인을 하시면 댓글을 달 수 있습니다.</p>
                 </c:if>
             </div>
         </div><!-- // commentSec end -->
    </div><!-- // container end -->
<script>

postType = ${board.postType };
postNo = ${board.postNo };

console.log(postType);

$(document).on("ready", function(){
	commView();
});

// 300자 넘어가면 자르는 함수
$(document).on("keyup", ".commInsert", function() {
	var commVal = $(".commInsert textarea").val();
	var commCount = commVal.length;

	var cut = 300 - commCount;
	if(commCount > 300){
		var cutStr = commVal.slice(0, cut);
		$(".commInsert textarea").val(cutStr);
		alert("댓글은 300자까지 입력 가능합니다.");
	}
});

$(document).on("keyup", ".insertarea, .recommArea, .reinsertarea", function() {
	var commVal = $(this).val();
	var commCount = commVal.length;

	var cut = 300 - commCount;
	if(commCount > 300){
		var cutStr = commVal.slice(0, cut);
		$(this).val(cutStr);
		alert("댓글은 300자까지 입력 가능합니다.");
	}
});


$(".commInsert p.btn").on("click", function(){
	var commCont = $(".commInsert textarea").val();
	
	$.ajax({
		url : "commInsert.do",
		data : { "postType" : postType, "postNo" : postNo, "commCont" : commCont},
		success : function(data){
			if(data == "success"){
				$(".commInsert textarea").val("");
				commView();
			}
		},
		error : function(request, status, errorData){
			alert("error code: " + request.status + "\n"
                      +"message: " + request.responseText
                      +"error: " + errorData);
		}
	});
});

// 리뷰 리스트
function commView(){
	$.ajax({
		url : "commView.do",
		data: { "postType" : postType, "postNo" : postNo },
		dataType : "json",
		success : function(data){
			console.log(data[0]);
			console.log(data[1]);
			
			$(".commCount").text("COMMENTS (" + (data[0].length + data[1].length) + ")");

			$(".commentSec table").html("");
			var $commTable = $(".commentSec table");
			
			if(data[0].length > 0){
				for(var i in data[0]){
					
					var $commtr = $("<tr class='comm'>");
					var $usertd = $("<td>");
					var $userRound = $("<div class='userRound'>");
					var $commp = $("<p>");
					var $commConttd = $("<td>");
					var $commdatetd = $("<td>");
					
					var $reCommTable = $("<table>");
					
					$commp.append(data[0][i].cmntWirter);
					$userRound.append($commp);
					$usertd.append($userRound);
					
					$commConttd.text(data[0][i].cmntContents);
					
					var nickname = data[0][i].cmntWirter;
					
					if("${loginUser.nickname }" == nickname){
					var $commModify = $("<span class='commModify'>").text("수정");
					$commConttd.append($commModify);
						
					}

					
	                <c:if test="${!empty sessionScope.loginUser}">
					var $reCommt = $("<span class='reCommt'>").text("답글");
					$commConttd.append($reCommt);
					</c:if>
					
					$commdatetd.append(data[0][i].cmntDate);

					$commtr.attr("id", data[0][i].cmntNo);
					
					$commtr.append($usertd);
					$commtr.append($commConttd);
					$commtr.append($commdatetd);
					
					
					var $retr = $("<tr>");
					var $retd = $("<td colspan='3'>");
					
					for(var j in data[1]){
						if(data[1][j].cmntNo == data[0][i].cmntNo){
							
							var $recommtr = $("<tr class='reComm'>");
							var $reusertd = $("<td>");
							var $reuserRound = $("<div class='userRound'>");
							var $recommp = $("<p>");
							var $recommConttd = $("<td>");
							var $recommdatetd = $("<td>");
							
							$recommp.append(data[1][j].rcmntWirter);
							$reuserRound.append($recommp);
							$reusertd.append($reuserRound);
							

							$recommConttd.text(data[1][j].rcmntContents);


							var nickname = data[1][j].rcmntWirter;
							
							if("${loginUser.nickname }" == nickname){
							var $recommModify = $("<span class='recommModify'>").text("수정");
							$recommConttd.append($recommModify);
							}
							
							$recommdatetd.append(data[1][j].rcmntDate);
							

							$recommtr.attr("id", data[1][j].rcmntNo);
							
							$recommtr.append($reusertd);
							$recommtr.append($recommConttd);
							$recommtr.append($recommdatetd);
							
							
							
							//$commTable.append($recommtr);
							$reCommTable.append($recommtr);
							$retd.append($reCommTable);
							$retr.append($retd);
							
						}

					}
					$commTable.append($commtr);
					$commTable.append($retr);
				}
			}else{
				var $commtr = $("<tr>");
				var $commtd = $("<td style='text-align:center; padding:20px 0'>").html("아직 댓글이 없어요 &nbsp; :<");
				
				$commtr.append($commtd);
				$commTable.append($commtr);
				
				
			}
		},
		error : function(request, status, errorData){
			alert("error code: " + request.status + "\n"
                      +"message: " + request.responseText
                      +"error: " + errorData);
		}
	});
}

// 코멘트 수정 버튼 생성
$(document).on("click", ".comm .commModify", function(){
	var commCont = $(this).parent().text().replace("수정", "").replace("답글", "");
			
	var cmntBtn = $("<span class='cmntBtn'>").text("댓글 수정");
	
	var $insertTdArea = $("<textarea class='insertarea'>").css({"width": "100%", "height" : "50px", "resize" : "none"}).text(commCont);
	
	
	var $thistr = $(this).closest("tr");

	$thistr.children("td").eq(1).html($insertTdArea).append(cmntBtn);
});

// 코멘트 수정
$(document).on("click", ".comm .cmntBtn", function(){
	var commCont = $(this).prev(".insertarea").val();

	var cmntNo = $(this).closest("tr").attr("id");
	
	$.ajax({
		url : "commModify.do",
		data: { "postType" : postType, "postNo" : postNo, "commCont" : commCont, "cmntNo" : cmntNo },
		success : function(data){
			commView();
		},
		error : function(request, status, errorData){
			alert("error code: " + request.status + "\n"
                      +"message: " + request.responseText
                      +"error: " + errorData);
		}
	});
});


// 리코멘트 답글 버튼 생성
$(document).on("click", ".comm .reCommt", function(){
	var $recommArea = $("<textarea class='recommArea'>").css({"width": "90%", "height" : "50px", "resize" : "none"});
	var $recommtr = $("<tr class='recommtr'>");
	var $recommtd = $("<td colspan='2'>").css("text-align", "center");

	var $recmntBtn = $("<span class='recmntBtn'>").text("답글 달기");
	var $trcmnttd = $("<td>").css("vertical-align", "middle");
	
	var $thistr = $(this).closest("tr");
	
	
	$recommtd.append($recommArea);
	$trcmnttd.append($recmntBtn);
	$recommtr.append($recommtd);
	$recommtr.append($trcmnttd);
	$thistr.after($recommtr);
	
});

// 리코멘트 인서트
$(document).on("click", ".recommtr .recmntBtn", function(){
	var recommCont = $(this).parent("td").prev("td").children(".recommArea").val();
	var cmntNo = $(this).closest(".recommtr").prev(".comm").attr("id");
	
	$.ajax({
		url : "recommentInsert.do",
		data: { "postType" : postType, "postNo" : postNo, "recommCont" : recommCont, "cmntNo" : cmntNo },
		success : function(data){
			if(data == "success"){
				commView();
			}
		},
		error : function(request, status, errorData){
			alert("error code: " + request.status + "\n"
                      +"message: " + request.responseText
                      +"error: " + errorData);
		}
	});
});

// 리코멘트 수정 버튼 생성
$(document).on("click", ".reComm .recommModify", function(){
	var recommCont = $(this).parent().text().replace("수정", "");
	var recmntBtn = $("<span class='recmntBtn'>").text("답글 수정");
	
	var $reinsertTdArea = $("<textarea class='reinsertarea'>").css({"width": "100%", "height" : "50px", "resize" : "none"}).text(recommCont);
	

	var $thistr = $(this).closest("tr");

	$thistr.children("td").eq(1).html($reinsertTdArea).append(recmntBtn);
});

// 리코멘트 수정
$(document).on("click", ".reComm .recmntBtn", function(){
	var recommCont = $(this).prev(".reinsertarea").val();

	var recmntNo = $(this).closest("tr").attr("id");
	
	var cmntNo = $(this).closest("tr").parents("tr").prev().attr("id");

	console.log(recmntNo);
	console.log(cmntNo);
	
	
	$.ajax({
		url : "recommModify.do",
		data: { "postType" : postType, "postNo" : postNo, "recommCont" : recommCont, "cmntNo" : cmntNo, "recmntNo" : recmntNo},
		success : function(data){
			commView();
		},
		error : function(request, status, errorData){
			alert("error code: " + request.status + "\n"
                      +"message: " + request.responseText
                      +"error: " + errorData);
		}
	});
});



	$(".btns .delete").on("click", function(){
		var result = confirm("정말 삭제하시겠습니까?\n확인을 누르시면 글이 삭제됩니다.");
		if(result){
			<c:url var="reviewDelete" value="reviewDelete.do">
				<c:param name="postNo" value="${board.postNo }"/>
			</c:url>
			location.href="${reviewDelete }";
		    alert("삭제되었습니다.");
		}else{
		    
		}
	});

	userId = "${loginUser.id}";
	postNo = ${board.postNo };
	like = "${liked.likeYn }";
	vote = "${voted.postYn }";
	likeCount = ${mapList.likeTotal};
	voteCount = ${mapList.voteTotal};
	
	postType = ${board.postType };

	$(document).on("ready", function(){

		var $lspan = $("<span>");
		var $vspan = $("<span>");
		var $spanCl = $("<span class='count'>")
		var $spanCv = $("<span class='count'>")
		
		if(like == 'Y'){
			$lspan.append("<i class='xi-heart'>");
		}else if(like == 'N' || like == "") {
			$lspan.append("<i class='xi-heart-o'>");
		}
		$spanCl.text(" " + likeCount);
		$lspan.append($spanCl);
		$(".likes").html($lspan);
		

		if(vote == 'Y'){
			$vspan.append("<i class='xi-star'>");
		}else if(vote == 'N' || vote == "") {
			$vspan.append("<i class='xi-star-o'>");
		}
		$spanCv.text(" " + voteCount);
		$vspan.append($spanCv);
		$(".voting").html($vspan);
		
		
		
		
	});
	
	$(".likes").on("click", function(){
		$.ajax({
			url : "likeUp.do",
			dataType : "json",
			data : { "userId" : userId, "postType" : postType, "postNo" : postNo},
			success : function(data){
				var msg = data.msg;
				console.log(msg);
				if(msg == 'error'){
					alert("로그인 후 이용해주세요!");
     	        	location.href="${contextPath}/login.do";
				}else if(msg == 'success'){

					var userLiked = data.userLiked;
					var lc = data.lc;
					
					if(userLiked == 'Y'){
						$(".likes").find("i").attr("class", "xi-heart");
					}else if(userLiked == 'N') {
						$(".likes").find("i").attr("class", "xi-heart-o");
					}
					$(".likes").find(".count").text(" " + lc);
				}
			},
			error : function(request, status, errorData){
				alert("error code: " + request.status + "\n"
                          +"message: " + request.responseText
                          +"error: " + errorData);
			}
			
		});
	});
	

	$(".voting").on("click", function(){
		$.ajax({
			url : "voteUp.do",
			dataType : "json",
			data : { "userId" : userId, "postType" : postType, "postNo" : postNo},
			success : function(data){
				var msg = data.msg;
				console.log(msg);
				if(msg == 'error'){
					alert("로그인 후 이용해주세요!");
     	        	location.href="${contextPath}/login.do";
				}else if(msg == 'success'){
					//
					var userVoted = data.userVoted;
					var vc = data.vc;
					
					if(userVoted == 'Y'){
						$(".voting").find("i").attr("class", "xi-star");
					}else if(userVoted == 'N') {
						$(".voting").find("i").attr("class", "xi-star-o");
					}
					$(".voting").find(".count").text(" " + vc);
				}
			},
			error : function(request, status, errorData){
				alert("error code: " + request.status + "\n"
                          +"message: " + request.responseText
                          +"error: " + errorData);
			}
			
		});
	});

    mapContainer = document.getElementById('map'), // 지도를 표시할 div  
    mapOption = { 
        center: new kakao.maps.LatLng(37.497978, 127.027524), // 지도의 중심좌표
        level: 7 // 지도의 확대 레벨
    };

    map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
    bounds = new kakao.maps.LatLngBounds();  
	
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
			var tcode = "${tv.tCode}";
			
			var night = "${tv.night}";
          		
        // 배열 추가 설정
			var str = {title: tvDataTit, latlng: new kakao.maps.LatLng(YP, XP), tcode : tcode};
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

		colors = ['#bc2626', '#9726bc', '#5726bc', '#263ebc', '#267ebc', '#26bcac', '#3bbc26'];

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
					   bounds.extend(posex[i][k].latlng);
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

	function setBounds() {
	    // LatLngBounds 객체에 추가된 좌표들을 기준으로 지도의 범위를 재설정합니다
	    // 이때 지도의 중심좌표와 레벨이 변경될 수 있습니다
	    map.setBounds(bounds);
	}
</script>
            
<jsp:include page="../common/footer.jsp" />
</body>
</html>
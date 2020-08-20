<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


</head>
<style>
body {font-family: "Lato", sans-serif;}
#h{right: 250px;}
#friendsbody{width: 850px;margin: 0 auto;}
#inp{padding: 10px;padding-left: 110px; padding-right: 100px;}
tr td input{border-radius: 5px;height: 30px;width: 280px;}
#sye{border-radius: 5px;height: 30px; width: 280px;}
#checkAll{zoom: 2.0;}
div select{height: 30px;border-radius: 5px;width: 80px;float: left;margin-left: 3px ;}
#h2{margin-left: 20px;text-align: center;}
#h3{float: left;margin-left: 20px;}
#hh5{float:right;margin-bottom: 0;color: lightgray;}
#agr{margin-left: 20px;}
.text{float: right;}
.container {width: 100%;height: 140px;overflow: auto;border: 1px solid black;border-radius: 10px;}
.container::-webkit-scrollbar {width: 10px;}
.container::-webkit-scrollbar-thumb {background-color: #2f3542;border-radius: 10px;background-clip: padding-box;border: 2px solid transparent}
.container::-webkit-scrollbar-track {background-color: grey;border-radius: 10px;box-shadow: inset 0px 0px 5px white;}
input::-webkit-input-placeholder { color: lightgray; }
input[type=radio] {width:              150px;height:             20px;}
#sye{border-radius: 5px;height: 30px;width: 280px;}
@media screen and (max-height: 450px) {.sidenav {padding-top: 15px;}.sidenav a {font-size: 18px;}}
#friendsbody{  width: 850px;  margin: 0 auto;    }
#firendsIdSearch{
	margin:20px auto;
	text-align:center;
}

#friendsbodyInfo {
width:100%;
}

#search {
	width:540px;
}

#friendsbodyInfo tr {
	line-height:2.6;
	border-bottom:1px solid #ddd;
}
#friendsbodyInfo td { 
 }

input[type=text]{
height: 36px;
 width: 200px;
}

#memberinfo{
width : 100%;
height : 150px;
text-align: center;
}
#memberinfo h1{
margin : 10px;
}
#memberinfo h2{
margin : 10px  10px 20px 10px;
}

#menubutton{
width: 50px;
height:50px;
font-size : 14px;
text-align:center;
margin:0;
padding: 0;
line-height:50px;
border:0;
background:#bd9dec;
border:1px solid #bd9dec;
position: absolute;
top:-50px;
left: 0;
color:#fff;
}

#mySidenav{
font-size :xx-large;
width: 200px;
height:435px;
position: fixed;
bottom : 0px;
right: 75px;
color :black;
border: 1px solid #ddd;
transition : .2s ease-in;
}

#mySidenav.on {
bottom:-435px;
}

p{
text-align: center;
}

.menuSide { background:#fff; }

.menuSide p a:before,
.menuSide  p a:after {
  content: '';
  border-bottom: solid 1px black;
  position: absolute;
  width: 0;
}


.menuSide p a { position:relative; }

.menuSide p a:before { left: 0; bottom:-4px; }
.menuSide p a:after { right: 0; bottom:-4px; }

.menuSide  p a:hover:before,
.menuSide  p a:hover:after {
  width: 50%;
}
.menuSide  p a:before, .menuSide p a:after {
  -webkit-transition: all 0.2s ease;
          transition: all 0.2s ease;
}


#friendstable{
                margin: 10px;
                padding:0;
                width: 800px;
                border-top: 1px solid #444444;
                border-collapse: collapse;
            }</style>

<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="https://unpkg.com/hangul-js" type="text/javascript"></script>
<body>
<jsp:include page="../common/header.jsp" />

<div id="memberinfo">

<h1><span style="color: orange;"> ${loginUser.name }</span>님 어서오세요<br></h1>
<h2>친구 : <span style="color: orange;"> ${fCount}</span>명<br>
글 수 <span style="color: orange;"> ${pCount} </span>개<br>
공유 글 수 <span style="color: orange;"> ${sCount} </span>개 </h2>
<h1 style="text-align: center; font-style : oblique;">FRIENDS</h1>
<hr>
</div>

   <br><br><br>
  
  
   <div id="mySidenav">
   <button id="menubutton"><i class="xi-angle-down"></i></button>
	   <div class="menuSide">
		   	<p>
		   		<a href="memberplanList.do">내 가 쓴 글</a>
		   	</p>
		</div>
	   <div class="menuSide"><p> <a href="mypageSharedme.do">내게 공유된 글</a></p></div>
	    <div class="menuSide"><p><a href="memberChange.do">내 정보 수정</a></p></div>
	    <div class="menuSide"><p><a href="friends.do">친구정보</a></p></div>
	    <div class="menuSide"><p><a href="friendsadd.do">친구추가</a></p></div>
	    <div class="menuSide"><p><a href="accfriends.do">친구수락(<span style="color: red;">${ accCount}</span>)</a></p></div>
	    <div class="menuSide"><p><a href="mypageDelete.do">회원탈퇴</a></p></div>
	<c:if test="${sessionScope.loginUser.id ne 'master'}">
	    <div class="menuSide"><p><a href="planList.do">플랜</a></p></div>
	    <div class="menuSide"><p><a href="reviewListView.do">리뷰</a></p></div>
   </c:if>
	<c:if test="${sessionScope.loginUser.id eq 'master'}">
	    <div class="menuSide"><p><a href="adminMember.do">회원관리</a></p></div>
	    <div class="menuSide"><p><a href="adminPostmanager.do">회원 글 관리</a></p></div>
   </c:if>
    </div>
<div id="friendsbody">
	<form method="post" action="friends.do">
		<div id="firendsIdSearch">
		<label for="search"> 아이디로검색 :</label> 
		<input align="center" type="text" id="search" name="noticeSearch"  placeholder="아이디를 입력해주세요">
		<input type="submit" id="searchBtn" class="colorBtn btn" value="SEARCH">
		</div>
			<div id="friendsbodyInfo">
				<table align="center" width="800" border="1" cellspacing="0" 
			         style="claer:right;" id="friendstable">
			      <tr bgcolor="#bd9dec">
			         <th>이름</th>
			         <th>닉네임</th>
			         <th>성별</th>
			         <th>ID</th>
			         <th>최근접속일</th>
			         <th>삭제여부</th>
			      </tr>
			      <c:if test="${empty friends }">
			            <tr>
			            <td style="text-align : center;" colspan="6">리스트가없습니다</td>
			            </tr>
			            </c:if>
			      <c:forEach var="n" items="${friends }">
			       
			         <tr>
			            <td align="center">${n.name }</td>
			            <td align="center">${n.nickname }</td>
			            <td align="center">${n.gender }</td>
			            <td align="center">${n.id }</td>
			            <td align="center">${n.time }</td>
			            <td>
					            <c:url value="refusefriends.do" var="url">
								<c:param name="deleteid" value="${n.id }" />
								</c:url>
					            <a href="${url}">삭제하기</a>
					            </td>
			        </tr>   
			      </c:forEach>
			   </table>
		   </div>
	  </form>
		   
  </div> 
   <div id="paging" align="center" width="600" border="1">
   <!-- [이전] -->
			<c:if test="${pi.currentPage eq 1 }">
				[이전]&nbsp;
			</c:if>
			
			<c:if test="${pi.currentPage gt 1 }">
				<c:url var="blistBack" value="friends.do">
					<c:param name="page" value="${pi.currentPage -1 }"/>
					<c:param name="search" value="${search}"/>
				</c:url>
				<a href="${blistBack }">[이전]</a>
			</c:if>
			<!-- [번호들] -->
			<c:forEach var="p" begin="${pi.startPage }" end="${pi.endPage }">
				<c:if test="${p eq pi.currentPage }">
					<font color="red" size="4"><b>[${p }]</b></font>
				</c:if>
				
				<c:if test="${p ne pi.currentPage }">
					<c:url var="blistCheck" value="friends.do">
						<c:param name="page" value="${p }"/>
						<c:param name="search" value="${search}"/>
					</c:url>
					<a href="${blistCheck }">${p }</a>
				</c:if>
			</c:forEach>
			
			<!-- [다음] -->
			<c:if test="${pi.currentPage eq pi.maxPage }">
				&nbsp;[다음]
			</c:if>
			
			<c:if test="${pi.currentPage lt pi.maxPage }">
				<c:url var="blistEnd" value="friends.do">
					<c:param name="search" value="${search}"/>
					<c:param name="page" value="${pi.currentPage + 1 }"/>
				</c:url>
				<a href="${blistEnd }">[다음]</a>
			</c:if>
   			<script>
   			var cnt =parsetInt(60);
   			function counter_init(){
   				tid = setInterval("counter_run()",1000);
   			}
   			
   			function counter_run(){
   				cnt--;
   				if(cnt < 0 ){
   					clearInterval(tid);
   					self.location = "logout.do";
   				}
   			}
   			</script>
   
   <script>
	$(function() { 

		//화면 다 뜨면 시작
		//DB쿼리 조작 없이 초성 검색을 하기 위해서는 우선 DB에 있는 항목들을 다 가지고 와야한다.
		//즉 너무 많은 수가 있으면 클라이언트 측이 느려질 수 있다는 점.
		//하지만 DB쿼리를 조작해서 서버에서 초성검색을 하는 방식에 비해 서버에는 무리가 없다.
		// ajax로 미리 검색어 목록을 다 가지고 온다.
		$.ajax({
			type : 'get',
			url : "friendshansolyy.do",
			dataType : "json",
			//request.term = $("#autocomplete").val()
			//data: {"param":"param"},
			success : function(data) {
				let source = $.map(data, function(item) { //json[i] 번째 에 있는게 item 임.
					chosung = "";
					Hangul.d(item, true).forEach(function(strItem, index) {
						if(strItem[0] != " "){	//띄어 쓰기가 아니면
							chosung += strItem[0];//초성 추가
						}
					});
					return {
						label : chosung + "|" +item, //실제 검색어랑 비교 대상 ㄱㅊㅂㅇㅂ|김치 볶음밥 이 저장된다.
						value : item, //김치 볶음밥
						chosung : chosung	//ㄱㅊㅂㅇㅂ
					}
				});
				
				
				$("#search").autocomplete({
					source : source,	// source 는 자동 완성 대상
					select : function(event, ui) {	//아이템 선택시
						console.log(ui.item.label + " 선택 완료");	
						
					},
					focus : function(event, ui) {	//포커스 가면
						return false;//한글 에러 잡기용도로 사용됨
					}
				}).autocomplete( "instance" )._renderItem = function( ul, item ) {	
				//.autocomplete( "instance" )._renderItem 설절 부분이 핵심
			      return $( "<li>" )	//기본 tag가 li로 되어 있음 
			        .append( "<div>" + item.value + "</div>" )	//여기에다가 원하는 모양의 HTML을 만들면 UI가 원하는 모양으로 변함.
			        .appendTo( ul );	//웹 상으로 보이는 건 정상적인 "김치 볶음밥" 인데 내부에서는 ㄱㅊㅂㅇㅂ,김치 볶음밥 에서 검색을 함.
			    };
			}
		});

	});
	
	
	
</script>
   

</div>

   
   <script>
$(document).ready(function(){
/*     $("#menubutton").click(function(){
        $("#mySidenav").slideToggle();
    }); */
    
    $("#menubutton").on("click", function(){
    	$mySidenav = $("#mySidenav").attr("class");
    	console.log($mySidenav);
    	if($mySidenav == "on"){
    		$("#mySidenav").removeClass("on");
    		$(this).find("i").attr("class", "xi-angle-down");
    	}else {
    		$("#mySidenav").addClass("on");
    		$(this).find("i").attr("class", "xi-angle-up");
    	}
    	
    });
    
    
});
</script>

   <jsp:include page="../common/footer.jsp" />
 
</body>
</html>
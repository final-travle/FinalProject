<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<link href="https://fonts.googleapis.com/css2?family=Black+And+White+Picture&family=Poor+Story&display=swap" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css2?family=Gamja+Flower&display=swap" rel="stylesheet">
<style>
     h1{
		font-family: 'Poor Story', cursive;
      }
      p{
      	font-family: 'Gamja Flower', cursive;
      }
/* 기초 CSS 디자인 */
* {
  box-sizing:border-box;
}
body {
  margin:0;
}

/* 본문 디자인 */
.wrap {
  display:block;
  position:fixed;
  top:0;
  bottom:0;
  left:0;
  right:0;
  text-align:center;
  background:#f0f0f0;
  background: -webkit-linear-gradient(45deg, hsl(48, 95%, 66%) 0%, transparent 70%), -webkit-linear-gradient(135deg, hsl(325, 97%, 73%) 10%, transparent 80%), -webkit-linear-gradient(225deg, hsl(72, 100%, 68%) 10%, transparent 80%), -webkit-linear-gradient(315deg, hsl(165, 97%, 69%) 50%, transparent 100%); 
  background: -ms-linear-gradient(45deg, hsl(48, 95%, 66%) 0%, transparent 70%), -ms-linear-gradient(135deg, hsl(325, 97%, 73%) 10%, transparent 80%), -ms-linear-gradient(225deg, hsl(72, 100%, 68%) 10%, transparent 80%), -ms-linear-gradient(315deg, hsl(165, 97%, 69%) 50%, transparent 100%); 
  background: linear-gradient(45deg, hsl(48, 95%, 66%) 0%, transparent 70%), linear-gradient(135deg, hsl(325, 97%, 73%) 10%, transparent 80%), linear-gradient(225deg, hsl(72, 100%, 68%) 10%, transparent 80%), linear-gradient(315deg, hsl(165, 97%, 69%) 50%, transparent 100%);
}


/* 모달 윈도우 디자인 */
.friend_modal {
  position:fixed;
  display:block;
  width:100%;
  height:100%;
  top:190px;
  left:75px;
  background:#FFFFFF;
  border:1px solid #386980;
  border-left:0px;
  border-top:0px;
  overflow-y:scroll;
  /* 아래 부분은 애니메이션 효과를 위한 부분 */
  visibility: collapse;
  opacity: 0.8;
  filter: alpha(opacity=60);
  -webkit-transition: all .0s ease;
  transition: all .0s ease;
  -webkit-transform: scale(0, 0);
  -ms-transform: scale(0, 0);
  transform: scale(0, 0);
}

/* 모달 윈도우가 팝업되는 코어 소스 */
input#modal1[type=checkbox]:checked ~ .friend_modal {
  visibility: visible;
  -webkit-transform: scale(1, 1);
  -ms-transform: scale(1, 1);
  transform: scale(1, 1);
}

.chatroom_modal {
  position:fixed;
  display:block;
  width:100%;
  height:100%;
  top:150px;
  left:75px;
  background:#FFFFFF;
  border:1px solid #386980;
  border-left:0px;
  border-top:0px;
  overflow-y:scroll;
  word-break:break-all;
  /* 아래 부분은 애니메이션 효과를 위한 부분 */
  visibility: collapse;
  opacity: 0.8;
  filter: alpha(opacity=60);
  -webkit-transition: all .0s ease;
  transition: all .0s ease;
  -webkit-transform: scale(0, 0);
  -ms-transform: scale(0, 0);
  transform: scale(0, 0);
}

/* 모달 윈도우가 팝업되는 코어 소스 */
input#modal2[type=checkbox]:checked ~ .chatroom_modal {
  visibility: visible;
  -webkit-transform: scale(1, 1);
  -ms-transform: scale(1, 1);
  transform: scale(1, 1);
}

.openchatroom_modal {
  position:fixed;
  display:block;
  width:100%;
  height:100%;
  top:150px;
  left:75px;
  background:#FFFFFF;
  border:1px solid #386980;
  border-left:0px;
  border-top:0px;
  overflow-y:scroll;
  word-break:break-all;
  /* 아래 부분은 애니메이션 효과를 위한 부분 */
  visibility: collapse;
  opacity: 0.8;
  filter: alpha(opacity=60);
  -webkit-transition: all .0s ease;
  transition: all .0s ease;
  -webkit-transform: scale(0, 0);
  -ms-transform: scale(0, 0);
  transform: scale(0, 0);
}

/* 모달 윈도우가 팝업되는 코어 소스 */
input#modal3[type=checkbox]:checked ~ .openchatroom_modal {
  visibility: visible;
  -webkit-transform: scale(1, 1);
  -ms-transform: scale(1, 1);
  transform: scale(1, 1);
}

#friendSearch{
	margin-top:-30px;
	margin-left:10px;
	width:80%;
	background-color:#F2F2F2;
	border-top-left-radius: 10px;
	border-top-right-radius: 10px;
	border-bottom-right-radius: 10px;
	border-bottom-left-radius: 10px;
	height:28px;
	border: 1px solid #BDBDBD;
}
#chatroomSearch{
	margin-top:-30px;
	margin-left:10px;
	width:80%;
	background-color:#F2F2F2;
	border-top-left-radius: 10px;
	border-top-right-radius: 10px;
	border-bottom-right-radius: 10px;
	border-bottom-left-radius: 10px;
	height:28px;
	border: 1px solid #BDBDBD;
}

.menu_modal {
  position:fixed;
  display:block;
  width:75px;
  height:100%;
  top:0px;
  left:0px;
  background:#E6E6E6;
  border:1px solid #386980;
  border-right:0px;
  overflow:hidden;
  /* 아래 부분은 애니메이션 효과를 위한 부분 */
  visibility: collapse;
  opacity: 0.9;
  filter: alpha(opacity=60);
  -webkit-transition: all .2s ease;
  transition: all .2s ease;
  -webkit-transform: scale(0, 0);
  -ms-transform: scale(0, 0);
  transform: scale(0, 0);
}

/* 모달 윈도우가 팝업되는 코어 소스 */
input#chatmenumodal[type=checkbox]:checked ~ .menu_modal {
  visibility: visible;
  -webkit-transform: scale(1, 1);
  -ms-transform: scale(1, 1);
  transform: scale(1, 1);
}

.friendmodalheader {
  position:fixed;
  display:block;
  width:100%;
  height:190px;
  top:0px;
  left:75px;
  background:#FFFFFF;
  border:1px solid #386980;
  border-left:0px;
  border-bottom:1px solid #BDBDBD;
  overflow-y:scroll;
  /* 아래 부분은 애니메이션 효과를 위한 부분 */
  visibility: collapse;
  opacity: 0.8;
  filter: alpha(opacity=60);
  -webkit-transition: all .0s ease;
  transition: all .0s ease;
  -webkit-transform: scale(0, 0);
  -ms-transform: scale(0, 0);
  transform: scale(0, 0);
}

/* 모달 윈도우가 팝업되는 코어 소스 */
input#head_modal1[type=checkbox]:checked ~ .friendmodalheader {
  visibility: visible;
  -webkit-transform: scale(1, 1);
  -ms-transform: scale(1, 1);
  transform: scale(1, 1);
}

.chatmodalheader {
  position:fixed;
  display:block;
  width:100%;
  height:150px;
  top:0px;
  left:75px;
  background:#FFFFFF;
  border:1px solid #386980;
  border-left:0px;
  border-bottom:0px;
  overflow-y:scroll;
  /* 아래 부분은 애니메이션 효과를 위한 부분 */
  visibility: collapse;
  opacity: 0.8;
  filter: alpha(opacity=60);
  -webkit-transition: all .0s ease;
  transition: all .0s ease;
  -webkit-transform: scale(0, 0);
  -ms-transform: scale(0, 0);
  transform: scale(0, 0);
}

/* 모달 윈도우가 팝업되는 코어 소스 */
input#head_modal2[type=checkbox]:checked ~ .chatmodalheader {
  visibility: visible;
  -webkit-transform: scale(1, 1);
  -ms-transform: scale(1, 1);
  transform: scale(1, 1);
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<link rel="stylesheet" href="http://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
	<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
	<!-- <script src="lib/sockjs.min.js"></script> -->
	<script src="https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js"></script>
	<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
</head>
<body>
	<div class="wrap">
</div>
<input type="checkbox" id="chatmenumodal" checked>
<div class="menu_modal">
	<a href="#" title="친구" onclick="openFriendListModal();">
	<img src="${pageContext.request.contextPath}/resources/images/friendlist.png"  
	style="height:60px; width:60px; margin-left:5px; margin-top:70px;"></a>
	
	<a href="#" title="채팅" onclick="openChatroomListModal();">
	<img src="${pageContext.request.contextPath}/resources/images/chatroomlist.png"  
	style="height:40px; width:40px; margin-left:15px; margin-top:20px;"></a>
	
	<a href="#" title="오픈채팅" onclick="openOpenChatroomListModal();">
	<img src="${pageContext.request.contextPath}/resources/images/openchatroomlist.png"  
	style="height:60px; width:60px; margin-left:5px; margin-top:20px;"></a>
	
</div>

<input type="checkbox" id="head_modal1" checked>
<div class="friendmodalheader">
 		<h1 style="margin-top:30px; margin-left:10px;">친구</h1>
  	  <input type="text" id="friendSearch"  placeholder="친구 검색">
  	  <br>
  	  <div id="myprofile">
  	  <c:if test="${empty loginUser.profile }">
  	  <img src="${pageContext.request.contextPath}/resources/images/noprofile.png" 
  	  	style="width:50px;height:50px;border-radius:45%; margin-bottom:-10px;margin-top:10px;margin-left:13px;float:left;">
  	  </c:if>
  	  <c:if test="${!empty loginUser.profile }">
  	  	<img src="${pageContext.request.contextPath}/resources/profile/${loginUser.profile}" 
  	  	style="width:50px;height:50px;border-radius:45%; margin-bottom:-10px;margin-top:10px;margin-left:13px;float:left;">
  	  	</c:if>
  	  	<p style="font-size:20px;margin-left:15px;float:left">${loginUser.nickname}</p>
  	  </div>
 </div>
 
 <input type="checkbox" id="head_modal2">
 <div class="chatmodalheader">
 	<h1 style="margin-top:30px; margin-left:10px;">채팅</h1>
  	  <input type="text" id="chatroomSearch"  placeholder="채팅방 이름 검색">
  	  <br>
 </div>
 
 
 
 

<input type="checkbox" id="modal1" checked>
<div class="friend_modal">

	<table>
		
		<c:forEach var="friendList" items="${friendList }">
			<tr>
				<td align="center">
				<c:if test="${empty friendList.fprofile }">
				<img src="${pageContext.request.contextPath}/resources/images/noprofile.png" 
				style="width:50px;height:50px;border-radius:45%; margin-bottom:5px;margin-top:10px;margin-left:10px;">
				</c:if>
				<c:if test="${!empty friendList.fprofile }">
				<img src="${pageContext.request.contextPath}/resources/profile/${friendList.fprofile}" 
				style="width:50px;height:50px;border-radius:45%; margin-bottom:5px;margin-top:10px;margin-left:10px;">
				</c:if>
				</td>
				<td align="left"><p style="font-size:20px;margin-left:10px;">${friendList.fnickname}</p></td>
			</tr>
			</c:forEach>
	</table>
	<br><br><br><br><br>
	<br><br><br><br>
</div>

<input type="checkbox" id="modal2">
<div class="chatroom_modal">
	채팅
	
	<br><br><br><br><br>
	<br><br><br><br>
</div>

<input type="checkbox" id="modal3">
<div class="openchatroom_modal">
	<div class="container">
	
		<table class="table table-striped table-bordered table-hover">
		
		<c:forEach var="chatroomList" items="${chatroomList }">
			<tr>
				<td align="left" style="width:500px;">
					<c:url var="chatroom" value="chatroomjoin.do">
						<c:param name="chatroomnumber" value="${chatroomList.chatroom_no}"/>
						<c:param name="chatroomname" value="${chatroomList.chatroomname }"/>
					</c:url>
				<p style="font-size:30px;margin-left:10px;">
				<a href="#" onclick="window.open('${chatroom}','openchatroom','top=100, left=300, width=400, height=500, status=no, menubar=no')" 
				style="color:black;text-decoration:none;" >${chatroomList.chatroomname} </a>
				</p>
				<p style="font-size:15px;margin-top:-30px;margin-right:60px;word-break:break-all;">
				<img src="${pageContext.request.contextPath}/resources/images/openchatroomdetail.png"
				style="width:25px;height:20px;margin-left:20px;">
				${chatroomList.chatroomdetail }</p>
				</td>
			</tr>
			</c:forEach>
	</table>
	<br><br><br><br><br>
	<br><br><br><br>
</div>
</div>

<script>
function openFriendListModal(){
	$("input:checkbox[id='modal1']").prop("checked", true);	
	$("#modal1").prop("checked", true);
	$("input:checkbox[id='head_modal1']").prop("checked", true);	
	$("#head_modal1").prop("checked", true);
	
	$("input:checkbox[id='modal2']").prop("checked", false);
	$("#modal2").prop("checked", false);
	$("input:checkbox[id='modal3']").prop("checked", false);
	$("#modal3").prop("checked", false);
	$("input:checkbox[id='head_modal2']").prop("checked", false);	
	$("#head_modal2").prop("checked", false);
}

function openChatroomListModal(){
	$("input:checkbox[id='modal2']").prop("checked", true);	
	$("#modal2").prop("checked", true);
	$("input:checkbox[id='head_modal2']").prop("checked", true);	
	$("#head_modal2").prop("checked", true);
	
	$("input:checkbox[id='modal1']").prop("checked", false);
	$("#modal1").prop("checked", false);
	$("input:checkbox[id='modal3']").prop("checked", false);
	$("#modal3").prop("checked", false);
	$("input:checkbox[id='head_modal1']").prop("checked", false);	
	$("#head_modal1").prop("checked", false);
}

function openOpenChatroomListModal(){
	$("input:checkbox[id='modal3']").prop("checked", true);	
	$("#modal3").prop("checked", true);
	$("input:checkbox[id='head_modal2']").prop("checked", true);	
	$("#head_modal2").prop("checked", true);
	
	$("input:checkbox[id='modal1']").prop("checked", false);
	$("#modal1").prop("checked", false);
	$("input:checkbox[id='modal2']").prop("checked", false);
	$("#modal2").prop("checked", false);
	$("input:checkbox[id='head_modal1']").prop("checked", false);	
	$("#head_modal1").prop("checked", false);
}

	/* function chatroomdetail(){
		window.open("chatroomjoin.do","openChatroom","top=100, left=300, width=400, height=500, status=no, menubar=no");
	} */
	
</script>

</body>
</html>







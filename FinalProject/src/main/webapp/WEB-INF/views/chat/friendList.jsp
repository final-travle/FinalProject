<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<link href="https://fonts.googleapis.com/css2?family=Black+And+White+Picture&family=Poor+Story&display=swap" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css2?family=Gamja+Flower&display=swap" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">
<style>
     h1{
		font-family: 'Poor Story', cursive;
      }
      h2{
      font-family: 'Poor Story', cursive;
      }
      p{
      	font-family: 'Gamja Flower', cursive;
      }
      p.a{
      	font-family: 'Jua', sans-serif;
      	letter-spacing :0.5px;
      }

* {
  box-sizing:border-box;
}
body {
  margin:0;
}


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

  visibility: collapse;
  opacity: 0.8;
  filter: alpha(opacity=60);
  -webkit-transition: all .0s ease;
  transition: all .0s ease;
  -webkit-transform: scale(0, 0);
  -ms-transform: scale(0, 0);
  transform: scale(0, 0);
}
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

  visibility: collapse;
  opacity: 0.8;
  filter: alpha(opacity=60);
  -webkit-transition: all .0s ease;
  transition: all .0s ease;
  -webkit-transform: scale(0, 0);
  -ms-transform: scale(0, 0);
  transform: scale(0, 0);
}
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

  visibility: collapse;
  opacity: 0.8;
  filter: alpha(opacity=60);
  -webkit-transition: all .0s ease;
  transition: all .0s ease;
  -webkit-transform: scale(0, 0);
  -ms-transform: scale(0, 0);
  transform: scale(0, 0);
}
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
  
  visibility: collapse;
  opacity: 0.9;
  filter: alpha(opacity=60);
  -webkit-transition: all .2s ease;
  transition: all .2s ease;
  -webkit-transform: scale(0, 0);
  -ms-transform: scale(0, 0);
  transform: scale(0, 0);
}
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
  
  visibility: collapse;
  opacity: 0.8;
  filter: alpha(opacity=60);
  -webkit-transition: all .0s ease;
  transition: all .0s ease;
  -webkit-transform: scale(0, 0);
  -ms-transform: scale(0, 0);
  transform: scale(0, 0);
}
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

  visibility: collapse;
  opacity: 0.8;
  filter: alpha(opacity=60);
  -webkit-transition: all .0s ease;
  transition: all .0s ease;
  -webkit-transform: scale(0, 0);
  -ms-transform: scale(0, 0);
  transform: scale(0, 0);
}
input#head_modal2[type=checkbox]:checked ~ .chatmodalheader {
  visibility: visible;
  -webkit-transform: scale(1, 1);
  -ms-transform: scale(1, 1);
  transform: scale(1, 1);
}

.makeOpenchatForm_modal {
  position:absolute;
  display:block;
  z-index:91;
  width:350px;
  height:300px;
  top:25%;
  left:20%;
  background-image: url("${pageContext.request.contextPath}/resources/images/makechat_background.jpg");
  border:1px #BCA9F5;
  border-radius:10px;
  overflow:hidden;
  
  visibility: collapse;
  opacity: 1;
  filter: alpha(opacity=60);
  -webkit-transition: all .0s ease;
  transition: all .0s ease;
  -webkit-transform: scale(0, 0);
  -ms-transform: scale(0, 0);
  transform: scale(0, 0);
}
input#makeopenchat_modal[type=checkbox]:checked ~ .makeOpenchatForm_modal {
  visibility: visible;
  -webkit-transform: scale(1, 1);
  -ms-transform: scale(1, 1);
  transform: scale(1, 1);
}
.updateNickname {
  position:absolute;
  display:block;
  z-index:93;
  width:300px;
  height:120px;
  top:25%;
  left:20%;
  background-image: url("${pageContext.request.contextPath}/resources/images/makechat_background.jpg");
  border:1px #BCA9F5;
  border-radius:10px;
  overflow:hidden;

  visibility: collapse;
  opacity: 1;
  filter: alpha(opacity=60);
  -webkit-transition: all .0s ease;
  transition: all .0s ease;
  -webkit-transform: scale(0, 0);
  -ms-transform: scale(0, 0);
  transform: scale(0, 0);
}
input#updateNickname[type=checkbox]:checked ~ .updateNickname {
  visibility: visible;
  -webkit-transform: scale(1, 1);
  -ms-transform: scale(1, 1);
  transform: scale(1, 1);
}

.myprofile_detail_modal {
  position:absolute;
  display:block;
  z-index:92;
  width:320px;
  height:350px;
  top:20%;
  left:20%;
 /*  background-image: url("${pageContext.request.contextPath}/resources/images/makechat_background.jpg"); */
 background:white;
  border:4px solid black;
  border-radius:5%;
  overflow:hidden;

  visibility: collapse;
  opacity: 1;
  filter: alpha(opacity=60);
  -webkit-transition: all .0s ease;
  transition: all .0s ease;
  -webkit-transform: scale(0, 0);
  -ms-transform: scale(0, 0);
  transform: scale(0, 0);
}
input#myprofile_detail_modal[type=checkbox]:checked ~ .myprofile_detail_modal {
  visibility: visible;
  -webkit-transform: scale(1, 1);
  -ms-transform: scale(1, 1);
  transform: scale(1, 1);
}
.saveprofile_modal {
  position:absolute;
  display:block;
  z-index:93;
  width:80px;
  height:50px;
  top:67%;
  left:43%;
 /*  background-image: url("${pageContext.request.contextPath}/resources/images/makechat_background.jpg"); */
background-color:transparent;
 border:0px;
  overflow:hidden;

  visibility: collapse;
  opacity: 1;
  filter: alpha(opacity=60);
  -webkit-transition: all .0s ease;
  transition: all .0s ease;
  -webkit-transform: scale(0, 0);
  -ms-transform: scale(0, 0);
  transform: scale(0, 0);
}
input#saveprofile_modal[type=checkbox]:checked ~ .saveprofile_modal {
  visibility: visible;
  -webkit-transform: scale(1, 1);
  -ms-transform: scale(1, 1);
  transform: scale(1, 1);
}
#saveprofile_button{
	width:100%;
	height:100%;
	background-color:transparent;
	border:0px;
	outline:0px;
}

.friend_profile_detail {
  position:absolute;
  display:block;
  z-index:92;
  width:320px;
  height:350px;
  top:20%;
  left:20%;
 /*  background-image: url("${pageContext.request.contextPath}/resources/images/makechat_background.jpg"); */
 background:white;
  border:4px solid black;
  border-radius:5%;
  overflow:hidden;

  visibility: collapse;
  opacity: 1;
  filter: alpha(opacity=60);
  -webkit-transition: all .0s ease;
  transition: all .0s ease;
  -webkit-transform: scale(0, 0);
  -ms-transform: scale(0, 0);
  transform: scale(0, 0);
}
input#friend_profile_detail[type=checkbox]:checked ~ .friend_profile_detail {
  visibility: visible;
  -webkit-transform: scale(1, 1);
  -ms-transform: scale(1, 1);
  transform: scale(1, 1);
}

.friend_profile_detail2 {
  position:absolute;
  display:block;
  z-index:92;
  width:320px;
  height:350px;
  top:20%;
  left:20%;
 /*  background-image: url("${pageContext.request.contextPath}/resources/images/makechat_background.jpg"); */
 background:white;
  border:4px solid black;
  border-radius:5%;
  overflow:hidden;

  visibility: collapse;
  opacity: 1;
  filter: alpha(opacity=60);
  -webkit-transition: all .0s ease;
  transition: all .0s ease;
  -webkit-transform: scale(0, 0);
  -ms-transform: scale(0, 0);
  transform: scale(0, 0);
}
input#friend_profile_detail2[type=checkbox]:checked ~ .friend_profile_detail2 {
  visibility: visible;
  -webkit-transform: scale(1, 1);
  -ms-transform: scale(1, 1);
  transform: scale(1, 1);
}


#makeopenchat_modal{
	display:none;
}
input:focus {
		outline:none;
	}
textarea:focus{
	outline:none;
}

.submitImage{
	margin-left:-25px;
	margin-top:-50px;
	width:50px;
}
.submitText{
	text-align: center;
	position: absolute;
	top:90%;
	left:23%;
	transform: translate( -50%, -50% );
	line-height:0px;
}
.submitImage2{
	margin-top:-50px;
	margin-left:110px;
	width:50px;
}
.submitText2{
	text-align: center;
	position: absolute;
	top:90%;
	left:77%;
	transform: translate( -50%, -50% );
	line-height:0px;
}
.makeroomInput{
	border:2px dashed #BE81F7;
	border-radius:5px;
	background-color:transparent;
	margin-top:-50px;
	margin-left:20px;
	font-family: 'Nanum Gothic', sans-serif;
}
.makeroomInputArea{
	border:2px dashed #BE81F7;
	border-radius:5px;
	background-color:transparent;
	margin-left:20px;
	resize:none;
	font-family: 'Nanum Gothic', sans-serif;
}
.makeroomInputArea::-webkit-scrollbar {
		    width: 0px;
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
	
	<img src="${pageContext.request.contextPath}/resources/images/friendlist.png"  
	style="height:60px; width:60px; margin-left:5px; margin-top:70px;cursor:pointer;"
	onclick="openFriendListModal();" title="친구">
	
	
	<img src="${pageContext.request.contextPath}/resources/images/onetooneList.png"  
	style="height:50px; width:50px; margin-left:10px; margin-top:20px;cursor:pointer;"
	onclick="openChatroomListModal();" title="1대1채팅">
	
	
	<img src="${pageContext.request.contextPath}/resources/images/openchatroomlist.png"  
	style="height:60px; width:60px; margin-left:5px; margin-top:20px;cursor:pointer;"
	onclick="openOpenChatroomListModal();" title="오픈채팅">
	
	
</div>

<input type="checkbox" id="head_modal1" checked>
<div class="friendmodalheader">
 		<h1 style="margin-top:30px; margin-left:10px;">친구</h1>
  	  <input type="text" id="friendSearch"  placeholder="친구 검색">
  	  <br>
  	  <div id="myprofile">
  	  	<img src="${pageContext.request.contextPath}/resources/profile/${loginUser.profile}" onclick="myprofile_detail();" id="savedMyProfile"
  	  	style="width:50px;height:50px;border-radius:45%; margin-bottom:-10px;margin-top:10px;margin-left:13px;float:left;cursor:pointer;">
  	  	
  	  	<p style="font-size:20px;margin-left:15px;float:left">${loginUser.nickname}</p>
  	  	<img src="${pageContext.request.contextPath}/resources/images/updatenickname.png" onclick="updateNickname();"
  	  	style="width:30px;height:30px;float:left;margin-top:12px;margin-left:2px;cursor:pointer;">
  	  </div>
 </div>
 <input type="checkbox" id="updateNickname">
 <div class="updateNickname">
 	<p style="text-align:center;">변경할 닉네임</p>
 	<form action="updateNickname.do" name="updateNicknameForm" id="updateNicknameForm">
 		<input type="text" id="inputNickname" name="inputNickname" autocomplete="off" onkeyup="noSpaceForm(this);" onchange="noSpaceForm(this);">
 		<br>
 		<button type="button" onclick="close_updateNicknameForm();">취소</button>
 		<button type="button" onclick="submit_updateNicknameForm();">확인</button>
 	</form>
 </div>
 <script>
 	function noSpaceForm(obj){
 		if(obj.value == " "){
 			alert("첫 글자는 띄어쓰기 불가능합니다");
 			obj.focus();
 			obj.value = obj.value.replace(' ','');
 			return false;
 		}
 	}
 	function updateNickname(){
 		$("input:checkbox[id='updateNickname']").prop("checked", true);	
 		$("#updateNickname").prop("checked", true);
 	}
 	function close_updateNicknameForm(){
 		$("#inputNickname").val('');
 		
 		$("input:checkbox[id='updateNickname']").prop("checked", false);	
 		$("#updateNickname").prop("checked", false);
 	}
 	
 	
 	$(function (){
 		$("#inputNickname").keydown(function(key){
 			if(key.keyCode == 13){
 				var nickname = $("#inputNickname").val();
 				console.log("nickname1 = " + nickname);
 				if(nickname == ""){
 					alert("새로운 별명을 입력해주세요");
 					event.preventDefault();
 				}else{
 					updateNicknameForm.submit();
 				}
 			}
 		})
 	})
 	function submit_updateNicknameForm(){
 		if(nickname == ""){
				alert("새로운 별명을 입력해주세요");
			}else{
				updateNicknameForm.submit();
			}
 	}
 </script>
 
 <input type="checkbox" id="myprofile_detail_modal">
 <div class="myprofile_detail_modal">
 
  	  	<img src="${pageContext.request.contextPath}/resources/profile/${loginUser.profile}"  class="current_myProfile"
  	  	style="width:280px;height:280px;margin-left:17px;margin-top:10px;border-radius:5%;">
  	  	
  	  <img src="${pageContext.request.contextPath}/resources/images/closeprofilemodal.png" title="닫기"
  	  style="width:60px;height:50px;margin-left:36px;cursor:pointer;" onclick="close_myprofile_detail();">
  	  
  	  
  	  <label for="update_myprofile">
  	  <img src="${pageContext.request.contextPath}/resources/images/addprofile.png" title="프로필 등록"
	  	  style="width:75px;height:50px;margin-left:100px;cursor:pointer;">
	  </label>
  	  <form name="updateProfileForm" action ="updateprofile.do" method="post" enctype="multipart/form-data">
  	  	<input type="hidden" name="id" value="${loginUser.id }" id="id2">
  	  	<input type="hidden" name="profile" value="${loginUser.profile }">
	  	  <input id="update_myprofile" name="update_myprofile" type="file" style="display:none;" accept="image/*">
	  	  
  	  </form>
 </div>
 
 <input type="checkbox" id="saveprofile_modal">
 <div class="saveprofile_modal">
 	<button type="submit" onclick="updateprofile_submit();" id="saveprofile_button" style="cursor:pointer;"><h1>저장</h1></button>
 </div>
 

 <script>
 	function myprofile_detail(){
 		 var inputprofile = $("#update_myprofile").value;
 		 console.log(inputprofile);
 		$("input:checkbox[id='myprofile_detail_modal']").prop("checked", true);	
 		$("#myprofile_detail_modal").prop("checked", true);
 	}
 	function close_myprofile_detail(){
 		
 		$(".current_myProfile").attr("src","${pageContext.request.contextPath}/resources/profile/${loginUser.profile}");
 		
 		$("input:checkbox[id='myprofile_detail_modal']").prop("checked", false);	
 		$("#myprofile_detail_modal").prop("checked", false);
 	}
 </script>
 <script>
 function updateprofile_submit(){
	 updateProfileForm.submit();
	 $("input:checkbox[id='saveprofile_modal']").prop("checked", false);	
	$("#saveprofile_modal").prop("checked", false);
}
 </script>

 <script>
 function readURL(input){
	 if(input.files&&input.files[0]){
		 var reader = new FileReader();
		 reader.onload = function(e){
			 $(".current_myProfile").attr("src",e.target.result);
			 console.log(e.target.result);
		 }
		 
		 reader.readAsDataURL(input.files[0]);
	 }
 }
 $("#update_myprofile").change(function(){
	 readURL(this);
	 $("input:checkbox[id='saveprofile_modal']").prop("checked", true);	
		$("#saveprofile_modal").prop("checked", true);
 });
 </script>
 
 
 <input type="checkbox" id="head_modal2">
 <div class="chatmodalheader">
 <table style="width:100%">
 <tr>
 <td>
 	<h1 style="margin-top:30px; margin-left:10px;">채팅</h1>
 	</td>
 	<td>
 	
 	<img src="${pageContext.request.contextPath}/resources/images/addopenchatroom2.png"
 	style="width:55px;height:40px;float:right;margin-top:15px;margin-right:80px;cursor:pointer;"
 	onclick="makeOpenChatroom();" title="새로운 오픈채팅">
 	</td>
 	</tr>
 	</table>
  	  <input type="text" id="chatroomSearch"  placeholder="채팅방 이름 검색">
  	  <br>
 </div>
 
 <input type="checkbox" id="makeopenchat_modal">
 <div class="makeOpenchatForm_modal">
 	<h1 style="text-align:center;">오픈채팅방 생성</h1>
<form name="makeOpenChatroomForm" action="makeOpenChatroom.do" method="post">
	<table align="center">
		<tr>	
			<td><p class="a">방 이름</p></td>
			<td>
				<input type="text" class="makeroomInput" name="chatroomname" autocomplete=off>
			</td>
		</tr>
		<tr>
			<td><p class="a">방 소개</p></td>
			<td class="makechat_input">
			<textarea name="chatroomdetail" cols="20" rows="5" wrap="hard"  class="makeroomInputArea"></textarea>
			</td>
		</tr>
		<tr>
			<td onclick="closemodal();"><br><br><br>
			<div class="submitImage">
				<img src="${pageContext.request.contextPath}/resources/images/inputbox.png"
	 			style="width:100px;height:40px;cursor:pointer;" >
 			</div>
 			<div class="submitText"style="cursor:pointer">
				<p style="font-weight:800;font-size:23px;cursor:pointer;">취소</p>
			</div>
			</td>
			<td onclick="makeChatroomSubmit();" ><br><br><br>
			<div class="submitImage2">
				<img src="${pageContext.request.contextPath}/resources/images/inputbox.png"
	 			style="width:100px;height:40px;cursor:pointer;">
			</div>
			<div class="submitText2"style="cursor:pointer">
				<p style="font-weight:800;font-size:23px;">방생성</p>
			</div>
			</td>
		</tr>
	</table>
	<input type="hidden" class="makeroomInput" name="creater" value="${loginUser.id }" >
</form>
 </div>
 <script>
 	function closemodal(){
 		$("input:checkbox[id='makeopenchat_modal']").prop("checked", false);
 		$("#makeopenchat_modal").prop("checked", false);
 	}
 	
 	function makeChatroomSubmit(){
 		var makeOpenChatroomForm = document.makeOpenChatroomForm;
 		var chatroomname = makeOpenChatroomForm.chatroomname.value;
 		var chatroomdetail = makeOpenChatroomForm.chatroomdetail.value;
 		
 		if(!chatroomname || !chatroomdetail){
 			alert("방 정보를 모두 입력해 주세요");
 		}else{
 			makeOpenChatroomForm.submit();
 		}
 		
 	}
 </script>
 
 
 

<input type="checkbox" id="modal1" checked>
<div class="friend_modal">

	<table>
		
		<c:forEach var="friendList" items="${friendList }">
			<tr>
				<td align="center">
				<img src="${pageContext.request.contextPath}/resources/profile/${friendList.profile}" id="friend_profile"
				class="friend_profile"
				style="width:50px;height:50px;border-radius:45%; margin-bottom:5px;margin-top:10px;margin-left:10px;cursor:pointer">
				<input type="hidden" value="${friendList.id }" id="friendId" class="friendId">
				</td>
				<td align="left"><p style="font-size:20px;margin-left:10px;">${friendList.nickname}</p></td>
			</tr>
			</c:forEach>
	</table>
	<br><br><br><br><br>
	<br><br><br><br>
</div>
<script>
	 var friendId = "";

 		$(function(){
 			$(".friend_profile").click(function(){
 				var img = $(this).attr("src");
 				var friend_profile = img.substring(img.lastIndexOf("/")+1);
 				console.log("이미지 경로 : " + img);
 				console.log("이미지 이름 : " + friend_profile);
 				$(".friendsprofile_detail").attr("src",img);
 				
 				friendId = $(this).siblings(".friendId").val();
 				console.log("친구 아이디 = " + friendId);
 				
 				friend_profile_detail();
 			})
 		})
 	</script>
 	<script>
 		var friendId=""
 		
 		$(function(){
 			$(".chat_friend_profile_detail").click(function(){
 				var img = $(this).attr("src");
 				var friend_profile = img.substring(img.lastIndexOf("/")+1);
 				$(".friendsprofile_detail").attr("src",img);
 				
 				friend_profile_detail2();
 			})
 		})
 	</script>

<input type="checkbox" id="friend_profile_detail">
 <div class="friend_profile_detail"> 
 	
	<img class="friendsprofile_detail" src="" 
	style="width:280px;height:280px;margin-left:17px;margin-top:10px;border-radius:5%;">
 	
  	 <img src="${pageContext.request.contextPath}/resources/images/closeprofilemodal.png" title="닫기"
  	  style="width:60px;height:50px;margin-left:40px;cursor:pointer;" onclick="close_friend_profile_detail();">
  	  
  	  <img src="${pageContext.request.contextPath}/resources/images/makeOnetoOneChatroom.png" 
  	  style="width:60px;height:50px;margin-left:100px;cursor:pointer;" title="1대1채팅"
  	  onclick="insertOneToOneChatroom();">
  	  <script>
  	  	function insertOneToOneChatroom(){
  	  		console.log("fr_id = " + friendId);
  	  		
  	  		/* window.open("insertOneToOneChatroom.do?friendId="+friendId, "1대1채팅", "top=100, left=600, width=400, height=500, status=no, menubar=no"); */
  	  		
  	  		location.href="insertOneToOneChatroom.do?friendId="+friendId;
	  	  	$("input:checkbox[id='friend_profile_detail']").prop("checked", false);
	  		$("#friend_profile_detail").prop("checked", false);
  	  	}
  	  </script>
  	  
  	  
  	  <%-- <form action="insertOneToOneChatroom.do" name="insertOneToOneForm">
  	  		<input type="hidden" name="myId" value="${loginUser.id }">
  	  		<input type="hidden" name="friendId" value="">
  	  </form> --%>
 </div>
 
 <input type="checkbox" id="friend_profile_detail2">
 <div class="friend_profile_detail2"> 
 	
	<img class="friendsprofile_detail" src="" 
	style="width:280px;height:280px;margin-left:17px;margin-top:10px;border-radius:5%;">
	
	 <img src="${pageContext.request.contextPath}/resources/images/closeprofilemodal.png" title="닫기"
  	  style="width:60px;height:50px;margin-left:127px;cursor:pointer;" onclick="close_friend_profile_detail2();">
 </div>
 
 <script>
 	function friend_profile_detail(){
 		$("input:checkbox[id='friend_profile_detail']").prop("checked", true);	
 		$("#friend_profile_detail").prop("checked", true);
 	}
 	function close_friend_profile_detail(){
 		$("input:checkbox[id='friend_profile_detail']").prop("checked", false);	
 		$("#friend_profile_detail").prop("checked", false);
 	}
 	function friend_profile_detail2(){
 		$("input:checkbox[id='friend_profile_detail2']").prop("checked", true);	
 		$("#friend_profile_detail2").prop("checked", true);
 	}
 	function close_friend_profile_detail2(){
 		$("input:checkbox[id='friend_profile_detail2']").prop("checked", false);	
 		$("#friend_profile_detail2").prop("checked", false);
 	}
 	
 	$('#friend_profile').click(function(){
 	   $(this).attr
 	});
 </script>

<input type="checkbox" id="modal2">
<div class="chatroom_modal">
	<div class="container">
	
		<table class="table table-striped table-bordered table-hover">
		
		<c:forEach var="onetooneList" items="${onetooneList }">
			<tr>
				<td align="left" style="width:500px;">
				<div style="float:left;height:80px;">
					<img src="${pageContext.request.contextPath}/resources/profile/${onetooneList.profile}" 
  	  				style="margin-left:10px;width:50px;height:50px;border-radius:40%;cursor:pointer;"class="chat_friend_profile_detail">
  	  				
				</div>
				<div style="float:left;height:50px;width:280px;overflow:hidden;">
					<c:url var="chatroom" value="enterOneToOneChatroom.do">
						<c:param name="co_no" value="${onetooneList.co_no}" />
						<c:param name="friendId" value="${onetooneList.friendId }"/>
					</c:url>
					<p style="font-size:30px;margin-left:20px;margin-top:-6px;">
						<a href="${chatroom }" <%-- onclick="window.open('${chatroom}','openchatroom','top=100, left=300, width=400, height=500, status=no, menubar=no')" --%> 
						style="color:black;text-decoration:none;" class="enterOneToOneChatroom" >${onetooneList.nickname }
						</a>
					</p>
					<p style="margin-top:-30px;margin-left:20px;" id="Message_Content${onetooneList.co_no }">
						${onetooneList.message_cont }
					</p>
				</div>
				<div>
					<p id="ReadYNCount${onetooneList.co_no }">
						${onetooneList.count }
					</p>
				</div>
			
				</td>
			</tr>
			</c:forEach>
	</table>
	<br><br><br><br><br>
	<br><br><br><br>
</div>
</div>

<script>

	let sock2 = new SockJS("<c:url value='/echolist'/>");
	
	sock2.onmessage = onMessage;
	

	function onMessage(evt){
		var data = evt.data;
		var co_no = null;
		var message = null;
		var friendid = null;
		
		var myid = $("#id2").val();
		
		console.log("채팅리스트 데이터" + data)
		
		var strArray = data.split("|");
		
		for(var i = 0; i < strArray.length; i++){
			console.log("str[" + i + "]" + strArray[i]);
		}
		
		co_no = strArray[0];
		friendid = strArray[1];
		message = strArray[2];
		
		console.log("co_no = " + co_no);
		console.log("friendid = " + friendid);
		console.log("message = " + message);
		console.log("myid = " + myid);
		
		var ReadYNCount = $("#ReadYNCount"+co_no).val();
		console.log("count = " + ReadYNCount);
		
		if(myid != friendid){
			
		}
		
		
			$("#Message_Content"+co_no).text(message);
		
		
	}
</script>

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

function makeOpenChatroom(){
	$("#input:checkbox[id='makeopenchat_modal']").prop("checked", true);
	$("#makeopenchat_modal").prop("checked", true);
}

	
</script>

</body>
</html>







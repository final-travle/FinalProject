<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<link href="https://fonts.googleapis.com/css2?family=Black+And+White+Picture&family=Poor+Story&display=swap" rel="stylesheet">
<style>
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
		#mymsg {
			border-top-left-radius: 5px;
			border-top-right-radius: 5px;
			border-bottom-right-radius: 5px;
			border-bottom-left-radius: 5px;
			position: relative;
			background: #ffff00;
			border: 2px solid #ffff00;
		}
		#mymsg:after, #mymsg:before {
			left: 100%;
			top: 10px;
			border: solid transparent;
			content: " ";
			height: 0;
			width: 0;
			position: absolute;
			pointer-events: none;
		}
		
		#mymsg:after {
			border-color: rgba(255, 255, 0, 0);
			border-left-color: #ffff00;
			border-width: 5px;
			margin-top: -5px;
		}
		#mymsg:before {
			border-color: rgba(255, 255, 0, 0);
			border-left-color: #ffff00;
			border-width: 7px;
			margin-top: -7px;
		}
		.interval{
			margin-top:10px;
			margin-right:10px;
		}
		.intervalgreet{
			margin-top:10px;
			margin-bottom:10px;
		}
		
		
		#othermsg {
			border-top-left-radius: 5px;
			border-top-right-radius: 5px;
			border-bottom-right-radius: 5px;
			border-bottom-left-radius: 5px;
			position: relative;
			background: #ffffff;
			border: 2px solid #ffffff;
		}
		#othermsg:after, #othermsg:before {
			right: 100%;
			top: 10px;
			border: solid transparent;
			content: " ";
			height: 0;
			width: 0;
			position: absolute;
			pointer-events: none;
		}
		
		#othermsg:after {
			border-color: rgba(255, 255, 255, 0);
			border-right-color: #ffffff;
			border-width: 5px;
			margin-top: -5px;
		}
		#othermsg:before {
			border-color: rgba(255, 255, 255, 0);
			border-right-color: #ffffff;
			border-width: 8px;
			margin-top: -8px;
		}

	  p{
        font-family: 'Black And White Picture', sans-serif;
      }
      p.a{
      font-size: 30px;
      	font-weight:400;
      }
      strong{
		font-family: 'Poor Story', cursive;
      }
      strong.a{
      	font-size : 18px;
      }
      strong.b{
      	font-size : 28px;
      }


 		.chat {
		    overflow-y: scroll;
		    overflow-x:hidden;
		    word-break:break-all;
		    height: 90%;
		  }
		  .chat::-webkit-scrollbar {
		    width: 10px;
		  }
		  .chat::-webkit-scrollbar-thumb {
		    background-color: #2f3542;
		    border-radius: 10px;
		    background-clip: padding-box;
		    border: 2px solid transparent;
		  }
		  .chat::-webkit-scrollbar-track {
		    background-color: grey;
		    border-radius: 10px;
		    box-shadow: inset 0px 0px 5px white;
		  }
		   
   		/* #chatRoomUserList{
  			width: 150px;
            height:425px;
            border: 2px solid black;
            background: white;
  		} */
	    #container {
            width: 100%;
            height: 100%;
            border: 0px;
            background: ivory;
        }
        #chat {
            height: 80%;
            word-break:break-all;
            background-image: url("${pageContext.request.contextPath}/resources/chatroomBackground/b.jpg");
            background-size: cover;
            background-repeat: no-repeat;
        }
        #chatForm {
            height: 20%;
            border-top: 1px solid black;
            background-color:white;
            text-align: center;
        }
        #message {
            width: 80%;
            height: 60px;
            border:0px;
            font-size:15px;
            outline:none;
        }
        #sendBtn {
            width: 16%;
            height: 34px;
            background: #F4FA58;
            color: blcak;
            border-radius:5px;
            border:1px solid #E6E6E6;
        }
		
		
	 
		#enterdiv {
			margin-left:20px;
			border-top-left-radius: 20px;
			border-top-right-radius: 20px;
			border-bottom-right-radius: 20px;
			border-bottom-left-radius: 20px;
			position: relative;
			background: #caeaff;
			border: 5px solid #caeaff;
		}
		#enterdiv:after, #enterdiv:before {
			bottom: 100%;
			left: 50%;
			border: solid transparent;
			content: " ";
			height: 0;
			width: 0;
			position: absolute;
			pointer-events: none;
		}
		
		#enterdiv:after {
			border-color: rgba(202, 234, 255, 0);
			border-bottom-color: #caeaff;
			border-width: NaNpx;
			margin-left: -NaNpx;
		}
		#enterdiv:before {
			border-color: rgba(202, 234, 255, 0);
			border-bottom-color: #caeaff;
			border-width: NaNpx;
			margin-left: -NaNpx;
		}
		
		
.text {
	position:fixed;
  display:block;
  height:100%;
  width:100%;
}

.friend_modal {
  position:fixed;
  display:block;
  width:100%;
  height:100%;
  top:0px;
  left:0px;
  background:#FFFFFF;
  border:1px solid #386980;
  border-left:0px;
  border-top:0px;
  /* 아래 부분은 애니메이션 효과를 위한 부분 */
  visibility: collapse;
  opacity: 1;
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

.SendImage_modal {
   position:absolute;
  display:block;
  z-index:97;
  width:300px;
  top:5%;
  left:15%;
 /*  background-image: url("${pageContext.request.contextPath}/resources/images/makechat_background.jpg"); */
 background:white;
  border:4px solid black;
  border-radius:5%;
  overflow:hidden;
  /* 아래 부분은 애니메이션 효과를 위한 부분 */
  visibility: collapse;
  opacity: 1;
  filter: alpha(opacity=60);
  -webkit-transition: all .0s ease;
  transition: all .0s ease;
  -webkit-transform: scale(0, 0);
  -ms-transform: scale(0, 0);
  transform: scale(0, 0);
}

input#SendImage_modal[type=checkbox]:checked ~ .SendImage_modal {
  visibility: visible;
  -webkit-transform: scale(1, 1);
  -ms-transform: scale(1, 1);
  transform: scale(1, 1);
}

.sentImage_detail_modal {
   position:absolute;
  display:block;
  z-index:96;
  width:300px;
  top:7%;
  left:20%;
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

input#sentImage_detail_modal[type=checkbox]:checked ~ .sentImage_detail_modal {
  visibility: visible;
  -webkit-transform: scale(1, 1);
  -ms-transform: scale(1, 1);
  transform: scale(1, 1);
}

.updateNotice_modal {
   position:absolute;
  display:block;
  z-index:93;
  width:300px;
  height:200px;
  top:20%;
  left:20%;
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

input#updateNotice_modal[type=checkbox]:checked ~ .updateNotice_modal {
  visibility: visible;
  -webkit-transform: scale(1, 1);
  -ms-transform: scale(1, 1);
  transform: scale(1, 1);
}

.chatroomNotice_modal {
   position:absolute;
  display:block;
  z-index:94;
  width:60%;
  height:120px;
  top:0%;
  left:20%;
 background:white;
  border:1px solid gray;
  overflow:hidden;

  visibility: collapse;
  opacity: 0.8;
  filter: alpha(opacity=60);
  -webkit-transition: all .0s ease;
  transition: all .0s ease;
  -webkit-transform: scale(0, 0);
  -ms-transform: scale(0, 0);
  transform: scale(0, 0);
}

input#chatroomNotice_modal[type=checkbox]:checked ~ .chatroomNotice_modal {
  visibility: visible;
  -webkit-transform: scale(1, 1);
  -ms-transform: scale(1, 1);
  transform: scale(1, 1);
}

.smallNotice_modal {
   position:absolute;
  display:block;
  z-index:95;
  width:40px;
  height:40px;
  top:11px;
  left:65px;
 background:transparent;
  border:0px;
  overflow:hidden;

  visibility: collapse;
  opacity: 0.9;
  filter: alpha(opacity=60);
  -webkit-transition: all .0s ease;
  transition: all .0s ease;
  -webkit-transform: scale(0, 0);
  -ms-transform: scale(0, 0);
  transform: scale(0, 0);
}

input#smallNotice_modal[type=checkbox]:checked ~ .smallNotice_modal {
  visibility: visible;
  -webkit-transform: scale(1, 1);
  -ms-transform: scale(1, 1);
  transform: scale(1, 1);
}

.detail_chatroomNotice_modal {
   position:absolute;
  display:block;
  z-index:95;
  width:60%;
  height:400px;
  top:0%;
  left:20%;
 background:white;
  border:1px solid gray;
  overflow:hidden;

  visibility: collapse;
  opacity: 0.9;
  filter: alpha(opacity=60);
  -webkit-transition: all .0s ease;
  transition: all .0s ease;
  -webkit-transform: scale(0, 0);
  -ms-transform: scale(0, 0);
  transform: scale(0, 0);
}

input#detail_chatroomNotice_modal[type=checkbox]:checked ~ .detail_chatroomNotice_modal {
  visibility: visible;
  -webkit-transform: scale(1, 1);
  -ms-transform: scale(1, 1);
  transform: scale(1, 1);
}

.selectBackground_modal::-webkit-scrollbar {
		    width: 0px;
		  }
		  .selectBackground_modal::-webkit-scrollbar-thumb {
		    background-color: #2f3542;
		    border-radius: 10px;
		    background-clip: padding-box;
		    border: 2px solid transparent;
		  }
		  .selectBackground_modal::-webkit-scrollbar-track {
		    background-color: grey;
		    border-radius: 10px;
		    box-shadow: inset 0px 0px 5px white;
		  }
.selectBackground_modal{
   position:absolute;
  display:block;
  z-index:95;
  width:388px;
  height:300px;
  top:44%;
  left:0%;
 background:white;
  border:1px solid gray;
  border-radius:7px;
  overflow:hidden;
  overflow-y:auto;

  visibility: collapse;
  opacity: 1;
  filter: alpha(opacity=60);
  -webkit-transition: all .0s ease;
  transition: all .0s ease;
  -webkit-transform: scale(0, 0);
  -ms-transform: scale(0, 0);
  transform: scale(0, 0);
}

input#selectBackground_modal[type=checkbox]:checked ~ .selectBackground_modal {
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

<!-- <input type="checkbox" id="userlist_modal" class="hidden">
	<div class="box_modal2">
		<label for="userlist_modal" class="closer2"><strong><b>Ⅹ</b></strong></label>
	
		<div class="ulist">
			<div id="chatRoomUserList">
		
		</div> 
	</div>
</div> -->


<input type="checkbox" id="modal1" checked>
<div class="friend_modal">
	<div class="text">
	<div id="backArea" style="position:absolute;top:10px;left:10px;width:40px;height:40px;background:white;border-radius:50%;opacity:0.8;">
		<img src="${pageContext.request.contextPath}/resources/images/back.png" title="나가기"
						 style='width:40px;height:40px;cursor:pointer;' onclick="history.go(-1);">
	</div>
	<div id="container">
	<div id="chat" class="chat">
	<c:forEach var="otomsg" items="${otomsg }">
			<c:if test="${loginUser.id  eq otomsg.chatId }">
				<div>
					<div class='interval'>
						<img src="${pageContext.request.contextPath}/resources/profile/${otomsg.profile}"
						 style='float:right;width:40px;height:40px;border-radius:40%'>
						 <c:if test="${otomsg.send_image ne null}">
							<strong class='a' style='float:right;margin-right:10px;margin-top:7px;max-width:200px;' id='mymsg'>
							&nbsp;<img src="${pageContext.request.contextPath }/resources/ChatroomSendImage/${otomsg.send_image}" 
							class="sent_Image"
							style='width:150px;margin-top:10px;cursor:pointer;' onclick="sentImage_detail();">&nbsp;</strong>&nbsp;
						</c:if>
						<c:if test="${otomsg.send_image eq null}">
							<strong class='a' style='float:right;margin-right:10px;margin-top:7px;max-width:200px;' id='mymsg'>
							&nbsp;${otomsg.content }&nbsp;</strong>&nbsp;
						</c:if>
						<c:if test="${otomsg.read_yn eq 'N'}">
							<strong style="float:right;margin-right:10px;margin-top:20px;color:yellow;font-size:12px;" class='readyn'>1</strong>
						</c:if>
					</div>
				</div>
				<br clear='both'>
			</c:if>
			<c:if test="${loginUser.id  ne otomsg.chatId }">
				<div>
					<div class='interval'>
						<img src="${pageContext.request.contextPath}/resources/profile/${otomsg.profile}"
						style='width:40px;height:40px;border-radius:40%;float:left;'>
						<p style='margin-top:-5px;float:left;width:23px;overflow:visible;white-space:nowrap;'>&nbsp;&nbsp;${otomsg.nickname }</p>
						<c:if test="${otomsg.send_image ne null }">
							<strong class='a' style='margin-left:-10px;float:left;margin-top:15px;max-width:200px;' id='othermsg'>&nbsp;
							<img src="${pageContext.request.contextPath }/resources/ChatroomSendImage/${otomsg.send_image}" class="sent_Image"
							style="width:150px;margin-top:10px;cursor:pointer;" onclick="sentImage_detail();">&nbsp;</strong>&nbsp; 
						</c:if>
						<c:if test="${otomsg.send_image eq null }">
							<strong class='a' style='margin-left:-10px;float:left;margin-top:15px;max-width:200px;' id='othermsg'>&nbsp;
							${otomsg.content }&nbsp;</strong>&nbsp;
						</c:if>
						<c:if test="${otomsg.read_yn eq 'N'}">
							<strong style='float:left;margin-left:10px;margin-top:20px;color:yellow;font-size:12px;' class='readyn'id="readyn_id">1</strong>
						</c:if>
					</div>
				</div>
				<br clear='both'>
			</c:if>
	</c:forEach>
	<c:forEach  var="otoBackgroundInfo" items="${otoBackgroundInfo }">
		<input type="hidden" value="${otoBackgroundInfo.myId }" id="myid">
		<input type="hidden" value="${otoBackgroundInfo.oto_mybackground }" id="otoMyBackground">
		<input type="hidden" value="${otoBackgroundInfo.oto_frbackground }" id="otoFrBackground">
	</c:forEach>

		<div id="chatdata">
			<input type="hidden" value="${loginUser.id }" id="userid">
			<input type="hidden" value="${loginUser.nickname }" id="nickname">
			<input type="hidden" value="${oto.co_no }" id="chatroom_no">
			<input type="hidden" value="${oto.friendId}" id="friendid" >
			<input type="hidden" value="${loginUser.profile }" id="profile">
			<input type="hidden" value="${notice }" id="OnetoOneChatroomNotice">
			
		</div>
	</div>
	<div id="chatForm">
		<form id="sendMessageForm">
			<input type="text" id="message" autocomplete=off >
			<button id="sendBtn" >전송</button>
		</form>
			<label for="ChatroomSendImage">
				<img src="${pageContext.request.contextPath}/resources/images/sendImage.jpeg"
				style="width:45px;height:40px;cursor:pointer;float:left;maring-left:20px;" title="사진전송">
			</label>
			<form id="SendImage" name="SendImage" enctype="multipart/form-data">
				<input id="ChatroomSendImage" name="ChatroomSendImage" type="file" style="display:none;"accept="image/*">
			</form>
				<img src="${pageContext.request.contextPath}/resources/images/notice.jpeg" onclick="updateChatNotice();"
				style="width:45px;height:40px;cursor:pointer;float:left;maring-left:20px;" title="공지글 작성">
				
			<img src="${pageContext.request.contextPath}/resources/images/background.png" onclick="changeChatroomBackground();"
				style="width:35px;height:35px;cursor:pointer;float:left;margin-left:13px;margin-top:6px;" title="배경화면">
	</div>
</div>
  </div>
	<br><br><br><br><br>
	<br><br><br><br>
</div>

<script type="text/javascript">
	var myid = $("#myid").val();
	var userid = $("#userid").val();
	var otoMyBackground = $("#otoMyBackground").val();
	var otoFrBackground = $("#otoFrBackground").val();
	
	console.log("배경_myid" + myid);
	console.log("배경_userid" + userid);
	console.log("배경_otoMyBackground" + otoMyBackground);
	console.log("배경_otoFrBackground" + otoFrBackground);
	
	$(document).ready(function(){
		$("#chat").scrollTop($("#chat")[0].scrollHeight);
		if(myid != undefined){
			if(myid == userid){
				$("#chat").css({"background":"url(${pageContext.request.contextPath}/resources/chatroomBackground/"+ otoMyBackground +")"});
				$("#chat").css({"background-size":"cover"});
				$("#chat").css({"background-repeat":"no-repeat"});
			}else{
				$("#chat").css({"background":"url(${pageContext.request.contextPath}/resources/chatroomBackground/"+ otoFrBackground +")"});
				$("#chat").css({"background-size":"cover"});
				$("#chat").css({"background-repeat":"no-repeat"});
			}
		}else{
			$("#chat").css({"background":"url(${pageContext.request.contextPath}/resources/chatroomBackground/b.jpg)"});
			$("#chat").css({"background-size":"cover"});
			$("#chat").css({"background-repeat":"no-repeat"});
		}
	});
</script>


<input type="checkbox" id="selectBackground_modal">
<div class="selectBackground_modal">
	<div style="display:flex;flex-wrap:wrap;">
		<div style="margin-top:5px;margin-left:5px;">
			<img src="${pageContext.request.contextPath}/resources/chatroomBackground/airplane.png" 
					style="width:90px;height:150px;cursor:pointer;"class="backgroundImages">
		</div>
		<div style="margin-top:5px;margin-left:5px;">
			<img src="${pageContext.request.contextPath}/resources/chatroomBackground/beach.jpg" 
					style="width:90px;height:150px;cursor:pointer;"class="backgroundImages">
		</div>
		<div style="margin-top:5px;margin-left:5px;">
			<img src="${pageContext.request.contextPath}/resources/chatroomBackground/blue.jpg" 
					style="width:90px;height:150px;cursor:pointer;"class="backgroundImages">
		</div>
		<div style="margin-top:5px;margin-left:5px;">
			<img src="${pageContext.request.contextPath}/resources/chatroomBackground/city.jpg" 
					style="width:90px;height:150px;cursor:pointer;"class="backgroundImages">
		</div>
		<div style="margin-top:5px;margin-left:5px;">
			<img src="${pageContext.request.contextPath}/resources/chatroomBackground/moon.jpg" 
					style="width:90px;height:150px;cursor:pointer;"class="backgroundImages">
		</div>
		<div style="margin-top:5px;margin-left:5px;">
			<img src="${pageContext.request.contextPath}/resources/chatroomBackground/paint.jpg" 
					style="width:90px;height:150px;cursor:pointer;"class="backgroundImages">
		</div>
		<div style="margin-top:5px;margin-left:5px;">
			<img src="${pageContext.request.contextPath}/resources/chatroomBackground/sea.jpg" 
					style="width:90px;height:150px;cursor:pointer;"class="backgroundImages">
		</div>
		<div style="margin-top:5px;margin-left:5px;">
			<img src="${pageContext.request.contextPath}/resources/chatroomBackground/sky.jpg" 
					style="width:90px;height:150px;cursor:pointer;"class="backgroundImages">
		</div>
	</div>
	<hr>
	<div style="display:flex;flex-wrap:wrap;">
		<div style="margin-top:5px;margin-left:5px;">
			<label for="enrollBackground">
				<img src="${pageContext.request.contextPath}/resources/images/addbackground.png" 
						style="width:90px;height:150px;cursor:pointer;" title="배경사진 등록" >
			</label>
			<form id="enrollBackgroundForm" name="enrollBackgroundForm" enctype="multipart/form-data">
					<input id="enrollBackground" name="enrollBackground" type="file" style="display:none;"accept="image/*">
			</form>
		</div>
	</div>
</div>
<script>
$(function(){
	$("#enrollBackground").on("change",function(){
	var co_no = $("#chatroom_no").val();
	var friendid = $("#friendid").val();
	
	var form = $("#enrollBackgroundForm")[0];
	var formData = new FormData(form);
	
	console.log("co_no = " + co_no);
	console.log("friendid = " +friendid);
	console.log("확인" + form);
	
		$.ajax({
			type:"post",
			enctype:"multipart/form-data",
			url:"enrollBackground.do?co_no="+co_no+"&friendid="+friendid,
			data:formData,
			contentType : false,
	        processData : false,
	        success:function(result){
	        	$("#chat").css({"background":"url(${pageContext.request.contextPath}/resources/chatroomBackground/"+ result +")"});
				$("#chat").css({"background-size":"cover"});
				$("#chat").css({"background-repeat":"no-repeat"});
	        },
	        error:function(result){
	        }
	        });
		});
});
</script>

<script type="text/javascript">
	$(function(){
		$(".backgroundImages").on("click",function(){
			var co_no = $("#chatroom_no").val();
			var friendid = $("#friendid").val();
			
			var background = $(this).attr("src");
			console.log("맞아? "+background);
			var backgroundname = background.substring(background.lastIndexOf("/")+1);
			console.log("이름 맞아?" + backgroundname)
			var data = "backgroundname="+backgroundname;
			
			$("#chat").css({"background":"url("+ background +")"});
			$("#chat").css({"background-size":"cover"});
			$("#chat").css({"background-repeat":"no-repeat"});
			
			$.ajax({
				type:"post",
				enctype:"multipart/form-data",
				url:"selectBaseBackground.do?co_no="+co_no+"&friendid="+friendid,
				data:data,
		        success:function(result){
		        },
		        error:function(result){
		        }
		        });
		})
	})
</script>

<script type="text/javascript">
	function changeChatroomBackground(){
		if($("input:checkbox[id='selectBackground_modal']").is(":checked") == true){
			$("input:checkbox[id='selectBackground_modal']").prop("checked", false);	
			$("#selectBackground_modal").prop("checked", false);
		}else{
			$("input:checkbox[id='selectBackground_modal']").prop("checked", true);
			$("#selectBackground_modal").prop("checked", true);
		}
	}
	function updateChatNotice(){
		$("input:checkbox[id='updateNotice_modal']").prop("checked", true);	
		$("#updateNotice_modal").prop("checked", true);
		$("#updateChatNotice").focus();
	}
</script>
<input type="checkbox" id="updateNotice_modal">
<div class="updateNotice_modal">
	<p style="text-align:center;font-size:20px;">공지사항</p>
	<textarea id="updateChatNotice" name="updateChatNotice" cols="35" rows="6" wrap="hard" style="resize:none;margin-left:14px;"></textarea>
	<button type="button" onclick="close_updateChatNotice_modal();">취소</button>
	<button type="button" onclick="submit_updateChatNotice_modal();">등록</button>
</div>
<script>
	function close_updateChatNotice_modal(){
		$("#updateChatNotice").val("");
		$("input:checkbox[id='updateNotice_modal']").prop("checked", false);	
		$("#updateNotice_modal").prop("checked", false);
	}
	function submit_updateChatNotice_modal(){
		var notice = $("#updateChatNotice").val();
		var data = 'notice='+notice;
		var co_no = $("#chatroom_no").val();
		console.log("내용 = " + data);
		console.log("방번호 = " + co_no);
		
		$.ajax({
			type:"POST",
			url:"updateChatNotice.do?co_no="+co_no,
			data:data,
			success:function(result){
				var dcoderesult = decodeURIComponent(result);
				console.log("결과 = " + dcoderesult);
				$("input:checkbox[id='chatroomNotice_modal']").prop("checked", true);	
				$("#chatroomNotice_modal").prop("checked", true);
				
				$("input:checkbox[id='smallNotice_modal']").prop("checked", false);	
				$("#smallNotice_modal").prop("checked", false);
				$("input:checkbox[id='detail_chatroomNotice_modal']").prop("checked", false);	
				$("#detail_chatroomNotice_modal").prop("checked", false);
				
				$(".notice_content").text(result);
				$("#updateChatNotice").val("");
			},
			error:function(error){
				alert(error);
			}
		});
		
		$("input:checkbox[id='updateNotice_modal']").prop("checked", false);	
		$("#updateNotice_modal").prop("checked", false);
		$("#updateChatNotice").text("");
	}
</script>
<input type="checkbox" id="chatroomNotice_modal">
<div class="chatroomNotice_modal">
<div style="width:100%;height:80px;text-overflow:ellipsis;overflow:hidden;white-space:nowrap;display:block">
	<img src="${pageContext.request.contextPath}/resources/images/notice2.jpg" onclick="closeForm_chatroomNotice_modal();" title="접어두기"
	style='width:40px;height:40px;border-radius:50%;margin-left:5px;margin-right:5px;margin-top:10px;float:left;cursor:pointer;'>
	<strong class="notice_content" style="margin-top:10px;white-space: normal; line-height: 1.5; height: 2.4em; text-align: left;
	word-wrap: break-word; display: -webkit-box; -webkit-line-clamp: 3; -webkit-box-orient: vertical;text-overflow:ellipsis;"></strong>
</div>
	<hr style="margin-bottom:2px;">
	<p style="text-align:center;margin-top:5px;height:10px; font-size:20px;cursor:pointer;"onclick="detail_chatroomNotice_modal();">전체보기</p>
</div>

<input type="checkbox" id="smallNotice_modal">
<div class="smallNotice_modal">
	<img src="${pageContext.request.contextPath}/resources/images/notice2.jpg" onclick="reOpen_chatroomNotice_modal();"
	style='width:40px;height:40px;border-radius:50%;cursor:pointer;'>
</div>

<input type="checkbox" id="detail_chatroomNotice_modal">
<div class="detail_chatroomNotice_modal">
	<strong class="notice_content"></strong>
	<div style="height:50px;width:100%;bottom:0px;position:absolute;">
	<hr style="margin-bottom:0px;">
		<p style="height:10px; font-size:20px;text-align:center;cursor:pointer;margin-top:4px;"
		onclick="close_detail_chatroomNotice_modal();" >접어두기</p>
	</div>
</div>

<script type="text/javascript">
	function closeForm_chatroomNotice_modal(){
		$("input:checkbox[id='chatroomNotice_modal']").prop("checked", false);
		$("#chatroomNotice_modal").prop("checked", false);
		
		$("input:checkbox[id='smallNotice_modal']").prop("checked", true);
		$("#smallNotice_modal").prop("checked", true);
	}
	function reOpen_chatroomNotice_modal(){
		$("input:checkbox[id='chatroomNotice_modal']").prop("checked", true);
		$("#chatroomNotice_modal").prop("checked", true);
		
		$("input:checkbox[id='smallNotice_modal']").prop("checked", false);
		$("#smallNotice_modal").prop("checked", false);
	}
	function detail_chatroomNotice_modal(){
		$("input:checkbox[id='detail_chatroomNotice_modal']").prop("checked", true);
		$("#detail_chatroomNotice_modal").prop("checked", true);
		
		$("input:checkbox[id='chatroomNotice_modal']").prop("checked", false);
		$("#chatroomNotice_modal").prop("checked", false);
	}
	function close_detail_chatroomNotice_modal(){
		$("input:checkbox[id='chatroomNotice_modal']").prop("checked", true);
		$("#chatroomNotice_modal").prop("checked", true);
		
		$("input:checkbox[id='detail_chatroomNotice_modal']").prop("checked", false);
		$("#detail_chatroomNotice_modal").prop("checked", false);
	}
</script>

<script type="text/javascript">
  $(document).ready(function() {
	  var OnetoOneChatroomNotice = $("#OnetoOneChatroomNotice").val();
	  console.log("notice = " + OnetoOneChatroomNotice);
	  
	  if(OnetoOneChatroomNotice != ""){
		  $(".notice_content").text(OnetoOneChatroomNotice);
		  $("input:checkbox[id='chatroomNotice_modal']").prop("checked", true);	
		  $("#chatroomNotice_modal").prop("checked", true);
	  }
  }); 
</script>


<script type="text/javascript">
	$(function(){
			/* $('input[id="message"]').keydown(function() {
			    if (event.keyCode === 13) {
			        return false;
			    }
			}); 
			$("#sendBtn").prop("disabled",true);
		
		
		$("#sendMessageForm").submit(function(){
				$("#sendBtn").prop("disabled",true);
				$('input[id="message"]').keydown(function() {
				    if (event.keyCode === 13) {
				        event.preventDefault();
				    }
				});
		})
		
		 $("#message").keypress(function(e){
			 if(e.keyCode == 32){
				 $("#sendBtn").prop("disabled",true);
			 }else{
				 $("#sendBtn").prop("disabled",false);
			 }
		 }) */
	})
</script>

<script>
		$(document).on("click",".sent_Image",function(){
			var img = $(this).attr("src");
			
			console.log("경로 : " + img);
			
			$(".sentImage_detailview").attr("src",img);
			$("#downloadImage").attr("href",img);
		})
				
		function sentImage_detail(){
			$("input:checkbox[id='sentImage_detail_modal']").prop("checked", true);	
			$("#sentImage_detail_modal").prop("checked", true);
		}
	</script>
	<input type="checkbox" id="sentImage_detail_modal">
	<div class="sentImage_detail_modal">
		<img src="" class="sentImage_detailview"
		style="width:300px;">
		
		<img src="${pageContext.request.contextPath}/resources/images/closeprofilemodal.png" title="닫기"
		style='width:50px;height:40px;float:left;margin-left:40px;cursor:pointer;' onclick="close_SentImage_detail_modal();">
		
		<a href="" id="downloadImage" download>
		<img src="${pageContext.request.contextPath}/resources/images/imagedownload.jpg" title="다운로드"
		style='width:50px;height:40px;float:left;margin-left:120px;cursor:pointer;'onclick="downloadImage();"></a>
	</div>

<script>
	$(function(){
		$("#message").focus();
	});
	 function readURL(input){
		 if(input.files&&input.files[0]){
			 var reader = new FileReader();
			 reader.onload = function(e){
				 $(".SendImage_preview").attr("src",e.target.result);
				 console.log(e.target.result);
			 }
			 
			 reader.readAsDataURL(input.files[0]);
		 }
	 }
	$("#ChatroomSendImage").change(function(){
		readURL(this);
		$("input:checkbox[id='SendImage_modal']").prop("checked", true);	
		$("#SendImage_modal").prop("checked", true);
	})
	function close_SentImage_detail_modal(){
		$(".sentImage_detailview").attr("src","${pageContext.request.contextPath}/resources/images/white.png");
		$("input:checkbox[id='sentImage_detail_modal']").prop("checked", false);
		$("#sentImage_detail_modal").prop("checked", false);
	}
	
</script>

<script>

function submit_SendImage_modal(){
	
	var form = $("#SendImage")[0];
	var formData = new FormData(form);
	
	console.log("확인" + form);
	
		$.ajax({
			type:"post",
			enctype:"multipart/form-data",
			url:"SaveSendImage.do",
			data:formData,
			contentType : false,
	        processData : false,
	        success:function(result){
	        	var msgData3 = {
	    				user_profile : $("#profile").val(),
	    				user_nickname : $("#nickname").val(),
	    				chatroom_no : $("#chatroom_no").val(),
	    				msg : "이미지입니다",
	    				image : result
	    		};
	        	var msgData4 = {
	        			friendid : $("#friendid").val(),
	        			co_no : $("#chatroom_no").val(),
	        			msg : "이미지입니다"
	        	};
	        	var jsonData3 = JSON.stringify(msgData3);
	        	var jsonData4 = JSON.stringify(msgData4);
	        	sock.send(jsonData3);
	        	sock2.send(jsonData4);
	        }
		});
		$("input:checkbox[id='SendImage_modal']").prop("checked", false);
		$("#SendImage_modal").prop("checked", false);
}
</script>

 <input type="checkbox" id="SendImage_modal">
 <div class="SendImage_modal">
 	<img src="" class="SendImage_preview"
			style="width:300px;">
			
	<img src="${pageContext.request.contextPath}/resources/images/closeprofilemodal.png" title="닫기"
						style='width:50px;height:40px;float:left;margin-left:30px;cursor:pointer;' onclick="close_SendImage_modal();">
						
	<img src="${pageContext.request.contextPath}/resources/images/submitImage.png" onclick="submit_SendImage_modal();"
						style="width:40px;height:30px;float:left;margin-left:140px;margin-top:5px;cursor:pointer;" title="전송">
 </div> 
<script>
	function close_SendImage_modal(){
		$(".SendImage_preview").attr("src","${pageContext.request.contextPath}/resources/images/white.png");
		$("input:checkbox[id='SendImage_modal']").prop("checked", false);
		$("#SendImage_modal").prop("checked", false);
	}
</script>



	<script type="text/javascript">
	//소켓 연결
	 let sock = new SockJS("<c:url value='/onetoone'/>");
	 let sock2 = new SockJS("<c:url value='/echolist'/>");
		
	 
	 
	   //소켓연결
	  sock.onopen =onOpen;

	
	//메세지전송
	sock.onmessage = onMessage;
	
	//연결 끊음
	sock.onclose = onClose;
	

	$(document).ready(function(){
		$("#chatForm").submit(function(event){
			event.preventDefault();
			sendMessage();
			console.log('send message...');
			$("#message").val('').focus();
		});
	});
	/* --------------------------------------------------------------------------------------------------------------- */
	   function onOpen(){
		   
		   
		      var msgData ={
		            user_nickname : $("#nickname").val(),
		            chatroom_no : $("#chatroom_no").val()
		      }
		      var jsonData = JSON.stringify(msgData);
		      sock.send(jsonData);
		   }

	   /* --------------------------------------------------------------------------------------------------------------- */
	function sendMessage(){
		   
		var friendid = $("#friendid").val();   
		console.log("friendid = " + friendid);
		
		var msgData = {
				user_profile : $("#profile").val(),
				user_nickname : $("#nickname").val(),
				chatroom_no : $("#chatroom_no").val(),
				msg : $("#message").val()
		};
		 var msgData2 ={
		            friendid : $("#friendid").val(),
		            co_no : $("#chatroom_no").val(),
		            msg : $("#message").val()
		      };

		var jsonData = JSON.stringify(msgData);//JSON.stringify란 자바스크립트의 값을 JSON 문자열로 변환한다. 
		 var jsonData2 = JSON.stringify(msgData2);
	      sock.send(jsonData);
	      sock2.send(jsonData2);

	}
	
	/* --------------------------------------------------------------------------------------------------------------- */
	function onMessage(evt){
		var data = evt.data;
		var sessionid = null;
		var message = null;
		var chatroom = null;
		var profile = null;
		var readyn = null;
		var image = null;
		
		
		console.log("데이타 : " + data);
		
		
		
		var strArray = data.split("|");
		
		for(var i=0; i<strArray.length;i++){
			console.log("str["+i+"]" + strArray[i]);
		}
		var currentuser_session = $("#nickname").val();
		var currentchatroom = $("#chatroom_no").val();
		var loginId = $("#nickname").val();
		console.log("current_session_nickname : " + currentuser_session);
		
		if(strArray.length == 6){
			chatroom = strArray[0];
			profile = strArray[1];
			sessionid = strArray[2];
			message = strArray[3];
			image = strArray[4];
			readyn = strArray[5];
			console.log("chatroom :" + chatroom);
			console.log("message : " + message);
			console.log("profile : " + profile);
			console.log("readyn : " + readyn);
			console.log("sessionid : " + sessionid);
			console.log("image : " + image);
			
			/* <img src="${pageContext.request.contextPath}/resources/images/sendImage.jpeg"
				style="width:45px;height:40px;cursor:pointer;float:left;maring-left:20px;" title="사진전송"> */
				
			if(chatroom == currentchatroom){
				if(sessionid == currentuser_session){
					var printHTML = "<div>";
					printHTML += "<div class='interval'>";
					printHTML += "<img src='${pageContext.request.contextPath}/resources/profile/" + profile 
											+ "' style='float:right;width:40px;height:40px;border-radius:40%'>"
											+" <strong class='a' style='float:right;margin-right:10px;margin-top:7px;max-width:200px;' id='mymsg'>&nbsp;"
											+"<img src='${pageContext.request.contextPath}/resources/ChatroomSendImage/" + image 
											+ "'class='sent_Image' style='width:150px;margin-top:10px;cursor:pointer;' onclick='sentImage_detail();'>"
											+"&nbsp;</strong>&nbsp;<strong style='float:right;margin-right:7px;margin-top:20px;color:yellow;font-size:12px;'class='readyn'>"
											+readyn+"</strong>";
					printHTML += "</div>";
					printHTML += "</div>";
					printHTML += "<br clear='both'>";
					$("#chat").append(printHTML);
					$("#chat").scrollTop($("#chat")[0].scrollHeight);
				}else{
					var printHTML = "<div>";
					printHTML += "<div class='interval'>";
					printHTML += "<img src='${pageContext.request.contextPath}/resources/profile/"+ profile
											+"' style='width:40px;height:40px;border-radius:40%;float:left;'>"
											+"<p style='margin-top:-5px;float:left;width:23px;overflow:visible;white-space:nowrap;'>&nbsp;&nbsp;"+ sessionid +"</p>"
											+"<strong class='a'style='margin-left:-10px;float:left;margin-top:15px;max-width:200px;' id='othermsg'>&nbsp;"
											+"<img src='${pageContext.request.contextPath}/resources/ChatroomSendImage/" + image 
											+ "' class='sent_Image' style='width:150px;margin-top:10px;cursor:pointer;' onclick='sentImage_detail();'>"
											+"&nbsp;</strong>&nbsp;<strong style='float:left;margin-left:7px;margin-top:20px;color:yellow;font-size:12px;'class='readyn'>"
											+readyn+"</strong>";
					printHTML += "</div>";
					printHTML += "</div>";
					printHTML += "<br clear='both'>";
					$("#chat").append(printHTML);
					$("#chat").scrollTop($("#chat")[0].scrollHeight);
				} 
			}
				//여기서 ajax? 디비에서 불러온건 모달자세히보기가 켜지는데 이렇게 붙인건 안켜짐
		}else{
		chatroom = strArray[0];
		profile = strArray[1];
		sessionid = strArray[2];
		message = strArray[3];
		readyn = strArray[4];
		console.log("chatroom :" + chatroom);
		console.log("currentchatroom" + currentchatroom);
		console.log("message : " + message);
		console.log("profile : " + profile);
		console.log("readyn : " + readyn);
		console.log("sessionid : " + sessionid);
		console.log("loginId : " + loginId);
		
		if(message == "null"){
			if(sessionid != loginId){
				$(".readyn").text('');
			}
			/* userEnter(); */
			/* var printHTML = "<div>"; */
			/* printHTML += "<div class='intervalgreet'>";
			printHTML += "<strong class='a' id='enterdiv'>&nbsp;[ "+sessionid +" ]님께서 입장하셨습니다   "+"&nbsp;</strong>";
			printHTML += "</div>"; */
			/* printHTML += "</div>";
			$("#chat").append(printHTML); */
			return 0;
		}
		
		if(message == "믜댜퇴장듀틔"){
			/* userEnter();
			var printHTML = "<div>";
			printHTML += "<div class='interval'>";
			printHTML += "<strong class='a'>[ "+sessionid +" ]님께서 퇴장하셨습니다   "+"</strong>";
			printHTML += "</div>";
			printHTML += "</div>";
		
			$("#chat").append(printHTML); */
			return 0;
		}
		
		 if(chatroom == currentchatroom){
			if(sessionid == currentuser_session){
				var printHTML = "<div>";
				printHTML += "<div class='interval'>";
				printHTML += "<img src='${pageContext.request.contextPath}/resources/profile/" + profile 
										+ "' style='float:right;width:40px;height:40px;border-radius:40%'>"
										+" <strong class='a' style='float:right;margin-right:10px;margin-top:7px;max-width:200px;' id='mymsg'>&nbsp;"+message
										+"&nbsp;</strong>&nbsp;<strong style='float:right;margin-right:7px;margin-top:20px;color:yellow;font-size:12px;'class='readyn'>"
										+readyn+"</strong>";
				printHTML += "</div>";
				printHTML += "</div>";
				printHTML += "<br clear='both'>";
				$("#chat").append(printHTML);
				$("#chat").scrollTop($("#chat")[0].scrollHeight);
			}else{
				var printHTML = "<div>";
				printHTML += "<div class='interval'>";
				printHTML += "<img src='${pageContext.request.contextPath}/resources/profile/"+ profile
										+"' style='width:40px;height:40px;border-radius:40%;float:left;'>" 
										+"<p style='margin-top:-5px;float:left;width:23px;overflow:visible;white-space:nowrap;'>&nbsp;&nbsp;"+ sessionid +"</p>"
										+"<strong class='a'style='margin-left:-10px;float:left;margin-top:15px;max-width:200px;' id='othermsg'>&nbsp;"
										+message+"&nbsp;</strong>&nbsp;<strong style='float:left;margin-left:7px;margin-top:20px;color:yellow;font-size:12px;'class='readyn'>"
										+readyn+"</strong>";
				printHTML += "</div>";
				printHTML += "</div>";
				printHTML += "<br clear='both'>";
				$("#chat").append(printHTML);
				$("#chat").scrollTop($("#chat")[0].scrollHeight);
			} 
		
		}else{
			console.log("오류 ");
		}
		}
	}
	/* --------------------------------------------------------------------------------------------------------------- */
	function onClose(evt){
		$("#data").append("연결 끊김");
		
		var msgData = {
				user_nickname : $("#nickname").val(),
				chatroom_no : $("#chatroom_no").val(),
				msg : "퇴장"
		};
		
		console.log(evt.data);
		var jsonData = JSON.stringify(msgData);
		sock.send(jsonData);
	}  
	
	/* --------------------------------------------------------------------------------------------------------------- */
	/* function userEnter(){
		
		console.log("오나?");
		var roomnumber = $("#chatroom_no").val();
		
		$.ajax({
			url:"enteruserlist.do",
			data:{roomnumber:roomnumber},
			success:function(data){
				$userlist = $("#chatRoomUserList");
				$userlist.html("");
				
				
				for(var i in data.list){
					var $div = $("<div>");
					var $nickname = $("<strong class='b'>").text(data.list[i].nickname);
					
					
					$div.append($nickname);
					$userlist.append($div);
				}
			},
			error:function(request, status, errorData){
                alert("error code: " + request.status + "\n"
                      +"message: " + request.responseText
                      +"error: " + errorData);
           }  
		});
	
	} */
	
	
	</script>
</body>
</html>


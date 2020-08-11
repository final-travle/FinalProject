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
            border: 2px solid black;
            background: ivory;
        }
        #chat {
            height: 90%;
            word-break:break-all;
            background-image: url("${pageContext.request.contextPath}/resources/images/b.jpg");
            background-size: cover;
            background-repeat: no-repeat;
        }
        #chatForm {
            height: 10%;
            border-top: 1px solid black;
            background-color:#D8D8D8;
            text-align: center;
        }
        #message {
            width: 80%;
            height: 32px;
            border-radius: 8px;
        }
        #sendBtn {
            width: 16%;
            height: 34px;
            border-radius: 50px;
            background: black;
            color: white;
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
 
<div id="container">
	<div id="chat" class="chat">
	
	<c:forEach var="otomsg" items="${otomsg }">
			<c:if test="${loginUser.id  eq otomsg.chatId }">
				<div>
					<div class='interval'>
						<img src="${pageContext.request.contextPath}/resources/profile/${otomsg.profile}"
						 style='float:right;width:40px;height:40px;border-radius:40%'>
						<strong class='a' style='float:right;margin-right:10px;margin-top:7px;max-width:200px;' id='mymsg'>
						&nbsp;${otomsg.content }&nbsp;</strong>
					</div>
				</div>
				<br clear='both'>
			</c:if>
			<c:if test="${loginUser.id  ne otomsg.chatId }">
				<div>
					<div class='interval'>
						<img src="${pageContext.request.contextPath}/resources/profile/${otomsg.profile}"
						style='width:40px;height:40px;border-radius:40%;float:left;'>
						<p style='margin-top:-5px;float:left;'>&nbsp;&nbsp;${otomsg.nickname }</p>
						<strong class='a' style='margin-left:-23px;float:left;margin-top:15px;max-width:200px;' id='othermsg'>&nbsp;
						${otomsg.content }&nbsp;&nbsp;</strong>
					</div>
				</div>
				<br clear='both'>
			</c:if>
	</c:forEach>
	
	
	
		<div id="chatdata">
			<input type="hidden" value="${loginUser.id }" id="userid">
			<input type="hidden" value="${loginUser.nickname }" id="nickname">
			<input type="hidden" value="${oto.co_no }" id="chatroom_no">
			<input type="hidden" value="${loginUser.profile }" id="profile">
		</div>
	</div>
		<form id="chatForm">
			<input type="text" id="message" autocomplete=off >
			<button id="sendBtn" >send</button>
		</form>
</div>
	
  </div>
	

	
	<br><br><br><br><br>
	<br><br><br><br>
</div>



	<script type="text/javascript">
	//소켓 연결
	 let sock = new SockJS("<c:url value='/onetoone'/>");

		
	 
	 
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
		var msgData = {
				user_profile : $("#profile").val(),
				user_nickname : $("#nickname").val(),
				chatroom_no : $("#chatroom_no").val(),
				msg : $("#message").val()
		};
		var jsonData = JSON.stringify(msgData);//JSON.stringify란 자바스크립트의 값을 JSON 문자열로 변환한다. 
		sock.send(jsonData);
	}
	
	/* --------------------------------------------------------------------------------------------------------------- */
	function onMessage(evt){
		var data = evt.data;
		var sessionid = null;
		var message = null;
		var chatroom = null;
		var profile = null;
		
		
		
		console.log("데이타 : " + data);
		
		
		
		var strArray = data.split("|");
		
		for(var i=0; i<strArray.length;i++){
			console.log("str["+i+"]" + strArray[i]);
		}
		var currentuser_session = $("#nickname").val();
		var currentchatroom = $("#chatroom_no").val();
		console.log("current_session_nickname : " + currentuser_session);
		
		//1. 채팅방번호  2.세션아이디 3.메세지내용
		chatroom = strArray[0];
		profile = strArray[1];
		sessionid = strArray[2];
		message = strArray[3];
		console.log("chatroom :" + chatroom);
		console.log("currentchatroom" + currentchatroom);
		console.log("message : " + message);
		console.log("profile : " + profile);
		
		if(message == "null"){
			userEnter();
			var printHTML = "<div>";
			printHTML += "<div class='intervalgreet'>";
			printHTML += "<strong class='a' id='enterdiv'>&nbsp;[ "+sessionid +" ]님께서 입장하셨습니다   "+"&nbsp;</strong>";
			printHTML += "</div>";
			printHTML += "</div>";
			$("#chat").append(printHTML);
			return 0;
		}
		
		if(message == "믜댜퇴장듀틔"){
			userEnter();
			var printHTML = "<div>";
			printHTML += "<div class='interval'>";
			printHTML += "<strong class='a'>[ "+sessionid +" ]님께서 퇴장하셨습니다   "+"</strong>";
			printHTML += "</div>";
			printHTML += "</div>";
		
			$("#chat").append(printHTML);
			return 0;
		}
		
		 if(chatroom == currentchatroom){
			if(sessionid == currentuser_session){
				var printHTML = "<div>";
				printHTML += "<div class='interval'>";
				printHTML += "<img src='${pageContext.request.contextPath}/resources/profile/" + profile 
										+ "' style='float:right;width:40px;height:40px;border-radius:40%'>"
										+" <strong class='a' style='float:right;margin-right:10px;margin-top:7px;max-width:200px;' id='mymsg'>&nbsp;"+message
										+"&nbsp;</strong>";
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
										+"<p style='margin-top:-5px;float:left;'>&nbsp;&nbsp;"+ sessionid +"</p>"
										+"<strong class='a'style='margin-left:-23px;float:left;margin-top:15px;max-width:200px;' id='othermsg'>&nbsp;"
										+message+"&nbsp;&nbsp;</strong>";
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
	function userEnter(){
		
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
	
	}
	
	
	</script>
</body>
</html>


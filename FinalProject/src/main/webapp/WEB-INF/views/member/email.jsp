<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<title></title>
	<script src="../../js/jquery-3.4.1.min.js"></script>
	<style>
	   
.btn { width:100px; height:40px; border:2px solid #bd9dec; background:#fff; border-radius:3px; line-height:40px; text-align:center; box-sizing:border-box; }
.btn a {  color:#bd9dec; font-weight:700; }
.colorBtn { background:#bd9dec; color:#fff; }
		a {
			text-decoration: none;
			color: darkgrey;
		}
		
		#nextbtn {
			width: 200px;
			height: 30px;
			border-radius: 8px;
			color: white;
			background: darkgrey;
		}
		
		input::-webkit-input-placeholder {
			color: lightgray;
		}
		
		.cont {
			width: 1460px;
			margin: 0 auto;
		}
		
		.cont form {
			width: 600px;
			margin: 0 auto;
			/* border: 1px solid black; */
			text-align: center;
		}
	</style>
</head>
<body>
	<jsp:include page="../common/header.jsp" />
	
	 <br>
     <br>
     <br>

	<div class="cont">
		<form method="post" action="join_injeung.do">
            <h2>이메일인증</h2>
            <hr style="height: 5px; background: black;">
            <br>
            <div>코드 입력</div>
            <div style="font-size: 12px; color: darkgray;">인증코드를 적어주세요.</div> 제한시간 : <B><span id="timer"></span></B> <br>
            <br>
            <input type="text" id="userId" name="email_injeung" style="width: 600px; height: 30px; border-radius: 8px; " placeholder="인증코드를 적어주세요">
            <br>    
            <input type="hidden" name="dice" value=${dice } />
  			<input type="hidden" name="member" value=${member.id } />
            <br>
            <div style="font-size: 12px; color: darkgrey">
            	인증번호를 다시 받으시겠습니까?
            <a href="searchPwd.do">재전송</a>
            </div>
            <br>
            <hr>
            <br>
          	 <input class="colorBtn btn" type="submit" value="다음" id="nextbtn" style="font-size: 16px;">
        </form>
	</div>
<br>
    <br>

	<script>
	
		var iSecond;
		var timerchecker =null;
		
		window.onload= function(){
			fncClearTime();
			initTimer();
		}
		
		function fncClearTime(){
			iSecond=300;
		}
		
		Lpad = function(str,len){
			str = str+"";
			while(str.length< len){
				str="0"+str;
			}
			return str;
		}
		
		initTimer = function(){
			var timer = document.getElementById("timer");
			rMinute = parseInt(iSecond / 60);
			rMinute = rMinute % 60;
			rSecond = iSecond % 60;
			if(iSecond > 0){
				timer.innerHTML = "&nbsp;"+Lpad(rMinute,2)+"분" +Lpad(rSecond,2)+"초";
				iSecond--;
				timerchecker = setTimeout("initTimer()",1000);
			}else{
				TimeOver();
			}
		
		}
		function TimeOver(){
			clearTimeout(timerchecker);
			alert('시간이 초과되었습니다.');
			window.history.go(-1);
		}
		
	
         </script>
		<%-- // 비밀번호 변경 성공 시
         $(function(){
         <%if(msg != null){%>
			alert("<%=msg%>");
		 <%}%>
        	 
         });
         // 인증 실패 시
         $(function(){
             <%if(msg1 != null){%>
    			alert("<%=msg1%>");
    		 <%}%>
            	 
             });
         // 비밀번호 변경 실패 시
         $(function(){
             <%if(msg2 != null){%>
    			alert("<%=msg2%>");
    		 <%}%>
            	 
             }); --%>
          


	

<jsp:include page="../common/footer.jsp" />

	
</body>
</html>
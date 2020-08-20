<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<title></title>
	<script src="../../js/jquery-3.4.1.min.js"></script>
	<style>
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
		<form method="post" action="auth.do">
            <h2>비밀번호 찾기</h2>
            <hr style="height: 5px; background: black;">
            <br>
            <div>아이디 입력</div>
            <div style="font-size: 12px; color: darkgray;">비밀번호를 찾고자 하는 아이디를 입력해 주세요.</div>
            <br>
            <input type="text" id="userId" name="id" style="width: 600px; height: 30px; border-radius: 8px; " placeholder="아이디를 입력해주세요">
            <br>     
            <div>이메일 입력</div>
            <div style="font-size: 12px; color: darkgray;">비밀번호를 찾고자 하는 이메일을 입력해 주세요.</div>
            <br>
            <input type="text" id="userEmail" name="email" style="width: 600px; height: 30px; border-radius: 8px; " placeholder="이메일을 입력해주세요">
            <br>
            
            
            
            
            <br>
            <div style="font-size: 12px; color: darkgrey">
            	아이디를 모르시나요?
            <a href="searchId.do">아이디 찾기</a>
            </div>
            <br>
            <hr>
            <br>
          	 <input type="submit" value="다음" id="nextbtn" style="font-size: 16px;">
        </form>
	</div>
	<br>
    <br>
    

<jsp:include page="../common/footer.jsp" />


	<script>
	
		// 아이디 
        /*  $("#userid").change(function(){
                    var value = $("#userid").val();
                    var reg = /^[a-z0-9]{4,12}$/;
                    if(!reg.test(value)){
                        alert("영문자와 숫자로 4글자 이상 12글자 이하여야 합니다.");
                        $("#userid").focus().val('');
                    }
         }); */
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
          


	

	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<style>
            p, input, span, div { padding:0; margin:0; }
            #h2{
                text-align: center;
            }
            #logintable{
                width: 600px;
                /* text-align: center; */
            }
           .p{
				    vertical-align: middle;
            }
            
            td.p span { width:28%; display:inline-block; }
            a{
                text-decoration:none;
                color:  #bd9dec;
            }
            input::-webkit-input-placeholder { 
                color: lightgray; 
            }
            #div1{
                padding: 20px; 
                font-size: 25px; 
                background: #bd9dec; 
                margin: 0 auto; 
                text-align: center;
            }
            .log1{
                height: 30px;
                width: 70%; 
                box-sizing:border-box;
                border-radius: 4px;
            }
            #btn{
                height: 100px; 
                width: 180px; 
                color: white; 
                font-size: 16px; 
                border-radius: 4px; 
                background: #bd9dec;
            }
            #check1{
                float: left;
                
            }
            #idsave{
                color: #bd9dec;
                float:left
            }
            #memberJoin{
                background: #bd9dec; 
                color: white; 
                width: 600px; 
                text-align: center; 
                height: 80px; 
                border-radius: 4px; 
                font-size: 16px;
            }
            
            .cont{
            	width:1460px;
            	margin:0 auto;            
            }
            
            #loginform{
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
        <br>
        
        
        <form id="loginform" method="post" name="loginInfo" action="mlogin.do" onsubmit="return checkValue()">
            <h2 id="h2">Login</h2>
            <hr>
            <br>
            <table id="logintable">
                <tr class="p">
                    <td class = "p">
                      <span>ID :</span>  <input type="text" class="log1" name="id" id="userId" placeholder="이름을 입력해주세요">
                    </td>
                    <td rowspan="2">
                        <input type="submit" id="btn" value="LOGIN">
                    </td>
                    
                </tr>
                <tr>
                    <td class = "p">
                      <span>Passward :</span>  <input type="password" class="log1" name="pwd" id="userPwd" placeholder="비밀번호를 입력해주세요">
                    </td>
                </tr>
            </table>
            <div>
                <input type="checkbox" id="check1">
                <label id="idsave">아이디 저장</label>
                
                <label style="float: right;"><a href="searchPwd.do">비밀번호찾기</a></label>
                <label style="float: right; text-decoration: none"><a href="searchId.do">아이디찾기 /&nbsp;</a></laebel>
                
            </div>
            <br>
            <br>
             <!-- <input type="button" id="klogin" value="klog  -->
            <br>
            <br>
            <hr>
            <br>
            
      		
        </form>
        <script>       		
            	// 아이디
                $("#userId").change(function(){
                    var value = $("#userId").val();
                    var reg = /^[a-z0-9]{4,12}$/;
                    if(!reg.test(value)){
                        alert("영문자와 숫자로 4글자 이상 12글자 이하여야 합니다.");
                        $("#userId").focus().val('');
                    }
                });
            	
            	// 비밀번호
                $("#userPwd").change(function(){
                    var value = $("#userPwd").val();
                    var reg = /^[a-z0-9]{6,18}$/;
                    if(!reg.test(value)){
                        alert("영문자와 숫자로 6글자 이상 12글자 이하여야 합니다.");
                        $("#userPwd").focus().val('');
                    }
                });
                
            	// 회원가입 버튼
                $("#memberJoin").click(function(){
                	location.href="<%=request.getContextPath()%>/views/member/memberJoin.jsp";
                });
                
                $("#klogin").click(function(){
                	location.href="<%=request.getContextPath()%>/views/member/kLogin.jsp";
                });
                
            	
            	
            	
            	
            	
            	
                // 아이디 저장 코드
                var key = getCookie("key");
                $("#userId").val(key); 
                 
                if($("#userId").val() != ""){ // 그 전에 ID를 저장해서 처음 페이지 로딩 시, 입력 칸에 저장된 ID가 표시된 상태라면,
                    $("#check1").attr("checked", true); // ID 저장하기를 체크 상태로 두기.
                }
                 
                $("#check1").change(function(){ // 체크박스에 변화가 있다면,
                    if($("#check1").is(":checked")){ // ID 저장하기 체크했을 때,
                        setCookie("key", $("#userId").val(), 7); // 7일 동안 쿠키 보관
                    }else{ // ID 저장하기 체크 해제 시,
                        deleteCookie("key");
                    }
                });
                 
                // ID 저장하기를 체크한 상태에서 ID를 입력하는 경우, 이럴 때도 쿠키 저장.
                $("#userId").keyup(function(){ // ID 입력 칸에 ID를 입력할 때,
                    if($("#check1").is(":checked")){ // ID 저장하기를 체크한 상태라면,
                        setCookie("key", $("#userId").val(), 7); // 7일 동안 쿠키 보관
                    }
                });
           
            function setCookie(cookieName, value, exdays){
                var exdate = new Date();
                exdate.setDate(exdate.getDate() + exdays);
                var cookieValue = escape(value) + ((exdays==null) ? "" : "; expires=" + exdate.toGMTString());
                document.cookie = cookieName + "=" + cookieValue;
            }
             
            function deleteCookie(cookieName){
                var expireDate = new Date();
                expireDate.setDate(expireDate.getDate() - 1);
                document.cookie = cookieName + "= " + "; expires=" + expireDate.toGMTString();
            }
             
            function getCookie(cookieName) {
                cookieName = cookieName + '=';
                var cookieData = document.cookie;
                var start = cookieData.indexOf(cookieName);
                var cookieValue = '';
                if(start != -1){
                    start += cookieName.length;
                    var end = cookieData.indexOf(';', start);
                    if(end == -1)end = cookieData.length;
                    cookieValue = cookieData.substring(start, end);
                }
                return unescape(cookieValue);
            }
            // 아이디 저장 코드 end
            
            
         function checkValue()    {
            inputForm = eval("document.loginInfo");
            if(!inputForm.id.value)
            {
                alert("아이디를 입력하세요");    
                inputForm.id.focus();
                return false;
            }
            if(!inputForm.pwd.value)
            {
                alert("비밀번호를 입력하세요");    
                inputForm.pwd.focus();
                return false;
            }
        }
 }


        </script>
        
       
</body>
</html>
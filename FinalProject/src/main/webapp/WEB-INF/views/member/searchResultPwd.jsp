<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang='ko'>
<head>
   <title></title>
   <style>
   
.btn { width:100px; height:40px; border:2px solid #bd9dec; background:#fff; border-radius:3px; line-height:40px; text-align:center; box-sizing:border-box; }
.btn a {  color:#bd9dec; font-weight:700; }
.colorBtn { background:#bd9dec; color:#fff; }
        #h1{
               margin-left: 300px;
           }
        #h3{
            text-align: center;
            padding:0;
            margin:0;
        }
        #hansol1{
            width: 800px;
            margin: 0 auto;
        }
        #hansol2{
           border : 1px;
            width: 100%;
            height:300px;
            padding:0;
            margin:0;
            line-height:100px;
            border-color: gray;
            border-style: solid;
           
        }
        #home{
        	float : left;

        }
        #searchId{float : right;}
    </style>
<body>
<jsp:include page="../common/header.jsp" />

    <div id="hansol1">
    <h1 id="h1">SEARCH RESULT</h1>
    
        <form id="joinForm" name="join" method="post" action="changepass.do">
    <div id="hansol2">
       <br>
       <h3 id="h3">
        
           변경할 비밀먼호 :  <input type="password" id="userPwd" name="pass" style="width: 200px; height: 30px;  " placeholder="변경할 비밀번호를 적어주세요">
            <input type="hidden" value=${result } name="result" >
                
            </h3>
            <br>
    </div>
    
    <button id="home" class="colorBtn btn" onclick="location.href='home.do'">홈으로 </button>
      <input type="submit" class="colorBtn btn" value="변경" id="searchId"  name="pwd" style="font-size: 16px;">
    </form>
    </div>
    <br>
    <br>
   <jsp:include page="../common/footer.jsp" />
   
   <script>
   $(function(){
	   $("#userPwd").change(function(){
           var value = $("#userPwd").val();
           var reg = /^[a-z0-9]{6,18}$/;
           if(!reg.test(value)){
               alert("영문자와 숫자로 6글자 이상 18글자 이하여야 합니다.");
              
           }else{
           	
           }
       });
  
	   
	   
	   
   })
   </script>
</body>

</html>
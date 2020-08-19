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
            line-height:300px;
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
    <h1 id="h1">SEARCH RESULT</h2>
    <div id="hansol2">
       <h3 id="h3"> <c:out value="${result.name }님의 비밀번호는 ${result.pwd}입니다"/></h3>
    </div>
    <button id="home" class="colorBtn btn" onclick="location.href='home.do'">홈으로 </button> <button class="colorBtn btn" id="searchId" onclick="location.href='searchId.do'">아이디찾기 </button>
    
    </div>
    <br>
    <br>
   <jsp:include page="../common/footer.jsp" />
   
</body>

</html>
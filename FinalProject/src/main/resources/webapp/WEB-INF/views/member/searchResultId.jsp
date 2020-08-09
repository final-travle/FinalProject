<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang='ko'>
<head>
   <title></title>
   <style>
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
    </style>
<body>
    <div id="hansol1">
    <h1 id="h1">SEARCH RESULT</h2>
    <div id="hansol2">
       <h3 id="h3"><c:out value="${result.name }님의 아이디는 ${result.id}입니다"/></h3>
    </div>
    <button id="home" onclick="location.href='home.do'">홈으로 </button> <button id="searchPwd" onclick="location.href='searchPwd.do'">비밀번호찾기 </button>
    </div>
</body>

</html>
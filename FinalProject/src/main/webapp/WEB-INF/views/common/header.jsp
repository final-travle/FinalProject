<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
</head>
<body>
   <c:set var="contextPath" value="${pageContext.servletContext.contextPath }" scope="application"/>
    <div id="headWrap">
        <header id="header" class="cb">
            <h1 class="logo"><img src="${contextPath}/images/logo.png"></h1>
            <div class="logSection">
                <!-- 로그인하지 않았을 때 -->
                <div class="log-out cf">
                    <p class="btn colorBtn"><a href="#none">회원가입</a></p>
                    <p class="btn"><a href="#none">로그인</a></p>
                </div>
                <!-- 로그인했을 때 -->
                <div class="log-in cf">
                    <p class="btn"><a href="#none">로그아웃</a></p>
                    <p class="btn colorBtn"><a href="#none">마이페이지</a></p>
                    <div class="userRound">
                        <p>한솔찡</p><!-- user nickname 들어갈 부분 -->
                    </div>
                </div>
            </div>
        </header>
        <nav id="nav">
            <ul class="topMenu cf">
                <li><a href="#none">홈</a></li>
                <li><a href="#none">플랜</a></li>
                <li><a href="#none">탐색</a></li>
                <li><a href="#none">리뷰</a></li>
                <li><a href="#none">이벤트</a></li>
            </ul>
        </nav>
    </div>
    <!-- // header end -->
</body>
</html>
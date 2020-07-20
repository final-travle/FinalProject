<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/reset.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/swiper-bundle.min.css" />" rel="stylesheet">
<link rel="stylesheet" href="http://cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
<script src="http://code.jquery.com/jquery-1.12.4.min.js" integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ=" crossorigin="anonymous"></script>
<script src="<c:url value="/resources/js/action.js" />"></script>
<script src="<c:url value="/resources/js/swiper-bundle.min.js" />"></script>
</head>
<body>
   <c:set var="contextPath" value="${pageContext.servletContext.contextPath }" scope="application"/>
    <div id="headWrap">
        <header id="header" class="cb">
            <h1 class="logo"><img src="<c:url value="/resources/images/logo.png" />"></h1>
            <div class="logSection">
                <!-- 로그인하지 않았을 때 -->
                <div class="log-out cf">
             
                <c:if test="${empty sessionScope.loginUser}">
                    <p class="btn colorBtn"><a href="memberJoin.do">회원가입</a></p>
                    <p class="btn"><a href="login.do">로그인</a></p>
                    </c:if>
                </div>
                <!-- 로그인했을 때 -->
                <div class="log-in cf">
                <c:if test="${!empty sessionScope.loginUser}">
                	<p><c:out value="${loginUser.name }님"/></p>
                    <p class="btn"><a href="logout.do">로그아웃</a></p>
                    <p class="btn colorBtn"><a href="friends.do">마이페이지</a></p>
                    </c:if>
                    <div class="userRound">
                        <p><c:out value="${loginUser.nicname }"/> </p><!-- user nickname 들어갈 부분 -->
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
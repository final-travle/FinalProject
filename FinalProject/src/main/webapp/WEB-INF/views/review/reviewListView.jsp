<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="../common/header.jsp" />
    <div id="container" class="cf">
        <div id="content">
            
            <!-- review -->
            <h2 class="title"><span class="color">주목해야 할 여행지!</span> 아직도 안 가봤어요?</h2>
            
            <ul class="grid grid3 cf">
                <li>
                    <p class="img">
                        <a href="#none"><img src="images/adImg.jpg" /></a>
                    </p>
                    <p class="title">서울</p>
                    <p class="cont">#2박3일 #힐링 #호캉스</p>
                </li>
                <li>
                    <p class="img">
                        <a href="#none"><img src="images/adImg.jpg" /></a>
                    </p>
                    <p class="title">제주</p>
                    <p class="cont">#호캉스 #바다 #여자끼리</p>
                </li>
                <li>
                    <p class="img">
                        <a href="#none"><img src="images/adImg.jpg" /></a>
                    </p>
                    <p class="title">전주</p>
                    <p class="cont">#당일치기 #돼지파티</p>
                </li>
                <li>
                    <p class="img">
                        <a href="#none"><img src="images/adImg.jpg" /></a>
                    </p>
                    <p class="title">전주</p>
                    <p class="cont">#당일치기 #돼지파티</p>
                </li>
                <li>
                    <p class="img">
                        <a href="#none"><img src="images/adImg.jpg" /></a>
                    </p>
                    <p class="title">서울</p>
                    <p class="cont">#2박3일 #힐링 #호캉스</p>
                </li>
                <li>
                    <p class="img">
                        <a href="#none"><img src="images/adImg.jpg" /></a>
                    </p>
                    <p class="title">제주</p>
                    <p class="cont">#호캉스 #바다 #여자끼리</p>
                </li>
            </ul>
            <div class="insertBtns cf">
                <a href="#none" class="insert colorBtn btn">글쓰기</a>
            </div>

            <div class="pagination">
                <span class="fprev"> ≪ </span>
                <span class="prev"> ＜ </span>
                <span class="number"><a href="#none">1 2 3 4 5 6 7 8 9 10</a></span>
                <span class="next"> ＞ </span>
                <span class="lnext"> ≫ </span>
            </div>
            <!-- // Review -->

        </div><!-- // content end -->
        <div class="chatSec">
            <p class="chatBtn">
                <a href="#none">지역채팅 바로가기</a>
            </p>
        </div>
    </div><!-- // container end -->
<jsp:include page="../common/footer.jsp" />
</body>
</html>
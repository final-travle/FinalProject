<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<jsp:include page="common/header.jsp" />
   <!-- 메인 컨텐츠 영역 start -->
   
   <!-- 임시로 만든 버튼 -->
   <div class="chatSec">
            <p class="chatBtn" >
                <a href="javascript:openChat('chat');">지역채팅 바로가기</a>
            </p>
        </div>		
   <!-- 임시로 만든 버튼 -->
   
    <!-- 이미지 슬라이드 영역 -->
    <div class="mainSlide">
        <div class="swiper-container">
            <div class="swiper-wrapper">
                <div class="swiper-slide exImg"><img src="<c:url value="/resources/images/main_img01.jpg" />" /></div>
                <div class="swiper-slide exImg"><img src="<c:url value="/resources/images/main_img01.jpg" />" /></div>
                <div class="swiper-slide exImg"><img src="<c:url value="/resources/images/main_img01.jpg" />" /></div>
                <div class="swiper-slide exImg"><img src="<c:url value="/resources/images/main_img01.jpg" />" /></div>
            </div>
            
            <!-- Add Pagination -->
            <div class="swiper-pagination"></div>
            <!-- Add Arrows -->
            <div class="swiper-button-next"></div>
            <div class="swiper-button-prev"></div>
            
        </div>
        <div class="searchWrap">
            <i class="xi-search xi-2x"></i>
            <input type="search" id="search" name="search" placeholder="원하시는 여행 키워드를 검색해 보세요! ex) 힐링, 커플, 가족, 서울, 부산..." />
        </div>
    </div>
    <script>
        
        // 메인 슬라이드
        var swiper = new Swiper('.swiper-container', {
            slidesPerView: 1,     // 한 페이지에 보여질 이미지 갯수
            spaceBetween: 0,      // 페이지와 페이지 사이의 공백
            loop: true,           // 마지막 장이 끝나면 첫장으로 돌아갈 것인지
            pagination: {
            el: '.swiper-pagination',
            clickable: true,            // 드래그로 페이지를 넘길 수 있게 할것인지
            },
            navigation: {
            nextEl: '.swiper-button-next',
            prevEl: '.swiper-button-prev',
            },
        });
    </script>
    <!-- // 이미지 슬라이드 영역 -->
    <div id="container" class="cf">
        <div id="content">

            <!-- AD -->
            <h2 class="title"><span class="color">소리찡</span> 님만을 위한 추천 포인트!</h2>
            
            <ul class="grid grid4 cf">
                <li>
                    <p class="img">
                        <a href="#none"><img src="<c:url value="/resources/images/adImg.jpg" />" /></a>
                    </p>
                    <p class="title">혼저옵서예!</p>
                    <p class="cont">이번 달! 제주 여행 어때요?</p>
                </li>
                <li>
                    <p class="img">
                        <a href="#none"><img src="<c:url value="/resources/images/adImg.jpg" />" /></a>
                    </p>
                    <p class="title">여름엔 역시 부산이죠?</p>
                    <p class="cont">인스타에서 가장 힙한 카페!</p>
                </li>
                <li>
                    <p class="img">
                        <a href="#none"><img src="<c:url value="/resources/images/adImg.jpg" />" /></a>
                    </p>
                    <p class="title">혼저옵서예!</p>
                    <p class="cont">이번 달! 제주 여행 어때요?</p>
                </li>
                <li>
                    <p class="img">
                        <a href="#none"><img src="<c:url value="/resources/images/adImg.jpg" />" /></a>
                    </p>
                    <p class="title">여름엔 역시 부산이죠?</p>
                    <p class="cont">인스타에서 가장 힙한 카페!</p>
                </li>
            </ul>
            <!-- // AD -->

            <!-- PLAN -->
            <h2 class="title">계획 짜기 힘들었다면? <span class="color">이미 여기 준비되어 있어요!</span></h2>
            
            <ul class="grid grid3 cf">
                <li>
                    <p class="img">
                        <a href="#none"><img src="<c:url value="/resources/images/adImg.jpg" />" /></a>
                    </p>
                    <p class="title">서울</p>
                    <p class="cont">#2박3일 #힐링 #호캉스</p>
                </li>
                <li>
                    <p class="img">
                        <a href="#none"><img src="<c:url value="/resources/images/adImg.jpg" />" /></a>
                    </p>
                    <p class="title">제주</p>
                    <p class="cont">#호캉스 #바다 #여자끼리</p>
                </li>
                <li>
                    <p class="img">
                        <a href="#none"><img src="<c:url value="/resources/images/adImg.jpg" />" /></a>
                    </p>
                    <p class="title">전주</p>
                    <p class="cont">#당일치기 #돼지파티</p>
                </li>
                <li>
                    <p class="img">
                        <a href="#none"><img src="<c:url value="/resources/images/adImg.jpg" />" /></a>
                    </p>
                    <p class="title">전주</p>
                    <p class="cont">#당일치기 #돼지파티</p>
                </li>
                <li>
                    <p class="img">
                        <a href="#none"><img src="<c:url value="/resources/images/adImg.jpg" />" /></a>
                    </p>
                    <p class="title">서울</p>
                    <p class="cont">#2박3일 #힐링 #호캉스</p>
                </li>
                <li>
                    <p class="img">
                        <a href="#none"><img src="<c:url value="/resources/images/adImg.jpg" />" /></a>
                    </p>
                    <p class="title">제주</p>
                    <p class="cont">#호캉스 #바다 #여자끼리</p>
                </li>
            </ul>
            <p class="more colorBtn btn"><a href="#none">MORE PLAN ></a></p>
            <!-- // PLAN -->

        </div><!-- // content end -->
        <!-- month rev include -->        
   		<jsp:include page="common/monthRev.jsp" />
        
        <div id="content">
            
            <!-- review -->
            <h2 class="title"><span class="color">주목해야 할 여행지!</span> 아직도 안 가봤어요?</h2>
            
            <ul class="grid grid3 cf">
                <li>
                    <p class="img">
                  		<a href="#none"><img src="<c:url value="/resources/images/adImg.jpg" />" /></a>
                    </p>
                    <p class="title">서울</p>
                    <p class="cont">#2박3일 #힐링 #호캉스</p>
                </li>
                <li>
                    <p class="img">
                  		<a href="#none"><img src="<c:url value="/resources/images/adImg.jpg" />" /></a>
                    </p>
                    <p class="title">제주</p>
                    <p class="cont">#호캉스 #바다 #여자끼리</p>
                </li>
                <li>
                    <p class="img">
                  		<a href="#none"><img src="<c:url value="/resources/images/adImg.jpg" />" /></a>
                    </p>
                    <p class="title">전주</p>
                    <p class="cont">#당일치기 #돼지파티</p>
                </li>
                <li>
                    <p class="img">
                  		<a href="#none"><img src="<c:url value="/resources/images/adImg.jpg" />" /></a>
                    </p>
                    <p class="title">전주</p>
                    <p class="cont">#당일치기 #돼지파티</p>
                </li>
                <li>
                    <p class="img">
                  		<a href="#none"><img src="<c:url value="/resources/images/adImg.jpg" />" /></a>
                    </p>
                    <p class="title">서울</p>
                    <p class="cont">#2박3일 #힐링 #호캉스</p>
                </li>
                <li>
                    <p class="img">
                  		<a href="#none"><img src="<c:url value="/resources/images/adImg.jpg" />" /></a>
                    </p>
                    <p class="title">제주</p>
                    <p class="cont">#호캉스 #바다 #여자끼리</p>
                </li>
            </ul>
            <p class="more colorBtn btn"><a href="#none">MORE REVIEW ></a></p>
            <!-- // Review -->

        </div><!-- // content end -->
        <div class="chatSec">
            <p class="chatBtn" >
                <a href="javascript:openChat('chat');">지역채팅 바로가기</a>
            </p>
        </div>
    </div><!-- // container end -->
    <script>
    	function openChat(name){
    		var url = "friendList.do";
    		var options = 'top=100, left=300, width=500, height=600, status=no, menubar=no';
    		window.open(url, name, options);
    	}
    </script>
   
   
   
	<!-- 메인 컨텐츠 영역 end -->
   <jsp:include page="common/footer.jsp" />

</body>
</html>

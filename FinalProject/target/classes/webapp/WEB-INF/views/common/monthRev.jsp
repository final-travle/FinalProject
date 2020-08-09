<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

        <div class="rvBg">
            <div class="rvSec">
                <h2 class="title">이달의 리뷰</h2>
                <div class="swiper-container2">
                    <ul class="grid grid3 cf swiper-wrapper">
                        <li class="swiper-slide">
                            <p class="rankFlag">RANK<br/><span>1</span></p>
                            <p class="img">
                      		  <a href="#none"><img src="/FinalProject/resources/images/adImg.jpg"></a>
                            </p>
                            <p class="title">${userName}님의 전주</p>
                            <p class="cont">#당일치기 #돼지파티</p>
                        </li>
                        <li class="swiper-slide">
                            <p class="rankFlag">RANK<br/><span>2</span></p>
                            <p class="img">
                      		  <a href="#none"><img src="/FinalProject/resources/images/adImg.jpg"></a>
                            </p>
                            <p class="title">${userName}님의 서울</p>
                            <p class="cont">#2박3일 #힐링 #호캉스</p>
                        </li>
                        <li class="swiper-slide">
                            <p class="rankFlag">RANK<br/><span>3</span></p>
                            <p class="img">
                      		  <a href="#none"><img src="/FinalProject/resources/images/adImg.jpg"></a>
                            </p>
                            <p class="title">${userName}님의 제주</p>
                            <p class="cont">#호캉스 #바다 #여자끼리</p>
                        </li>
                    </ul>
                </div>
                    <!-- Add Pagination -->
                <div class="swiper-pagination"></div>
                        <!-- Add Arrows -->
                <div class="swiper-button-next"></div>
                <div class="swiper-button-prev"></div>
            
            </div>      <!-- // rvSec end -->
        </div>  <!-- // rvBg end -->
        <script>
            
            // 메인 상위 리뷰 슬라이드
            var swiper = new Swiper('.swiper-container2', {
                slidesPerView: 3,     // 한 페이지에 보여질 이미지 갯수
                spaceBetween: 10,      // 페이지와 페이지 사이의 공백
                loop: true,           // 마지막 장이 끝나면 첫장으로 돌아갈 것인지
                pagination: {
                    clickable: true,            // 드래그로 페이지를 넘길 수 있게 할것인지
                },
                navigation: {
                    nextEl: '.swiper-button-next',
                    prevEl: '.swiper-button-prev',
                },
            });
        </script>

</body>
</html>
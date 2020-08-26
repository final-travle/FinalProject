<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="../common/header.jsp" />

    <div class="compHeader">
        <h2>I REVIEW</h2>
        <p class="compCont">I REVIEW의 REVIEWER들은 항상 코딩만을 생각합니다.<br/>
                            LIFE IS 'IF' / 인생은 if 문이다.
        </p>
        </div>
        <div id="container" class="cf">
            <div id="content">
                <div class="firstSec cf">
                    <div class="imgSec leftImg">
                        <img src="${contextPath }/resources/images/compImg01.jpg"/>
                    </div>
                    <div class="textSec leftText">
                        <h3>I REVIEW HISTORY</h3>
                        <ul>
                            <li><span>2019.12.30~2020.08.28</span> / 우리가 달려온 시간</li>
                            <li><span>2020.07.06~2020.08.27</span> / I REVIEW 를 제작한 기간</li>
                        </ul>
                    </div>                    
                </div>
                <div class="secondSec cf">
                    <div class="imgSec rightImg">
                        <img src="${contextPath }/resources/images/compImg01.jpg"/>
                    </div>
                    <div class="textSec rightText">
                        <h3>REVIEWER?</h3>
                        <ul>
                            <li><span><i class="xi-crown"></i> REVIEWER 조성균</span> / 조장 · 채팅 구현</li>
                            <li><span><i class="xi-emoticon-smiley-o"></i> REVIEWER 조한솔</span> / 회원, 친구 관련 전체 구현</li>
                            <li><span><i class="xi-emoticon-smiley-o"></i> REVIEWER 지정수</span> / 탐색 구현</li>
                            <li><span><i class="xi-emoticon-smiley-o"></i> REVIEWER 양서윤</span> / 디자인 및 플랜, 리뷰 구현</li>
                        </ul>
                    </div>                    
                </div>
            </div>
        </div>
        <script>
            $(document).ready(function(){
                $(".compHeader h2").delay(100).animate({"opacity" : 1});
                $(".compHeader .compCont").delay(600).animate({"opacity" : 1});
            });

            $(window).on("scroll", function(){
                var h = $(document).scrollTop();
                
                if(h >= 100){
                    $(".firstSec .imgSec").animate({"opacity" : "0.8"}, 300);
                    $(".firstSec .textSec").delay(300).animate({"opacity" : "1"}, 300).delay(100).animate({"left": 560});
                }

                if(h >= 600){
                    $(".secondSec .imgSec").animate({"opacity" : "0.8"}, 300);
                    $(".secondSec .textSec").delay(300).animate({"opacity" : "1"}, 300).delay(300).animate({"left": 240});

                }
                
            });
        </script>
<jsp:include page="../common/footer.jsp" />
</body>
</html>
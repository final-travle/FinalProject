<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
	<title>Home</title>
</head>
<style>
	.modal {
            display: none; /* Hidden by default */
            position: fixed; /* Stay in place */
            z-index: 1; /* Sit on top */
            left: 0;
            top: 0;
            width: 100%; /* Full width */
            height: 100%; /* Full height */
            overflow: auto; /* Enable scroll if needed */
            background-color: rgb(0,0,0); /* Fallback color */
            background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
        }
    
        /* Modal Content/Box */
        .modal-content {
        	z-index: 10;
            background-color: #fefefe;
            margin: 7% auto; /* 15% from the top and centered */
            padding: 20px;
            border: 1px solid #888;
            width: 50%; /* Could be more or less, depending on screen size */
            float : left;                          
        }
        /* The Close Button */
        .close {
            color: #aaa;
            float: right;
            font-size: 28px;
            font-weight: bold;
        }
        .close:hover,
        .close:focus {
            color: black;
            text-decoration: none;
            cursor: pointer;
        }
	
	</style>
<body>
<c:set var="contextPath" value="${pageContext.servletContext.contextPath }" scope="application"/>
<jsp:include page="common/header.jsp" />
   <!-- 메인 컨텐츠 영역 start -->
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
            <c:if test="${!empty sessionScope.loginUser}">
            <h2 class="title"><span class="color">${loginUser.nickname }</span> 님만을 위한 추천 포인트!</h2>
            </c:if>
            
            <c:if test="${empty sessionScope.loginUser}">
            <h2 class="title"><span class="color">여긴 어때요?</span> 여행지 추천 드려요!</h2>
            </c:if>
            
            <ul class="grid grid4 cf">
            <c:forEach var="al" items="${al }" end="3">
                <li>
                    <p class="img">
                        <a href="${al.adLink }"><img src="<c:url value='${al.adImg }'/>" /></a>
                    </p>
                    <p class="title"><a href="${al.adLink }">${al.adTitle }</a></p>
                    <p class="cont">${al.adContents }</p>
                </li>
             </c:forEach>
            </ul>
            
            <!-- // AD -->

            <!-- PLAN -->
            <h2 class="title">계획 짜기 힘들었다면? <span class="color">이미 여기 준비되어 있어요!</span></h2>
            <ul class="grid grid3 cf">
            	<c:forEach var="mpl" items="${mpl }" varStatus="status">
					<c:url var="planDetail" value="planDetail.do">
						<c:param name="postNo" value="${mpl.postNo }" />
						<c:param name="postType" value="${mpl.postType }" />
						<c:param name="page" value="${bi.currentPage }" />						
					</c:url>
                <li>
	                    <p class="img">
	                        <a href="${planDetail }"><img src="${mpl.thumbnail }" /></a>
	                    </p>
	                    <p class="title"><a href="${planDetail }">${mpl.title }</a></p>
	                    <!-- p class="userName">${mpl.userId }</p -->
	                    <p class="cont">
	                    	<c:set var="liPostNo" value="${mpl.postNo }" />
	                    	<c:forEach var="pt" items = "${pt }">
		                    	<c:if test = "${pt.postNo eq liPostNo}">
			                    		<c:out value="# ${pt.tagName } " />
		                    	</c:if>
                    		</c:forEach>
                   		</p>
                </li>
                </c:forEach>
            	
            </ul>
            <p class="more colorBtn btn"><a href="planList.do">MORE PLAN ></a></p>
            <!-- // PLAN -->

        </div><!-- // content end -->
        <!-- month rev include -->
   		<jsp:include page="common/monthRev.jsp" />
        
        <div id="content">
            
            <!-- review -->
            <h2 class="title"><span class="color">주목해야 할 여행지!</span> 아직도 안 가봤어요?</h2>
            
            <ul class="grid grid3 cf">
            	<c:forEach var="mrl" items="${mrl }" varStatus="status">
					<c:url var="reviewDetail" value="reviewDetail.do">
						<c:param name="postNo" value="${mrl.postNo }" />
						<c:param name="postType" value="${mrl.postType }" />
						<c:param name="page" value="${bi.currentPage }" />						
					</c:url>
                <li>
	                    <p class="img">
	                        <a href="${reviewDetail }"><img src="${mrl.thumbnail }" /></a>
	                    </p>
	                    <p class="title"><a href="${reviewDetail }">${mrl.title }</a></p>
	                    <!-- p class="userName">${mrl.userId }</p -->
	                    <p class="cont">
	                    	<c:set var="liPostNo" value="${mrl.postNo }" />
	                    	<c:forEach var="pt" items = "${pt }">
		                    	<c:if test = "${pt.postNo eq liPostNo}">
			                    		<c:out value="# ${pt.tagName } " />
		                    	</c:if>
                    		</c:forEach>
                   		</p>
                </li>
                </c:forEach>
            </ul>
            <p class="more colorBtn btn"><a href="reviewListView.do">MORE REVIEW ></a></p>
            <!-- // Review -->

        </div><!-- // content end -->
         <div class="chatSec">
            <p class="chatBtn" >
            	<c:if test="${!empty sessionScope.loginUser }">
                	<a href="javascript:openChat('chat');">지역채팅 바로가기</a>
                </c:if>
                <c:if test="${empty sessionScope.loginUser }">
                	<a href="login.do">지역채팅 바로가기</a>
                </c:if>
            </p>
        </div>
    </div><!-- // container end -->
    <div id="myModal" class="modal">
      <!-- Modal content -->
      <div class="modal-content">
        <span class="close">&times;</span>                                                           
         <a href="${adsel.adLink }"><img src="<c:url value='${adsel.adImg }'/>" /></a>
          <p class="title"><a href="${adsel.adLink }">${adsel.adTitle }</a></p>
                    <p class="cont">${adsel.adContents }</p>            
      </div>
    </div>
    
    <script>
    	function openChat(name){
    		var url = "friendList.do";
    		var options = 'top=20, left=400, width=450, height=650, status=no, menubar=no';
    		window.open(url, name, options);
    	}
    </script>
   
   
   
      <script> 
   $(document).ready(function(){
	   var modal = document.getElementById('myModal');
	   var btn = document.getElementById("myBtn");
	   var span = document.getElementsByClassName("close")[0];                                          
		span.onclick = function() {
           modal.style.display = "none";
       }
		 modal.style.display = "block";
       // When the user clicks anywhere outside of the modal, close it
       window.onclick = function(event) {
           if (event.target == modal) {
               modal.style.display = "none";
           }
       }

	   span.onclick = function() {
           modal.style.display = "none";
       }

   })    	   
        
   </script>    
   
   
   
	<!-- 메인 컨텐츠 영역 end -->
   <jsp:include page="common/footer.jsp" />

</body>
</html>

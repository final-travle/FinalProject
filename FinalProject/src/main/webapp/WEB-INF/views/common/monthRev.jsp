<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${fn:length(brl)}
        <div class="rvBg">
            <div class="rvSec">
                <h2 class="title">이달의 리뷰</h2>
                <div class="swiper-container2">
                    <ul class="grid grid3 cf swiper-wrapper">
                    <c:forEach var="brl" items="${brl }" varStatus="status">
						<c:url var="reviewDetail" value="reviewDetail.do">
							<c:param name="postNo" value="${brl.postNo }" />
							<c:param name="postType" value="${brl.postType }" />
							<c:param name="page" value="${bi.currentPage }" />						
						</c:url>
                        <li class="swiper-slide">
                            <p class="rankFlag">RANK<br/><span>${status.count }</span></p>
                            <p class="img">
                      		  <a href="${reviewDetail }"><img src="${brl.thumbnail }" /></a>
                            </p>
                            <p class="title"><a href="${reviewDetail }">${brl.title }</a></p>
                            <p class="cont">
	                    	<c:set var="liPostNo" value="${brl.postNo }" />
	                    	<c:forEach var="pt" items = "${pt }">
		                    	<c:if test = "${pt.postNo eq liPostNo}">
			                    		<c:out value="# ${pt.tagName } " />
		                    	</c:if>
                    		</c:forEach>
                   		</p>
                        </li>
               		</c:forEach>
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
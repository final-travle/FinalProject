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
            <h2 class="title cont-title"><span class="color">인증된 여행지!</span> 여긴 어때요?</h2>
            
			<p class="piCount">총 개시글 갯수 : ${pi.listCount }</p>
            <ul class="grid grid3 cf">
				<c:forEach var="pl" items="${list }">
					<c:url var="planDetail" value="planDetail.do">
						<c:param name="postNo" value="${pl.postNo }" />
						<c:param name="page" value="${pi.currentPage }" />
					</c:url>
	                <li>
	                    <p class="img">
	                        <a href="${planDetail }"><img src="${pl.thumbnail }" /></a>
	                    </p>
	                    <p class="title">${pl.title }</p>
	                    <p>${pl.userId }</p>
	                    <p class="cont">
	                    	<c:set var="liPostNo" value="${pl.postNo }" />
	                    	<c:forEach var="tl" items = "${tl }">
		                    	<c:if test = "${tl.postNo eq liPostNo}">
			                    		<c:out value="# ${tl.tagName } " />
		                    	</c:if>
                    		</c:forEach>
	                    
	                    
	                    </p>
	                </li>
                </c:forEach>
               </ul>             
            <c:if test="${!empty sessionScope.loginUser}">
            <div class="insertBtns cf">
                <a href="reviewInsertView.do" class="insert colorBtn btn">글쓰기</a>
            </div>
            </c:if>

            <div class="pagination">
				<!-- [prev] -->
				<c:if test="${pi.currentPage eq 1 }">
					[prev] 
				</c:if>
				
				<c:if test="${pi.currentPage gt 1 }">
					<c:url var="blistBack" value="planList.do">
						<c:param name="page" value="${pi.currentPage - 1 }" />
					</c:url>
					<a href="${blistBack }">[prev] </a>
				</c:if>
				
				<!-- [pagination] -->
				<c:forEach var="p" begin="${pi.startPage }" end="${pi.endPage }">
					<c:if test="${p eq pi.currentPage }">
						<b>[${p }]</b>
					</c:if>
					
					<c:if test="${p ne pi.currentPage }">
						<c:url var="blistCheck" value="planList.do">
							<c:param name="page" value="${p }"/>
						</c:url>
						<a href="${blistCheck }">${p }</a>
					</c:if>
				</c:forEach>
				
				
				<!-- [next] -->
				<c:if test="${pi.currentPage eq pi.maxPage }">
					 [next]
				</c:if>
				
				<c:if test="${pi.currentPage lt pi.maxPage }">
					<c:url var="blistEnd" value="planList.do">
						<c:param name="page" value="${pi.currentPage + 1 }" />
					</c:url>
					<a href="${blistEnd }"> [next]</a>
				</c:if>	
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
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.snip1368 { position:relative; width:440px; height:320px; overflow:hidden; }
	.snip13 { position:absolute; top:0; bottom:0; width:100%; height:100%; background:rgba(0,0,0,.7); display:none; }
	.snip1368:hover .snip13 { display:block; transition: 0.3s;}
	.snip13 .icon:after { display:block; content:""; clear:both;  }
	.snip13 a { display:inline-block; width:50%; box-sizing:border-box;  float:left; height:160px; line-height:160px; text-align:center; color:#fff; text-decoration:none; }
</style>
</head>
<body>
<jsp:include page="../common/header.jsp" />

    <div id="container" class="cf">
        <div id="content">
            
            <!-- plan -->
       <ul class="grid grid3 cf">
				<c:forEach var="pl" items="${list }">
					<c:url var="memberplanListShared" value="memberplanListShared.do"> <!-- 이게 공유라고 가정하고 쿼리스트링 써야됨  -->
						<c:param name="postNo" value="${pl.postNo }" />
						<c:param name="postType" value="${pl.postType }" />
					</c:url>
					<c:url var="planDetail" value="planDetail.do">
						<c:param name="postNo" value="${pl.postNo }" />
						<c:param name="page" value="${pi.currentPage }" />
					</c:url>
	                <li>
	                <div class="snip1368">
	                    <img src="${pl.thumbnail }"/>
	                        <div class="snip13">
			                    <div class="icons">
				                    <a href="#" onclick="window.open('${memberplanListShared }','_blank','width=600, height=800'); return flase">공유</a>
			      					<a href="#"> <i class="ion-social-two-outline">삭제</i></a>
								    <a href="#"> <i class="ion-social-three-outline">수정</i></a>
								    <a href="${planDetail }"> <i class="ion-social-four-outline">글보기</i></a>
			                    </div>
			                 </div>   
	                    </div>
	                    <p class="img">
	                        
	                    </p>
	                    <p class="title">${pl.title }</p>
	                    <p>${pl.userId }</p>
	                    <p class="cont">
	                    	<c:set var="liPostNo" value="${pl.postNo }" />
	                    	<c:forEach var="tl" items = "${tl }">
		                    	<c:if test = "${tl.postNo eq liPostNo}">
			                    		<c:out value=" ${tl.tagName } " />
		                    	</c:if>
                    		</c:forEach>
	                    
	                    
	                    </p>
	                </li>
                </c:forEach>
               </ul>             
          

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
            <!-- // plan -->

        </div><!-- // content end -->
    </div><!-- // container end -->

<jsp:include page="../common/footer.jsp" />

</body>
</html>
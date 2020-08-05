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
        <div class="titleSec" style="background:url('${board.thumbnail }' )no-repeat 0 20%;  background-size:cover;">
            <p class="planTitle">${board.title }</p>
            <p class="ltSec">
                <span class="likes"><i class="xi-heart-o"></i> 0</span>
                <span class="voting"><i class="xi-star-o"></i> 300</span>
            </p>
            <div class="cover"></div>
        </div>
        <div class="wrap cf">
            <div class="leftSelBox">
                <div class="bottSel">
                    <h3>전체 일정 루트</h3>
                    <ul class="dayNight list">
	                    <c:forEach var="i" begin="0" end="${dayNum }">
						<li>
						<p class="tit">DAY ${i + 1 }</p>
                            <ul class="spot">
							<c:forEach var="tv" items="${travel }">
		                    	<c:set var="night" value="${tv.night }" />
								<c:if test="${i eq night }">
		                                <li>${tv.tName }</li>
								</c:if>
		                    </c:forEach> 
                            </ul>
                        </li>
						</c:forEach>
                    </ul>
                </div><!-- bottSel -->
            </div><!-- // leftSelBox -->
            <div class="rightMapBox">
            
            </div><!-- // rightMapBox -->
            
        </div><!-- // wrap end -->
    </div><!-- // container end -->
<jsp:include page="../common/footer.jsp" />
</body>
</html>
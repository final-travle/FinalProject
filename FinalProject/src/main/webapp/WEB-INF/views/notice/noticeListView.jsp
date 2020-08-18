<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 글 목록</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<style>

* {
    margin: 0;
    padding: 0;
}

a {
    text-decoration: none;
    color: inherit;

}



.board_list_wrap {
    padding: 50px;
}

.board_list_head,
.board_list_body .item {
    padding: 10px 0;
    font-size: 0;
}

.board_list_head {
    border-top: 2px solid gray;
    border-bottom: 1px solid #ccc;
}

.board_list_body .item {
    border-bottom: 1px solid #ccc;
}

.board_list_head > div,
.board_list_body .item > div {
    display: inline-block;
    text-align: center;
    font-size: 14px;
}

.board_list_head > div {
    font-weight: 600;
}

.board_list .num {
    width: 10%;
}

.board_list .title {
    width: 50%;
}

.board_list_body div.title {
    text-align: left;
}

.board_list_body div.title a:hover {
    text-decoration: underline;
}

.board_list .writer {
    width: 10%;
}

.board_list .date {
    width: 15%;
}

.board_list .view {
    width: 10%;
}

</style>
</head>
<body>
	<jsp:include page="../common/header.jsp"/>
	
	<br><br>
	<h2 align="center">공지사항</h2>
	

		
	 <div class="board_list_wrap">
            <div class="board_list">
                <div class="board_list_head">
                    <div class="num">번호</div>
                    <div class="title">제목</div>
                    <div class="writer">글쓴이</div>
                    <div class="date">작성일</div>
                    <div class="view">조회수</div>
                    <div class="file">첨부파일</div>
                </div>

              
			
			<c:forEach var="n" items="${list }">				           
                <div class="board_list_head">
                    <div class="num">${n.postNo}</div>
                   <div class="title">
                   		<c:url var="ndetail" value="ndetail.do">
                   			<c:param name="postNo" value="${n.postNo }"/>
                   			<c:param name="page" value="${currentPage }"/>
                   		</c:url>
                   	 <a href="${ndetail }">${n.title }</a>
                   </div>
                    <div class="writer">${n.userId}</div>
                    <div class="date">${n.writeDate}</div>
                    <div class="view">${n.hits}</div>
                    <div class="file">
                    	<c:if test="${!empty n.fileName }">
                    			★
                    	</c:if>
                    	<c:if test="${empty n.fileName }">
                    		&nbsp;
                    	</c:if>
                    </div>
                </div>

			</c:forEach>
		
			<br>
				<form align="center" method="get" name="listForm" action="nlist.do">
	 				<input type="hidden" name="page" value="${currentPage }">
	 				<input name="keyword" value="${keyword}">
	 				<input type="submit" value="검색">
	 			</form>
	 			
	 			<div align = "right">
	 				<c:if test="${loginUser.id eq 'master'}">
						<button onclick="location.href='nWriterView.do'">글쓰기</button>
					</c:if>
					<c:if test="${loginUser.id ne 'master' }">						
					</c:if>
				</div>
			<br>	
				 
	 <br>
	<!-- 페이징 처리 부분 -->
	<table align="center" cellspacing="0" width="500" id="td">
	
		<tr align="center" height="10">
			<td colspan="5">
			<!-- [이전] -->
			<c:if test="${currentPage <= 1 }">
				[이전]&nbsp;
			</c:if>
			
			<c:if test="${currentPage > 1 }">
				<c:url var="nlistBack" value="nlist.do">
					<c:param name="page" value="${currentPage-1 }"/>
				</c:url>
				<a href="${nlistBack }">[이전]</a>
			</c:if>
			
			<!-- [번호들] -->
		  <c:set var="endPage" value="${maxPage }"/>
			<c:forEach var="p" begin="${startPage + 1}" end="${endPage }">
				<c:if test="${p eq currentPage }">
					<font color="blue" size="4"><b>[${p }]</b></font>
				</c:if>
				
				<c:if test="${p ne currentPage }">
					<c:url var="nlistCheck" value="nlist.do">
						<c:param name="page" value="${p }"/>
					</c:url>
					<a href="${nlistCheck }">${p }</a>
				</c:if>
			</c:forEach>
			
			
			<!-- [다음] -->			
			<c:if test="${currentPage >= maxPage }">
				[다음]
			</c:if>
			
			<c:if test="${currentPage < maxPage }">
				<c:url var="nlistEnd" value="nlist.do">
					<c:param name="page" value="${currentPage + 1 }"/>
				</c:url>
				<a href="${nlistEnd }">[다음]</a>
			</c:if>
			
		</td>
	</tr>
	</table>	
			
			<br><br>
			
			 
			
              
		
          </div>
      </div> 
        
             
    		<br>			
			<br>
			      
       	<p align="center">
			<c:url var="home" value="home.do"/>
			<a href="${home }">메인 페이지로 이동</a>&nbsp;
			<c:url var="nlist" value="nlist.do"/>
			<a href="${nlist }">목록 전체 보기</a>
		</p>
		<br><br>
</body>
</html>
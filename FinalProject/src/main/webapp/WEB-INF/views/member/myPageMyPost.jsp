<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#memberinfo{
width : 100%;
height : 150px;
text-align: center;
}
#memberinfo h1{
margin : 10px;
}
#memberinfo h2{
margin : 10px  10px 20px 10px;
}
#menubutton{
width: 50px;
height:50px;
font-size : 14px;
text-align:center;
margin:0;
padding: 0;
line-height:50px;
border:0;
background:#bd9dec;
border:1px solid #bd9dec;
position: absolute;
top:-50px;
left: 0;
color:#fff;
}

#mySidenav{
font-size :xx-large;
width: 200px;
height:435px;
position: fixed;
bottom : 0px;
right: 75px;
color :black;
border: 1px solid #ddd;
transition : .2s ease-in;
z-index : 100;
}

#mySidenav.on {
bottom:-435px;
}

p{
text-align: center;
}

.menuSide { background:#fff; }

.menuSide p a:before,
.menuSide  p a:after {
  content: '';
  border-bottom: solid 1px black;
  position: absolute;
  width: 0;
}


.menuSide p a { position:relative; }

.menuSide p a:before { left: 0; bottom:-4px; }
.menuSide p a:after { right: 0; bottom:-4px; }

.menuSide  p a:hover:before,
.menuSide  p a:hover:after {
  width: 50%;
}
.menuSide  p a:before, .menuSide p a:after {
  -webkit-transition: all 0.2s ease;
          transition: all 0.2s ease;
}


	.snip1368 {position:relative; overflow:hidden; }
	.snip13 { -webkit-transition: 0.2s; position:absolute; top:0; bottom:0; width:100%; height:100%; background:rgba(0,0,0,.7); display:none; }
	.snip1368:hover .snip13 { display:block; }
	.snip13 .icon:after { display:block; content:""; clear:both;  }
	.snip13 a {  display:inline-block; width:50%; box-sizing:border-box;  float:left; height:160px; line-height:160px; text-align:center; color:#fff; text-decoration:none; }
	.snip131 .icon1:after { display:block; content:""; clear:both;  }
	.snip131 a {  display:inline-block; width:50%; box-sizing:border-box;  float:left;  height:100%; line-height:160px; text-align:center; color:#fff; text-decoration:none; }
	
	
</style>
</head>
<body>
<jsp:include page="../common/header.jsp" />
<div id="memberinfo">
<h1><span style="color: orange;"> ${loginUser.name }</span>님 어서오세요<br></h1>
<h2>친구 : <span style="color: orange;">${fCount}</span>명<br>
글 수 <span style="color: orange;"> ${pCount}</span>개</h2>
<h1 style="text-align: center; font-style : oblique;">MY POST</h1>
<hr>
</div>
   <br><br><br>
   <div id="mySidenav">
   <button id="menubutton"><i class="xi-angle-down"></i></button>
<div class="menuSide">
		   	<p>
		   		<a href="memberplanList.do">내 가 쓴 글</a>
		   	</p>
		</div>
	   <div class="menuSide"><p> <a href="mypageSharedme.do">내게 공유된 글</a></p></div>
	    <div class="menuSide"><p><a href="memberChange.do">내 정보 수정</a></p></div>
	    <div class="menuSide"><p><a href="friends.do">친구정보</a></p></div>
	    <div class="menuSide"><p><a href="friendsadd.do">친구추가</a></p></div>
	    <div class="menuSide"><p><a href="accfriends.do">친구수락</a></p></div>
	    <div class="menuSide"><p><a href="mypageDelete.do">회원탈퇴</a></p></div>
	    <c:if test="${sessionScope.loginUser.id eq 'master'}">
	    <div class="menuSide"><p><a href="adminMember.do">회원관리</a></p></div>
	    <div class="menuSide"><p><a href="#">회원 글 관리</a></p></div>
   </c:if>
    </div>

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
						<c:param name="postType" value="${pl.postType }" />
						<c:param name="page" value="${pi.currentPage }" />
					</c:url>
					planModifyForm.do
					
					<c:url var="planModifyForm" value="planModifyForm.do">
						<c:param name="postNo" value="${pl.postNo }" />
						<c:param name="postType" value="${pl.postType }" />
						<c:param name="page" value="${pi.currentPage }" />
					</c:url>
					
					<c:url var="planDelete" value="myplanDelete2.do">
						<c:param name="postNo" value="${pl.postNo }" />
						<c:param name="postType" value="${pl.postType }" />
						<c:param name="page" value="${pi.currentPage }" />
					</c:url>
					
					
					
					
	                <li>
	                <c:if test="${pl.postType eq 3 }">
	                <div class="snip1368">
	                    <img src="${pl.thumbnail }"/>
	                        <div class="snip13">
			                    <div class="icons">
				                    <a href="#" onclick="window.open('${memberplanListShared }','_blank','width=600, height=600'); return flase">공유</a>
			      					<a href="${planDelete }"> <i class="ion-social-two-outline">삭제</i></a>
								    <a href="${planModifyForm}"> <i class="ion-social-three-outline">수정</i></a>
								    <a href="${planDetail }"> <i class="ion-social-four-outline">글보기</i></a>
			                    </div>
			                 </div>
	                    </div>
	                 </c:if>   
	                 
	                 <c:url var="reviewDetail" value="reviewDetail.do">
						<c:param name="postNo" value="${pl.postNo }" />
						<c:param name="postType" value="${pl.postType }" />
						<c:param name="page" value="${pi.currentPage }" />
					</c:url>
					
					
					<c:url var="reviewDelete" value="myreviewListDelete2.do">
						<c:param name="postNo" value="${pl.postNo }" />
						<c:param name="postType" value="${pl.postType }" />
						<c:param name="page" value="${pi.currentPage }" />
					</c:url>
	                 <c:if test="${pl.postType ne 3 }">
	                    <div class="snip1368">
	                    <img src="${pl.thumbnail }"/>
	                        <div class="snip13">
			                    <div class="icons">
			      					<a href="${reviewDelete }"> <i class="ion-social-two-outline">삭제</i></a>		   
								    <a href="${reviewDetail }"> <i class="ion-social-four-outline">글보기</i></a>
			                    </div>
			                 </div>
	                    </div>
					</c:if>
	                    <p class="title">${pl.title }</p>
	                    <p>${pl.userId }</p>
	                    <p class="cont">
	                 
						<c:choose>
							<c:when test="${pl.postType ne 3}"><c:out value="리뷰" /><br></c:when>							
							<c:when test="${pl.postType eq 3}"><c:out value="플랜 " /><br></c:when>						
						</c:choose>
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
					<c:url var="blistBack" value="memberplanList.do">
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
						<c:url var="blistCheck" value="memberplanList.do">
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
					<c:url var="blistEnd" value="memberplanList.do">
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
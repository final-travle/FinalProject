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

</style>

</head>
<body>
<jsp:include page="../common/header.jsp" />


<div id="memberinfo">
<h1><span style="color: orange;"> ${loginUser.name }</span>님 어서오세요<br></h1>
<h2>친구 : <span style="color: orange;">${fCount}</span>명<br>
글 수 <span style="color: orange;"> ${pCount}</span>개<br>
공유 글 수 <span style="color: orange;"> ${sCount} </span>개 </h2>
<h1 style="text-align: center; font-style : oblique;">SHARED POSTS</h1>
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
	    <div class="menuSide"><p><a href="accfriends.do">친구수락(<span style="color: red;">${ accCount}</span>)</a></p></div>
	    <div class="menuSide"><p><a href="mypageDelete.do">회원탈퇴</a></p></div>
	    <c:if test="${sessionScope.loginUser.id ne 'master'}">
	    <div class="menuSide"><p><a href="planList.do">플랜</a></p></div>
	    <div class="menuSide"><p><a href="reviewListView.do">리뷰</a></p></div>
   </c:if>
	    <c:if test="${sessionScope.loginUser.id eq 'master'}">
	    <div class="menuSide"><p><a href="adminMember.do">회원관리</a></p></div>
	    <div class="menuSide"><p><a href="adminPostmanager.do">회원 글 관리</a></p></div>
   </c:if>
    </div>



    <div id="container" class="cf">
        <div id="content">
            
            <!-- plan -->
       <ul class="grid grid3 cf">
       <c:if test="${empty list }">
            <h1 style="text-align: center; font-style : oblique;" > 글이 없습니다.</h1>
            </c:if>
				<c:forEach var="pl" items="${list }">
					<c:url var="planDetail" value="planDetail.do">
						<c:param name="postNo" value="${pl.postNo }" />
						<c:param name="postType" value="${pl.postType }" />
						<c:param name="page" value="${pi.currentPage }" />
					</c:url>
					
					<c:url var="memberSharedDelete" value="memberSharedDelete.do">
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
	                    <a href="${memberSharedDelete }">공유끊기</a><br>
	                    	<c:set var="liPostNo" value="${pl.postNo }" />
	                    	<c:forEach var="tl" items = "${tl }">
		                    	<c:if test = "${tl.postNo eq liPostNo}">
			                    		#<c:out value=" ${tl.tagName } " />
		                    	</c:if>
                    		</c:forEach>
	                    
	                    
	                    </p>
	                </li>
                </c:forEach>
               </ul>             

<jsp:include page="../common/footer.jsp" />

<script>
$(document).ready(function(){
/*     $("#menubutton").click(function(){
        $("#mySidenav").slideToggle();
    }); */
    
    $("#menubutton").on("click", function(){
    	$mySidenav = $("#mySidenav").attr("class");
    	console.log($mySidenav);
    	if($mySidenav == "on"){
    		$("#mySidenav").removeClass("on");
    		$(this).find("i").attr("class", "xi-angle-down");
    	}else {
    		$("#mySidenav").addClass("on");
    		$(this).find("i").attr("class", "xi-angle-up");
    	}
    	
    });
    
    
});
</script>

</body>
</html>
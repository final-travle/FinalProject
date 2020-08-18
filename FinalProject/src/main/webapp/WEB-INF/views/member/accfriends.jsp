<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <title></title>
   
   
<style>
body {font-family: "Lato", sans-serif;}
#h{right: 250px;}
#friendsbody{width: 850px;margin: 0 auto; }
#noticelistArea{    margin: 10px;
                padding:0;
                width: 800px;
                border-top: 1px solid #444444;
                border-collapse: collapse;
            }
#friendsbodyInfo tr {
	line-height:2.6;
	border-bottom:1px solid #ddd;
}

#sye{border-radius: 5px;height: 30px; width: 280px;}

#friendsbodyInfo {
width:100%;
}

#friendsbodyInfo tr {
	line-height:2.6;
	border-bottom:1px solid #ddd;
}
input[type=text]{
height: 36px;
 width: 200px;
}
.ltd {border-bottom: 1px solid #444444;padding: 10px;}
#lab{background-color:white;color: black;text-align: center;padding: 10px;   }
#inp{padding: 10px;padding-left: 110px; padding-right: 100px;}
tr td input{border-radius: 5px;height: 30px;width: 280px;}
#sye{border-radius: 5px;height: 30px; width: 280px;}
#checkAll{zoom: 2.0;}
div select{height: 30px;border-radius: 5px;width: 80px;float: left;margin-left: 3px ;}
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


<body>
<jsp:include page="../common/header.jsp" />

<div id="memberinfo">
<h1><span style="color: orange;"> ${loginUser.name }</span>님 어서오세요<br></h1>
<h2>친구 : <span style="color: orange;">${fCount}</span>명<br>
글 수 <span style="color: orange;"> ${pCount}</span>개</h2>
<h1 style="text-align: center; font-style : oblique;">ACCEPT FRIENDS</h1>
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
	<div id="friendsbody">   
    <form method="post" action="friendsadd2.do">
		<div id="friendsbodyInfo">
            <table id="noticelistArea" align="center" width="800" border="1">
                    <tr bgcolor="#bd9dec">
                        <th>ID</th> <th>이름</th> <th>닉네임</th> <th>수락</th> <th>거절</th>
                    </tr>
			  <c:if test="${empty falll }">
            <tr>
            <td style="text-align : center;" colspan="5"> <p style="text-align: center;">리스트가없습니다</p></td>
            </tr>
            </c:if>
            <c:if test="${not empty falll}">          
            <c:forEach var="n" items="${falll }">
            <c:set var="Y" value="Y" />
         <tr>
         <td align="center">${n.id }</td>
            <td align="center">${n.name }</td>
            <td align="center">${n.nickname }</td>
					<c:url value="accfriends.do" var="url">
					  <c:param name="id" value="${n.id }" />
					</c:url>
					<c:url value="dltaccfriends.do" var="urldt">
					  <c:param name="id" value="${n.id }" />
					</c:url>
					<td>
		            <a href="${url}">승낙하기</a></td>
		            <td><a href="${urldt}">거절하기</a></td>
        </tr>   
      </c:forEach>
                </c:if>   
            </table>
            </div>
     </form> 
 </div>
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
  <jsp:include page="../common/footer.jsp" />
</body>
</html>
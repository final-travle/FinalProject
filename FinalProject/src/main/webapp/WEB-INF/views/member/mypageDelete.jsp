<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<style>
body {font-family: "Lato", sans-serif; padding-bottom:10px;}
#h{right: 250px;}
.ltd {border-bottom: 1px solid #444444;padding: 10px;}
#lab{background-color:white;color: black;text-align: center;padding: 10px;   }
#inp{padding: 10px;padding-left: 110px; padding-right: 100px;}
tr td input{border-radius: 5px;height: 30px;width: 280px;}
#sye{border-radius: 5px;height: 30px; width: 280px;}
#checkAll{zoom: 2.0;}
div select{height: 30px;border-radius: 5px;width: 80px;float: left;margin-left: 3px ;}
#h2{margin-left: 20px;text-align: center;}
#h3{float: left;margin-left: 20px;}
#hh5{float:right;margin-bottom: 0;color: lightgray;}
#agr{margin-left: 20px;}
.text{float: right;}

.container {width: 100%;height: 140px;overflow: auto;border: 1px solid black;border-radius: 10px;}
.container::-webkit-scrollbar {width: 10px;}
.container::-webkit-scrollbar-thumb {background-color: #2f3542;border-radius: 10px;background-clip: padding-box;border: 2px solid transparent}
.container::-webkit-scrollbar-track {background-color: grey;border-radius: 10px;box-shadow: inset 0px 0px 5px white;}
input::-webkit-input-placeholder { color: lightgray; }
input[type=radio] {width:              150px;height:             20px;}
.myPageBox { margin: 0 auto; width:80%; } 

#sye{border-radius: 5px;height: 30px;width: 280px;}
@media screen and (max-height: 450px) {.sidenav {padding-top: 15px;}.sidenav a {font-size: 18px;}}
#friendsbody{  width: 850px;  margin: 0 auto;  color: red;  }
#firendsIdSearch{
	margin:20px auto;
	float : left;
}
p{
text-align: center;
}

#friendsbodyInfo {
width:100%;
margin-bottom: 15px;
}


#friendsbodyInfo tr {
	line-height:2.6;
	border-bottom:1px solid #ddd;
}
#friendsbodyInfo td { 
 }

#paging {
	margin:20px 0 20px;
}

input[type=text]{
height: 36px;
 width: 200px;
}

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

#logintable{margin: 10px;padding:0;  width:100%; margin: 0 auto; padding:10px 0; }
#logintable span { display:inline-block; margin-right:20px; }
#logintable li {  display:inline-block; list-style:none; padding:10px 0; }
#logintable li input { width:540px; }
#friendstable{
                margin: 10px;
                padding:0;
                width: 800px;
                border-top: 1px solid #444444;
                border-collapse: collapse;
            }

</style>

<body>
<jsp:include page="../common/header.jsp" />


<div id="memberinfo">
<h1><span style="color: orange;"> ${loginUser.name }</span>님 어서오세요<br></h1>
<h2>친구 : <span style="color: orange;">${fCount}</span>명<br>
글 수 <span style="color: orange;"> ${pCount} </span>개<br>
공유 글 수 <span style="color: orange;"> ${sCount} </span>개 </h2>
<h1 style="text-align: center; font-style : oblique;">DELETE FRIENDS</h1>
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
	    <c:if test="${sessionScope.loginUser.id ne 'master'}">
	    <div class="menuSide"><p><a href="planList.do">플랜</a></p></div>
	    <div class="menuSide"><p><a href="reviewListView.do">리뷰</a></p></div>
   </c:if>
	    <c:if test="${sessionScope.loginUser.id eq 'master'}">
	    <div class="menuSide"><p><a href="adminMember.do">회원관리</a></p></div>
	    <div class="menuSide"><p><a href="adminPostmanager.do">회원 글 관리</a></p></div>
   </c:if>
    </div>

	<div id="friendsbody">
		<div id="friendsbodyInfo">
		  <h3 style="color: red;">탈퇴시 유의사항</h3>
		  1. 탈퇴하시면 지금까지 작성하신 여행계획에 단 댓글은 자동으로 삭제됩니다.<br>
		  2. 작성하신 여행계획은 탈퇴전에 직접<a href="memberplanList.do">[내여행리스트]</a> 에서 삭제해주시기 바랍니다.삭제방법은 각 여행플래너에서 상단<br>
		  제목 우측에 삭제버튼을 누르시면 됩니다.<br>
		  3. 쓰는 글들과 댓글은 자동으로 삭제되지 않으므로 직접 삭제해주시기 바랍니다.<br>
		  4. 여행정보와 현지교통과 관련해 집필하신 지식글들은 자동으로 삭제되지 않습니다.<br>
	  
	  <form method="post" action="dltmember.do">
	  	<ul id="logintable">
	  		<li><span  style="color: black;">비밀번호 : </span><input type="text" id="userPwd" name="pwd" required=""></li>
	  		<li><button type="submit" id="idCheck" class="colorBtn btn"  style="width: 70px; background: darkgrey; color: white;">제출</button></li>
	  	</ul>
	</form>
 </div>
 </div>	
	
	
	
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
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<style>

.myPageWrap { width:1200px; margin:0 auto; }

.myPageNot { padding-bottom:20px; }
.myPageNot p { padding:0; margin:0; line-height:1.6; }
#myPageHeader { border-top:1px solid #666; border-bottom:1px solid #666; }
body {font-family: "Lato", sans-serif; padding-bottom:10px;}
#h{right: 250px;}
.sidenav {height: 150;width: 100;position: fixed;z-index: 0;top: 150; left: 0;right: 10;
			overflow-x: hidden;transition: 0.5s;padding-top: 60px;margin-right:20px ;}
.sidenav a {padding: 8px 8px 8px 32px;text-decoration: none; font-size: 25px;
    color: #818181;display: block;transition: 0.3s;}
#joinForm{width: 850px;margin: 0 auto;}
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
#logintable{margin: 10px;padding:0; border-top: 1px solid #444; border-bottom: 1px solid #444; width:100%; margin: 0 auto;padding:10px 0; }
#logintable span { display:inline-block; margin-right:20px; }
#logintable li { text-align:center; list-style:none; padding:10px 0; }
#logintable li input { width:260px; }
.myPageBox { margin: 0 auto; width:80%; } 
tr td input{border-radius: 5px;height: 30px;width: 500px;}
#sye{border-radius: 5px;height: 30px;width: 280px;}
.sidenav a:hover {color: #f1f1f1;}
.sidenav .closebtn {position: absolute;top: 0;right: 25px;font-size: 36px;margin-left: 50px;}
@media screen and (max-height: 450px) {.sidenav {padding-top: 15px;}.sidenav a {font-size: 18px;}}
</style>

<body>
<div class="myPageWrap">
	<div id="myPageHeader">
	<h1><span style="color: orange;"> ${loginUser.name }</span>님 어서오세요<br></h1>
	<h2>친구 : <span style="color: orange;"> ${fCount}</span>명<br>
	글 수 <span style="color: orange;"> 15</span>개</h2>
	</div>
	   <br><br><br>
	   <div id="mySidenav" class="sidenav">
	    <hr>
	    
	    <a href="#">내 가 쓴 글</a>
	    <a href="#">내가 좋아한 글</a>
	    <a href="memberChange.do">내 정보 수정</a>
	    <a href="friends.do">친구정보</a>
	    <a href="friendsadd.do">친구추가</a>
	    <a href="accfriends.do">친구수락</a>
	    <a href="#">회원탈퇴</a>
	    <hr>
	  </div>
	   <div class="myPageBox">
		<div class="myPageNot">
		  <h3 style="color: red;">탈퇴시 유의사항</h3>
		  <p style="color: red;">1. 탈퇴하시면 지금까지 작성하신 여행계획에 단 댓글은 자동으로 삭제됩니다.</p>
		  <p style="color: red;">2. 작성하신 여행계획은 탈퇴전에 직접<a href="#">[내여행리스트]</a> 에서 삭제해주시기 바랍니다.삭제방법은 각 여행플래너에서 상단</p>
		  <p style="color: red;">제목 우측에 삭제버튼을 누르시면 됩니다.</p>
		  <p style="color: red;">3. 쓰는 글들과 댓글은 자동으로 삭제되지 않으므로 직접 삭제해주시기 바랍니다.</p>
		  <p style="color: red;">4. 여행정보와 현지교통과 관련해 집필하신 지식글들은 자동으로 삭제되지 않습니다.</p>
	  </div>
	  <form method="post" action="dltmember.do">
	  	<ul id="logintable">
	  		<li>비밀번호<span style="color: orange;">*</span><input type="text" id="userPwd" name="pwd" required=""></li>
	  		<li><button type="submit" id="idCheck"  style="width: 70px; background: darkgrey; color: white;">제출</button></li>
	  	</ul>
	</form>
	<!-- <span style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776; open</span> -->
	
	<!-- <script>
	    function openNav() {
	        document.getElementById("mySidenav").style.width = "250px";
	    }
	    
	    function closeNav() {
	        document.getElementById("mySidenav").style.width = "0";
	    }
	    </script> -->
	</div>
</div>	
	
	
	



</body>
</html>
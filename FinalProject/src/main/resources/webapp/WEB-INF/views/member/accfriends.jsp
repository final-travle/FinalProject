<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <title></title>
   
   
<style>
#memberinfo{width: 4000px;}
body {font-family: "Lato", sans-serif;}
#h{right: 250px;}
.sidenav {height: 150;width: 100;position: fixed;z-index: 0;top: 150; left: 0;right: 10;
			overflow-x: hidden;transition: 0.5s;padding-top: 60px;margin-right:20px ;}
.sidenav a {padding: 8px 8px 8px 32px;text-decoration: none; font-size: 25px;
    color: #818181;display: block;transition: 0.3s;}
#joinForm{width: 850px;margin: 0 auto;}
#logintable{margin: 10px;padding:0;width: 700px;border-top: 1px solid #444444;border-collapse: collapse;}
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
#logintable{    margin: 0 auto;padding:0;width: 750px;border-top: 1px solid #444444;border-collapse: collapse;}
tr td input{border-radius: 5px;height: 30px;width: 280px;}
#sye{border-radius: 5px;height: 30px;width: 280px;}
.sidenav a:hover {color: #f1f1f1;}
.sidenav .closebtn {position: absolute;top: 0;right: 25px;font-size: 36px;margin-left: 50px;}
@media screen and (max-height: 450px) {.sidenav {padding-top: 15px;}.sidenav a {font-size: 18px;}}
</style>


<body>
<div id="memberinfo">
<hr>
<h1><span style="color: orange;"> ${loginUser.name }</span>님 어서오세요<br></h1>
<h2>친구 : <span style="color: orange;">${fCount}</span>명<br>
글 수 <span style="color: orange;"> 15</span>개</h2>
<hr>
</div>
   <br><br><br>
   <div id="mySidenav" class="sidenav">
    <c:if test="${sessionScope.loginUser.id eq 'master'}">
    <hr>
    <a href="memberplanList.do">내 가 쓴 글</a>
    <a href="mypageSharedme.do">내게 공유된 글</a>
    <a href="memberChange.do">내 정보 수정</a>
    <a href="friends.do">친구정보</a>
    <a href="friendsadd.do">친구추가</a>
    <a href="accfriends.do">친구수락</a>
    <a href="mypageDelete.do">회원탈퇴</a>
    <a href="adminMember.do">회원관리</a>
    <a href="#">회원 글 관리</a>
    <hr>
    </c:if>
    </div>
    <div id="mySidenav" class="sidenav">
    <c:if test="${ sessionScope.loginUser.id ne 'master'}">
    <hr>
    <a href="memberplanList.do">내 가 쓴 글</a>
    <a href="mypageSharedme.do">내게 공유된 글</a>
    <a href="memberChange.do">내 정보 수정</a>
    <a href="friends.do">친구정보</a>
    <a href="friendsadd.do">친구추가</a>
    <a href="accfriends.do">친구수락</a>
    <a href="mypageDelete.do">회원탈퇴</a>
    <hr>
    </c:if>
  </div>

    <form method="post" action="membersearchId.do">
    <select name="search">
    <option value="">직업선택</option>
    <option value="name">이름</option>
    <option value="nicname">별명</option>
    <option value="sex">성별</option>
    <option value="birth">생년월일</option>
</select>
            <input type="text" id="search" name="noticeSearch"  placeholder="검색어를 입력해주세요"> <input type="submit" id="searchBtn" value="SEARCH">
            
            
            <table id="noticelistArea" align="center" width="600" border="1">
                    <tr>
                        <th>NO</th> <th>제목</th> <th>작성자</th> <th>날짜</th> <th>친구추가</th>
                    </tr>

			  <c:if test="${empty falll }">
            <tr>
            
            <td>리스트가없습니다</td>
            </tr>
            </c:if>
            <c:if test="${not empty falll}">          
            <c:forEach var="n" items="${falll }">
           
            <c:set var="Y" value="Y" />
           
         <tr>
         <td align="center">${n.userId }</td>
            <td align="center">${n.fId }</td>
	            
	            
					
					
					<c:url value="accfriends.do" var="url">
					  <c:param name="id" value="${n.userId }" />
					</c:url>
					<c:url value="dltaccfriends.do" var="urldt">
					  <c:param name="id" value="${n.userId }" />
					</c:url>
					<td>
		            <a href="${url}">승낙하기</a></td>
		            <td><a href="${urldt}">거절하기</a></td>
		            
		            
					
        </tr>   
      </c:forEach>
                </c:if>   
            </table>
            </form> 
   <script>

   </script>

</body>
</html>
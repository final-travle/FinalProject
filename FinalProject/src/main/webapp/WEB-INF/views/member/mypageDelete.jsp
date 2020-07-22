<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <title></title>
<style>
     #hansol{
          width: 4000px;
      }

      body {
    font-family: "Lato", sans-serif;
}
#h{
    right: 250px;
}
.sidenav {
    height: 150;
    width: 100;
    position: fixed;
    z-index: 0;
    top: 150;
    left: 0;
   right: 10;
    overflow-x: hidden;
    transition: 0.5s;
    padding-top: 60px;
    margin-right:20px ;
}

.sidenav a {
    padding: 8px 8px 8px 32px;
    text-decoration: none;
    font-size: 25px;
    color: #818181;
    display: block;
    transition: 0.3s;
}
#joinForm{
                width: 850px;
                margin: 0 auto;
            }
            #logintable{
                margin: 10px;
                padding:0;
                width: 700px;
                border-top: 1px solid #444444;
                border-collapse: collapse;
            }
            .ltd {
                border-bottom: 1px solid #444444;
                padding: 10px;
            }
            #lab{
                background-color:white;
                color: black;
                text-align: center;
                padding: 10px;   
            }
            #inp{
               padding: 10px;
               padding-left: 110px;
               padding-right: 100px;
            }
            tr td input{
                border-radius: 5px;
                height: 30px;
                width: 280px;
            }
            #sye{
              border-radius: 5px;
                height: 30px;
                width: 280px;
            }
            #checkAll{
               zoom: 2.0;
            }
           div select{
              height: 30px;
              border-radius: 5px;
              width: 80px;
              float: left;
              margin-left: 3px ;
           }
           #h2{
               margin-left: 20px;
               text-align: center;
           }
           #h3{
               float: left;
               margin-left: 20px;
           }
           #hh5{
               float:right;
               margin-bottom: 0;
               color: lightgray;
           }
           #agr{
               
               margin-left: 20px;
           }
           .text{
             float: right;
           }
           .container {
                width: 100%;
                height: 140px;
                overflow: auto;
                border: 1px solid black;
                border-radius: 10px;
            }
            .container::-webkit-scrollbar {
                width: 10px;
            }
            .container::-webkit-scrollbar-thumb {
                background-color: #2f3542;
                border-radius: 10px;
                background-clip: padding-box;
                border: 2px solid transparent;
            }
            .container::-webkit-scrollbar-track {
                background-color: grey;
                border-radius: 10px;
                box-shadow: inset 0px 0px 5px white;
            }
            input::-webkit-input-placeholder { 
                color: lightgray; 
            }
            input[type=radio] {
            width:              150px;
            height:             20px;
        }

#logintable{
    

                margin: 0 auto;
                padding:0;
                width: 750px;
                border-top: 1px solid #444444;
                border-collapse: collapse;
            }
            tr td input{
                border-radius: 5px;
                height: 30px;
                width: 280px;
            }
            #sye{
              border-radius: 5px;
                height: 30px;
                width: 280px;
            }

.sidenav a:hover {
    color: #f1f1f1;
}

.sidenav .closebtn {
    position: absolute;
    top: 0;
    right: 25px;
    font-size: 36px;
    margin-left: 50px;
}

@media screen and (max-height: 450px) {
  .sidenav {padding-top: 15px;}
  .sidenav a {font-size: 18px;}
}
</style>

<body>
<div id="hansol">
<hr>
<h1><span style="color: orange;"> ${loginUser.name }</span>님 어서오세요<br></h1>
<h2>친구 : <span style="color: orange;"> ${ listCount }</span>명<br>
글 수 <span style="color: orange;"> 15</span>개</h2>
<hr>
</div>
   <br><br><br>
   <div id="mySidenav" class="sidenav">
    <hr>
    
    <a href="#">내 가 쓴 글</a>
    <a href="#">내가 좋아한 글</a>
    <a href="#">내 정보 수정</a>
    <a href="friends.do">친구정보</a>
    <a href="friendsadd.do">친구추가</a>
    <a href="accfriends.do">친구수락</a>
     <a href="#">회원탈퇴</a>
    <hr>
  </div>
   

  <h3 style="color: red;">탈퇴시 유의사항</h3><br>
  <h3 style="color: red;">1. 탈퇴하시면 지금까지 작성하신 여행계획에 단 댓글은 자동으로 삭제됩니다.</h3><br>
  <h3 style="color: red;">2. 작성하신 여행계획은 탈퇴전에 직접 </h3><a href="#">[내여행리스트]</a><h3 style="color: red;">에서 삭제해주시기 바랍니다.삭제방법은 각 여행플래너에서 상단</h3><br>
  <h3 style="color: red;">제목 우측에 삭제버튼을 누르시면 됩니다.</h3><br>
  <h3 style="color: red;">3. 쓰는 글들과 댓글은 자동으로 삭제되지 않으므로 직접 삭제해주시기 바랍니다.</h3><br>
  <h3 style="color: red;">4. 여행정보와 현지교통과 관련해 집필하신 지식글들은 자동으로 삭제되지 않습니다.</h3><br>
  <span style="color: orange;">*</span>
  <form method="post" action="mchange.do">
  <div id="h">
  <table id="logintable">
    <tbody><tr>
        <td id="lab" class="ltd">
            <label>비밀번호<span style="color: orange;">*</span></label>
        </td>
        <td id="inp" class="ltd">
            <input type="text" id="userId" name="userId" required="" placeholder="4글자 이상 12글자 이하 영문자(소문자)와 숫자">
        </td>
    </tr>

       <tr>
       <td id="inp" class="ltd">
            <input type="submit" id="idCheck"  style="width: 70px; background: darkgrey; color: white;">
       </td>
       </tr>
   
</tbody>
</table>

</div>
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








</body></html>
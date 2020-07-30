<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
   
  <form method="post" action="mchange.do">
  <div id="h">
  <table id="logintable">
    <tbody><tr>
        <td id="lab" class="ltd">
            <label>ID<span style="color: orange;">*</span></label>
        </td>
        <td id="inp" class="ltd">
            <input type="text" id="userId" name="userId" value="${member.id}" required="" placeholder="4글자 이상 12글자 이하 영문자(소문자)와 숫자">
        </td>
    </tr>
    <tr>
        <td id="lab" class="ltd">
            <label>비밀번호<span style="color: orange;">*</span></label>
        </td>
        <td id="inp" class="ltd"> 
            <input type="password" id="userPwd" name="userPwd" required="" placeholder="6글자 이상 18글자 이하 영문자(소문자)와 숫자">
        </td>
    </tr>
    <tr>
        <td id="lab" class="ltd"> 
            <label>비밀번호 확인<span style="color: orange;">*</span></label>
        </td>
        <td id="inp" class="ltd"> 
            <input type="password" id="pwd_check" name="pwd_check" required="">
        </td>
    </tr>
    <tr>
        <td id="lab" class="ltd">
            <label>이름<span style="color: orange;">*</span></label>
        </td>
        <td id="inp" class="ltd">
            <input type="text" id="userName" name="userName" value="${member.name}" required="" placeholder="?쒓?濡?2湲 ???댁긽">
        </td>
    </tr>
    <tr>
      <td id="lab" class="ltd">
          <label>닉네임</label>
      </td>
      <td id="inp" class="ltd">
          <input type="text" id="reference" name="reference" value="${member.nickname}">
      </td>
  </tr>
  <tr>
    <td id="lab" class="ltd"> 
        <label>여행스타일<span style="color: orange;">*</span></label>
    </td>
    <td id="inp" class="ltd"> 
      <select id="sye" name="sye" required="">
        <option value="혼자">혼자여행가기</option>
        <option value="둘이">둘이여행가기</option>
        <option value="셋이">셋이여행가기</option>
        </select>
    </td>
</tr>
    <tr>
        <td id="lab" class="ltd">
            <label>이메일<span style="color: orange;">*</span></label>
        </td>
        <td id="inp" class="ltd">
            <input type="email" id="email" name="email" required="" value="${member.email}">
        </td>
    </tr>
    <tr>
        <td id="lab" class="ltd">
            <label>휴대폰<span style="color: orange;">*</span></label>
        </td>
        <td id="inp" class="ltd">
            <input type="tel" id="phone" name="phone" required="" value="${member.phone}" placeholder="-?쒖쇅 ?섍퀬 ?낅젰">
        </td>
    </tr>
    <tr>
        <td id="lab" class="ltd">
        <label>생년월일<span style="color: orange;">*</span></label>
        </td>
        <td id="inp" class="ltd">
            <div id="birth">
                <select id="year" name="year" required="">
                    <option value="년">년</option>
                    <option value="2020">2020</option>
                    <option value="2019">2019</option>
                    <option value="2018">2018</option>
                    <option value="2017">2017</option>
                    <option value="2016">2016</option>
                    <option value="2015">2015</option>
                    <option value="2014">2014</option>
                    <option value="2013">2013</option>
                    <option value="2012">2012</option>
                    <option value="2011">2011</option>
                    <option value="2010">2010</option>
                    <option value="2009">2009</option>
                    <option value="2008">2008</option>
                    <option value="2007">2007</option>
                    <option value="2006">2006</option>
                    <option value="2005">2005</option>
                    <option value="2004">2004</option>
                    <option value="2003">2003</option>
                    <option value="2002">2002</option>
                    <option value="2001">2001</option>
                    <option value="2000">2000</option>
                    <option value="1999">1999</option>
                    <option value="1998">1998</option>
                    <option value="1997">1997</option>
                    <option value="1996">1996</option>
                    <option value="1995">1995</option>
                    <option value="1994">1994</option>
                    <option value="1993">1993</option>
                    <option value="1992">1992</option>
                    <option value="1991">1991</option>
                    <option value="1990">1990</option>
                    <option value="1989">1989</option>
                    <option value="1988">1988</option>
                    <option value="1987">1987</option>
                    <option value="1986">1986</option>
                    <option value="1985">1985</option>
                    <option value="1984">1984</option>
                    <option value="1983">1983</option>
                    <option value="1982">1982</option>
                    <option value="1981">1981</option>
                    <option value="1980">1980</option>
                    <option value="1979">1979</option>
                    <option value="1978">1978</option>
                    <option value="1977">1977</option>
                    <option value="1976">1976</option>
                    <option value="1975">1975</option>
                    <option value="1974">1974</option>
                    <option value="1973">1973</option>
                    <option value="1972">1972</option>
                    <option value="1971">1971</option>
                    <option value="1970">1970</option>
                    <option value="1969">1969</option>
                    <option value="1968">1968</option>
                    <option value="1967">1967</option>
                    <option value="1966">1966</option>
                    <option value="1965">1965</option>
                    <option value="1964">1964</option>
                    <option value="1963">1963</option>
                    <option value="1962">1962</option>
                    <option value="1961">1961</option>
                    <option value="1960">1960</option>
                    <option value="1959">1959</option>
                    <option value="1958">1958</option>
                    <option value="1957">1957</option>
                    <option value="1956">1956</option>
                    <option value="1955">1955</option>
                    <option value="1954">1954</option>
                    <option value="1953">1953</option>
                    <option value="1952">1952</option>
                    <option value="1951">1951</option>
                    <option value="1950">1950</option>
                </select>
                <select id="mon" name="mon" required="">
                    <option value="월">월</option>
                    <option value="01">01</option>
                    <option value="02">02</option>
                    <option value="03">03</option>
                    <option value="04">04</option>
                    <option value="05">05</option>
                    <option value="06">06</option>
                    <option value="07">07</option>
                    <option value="08">08</option>
                    <option value="09">09</option>
                    <option value="10">10</option>
                    <option value="11">11</option>
                    <option value="12">12</option>
                </select>
                <select id="day" name="day" required="">
                    <option value="일">일</option>
                    <option value="01">01</option>
                    <option value="02">02</option>
                    <option value="03">03</option>
                    <option value="04">04</option>
                    <option value="05">05</option>
                    <option value="06">06</option>
                    <option value="07">07</option>
                    <option value="08">08</option>
                    <option value="09">09</option>
                    <option value="10">10</option>
                    <option value="11">11</option>
                    <option value="12">12</option>
                    <option value="13">13</option>
                    <option value="14">14</option>
                    <option value="15">15</option>
                    <option value="16">16</option>
                    <option value="17">17</option>
                    <option value="18">18</option>
                    <option value="19">19</option>
                    <option value="20">20</option>
                    <option value="21">21</option>
                    <option value="22">22</option>
                    <option value="23">23</option>
                    <option value="24">24</option>
                    <option value="25">25</option>
                    <option value="26">26</option>
                    <option value="27">27</option>
                    <option value="28">28</option>
                    <option value="29">29</option>
                    <option value="30">30</option>
                    <option value="31">31</option>          
          </select>
        </div></td>
        </tr><tr>
          <td id="lab" class="ltd">
              <label>성별<span style="color: orange;">*</span></label>
          </td>
          <td id="inp" class="ltd">
            <span class="sortOptions">
            <label for="sex">남</label>
            <input type="radio" name="sex" id="sex" value="남">
            <label for="sex">여</label>
            <input type="radio" name="sex" id="sex" value="여">
            </span>
            
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
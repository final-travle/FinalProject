<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <title></title>
<style>
body {    font-family: "Lato", sans-serif;}
#joinForm{  
				width: 800px;
                margin: 0 auto;
            }
            #logintable{
                margin: 0 ;
                padding:0 ;
                width: 800px;
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
            tr td input[type=text] {
                
                height: 30px;
                width: 280px;
            }
            
            #sye{
              
                height: 30px;
                width: 280px;
            }
            #checkAll{
               zoom: 2.0;
            }
           div select{
              height: 30px;   
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
            tr td input[type=password] {
              
                height: 30px;
                width: 280px;
            }
            tr td input[type=email] {
              
                height: 30px;
                width: 280px;
            }
             tr td input[type=tel] {
                              height: 30px;
                width: 280px;
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
            width:              100px;
            height:             20px;
        }
        input[type=submit]{
                                height: 30px;
                width: 280px;
                 margin: auto;
            }

			
            #sye{
              
                height: 30px;
                width: 280px;
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
글 수 <span style="color: orange;"> ${pCount} </span>개</h2>
<h1 style="text-align: center; font-style : oblique;">INFOCHANGE</h1>
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
	    <div class="menuSide"><p><a href="adminPostmanager.do">회원 글 관리</a></p></div>
   </c:if>
    </div>
  <form id="joinForm" name="join" method="post" action="mchange.do">
  <table id="logintable">
    <tbody>
    <tr>
        <td id="lab" class="ltd">
            <label>ID<span style="color: orange;">*</span></label>
        </td>
        <td id="inp" class="ltd">
            <input type="text" id="id" name="id" value="${member.id}" disabled required="" placeholder="4글자 이상 12글자 이하 영문자(소문자)와 숫자">
        </td>
    </tr>
    <tr>
        <td id="lab" class="ltd">
            <label>비밀번호<span style="color: orange;">*</span></label>
        </td>
        <td id="inp" class="ltd"> 
            <input type="password" id="userPwd" name="pwd" required="" placeholder="6글자 이상 18글자 이하 영문자(소문자)와 숫자">
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
            <input type="text" id="userName" name="name" value="${member.name}" required="" placeholder="?쒓?濡?2湲 ???댁긽">
        </td>
    </tr>
    <tr>
      <td id="lab" class="ltd">
          <label>닉네임</label>
      </td>
      <td id="inp" class="ltd">
          <input type="text" id="reference" name="nickname" value="${member.nickname}">
      </td>
  </tr>
    <tr>
             <td id="lab" class="ltd"> 
                 <label>여행스타일<span style="color: orange;">*</span></label>
             </td>
             <td id="inp" class="ltd"> 
              	호캉스<input type="checkbox" name="tType" value="호캉스"/>
                FLEX<input type="checkbox" name="tType" value="FLEX"/>
              	힐링<input type="checkbox" name="tType" value="힐링"/>
              	효도관광<input type="checkbox" name="tType" value="효도관광"/><br>
              	이벤트<input type="checkbox" name="tType" value="이벤트"/>
              	직장인휴가<input type="checkbox" name="tType" value="직장인휴가"/>
              	문화재탐방<input type="checkbox" name="tType" value="문화재탐방"/><br>
              	짠내투어<input type="checkbox" name="tType" value="짠내투어"/>
              	쇼핑관광<input type="checkbox" name="tType" value="쇼핑관광"/>
              	한달살이<input type="checkbox" name="tType" value="한달살이"/>
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
           
            <label for="sex">남</label>
            <input type="radio" name="gender" id="sex" value="M">
            <label for="sex">여</label>
            <input type="radio" name="gender" id="sex" value="Y">
           
            
        </td>
      </tr>
       <tr>
       <td id="inp" class="sb" colspan="2" >
       <div style="text-align : center;">
         <input class="colorBtn btn" type="button" value="제출" id="submit_btn"  onclick="check();">
                </div>
            </td>
            <td></td>
       </tr>
   
</tbody>
</table>

</form>
</div>
<!-- <span style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776; open</span> -->

<!-- <script>
    function openNav() {
        document.getElementById("mySidenav").style.width = "250px";
    }
    
    function closeNav() {
        document.getElementById("mySidenav").style.width = "0";
    }
    </script> -->


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


function check(){
	var f = document.join;
	   
	if (f.pwd.value == "") {
        alert("비밀번호를 입력해주십시오");
        f.pwd.focus();
        
        return false;
    }

if (f.pwd.value != f.pwd_check.value) {
		 alert("비빌번호를 다르게 입력했습니다.");
		f.pwd_check.select();
    return false;
}
   
   
	if (f.name.value == "") {
        alert("이름를 입력해주십시오");
        f.name.focus();
        
        return false;
    }
if (f.nickname.value == "") {
        alert("별명을 입력해주십시오");
        f.nickname.focus();
        
        return false;
    }
if (f.email.value == "") {
    alert("이메일을 입력해주십시오");
    f.job.focus();
    
    return false;
}
if (f.phone.value == "") {
    alert("핸드폰을 입력해주십시오");
    f.phone.focus();
    
    return false;
}

if ($("select[name=year]").val() == "년") {
    alert("생년월일을 입력해주십시오");
    f.year.focus();
    
    return false;
}
if ($("select[name=mon]").val() == "월") {
    alert("생년월일을 입력해주십시오");
    f.mon.focus();
    
    return false;
}
if ($("select[name=day]").val() == "일") {
    alert("생년월일을 입력해주십시오");
    f.day.focus();
    
    return false;
}


  
var objWrite3 = document.getElementsByName("tType");
var count = 0;
for(var i=0;i<objWrite3.length;i++){
    if(objWrite3[i].checked == true){
        count++;
    }
}
if(count<=0){
    alert("여행스타일을 설정해주십시오.");
    return false;
}


var objWrite4 = document.getElementsByName("gender");
var count = 0;
for(var i=0;i<objWrite4.length;i++){
    if(objWrite4[i].checked == true){
        count++;
    }
}
if(count<=0){
    alert("성별을 설정해주십시오.");
    return false;
}else{
	$("#joinForm").submit();	
}

}

</script>

   <jsp:include page="../common/footer.jsp" />
 

</body></html>
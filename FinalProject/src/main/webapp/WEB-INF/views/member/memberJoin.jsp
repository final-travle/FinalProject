
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<style>
           .guide{
           display:none;
           }
            #joinForm{
                width: 800px;
                margin: 0 auto;
            }
            #logintable{
                margin: 0;
                padding:0;
                width: 800px;
                border-top: 1px solid #444444;
                border-collapse: collapse;
            }
            .ltd {
                border-bottom: 1px solid #444444;
                padding: 10px;
            }
            #lab{
                background-color: white;
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
                border-radius: 5px;
                height: 30px;
                width: 280px;
            }
            tr td input[type=password] {
                border-radius: 5px;
                height: 30px;
                width: 280px;
            }
            tr td input[type=email] {
                border-radius: 5px;
                height: 30px;
                width: 280px;
            }
             tr td input[type=tel] {
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
               margin-left: 300px;
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
  
        </style>
</head>
<body>

   <form id="joinForm" method="post" action="minsert.do">
            <h2 id="h2">JOIN MEMBER</h2>
            <h5 id="hh5">*은 반드시 적어야 하는 항목</h5>
            <table id="logintable">
                <tr>
                    <td id="lab" class="ltd">
                        <label>아이디<span style="color: orange;">*</span></label>
                    </td>
                    <td id="inp" class="ltd">
                        <input type="text" id="userId" name="id" required placeholder="4글자 이상 12글자 이하 영문자(소문자)와 숫자">
                        <span class="guide ok" style="color: green;">사용 가능</span>
                  <span class="guide error" style="color: red;">사용 불가능</span>
                  <input type="hidden" name="idDuplicateCheck" id="idDuplicateCheck" value="0">
                        <!-- <input type="hidden" value="N" id="checkCheck"> -->
                    </td>
                </tr>
                <tr>
                    <td id="lab" class="ltd">
                        <label>비밀번호<span style="color: orange;">*</span></label>
                    </td>
                    <td id="inp" class="ltd"> 
                        <input type="password" id="userPwd" name="pwd" required placeholder="6글자 이상 18글자 이하 영문자(소문자)와 숫자">
                    </td>
                </tr>
                <tr>
                    <td id="lab" class="ltd"> 
                        <label>비밀번호 확인<span style="color: orange;">*</span></label>
                    </td>
                    <td id="inp" class="ltd"> 
                        <input type="password" id="pwd_check" name="pwd_check" required>
                    </td>
                </tr>
                <tr>
                    <td id="lab" class="ltd">
                        <label>이름<span style="color: orange;">*</span></label>
                    </td>
                    <td id="inp" class="ltd">
                        <input type="text" id="userName" name="name" required placeholder="한글로 2글자 이상">
                    </td>
                </tr>
                <tr>
                    <td id="lab" class="ltd">
                        <label>별명<span style="color: orange;">*</span></label>
                    </td>
                    <td id="inp" class="ltd">
                        <input type="text" id="userNic" name="nicname" required placeholder="한글로 2글자 이상">
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
              	효도관광<input type="checkbox" name="tType" value="효도관광"/>
              	이벤트<input type="checkbox" name="tType" value="이벤트"/>
              	직장인휴가<input type="checkbox" name="tType" value="직장인휴가"/><br>
              	문화재탐방<input type="checkbox" name="tType" value="문화재탐방"/>
              	짠내투어<input type="checkbox" name="tType" value="짠내투어"/>
              	쇼핑관광<input type="checkbox" name="tType" value="쇼핑관광"/>
              	한달살이<input type="checkbox" name="tType" value="한달살이"/>
             </td>
            </tr>
                <tr>
                    <td id="lab" class="ltd">
                        <label>성별<span style="color: orange;">*</span></label>
                    </td>
                    <td id="inp" class="ltd">
                      	남자  <input type="radio" id="sex" name="gender" value="M"> 여자  <input type="radio" id="sex" name="gender" value="F">
                    </td>
                </tr>
                
                <tr>
                    <td id="lab" class="ltd">
                        <label>직업<span style="color: orange;">*</span></label>
                    </td>
                    <td id="inp" class="ltd">
                        <input type="text" id="job" name="job" required placeholder="한글로 2글자 이상">
                    </td>
                </tr>
                
                
                
                <tr>
                    <td id="lab" class="ltd">
                        <label>이메일<span style="color: orange;">*</span></label>
                    </td>
                    <td id="inp" class="ltd">
                        <input type="email" id="email" name="email" required>
                    </td>
                </tr>
                <tr>
                    <td id="lab" class="ltd">
                        <label>휴대폰<span style="color: orange;">*</span></label>
                    </td>
                    <td id="inp" class="ltd">
                        <input type="tel" id="phone" name="phone" required placeholder="-제외 하고 입력">
                    </td>
                </tr>
                <tr>
                    <td id="lab" class="ltd">
                    <label>생년월일<span style="color: orange;">*</span></label>
                    </td>
                    <td id="inp" class="ltd">
                        <div id="birth">
                            <select id="year" name="year" required>
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
                            <select id="mon" name="mon" required>
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
                            <select id="day" name="day" required>
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
                        </div>
                    </td>
                </tr>
                
            </table>
            <br>
            <h5 id="agr">약관동의</h5>
            <hr>
            <input type="checkbox" id="checkAll">
            <label style="font-size: 18px;">모든 약관을 확인하고 동의합니다.</label>
            <label style="font-size: 13px; color: lightgray;">(전체동의, 선택항목도 포함됩니다.)</label>
            <ul>
                <ul>
                    <li style="list-style: none;">
                        <input type="checkbox" id="check1" name = "agree_chk" class="infoBox">
                        <label>(필수)이용약관</label>
                        <lable><a href="javascript:windowopenPopup();">전체보기</a></lable>
                    </li>
                    <br>
               

                    <li style="list-style: none;">
                        <input type="checkbox" id="check2" name="agree_chk" class="infoBox">
                        <label>(필수)개인정보 수집 및 이용</label>
                        <lable><a href="javascript:windowopenPopup2();">전체보기</a></lable>
                    </li>
                    <br>
                   
                 
                    <li style="list-style: none;">
                        <input type="checkbox" id="check3" name="agree_chk" class="infoBox" >
                        <label>(필수)14세 이상입니다. *회원가입은 만 14세 이상부터 가능합니다.</label>
                         <lable><a href="javascript:windowopenPopup3();">전체보기</a></lable>
                    </li>
                    <br>
                    <li style="list-style: none;">
                        <input type="checkbox" id="check4" value="N" name="alarm_YN" class="infoBox">
                        <label>(선택)정보/이벤트 메일 수신에 동의합니다.</label>
                         <lable><a href="javascript:windowopenPopup4();">전체보기</a></lable>
                    </li>
                    <br>
                    <li style="list-style: none;">
                        <input type="checkbox" id="check5" value="N" name="agree_chk" class="infoBox">
                        <label>(선택)정보/이벤트 SMS 수신에 동의합니다.</label>
                         <lable><a href="javascript:windowopenPopup5();">전체보기</a></lable>
                    </li>
                    <br>
                    <dev style="font-size: 10px; color: lightgray;">*선택 약관 미동의시 포인트, 할인 혜택 등 추가 정보 수신 불가</dev>
                </ul>
            </ul>
            <br><br><br><br><br>
            <div style="text-align: center;">
                <input type="button" value="회원가입" id="submit_btn" style="width: 90px; height: 40px; color: white; background: darkgrey; border-radius: 7px;" onclick="check();">
                
                <input type="button" value="취소" id="cancel" onclick=cancle(); style="width: 90px; height: 40px; color: black; background-color: lightgray; border-radius: 7px;">
            </div>        
        </form>
        <script>
        $(function(){
         $("#userId").on("keyup",function(){
            var userId = $(this).val().trim();
            
            if(userId.length < 4){
               $(".guide").hide();
               $("#idDuplicateCheck").val(0);
               
               return;   
               // 애초에 4글자가 안되게 아이디를 쓰면 ajax가 실행되지 않고
            
            }
            
            $.ajax({
               url:"dupid.do",      
               data:{id:userId},
               dataType : "json",
               type : "post",  
               success:function(data){
                  //1. Stream을 이용한 방식
                  //if(data == "true"){
                  //2. jsonView를 이용한 방식
                  if(data.isUsable == 0){ // 보내고자 하는 자료형을 그대로 뽑아올 수 있다.
                     /* console.log("사용가능"); */
                     $(".guide.error").hide();
                     $(".guide.ok").show();
                     $("#idDuplicateCheck").val(1);
                  }else{
                     /* console.log("사용불가능"); */
                     $(".guide.error").show();
                     $(".guide.ok").hide();
                     $("#idDuplicateCheck").val(0);
                  }
               },
               error:function(request, status, errorData){
                  alert("error code: " + request.status + "\n"
                        +"message: " + request.responseText
                        +"error: " + errorData);
               }
            })
         })
      })
      
   /*    function validate(){
         // 아이디 중복 체크 후 회원가입 버튼 눌렀을 때
         if($("#idDuplicateCheck").val()==0){
            alert("사용 가능한 아이디를 입력해 주세요.");
            $("#userId").focus();
         }else{
            $("#joinForm").submit();
         }
      } */
        
        
        
        
        
           // 취소
            function cancle(){
               location.href="<%=request.getContextPath()%>/main/mainView";
            }
           
           // 필수동의 체크 여부
            function check(){
              
            if($("#idDuplicateCheck").val()==0){
                alert("사용 가능한 아이디를 입력해 주세요.");
                $("#userId").focus();   
            }else if($("#check1").prop('checked') == false || $("#check2").prop("checked") == false || $("#check3").prop("checked") != true){
                     alert("필수 약관에 동의 하셔야 합니다.");   
               }else{
                   $("#joinForm").submit();
                }
            }
            // 회원가입 실패
             <%--  <%if(msg != null){%>
               alert("<%=msg%>");
             <%}%>
            --%>
            function windowopenPopup(){
                 window.open('ex1.do', 'window팝업', 'width=600, height=600, menubar=no, status=no, toolbar=no, resizable=no');
            }
            function windowopenPopup2(){
                window.open('ex2.do', 'window팝업', 'width=600, height=600, menubar=no, status=no, toolbar=no,resizable=no');
           }
            function windowopenPopup3(){
                window.open('ex3.do', 'window팝업', 'width=600, height=600, menubar=no, status=no, toolbar=no,resizable=no');
           }
            function windowopenPopup4(){
                window.open('ex4.do', 'window팝업', 'width=600, height=600, menubar=no, status=no, toolbar=no,resizable=no');
           }
            function windowopenPopup5(){
                window.open('ex5.do', 'window팝업', 'width=600, height=600, menubar=no, status=no, toolbar=no,resizable=no');
           } 

            function idCheck(){
                 var userid = document.getElementById("userId").value;
                 if(userid)
                 {
                    url = "idchecked.jsp?userid="+userid;
                       window.open(url,"chkid","width=300,height=100");
                    }else{
                       alert("아이디를 입력하세요");
                    }
                 }
            
            
            $(function(){                              
               // 체크 박스
                $('ipnut[type=checkbox]').click(function(){
                    console.log($(this).prop("checked"));
                });
                $("#checkAll").click(function(){
                    var bool = $("#checkAll").prop("checked");
                    $(".infoBox").prop("checked",bool);
                   
                    
                });
                // 체크박스 end
                
                // 아이디 정규화
                $("#userId").change(function(){
                    var value = $("#userId").val();
                    var reg = /^[a-z0-9]{4,12}$/;
                    if(!reg.test(value)){
                        alert("영문자와 숫자로 4글자 이상 12글자 이하여야 합니다.");
                        $("#userId").focus().val('');
                    }
                });
                // 비밀번호 정규화
                $("#userPwd").change(function(){
                    var value = $("#userPwd").val();
                    var reg = /^[a-z0-9]{6,18}$/;
                    if(!reg.test(value)){
                        alert("영문자와 숫자로 6글자 이상 12글자 이하여야 합니다.");
                        $("#userPwd").focus().val('');
                    }
                });
                // 비밀번호 체크 정규화
                $("#pwd_check").change(function(){
                    var pw1 = $("#userPwd").val();
                    var pw2 = $("#pwd_check").val();
                    
                    if(pw1 == pw2){
                        $("#pwd_check").val();
                    }else{
                        alert("비밀번호가 일치하지 않습니다.");
                        $("#pwd_check").focus().val('');
                    }
                });
                // 이름 정규화
                $("#userName").change(function(){
                    var value = $("#userName").val();
                    var reg = /^[가-힣]{2,4}$/;
                    
                    if(!reg.test(value)){
                        alert("한글로 2글자 이상 입력해주세요.");
                        $("#userName").focus().val('');
                    }
                });
                // 휴대폰 정규화
                $("#phone").change(function(){
                    var value = $("#phone").val();
                    var reg = /^[0-9]{11}$/;
                    
                    if(!reg.test(value)){
                        alert("-를 제외한 숫자만을 입력해 주세요.");
                        $("#phone").focus().val('');
                    }
                });
             
                
            });
               // 메일 수신 동의 시 
               $(function(){
                
                    if($("input:checkbox[id='check4']:checked") == true){
                  
                       $("#check4").val();
                    }else{
                       $("#check4").val("Y");
                    }
        
                 });   
              

                
               
                   
                     
            
            
       </script>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <title></title>
<style>

body {font-family: "Lato", sans-serif;}
#h{right: 250px;}
#friendsbody{width: 850px;margin: 0 auto;}
#noticelistArea{    margin: 10px;
                padding:0;
                width: 800px;
                border-top: 1px solid #444444;
                border-collapse: collapse;
            }
.ltd {border-bottom: 1px solid #444444;padding: 10px;}
#lab{background-color:white;color: black;text-align: center;padding: 10px;   }
#inp{padding: 10px;padding-left: 110px; padding-right: 100px;}
tr td input{   height: 30px;
                width: 280px;
            }
#search {
	width:540px;
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

#noticelistArea{
                margin: 10px;
                padding:0;
                width: 800px;
                border-top: 1px solid #444444;
                border-collapse: collapse;
            }

</style>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="https://unpkg.com/hangul-js" type="text/javascript"></script>

<body>
<jsp:include page="../common/header.jsp" />

<div id="memberinfo">
<h1><span style="color: orange;"> ${loginUser.name }</span>님 어서오세요<br></h1>
<h2>친구 : <span style="color: orange;">${fCount}</span>명<br>
글 수 <span style="color: orange;"> ${pCount} </span>개<br>
공유 글 수 <span style="color: orange;"> ${sCount} </span>개 </h2>
<h1 style="text-align: center; font-style : oblique;">ADDFRIENDS</h1>
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
    <br>
   <br>
 <div id="friendsbody">   
   <form method="post" action="friendsadd.do">
   <div id="firendsIdSearch">
   <label for="search">이름으로 검색 : </label>
   <input align="center" type="text" id="search" name="noticeSearch"  placeholder="이름을 입력해주세요">
   <input type="submit" id="searchBtn" class="colorBtn btn" value="SEARCH">
   </div>        
   
     <div id="friendsbodyInfo">       
            <table id="noticelistArea" align="center" width="800" border="1" cellspacing="0" 
			         style="claer:right;" >
                    <tr bgcolor="#bd9dec">
                        <th>ID</th> <th>이름</th> <th>닉네임</th> <th>성별</th> <th>친구추가</th>
                    </tr>

            <c:if test="${empty allmember  }">
            <tr>
            
            <td style="text-align : center;" colspan="6">리스트가없습니다</td>
            </tr>
            </c:if>      
            <c:forEach var="n" items="${allmember }">
            <c:set var="loop" value="false" />
           
         <tr>
            <td align="center">${n.id }</td>
            <td align="center">${n.name }</td>
            <td align="center">${n.nickname }</td>
            <td align="center">${n.gender }</td>
            <c:set var="loop_flag" value="false" />
	            <c:forEach var="nb" items="${allfriends }">
	            <c:if test="${not loop_flag }">
					<c:if test="${nb.userId eq n.id}">
					<c:choose>
						<c:when test="${nb.acceptYn eq 'Y'}">
							<td>
								<c:set var="loop_flag" value="true" />
					            <c:out value="이미친구" />
					            <c:set var="loop" value="true" />
				            </td>
						</c:when>
						<c:when test="${nb.acceptYn eq 'N'}">
							<td>
								<c:set var="loop_flag" value="true" />
					            <c:out value="응답대기중" />
					            <c:set var="loop" value="true" />
				            </td>
						</c:when>
					</c:choose>
					</c:if>
				</c:if>
				</c:forEach>
				<c:if test="${not loop }">
		            <td>
		            <c:url value="hansolhansol.do" var="url">
					  <c:param name="id" value="${n.id }" />
					</c:url>
		            <a href="${url}">신청하기</a>
		            </td>
				</c:if>
        </tr>   
      </c:forEach>
                   
            </table>
           </div> 
            </form>
            </div>
       <div id="paging" align="center" width="600" border="1">
   <!-- [이전] -->
			<c:if test="${pi.currentPage eq 1 }">
				[이전]&nbsp;
			</c:if>
			
			<c:if test="${pi.currentPage gt 1 }">
				<c:url var="blistBack" value="friendsadd.do">
					<c:param name="page" value="${pi.currentPage -1 }"/>
					<c:param name="search" value="${search}"/>
				</c:url>
				<a href="${blistBack }">[이전]</a>
			</c:if>
			<!-- [번호들] -->
			<c:forEach var="p" begin="${pi.startPage }" end="${pi.endPage }">
				<c:if test="${p eq pi.currentPage }">
					<font color="red" size="4"><b>[${p }]</b></font>
				</c:if>
				
				<c:if test="${p ne pi.currentPage }">
					<c:url var="blistCheck" value="friendsadd.do">
						<c:param name="page" value="${p }"/>
						<c:param name="search" value="${search}"/>
					</c:url>
					<a href="${blistCheck }">${p }</a>
				</c:if>
			</c:forEach>
			
			<!-- [다음] -->
			<c:if test="${pi.currentPage eq pi.maxPage }">
				&nbsp;[다음]
			</c:if>
			
			<c:if test="${pi.currentPage lt pi.maxPage }">
				<c:url var="blistEnd" value="friendsadd.do">
					<c:param name="page" value="${pi.currentPage + 1 }"/>
					<c:param name="search" value="${search}"/>
				</c:url>
				<a href="${blistEnd }">[다음]</a>
			</c:if>
    </div>
 <script>
	$(function() { 

		//화면 다 뜨면 시작
		//DB쿼리 조작 없이 초성 검색을 하기 위해서는 우선 DB에 있는 항목들을 다 가지고 와야한다.
		//즉 너무 많은 수가 있으면 클라이언트 측이 느려질 수 있다는 점.
		//하지만 DB쿼리를 조작해서 서버에서 초성검색을 하는 방식에 비해 서버에는 무리가 없다.
		// ajax로 미리 검색어 목록을 다 가지고 온다.
		$.ajax({
			type : 'get',
			url : "Allhansolyy.do",
			dataType : "json",
			//request.term = $("#autocomplete").val()
			//data: {"param":"param"},
			success : function(data) {
				let source = $.map(data, function(item) { //json[i] 번째 에 있는게 item 임.
					chosung = "";
					Hangul.d(item, true).forEach(function(strItem, index) {
						if(strItem[0] != " "){	//띄어 쓰기가 아니면
							chosung += strItem[0];//초성 추가
						}
					});
					return {
						label : chosung + "|" +item, //실제 검색어랑 비교 대상 ㄱㅊㅂㅇㅂ|김치 볶음밥 이 저장된다.
						value : item, //김치 볶음밥
						chosung : chosung	//ㄱㅊㅂㅇㅂ
					}
				});
				
				
				$("#search").autocomplete({
					source : source,	// source 는 자동 완성 대상
					select : function(event, ui) {	//아이템 선택시
						console.log(ui.item.label + " 선택 완료");	
						
					},
					focus : function(event, ui) {	//포커스 가면
						return false;//한글 에러 잡기용도로 사용됨
					}
				}).autocomplete( "instance" )._renderItem = function( ul, item ) {	
				//.autocomplete( "instance" )._renderItem 설절 부분이 핵심
			      return $( "<li>" )	//기본 tag가 li로 되어 있음 
			        .append( "<div>" + item.value + "</div>" )	//여기에다가 원하는 모양의 HTML을 만들면 UI가 원하는 모양으로 변함.
			        .appendTo( ul );	//웹 상으로 보이는 건 정상적인 "김치 볶음밥" 인데 내부에서는 ㄱㅊㅂㅇㅂ,김치 볶음밥 에서 검색을 함.
			    };
			}
		});

	});
	
	
	
</script>

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
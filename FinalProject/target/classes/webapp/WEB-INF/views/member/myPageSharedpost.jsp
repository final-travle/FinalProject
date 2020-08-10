<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 필요한 CSS, JS 로드 -->
<style>
.ui-autocomplete { 
    overflow-y: scroll; 
    overflow-x: hidden;}
    
    
@import url(https://fonts.googleapis.com/css?family=Roboto:300,400);
@import url(https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css);
.snip1368 {
  font-family: 'Roboto', Arial, sans-serif;
  position: relative;
  overflow: hidden;
  margin: 10px;
  min-width: 315px;
  max-width: 315px;
  color: #ffffff;
  line-height: 1.4em;
} 

.snip1368 img {
  opacity: 1;
  width: 100%;
  vertical-align: top;
}

.snip1368 .snip13 {
  padding: 5px 25px 15px;
  position: absolute;
  width: 100%;
  height: 100%;
  z-index: 2;
  bottom: 0%;
  background-color: #141414;
  -webkit-transform: translateY(200%);
  transform: translateY(200%);
}

.snip1368 .snip13:before {
  position: absolute;
  content: '';
  bottom: 100%;
  left: 0;
  width: 0;
  height: 0;
  border-style: solid;
  border-width: 55px 0 0 315px;
  border-color: transparent transparent transparent #141414;
}

 .snip1368 .snip13 .icons{
  position: absolute;
  content: '';
  bottom: 100%;
  top: 0px;
  right: 0;
  left: 0;
  width: 0;
  height: 100%;
  }

 .snip1368 i {
  padding: 0px 8px;
  display: inline-block;
  font-size: 24px;
  color: #ffffff;
  text-align: center;
  opacity: 0.7;
}

 .snip1368 i:hover {
  opacity: 1;
  -webkit-transition: all 0.35s ease;
  transition: all 0.35s ease;
}

.snip1368:hover .snip13,
.snip1368.hover .snip13 {
  -webkit-transform: translateY(0%);
  transform: translateY(0%);
}
</STYLE>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="https://unpkg.com/hangul-js" type="text/javascript"></script>

</head>
<body>
	<form id="memberplanListShared"  method="post" action="memberplanListShared.do">
		<input id="searchInput" name="searchInput">
		<button type="submit">검색</button>
			
			<input type="hidden" name="postNo" value="${postNo }"/>
			<input type="hidden" name="page" value="${pi.currentPage }"/>
			<input type="hidden" name="postType" value="${postType }"/>
			
	</form>
 
 <div>
 <c:if test="${empty freindsshared  }">
            <h3>공유된 친구가없습니다 .</h3>
            </c:if>
	 <c:forEach var="nb" items="${freindsshared }">
                <c:url value="memberdeleteShared.do" var="url12">
						<c:param name="postNo" value="${postNo }" />
						<c:param name="postType" value="${postType }" />
					  	<c:param name="id" value="${nb.id} " />
					</c:url>
		         <a href="${url12}">${nb.name }</a>
                 
	</c:forEach>
	 
 </div>
 
 
 
 <div id="friendsInfo">
             <table id="noticelistArea" align="center" width="600" border="1">
                    <tr>
                        <th>id</th> <th>이름</th> <th>닉네임</th> <th>핸드폰</th> <th>공유하기</th>
                    </tr>

            <c:if test="${empty friends  }">
            <tr>
            <td>검색된 친구가없습니다</td>
            </tr>
            </c:if>      
            <c:forEach var="n" items="${friends }">
            <c:set var="loop" value="false" />
           
         <tr>
            <td align="center">${n.id }</td>
            <td align="center">${n.name }</td>
            <td align="center">${n.nickname }</td>
            <td align="center">${n.phone }</td>
            <c:set var="loop_flag" value="false" />
	            <c:forEach var="nb" items="${allshared }">
	            <c:if test="${not loop_flag }">
					<c:if test="${nb eq n.id}">
					 <c:set var="loop" value="true" />
					 <td>
					  <c:out value="공유된친구" />
					  </td>
					</c:if>
				</c:if>
				</c:forEach>
				<c:if test="${not loop }">
		            <td>
		            <c:url value="memberSharedInsert.do" var="url">
						<c:param name="postNo" value="${postNo }" />
						<c:param name="postType" value="${postType }" />
					  <c:param name="id" value="${n.id }" />
					</c:url>
		            <a href="${url}">공유하기</a>
		            </td>
				</c:if>
        </tr>   
      </c:forEach>
                   
            </table>
 </div>
</body>
<script>
	$(function() { 

		//화면 다 뜨면 시작
		//DB쿼리 조작 없이 초성 검색을 하기 위해서는 우선 DB에 있는 항목들을 다 가지고 와야한다.
		//즉 너무 많은 수가 있으면 클라이언트 측이 느려질 수 있다는 점.
		//하지만 DB쿼리를 조작해서 서버에서 초성검색을 하는 방식에 비해 서버에는 무리가 없다.
		// ajax로 미리 검색어 목록을 다 가지고 온다.
		$.ajax({
			type : 'get',
			url : "hansolyy.do",
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
				
				
				$("#searchInput").autocomplete({
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
$('.deleteShared').click(function(){
    alert(this.id);
});
</script>

</html>
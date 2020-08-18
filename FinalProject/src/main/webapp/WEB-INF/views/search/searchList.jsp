<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>  
</head>
<body>
<jsp:include page="../common/header.jsp" />

  <div id="container" class="cf">
        <div id="content">

  <section class="tagSearch" style="margin-top:0px">
        <div class="titleArea">
            <h1 class="titlename">국내 추천 여행지 <font style="font-size:10pt;color:#3ad195">전국 관광지를 조건에 맞게 설정할 수 있어요!</font></h1>
        </div>
        <br>
 	<div id="searchTag" >        
        <div class="container">
                           지역&nbsp;
            <input type="radio" name="city" value="서울"/>서울
            <input type="radio" name="city" value="인천"/>인천
            <input type="radio" name="city" value="부산"/>부산
            <input type="radio" name="city" value="광주"/>광주
            <input type="radio" name="city" value="대전"/>대전
            <input type="radio" name="city" value="대구"/>대구
            <input type="radio" name="city" value="울산"/>울산 
            <input type="radio" name="city" value="경기"/>경기
            <input type="radio" name="city" value="세종"/>세종
            <input type="radio" name="city" value="강원"/>강원
            <input type="radio" name="city" value="충북"/>충북
            <input type="radio" name="city" value="충남"/>충남
            <input type="radio" name="city" value="전북"/>전북
            <input type="radio" name="city" value="전남"/>전남
            <input type="radio" name="city" value="경북"/>경북
            <input type="radio" name="city" value="경남"/>경남
            <input type="radio" name="city" value="제주"/>제주  

    
        </div>
           <br>

        <div class="container">
                           월별&nbsp;
            <input type="radio" name="month" value="1월"/>1월
            <input type="radio" name="month" value="2월"/>2월
            <input type="radio" name="month" value="3월"/>3월
            <input type="radio" name="month" value="4월"/>4월
            <input type="radio" name="month" value="5월"/>5월
            <input type="radio" name="month" value="6월"/>6월
            <input type="radio" name="month" value="7월"/>7월     
            <input type="radio" name="month" value="8월"/>8월
            <input type="radio" name="month" value="9월"/>9월  
            <input type="radio" name="month" value="10월"/>10월 
            <input type="radio" name="month" value="11월"/>11월  
            <input type="radio" name="month" value="12월"/>12월 
        </div>
           <br>

        <div class="container">
                            인원&nbsp;
            <input type="radio" name="theNumber" value="여자혼자"/>여자혼자
            <input type="radio" name="theNumber" value="남자혼자"/>남자혼자
            <input type="radio" name="theNumber" value="가족여행"/>가족여행
            <input type="radio" name="theNumber" value="커플"/>커플
            <input type="radio" name="theNumber" value="단체"/>단체
            <input type="radio" name="theNumber" value="여자끼리"/>여자끼리
            <input type="radio" name="theNumber" value="남자끼리"/>남자끼리    
            <input type="radio" name="theNumber" value="친구끼리"/>친구끼리
            <input type="radio" name="theNumber" value="자매끼리"/>자매끼리                        
            <input type="radio" name="theNumber" value="형제끼리"/>형제끼리 
        </div>
         <br>
	         
	</div>

  </section>
  
  	<div id="search">
            <ul class="grid grid3 cf">
				<c:forEach var="pl" items="${list }">
					<c:url var="planDetail" value="planDetail.do">
						<c:param name="postNo" value="${pl.postNo }" />
						<c:param name="postType" value="${pl.postType }" />
						<c:param name="page" value="${pi.currentPage }" />
					</c:url>
					
					
					
	                <li>
	                    	<p class="img">
	                        	<a href="${planDetail }"><img src="${pl.thumbnail }" /></a>
	                    	</p>

	                    	<p class="id">
	                    		${pl.userId }
	                    	</p>
	                    	
	                        <p class="title">
	                    		${pl.title }
	                    	</p>
	                    	<p class="cont">
	                    		<c:set var="liPostNo" value="${pl.postNo }" />
	                    		<c:forEach var="tl" items = "${tl }">
		                    		<c:if test = "${tl.postNo eq liPostNo}">
			                    		<c:out value="# ${tl.tagName } " />
		                    		</c:if>
                    			</c:forEach>
	                    	</p>
	                </li> 	      
	                          
                </c:forEach>
               </ul>   
           </div>
      
      
           
      <div class="pagination">
				<!-- [prev] -->
				<c:if test="${pi.currentPage eq 1 }">
					[prev] 
				</c:if>
				
				<c:if test="${pi.currentPage gt 1 }">
					<c:url var="blistBack" value="planList.do">
						<c:param name="page" value="${pi.currentPage - 1 }" />
					</c:url>
					<a href="${blistBack }">[prev] </a>
				</c:if>
				
				<!-- [pagination] -->
				<c:forEach var="p" begin="${pi.startPage }" end="${pi.endPage }">
					<c:if test="${p eq pi.currentPage }">
						<b>[${p }]</b>
					</c:if>
					
					<c:if test="${p ne pi.currentPage }">
						<c:url var="blistCheck" value="planList.do">
							<c:param name="page" value="${p }"/>
						</c:url>
						<a href="${blistCheck }">${p }</a>
					</c:if>
				</c:forEach>
				
				
				<!-- [next] -->
				<c:if test="${pi.currentPage eq pi.maxPage }">
					 [next]
				</c:if>
				
				<c:if test="${pi.currentPage lt pi.maxPage }">
					<c:url var="blistEnd" value="planList.do">
						<c:param name="page" value="${pi.currentPage + 1 }" />
					</c:url>
					<a href="${blistEnd }"> [next]</a>
				</c:if>	
            </div>      
	</div>
</div>	

<jsp:include page="../common/footer.jsp" />


<script>
   $("#searchTag input[type='radio']").on("change",function(){
		
		var city = $("input[name='city']:checked").val();
		var month = $("input[name='month']:checked").val();
		var theNumber = $("input[name='theNumber']:checked").val();
			console.log(city, month, theNumber);
			
		 $.ajax({
			   url:"conditioncheck.do",
			   type:"post",
			   data: {city:city, month:month, theNumber:theNumber},
			   dataType:"json",
			   success:function(data){
				   console.log(data);

				   
					$ul = $("#search ul");
	    	 	    $ul.html(""); 

					var $li;
   					var $img;   
					var $title;
					var $id;
					    	 		  
    	 	if(data.length > 0){	       	 		   	   
				for(var i in data){
						    	 		   
	     	 		   $li = $("<li>");	    	 		   
    	     	 	   $pimg = $("<p class='img'>");    	     	 	   
    	     	 	   $img = $("<img>").attr("src", data[i].thumbnail);
    	     	 	   $postNo = data[i].postNo;
      				   $postType = data[i].postType; 
    	     	 	   

 	$aurl = $("<a>").attr("href", "${contextPath}/planDetail.do?postNo="+$postNo+"&postType="+$postType+"&page="+${pi.currentPage }); 
			
					   
    	     	 	   $aurl.append($img);
    	     	 	   $pimg.append($aurl);
 	    	 		   $title = $("<p class='title'>").text(data[i].title);
	    	 		   $id = $("<p class='id'>").text(data[i].userId); 
 

	    	 		       	 		   
    	     	 	   $li.append($pimg);     
	    	 		   $li.append($title);
	    	 		   $li.append($id);
	

	    	 		   
	    	 		   $ul.append($li);
					
				  	  }				
    	 	   }else{
    	 		  for(var i in data){
  					   
	     	 		   $li = $("<li>");
	    	 		   
 	     	 		   $img = $("<img>").attr("src", data[i].thumbnail);   
	    	 		   $title = $("<title>").text(data[i].title);
	    	 		   $id = $("<id>").text(data[i].userId); 
					 	
	    	 		       	 		   
 	     	 		   $li.append($img);  
	    	 		   $li.append($title);
	    	 		   $li.append($id);
	    	 		   
	    	 		   $ul.append($li);
    	 		  	
    	 			   $ul.html("");
    	 		 }
    	 	   }
 	 		
    	 	
    	 	
			
			   
				
			},
			   error : function(request, status, errorData){
	               alert("error: " + errorData);
	            }
		  }) 
   });  
      
</script> 
</body>


</html>
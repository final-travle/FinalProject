<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script> 
<style>
  .box-radio-input input[type="radio"]{
    display:none;
}
   .box-radio-input input[type="button"]{
    display:inline-block;
    background:none;
    border:1px solid #dfdfdf;
    border-radius:5px;    
    padding:0px 10px;
    text-align:center;
    height:35px;
    line-height:33px;
    font-weight:500;
    cursor:pointer;		
   }

.box-radio-input input[type="radio"] + span{
    display:inline-block;
    background:none;
    border:1px solid #dfdfdf;
    border-radius:5px;    
    padding:0px 10px;
    text-align:center;
    height:35px;
    line-height:33px;
    font-weight:500;
    cursor:pointer;
}

.box-radio-input input[type="radio"]:checked + span{
    border-radius:5px;
    margin: 0px 6px 6px 0px;
    background:#bd9dec;
    color:#ffffff;
}

.grid { margin:0 auto 140px; }
.img1 { width:100%; height:210px; overflow:hidden; }
.img1 img { width:100%; }
.title1 { text-align:left; font-size:20px; font-weight:700; margin-top:14px; }
.cont1 { text-align:center; margin-top:10px; margin-bottom:14px; overflow:hidden; text-overflow:ellipsis; white-space:nowrap; }
.id1 { text-align:center}


.img2 { width:100%; height:210px; overflow:hidden; }
.img2 img {width:100%; }
.title2 { text-align:left; font-size:20px; font-weight:700; margin-top:14px; }
.cont2 { text-align:center; margin-top:10px; margin-bottom:14px; overflow:hidden; text-overflow:ellipsis; white-space:nowrap; }
.id2 { text-align:center} 


.grid.grid5 li { float:left; width:32.8%; box-sizing:border-box; border:1px solid #ddd; text-align:center; padding:10px; margin:0 3px; margin-bottom: 6px; }
.grid.grid5 li .title1 { text-align:left; font-weight:700; margin-top:14px; }
.grid.grid5 li .title1 a { font-size:20px; font-weight:700;  }
.grid.grid5 li .title2 { text-align:left; font-weight:700; margin-top:14px; }
.grid.grid5 li .title2 a { font-size:20px; font-weight:700;  }  

</style> 
</head>
<body>
<jsp:include page="../common/header.jsp" />

  <div id="container" class="cf">
       <div id="content">
              
  <section class="tagSearch" style="margin-top:0px">
  <br>
        <div class="titleArea">
            <h1 class="titlename">국내 추천 여행지 <font style="font-size:10pt;color:#3ad195">전국 관광지를 조건에 맞게 설정할 수 있어요!</font></h1>
        </div>
        <br>
 	<div id="searchTag" > 

		  <br>
  	       
        <div class="container">
        	<em>지역&nbsp;&nbsp;</em>
        	<label class="box-radio-input"><input type="radio" name="city" value="서울"><span>서울</span></label>
            <label class="box-radio-input"><input type="radio" name="city" value="인천"><span>인천</span></label>
            <label class="box-radio-input"><input type="radio" name="city" value="부산"><span>부산</span></label>
            <label class="box-radio-input"><input type="radio" name="city" value="광주"><span>광주</span></label>
            <label class="box-radio-input"><input type="radio" name="city" value="대전"><span>대전</span></label>
            <label class="box-radio-input"><input type="radio" name="city" value="대구"><span>대구</span></label>
            <label class="box-radio-input"><input type="radio" name="city" value="울산"><span>울산</span></label>
            <label class="box-radio-input"><input type="radio" name="city" value="경기"><span>경기</span></label>
            <label class="box-radio-input"><input type="radio" name="city" value="세종"><span>세종</span></label>
            <label class="box-radio-input"><input type="radio" name="city" value="강원"><span>강원</span></label>
            <label class="box-radio-input"><input type="radio" name="city" value="충북"><span>충북</span></label>
            <label class="box-radio-input"><input type="radio" name="city" value="충남"><span>충남</span></label>
            <label class="box-radio-input"><input type="radio" name="city" value="전북"><span>전북</span></label>
            <label class="box-radio-input"><input type="radio" name="city" value="전남"><span>전남</span></label>
            <label class="box-radio-input"><input type="radio" name="city" value="경북"><span>경북</span></label>
            <label class="box-radio-input"><input type="radio" name="city" value="경남"><span>경남</span></label>
            <label class="box-radio-input"><input type="radio" name="city" value="제주"><span>제주</span></label>
    
        </div>
           <br>

        <div class="container">
            <em>월별&nbsp;&nbsp;</em>
            <label class="box-radio-input"><input type="radio" name="month" value="1월"><span>1월</span></label>
            <label class="box-radio-input"><input type="radio" name="month" value="2월"><span>2월</span></label>
            <label class="box-radio-input"><input type="radio" name="month" value="3월"><span>3월</span></label>
            <label class="box-radio-input"><input type="radio" name="month" value="4월"><span>4월</span></label>
            <label class="box-radio-input"><input type="radio" name="month" value="5월"><span>5월</span></label>
            <label class="box-radio-input"><input type="radio" name="month" value="6월"><span>6월</span></label>
            <label class="box-radio-input"><input type="radio" name="month" value="7월"><span>7월</span></label>
            <label class="box-radio-input"><input type="radio" name="month" value="8월"><span>8월</span></label>
            <label class="box-radio-input"><input type="radio" name="month" value="9월"><span>9월</span></label>
            <label class="box-radio-input"><input type="radio" name="month" value="10월"><span>10월</span></label>
            <label class="box-radio-input"><input type="radio" name="month" value="11월"><span>11월</span></label>
            <label class="box-radio-input"><input type="radio" name="month" value="12월"><span>12월</span></label>
        </div>
           <br>

        <div class="container">
             <em>인원&nbsp;&nbsp;</em>
            <label class="box-radio-input"><input type="radio" name="theNumber" value="여자혼자"><span>여자혼자</span></label>
            <label class="box-radio-input"><input type="radio" name="theNumber" value="남자혼자"><span>남자혼자</span></label>
            <label class="box-radio-input"><input type="radio" name="theNumber" value="가족여행"><span>가족여행</span></label>
            <label class="box-radio-input"><input type="radio" name="theNumber" value="커플"><span>커플</span></label>
            <label class="box-radio-input"><input type="radio" name="theNumber" value="단체"><span>단체</span></label>
            <label class="box-radio-input"><input type="radio" name="theNumber" value="여자끼리"><span>여자끼리</span></label>
            <label class="box-radio-input"><input type="radio" name="theNumber" value="남자끼리"><span>남자끼리</span></label>
            <label class="box-radio-input"><input type="radio" name="theNumber" value="친구끼리"><span>친구끼리</span></label>
            <label class="box-radio-input"><input type="radio" name="theNumber" value="자매끼리"><span>자매끼리</span></label>
            <label class="box-radio-input"><input type="radio" name="theNumber" value="형제끼리"><span>형제끼리</span></label>
        </div>        
		  <br>
		  
		<div class="container">
			<em>조건&nbsp;&nbsp;</em>
			<label class="box-radio-input"><input type="button" value="전체" onclick="location.href='slist.do'"></label>
		</div>
		<br> 

	          
	</div>

  </section>
  
   	  
          
  		
  	<div id="search">  	
  		<div id="content">		   
		   <h2 class="title cont-title"><span class="color">주목해야 할 여행지!</span> 아직도 안 가봤어요?</h2>
           			
            <ul class="grid grid5 cf">
				<c:forEach var="pl" items="${list }">
				
					<c:url var="planDetail" value="planDetail.do">
						<c:param name="postNo" value="${pl.postNo }" />
						<c:param name="postType" value="${pl.postType }" />
						<c:param name="page" value="${pi.currentPage }" />
					</c:url>
					
										
	                <c:if test="${pl.postType eq '3' }">
	                	 <li>
							<p class="cont1">	                    	
	                    	  <c:set var="liPostNo" value="${pl.postNo }" />
	                    		<c:forEach var="tl" items = "${tl }">
		                    		<c:if test = "${tl.postNo eq liPostNo}">
			                    		<c:out value="# ${tl.tagName } " />
		                    			</c:if>
                    			</c:forEach>	
	                    	</p>
	                    	<p class="img1">
	                        	<a href="${planDetail }"><img src="${pl.thumbnail }" /></a>
	                    	</p>
							
						    <p class="title1" id="title1"><a href="${planDetail }">
						    	${pl.title }</a>
						    </p>
							
	                    	<p class="id1">
	                    		${pl.userId }
	                    	</p>	                    	
	                	  </li>
	              	</c:if>  	      	                          
                </c:forEach>
               </ul>
               
           </div>
       </div>  
            
            <br>
            
           <div id ="search2"> 
             <div id="content"> 
               <h2 class="title cont-title">어디 갈 지 고민이라면? <span class="color"> 인증된 여행지!</span></h2>
               
               <ul class="grid grid5 cf">
				<c:forEach var="rl" items="${list }">
					<c:url var="reviewDetail" value="reviewDetail.do">
						<c:param name="postNo" value="${rl.postNo }" />
						<c:param name="page" value="${ri.currentPage }" />
					</c:url>
	                	<c:if test="${rl.postType eq '4' }">
	                <li id="cont222">
						<p class="cont2">
	                    	<c:set var="liPostNo" value="${rl.postNo }" />
	                    	<c:forEach var="tl" items = "${tl }">
		                    	<c:if test = "${tl.postNo eq liPostNo}">
			                    		<c:out value="# ${tl.tagName } " />
		                    	</c:if>
                    		</c:forEach>	                    	                    
	                    </p>	
	                    <p class="img2">
	                        <a href="${reviewDetail }"><img src="${rl.thumbnail }" /></a>
	                    </p>
	                    <p class="title2"><a href="${reviewDetail }">
	                    	${rl.title }</a>
	                    </p>
	                     <p class="id2">
	                    	${rl.userId }
	                    </p>
	                  </li>
	                    </c:if>
                </c:forEach>
               </ul>  
                   
         </div>
       </div>        
    
      	</div>
</div>	  

<br><br>
  

<jsp:include page="../common/footer.jsp" />






<script>
  	 $("#searchTag input[type='radio']").on("change", function() {
  		  
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
				   
					$ul = $("#search ul");
				    $ul2 = $("#search2 ul");
	    	 	    $ul.html(""); 
					
	    	 	    $ul2.html("");
	    	 	   
					var $li;
  					var $img;   
					var $title;
					var $id;
					var $cont;
					var $contWrap = $("<p class='tagWrap2'>"); 
					
					
  					var $img2;   
					var $title2;
					var $id2;
					var $cont2;
					var $contWrap2 = $("<p class='tagWrap2'>");
			
					
   	 		if(data[0].length > 0){	       	 		   	   
				for(var i in data[0]){
   	     	 	   $postNo = data[0][i].postNo;
     			   $postType = data[0][i].postType;
     			   
     		
     			   
     			  						    	 		    
	     	 	   $li = $("<li>");	
	     	 	   
   	     	 	   $pimg = $("<p class='img1'>");    	     	 	   
   	     	 	   $img = $("<img>").attr("src", data[0][i].thumbnail);   	     	 	       			   
	    	 	   $title = $("<p class='title1'>").text(data[0][i].title);  
	    	 	   $id = $("<p class='id1'>").text(data[0][i].userId);
	    	 	   
	    	 	   
    	 		   
   	     	 	   $pimg2 = $("<p class='img2'>");    	     	 	   
   	     	 	   $img2 = $("<img>").attr("src", data[0][i].thumbnail);   	     	 	       			   
	    	 	   $title2 = $("<p class='title2'>").text(data[0][i].title); 	    	 	   
	    	 	   $id2 = $("<p class='id2'>").text(data[0][i].userId);
	    	 	   
	    	 	   
	    	 	   	
	    	 	   	
		    	   
	    	 	   			     			   
    	 		   for(var j in data[1]){
    	 			   
/*      	 			$tagName = data[1][j].tagName;
    	 			   console.log($tagName);  */
    	 			       	 			   
    	 			   if(data[1][j].postNo == data[0][i].postNo){
    	 				 
    	 				 if($postType == '3' ){
    	 				   
    	 				  $aurl = $("<a>").attr("href", "${contextPath}/planDetail.do?postNo="+$postNo+"&postType="+$postType+"&page="+${pi.currentPage }); 
    	 				
    	 				  $cont = $("<span class='cont1'>").text("#" + data[1][j].tagName +   " ");
													  
    	 				    
   		    	 			$contWrap.append($cont); 		    	 		    
  		    	 		    $li.append($cont);
		    	 		    $li.append($contWrap);     
		    	 		    
    	   	     	 	   	$aurl.append($img);
    	   	     	 	   	$pimg.append($aurl);
	 		       	 		   
    	   	     	 	   	$li.append($pimg);     
    		    	 		$li.append($title);
    		    	 		$li.append($id);
    		    	 		    		    	 		
 		    	 		  $li.css({"text-align":"center","margin-top":"10px","margin-bottom":"14px","overflow":"hidden","text-overflow":"ellipsis","white-space":"nowrap"});

    		    	 	    $ul.append($li);
    	 		
    		    	 		    	 				    	 				   
    	 				 }else if($postType == '4'){
    	 					
    	 					$aurl2 = $("<a>").attr("href", "${contextPath}/reviewDetail.do?postNo="+$postNo+"&postType="+$postType+"&page="+${pi.currentPage }); 
        	 				
      	 				 	$cont2 = $("<span class='cont2'>").text("#" + data[1][j].tagName +    " ");
	
       	 					$contWrap2.append($cont2);       	 					
      	 					$li.append($cont2);
       	 					$li.append($contWrap2); 
       	 					
      	 				 	
      	   	     	 	   	$aurl2.append($img2);
      	   	     	 	   	$pimg2.append($aurl2);
  	 		       	 		   
      	   	     	 	   	$li.append($pimg2);     
      		    	 		$li.append($title2);

      		    	 		$li.append($id2);
      		    	 		 		    	
 		    	 		    $li.css({"text-align":"center","margin-top":"10px","margin-bottom":"14px","overflow":"hidden","text-overflow":"ellipsis","white-space":"nowrap"});

      		    	 		$ul2.append($li);
      		    	 		
    	 				 }
    	 				 
    	 				 
    	 				     		    	 	    	 				   
    	 			   	}
    	 			   
    	 		  	  }
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
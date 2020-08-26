<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 글쓰기</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<style>
	#write .content_wrap{width:1000px; margin:50px auto 0 auto; padding:30px; background:lightgray; border-radius:5px;}
	#write .content_wrap .form_title{margin-bottom:40px; font-size:24px; font-weight:700; color:#ea657b;}

	input, textarea, button, a{font-family:'Noto Sans Korean','Malgun Gothic','맑은고딕','돋움',dotum, sans-serif; font-size:16px; color:#919090; line-height:1.5; letter-spacing:0; vertical-align:middle; border:none;}
	.formlist ul li{margin-bottom:15px; }
	.formlist ul li label { display:inline-block; width:20%; }
	.formlist ul li .textbox { display:inline-block; width:70%; } 
	.formlist ul li .textbox input,
	.formlist ul li .textbox textarea { width:100%; box-sizing: border-box; resize: none; }
	.formlist ul li .textbox1 input { max-width:100%; height:auto;}

	li { list-style: none; padding:0; margin:0; }

	.btn_box{width:100%; margin-top:20px; text-align:center;}  
</style>
</head>
<body>
	<jsp:include page="../common/header.jsp"/>
	
	<section id="write" class="content">
    
    <br><br><br>
    
    <h1 align="center">공지사항 </h1>
    
        <div class="conbox">
        <section class="content_wrap">
        <h3 class="form-title"></h3>
        	<form action="ninsert.do" class="nform" method="POST" enctype="Multipart/form-data" accept-charset="UTF-8">
            	<fieldset>
                 	<legend></legend>
                 	<div class="formlist">
                   <ul>
                     <li>
                       <label for="name" >제목</label>
                       <span class="textbox"><input type="text" id="title" name="title" required placeholder="제목을 입력하여 주세요" /></span>
                     </li>
                     <li>
                       <label for="name" >작성자 <sup>*</sup></label>
                       <span class="textbox"><input type="text" id="userId" name="userId" readonly value="${loginUser.id }" /></span>
                     </li>
                     <!-- jsp페이지에 <textarea>, <input type="text">와 같은 곳 위에 선언해주는 코드. -->
                     <script>
                     	$('#text').val().replace(/\n/g, "<br>")
                     </script>
                     <li>
                       <label for="message">내용<sup>*</sup></label>
                       <span class="textbox">
                         <textarea id="text" rows="5" name="postContents" placeholder="내용을 작성해 주세요" required></textarea>
                       </span>
                     </li>
                     
                     <li>
                        <label for="email">첨부</label>
                        <span class="textbox1"><input type="file" id="file" name="uploadFile"></span>
                      </li>
                   </ul>
                   <br><br>
                   <div class="btn_box">
                       <button type="submit" class="commbtn gray" value="등록하기">등록</button>
                       <button type="reset" class="combtn gray" value="취소하기">취소</button>
                   </div>
                 </div>
             </fieldset>
         </form>
        </section>
    </div>
    	
    	<br><br>
    	<p align="center">
    		<em><a href="home.do">Home&nbsp;&nbsp;</a></em>
    		<em><a href="nlist.do">공지사항</a></em>
    	</p>
</section>


    <br><br><br>
    	
    	
			<jsp:include page="../common/footer.jsp"/>

</body>
</html>
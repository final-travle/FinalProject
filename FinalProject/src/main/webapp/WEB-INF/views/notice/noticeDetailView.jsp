<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

 *{
    margin: 0;
    padding: 0;
    line-height: 1.2em;
}
.customerWrap {
    width: 100%;
    background-color: #f9f9f9;
}
.customerContents {
    min-width: 566px;
    max-width: 826px;
    min-height: 750px;
    padding-left: 116px;
    padding-right: 116px;
    padding-top: 40px;
    padding-bottom: 26px;
    margin: 0 auto;
    position: relative;
}
.viewWrap .titleWrap {
    padding-bottom: 14px;
    border-bottom: 1px solid #bfbfbf;
    position: relative;
}

.viewWrap .titleWrap .status {
    padding-top: 6px;
}

.clearfix {
    min-height: 1px;
}

.viewWrap .titleWrap .status p:first-child {
    padding-left: 0;
}

    .viewWrap .titleWrap .tit {
    font-size: 24px;
    font-weight: 400;
    text-align: center;
    color: #404040;
}

p {
    display: block;
    margin-block-start: 1em;
    margin-block-end: 1em;
    margin-inline-start: 0px;
    margin-inline-end: 0px;
    text-align: center;
}

.viewWrap .titleWrap .status p:first-child {
    padding-left: 0;
}

.viewWrap .titleWrap .status p {
    text-align: center;
    height: 11px;
    padding-left: 8px;
    padding-right: 9px;
    position: relative;
    font-size: 11px;
    color: #808080;
    font-family: '돋움',Dotum,'Apple SD Gothic Neo',Helvetica,sans-serif !important;
}
 div{
     display: block;
 }
</style>
        
</head>
<body>
	
	<jsp:include page="../common/header.jsp"/>


	
  <div class="contentsDefaultWrap"> 
    <div class="customerWrap"> 
        <div class="customerContents"> 
            <!-- 공지사항 뷰 --> 
 
            <div class="viewWrap"> 
                <div class="viewWrap"> 
                    <div class="titleWrap"> 
                        <div class="tit">${notice.title }</div><br>
                        	<div class="status clearfix"> 
                            	<p style="text-align: center" align="center">작성일 :${notice.writeDate }<span></span></p><br> 
                            	<p style="text-align: center" align="center">작성자: ${notice.userId }<span></span></p><br>
                            	<p style="text-align: center" align="center">조회수: ${notice.hits }<span></span></p><br>  
                            </div>
                  	    </div>
         
       		    
       		     	<div class="editorView"> 
       		     		<br>
                         <p style="text-align: center; " align="center"><span style="font-family: 나눔고딕, NanumGothic, sans-serif; font-size: 18pt; color: rgb(247, 77, 172); "><b>${notice.title }</b></span></p>
                         <p style="text-align: center;" align="center">&nbsp;</p>
                         <p style="text-align: center;" align="center">&nbsp;</p>
                         
                         <c:if test="${!empty notice.fileName }">
                         <div style="text-align: center;" align="center">
                         	<img src="${contextPath }/resources/nuploadFiles/${notice.fileName }" /><br style="clear:both;"><br>
                         </div>
                         </c:if>

                         <c:if test="${empty notice.fileName }">
                         	<div style="text-align: center;" align="center">
                         		&nbsp;
                         	</div>
                         </c:if>
                         
                         
                        <div style="text-align: center;" align="center">&nbsp;</div>   
                        	<p style="text-align: center; " align="center">&nbsp;</p>    
                        	<!-- DB에서 값 조회하여 jsp에 보여질 때. -->
                        	<%
                        		pageContext.setAttribute("crcn", "\r\n");
                        		pageContext.setAttribute("br", "<br/>");
                        	%>              		
                        	<p style="text-align: center; " align="center"><span style="font-size: 15pt; font-family: 나눔고딕, NanumGothic, sans-serif;">${fn:replace(notice.postContents, crcn, br) }</span></p>
                      
       		    	 </div> 
       	    	</div>
         	</div>
    	</div>
   	</div>
</div>
       		    
		<br><br>    			
    			<table>
	   				<tr>
						<td colspan="2" align="center">
			
						<c:url var="nupView" value="nupView.do">
							<c:param name="postNo" value="${notice.postNo }"/>
							<c:param name="page" value="${currentPage }"/>
						</c:url>		
		
						<c:url var="ndelete" value="ndelete.do">
							<c:param name="postNo" value="${notice.postNo }"/>
						</c:url>
						
						<c:url var="nlist" value="nlist.do">
							<c:param name="page" value="${currentPage }"/>
						</c:url>
	
				
						<c:if test="${loginUser.id eq 'master' }">		
							<ul class="actions">
								<li><a href="${nupView }">글 수정하기</a></li>
								<li><a href="${ndelete }">글 삭제하기</a></li>
								<li><a href="nlist.do">목록으로</a></li>
							</ul>
						</c:if>
						
						<c:if test="${empty loginUser.id }">		
							<ul class="actions">
								<li><a href="nlist.do">목록으로</a></li>
							</ul>
						</c:if>
						
					</td>
				</tr>
			</table>

		
			<br><br><br>
	
                   
   			
			<jsp:include page="../common/footer.jsp"/>
        
        
    </body>
</html>             
		

	
	
	

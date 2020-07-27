<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>OrderInfo Detail</title>
<style>
        #order_manage{margin-left:200px; width:1200px;}
        #order_table {
            border-top: 2px solid grey;
            border-collapse: collapse;
            border-botton:1px solid white;
            margin: 0 auto;
  			width: 1200px;
        }

        #order_table tr { border-bottom: 1px solid grey; }

        #order_table th { width:300px; padding:5px; padding-left:10px;text-align:left; }


        #order_table td { width:900px;padding:5px; padding-left:10px; text-align:left; }
    
    	#backBtn{
    	margin-top:20px;
    	margin-left:1100px;
    	border:0;
    	background:grey;
    	height: 50px; 
    	border-radius: 10px; 
    	width:100px; 
    	font-size:large;
    	font-weight:600;
    	color:white;
    	cursor:pointer;
    	 }
    	 #lastTr{border-botton:1px solid white;}
    </style>
</head>
<body>
	
	
	<h1 align="center">주문관리</h1>
    <div id="order_manage">
        <table id="order_table">
       		 <tr>
                <th>회원아이디</th>
                <td><c:out value="${member.id}"/></td>
            </tr>
            <tr>
                <th>비밀번호</th>
                <td><c:out value="${member.pwd}"/></td>
            </tr>
             <tr>
                <th>이름</th>
                <td><c:out value="${member.name}"/></td>
            </tr>
             <tr>
                <th>닉네임</th>
                <td><c:out value="${member.nicname}"/></td>
            </tr>
             <tr>
                <th>여행스타일</th>
                <td><c:out value="${type}"/></td>
            </tr>
             <tr>
                <th>이메일</th>
                <td><c:out value="${member.email}"/></td>
            </tr>
             <tr>
                <th>핸드폰 번호</th>
                <td><c:out value="${member.email}"/></td>
            </tr>
             <tr>
                <th>생년월일</th>
                <td><c:out value="${member.birth}"/></td>
            </tr>
             <tr>
                <th>성별</th>
                <td><c:out value="${member.gender}"/></td>
            </tr>
        </table>
		<button id="backBtn" onclick="location.href='<%=request.getContextPath() %>/admin/orderInfo'">돌아가기</button>	
	</div>

</body>
</html>
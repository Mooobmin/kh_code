<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<%
	String name=(String)request.getAttribute("name");
	String age=(String)request.getAttribute("age");
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
				
		<title>request 내장 객체 테스트</title>
	
		<link rel="shortcut icon" href="../image/icon.png" />
		<link rel="apple-touch-icon" href="../image/icon.png" />
		
		<!--[if lt IE 9]>
		<script src="../js/html5shiv.js"></script>
		<![endif]-->	
	</head>
	<body>
		<h3>이름은 <%=name %>입니다.</h3>
		<h3>주소는 <%=age %>입니다.</h3>
	</body>
</html>
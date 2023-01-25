<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<% String message = (String)request.getAttribute("message"); %>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />		
		<title>에러 페이지</title>
		
		<!-- 모바일 웹 페이지 설정 -->
		<link rel="shortcut icon" href="../image/icon.png" />
		<link rel="apple-touch-icon" href="../image/icon.png" />
		<!-- 모바일 웹 페이지 설정 끝 -->
		
		<!--IE8이하 브라우저에서 HTML5를 인식하기 위해서는 아래의 패스필터를 적용하면 된다.--> 
		<!--[if lt IE 9]>
		<script src="../js/html5shiv.js"></script>
		<![endif]-->
		<style type="text/css">
			a{text-decoration: none;}
		</style>	
		<script type="text/javascript" src="../js/jquery-3.6.2.min.js"></script>
	</head>
	<body>
		<h1><%= message %></h1>
		<div>
			<button type="button" onclick="history.back();">이전 페이지로 이동</button>
			<button type="button" onclick="location.href='<%=request.getContextPath()%>/boardList'">홈으로 돌아가기</button>
		</div>
	</body>
</html>
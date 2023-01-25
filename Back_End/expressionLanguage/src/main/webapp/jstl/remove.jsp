<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
				
		<title>JSTL Core : remove</title>
	
		<link rel="shortcut icon" href="../image/icon.png" />
		<link rel="apple-touch-icon" href="../image/icon.png" />
		
		<!--[if lt IE 9]>
		<script src="../js/html5shiv.js"></script>
		<![endif]-->	
	</head>
	<body>
		<h2>JSTL Core Tag : remove</h2>
		<c:set var = "str" value="Hello set Tag!!!" scope="session"/>
		\${str} = ${str} <br>
		\${sessionScope.str} = ${sessionScope.str} <br>
		
		<c:remove var="str" scope="page"/>
		\${str} = ${str} <br>
		
		<c:remove var="str" scope="session"/>
		\${str} = ${str} <br>
		
		<c:set var="app" value="응용프로그램변수" scope="application"/>
		\${app} = ${app} <br>
		
		<c:remove var="app"/>
		\${app} = ${app} <br>
	</body>
</html>
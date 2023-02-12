<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		
		<title>exam02 문서</title>
		
		<link rel="shortcut icon" href="/resources/image/icon.png" />
		<link rel="apple-touch-icon" href="/resources/image/icon.png" />
		
		<!--[if lt IE 9]>
		<script src="/resources/js/html5shiv.js"></script>
		<![endif]-->	
	</head>
	<body>
		<!-- 모델에 담았을때 -->
		<%-- <div>
			<label>이름</label> ${dto.name} <br />
			<label>나이</label> ${dto.age} <br />
		</div> --%>
		<!-- 모델에 안담았을때 -->		
		<div>
			<label>이름</label> ${sampleDTO.name} <br />
			<label>나이</label> ${sampleDTO.age} <br />
		</div>						
	</body>
</html>
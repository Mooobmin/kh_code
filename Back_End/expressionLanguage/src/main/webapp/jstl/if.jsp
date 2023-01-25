<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
				
		<title>JSTL Core : if</title>
	
		<link rel="shortcut icon" href="../image/icon.png" />
		<link rel="apple-touch-icon" href="../image/icon.png" />
		
		<!--[if lt IE 9]>
		<script src="../js/html5shiv.js"></script>
		<![endif]-->	
	</head>
	<body>
		<h3>JSTL Core Tag : if</h3>
		<c:set var="num" value="95"/>
		점수 ${num}은
		<c:if test="${num > 60}" var="result">
			합격입니다.<br />
		</c:if>
		if문의 결과 : ${result} <br />
		
		<c:set var="number" value="4"/>
			숫자 ${number}
		<c:if test="${number mod 2 != 0}">
			홀수
		</c:if>
		입니다 <br />
		<hr />
		
		<h3>JSTL Core Tag : choose</h3>
		<%-- <c:set var="today" value="<%= new java.util.Date()%> /> --%>
		<jsp:useBean id="today" class="java.util.Date"/>
		<c:choose>
			<c:when test="${today.hours <12}">
				Good morning!
			</c:when>
			<c:when test="${today.hours <18}">
				Good afternoon!
			</c:when>
			<c:otherwise>
				Good evening!
			</c:otherwise>
		</c:choose>
		<hr />
		
		<c:set var="jumsu" value="${param.jumsu}"/>
		점수 : <c:out value="${junsu}" default="0"/> 점 / 학점 : 
		<c:choose>
			<c:when test="${junsu >90}">
				A
			</c:when>
			<c:when test="${junsu >80}">
				B
			</c:when>
			<c:when test="${junsu >70}">
				C
			</c:when>
			<c:when test="${junsu >60}">
				D
			</c:when>
			<c:otherwise>
				F
			</c:otherwise>
		</c:choose>
		학점.
		
		<h3>JSTL Core Tag : if와 choose</h3>
		<c:if test="${empty param.name and empty param.age }">
			<h3>name=xxx &amp; age=xxx 형식으로 Query 문자열을 전달하세요...</h3>
		</c:if>
		
		<c:if test="${not empty param.name and empty param.age }">
			<c:if test="${param.name == 'java' }">
				name 파라미터의 값이 ${param.name} 입니다. <br />
			</c:if>
			
			<c:if test="${param.age>=30}">
				당신의 나이는 30세 이상입니다.
			</c:if>
			<hr />
			
			<ul>
			<c:choose>
				<c:when test="${param.name == 'java'}">
					<li> 당신의 이름은 ${param.name} 입니다.</li>
				</c:when>
				<c:when test="${param.age >= 30}">
					<li> 당신은 30세 이상입니다.</li>
				</c:when>
				<c:otherwise>
					<li> 당신은 'java'도 아니고 30세 이상도 아닙니다.
				</c:otherwise>
			</c:choose>
			</ul>
		</c:if>
	</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
				
		<title>내정보 관리</title>
	
		<link rel="shortcut icon" href="../image/icon.png" />
		<link rel="apple-touch-icon" href="../image/icon.png" />
		
		<!--[if lt IE 9]>
		<script src="../js/html5shiv.js"></script>
		<![endif]-->	
		
		<link rel="stylesheet" type="text/css" href="/include/dist/css/bootstrap.min.css"/>
		<link rel="stylesheet" type="text/css" href="/include/dist/css/bootstrap-theme.css"/>
				
		<script type="text/javascript" src="/include/js/jquery-1.12.4.min.js"></script>
		<script type="text/javascript" src="/include/js/common.js"></script>
		<script type="text/javascript" src="/include/dist/js/bootstrap.min.js"></script>
		
	</head>
	<body>
		<div class="container">
			<div class="text-center"><h3>마이 페이지</h3></div>
			<form name="f_data" id="f_data" method="post">
				<input type="hidden" name="id" value="${mypage.id}">
			</form>
				
				<div class="col-md-12 text-right">
					<button type="button" id="updateForm" class="btn btn-primary btn-sm">수정</button>
					<button type="button" id="boardDelete" class="btn btn-primary btn-sm">삭제</button>
				</div>
			</div>
			
			<%-- =============상세정보 보여주기 시작============= --%>
			<div class="text-center">
				<table class="table table-bordered">
					<tbody>
						<tr>
							<td class="col-md-3">이름</td>
							<td class="col-md-3 text-left">${mypage.name} <label>(성별 : ${mypage.gender})</label></td>
							<td class="col-md-3">가입일</td>
							<td class="col-md-3 text-left">${mypage.regdate}</td>
						</tr>
						<tr>
							<td class="col-md-3">아이디</td>
							<td colspan="3" class="col-md-9 text-left">${mypage.id}</td>
						</tr>
						<tr>
							<td class="col-md-3">비밀번호</td>
							<td colspan="3" class="col-md-9 text-left">${mypage.passwd}</td>
						</tr>
					</tbody>
				</table>
			</div>
			<%-- =============상세정보 보여주기 종료============= --%>
		</div>	
	</body>
</html>
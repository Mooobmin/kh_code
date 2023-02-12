<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		
		<title>시작페이지</title>
		
		<link rel="shortcut icon" href="/resources/image/icon.png" />
		<link rel="apple-touch-icon" href="/resources/image/icon.png" />
		
		<!--[if lt IE 9]>
		<script src="/resources/js/html5shiv.js"></script>
		<![endif]-->
		
		<link rel="stylesheet" href="/resources/dist/css/bootstrap.min.css" />
		<link rel="stylesheet" href="/resources/dist/css/bootstrap-theme.min.css" />
		<style type="text/css">
			form{margin-bottom: 30px;}
			div#list{display: none;}
		</style>
		<script type="text/javascript" src="/resources/js/jquery-1.12.4.min.js"></script>
		<script type="text/javascript" src="/resources/dist/js/bootstrap.min.js"></script>
		<script type="text/javascript">
			$(function(){
				$("#exam01Btn").click(function(){
					$("#exam01Form").attr({
						method : "get",
						action :"/sample/exam01"
					});
					$("#exam01Form").submit();
				});
				$("#exam02Btn").click(function(){
					$("#exam01Form").attr({
						method : "get",
						action :"/sample/exam02"
					});
					$("#exam01Form").submit();
				});
				$("#exam02ListBtn").click(function(){
					$("#exam02ListForm").attr({
						method : "get",
						action :"/sample/exam02List"
					});
					$("#exam02ListForm").submit();
				});
				$("#exam02ArrayBtn").click(function(){
					$("#exam02ArrayForm").attr({
						method : "get",
						action :"/sample/exam02Array"
					});
					$("#exam02ArrayForm").submit();
				});
				$("#exam02BeanBtn").click(function(){
					$("#exam02BeanForm").attr({
						method : "get",
						action :"/sample/exam02Bean"
					});
					$("#exam02BeanForm").submit();
				});
				$("#exam03Btn").click(function(){
					$("#exam03Form").attr({
						method : "get",
						action :"/sample/exam03"
					});
					$("#exam03Form").submit();
				});
				
			});
		</script>
	</head>
	<body>
		<div class="container">
			<div class="text-center"><h3>웹 MVC 관련 예제</h3></div>
			<!-- 폼태그 여러개를 생성하고자 합니다. -->
			<h5>매개변수 처리 예제</h5>
				<form id="exam01Form" class="form-inline">
					<div class="form-group">
						<label class="sr-only">이름</label>
						<input type="text" class="form-control" name="name" id="name" placeholder="이름 입력"/>
					</div>
					<div class=form-group>
						<label class="sr-only">나이</label>
						<input type="text" class="form-control" name="age" id="age" placeholder="나이 입력"/>
					</div>
					<button type="button" id="exam01Btn" class="btn btn-success">exam01 예제 확인</button>
					<button type="button" id="exam02Btn" class="btn btn-success">exam02 예제 확인</button>
				</form>
				<hr />
			<h5>매개변수 값을 List타입에 대입 예제</h5>
				<form id="exam02ListForm">
					<label class="checkbox-inline">
						<input type="checkbox" name="language" value="java"> java
					</label>
					<label class="checkbox-inline">
						<input type="checkbox" name="language" value="jsp"> jsp
					</label>
					<label class="checkbox-inline">
						<input type="checkbox" name="language" value="oracle"> oracle
					</label>
					<label class="checkbox-inline">
						<input type="checkbox" name="language" value="spring"> spring
					</label>
					<label class="checkbox-inline">
						<input type="checkbox" name="language" value="jquery"> jquery
					</label>
					<button type="button" id="exam02ListBtn" class="btn btn-success">exam02ListBtn 예제 확인</button>
				</form>	
				<hr />
			<h5>매개변수 값을 배열(Array) 처리 예제</h5>
				<form id="exam02ArrayForm">
					<label class="checkbox-inline">
						<input type="checkbox" name="hobby" value="여행"> 여행
					</label>
					<label class="checkbox-inline">
						<input type="checkbox" name="hobby" value="영화, 드라마 감상"> 영화, 드라마 감상
					</label>
					<label class="checkbox-inline">
						<input type="checkbox" name="hobby" value="운동"> 운동
					</label>
					<label class="checkbox-inline">
						<input type="checkbox" name="hobby" value="독서"> 독서
					</label>
					<label class="checkbox-inline">
						<input type="checkbox" name="hobby" value="맛집 탐방"> 맛집 탐방
					</label>
					<button type="button" id="exam02ArrayBtn" class="btn btn-success">exam02ArrayBtn 예제 확인</button>
				</form>
				<hr />
			<h5>매개변수 값을 배열(Array) 처리 예제</h5>
				<form id="exam02BeanForm" class="form-inline">
					<div class="form-group">
						<label class="sr-only">이름</label>
						<input type="text" class="form-control" name="list[0].name" id="list[0].name" placeholder="이름 입력"/>
					</div>
					<div class="form-group">
						<label class="sr-only">나이</label>
						<input type="text" class="form-control" name="list[0].age" id="list[0].age" placeholder="나이 입력"/>
					</div>			
					
					<div class="form-group">
						<label class="sr-only">이름</label>
						<input type="text" class="form-control" name="list[1].name" id="list[1].name" placeholder="이름 입력"/>
					</div>
					<div class="form-group">
						<label class="sr-only">나이</label>
						<input type="text" class="form-control" name="list[1].age" id="list[1].age" placeholder="나이 입력"/>
					</div>							
					<button type="button" id="exam02BeanBtn" class="btn btn-success">exam02BeanBtn 예제 확인</button>
				</form>		
				<hr />	
			<h5>DTO와 일반 매개변수 값 처리 예제</h5>
				<form id="exam03Form" class="form-inline">
					<div class="form-group">
						<label class="sr-only">이름</label>
						<input type="text" class="form-control" name="name" id="name" placeholder="이름 입력"/>
					</div>
					<div class="form-group">
						<label class="sr-only">나이</label>
						<input type="text" class="form-control" name="age" id="age" placeholder="나이 입력"/>
					</div>			
					<div class="form-group">
						<label class="sr-only">상품번호</label>
						<input type="text" class="form-control" name="number" id="number" placeholder="상품번호 입력"/>
					</div>
					<button type="button" id="exam03Btn" class="btn btn-success">exam03Btn 예제 확인</button>
				</form>		
				<hr />							
		</div> 
	</body>
</html>
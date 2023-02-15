<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>        
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		
		<title>학과 정보 입력</title>
		
		<link rel="shortcut icon" href="/resources/image/icon.png" />
		<link rel="apple-touch-icon" href="/resources/image/icon.png" />
		
		<!--[if lt IE 9]>
		<script src="../js/html5shiv.js"></script>
		<![endif]-->
		<link rel="stylesheet" type="text/css" href="/resources/dist/css/bootstrap.min.css"/>
		<link rel="stylesheet" type="text/css" href="/resources/dist/css/bootstrap-theme.css"/>
		
		<script type="text/javascript" src="/resources/js/jquery-1.12.4.min.js"></script>
		<script type="text/javascript" src="/resources/js/common.js"></script>
		<script type="text/javascript" src="/resources/dist/js/bootstrap.min.js"></script>	
		<script type="text/javascript">
		$(function(){
				$("#insertBtn").click(function(){
					if(!chkData("#s_num", "학과번호를")) return;
					else if(!chkData("#s_name", "학과명을")) return;
					else{
						$("#insertForm").attr({
							"method" : "get",
							"action" : "/subject/subjectInsert"
						});
						$("#insertForm").submit();
					}
				});
				
				$("#cancelBtn").click(function(){
					$("#insertForm").each(function(){
						this.reset();
					});
				});
		});					
		</script>				
	</head>
	<body>
		<div class="col-xs-12">
			<div class="text-center"><h3>학과정보 입력</h3></div>
			<form id="insertForm">
				<table class="table table-striped">
					<tbody>
						<tr>
							<td>학과번호</td>
							<td class="text-left"><input type="text" class="form-control" id="s_num" name="s_num" placeholder="학과번호 입력"></td>
						</tr>
						<tr>
							<td>학과명</td>
							<td><input type="text" class="form-control" id="s_name" name="s_name" placeholder="학과명 입력"></td>
						</tr>
					</tbody>
				</table>
			</form>
			<div class="text-right">
				<button type="button" class="btn btn-success" id="insertBtn">저장</button>
				<button type="button" class="btn btn-success" id="cancelBtn">취소</button>
			</div>
		</div>				 
	</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jspf" %>
	<script type="text/javascript">
		$(function(){
			
		});
	</script>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		
		<title>Insert title here</title>
		
		<link rel="shortcut icon" href="/resources/image/icon.png" />
		<link rel="apple-touch-icon" href="/resources/image/icon.png" />
		
		<!--[if lt IE 9]>
		<script src="../js/html5shiv.js"></script>
		<![endif]-->	
	</head>
	<body>
		<div class="contentContainer container">
			<div class="contentTB text-center">
				<form id="f_updateForm" name="f_updateForm">
					<input type="hidden" id="b_num" name="b_num" value="${updateData.b_num}"/>
					
					<table class="table table-bordered">
						<tbody>
							<tr>
								<td class="col-md-3">글번호</td>
								<td class="text-left col-md-3">${updateData.b_num}</td>
								<td class="col-md-3">작성일</td>
								<td class="text-left col-md-3">${updateData.b_date}</td>
							</tr>
							<tr>
								<td>작성자</td>
								<td colspan="3" class="text-left">${updateData.b_name}</td>
							</tr>
							<tr>
								<td>글제목</td>
								<td colspan="3" class="text-left">
									<input type="text" name="b_title" id="b_title" value="${updateData.b_title}" class="form_control"/>
								</td>
							</tr>
							<tr class="table-tr-height">
								<td>내용</td>
								<td colspan="3" class="text-left">
									<textarea name="b_content" id="b_content" class="form_control" row="8">${updateData.b_content}</textarea>
								</td>
							</tr>
							<tr class="form-inline">
								<td>비밀번호</td>
								<td colspan="3" class="text-left">
									<input type="password" name="b_pwd" id="b_pwd" class="form-control" maxlength="18"/>
									<label>수정할 비밀번호를 입력해 주세요.</label>
								</td>
							</tr>					
						</tbody>
					</table>
				</form>
			</div>
		</div>
	</body>
</html>
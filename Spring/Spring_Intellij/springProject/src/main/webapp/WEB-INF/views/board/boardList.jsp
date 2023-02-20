<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		
		<title>Insert title here</title>
		
		<link rel="shortcut icon" href="/resources/image/common/icon.png" />
		<link rel="apple-touch-icon" href="/resources/image/common/icon.png" />
		
		<!--[if lt IE 9]>
		<script src="../js/html5shiv.js"></script>
		<![endif]-->	
		<link rel="stylesheet" type="text/css" href="/resources/include/dist/css/bootstrap.min.css"/>
		<link rel="stylesheet" type="text/css" href="/resources/include/dist/css/bootstrap-theme.css"/>
		
		<script type="text/javascript" src="/resources/include/js/jquery-1.12.4.min.js"></script>
		<script type="text/javascript" src="/resources/include/js/common.js"></script>
		<script type="text/javascript" src="/resources/include/dist/js/bootstrap.min.js"></script>
		<script type="text/javascript">
			$(function(){
				$("#insertFormBtn").click(function(){
					location.href="/board/writeForm";
				});
				
				$(".goDetail").click(function(){
					let b_num = $(this).parents("tr").attr("data-num");
					$("#b_num").val(b_num);
					console.log("글번호 : " + b_num);
					//상세페이지로 이동하기 위해 form 추가 (id : detailForm)					
					$("#detailForm").attr({
						"method" : "get",
						"action" : "/board/boardDetail"
					});
					$("#detailForm").submit();
				});
			});
		</script>

	</head>
	<body>
		<%-- ====================리스트 시작==================== --%>
		<div class="contentContainer container">
		
			<form id="detailForm">
				<input type="hidden" id="b_num" name="b_num" />
			</form>		
			<table summary="게시판 리스트" class="table table-striped">
				<thead>
					<tr>
						<th data-value="b_num" class="order text-center col-md-1">글번호</th>
						<th class="text-center col-md-4">글제목</th>
						<th class="text-center col-md-2">작성자</th>
						<th data-value="b_date" class="text-center col-md-1">작성일</th>
					</tr>
				</thead>
				<tbody id="list" class="table-striped">
					<!-- 데이터 출력 -->
					<c:choose>
						<c:when test="${not empty boardList}">
							<c:forEach var="board" items="${boardList}" varStatus="status">
								<tr class="text-center" data-num="${board.b_num}">
									<td>${board.b_num}</td>
									<td class="goDetail text-left">${board.b_title}</td>
									<td class="name">${board.b_name}</td>
									<td class="text-left">${board.b_date}</td>
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<tr>
								<td colspan="4" class="tac text-center">등록된 게시글이 존재하지 않습니다.</td>
							</tr>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
		</div>
		<%-- ====================리스트 종료==================== --%>
		<%-- ====================글쓰기 버튼 출력==================== --%>
		<div class="contentBtn text-right">
			<input type="button" value="글쓰기" id="insertFormBtn" class="btn btn-success">
		</div>
		<%-- ====================글쓰기 버튼 출력 종료==================== --%>
	</body>
</html>
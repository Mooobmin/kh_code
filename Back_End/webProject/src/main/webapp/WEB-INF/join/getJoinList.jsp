<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
				
		<title>관리자 페이지</title>
	
		<link rel="shortcut icon" href="../image/icon.png" />
		<link rel="apple-touch-icon" href="../image/icon.png" />
		
		<!--[if lt IE 9]>
		<script src="../js/html5shiv.js"></script>
		<![endif]-->
			
		<link rel="stylesheet" type="text/css" href="/include/dist/css/bootstrap.min.css"/>
		<link rel="stylesheet" type="text/css" href="/include/dist/css/bootstrap-theme.css"/>
		
		<style type="text/css">
			th{
				text-align: center;
			}
		</style>
		<script type="text/javascript" src="/include/js/jquery-1.12.4.min.js"></script>
		<script type="text/javascript" src="/include/js/common.js"></script>
		<script type="text/javascript" src="/include/dist/js/bootstrap.min.js"></script>
		<script type="text/javascript">
			$(function(){
				/* 제목 클릭시 상세 페이지 이동을 위한 처리 이벤트 추가 */
				$(".goDetail").click(function(){
					//let num = $(this).parents("tr").children().eq(0).html();
					//이벤트가 발생한 자기 자신.자신을 포함한 부모 요소 중, tr을 찾아 tr의 속성인 data-num값을 읽어옴
					let id = $(this).parents("tr").attr("data-id");
					$("#id").val(id);
					$("#myPageForm").attr({
						"method" : "post",
						"action" : "/join/getMyPage.do"
					});
					$("#myPageForm").submit();
					//get방식 처리법
					//location.href="/board/detailBoard.do?num="+num;
				});
			});				
		</script>
	</head>
	<body>
		<div class="container">
			<div class="text-center"><h3>사용자 리스트</h3>
			<form name="myPageForm" id="myPageForm">
				<input type="hidden" name="id" id="id"/>
			</form>
				<div id="joinList">
					<table summary="사용자 리스트" class="table table-bordered">
						<thead>
							<tr class="text-center">
								<th>아이디</th>
								<th>비밀번호</th>
								<th>이름</th>
								<th>성별</th>
								<th>휴대폰번호</th>
								<th>가입일자</th>
							</tr>
						</thead>
						<tbody>
							<c:choose>
								<c:when test="${not empty list}">
									<c:forEach var="vo" items="${list}">
										<tr class="text-center" data-id="${vo.id}">
											<td><span class="goDetail">${vo.id}</span></td>
											<td>${vo.passwd}</td>
											<td>${vo.name}</td>
											<td>${vo.gender}</td>
											<td>${vo.tel}</td>
											<td>${vo.regdate}</td>
										</tr>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<tr>
										<td colspan="6" class="text-center">등록된 유저가 존재하지 않습니다.</td>
									</tr>
								</c:otherwise>
							</c:choose>
						</tbody>
					</table>
				</div>
			</div>
		</div>		
	</body>
</html>
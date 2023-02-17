<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jspf" %>

	</head>
	<body>	
		<%-- =============상세정보 보여주기 시작============= --%>
		<div class="text-center">
			<table class="table table-bordered">
				<tbody>
					<tr>
						<td class="col-md-3">글번호</td>
						<td class="col-md-3 text-left">${board.b_num}</td>
						<td class="col-md-3">작성일</td>
						<td class="col-md-3 text-left">${board.b_date}</td>
					</tr>
					<tr>
						<td class="col-md-3">작성자</td>
						<td colspan="3" class="col-md-9 text-left">${board.b_name}</td>
					</tr>
					<tr>
						<td class="col-md-3">글제목</td>
						<td colspan="3" class="col-md-9 text-left">${board.b_title}</td>
					</tr>
					<tr>
						<td class="col-md-3">글내용</td>
						<td colspan="3" class="col-md-9 text-left">${board.b_content}</td>
					</tr>
				</tbody>
			</table>
		</div>
		<%-- =============상세정보 보여주기 종료============= --%>
	</body>
</html>
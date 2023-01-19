<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.ArrayList, com.board.Board" %>
<%
	ArrayList<Board> list = (ArrayList<Board>)request.getAttribute("list");
	int counter = list.size();
%>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1" />		
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />		

		<title>Board 테이블 조회</title>
		
		<!-- 모바일 웹 페이지 설정 -->
		<link rel="shortcut icon" href="../image/icon.png" />
		<link rel="apple-touch-icon" href="../image/icon.png" />
		<!-- 모바일 웹 페이지 설정 끝 -->
		
		<!--IE8이하 브라우저에서 HTML5를 인식하기 위해서는 아래의 패스필터를 적용하면 된다.--> 
		<!--[if lt IE 9]>
		<script src="../js/html5shiv.js"></script>
		<![endif]-->		
		
		<style type="text/css">
			body{font:12px/2em "돋움"}
			
			div#subjectList{width: 600px; float: left;}
			div#subjectList table{border-collapse: collapse; width: 600px; margin: 0 auto; margin-top: 8px;}
			div#subjectList thead > div#subjectList tr{background-color: #cecece}
			div#subjectList th, div#subjectList td{border: 1px solid black;}
			
			.tc{text-align: center;}
			.tl{text-align: left;}
			.tr{text-aligh: right;}
		</style>
		<script type="text/javascript" src="/scriptTag/js/jquery-3.6.2.min.js"></script>
		<script type="text/javascript">
			$(function(){
				//학과 정보 등록 버튼 제어
				$("#boardInsert").click(function(){
					location.href="<%=request.getContextPath()%>/jdbc/boardForm.jsp";
				});
			});
		</script>
	</head>
	<body>
		<h3>board 테이블 조회</h3>
		<hr />
		<div id="boardList">
			<div class="tr"><input type="button" value="게시글작성" id="boardInsert"></div>
			<table>
				<thead>
					<tr>
						<th>번호</th>
						<th>작성자</th>
						<th>제목</th>
						<th>내용</th>
						<th>작성일</th>
					</tr>
				</thead>
				<tbody>
					<% if (counter > 0 ){
						for( Board sub : list){
					%>
						<tr class="tc" data-no="<%= sub.getBoardNum() %>">
							<td><%= sub.getBoardNum() %></td>
							<td><%= sub.getBoardWriter() %></td>
							<td><%= sub.getBoardTitle() %></td>
							<td><%= sub.getBoardContent() %></td>
							<td><%= sub.getBoardDate() %></td>
						</tr>
					<%
						}	
					} else{
					%>
						<tr>
							<td colspan="5" class="tc">게시글이 존재하지 않습니다.</td>
						</tr>
					<% } %>
				</tbody>
			</table>
			<div class="tr">조회된 학과 수는 <span id="counter"><%=counter%></span></div>
		</div>
	</body>
</html>
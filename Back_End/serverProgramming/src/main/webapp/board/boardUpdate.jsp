<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.board.vo.Board"%>

<%
	Board board = (Board)request.getAttribute("board");
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
				
		<title>게시글 수정화면</title>
	
		<link rel="shortcut icon" href="../image/icon.png" />
		<link rel="apple-touch-icon" href="../image/icon.png" />
		
		<!--[if lt IE 9]>
		<script src="../js/html5shiv.js"></script>
		<![endif]-->	
	</head>
	<body>
		<h3></h3>
	 	<form action="<%=request.getContextPath()%>/boardUpdate" method="post">
	 		<input type="hidden" name="boardNum" value="<%=board.getBoardNum() %>">
				<table>
		   			<tr>
		    			<td>제목</td>
		    			<td class="text-left">
		    			<input type="text" name="boardTitle" value="<%=board.getBoardTitle()%>">
		    			</td>
		    			<td>작성자</td>
		    			<td class="text-left">
		    			<input type="text" name="boardWriter" maxlength="6" value="<%=board.getBoardWriter() %>">
		    			</td>
		   			</tr>
		   			<tr>
		    			<td>내용</td>
		    			<td class="text-left">
		    			<textarea name="boardContent" cols="50" rows="7" style="resize: none;"><%=board.getBoardContent()%></textarea>
		    			</td>
		   			</tr>
		   			<tr>
		    			<td colspan="2" class="text=center">
		    				<input type="submit" value="수정하기">
		    				<a href="${pageContext.request.contextPath}/boardList">목록으로</a>
		    			</td>
		   			</tr>
	  		</table>
		</form>
	</body>
</html>
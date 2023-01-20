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
				
		<title>게시글 수정</title>
	
		<link rel="shortcut icon" href="../image/icon.png" />
		<link rel="apple-touch-icon" href="../image/icon.png" />
		
		<!--[if lt IE 9]>
		<script src="../js/html5shiv.js"></script>
		<![endif]-->	
	</head>
	<body>
	<div align="center">
	 	<form action="<%=request.getContextPath()%>/boardUpdate" method="post">
	 	<input type="hidden" name="boardnum" value="<%=board.getBoardNum() %>">
			<table>
	   			<tr>
	    			<td>제목</td>
	    			<td>
	    			<input type="text" name="boardtitle" value="<%=board.getBoardTitle()%>">
	    			</td>
	    			<td>작성자</td>
	    			<td>
	    			<input type="text" name="boardwriter" value="<%=board.getBoardWriter() %>">
	    			</td>
	   			</tr>
	   			<tr>
	    			<td>내용</td>
	   			</tr>
	   			<tr>
	    		<td colspan="4">
	    		<textarea name="content" cols="60" rows="15" style="resize: none;"><%=board.getBoardContent()%></textarea>
	    		</td>
	   			</tr>
	  		</table>
	  		<div align="center">
	    		<button type="button" onclick="history.back();">취소</button>
	    		<button type="submit">수정하기</button>
	  		</div>
		</form>
	</div>
	</body>
</html>
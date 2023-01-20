<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<%@ page import="java.util.ArrayList, com.board.vo.Board"%>

<% @SuppressWarnings("unchecked")
	ArrayList<Board> boardList = (ArrayList<Board>)request.getAttribute("boardList");
%>

<%--
	서버프로그램에서 사용자의 게시판 글 등록 서비스를 구현하시오.
	(처리 결과, 성공시에는 게시글 목록을 출력하는 /boardList 서블릿을 실행하고,
	실패시에는 /views/common/error.jsp를 view 페이지로 지정하고, "message"키로 "게시글 등록 실패!" 메시지를 포워딩하시오 
 --%> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
				
		<title>게시판 리스트</title>
	
		<link rel="shortcut icon" href="../image/icon.png" />
		<link rel="apple-touch-icon" href="../image/icon.png" />
		
		<!--[if lt IE 9]>
		<script src="../js/html5shiv.js"></script>
		<![endif]-->	
		
		<style type="text/css">
			table{text-align: center; width: 700px; border-collapse: collapse; border: 1px solid #000000;}
			th, td{border-bottom: 1px solid #000000; padding: 4px;}
			.text-left{text-align: left}
			div{margin-top: 5px};
		</style>
		
		<script type="text/javascript" src="/serverProgramming/js/jquery-3.6.2.min.js"></script>
		<script type="text/javascript">
			$(function(){
				$("#insertFormBtn").click(function(){
					location.href="<%=request.getContextPath()%>/board/boardInsert.jsp";
				});
				
				$(".updateFormBtn").click(function(){
					let boardNum = $(this).parents("tr").attr("data-num");
					location.href="<%=request.getContextPath()%>/boardUpdate?boardNum=" + boardNum;
				});
			});
		</script>
	</head>
	<body>
		<h3>게시판 리스트</h3>
		<table>
			<colgroup>
				<col width=10% />
				<col width=40%  />
				<col width=10%  />
				<col width=25%  />
				<col width=15%  />
			</colgroup>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>등록일</th>
				<th>수정</th>
			</tr>
			<%if(boardList.size() > 0){
				for(Board board : boardList){ %>
				
				<tr data-num="<%=board.getBoardNum()%>">
					<td><%=board.getBoardNum() %></td>
					<td class="test-left"><%=board.getBoardTitle() %></td>
					<td><%=board.getBoardWriter() %></td>
					<td><%=board.getBoardDate() %></td>
					<td><button type="button" class="updateFormBtn">수정</button></td>
				</tr>
			<%	}
			} else{
			%>
				<tr>
					<td colspan="4">등록된 게시글이 존재하지 않습니다.</td>
				</tr>
			<%} %>
		</table>
		<div>
			<button type="button" id="insertFormBtn">글쓰기</button>
		</div>
	</body>
</html>
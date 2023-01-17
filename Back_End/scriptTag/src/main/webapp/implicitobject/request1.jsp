<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		
		<title>개인 정보 출력 페이지 - request1.jsp</title>
		
		<link rel="shortcut icon" href="../image/icon.png" />
		<link rel="apple-touch-icon" href="../image/icon.png" />
		
		<!--[if lt IE 9]>
		<script src="../js/html5shiv.js"></script>
		<![endif]-->

		<style type="text/css">
			fieldset{border-width:1px 3px; border-color:#000000; border-style:solid; 
            		 width:380px; height:120px; padding:15px; }
            legend{color:#039AFD}		 
			table{font:9pt/1em "굴림"; width:380px; border-collapse:collapse}
			th, td{background-color:#F7F7F7; border: 1px solid #000000; padding:8px 0} 
			td.t1{width:100px; text-align:center; background-color:#F7F7F7; }
			td.t2{background-color:#FFFFFF;}
		</style> 
		<script type="text/javascript" src="../js/jquery-1.12.4.min.js"></script>	
	</head>
	<body>
		<% // 웹 브라우저에서 서버로 넘어오는 파라미터 값에 한글이 있는 경우(post) 한글 처리
			request.setCharacterEncoding("UTF-8");
			
			String name = request.getParameter("name");
			String birth = request.getParameter("birth");
		%>
		<fieldset>
			<legend>
				<strong>기술정보 이력서</strong>
			</legend>
			<table>
				<tr>
					<td class="t1">이 름</td>
					<td class="t2">&nbsp;<%= name%></td>
				</tr>
				<tr>
					<td class="t1">생년월일</td>
					<td class="t2">&nbsp;<%= birth%></td>
				</tr> 
			</table>
		</fieldset>
	</body>
</html>
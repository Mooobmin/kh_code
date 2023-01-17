<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import="java.util.Arrays" %>
<% // 웹 브라우저에서 서버로 넘어오는 파라미터 값에 한글이 있는 경우(post) 한글 처리
	request.setCharacterEncoding("UTF-8");

	String name = request.getParameter("name");
	String birth = request.getParameter("birth");
	String scholarship = request.getParameter("scholarship");
	String major = request.getParameter("major");
	String[] platforms = request.getParameterValues("platform");
	String[] languages = request.getParameterValues("language");
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		
		<title>예제 request.jsp</title>
		
		<link rel="shortcut icon" href="../image/icon.png" />
		<link rel="apple-touch-icon" href="../image/icon.png" />
		
		<!--[if lt IE 9]>
		<script src="../js/html5shiv.js"></script>
		<![endif]-->

		<style type="text/css">
			fieldset{border-width:1px 3px; border-color:#000000; border-style:solid; 
            		 width:480px; height:220px; padding:15px; }
            legend{color:#039AFD}		 
			table{font:9pt/1em "굴림"; width:470px; border-collapse:collapse}/* height:200px; */ 
			th, td{background-color:#F7F7F7; border: 1px solid #000000; padding:8px 0} 
			td.t1{width:100px; text-align:center; background-color:#F7F7F7; }
			td.t2{background-color:#FFFFFF;}
		</style> 
		<script type="text/javascript" src="../js/jquery-1.12.4.min.js"></script>
		<script type="text/javascript">
			$(function(){
				// post 방식 데이터 전송
				$("#btnInfo").click(function(){
					$("#dataForm").attr({
						"method":"post",
						"action":"request1.jsp"
					});
					$("#dataForm").submit();
				}); 
				
				// get 방식 데이터 전송
				<%--$("#btnInfo").click(function(){
					location.href="request1.jsp?name=<%=name%>&birth=<%=birth%>";
				});--%>
			});
		</script>		
	</head>
	<body>
	 	<form id="dataForm">
			<input type="hidden" name="name" value="<%=name%>" />
			<input type="hidden" name="birth" value="<%=birth%>" />
		</form>
		<fieldset>
			<legend>
				<strong>기술정보 이력서</strong>
				<input type="button" id="btnInfo" value="개인정보" />
			</legend>
			<table>
				<%-- <tr>
					<td class="t1">이 름</td>
					<td class="t2">&nbsp;<%= name%></td>
				</tr>
				<tr>
					<td class="t1">생년월일</td>
					<td class="t2">&nbsp;<%= birth%></td>
				</tr> --%>
				<tr>
					<td class="t1">학 력</td>
					<td class="t2">&nbsp;<%= scholarship%></td>
				</tr>
				<tr>
					<td class="t1">학과(전공)</td>
					<td class="t2">&nbsp;<%= major%></td>
				</tr>
				<tr>
					<td class="t1">사용가능 플랫폼 </td>
					<td class="t2">&nbsp;
					<% 
						/* for (int i=0; i < platforms.length; i++){ 
							out.println(" [ " + platforms[i] + " ] "); 
						}*/
						
						int i = 0;
						for ( String forms : platforms ) {
		     				out.println(forms);
		     				if(i++ < platforms.length-1) out.println(", ");
						}
					%>
					</td>
				</tr>	
				<tr>
					<td class="t1">사용가능 언어</td>
					<td class="t2">&nbsp;<%=Arrays.toString(languages) %></td>
				</tr>
			</table>
		</fieldset>
 		<br />
		
		<fieldset>
			<legend><strong>요청 정보</strong></legend>
			<table>
				<tr>
					<td class="t1">요청 방식</td>
					<td class="t2">&nbsp;<%= request.getMethod()%></td>
				</tr>
				<tr>
					<td class="t1">요청 URL</td>
					<td class="t2">&nbsp;<%= request.getRequestURL()%></td>
				</tr>
				<tr>
					<td class="t1">요청 URI</td>
					<td class="t2">&nbsp;<%= request.getRequestURI()%></td>
				</tr>
				<tr>
					<td class="t1">클라이언트 주소</td>
					<td class="t2">&nbsp;<%= request.getRemoteAddr()%></td>
				</tr>
				<tr>
					<td class="t1">프로토콜 방식</td>
					<td class="t2">&nbsp;<%= request.getProtocol()%></td>
				</tr>
				<tr>
					<td class="t1">서버 이름</td>
					<td class="t2">&nbsp;<%= request.getServerName()%></td>
				</tr>
				<tr>
					<td class="t1">서버 포트 번호 </td>
					<td class="t2">&nbsp;<%= request.getServerPort()%></td>
				</tr>
			</table>
		</fieldset>
	</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.chungnam.ChungnamVO" %>    
<% 
	ArrayList<ChungnamVO> list = (ArrayList<ChungnamVO>)request.getAttribute("list");
	int counter = list.size();
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		
		<title>Chungnam 정보 리스트 예제</title>
		
		<link rel="shortcut icon" href="../image/icon.png" />
		<link rel="apple-touch-icon" href="../image/icon.png" />
		
		<!--[if lt IE 9]>
		<script src="../js/html5shiv.js"></script>
		<![endif]-->
		<link rel="stylesheet" type="text/css" href="/servletExample/css/chungnam.css" />
		
		<script type="text/javascript" src="../js/jquery-1.12.4.min.js"></script>
		<script type='text/javascript'>
			$(function(){
			   $('.delBtn').click(function(){
			    if(confirm('정보 삭제하시겠습니까?')){
			      let mng_no = $(this).parents('li').attr('data-no'); console.log(mng_no);
			      location.href='/servletExample/delete?mng_no='+mng_no;
			    }
			   })
			});
		</script>
	</head>
	<body>
		<h1 class='title'>충남관광 - 관광명소</h1>	
		<div class='btn'><a href='/servletExample/jdbc/chungnamForm.jsp'>정보등록</a></div>
		<ul id='list'>
		<% 
			if (counter > 0) { 
				//for(int i=0; i < counter; i++) { // 인덱스 접근 시
				//	ChungnamVO cvo = list.get(i);
				for( ChungnamVO cvo : list ) {
		%>
					<li class="item" data-no="<%=cvo.getMng_no()%>">
						<span class="item-thumb"><img src="<%=cvo.getList_img()%>" /></span>
						<span class="text">
							<span class="item-type"><%=cvo.getType() %></span>
							<span class="item-title"><%=cvo.getNm()%>
								<button type="button" class="delBtn">삭제</button>
							</span>
							<span class="item-sub"><%=cvo.getNm_sub()%></span>
							<span class="item-content"><%=cvo.getDescription()%></span>
						</span>
					</li>
		<%			
				}
			} 
		%>		
		</ul>
	</body>
</html>
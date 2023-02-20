<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jspf" %>

	<script type="text/javascript">
		$(function(){
			/* 글쓰기 버튼 클릭 시 처리 이벤트 */
			$("#insertFormBtn").click(function(){
				location.href = "/board/writeForm"; 
			});
			
			/* 목록 버튼 클릭 시 처리 이벤트 */
			$("#boardListBtn").click(function(){
				location.href="/board/boardList";
			});
			
			/* 수정 버튼 클릭 시 처리 이벤트 */
			$("#updateFormBtn").click(function(){
				location.href="/board/updateForm";
			});
			
		});
	</script>
	</head>
	<body>
		<div class="contentContainer container">
			<!-- <div class="contentTit page-header"><h3 class="text-center">게시판 상세보기</h3></div>  -->
			
			<form name="f_data" id="f_data" method="post">
				<input type="hidden" name="b_num" value="${detail.b_num}"/>
			</form> 
			
			<%-- ========= 비밀번호 확인 버튼 및 버튼 추가 시작 ====== --%>
			<div id="boardPwdBut" class="row text-center">
				<div id="pwdChk" class="authArea col-md-8 text-left">	
					<form name="f_pwd" id="f_pwd" class="form-inline">
						<input type="hidden" name="b_num" id="b_num" value="${detail.b_num}"/>	
						<label for="b_pwd" id="l_pwd">비밀번호 : </label>
						<input type="password" name="b_pwd" id="b_pwd" class="form-control" />
							
						<button type="button" id="pwdBtn" class="btn btn-default">확인</button>
						<span id="msg"></span>
					</form>
				</div>
				<div class="btnArea col-md-4 text-right">
					<input type="button" value="글수정" id="updateFormBtn" class="btn btn-success" />
					<input type="button" value="글삭제" id="boardDeleteBtn" class="btn btn-success" />
					<input type="button" value="글쓰기" id="insertFormBtn" class="btn btn-success" />
					<input type="button" value="목록" id="boardListBtn" class="btn btn-success" />
				</div>
			</div> 
			<%--========= 비밀번호 확인 버튼 및 버튼 추가 종료 ========= --%>
	
			<%-- =============== 상세 정보 보여주기 시작 ============ --%>
			<div class="contentTB text-center">
				<table class="table table-bordered">
					<tbody>
						<tr>
							<td class="col-md-3">작성자</td>
							<td class="col-md-3 text-left">${detail.b_name}</td>
							<td class="col-md-3">작성일</td>
							<td class="col-md-3 text-left">${detail.b_date}</td>
						</tr>
						<tr>
							<td class="col-md-4">글제목</td>
							<td colspan="3" class="col-md-8 text-left">${detail.b_title}</td>
						</tr>
						<tr class="table-tr-height">
							<td class="col-md-4">글내용</td>
							<td colspan="3" class="col-md-8 text-left">${detail.b_content}</td>
						</tr>
					</tbody>
				</table>
			</div>
			<%-- =============== 상세 정보 보여주기 종료 ============ --%>
		</div>
	</body>
</html>
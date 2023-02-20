<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jspf" %>
	<script type="text/javascript">
		$(function(){
			/* 수정 버튼 클릭 시 처리 이벤트 */
			$("#updateFormBtn").click(function(){
				if(!chkData("#b_title", "제목을")) return;
				else if(!chkData("#b_content", "작성할 내용을")) return;
				else{
				$("#f_updateForm").attr({
					"method" : "post",
					"action" : "/board/boardUpdate"
				});
				$("#f_updateForm").submit();
				}
			});
			/* 취소 버튼 클릭 시 처리 이벤트*/
			$("#boardcancelBtn").click(function(){
				$("#f_updateForm").each(function(){
					this.reset();
				});
			});
			/* 목록 버튼 클릭 시 처리 이벤트 */
			$("#boardListBtn").click(function(){
				location.href="/board/boardList";
			});
		});
	</script>    	
	</head>
	<body>
		<div class="contentContainer container">
			<div class="contentTB text-center">
				<form id="f_updateForm" name="f_updateForm">
					<input type="hidden" id="b_num" name="b_num" value="${updateData.b_num}"/>
					
					<table class="table table-bordered">
						<tbody>
							<tr>
								<td class="col-md-3">글번호</td>
								<td class="text-left col-md-3">${updateData.b_num}</td>
								<td class="col-md-3">작성일</td>
								<td class="text-left col-md-3">${updateData.b_date}</td>
							</tr>
							<tr>
								<td>작성자</td>
								<td colspan="3" class="text-left">${updateData.b_name}</td>
							</tr>
							<tr>
								<td>글제목</td>
								<td colspan="3" class="text-left">
									<input type="text" name="b_title" id="b_title" value="${updateData.b_title}" class="form_control"/>
								</td>
							</tr>
							<tr class="table-tr-height">
								<td>내용</td>
								<td colspan="3" class="text-left">
									<textarea name="b_content" id="b_content" class="form_control" row="8">${updateData.b_content}</textarea>
								</td>
							</tr>
							<tr class="form-inline">
								<td>비밀번호</td>
								<td colspan="3" class="text-left">
									<input type="password" name="b_pwd" id="b_pwd" class="form-control" maxlength="18"/>
									<label>수정할 비밀번호를 입력해 주세요.</label>
								</td>
							</tr>					
						</tbody>
						<div class="btnArea col-md-4 text-right">
							<input type="button" value="글수정" id="updateFormBtn" class="btn btn-success" />
							<input type="button" value="취소" id="boardcancelBtn" class="btn btn-success" />
							<input type="button" value="목록" id="boardListBtn" class="btn btn-success" />
						</div>
					</table>
				</form>
			</div>
		</div>
	</body>
</html>
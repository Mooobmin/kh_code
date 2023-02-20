<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jspf" %>

	<script type="text/javascript">
		$(function(){

			/* 저장 버튼 클릭 시 처리 이벤트 */
			$("#boardInsertBtn").click(function(){
				if(!chkData("#b_name", "이름을")) return;
				else if(!chkData("#b_title", "제목을")) return;
				else if(!chkData("#b_content", "작성할 내용을")) return;
				else if(!chkData("#b_pwd", "비밀번호를")) return;
				else {
					$("#writeForm").attr({
						"method" : "post",
						"action" : "/board/boardInsert"
					});
					$("#writeForm").submit();
				}
			});
			
			/* 목록 버튼 클릭 시 처리 이벤트 */
			$("#boardListBtn").click(function(){
				location.href="/board/boardList";
			});
			/* 취소 버튼 클릭 시 처리 이벤트*/
			$("#boardcancelBtn").click(function(){
				$("#writeForm").each(function(){
					this.reset();
				});
			});
		});
	</script>    
	</head>
	<body>
		<div class="container">
			<div class="text-center"><h3>게시글 작성</h3>
				<form class="form-horizontal" id="writeForm">
				  <div class="form-group">
				    <label for="author" class="col-sm-2 control-label">작 성 자</label>
				    <div class="col-sm-10">
				      <input type="text" class="form-control" id="b_name" name="b_name" placeholder="작성자 입력">
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="title" class="col-sm-2 control-label">글 제 목</label>
				    <div class="col-sm-10">
				      <input type="text" class="form-control" id="b_title" name="b_title" placeholder="글제목 입력">
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="content" class="col-sm-2 control-label">글 내 용</label>
				    <div class="col-sm-10">
				    <textarea class="form-control" rows="8" id="b_content" name="b_content" placeholder="글내용 입력"></textarea>
				    </div>
				 </div>
				  <div class="form-group">
				    <label for="password" class="col-sm-2 control-label">비밀번호</label>
				    <div class="col-sm-10">
				      <input type="password" class="form-control" id="b_pwd" name="b_pwd" placeholder="비밀번호 입력">
				    </div>
				  </div>
				</form>
				<div class="text-right">
					<button type="button" class="btn btn-success" id="boardInsertBtn">저장</button>
					<button type="button" class="btn btn-success" id="boardcancelBtn">취소</button>
					<button type="button" class="btn btn-success" id="boardListBtn">목록</button>
				</div>
			</div>
		</div>		
	</body>
</html>
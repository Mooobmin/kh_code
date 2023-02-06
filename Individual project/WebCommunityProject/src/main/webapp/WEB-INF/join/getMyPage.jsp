<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
				
		<title>내정보 관리</title>
	
		<link rel="shortcut icon" href="../image/icon.png" />
		<link rel="apple-touch-icon" href="../image/icon.png" />
		
		<!--[if lt IE 9]>
		<script src="../js/html5shiv.js"></script>
		<![endif]-->	
		<style type="text/css">
			#pwdChk{visibility:hidden;}
			#boardPwdBut{margin-bottom: 8px;}
			.table-height{height: 200px;}
			.table-height .text-vertical{vertical-align: middle;}
		</style>
		<link rel="stylesheet" type="text/css" href="/include/dist/css/bootstrap.min.css"/>
		<link rel="stylesheet" type="text/css" href="/include/dist/css/bootstrap-theme.css"/>
				
		<script type="text/javascript" src="/include/js/jquery-1.12.4.min.js"></script>
		<script type="text/javascript" src="/include/js/common.js"></script>
		<script type="text/javascript" src="/include/dist/js/bootstrap.min.js"></script>
		
		<script type="text/javascript">
         $(function(){
            $("#updateBtn").click(function(){
            	$("#f_data").attr({
					"method" : "post",
					"action" : "/join/updateJoinForm.do"
				});
				$("#f_data").submit();
            });
            $("#deleteBtn").click(function(){
				$("#pwdChk").css("visibility", "visible");
				$("#msg").text("작성시 입력한 비밀번호를 입력해주세요.").css("color", "#000009");
				buttonCheck = "deleteButton";
            });
			/* 비밀번호 확인 버튼 클릭 시 처리 이벤트*/
			$("#pwdBut").click(function(event){
				joinPwdConfirm();
			});
			
			$("#pwdButCancel").click(function(){
				$("#passwd").val("");
				$("#pwdChk").css("visibility", "hidden");
				buttonCheck = "";
			});
         });
			/* 비밀번호 클릭시 실질적인 처리 함수 */
			function joinPwdConfirm(){
				if(!chkData("#passwd", "비밀번호를")) return;
				//if(!dataCheck("#passwd", "#msg", "비밀번호를")) return;
				else{
					$.ajax({
						url : "/join/passwdCheck.do", //전송 url
						type : "post",				   //전송 method 방식
						data : $("#f_pwd").serialize(),//폼 전체 데이터 전송
						dataType : "text",
						error : function(){				//실행시 오류가 발생하였을 경우
							alert("시스템 오류 입니다. 관리자에게 문의하세요.");
						},								//정상적으로 실행이 되었을 경우
						success : function(resultData){
							let goUrl = "";				//이동할 경로를 저장하는 변수
							if(resultData == 0){		//일치하지 않는 경우
								$("#msg").text("작성시 입력한 비밀번호가 일치하지 않습니다.").css("color", "red");
								$("#passwd").select();
							} else if(resultData == 1){	//일치한 경우
								$("msg").text("");
								if(buttonCheck == "deleteButton"){ 	//삭제버튼 클릭 시 동작
									if(confirm("정말 삭제하시겠습니까?")){
										goUrl = "/join/deleteJoin.do";
										$("#f_data").attr("action", goUrl);
										$("#f_data").submit();
									}
								}
							}
						}
					});	
				}
			}         
         </script>
            
	</head>
	<body>
		<div class="container">
			<div class="text-center"><h3>마이 페이지</h3></div>
			<form name="f_data" id="f_data" method="post">
				<input type="hidden" name="id" value="${mypage.id}">
			</form>
			<%-- =============비밀번호 확인 버튼 및 버튼 추가 시작============= --%>
			<div id="boardPwdBut" class="row text-center">
				<div id="pwdChk" class="col-md-9 text-left">
					<form name="f_pwd" id="f_pwd" class="form-inline">
						<input type="hidden" name="id" id="id" value="${mypage.id}"/>
						<label for="passwd" id="l_pwd">비밀번호 : </label>
						<input type="password" name="passwd" id="passwd" class="form-control"/>
						
						<button type="button" id="pwdBut" class="btn btn-default btn-sm">확인</button>
						<button type="button" id="pwdButCancel" class="btn btn-default btn-sm">취소</button>
						<span id="msg"></span>
					</form>
				</div>
				<div class="col-md-3 text-right">
					<button type="button" id="updateBtn" class="btn btn-primary btn-sm">수정</button>
					<button type="button" id="deleteBtn" class="btn btn-primary btn-sm">삭제</button>
				</div>
			</div>
			<%-- =============비밀번호 확인 버튼 및 버튼 추가 종료============= --%>	

			</div>
			
			<div class="text-center">
				<table class="table table-bordered">
					<tbody>
						<tr>
							<td class="col-md-3">이름</td>
							<td class="col-md-3 text-left">${mypage.name} <label>(성별 : ${mypage.gender})</label></td>
							<td class="col-md-3">가입일</td>
							<td class="col-md-3 text-left">${mypage.regdate}</td>
						</tr>
						<tr>
							<td class="col-md-3">아이디</td>
							<td colspan="3" class="col-md-9 text-left">${mypage.id}</td>
						</tr>
						<tr>
							<td class="col-md-3">휴대폰번호</td>
							<td colspan="3" class="col-md-9 text-left">${mypage.tel}</td>
						</tr>
						<tr>
							<td class="col-md-3">비밀번호</td>
							<td colspan="3" class="col-md-9 text-left">${mypage.passwd}</td>
						</tr>
					</tbody>
				</table>
			</div>
	</body>
</html>
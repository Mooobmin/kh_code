<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
		<title>충남 정보 입력</title>
		
		<link rel="shortcut icon" href="../image/icon.png" />
		<link rel="apple-touch-icon" href="../image/icon.png" />
		
		
		<!--[if lt IE 9]>
		<script src="../js/html5shiv.js"></script>
		<![endif]-->
		
		<link rel='stylesheet' type='text/css' href='../css/chungnam.css' />
		
		<script type="text/javascript" src="../js/jquery-1.12.4.min.js"></script>
		<script type="text/javascript" src="../js/common.js"></script>
		<script type="text/javascript">
			$(function(){
				$("#btn").click(function(){
					if(!chkData("#mng_no", "번호")) return;
					else if(!chkData("#local_nm", "지역이름")) return;
					else if(!chkData("#type", "테마/카테고리")) return;
					else if(!chkData("#nm", "제목")) return;
					else if(!chkData("#nm_sub", "부제목")) return;
					else if(!chkData("#addr", "주소")) return;
					else if(!chkData("#lat", "경도")) return;
					else if(!chkData("#lng", "위도")) return;
					else if(!chkData("#description", "설명")) return;
					else if(!chkData("#list_img", "사진")) return;
					
					$("#frm").attr({
						"method" : "post",
						"action" : "/servletExample/insert"
					})
					
					$("#frm").submit();
				});
			});
		</script>
	</head>
	<body>
		
		<form name="frm" id="frm">
			<fieldset>
				<legend>새 게시글 작성</legend>
				<table>
					<tr>
						<td>번호</td>
						<td>
							<input type="text" name="mng_no" id="mng_no" placeholder="번호를 입력해 주세요."/>
						</td>
					</tr>
					<tr>
						<td>지역 이름</td>
						<td>
							<input type="text" name="local_nm" id="local_nm" placeholder="지역이름 입력해 주세요."/>
						</td>
					</tr>
					<tr>
						<td>
							테마/카테고리
						</td>
						<td>
							<input type="text" name="type" id="type" placeholder="테마/카테고리 입력해 주세요."/>				
						</td>
					</tr>
					<tr>
						<td>
							제목
						</td>
						<td>
							<input type="text" name="nm" id="nm" placeholder="제목 입력해 주세요."/>
						</td>
					</tr>
					<tr>
						<td>
							부제목
						</td>
						<td>
							<input type="text" name="nm_sub" id="nm_sub" placeholder="부제목 입력해 주세요."/>
						</td>
					</tr>
					<tr>
						<td>주소</td>
						<td><input type="text" name="addr" id="addr" placeholder="주소를 입력해 주세요."/></td>
					</tr>
					<tr>
						<td>경도</td>
						<td><input type="text" name="lat" id="lat"/></td>
					</tr>
					<tr>
						<td>위도</td>
						<td><input type="text" name="lng" id="lng" /></td>
					</tr>
					<tr>
						<td>
							설명
						</td>
						<td>
							<textarea name="description" id="description"></textarea>
						</td>
					</tr>
					<tr>
						<td>
							이미지 선택
						</td>
						<td>
							<input type="text" name="list_img" id="list_img">
						</td>
					</tr>
					<tr>
						<td></td>
						<td>
							<input type="button" id="btn" value="입력">
							<input type="reset" value="취소">
						</td>
					</tr>
				</table>
			</fieldset>
		</form>
	</body>
</html>
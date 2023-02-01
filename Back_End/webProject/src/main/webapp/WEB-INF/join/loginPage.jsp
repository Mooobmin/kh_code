<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
				
		<title>관리자 페이지</title>
	
		<link rel="shortcut icon" href="../image/icon.png" />
		<link rel="apple-touch-icon" href="../image/icon.png" />
		
		<!--[if lt IE 9]>
		<script src="../js/html5shiv.js"></script>
		<![endif]-->
			
		<link rel="stylesheet" type="text/css" href="/include/dist/css/bootstrap.min.css"/>
		<link rel="stylesheet" type="text/css" href="/include/dist/css/bootstrap-theme.css"/>
		<style type="text/css">
			body {
			  padding-top: 40px;
			  padding-bottom: 40px;
			  background-color: #eee;
			}
			
			.form-signin {
			  max-width: 330px;
			  padding: 15px;
			  margin: 0 auto;
			}
			.form-signin .form-signin-heading,
			.form-signin .checkbox {
			  margin-bottom: 10px;
			}
			.form-signin .checkbox {
			  font-weight: normal;
			}
			.form-signin .form-control {
			  position: relative;
			  height: auto;
			  -webkit-box-sizing: border-box;
			     -moz-box-sizing: border-box;
			          box-sizing: border-box;
			  padding: 10px;
			  font-size: 16px;
			}
			.form-signin .form-control:focus {
			  z-index: 2;
			}
			.form-signin input[type="email"] {
			  margin-bottom: -1px;
			  border-bottom-right-radius: 0;
			  border-bottom-left-radius: 0;
			}
			.form-signin input[type="password"] {
			  margin-bottom: 10px;
			  border-top-left-radius: 0;
			  border-top-right-radius: 0;
			}
		</style>
		
		<script type="text/javascript" src="/include/js/jquery-1.12.4.min.js"></script>
		<script type="text/javascript" src="/include/js/common.js"></script>
		<script type="text/javascript" src="/include/dist/js/bootstrap.min.js"></script>	
		<script type="text/javascript">
			$(function(){
				let msg = "${errorMsg}";
				if(msg != ""){
					alert(msg);
				}
				
				$("#loginBtn").click(function(){
					console.log("클릭");
					if(!chkData("#id", "아이디를")) return;
					else if(!chkData("#passwd", "비밀번호를")) return;
					else{
						$("#loginForm").attr({
							"method" : "post",
							"action" : "/join/loginBoard.do"
						});
						$("#loginForm").submit();
					}
				});
				$("#insertBtn").click(function(){
					location.href="/join/insertJoinForm.do";
				});
			});
		
			
		</script>
		
	</head>
	<body>
    <div class="container">

      <form class="form-signin" id="loginForm">
        <h2 class="form-signin-heading">로그인</h2>
        <label for="inputEmail" class="sr-only">Email address</label>
        <input type="text" name="id" id="id" class="form-control" placeholder="아이디">
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="passwd" name="passwd" class="form-control" placeholder="비밀번호">

        <button type="button" id="loginBtn" class="btn btn-lg btn-primary btn-block" >로그인</button>
        <button type="button" id="insertBtn" class="btn btn-lg btn-primary btn-block" >회원가입</button>
      </form>

    </div> <!-- /container -->
	</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/common/common.jsp" %>
	<script type="text/javascript">
		$(function () {
			//$('#signinBtn').click(function () {
				
			//})
		})
	</script>
	
	</head>
	<body>
		<nav class="navbar navbar-default">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="/index.html">JSP 게시판 웹 사이트</a>
			</div>
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="/index.html">메인</a></li>
					<li ><a href="/board/getBoardList.do">게시판</a></li>
				</ul>

				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown">
						<a href="#" class="dropdown-toggle"
							data-toggle="dropdown" role="button" aria-haspopup="true"
							aria-expanded="false">접속하기<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="board/getBoardList.do">로그인</a></li>
							<li><a href="join.jsp">회원가입</a></li>
						</ul>
					</li>
				</ul>
	
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown">
						<a href="#" class="dropdown-toggle"
							data-toggle="dropdown" role="button" aria-haspopup="true"
							aria-expanded="false">회원관리<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="logoutAction.jsp">마이페이지</a></li>
						</ul>
					</li>
				</ul>
			</div>
		</nav>
		<div class="container">
		    
		      <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
		        <div class="card card-signin my-5t">
		          <div class="card-body">
		            <h5 class="card-title text-center">Log In</h5>
		            
		            <form class="form-signin" method="post" action="/join/loginboard.do">
		              <div class="form-label-group">
		                <input type="text" id="id" name="id" class="form-control" placeholder="id" required autofocus>
		              </div><br>
		
		              <div class="form-label-group">
		                <input type="password" id="passwd" name="passwd" class="form-control" placeholder="Password" required>
		              </div>
		              
		              <hr>
		              
				<%-- <div class="form-label-group">
		              <c:if test="${check == 1 }">
		                <label>${message }</label>
		              </c:if>
		              </div> --%>
		
		              <button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit" id="signinBtn">Sign in</button>
		              <hr class="my-4">
		              	Forgot your <a href="javascript:void(0)" onclick="findid()">ID</a> or 
		              				<a href="javascript:void(0)" onclick="findpassword()">Password</a>?
		              <button class="btn btn-lg btn-secondary btn-block text-uppercase" id="joinBtn">Join</button>
		            </form>
		            
		          </div>
		        </div>
		      </div>
		    
		  </div>
	</body>
</html>
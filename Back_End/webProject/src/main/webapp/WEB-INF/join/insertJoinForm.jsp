<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/common/common.jsp" %>
      <style type="text/css">
         .form-horizontal{width:700px;
                      margin:auto;
                      padding-top:100px;
                      }
      </style>
      <script type="text/javascript">
         $(function(){
            $(".btn-default").click(function(){
               if(!chkData("#id","아이디를"))return;
               else if(!chkData("#passwd","비밀번호를"))return;
               else if(!chkData("#name","이름을"))return;
               else if(!chkData("#tel","전화번호를"))return;
               
               if($("#passwd").val()!=$("#rpasswd").val()){
                  alert("비밀번호가 다릅니다.");
               }
               
               $(".form-horizontal").attr({
                  "method" : "post",
                  "action" : "/join/insertJoin.do"
               });
               $(".form-horizontal").submit();
            });
         });
      </script>
   </head>
   <body>
         <form class="form-horizontal">
             <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">아이디</label>
                  <div class="col-sm-10">
                   <input type="text" class="form-control" id="id" name="id" placeholder="아이디 입력">
                </div>
              </div>
              <div class="form-group">
                  <label for="inputPassword3" class="col-sm-2 control-label">비밀번호</label>
                <div class="col-sm-10">
                     <input type="password" class="form-control" id="passwd" name="passwd" placeholder="비밀번호 입력">
                </div>
              </div>
              <div class="form-group">
                  <label for="inputPassword3" class="col-sm-2 control-label">비밀번호 확인</label>
                <div class="col-sm-10">
                     <input type="password" class="form-control" id="rpasswd" name="rpasswd" placeholder="비밀번호 입력">
                </div>
              </div>
              <div class="form-group">
                  <label for="inputPassword3" class="col-sm-2 control-label">이름</label>
                <div class="col-sm-10">
                     <input type="text" class="form-control" id="name" name="name" placeholder="이름 입력">
                </div>
              </div>
              <div class="form-group">
                  <label for="inputPassword3" class="col-sm-2 control-label">성별</label>
                <div class="col-sm-10">
                     <input type="text" class="form-control" id="gender" name="gender" placeholder="성별 입력">
                </div>
              </div>
              <div class="form-group">
                  <label for="inputPassword3" class="col-sm-2 control-label">전화번호</label>
                <div class="col-sm-10">
                     <input type="tel" class="form-control" id="tel" name="tel" placeholder="전화번호 입력">
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                  <button type="submit" class="btn btn-default">Sign in</button>
                </div>
              </div>
         </form>
   </body>
</html>
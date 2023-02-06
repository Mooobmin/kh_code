<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/common/common.jsp" %>
      <style type="text/css">
         .form-horizontal{width:700px;
                      margin:auto;
                      padding-top:100px;
         }
         .regExpMsg{
            font-size:7px;
         }
      </style>
      <script type="text/javascript">
         $(function(){
            /* 정규 표현식 */
            const idExp = /^[a-z][a-z0-9]{5,14}$/; // 글자수 = 6~15, 시작은 소문자영어
            const passwdExp = /[a-z][a-z0-9]{5,14}/; // 비밀번호수 = 6~15, 시작은 소문자영어
            const nameExp = /[가-힣]{2,4}/; // 이름은 한글로 3~4글자
            const telExp = /^\d{3}-\d{3,4}-\d{4}$/; // 숫자3개 - 숫자3~4개 - 숫자4개
            /* 정규 표현식 종료 */
            
            
            $(".btn-default").click(function(){
               //빈칸일때 알람
               if(!chkData("#id","아이디를"))return;
               else if(!chkData("#passwd","비밀번호를"))return;
               else if(!chkData("#name","이름을"))return;
               else if(!chkData("#tel","전화번호를"))return;
               
               
               if($("#passwd").val() != $("#rpasswd").val()){
                  alert("비밀번호가 다릅니다.");
                  return;
               }
               
               $(".form-horizontal").attr({
                  "method" : "post",
                  "action" : "/join/insertJoin.do"
               });
               $(".form-horizontal").submit();
            });
            
            
            //아이디 중복체크
            $("#idCheck").click(function(){         
               $.ajax({
                  url : "/join/idCheck.do",
                  type : "post",
                  data : "id="+$("#id").val(),
                  dataType : "text",
                  error : function(){
                     alert("시스템 오류 입니다. 관리자에게 문의 하세요.");
                  },
                  success : function(result){
                     if(result==1){
                        alert("중복된 아이디입니다.");
                        $("#id").val("").focus();
                     }else{
                        alert("사용 가능한 아이디입니다.");
                        $("#id").attr("readonly","readonly");
                     }
                  }   
               })
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
                   <button type="button" class="btn btn-primary btn-sm" id="idCheck">아이디 중복체크</button>
                   <span class="idMsg">글자수 = 6~15, 시작은 소문자영어</span>
                </div>
              </div>
              <div class="form-group">
                  <label for="inputPassword3" class="col-sm-2 control-label">비밀번호</label>
                <div class="col-sm-10">
                     <input type="password" class="form-control" id="passwd" name="passwd" placeholder="비밀번호 입력">
                   <span class="passwdMsg">비밀번호수 = 6~15, 시작은 소문자영어</span>
                </div>
              </div>
              <div class="form-group">
                  <label for="inputPassword3" class="col-sm-2 control-label">비밀번호 확인</label>
                <div class="col-sm-10">
                     <input type="password" class="form-control" id="rpasswd" name="rpasswd" placeholder="비밀번호 입력">
                   <span class="rpasswdMsg"></span>
                </div>
              </div>
              <div class="form-group">
                  <label for="inputPassword3" class="col-sm-2 control-label">이름</label>
                <div class="col-sm-10">
                     <input type="text" class="form-control" id="name" name="name" placeholder="이름 입력">
                   <span class="nameMsg">한글로 3~4글자</span>
                </div>
              </div>
              <div class="form-group">
                  <label for="inputPassword3" class="col-sm-2 control-label">성별</label>
                <div class="col-sm-10">
                     <input type="radio" name="gender" value="남자">남&nbsp;
                     <input type="radio" name="gender" value="여자">여
                </div>
              </div>
              <div class="form-group">
                  <label for="inputPassword3" class="col-sm-2 control-label">전화번호</label>
                <div class="col-sm-10">
                     <input type="tel" class="form-control" id="tel" name="tel" placeholder="전화번호 입력">
                   <span class="telMsg">###-###(#)-####</span>
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                  <button type="button" class="btn btn-default">회원가입</button>
                </div>
              </div>
         </form>
   </body>
</html>
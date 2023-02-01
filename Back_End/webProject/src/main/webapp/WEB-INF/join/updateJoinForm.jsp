<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/common.jsp" %>
      <style type="text/css">
         #content{resize: none;}
         .table-height{height: 200px;}
         .table-height .text-vertical{vertical-align : middle;}
      </style>
      
      <script type="text/javascript">
         $(function(){
            let msg="${errorMsg}";
            if(msg!=""){
               alert(msg);
            }
            
            // 수정 버튼 클릭 시 처리 이벤트
            $("#joinUpdate").click(function(){
               //입력값 체크
               if(!chkData("#passwd","비밀번호를")) return;
               else if(!chkData("#tel", "휴대폰 번호를")) return;
               else{
                  $("#j_updateForm").attr({
                     "method":"post",
                     "action" : "/join/updateJoin.do"
                  });
                  $("#j_updateForm").submit();
               }
               
            });
            
            
             
         });
      </script>

   </head>
   <body>
      <div class="container">
         <div class="text-center"><h3>회원정보수정</h3></div>
         
         <div class="text-center">
            <form name="j_updateForm" id="j_updateForm">
               <input type="hidden" name="id" id="id" value="${updateData.id }" />
               <table class="table table-boardered">
                  <tr>
                     <td class="col-md-3">아이디</td>
                     <td class="col-md-3 text-left">${updateData.id }</td>
                  </tr>
                  <tr>
                     <td class="col-md-3">이름</td>
                     <td colspan="3" class="col-md-9 text-left">${updateData.name }</td>
                  </tr>
                  <tr>
                     <td class="col-md-3">성별</td>
                     <td colspan="3" class="col-md-9 text-left">${updateData.gender }</td>
                  </tr>
                  <tr>
                     <td class="text-valign">휴대폰번호</td>
                     <td colspan="3" class="col-md-9 text-left"><input type="text" name="tel" id="tel" value="${updateData.tel }"
                     class="form-control" placeholder="수정할 휴대폰번호를 입력해 주세요." /></td>
                  </tr>
                  <tr>
                     <td class="text-valign">비밀번호</td>
                     <td colspan="3" class="col-md-9 text-left"><input type="password" name="passwd" id="passwd"
                     class="form-control" placeholder="수정할 비밀번호를 입력해 주세요." /></td>
                  </tr>
                  <tr>
                     <td class="col-md-3">회원가입일</td>
                     <td class="col-md-9 text-left">${updateData.regdate }</td>   
                  </tr>                  
               </table>
            </form>
         </div>
         
         <div class="text-right">
            <button type="button" id="joinUpdate" class="btn btn-primary btn-sm">수정</button>
            
         </div>
      </div>
   </body>
</html>
/*
	함수명 : chkData(유효성 체크 대상, 메시지 내용)
	출력영역 : alert
	예시 : if (!chkData("#keyword", "검색어를")) return;
*/

function chkData(item, msg){
	if($(item).val().replace(/\s/g,"")==""){
		alert(msg+"입력해 주세요.");
		$(item).val("");
		$(item).focus();
		return false;
	} else{
		return true;
	}
}

/* 함수명 : checkForm(유효성 체크 대상, 메시지 내용)
   출력영역 : placeholder 속성을 이용.
   예시 : if(!checkForm("#keyword", "검색어를")) return;
*/
function checkForm(item, msg){
	let message = "";
	if($(item).val().replace(/\s/g,"")==""){
		message = msg + "입력해 주세요.";
		$(item).attr("placeholder", message);
		return false;
	} else{
		return true;
	}
}
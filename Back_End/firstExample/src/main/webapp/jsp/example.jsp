<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		
		<title>예제 파일 - example.jsp</title>
		
		<link rel="shortcut icon" href="../image/icon.png" />
		<link rel="apple-touch-icon" href="../image/icon.png" />
		
		<!--[if lt IE 9]>
		<script src="../js/html5shiv.js"></script>
		<![endif]-->
	</head>
	<body> 
		<h1>[ 파일명은 example.jsp입니다. ]</h1>
		<%  
			out.print("<h3>숫자를 저장한 변수 3개(7,5,9)를 정의하고 최대값 구하기</h3>");
			int number1 = 7, number2 = 5, number3 = 9;
			int maximumValue = number1; 
	      
	    	if ( number2 > maximumValue )
	         	maximumValue = number2; 
	      
	    	if ( number3 > maximumValue )
	         	maximumValue = number3;

			out.println("<p>");
	    	out.println("최대값은 : " + maximumValue );  
	    	out.println("</p>");
	    	
			out.print("<h3>배열의 값(12, 26, 68, 98, 76, 54, 8, 6, 4) 중 최대값과 최소값 구하기</h3>");
			int[] su = { 12, 26, 68, 98, 76, 54, 8, 6, 4 };
			int max = su[0];
			int min = su[0];
			
			for (int i = 0; i < su.length; i++) {
				if (su[i] > max)
					max = su[i];
				if (su[i] < min)
					min = su[i];
			}
			out.print("최대값 :" + max + ", 최소값 :" + min);
	    	
			out.print("<h3>문자열 추출하기</h3>");
			char c = '닳';
			String letter="동해 물과 백두산이 마르고 닳도록 하느님이 보우하사 우리나라 만세";
			
			int letterNumber=letter.length();     
			int loc=letter.indexOf(c);
			out.print("\""+letter + "\" => " + letterNumber + "자이며, \'" + c +"\'은 " + loc + "번째 있다.<br /><br />");
			
			char b = letter.charAt(loc) ; 
			out.print("\""+letter + "\" 의 " + loc + "번째 문자는 \'" + b + "\'이다.");
			
		%>
	</body>
</html>
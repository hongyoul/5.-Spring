<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
    <!-- jsp는 HTML안에 자바(java)가 있음 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<!-- 회원 등록 폼 -->
	<form action="/view/v1/save.jsp" method="post">
		이름: <input type="text" name="username"/>
		암호: <input type="text" name="password"/>
		
		<!-- submit은 이벤트 자동 동작 일반 버튼은 이벤트를 사용자가 설정해야함 -->
			<button type="submit">등록</button> 
			
	</form>
	
	
</body>
</html>

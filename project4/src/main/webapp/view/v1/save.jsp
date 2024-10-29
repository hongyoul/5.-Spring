<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <!-- 새로운 회원 정보를 추가하기 위한 JSP -->
    <%@ page import="com.example.demo.domain.MemberRepository" %>
	<%@ page import="com.example.demo.domain.Member" %>
    
    <!-- JSP에서 자바코드를 삽입하기 위한 태그 -->
    <% 
	    MemberRepository repository = new MemberRepository();
	
	    String username = request.getParameter("username");
	    String password = request.getParameter("password");
	
	    Member member = Member.builder()
	                            .userId(username).password(password)
	                            .build();
	
	    Member newMember = repository.save(member);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

		<!-- 위에서 저장된 회원 정보를 출력  -->
        <%= newMember.getNo() %> 번째 <%= newMember.getUserId() %> 회원을 추가했습니다!

</body>
</html>
package com.example.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.example.demo.domain.Member;
import com.example.demo.domain.MemberRepository;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//회원 등록 폼에서 입력된 정보를 받아 새로운 회원을 저장하는 서블릿 만들기

// 이름,주소 중복 안됨.
@WebServlet(name = "SaveServlet", urlPatterns = "/servlet/save")
public class SaveServlet extends HttpServlet {

		
	// 회원정보를 관리할 리파지토리 생성 
	MemberRepository repository = new MemberRepository();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 요청 메세지에서 사용자가 전달한 파라미터를 조회
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		// 회원 이름과 패스워드로 새로운 멤버 객체 생성
		Member member = new Member(0, username, password);
		
		// 생성된 회원 객체를 저장소에 등록
		repository.save(member);
		
		// 응답 메세지 설정(컨텐츠 타입과 문자 인코딩)
		resp.setContentType("text/html"); // HTML, JSON, XML ..
		resp.setCharacterEncoding("utf-8");
		
		PrintWriter w = resp.getWriter();
		
		 // 등록 결과를 확인하기 위한 html을 만들어서 응답에 추가
			// 자바코드로 html를 작성 -시작-
		   		w.write("<html>\n" +
				        "<head>\n" +
				        " <meta charset=\"UTF-8\">\n" +
				        "</head>\n" +
				        "<body>\n" +
				        "성공\n" +
				        "<ul>\n" +
				        " <li>회원번호="+member.getNo()+"</li>\n" +
				        " <li>이름="+member.getUserId()+"</li>\n" +
				        " <li>비밀번호="+member.getPassword()+"</li>\n" +
				        "</ul>\n" +
				        "</body>\n" +
				        "</html>");
		   	// 자바코드로 html를 작성 -끝-
		   		
			}
	
}

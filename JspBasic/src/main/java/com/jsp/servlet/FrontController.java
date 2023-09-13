package com.jsp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 서블릿 맵핑 url 패턴 종류

//1. 디렉토리 패턴: 디렉토리 형태로 서버의 해당 컴포넌트를 찾아서 실행하는 구조
//-> 정해진 url로만 서블릿에 요청을 보낼 수가 있습니다.

//2. 확장자 패턴: 확장자 형태로 서버의 해당 컴포넌트를 찾아서 실행하는 구조
//*.board -> 앞에 어떠한 경로가 존재하던지 .board 요청으로만 끝나면 해당 서블릿이 반응하겠다.

@WebServlet("*.user")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public FrontController() {
        super();
    }


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("요청 URI: " + request.getRequestURI());
		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath(); // -> /JspBasic (컨텍스트 루트)
		
		// /JspBasic/join.user
		uri = uri.substring(conPath.length()+1 , uri.lastIndexOf("."));
		System.out.println("정제된 uri: " + uri);
		
		if(uri.equals("join")) {
			System.out.println("회원 가입 요청이 들어왔습니다!");
		}else if (uri.equals("login")) {
			
		}
	}

}

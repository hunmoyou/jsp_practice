package com.jsp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/cookie/login")
public class CookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CookieServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		if(id.equals("kim1234") && pw.equals("kkk1111!")) {
			
			//쿠키 생성 방법
			//1. 쿠키 객체 생성 - 생성자의 매개값으로 쿠키의 이름과 저장할 데이터 입력(String)
			Cookie loginCoo = new Cookie("login_cookie", id);
			
			//2. 쿠키 클래스의 setter메서드로 쿠키의 속성을 설정.
			loginCoo.setMaxAge(5); //쿠키의 유효 시간 절정(초) 1시간 -> 60*60
			
			//3. http 응답 시 response 객체에 생성된 쿠키를 탑재해서 클라이언트에게 전송.
			response.addCookie(loginCoo);
			
			//사용자가 아이디 기억하기 체크박스를 체크했는지의 여부 확인.
			if(request.getParameter("rememberId") != null) {//체크를 했다면 null이 아님.
				Cookie idMemory = new Cookie("remember_id", id);
				idMemory.setMaxAge(30);
				response.addCookie(idMemory);
			}
			
			
			
			response.sendRedirect("/JspBasic/cookie/cookie_welcome.jsp");
			
		}else {
			response.sendRedirect("/JspBasic/cookie/cookie_login.jsp");
		}
	}

}

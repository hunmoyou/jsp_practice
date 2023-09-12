package com.jsp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/practice2/login")
public class PracticeLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public PracticeLoginServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		if(id.equals("gnsah0926") && pw.equals("hunmo1234")) {
			
			Cookie loginCoo = new Cookie("login_health", id);
			
			loginCoo.setMaxAge(15);
			
			response.addCookie(loginCoo);
			
			response.sendRedirect("/JspBasic/practice2/practice_welcome.jsp");
		}else {
			response.sendRedirect("/JspBasic/practice2/practice_login.jsp");
		}
	}

}

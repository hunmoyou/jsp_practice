package com.jsp.pboard.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.pboard.model.PboardRepository;
import com.jsp.pboard.model.PboardVO;


@WebServlet("*.pboard")
public class PboardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public PboardController() {
        super();
    }


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getMethod().equals("POST")) {
			request.setCharacterEncoding("UTF-8");
		}
		
		String uri = request.getRequestURI();
		uri = uri.substring(request.getContextPath().length()+1, uri.lastIndexOf("."));
		
		System.out.println("정제된 uri: " +uri);
		
		switch (uri) {
		
		case "write" :
			System.out.println("글쓰기 페이지로 이동 요청합니다람쥐!");
			response.sendRedirect("pboard/pboard_write.jsp");
			break;
			
		
		case "regist":
			System.out.println("글 등록 요청이 들어왔습니다람쥐!");
			String writer = request.getParameter("writer");
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			PboardVO vo = new PboardVO();
			vo.setWriter(writer);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setRegDate(LocalDateTime.now());
			
			PboardRepository.getInstance().regist(vo); //글 등록 끝
			
			response.sendRedirect("/JspBasic/list.pboard");
			
			break;
			
		case "list" :
			System.out.println("글 목록 요청이 들어왔습니다람쥐!");
			List<PboardVO> plist = PboardRepository.getInstance().getList();
			
			request.setAttribute("pboardList", plist);
			RequestDispatcher pdp = request.getRequestDispatcher("pboard/pboard_list.jsp");
			pdp.forward(request, response);
			break;
		
		}
		
	}

}

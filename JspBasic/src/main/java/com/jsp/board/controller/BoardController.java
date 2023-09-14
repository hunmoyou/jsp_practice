package com.jsp.board.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.board.model.BoardRepository;
import com.jsp.board.model.BoardVO;
import com.jsp.board.service.ContentService;
import com.jsp.board.service.DeleteService;
import com.jsp.board.service.GetListService;
import com.jsp.board.service.IBoardService;
import com.jsp.board.service.ModifyService;
import com.jsp.board.service.RegistService;
import com.jsp.board.service.SearchService;
import com.jsp.board.service.UpdateService;


@WebServlet("*.board")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	private IBoardService sv;
	private RequestDispatcher dp;
	
    public BoardController() {
        super();
    }


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getMethod().equals("POST")) {
			request.setCharacterEncoding("UTF-8");
		}
		
		String uri = request.getRequestURI();
		uri = uri.substring(request.getContextPath().length()+1, uri.lastIndexOf("."));
		
		System.out.println("정제된 uri: " + uri);
		
		switch (uri) {
		
		case "write":
			System.out.println("글쓰기 페이지로 이동 요청!");
			response.sendRedirect("board/board_write.jsp");
			break;
			
		case "regist":
			System.out.println("글 등록 요청이 들어옴!");			
			sv = new RegistService();
			sv.execute(request, response);
			/*
            왜 board_list.jsp로 바로 리다이렉트를 하면 안될까?
            board_list.jsp에는 데이터베이스로부터 전체 글 목록을 가져오는
            로직을 작성하지 않을 것이기 때문입니다. (jsp는 단순히 보여지는 역할만 수행)
            컨트롤러로 글 목록 요청이 다시 들어올 수 있게끔
            sendRedirect()를 사용하여 자동 목록 재 요청이 들어오게 하는 겁니다.
            */
			
			response.sendRedirect("/JspBasic/list.board");			
			break;
			
		case "list" :
			System.out.println("글 목록 요청이 들어왔습니다!");		
			sv = new GetListService();
			sv.execute(request, response);
			/*
			 여기서 sendRedirect를 하면 안되는 이유.
			 request 객체에 list를 전달하려 하는데, sendRedirect를 사용하면
			 응답이 바로 나가면서 기본의 request 객체가 소멸해 버립니다.
			 여기서는 forward방식을 사용해서 request를 원하는 jsp 파일로 전달해서
			 그쪽에서 응답이 나갈 수 있도록 처리해야 합니다.
			 */
//			response.sendRedirect("board/board_list.jsp");
			
			//request 객체를 다음 화면까지 운반하기 위한 forward기능을 제공하는 객체
			//-> RequestDispatcher  (dispatcher는 절대경로X)
			  dp = request.getRequestDispatcher("board/board_list.jsp");		  
			  dp.forward(request, response); 
			
			break;
			
													
		case "content" :
			System.out.println("글 상세보기 요청이 들어옴!");
			sv=new ContentService();
			sv.execute(request, response);
			
			dp =  request.getRequestDispatcher("board/board_content.jsp");
			dp.forward(request, response);
			break;
			
			
		case "modify" :
			System.out.println("글 수정 페이지로 이동 요청!");
			sv= new ModifyService();
			sv.execute(request, response);
			
			dp=request.getRequestDispatcher("board/board_modify.jsp");
			dp.forward(request, response);
			break;
			
		case "update" :
			System.out.println("글 수정 요청이 들어옴!");
			sv = new UpdateService();
			// 새롭게 입력받은 수정값으로 BoardVO 객체를 생성해서 수정을 진행하세요
			//기존 리스트에 존재하는 객체를 새로운 객체로 교체
			//수정이 완료되면 수정된 글의 상세보기 페이지로 응답이 나가야 합니다.
			sv.execute(request, response);
			
			response.sendRedirect("/JspBasic/content.board?bId=" + request.getParameter("boardNo"));
			break;
			
		case "delete" :
			System.out.println("글 삭제 요청이 들어옴!");
			sv = new DeleteService();
			sv.execute(request, response);
			
			response.sendRedirect("/JspBasic/list.board");
			break;
			
		case "search" :
			System.out.println("작성자 검색 요청이 들어옴!");
			sv = new SearchService();
			sv.execute(request, response);
			
			dp = request.getRequestDispatcher("board/board_list.jsp");
			dp.forward(request, response);
			break;
			
		}
		
		
	}

}

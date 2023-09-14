package com.jsp.board.service;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.board.model.BoardRepository;
import com.jsp.board.model.BoardVO;

public class RegistService implements IBoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		BoardVO vo = new BoardVO();
		vo.setWriter(writer);
		vo.setTitle(title);
		vo.setContent(content);
		vo.setRegDate(LocalDateTime.now());
		
		BoardRepository.getInstance().regist(vo); //글 등록 완료.
	}

}

package com.jsp.board.service;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.board.model.BoardRepository;
import com.jsp.board.model.BoardVO;

public class DeleteService implements IBoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
			int bId = Integer.parseInt(request.getParameter("bId"));
			
			BoardRepository.getInstance().delete(bId); 
		
		
		
		
	}

}

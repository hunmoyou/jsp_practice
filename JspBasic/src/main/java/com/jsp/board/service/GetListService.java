package com.jsp.board.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.board.model.BoardRepository;
import com.jsp.board.model.BoardVO;

public class GetListService implements IBoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		List<BoardVO> list = BoardRepository.getInstance().getList();
		
		//DB로부터 전달받은 글 목록을 세션에 넣기는 좀 아깝습니다,
		//세션 -> 데이터를 계속 유지하는 위한 수단 -> 글 목록을 계속 유지해> 왜?
		//글 목록은 한 번 응답하면 더 이상 필요 없다 -> 계속 갱신되는 데이터이기 때문.
		//응답이 나가면 자동으로 소멸하는 request 객체를 사용하자 
		request.setAttribute("boardList", list);
	}

}

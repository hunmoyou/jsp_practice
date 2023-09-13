package com.jsp.board.model;

import java.time.LocalDateTime;

/*
 모델(model) 계층은 비즈니스 로직을 처리하는 역할을 담당합니다.
 비즈니스 로직이란, 외부 프로그램과 연계 작업 등을 수행하는 로직입니다.(데이터베이스 등...)


 VO (value object)
 : 데이터 베이스에서 조회된 값, 서버 프로그램에서 요청과 함께 얻은 값 등을 
 포장해서 운반하는 값에 관련된 객체입니다.
 VO 클래스는 자바빈 클래스로 생성합니다.

 자바 빈 (java bean)
 웹 프로그래밍에서 어떠한 객체를 가지고 오기 위한 기법이며, 자바 언어로 작성된
  클래스를 일반적으로 부르는 호칭입니다.

  자바빈을 설계하기 위한 규약이 존재합니다.
  1. 은닉(캡슐화)을 구현해서 클래스를 제작합니다. (변수 private, getter/setter)
  2. getter 메서드는 매개변수가 존재하지 않아야 한다.
  3. 생성자는 매개값을 받지 않는 생성자(필수), 매개값을 받는 생성자(선택)가 존재한다.
  4. 모든 getter/setter 메서드는 접근 제한이 public 이어야 한다.
 */

public class BoardVO {
	
	private String writer;
	private String title;
	private String content;
	private LocalDateTime regDate;
	
	public BoardVO() {}

	public BoardVO(String writer, String title, String content, LocalDateTime regDate) {
		super();
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.regDate = regDate;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getRegDate() {
		return regDate;
	}

	public void setRegDate(LocalDateTime regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "BoardVO [writer=" + writer + ", title=" + title + ", content="
				+ content + ", regDate=" + regDate + "]";
	}
	
	
	
	
	

}

package com.jsp.pboard.model;

import java.time.LocalDateTime;

public class PboardVO {
	
	private String writer;
	private String title;
	private String content;
	private LocalDateTime regDate;
	
	public PboardVO() {} //나는 기본 생성자야.

	public PboardVO(String writer, String title, String content, LocalDateTime regDate) {
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
		return "PboardVO [writer=" + writer + ", title=" + title + ", content=" + content + ", regDate=" + regDate
				+ "]";
	}
	
	
	
	
}

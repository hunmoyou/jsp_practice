package com.jsp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
- 서블릿이란 웹 페이지를 자바 언어로만 구성하는 것입니다.
즉, jsp 파일을 자바 언어로만 구성하는 것입니다. 
톰캣을 사용해서 jsp 파일을 자동으로 class로 변환했다면
지금은 직접 클래스를 생성해서 클래스로 요청을 처리해 보자는 것입니다.
*/

public class ServletBasic extends HttpServlet{
	
	//# 서블릿 클래스를 만드는 방법
	//1. HttpServlet 클래스를 상속
	
	//2. 생성자를 선언 (선택)		
	public ServletBasic() {
		System.out.println("페이지에 요청이 들어옴!");
		System.out.println("서블릿 객체가 생성됨!!!");
	}
	
	//3. HttpServlet이 제공하는 상속 메서드를 목적에 맞게 오버라이딩(재정의)합니다.
    //클라이언트가 어떠한 요청을 했을 때 서버는 어떠한 처리와 함께 응답을 할 것인가?
    //init(), doGet(), doPost(), service(), destroy()...
	
	@Override
	public void init() throws ServletException {
		/*
        - 페이지 요청이 들어왔을 때 처음 실행할 로직을 작성.
        - init()은 컨테이너(서버 프로그램)에 의해 서블릿 객체가 생성될 때
        최초 1회 자동으로 호출됩니다.
        - 객체의 생성자와 비슷한 역할을 수행합니다.
        */
       System.out.println("init 메서드 호출!");
	}
	
//	@Override
//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		/*
//        - 페이지 요청이 들어왔을 때 자동으로 호출.
//        - get, post 구분 없이 들어오는 모든 요청과 응답을 관제할 수 있다.
//    	- 매개값으로 요청, 응답 내장 객체가 전달됩니다. 
//        */
//		
//		/*
//		//요청 방식이 뭐니?
//		String method = request.getMethod();
//		//요청 URI가 뭐니?
//		String uri = request.getRequestURI();
//		//요청 파라미터
//		String queryString = request.getQueryString();
//		//요청을 보낸 IP 주소
//		String addr = request.getRemoteAddr();
//		
//		System.out.println("----- 값 확인하기 -----");
//		System.out.println("method: " + method);
//		System.out.println("uri: " + uri);
//		System.out.println("queryString: " + queryString);
//		System.out.println("addr: " + addr);
//		*/
//		
//		//요청과 함께 전달된 파라미터를 낱개로 얻는 방법
//		String account = request.getParameter("account");
//		String password = request.getParameter("password");
//		String name = request.getParameter("name");
//		
//		System.out.println("아이디: " + account);
//		System.out.println("비밀번호: " + password);
//		System.out.println("이름: " + name);
//		
//		//응답하고자 하는  content의 타입과 문자열 인코딩을 셋팅.
//		response.setContentType("text/html");
//		response.setCharacterEncoding("UTF-8");
//		
//		//응답 화면 제작
//		//자바 클래스에서 브라우저로 바로 응답을 구현하기 위해서는
//		//PrintWriter 객체를 사용합니다.
//		
//		PrintWriter w =  response.getWriter();
//		
//		String htmlCode = "";
//		
//		htmlCode += "<!DOCTYPE html> \r\n" 
//                + "<html>\r\n" 
//                + "<head>\r\n" 
//                + "<meta charset=\"UTF-8\"> \r\n"
//                + "<title>서블릿 요청과 응답 연습!</title>"
//                + "</head>\r\n"
//                + "<body>\r\n" 
//                + "\r\n"
//                + "\t아이디: " + account + "<br>\r\n"
//                + "\t비밀번호: " + password + "<br>\r\n"
//                + "\t이름: " + name + "\r\n"
//                + "</body>\r\n"
//                + "</html>";
//		
//		w.write(htmlCode); //버퍼에 응답하고자 하는 데이터 작성하기
//		w.flush(); //버터를 비우면서 작성한 내용을 브라우저로 밀어내기
//		w.close(); //객체 해제
//	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//http 통신 중 get 요청이 발생했을 때 자동으로 호출되는 메서드
		//매개값으로 내장객체 request와 response가 전달되므로
		//객체의 메서드를 통해 파라미터를 가져오거나, 페이지 이동이 가능합니다.
		System.out.println("doGet 메서드가 호출됨!");
		
		System.out.println("아이디: " + req.getParameter("account"));
		System.out.println("비밀번호: " + req.getParameter("password"));
		System.out.println("이름: " + req.getParameter("name"));
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//http 통신 중 post 요청이 발생했을 때 자동으로 호출되는 메서드
        //doGet과 마찬가지로 내장객체 request와 response를 매개값으로 받습니다.
		//post방식으로 요청이 들어왔을 때, 함께 전송된 파라미터를 얻으실 때는
		//인코딩 작업을 다시 거치셔야 합니다.
		
		req.setCharacterEncoding("UTF-8");
		System.out.println("doPost 메서드가 호출됨!");
		
		System.out.println("아이디: " + req.getParameter("account"));
		System.out.println("비밀번호: " + req.getParameter("password"));
		System.out.println("이름: " + req.getParameter("name"));
	}
	
	@Override
	public void destroy() {
		//서블릿 객체가 소멸될 때 호출되는 메서드 (객체 소멸 시 1회 자동으로 호출)
		//대부분 객체 반납이나 소멸 등에 사용.
		System.out.println("destroy 메서드가 호출됨!");
	}
}

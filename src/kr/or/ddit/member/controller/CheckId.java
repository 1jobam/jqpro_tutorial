package kr.or.ddit.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.corba.se.spi.protocol.RequestDispatcherRegistry;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;

/**
 * Servlet implementation class CheckId
 */
@WebServlet("/CheckId")
public class CheckId extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckId() {
        super();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0. 요청시 클라이언트에서 값을 전달 - 입력한 id
		String inId = request.getParameter("id");
		
		//1. service객체 얻어오기
		IMemberService service = MemberServiceImpl.getSerivceInstance();
		
		//2. service메소드 호출 - 결과값 받기
		String resId = service.checkById(inId);
		
		//3. 결과값을 request에 저장하기
		request.setAttribute("resId", resId);
		request.setAttribute("inId", inId);
		
		//4. 결과값을 출력(json데이터 생성) - view페이지로 이동(forword)
		RequestDispatcher disp = request.getRequestDispatcher("0226/checkId.jsp");
		
		disp.forward(request, response);
	}

}

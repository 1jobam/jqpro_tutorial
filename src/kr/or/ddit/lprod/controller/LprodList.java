package kr.or.ddit.lprod.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.lprod.service.ILprodService;
import kr.or.ddit.lprod.service.LprodServiceImpl;
import kr.or.ddit.lprod.vo.LprodVO;

/**
 * Servlet implementation class LprodList
 */
@WebServlet("/LprodList")
public class LprodList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LprodList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//0. 요청시 클라이언트에서 값을 전달 - 없음
		
		//1. service객체 얻어오기
		ILprodService service = LprodServiceImpl.getService();
		
		//2. service메소드 호출 - 결과값 받기
		List<LprodVO> list = service.listLprod(); 
		
		//3. 결과값을 request에 저장하기
		request.setAttribute("listLprod", list);
		RequestDispatcher disp = request.getRequestDispatcher("0224/lprod.jsp");
		
		//4. 결과값을 출력(json데이터 생성) - view페이지로 이동(forword)
		disp.forward(request, response);
	}

}

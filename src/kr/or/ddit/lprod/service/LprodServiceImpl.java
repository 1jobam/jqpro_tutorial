package kr.or.ddit.lprod.service;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.lprod.dao.ILprodDao;
import kr.or.ddit.lprod.dao.LprodDaoImpl;
import kr.or.ddit.lprod.vo.LprodVO;

public class LprodServiceImpl implements ILprodService {
	
	private static ILprodService service;
	private ILprodDao dao;
	
	private LprodServiceImpl(){
		dao = LprodDaoImpl.getDaoInstance();
	}
	
	public static ILprodService getService(){
		if(service == null){
			service = new LprodServiceImpl();
		}
		return service;
	}
	

	@Override
	public List<LprodVO> listLprod() {
		//1. 변수선언
		List<LprodVO> list = null;
		
		//2. dao메서드 실행
		try {
			list = dao.listLprod();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//3. 변수 리턴
		return list;
	}

}

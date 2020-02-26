package kr.or.ddit.prod.service;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.prod.dao.IProdDao;
import kr.or.ddit.prod.dao.ProdDaoImpl;
import kr.or.ddit.prod.vo.ProdVO;

public class ProdServiceImpl implements IProdService {
	
	private static IProdService service;
	private IProdDao dao;
	
	private ProdServiceImpl(){
		dao = ProdDaoImpl.getDaoInstance();
	}
	
	public static IProdService getServiceInstance(){
		if(service == null){
			service = new ProdServiceImpl();
		}
		return service;
	}

	@Override
	public List<ProdVO> prodNames(String lprod_gu) {
		//변수선언
		List<ProdVO> list = null;
		
		//dao메서드 실행
		try {
			list = dao.prodNames(lprod_gu);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//변수리턴
		return list;
	}

	@Override
	public ProdVO prodDetail(String lprod_id) {
		ProdVO pid = null;
		try {
			pid = dao.prodDetail(lprod_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pid;
	}

}

package kr.or.ddit.lprod.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.config.SqlMapClientFactory;
import kr.or.ddit.lprod.vo.LprodVO;

/*
 * SqlMapClient 얻기
 * dao객체 생성, 리턴 - service에서 사용
 */
public class LprodDaoImpl implements ILprodDao {
	
	private SqlMapClient client;
	private static ILprodDao dao;
	
	private LprodDaoImpl(){
		client = SqlMapClientFactory.getSMClient();
	}
	
	public static ILprodDao getDaoInstance(){
		if(dao == null){
			dao = new LprodDaoImpl();
		}
		return dao;
	}


	@Override
	public List<LprodVO> listLprod() throws SQLException {
		return client.queryForList("lprod.listLprod");
	}

}

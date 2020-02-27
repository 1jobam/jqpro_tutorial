package kr.or.ddit.member.dao;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.ibatis.config.SqlMapClientFactory;
import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.member.vo.ZipVO;

import com.ibatis.sqlmap.client.SqlMapClient;

public class MemberDaoImpl implements IMemberDao {
	
	private SqlMapClient client;
	private static IMemberDao dao;
	
	private MemberDaoImpl(){
		client = SqlMapClientFactory.getSMClient();
	}
	
	public static IMemberDao getDaoInstance(){
		if(dao == null){
			dao = new MemberDaoImpl();
		}
		return dao;
	}

	@Override
	public String checkById(String mem_id) throws SQLException {
		return (String) client.queryForObject("member.checkById", mem_id);
	}

	@Override
	public List<ZipVO> selectByDong(String dong) throws SQLException {
		return client.queryForList("member.selectByDong", dong);
	}

	@Override
	public String insertMember(MemberVO vo) throws SQLException {
		return (String) client.insert("member.inserMember", vo);
	}

}

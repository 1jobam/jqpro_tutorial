package kr.or.ddit.member.service;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.member.dao.IMemberDao;
import kr.or.ddit.member.dao.MemberDaoImpl;
import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.member.vo.ZipVO;

public class MemberServiceImpl implements IMemberService {

	private static IMemberService service;
	private IMemberDao dao;
	
	private MemberServiceImpl(){
		dao = MemberDaoImpl.getDaoInstance();
	}
	
	public static IMemberService getSerivceInstance(){
		if(service == null){
			service = new MemberServiceImpl();
		}
		return service;
	}
	
	@Override
	public String checkById(String mem_id) {
		String id = null;
		
		try {
			id = dao.checkById(mem_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return id;
	}

	@Override
	public List<ZipVO> selectByDong(String dong) {
		List<ZipVO> vo = null;
		
		try {
			vo = dao.selectByDong(dong);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return vo;
	}

	@Override
	public String insertMember(MemberVO vo) {
		String mem_id = null;
		
		try {
			mem_id = dao.insertMember(vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return mem_id;
	}

}

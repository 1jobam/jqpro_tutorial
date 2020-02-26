<%@page import="kr.or.ddit.lprod.vo.LprodVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.ibatis.config.SqlMapClientFactory"%>
<%@page import="com.ibatis.sqlmap.client.SqlMapClient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
[
<%
	//클라이언트 요청시 전달 되는 값을 받는다
	
	//처리(CRUD)한다
	//1. SqlMapClient객체 얻어오기
	SqlMapClient client = SqlMapClientFactory.getSMClient();

	//2. mapper파일의 namespace이름과 id이름을 이용하여
	//sql문 실행 - 결과를 받는다
	List<LprodVO> list = client.queryForList("lprod.listLprod");
	
	//3. list에서 한줄씩 꺼내어 json object배열을 만든다
	for(int i = 0; i < list.size(); i++){
		LprodVO vo = list.get(i);
		if(i > 0) out.print(",");
%>
		{
			"id" : "<%= vo.getLprod_id() %>",
			"gu" : "<%= vo.getLprod_gu() %>",
			"nm" : "<%= vo.getLprod_nm() %>"
		}
		
<%	}
	
	//처리결과를 가지고 응답데이타(json 배열)를 만든다
	
%>
]
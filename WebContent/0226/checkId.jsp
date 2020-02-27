<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%
	String id = (String) request.getAttribute("resId");
	String inId = (String) request.getAttribute("inId");
	//jsp에서 요청하여 리턴받는 값은 String 이고 아이디 또는 null이다
	
	if(id == null){
		//사용가능
%>
	{
		"sw" : "<%= inId %> 사용가능합니다"
	}
		
<%	}else{
		//사용불가능
%>
	{
		"sw" : "<%= id %>사용불가능합니다"
	}

<%		
	}

%>
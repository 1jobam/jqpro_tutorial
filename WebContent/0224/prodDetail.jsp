<%@page import="kr.or.ddit.prod.vo.ProdVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	ProdVO vo = (ProdVO) request.getAttribute("pid");
%>

{
	"id" : "<%= vo.getProd_id() %>",
	"name" : "<%= vo.getProd_name() %>",
	"lgu" : "<%= vo.getProd_lgu() %>",
	"buyer" : "<%= vo.getProd_buyer() %>",
	"cost" : "<%= vo.getProd_cost() %>",
	"price" : "<%= vo.getProd_price() %>", 
	"sale" : "<%= vo.getProd_sale() %>",
	"outline" : "<%= vo.getProd_outline() %>", 
	"detail" : "<%= vo.getProd_detail() %>",
	"totalstock" : "<%= vo.getProd_totalstock() %>",
	"properstock" : "<%= vo.getProd_properstock() %>",
	"size" : "<%= vo.getProd_size() %>",
	"color" : "<%= vo.getProd_color() %>",
	"unit" : "<%= vo.getProd_unit() %>",
	"qtyin" : "<%= vo.getProd_qtyin() %>",
	"qtysale" : "<%= vo.getProd_qtysale() %>"
}
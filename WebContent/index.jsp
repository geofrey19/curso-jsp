<jsp:useBean id="calcula" class="beans.BeanCursoJsp" type="beans.BeanCursoJsp" scope="page"></jsp:useBean>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="myprefix" uri="WEB-INF/testetag.tld"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="cabecalho.jsp"></jsp:include>
	<h3>Conteúdo da página</h3>
	<%=calcula.calcula(50) %>
	<jsp:include page="rodape.jsp"></jsp:include>
	<%--@ include file="pagina-include.jsp" --%>
	<myprefix:minhatag/>
	<%--@ page import="java.util.Date" --%>
	<%--= "dta de hoje:"+ new Date() --%>
	<%--@ page errorPage="receber-nome2.jsp" --%>
	<%--=100/0 --%>
	<h1>Bem vindo ao curso de JSP</h1>
	<%= "seu sucesso garantido" %>
	
	<form action="receber-nome.jsp">
		<input type="text" id="nome" name ="nome"/>
		<input type="submit" value="Enviar"/>
	</form>
	
	<%! int cont = 2;
		public int  retorna(int n){
			return n* 3;
		}
	%>
	<%=retorna(8)%>
	<%= application.getInitParameter("estado") %>
	<% session.setAttribute("curso", "JSP");  %>
	
</body>
</html>
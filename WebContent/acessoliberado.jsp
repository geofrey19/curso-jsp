<jsp:useBean id="calcula" class="beans.BeanCursoJsp"
	type="beans.BeanCursoJsp" scope="page"></jsp:useBean>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Acesso liberado</h3>
	<a href="salvarUsuario?acao=listartodos"><img
		alt="cadastro de usuário" title="usuario" src="resources/img/user.jpg"
		width="100px" height="100px"></a>
	<a href="ServletsProduto?acao=listartodos"><img
		alt="cadastro de produto" title="produto" src="resources/img/produtos.png"
		width="80px" height="75px"></a>
</body>
</html>
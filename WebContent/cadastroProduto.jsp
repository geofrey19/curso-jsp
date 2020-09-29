<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Produtos</title>
<link rel="stylesheet" href="resources/css/cadastro.css">

</head>
<body>
<a href="acessoliberado.jsp">Inicio</a>
<a href="index.jsp">Sair</a>
	<center>
		<h1>Cadastro de produto</h1>
		<h3 style="color: orange">${msg}</h3>
	</center>

	<form action="ServletsProduto" method="post" id="formProd" onsubmit=" return validarCampos()? true : false">
		<ul class="form-style-1">
			<li>
				<table>
					<td>Código:</td>
					<td><input type="text" id="id" name="id" value="${prod.id}"></td>
					</tr>

					<tr>
						<td>Nome:</td>
						<td><input type="text" id="nome" name="nome"
							value="${prod.nome}" class="field-long"></td>
					</tr>

					<tr>
						<td>Quantidade:</td>
						<td><input type="text" id="quantidade" name="quantidade"
							value="${prod.quantidade}" class="field-long"></td>
					</tr>
					<tr>
						<td>Valor:</td>
						<td><input type="text" id="valor" name="valor"
							value="${prod.valor}" class="field-long"></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" value="Salvar"> <input
							type="submit" value="Cancelar"
							onclick="document.getElementById('formProd').action='ServletsProduto?acao=reset'"></td>
					</tr>
				</table>
			</li>
		</ul>
	</form>

	<div class="container">
		<table class="responsive-table">
			<caption>Produtos cadastrados</caption>
			<tr>
				<th>Id</th>
				<th>Nome</th>
				<th>Quantidade</th>
				<th>Valor</th>
			</tr>
			<c:forEach items="${produtos}" var="prod">
				<tr>
					<td style="width: 250px"><c:out value="${prod.id}"></c:out></td>
					<td style="width: 250px"><c:out value="${prod.nome}"></c:out></td>
					<td><c:out value="${prod.quantidade}"></c:out></td>
					<td><c:out value="${prod.valor}"></c:out></td>
					<td><a href="ServletsProduto?acao=delete&prod=${prod.id}"><img
							alt="Excluir" title="Excluir" src="resources/img/excluir.png"
							width="20px" height="20px"></a></td>
					<td><a href="ServletsProduto?acao=editar&prod=${prod.id}"><img
							alt="Editar" title="Editar" src="resources/img/editar.png"
							width="20px" height="20px"></a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<script type="text/javascript">
		function validarCampos(){
			if (document.getElementById("nome").value == ''){
				alert('Informe o nome');
				return false;
			}else if (document.getElementById("quantidade").value == ''){
				alert('Informe a quantidade');
				return false;
			}else if (document.getElementById("valor").value == ''){
				alert('Informe o valor');
				return false;
			}
			
			return true;
		}
	</script>
</body>
</html>
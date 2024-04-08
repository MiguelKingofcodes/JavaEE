<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Agenda de Contatos</title>
		<link rel="stylesheet" href="Novo_style.css">
	</head>
	<body>
			<form name="FRM_Contato" class= "image" action="Update">
				<div class="Moldura">
					<h2>Editar Usuário</h2>
					<input type="text" name="idcon" value="<%= request.getAttribute("idcon") %>" readonly>
			
					<input type="text" name="Nome" placeholder="Nome:" value="<%= request.getAttribute("nome") %> ">

					<input type="text" name="Phone" placeholder="Telefone: " value="<%= request.getAttribute("telefone") %> ">

					<input type="text" name="Email" placeholder="Email: " value="<%= request.getAttribute("email") %> ">
					
					<input id="Save_Button" type="submit" value="Salvar" onclick="">
				</div>
			</form>
	</body>
	<script src="Javascript/Validacao.js" type="text/javascript"></script>
</html>
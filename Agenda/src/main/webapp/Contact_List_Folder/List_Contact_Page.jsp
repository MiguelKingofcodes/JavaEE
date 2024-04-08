<%@page import="controller.Controller"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="model.JavaBeans"%>
<%@page import="java.util.ArrayList"%>

<%
	ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("contatos");
%>
    
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
		<title>
			Agenda de Contatos...
		</title>
		
		<link rel="icon" href="Images/Favicon.png">
		<link rel="stylesheet" href="index.css"> 
		
	</head>
	<body>
		
		<div class="Moldura">
			<img alt="Icon Agenda..." src="Images/Agenda_image.png">
			<h1>Agenda de Contados!</h1>
		</div>
		<div class="menu">
			<a href="Novo.html" class="Access_Button">
				Novo Contato
			</a>
			<a href="Contact_List_Folder" class="Access_Button">
				Ver lista de contatos
			</a>
		</div>
		
		<table id="tabela_contatos">
		<thead>
			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>Telefone</th>
				<th>E-mail</th>
				<th>Opções</th>
			</tr>
		</thead>
		<%for (int i=0; i < lista.size(); i++){ %>
			<tr>
				<td id="primary_key"><%= lista.get(i).getIdcon() %></td>
				<td><%= lista.get(i).getNome() %></td>
				<td><%= lista.get(i).getPhone() %></td>
				<td><%= lista.get(i).getEmail() %></td>
				<td class="options_block">
					<a href="select?idcon=<%= lista.get(i).getIdcon() %>" class="Edit_Button">Editar</a>
					<a href="javascript:confirmar(<%= lista.get(i).getIdcon() %>)" class="Delete_Button">Excluír</a>
				</td>
			</tr>
		<%}%>
		</table>

		
		<a href="main"><button class="Access_Button">
			Contatos
		</button></a>
		<a href="report"><button class="Access_Button">
			Imprimir
		</button></a>
		
		
	</body>
	<script src="Javascript/Confirmation.js">
	</script>
</html>
<%@page import="java.util.List"%>
<%@page import="br.com.resource.controller.rn.GerenciaProduto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%
	List<String[]> lista = GerenciaProduto.gerarListaProdutos();
	pageContext.setAttribute("lista", lista);
%>
<c:out value="${resposta}"/>

<jsp:include page="template/cadastrarForm.html"/>
<jsp:include page="template/topo-tabela.html"/>

<c:forEach var="item" items="${lista}">
	<tr>
		<td>${item[1]}</td>
		<td>${item[2]}</td>
		<td>${item[3]}</td>
		<td><button onclick="getAtualizar('${item[0]}',
										  '${item[1]}',
										  '${item[2]}',
										  '${item[3]}')">Alterar</button></td>
		<td><a onclick="">Excluir</a></td>
	</tr>
</c:forEach>          
<jsp:include page="template/fim-tabela.html"/>
<jsp:include page="template/rodape.html"/>
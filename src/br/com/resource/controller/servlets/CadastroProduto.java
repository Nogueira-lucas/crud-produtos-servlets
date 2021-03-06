package br.com.resource.controller.servlets;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.resource.controller.regranegocio.GerenciaProduto;
import br.com.resource.model.Produto;

@WebServlet("/cadastroProduto")
public class CadastroProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CadastroProduto() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		Produto produto = new Produto();
		try {
			produto.setNome(request.getParameter("nome"));
			produto.setFabricante(request.getParameter("fabricante"));
			produto.setValor(new BigDecimal(request.getParameter("valor").replace(",", ".")));
			
		}catch (NumberFormatException e) {
			session.setAttribute("resposta", "Erro ao cadastrar: campo(s) vazio(s)");
		}
		
		String resposta = GerenciaProduto.cadastrarProduto(produto);
		
		session.setAttribute("resposta", resposta);
		
		session = request.getSession(false);
		response.sendRedirect("index.jsp");
		
	}

}

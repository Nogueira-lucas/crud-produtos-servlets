package br.com.resource.controller.servlets;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.resource.controller.regranegocio.GerenciaProduto;
import br.com.resource.model.Produto;

@WebServlet("/ExcluirProduto")
public class ExcluirProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ExcluirProduto() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Produto produto = new Produto();
		HttpSession session = request.getSession(true);
		try {
			produto.setId(Integer.parseInt(request.getParameter("id")));
			produto.setNome(request.getParameter("nome"));
			produto.setFabricante(request.getParameter("fabricante"));
			produto.setValor(new BigDecimal(request.getParameter("valor").replace(",", ".")));
			
		}catch (NumberFormatException e) {
			session.setAttribute("resposta", "Erro ao excluir: campo(s) vazio(s)");
		}
		
		String resposta;
		try {
			resposta = GerenciaProduto.excluirProduto(produto);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resposta = "Não foi possível excluir!";
		}
		
		session.setAttribute("resposta", resposta);
		session = request.getSession(false);
		response.sendRedirect("index.jsp");
	}

}

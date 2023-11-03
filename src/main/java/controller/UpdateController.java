package controller;

import java.io.IOException;

import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuarioDAO;
import model.Usuario;

@WebServlet("/UpdateController")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String nome = req.getParameter("userName");
		
		try {
			UsuarioDAO uDAO = new UsuarioDAO();
			Usuario usuario = uDAO.findUsuario(id);
			
			req.setAttribute("usuario", usuario);
			
			RequestDispatcher rd = req.getRequestDispatcher("atualizar.jsp");
			rd.forward(req, res);
			
			System.out.println(nome);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		try {
			Usuario usuario = new Usuario();
			usuario.setId(Integer.parseInt(req.getParameter("id")));
			usuario.setUserName(req.getParameter("userName"));
			usuario.setUserLogin(req.getParameter("userLogin"));
			usuario.setUserSenha(req.getParameter("userSenha"));

			
			
			UsuarioDAO uDAO = new UsuarioDAO();
			uDAO.updateUsuario(usuario);
			System.out.println(usuario);
			res.sendRedirect("ReadController");
		} catch (Exception e) {
			
		}
		
		
		
		
	}

}


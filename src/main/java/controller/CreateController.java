package controller;

import java.io.IOException;
import java.sql.SQLException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuarioDAO;
import model.Usuario;


@WebServlet("/CreateController")
public class CreateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

 
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Usuario usuario = new Usuario();
		
		usuario.setUserName(req.getParameter("userName"));
		usuario.setUserLogin(req.getParameter("userLogin"));
		usuario.setUserSenha(req.getParameter("userSenha"));	
		
		
		try {
			UsuarioDAO usuariodao = new UsuarioDAO();
			usuariodao.createUsuario(usuario);
			
			
			res.sendRedirect("ReadController");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		
	}

}

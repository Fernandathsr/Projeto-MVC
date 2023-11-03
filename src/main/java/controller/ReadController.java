package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuarioDAO;
import model.Usuario;

@WebServlet("/ReadController")
public class ReadController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		try {
			UsuarioDAO uDAO = new UsuarioDAO();
			List<Usuario> usuarios = uDAO.findUsuario();
			req.setAttribute("usuarios", usuarios);
			
			RequestDispatcher rd = req.getRequestDispatcher("usuarios.jsp");
			rd.forward(req, res);
			System.out.println(usuarios);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}


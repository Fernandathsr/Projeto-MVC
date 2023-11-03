package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.DataBaseConnection;
import model.Usuario;

public class UsuarioDAO {

	private Connection connection;
	private String sql;

	public UsuarioDAO() throws SQLException {
		connection = DataBaseConnection.createConnection();
	}

	public void closeConnection() {
		try {
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void createUsuario(Usuario usuario) {
		sql = "INSERT INTO usuario(userName,userLogin,userSenha) VALUES (?,?,?)";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {

			stmt.setString(1, usuario.getUserName());
			stmt.setString(2, usuario.getUserLogin());
			stmt.setString(3, usuario.getUserSenha());

			stmt.executeUpdate();

			System.out.println("Usuario criado com sucesso!");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Usuario findUsuario(int id) {
		Usuario usuario = null;
		sql = "SELECT * FROM usuario WHERE id=?";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {

			stmt.setInt(1, id);
			ResultSet r = stmt.executeQuery();

			if (r.next()) {
				Usuario u = new Usuario();
				u.setId(r.getInt("id"));
				u.setUserName(r.getString("userName"));
				u.setUserLogin(r.getString("userLogin"));
				u.setUserSenha(r.getString("userSenha"));
				
				return u;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return usuario;
	}
	
	
	
	public List<Usuario> findUsuario() {

		String sql = "SELECT * FROM usuario";

		List<Usuario> usuarios = new ArrayList<Usuario>();

		ResultSet r = null;

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			r = stmt.executeQuery();

			while (r.next()) {
				Usuario usuario = new Usuario();
				usuario = new Usuario();
				usuario.setId(r.getInt("id"));
				usuario.setUserName(r.getString("userName"));
				usuario.setUserLogin(r.getString("userLogin"));
				usuario.setUserSenha(r.getString("userSenha"));


				usuarios.add(usuario);
			}
		} catch (Exception e) {

			e.printStackTrace();

		}
		return usuarios;

	}
	
	
	

	public void updateUsuario(Usuario usuario) {
		sql = "UPDATE usuario SET userName = ?, userLogin = ?, userSenha = ? WHERE id = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, usuario.getUserName());
			stmt.setString(2, usuario.getUserLogin());
			stmt.setString(3, usuario.getUserSenha());
			stmt.setInt(4, usuario.getId());

			stmt.executeUpdate();
	
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void deleteUsuario(int id) {
		sql = "DELETE FROM usuario WHERE id = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, id);
			stmt.executeUpdate();

			System.out.println("Usuario Deletado com sucesso!");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

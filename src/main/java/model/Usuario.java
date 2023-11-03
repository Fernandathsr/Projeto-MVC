package model;


public class Usuario {

	private int id;

	private String userName;

	private String userLogin;

	private String userSenha;


	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Usuario(int id, String username, String userLogin, String userSenha) {
		super();
		this.id = id;
		this.userName = username;
		this.userLogin = userLogin;
		this.userName = userSenha;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserLogin() {
		return userLogin;
	}

	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}

	public String getUserSenha() {
		return userSenha;
	}

	public void setUserSenha(String userSenha) {
		this.userSenha = userSenha;
	}

	

}

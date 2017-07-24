package app.model;

public class LoginModel {
private int id_login;
private String user;
private String login;
private String access;





public LoginModel() {
	super();
}



public LoginModel(int id_login, String user, String login, String access) {
	super();
	this.id_login = id_login;
	this.user = user;
	this.login = login;
	this.access = access;
}



public int getId_login() {
	return id_login;
}
public void setId_login(int id_login) {
	this.id_login = id_login;
}
public String getUser() {
	return user;
}
public void setUser(String user) {
	this.user = user;
}
public String getLogin() {
	return login;
}
public void setLogin(String login) {
	this.login = login;
}
public String getAccess() {
	return access;
}
public void setAccess(String access) {
	this.access = access;
}
	
	
	
}

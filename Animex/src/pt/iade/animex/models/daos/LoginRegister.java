package pt.iade.animex.models.daos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class LoginRegister {
	
	public static boolean userVerify(String user) {
		boolean existe = false;
		try {
			PreparedStatement statement = DBConnector.getConnection().prepareStatement("SELECT username FROM utilizador where username = '"+user+"'");
			ResultSet results = statement.executeQuery();
			if (results.next()) {
				existe = true;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return existe;
	}
	
	public static void createAccount(String user, String password,String data) {
		try {
			PreparedStatement statement = DBConnector.getConnection().prepareStatement("INSERT INTO utilizador (username, password,data) values (?,?,?)");
			statement.setString(1, user);
			statement.setString(2, password);
			statement.setString(3, data);
			statement.executeUpdate();

		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static boolean passwordVerify(String user, String password) {
		boolean verificar = false;
		try {
			PreparedStatement statement = DBConnector.getConnection().prepareStatement("SELECT password FROM utilizador where username = '"+user+"'");
			ResultSet results = statement.executeQuery();
			if (results.next()) {
				String password2 = results.getString(1);
					if(password2.equals(password)) {
					verificar=true;
					}
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return verificar;
	}
	
	public static boolean adminVerify(String user) {
		boolean verificar = false;
		try {
			PreparedStatement statement = DBConnector.getConnection().prepareStatement("SELECT admin FROM utilizador where username = '"+user+"'");
			ResultSet results = statement.executeQuery();
			if (results.next()) {
				verificar= results.getBoolean(1);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return verificar;
	}}

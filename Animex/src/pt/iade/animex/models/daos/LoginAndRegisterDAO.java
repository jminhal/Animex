package pt.iade.animex.models.daos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



/**
 * Class responsavel por todas as queries para Login e Registo.
 */

public class LoginAndRegisterDAO {
	
	public static boolean userVerify(String user) {
		boolean existe = false;
		try {
			PreparedStatement statement = DBConnector.getConnection().prepareStatement("SELECT username FROM utilizador where username = ?");
			statement.setString(1, user);
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
			PreparedStatement statement = DBConnector.getConnection().prepareStatement("SELECT password FROM utilizador where username = ?");
			statement.setString(1, user);
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
	
	public static boolean ModVerify(String user) {

		boolean verificar = false;
		try {
			PreparedStatement statement = DBConnector.getConnection().prepareStatement("SELECT admin FROM utilizador where username = ?");
			statement.setString(1, user);
			ResultSet results = statement.executeQuery();
			if (results.next()) {
				verificar= results.getBoolean(1);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return verificar;
	}
	
	public static int userID(String nickname) {
		try {
			PreparedStatement statement = DBConnector.getConnection().prepareStatement("SELECT user_id FROM utilizador where username = '"+nickname+"'");
			ResultSet results = statement.executeQuery();
			if (results.next()) {
				return results.getInt(1);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	}

package pt.iade.animex.models.daos;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnector {
	
	private static Connection connection = null;
	static Statement statement;
	
	public String host, database, username, password;
	public int port;
	
	/**
	 * Metodo para abrir conexao com a base de dados
	 */
	public static void abrirConexao() {
		String host = "localhost";
		String database = "Animex";
		String username = "root";
		String password = "";
		Integer port = 3306;
		
		String URL = "jdbc:mysql://" + host + ":" + port + "/" + database;
		
		try {
			//Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(URL, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		return connection;
	}

}

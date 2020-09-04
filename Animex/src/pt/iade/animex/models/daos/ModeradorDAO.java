package pt.iade.animex.models.daos;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ModeradorDAO {
	public static void addAnime(String nome, String autor,String data, float score,int episodes,int seasons,String genre, String synopsis,String link, byte[] imagem) {
		InputStream imagem1 = new ByteArrayInputStream(imagem);
		try {
			//Vai verificar se o nome do jogo já existe na base de dados
			PreparedStatement statement = DBConnector.getConnection().prepareStatement("SELECT * FROM animes WHERE nome=?");
			statement.setString(1, nome);
			ResultSet results = statement.executeQuery();
			if (!results.next()) {
				//se nao existir vai adiconar na base de dados
				PreparedStatement statement1 = DBConnector.getConnection().prepareStatement("INSERT INTO animes (nome, autor,data,score,episodes,seasons,genre,synopsis,link,imagem) values (?,?,?,?,?,?,?,?,?,?)");
				statement1.setString(1, nome);
				statement1.setString(2, autor);
				statement1.setString(3, data);
				statement1.setFloat(4, score);
				statement1.setInt(5, episodes);
				statement1.setInt(6, seasons);
				statement1.setString(7, genre);
				statement1.setString(8, synopsis);
				statement1.setString(9, link);
				statement1.setBinaryStream(10, imagem1);
				statement1.executeUpdate();
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}

package pt.iade.animex.models.daos;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MIDAO {
	public static void addAnime(String nome, String autor,String data, float score,int episodes,int seasons,String genre, String synopsis,String link, byte[] imagem) {
		try {
			PreparedStatement statement = DBConnector.getConnection().prepareStatement("INSERT INTO anime (nome, autor,data,score,episodes,seasons,genre,synopsis,link,imagem) values (?,?,?,?,?,?,?,?,?,?)");
			statement.setString(1, nome);
			statement.setString(2, autor);
			statement.setString(3, data);
			statement.setFloat(4, score);
			statement.setInt(5, episodes);
			statement.setInt(6, seasons);
			statement.setString(7, genre);
			statement.setString(8, synopsis);
			statement.setString(9, link);
			statement.setBytes(10, imagem);
			statement.executeUpdate();

		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}

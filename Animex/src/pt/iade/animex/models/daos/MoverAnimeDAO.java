package pt.iade.animex.models.daos;

import java.sql.PreparedStatement;
import java.sql.SQLException;


public class MoverAnimeDAO {
	public static void moverAnimeBacktoWatch(int anime_id, int user_id) {
		try {
			//Adicionar o jogo na nova categoria
			PreparedStatement statement3 = DBConnector.getConnection().prepareStatement("INSERT INTO voltarver (anime_id, user_id) VALUES (?,?)");
			statement3.setInt(1, anime_id);
			statement3.setInt(2, user_id);
			statement3.executeUpdate();
			
			//Remover o jogo da categoria antiga
			PreparedStatement statement2 = DBConnector.getConnection().prepareStatement("DELETE FROM continuarver WHERE anime_id = ? and user_id = ?");
			statement2.setInt(1, anime_id);
			statement2.setInt(2, user_id);
			statement2.executeUpdate();
			
			//Dialog.warningDialog("Jogo Movido!", "Jogo movido para arquivo com sucesso!");
			
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void moverAnimeConinue(int anime_id, int user_id) {
		try {
			//Adicionar o jogo na nova categoria
			PreparedStatement statement3 = DBConnector.getConnection().prepareStatement("INSERT INTO continuarver (anime_id, user_id) VALUES (?,?)");
			statement3.setInt(1, anime_id);
			statement3.setInt(2, user_id);
			statement3.executeUpdate();
			
			//Remover o jogo da categoria antiga
			PreparedStatement statement2 = DBConnector.getConnection().prepareStatement("DELETE FROM voltarver WHERE anime_id = ? and user_id = ?");
			statement2.setInt(1, anime_id);
			statement2.setInt(2, user_id);
			statement2.executeUpdate();
			
			//Dialog.warningDialog("Jogo Movido!", "Jogo movido para arquivo com sucesso!");
			
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
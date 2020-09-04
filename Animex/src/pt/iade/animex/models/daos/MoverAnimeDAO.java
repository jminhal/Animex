package pt.iade.animex.models.daos;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Class responsavel por todas as queries para Mover Animes.
 */
public class MoverAnimeDAO {
	//Metodo para mover jogo do continuar a ver para o voltarver
	public static void moverAnimeVoltarVer(int anime_id, int user_id) {
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
	//Metodo para mover jogo do voltarver a ver para o Continuar
	public static void moverAnimeContinuarVer(int anime_id, int user_id) {
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

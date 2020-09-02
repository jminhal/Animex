package pt.iade.animex.models.daos;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.util.Callback;
import pt.iade.animex.controllers.InfoAnimeController;
import pt.iade.animex.controllers.LoginController;
import pt.iade.animex.models.Episode;



public class LoadTrackingDAO {

	
	public static void loadAnimeTracking(int user_id, int anime_id, ListView<Episode> listViewEpisodes) {
			
		
		ObservableList<Episode> episodiosVistos = FXCollections.observableArrayList();


		try {
			//%or% Finds any values that have "or" in any position
			PreparedStatement statement = DBConnector.getConnection().prepareStatement("select episode from tracking where anime_id=? and user_id=?");
			statement.setInt(1, anime_id);
			statement.setInt(2, user_id);
			ResultSet results = statement.executeQuery();
			while(results.next()){
				
				int episode = results.getInt("episode");
                
				episodiosVistos.add(new Episode(episode, true)); //Vai adicionar os episodios ja vistos no array
				

			}
			for (Episode ep : episodiosVistos) {
                System.out.println("epvistos: " + ep.getEpisode());
            }
			int numeroEpisodiosAnime = InfoAnimeController.numeroEpisodios;
			for (int i = 1; i < numeroEpisodiosAnime+1; i++) {
				if (episodiosVistos.contains(new Episode(i, true))) {
                    episodiosVistos.add(new Episode(i, false));
				}
			}
			
			listViewEpisodes.setCellFactory(new Callback<ListView<Episode>,ListCell<Episode>>() {
				
				@Override
				public ListCell<Episode> call(ListView<Episode> arg0) {
					ListCell<Episode> cell = new ListCell<Episode>() {
						@Override
						protected void updateItem(Episode episode, boolean btl) {
							super.updateItem(episode, btl);
							if (episode != null) {
								
								CheckBox checkbox = new CheckBox();
								if (episode.isVisto()) {
									checkbox.setSelected(true);
								}
								else {
									checkbox.setSelected(false);
								}
								checkbox.setOnAction(new EventHandler<ActionEvent>() {
						            @Override  //Metodo para abrir a janela de adicionar jogo na Biblioteca, Arquivo ou Lista de desejos
						            public void handle(ActionEvent event) {
						            	if(checkbox.isSelected()) {
						            		addEpisodioVisto(LoginController.userID,LoadAnimeDAO.anime_id,episode.getEpisode());
						            	}
						            	else {
						            		removeEpisodioVisto(LoginController.userID,LoadAnimeDAO.anime_id,episode.getEpisode());
						            	}
						            }
						        });
								
								HBox hBox = new HBox(5);
			                    hBox.setAlignment(Pos.CENTER_LEFT); 	
			                    hBox.getChildren().addAll(
			                            new Label(String.valueOf(episode.getEpisode())),
			                    		new Label("",checkbox));
			                    setGraphic(hBox);
			                    
							}
						}
					};
					return cell;
				}
				
			});
			listViewEpisodes.setItems(episodiosVistos);
		}
		catch (SQLException e) {
			e.printStackTrace();
	}
	}
	public static void addEpisodioVisto(int user_id, int anime_id, int episode ) {
		try {
			PreparedStatement statement = DBConnector.getConnection().prepareStatement("INSERT INTO  tracking (user_id, anime_id,episode) VALUES (?,?,?)");
			statement.setInt(1, user_id);
			statement.setInt(2, anime_id);
			statement.setInt(3, episode);
			statement.executeUpdate();

		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void removeEpisodioVisto(int user_id, int anime_id, int episode ) {
		try {
			PreparedStatement statement = DBConnector.getConnection().prepareStatement("DELETE from tracking WHERE user_id = ? and anime_id = ? and episode = ?");
			statement.setInt(1, user_id);
			statement.setInt(2, anime_id);
			statement.setInt(3, episode);
			statement.executeUpdate();

		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

}


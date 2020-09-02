package pt.iade.animex.controllers;


import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import pt.iade.animex.models.Episode;
import pt.iade.animex.models.daos.LoadAnimeDAO;
import pt.iade.animex.models.daos.LoadTrackingDAO;

public class ListController {

    @FXML
    private ListView<Episode> listaEpisodios;

    @FXML
    private ImageView imgAnime;

    @FXML
    private Label nomeAnime;
    @FXML
    private void initialize() { 
		
    	LoadTrackingDAO.loadAnimeTracking(LoginController.userID, LoadAnimeDAO.anime_id, listaEpisodios);

	}

}

package pt.iade.animex.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import pt.iade.animex.models.Anime;
import pt.iade.animex.models.daos.LoadAnimeDAO;

public class BacktoWatchController {

    @FXML
    private ListView<Anime> ListViewAnimes;

    @FXML
    private TextField ProcurarAnime;

    @FXML
	private void initialize() { 
		
		LoadAnimeDAO.loadAnime(ProcurarAnime.getText(),ListViewAnimes);
		ProcurarAnime.textProperty().addListener((observable, oldValue, newValue) -> {
			
    		LoadAnimeDAO.loadAnime(newValue, ListViewAnimes);
    	});
	}

}

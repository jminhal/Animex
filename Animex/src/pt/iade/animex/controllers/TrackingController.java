package pt.iade.animex.controllers;


import java.io.ByteArrayInputStream;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import pt.iade.animex.WindowManager;
import pt.iade.animex.models.Anime;
import pt.iade.animex.models.Episode;
import pt.iade.animex.models.daos.LoadAnimeDAO;
import pt.iade.animex.models.daos.LoadTrackingDAO;

public class TrackingController {
    /**
	 * lista de Episodios
	 */
    @FXML
    private ListView<Episode> listaEpisodios;
    /**
	 * ImageView para aprecer a imagem associada ao anime
	 */
    @FXML
    private ImageView imgAnime;
    /**
	 * lable para aparecer o nome
	 */
    @FXML
    private Label nomeAnime;
    /**
     *Quando este controlador iniciar vai iniciar o initialize
     */
    @FXML
    private void initialize() { 
		//vai buscar o ID user, animeID e listview ID
    	LoadTrackingDAO.loadAnimeTracking(LoginController.userID, LoadAnimeDAO.anime_id, listaEpisodios);
    	ArrayList<Anime> animeList = LoadAnimeDAO.getInfoAnime(LoadAnimeDAO.anime_id);
    	nomeAnime.setText(animeList.get(0).getNome());
    	Image img = new Image(new ByteArrayInputStream(animeList.get(0).getImagem()));
    	imgAnime.setImage(img);
	}

    @FXML
    void voltar(ActionEvent event) {
    	WindowManager.openinfoAnime();

    }
}

package pt.iade.animex.controllers;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import pt.iade.animex.WindowManager;
import pt.iade.animex.models.Anime;
import pt.iade.animex.models.daos.LoadAnimeDAO;
import pt.iade.animex.models.daos.MoverAnimeDAO;


public class InfoAnimeController {
	public static int numeroEpisodios;
    @FXML
    private AnchorPane searchAnimeInfo;
    @FXML
    private ImageView IMG;
    @FXML
    private Label Link,Seasons,EPS,Sinopse,Genero,Data,Score,Nome,Autor;
    @FXML
    private TextArea test;
    @FXML
    private Button começarID, finalizadoID;
    @FXML
	private void initialize() {
    	if(SideBarController.continuar) {
    		começarID.setVisible(false);
    		finalizadoID.setVisible(true);
    	}
    	else if(SideBarController.voltaraver) {
    		finalizadoID.setVisible(false);	
    		começarID.setVisible(true);
    	}
    	else {
    		finalizadoID.setVisible(true);	
    		começarID.setVisible(true);
    	}
    	ArrayList<Anime> animeList = LoadAnimeDAO.getInfoAnime(LoadAnimeDAO.anime_id);
    	Link.setText(animeList.get(0).getLink());
     	Nome.setText(animeList.get(0).getNome());
     	Autor.setText(animeList.get(0).getAutor());
    	Sinopse.setText(animeList.get(0).getSynopsis().replaceAll("(.{50})", "$1\n"));
    	Genero.setText(animeList.get(0).getGenre());
    	Data.setText(animeList.get(0).getData());
    	Seasons.setText(String.valueOf(animeList.get(0).getSeasons()));
    	EPS.setText(String.valueOf(animeList.get(0).getEpisodes()));
    	Score.setText(String.valueOf(animeList.get(0).getScore()));
    	Image img = new Image(new ByteArrayInputStream(animeList.get(0).getImagem()));
    	IMG.setImage(img);
    	numeroEpisodios=animeList.get(0).getEpisodes();
	}
    @FXML
    void Finalizado(ActionEvent event) {//voltar a ver
       	if(SideBarController.continuar){
       		MoverAnimeDAO.moverAnimeBacktoWatch(LoadAnimeDAO.anime_id, LoginController.userID);
       	}
       	else if(!SideBarController.voltaraver &&!SideBarController.continuar) {
       		LoadAnimeDAO.addAnimeBacktoWatch(LoginController.userID, LoadAnimeDAO.anime_id);
    	}
    }
    @FXML
    void Começar(ActionEvent event) {//continuar a ver
    	if(SideBarController.voltaraver){
    		MoverAnimeDAO.moverAnimeConinue(LoadAnimeDAO.anime_id, LoginController.userID);
    	}
    	else if(!SideBarController.voltaraver &&!SideBarController.continuar) {
    		LoadAnimeDAO.addAnimeContinue(LoginController.userID, LoadAnimeDAO.anime_id);
    	}
    }
    @FXML
    void Voltar(ActionEvent event) {
    	WindowManager.openUserPage();
    }
    @FXML
    void Tracking(ActionEvent event) {
    	WindowManager.openlist();
    }

}

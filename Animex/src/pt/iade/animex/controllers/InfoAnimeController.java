package pt.iade.animex.controllers;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import pt.iade.animex.WindowManager;
import pt.iade.animex.models.Anime;
import pt.iade.animex.models.daos.LoadAnimeDAO;
import pt.iade.animex.models.daos.MoverAnimeDAO;


public class InfoAnimeController {
    /**
	 * variavel onde vai guardar o numero de episodios para depois enviar para o tracking
	 */
	public static int numeroEpisodios;
    /**
	 * ImageView para aprecer a imagem associada ao anime
	 */
    @FXML
    private ImageView IMG;
    /**
	 * lable para aparecer a informação do anime
	 */
    @FXML
    private Label Link,Seasons,EPS,Sinopse,Genero,Data,Score,Nome,Autor;
    /**
	 * botões para mover o anime, para a secção de voltar a ver ou continuar a ver 
	 */
    @FXML
    private Button começarID, finalizadoID;
    /**
    *Quando este controlador iniciar vai iniciar o initialize
    *este metedo é para fazer aparecer/desaparecer os botões começarID e finalizadoID para move os Animes
    */
    @FXML
	private void initialize() {
    	//se tivermos no continuar a ver aparecer o botão finalizado
    	if(SideBarController.continuar) {
    		começarID.setVisible(false);
    		finalizadoID.setVisible(true);
    	}
    	//se tivermos no voltar a ver aparecer o botão Começar
    	else if(SideBarController.voltaraver) {
    		finalizadoID.setVisible(false);	
    		começarID.setVisible(true);
    	}
    	else {
    		//se tivermos no procurar aparece o botão finalizado e Começar
    		finalizadoID.setVisible(true);	
    		começarID.setVisible(true);
    	}
       // coloca a informação de um certo anime no arraylist ao carregar esse cenario ele coloca a informação nas lables
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
	/**
	 * Botao para mover o Anime
	 * @param event para clicar
	 */
    @FXML
    void Finalizado(ActionEvent event) {//voltar a ver
       	if(SideBarController.continuar){
       		MoverAnimeDAO.moverAnimeBacktoWatch(LoadAnimeDAO.anime_id, LoginController.userID);
       	}
       	else if(!SideBarController.voltaraver &&!SideBarController.continuar) {
       		LoadAnimeDAO.addAnimeBacktoWatch(LoginController.userID, LoadAnimeDAO.anime_id);
    	}
    }
	/**
	 * Botao para mover o Anime
	 * @param event para clicar
	 */
    @FXML
    void Começar(ActionEvent event) {//continuar a ver
    	if(SideBarController.voltaraver){
    		MoverAnimeDAO.moverAnimeConinue(LoadAnimeDAO.anime_id, LoginController.userID);
    	}
    	else if(!SideBarController.voltaraver &&!SideBarController.continuar) {
    		LoadAnimeDAO.addAnimeContinue(LoginController.userID, LoadAnimeDAO.anime_id);
    	}
    }
	/**
	 * Botao para Voltar à pagina anterior
	 * @param event para clicar
	 */
    @FXML
    void Voltar(ActionEvent event) {
    	WindowManager.openUserPage();
    }
	/**
	 * Botao para ir para o tracking do anime
	 * @param event para clicar
	 */
    @FXML
    void Tracking(ActionEvent event) {
    	WindowManager.openlist();
    }

}

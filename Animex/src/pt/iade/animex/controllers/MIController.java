package pt.iade.animex.controllers;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import pt.iade.animex.WindowManager;
import pt.iade.animex.models.Dialog;
import pt.iade.animex.models.daos.MIDAO;






public class MIController {
	@FXML
	private void initialize() {

    	
    }
    @FXML
    private TextField nome,autor,episodes,score,genre,synopsis,link,data,seasons;

    @FXML
    void CarregarImagem(ActionEvent event) {	// botão para procurar a imagem no pc

    }

    @FXML
    void Confirmar(ActionEvent event) {  // botão para confimar o upload da imagem do anime
    	
    	if(!nome.getText().isEmpty() && !autor.getText().isEmpty() && !link.getText().isEmpty() &&
    			!data.getText().isEmpty() && !score.getText().isEmpty()&&  !episodes.getText().isEmpty() &&
    			!genre.getText().isEmpty() && !synopsis.getText().isEmpty()&& !seasons.getText().isEmpty()) { 
    		MIDAO.addAnime(nome, autor, data, score, episodes, seasons, genre, synopsis, link);
    		Dialog.warningDialog("", "Anime adicionado com sucesso!", "Anime Adicionado" );
    		/*
    		if (imagemJogo.getImage() != null && !nomeJogo.getText().isEmpty() && !categoriaJogo.getSelectionModel().isEmpty() 
    				&& !devJogo.getText().isEmpty() && dataJogo.getValue() != null)*/
    	}
    	else {
			Dialog.warningDialog("", "Preencha todos os campos anteriores!", "Atenção!" );

    		
    	}
    	

    
    }

    @FXML
    void LogOut(ActionEvent event) {	// botão para sair da conta e volta para o start
    	WindowManager.openMainWindow();

    }


    @FXML
    void VoltarAnimeX(ActionEvent event) {	// botão para voltar para o ModeradorScreen
    	WindowManager.openUserPage();

    }
	

}

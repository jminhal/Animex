package pt.iade.animex.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import pt.iade.animex.WindowManager;

public class MIController {

    @FXML
    void CarregarImagem(ActionEvent event) {	// bot�o para procurar a imagem no pc

    }

    @FXML
    void Confirmar(ActionEvent event) {  // bot�o para confimar o upload da imagem do anime

    }

    @FXML
    void LogOut(ActionEvent event) {	// bot�o para sair da conta e volta para o start
    	WindowManager.openMainWindow();

    }

    @FXML
    void Moderador(ActionEvent event) {			// bot�o para entrar no MIScreen
    }

    @FXML
    void VoltarAnimeX(ActionEvent event) {	// bot�o para voltar para o ModeradorScreen
    	WindowManager.openModerador();

    }
	

}

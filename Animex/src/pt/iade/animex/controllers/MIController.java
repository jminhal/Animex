package pt.iade.animex.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import pt.iade.animex.WindowManager;

public class MIController {

    @FXML
    void CarregarImagem(ActionEvent event) {	// botão para procurar a imagem no pc

    }

    @FXML
    void Confirmar(ActionEvent event) {  // botão para confimar o upload da imagem do anime

    }

    @FXML
    void LogOut(ActionEvent event) {	// botão para sair da conta e volta para o start
    	WindowManager.openMainWindow();

    }

    @FXML
    void Moderador(ActionEvent event) {			// botão para entrar no MIScreen
    }

    @FXML
    void VoltarAnimeX(ActionEvent event) {	// botão para voltar para o ModeradorScreen
    	WindowManager.openModerador();

    }
	

}

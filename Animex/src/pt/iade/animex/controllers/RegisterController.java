package pt.iade.animex.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import pt.iade.animex.WindowManager;

public class RegisterController {

    @FXML
    void ConfirmarRegisto(ActionEvent event) { //bot�o que faz confirma��o do registo
    	WindowManager.openMainWindow();
    }

    @FXML
    void Voltar(ActionEvent event) { 	    	//bot�o de voltar atr�s na pagina do registo
    	WindowManager.openMainWindow();
    }
}

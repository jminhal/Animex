package pt.iade.animex.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import pt.iade.animex.WindowManager;

public class RegisterController {

    @FXML
    void ConfirmarRegisto(ActionEvent event) { //botão que faz confirmação do registo
    	WindowManager.openMainWindow();
    }

    @FXML
    void Voltar(ActionEvent event) { 	    	//botão de voltar atrás na pagina do registo
    	WindowManager.openMainWindow();
    }
}

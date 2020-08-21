package pt.iade.animex.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import pt.iade.animex.WindowManager;



public class MainController {
		@FXML
		private void initialize() {
		}

	    @FXML
	    void Entrar(ActionEvent event) {			//botão que faz ir para o loginScreen
	    	WindowManager.openLogin();



	    }

	    @FXML
	    void NewAccount(ActionEvent event) {  	//boto que faz ir para o registerScreen
	    	WindowManager.openRegister();
	    }

	    
	    


}
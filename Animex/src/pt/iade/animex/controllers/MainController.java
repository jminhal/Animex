package pt.iade.animex.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import pt.iade.animex.WindowManager;



public class MainController {
	/**
	 * Bot�o para abrir o login
	 * @param event para clicar
	 */
	    @FXML
	    void Entrar(ActionEvent event) {			//bot�o que faz ir para o loginScreen
	    	WindowManager.openLogin();
	    }
		/**
		 * Bot�o para abrir o registo
		 * @param event para clicar
		 */
	    @FXML
	    void NewAccount(ActionEvent event) {  	//boto que faz ir para o registerScreen
	    	WindowManager.openRegister();
	    }

	    
	    


}
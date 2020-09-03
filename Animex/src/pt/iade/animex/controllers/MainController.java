package pt.iade.animex.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import pt.iade.animex.WindowManager;



public class MainController {
	/**
	 * Botão para abrir o login
	 * @param event para clicar
	 */
	    @FXML
	    void Entrar(ActionEvent event) {			//botão que faz ir para o loginScreen
	    	WindowManager.openLogin();
	    }
		/**
		 * Botão para abrir o registo
		 * @param event para clicar
		 */
	    @FXML
	    void NewAccount(ActionEvent event) {  	//boto que faz ir para o registerScreen
	    	WindowManager.openRegister();
	    }

	    
	    


}
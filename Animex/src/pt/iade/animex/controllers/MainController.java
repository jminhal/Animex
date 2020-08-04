package pt.iade.animex.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import pt.iade.animex.WindowManager;



public class MainController {
		@FXML
		private void initialize() {
		}

	    @FXML
	    void Entrar(ActionEvent event) {			//botão que faz login na pagina inicial
	    	WindowManager.openUserPage();;

	    }

	    @FXML
	    void NewAccount(ActionEvent event) {  	//botão que faz abrir a pagina do registo
	    	WindowManager.openRegister();
	    }

	    
	    


}
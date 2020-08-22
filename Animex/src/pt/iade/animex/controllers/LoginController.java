package pt.iade.animex.controllers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import pt.iade.animex.WindowManager;
import pt.iade.animex.models.Dialog;
import pt.iade.animex.models.daos.LoginAndRegister;

public class LoginController {
    @FXML
    private TextField username;

    @FXML
    private PasswordField password;


    @FXML
    void EntrarConta(ActionEvent event) {  // bot�o que filtra(se � user ou mod) e faz o login no ModScreen ou UserScreen
    	if(!username.getText().isEmpty()&&!password.getText().isEmpty()) {
    		if (LoginAndRegister.passwordVerify(username.getText(), password.getText())) {
    			if (LoginAndRegister.ModVerify(username.getText())) {
    		    	WindowManager.openModerador();
    			}
    			else {
    			WindowManager.openUserPage();
    			}
    		}
    		else {
    		Dialog.warningDialog("", "Essa conta n�o existe na nossa base de dados, cria uma conta primeiro!", "Aten��o" );
    		}

    	}
		else {
		Dialog.warningDialog("", "Falta-te preencher o username ou a password", "Aten��o" );
		}
    }

    @FXML
    void voltarStart(ActionEvent event) { // bot�o que faz voltar para o StartScreen
    	WindowManager.openMainWindow();

    }

}

package pt.iade.animex.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import pt.iade.animex.WindowManager;
import pt.iade.animex.models.daos.LoginAndRegister;


public class RegisterController {
    @FXML
    private DatePicker birthday;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private PasswordField passwordconf;
    @FXML
    void ConfirmarRegisto(ActionEvent event) { //botão que faz confirmação do registo
    	if(!username.getText().isEmpty() && birthday.getValue()!=null && !password.getText().isEmpty() && !passwordconf.getText().isEmpty()) {
    		if(password.getText().equals(passwordconf.getText())) {
    			LoginAndRegister.createAccount(username.getText(), password.getText(),birthday.getValue().toString());
    		}
    	}
    	WindowManager.openMainWindow();
    }

    @FXML
    void Voltar(ActionEvent event) { 	    	//botão de voltar atrás na pagina do registo
    	WindowManager.openMainWindow();
    }
}


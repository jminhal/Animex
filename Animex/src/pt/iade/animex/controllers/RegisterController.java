package pt.iade.animex.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import pt.iade.animex.WindowManager;
import pt.iade.animex.models.daos.LoginAndRegisterDAO;


/**
 * Nesta class vai estar tudo relacionado como registo
 * O utilizador ao clicar no botao de ConfirmarRegisto vai verficar se o utilizador já existe na base de dados,
 * se nao existir vai adicionar.
 */
public class RegisterController {
    @FXML
    private DatePicker birthday;
    /**
	 * ID da lable da username
	 */
    @FXML
    private TextField username;
    /**
	 * ID da lable da password
	 */
    @FXML
    private PasswordField password,passwordconf;
	/**
	 * Vai verficar se o utilizador preencheu a password e Username 
	 * Vai verificar se o username ja existe na base de dados.
	 * Se nao existe vai adicionar o novo utilizador na base de dados.
	 * @param event evento de ConfirmarRegisto
	 */
    @FXML
    void ConfirmarRegisto(ActionEvent event) { //botão que faz confirmação do registo
    	if(!username.getText().isEmpty() && birthday.getValue()!=null && !password.getText().isEmpty() && !passwordconf.getText().isEmpty()) {
    		if(password.getText().equals(passwordconf.getText())) {
    			LoginAndRegisterDAO.createAccount(username.getText(), password.getText(),birthday.getValue().toString());
    		}
    	}
    	WindowManager.openMainWindow();
    }

    @FXML
	/**
	 * Botão para voltar à pagina anterior
	 * @param event para clicar
	 */
    void Voltar(ActionEvent event) { 	    	//botão de voltar atrás na pagina do registo
    	WindowManager.openMainWindow();
    }
}


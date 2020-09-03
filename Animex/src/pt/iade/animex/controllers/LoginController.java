package pt.iade.animex.controllers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import pt.iade.animex.WindowManager;
import pt.iade.animex.models.Dialog;
import pt.iade.animex.models.daos.LoginAndRegisterDAO;
/**
 * Nesta class vai estar tudo relacionado com o Login
 * O utilizador ao clicar no botao Login vai verficar se o utilizador já existe na base de dados,
 * se nao existir pedir para crirar conta. Caso já exista vai fazer uma verificação para saber se é 
 * Moderador ou não.
 */
public class LoginController {
    public static boolean eMod=false; //variavel para ir ao SideBarController meter o painel a true/false 
	public static int userID; //vai buscar ao id de utilizador à base de dados e guarda aqui
    /**
	 * ID da lable do username
	 */
    @FXML
    private TextField username;
    /**
	 * ID da lable da password
	 */
    @FXML
    private PasswordField password; 

	/**
	 * Quando o utilizador clica no botao de login vai verificar se o utilizador preencheu a password e o username
	 * Vai verificar se o utilizador ja existe na base de dados, Verficicar se a password coincide com a que está na base de dados.
	 * Vai verificar se o nome do utilizador é admin vai abrir a pagina de Moderador.
	 * @param event evento de EntrarConta
	 */
    @FXML
    void EntrarConta(ActionEvent event) {  // botão que filtra(se é user ou mod) e faz o login no ModScreen ou UserScreen
    	if(!username.getText().isEmpty()&&!password.getText().isEmpty()) {
    		if (LoginAndRegisterDAO.passwordVerify(username.getText(), password.getText())) {
    			if (LoginAndRegisterDAO.ModVerify(username.getText())) {
    		    	eMod=true;
    		    	WindowManager.openUserPage();
    		    	userID = LoginAndRegisterDAO.userID(username.getText());

    			}
    			else {
    		    	eMod=false;
    				WindowManager.openUserPage();
    				userID = LoginAndRegisterDAO.userID(username.getText());


    				
    			}
    		}
    		else {
    			Dialog.warningDialog("", "Essa conta não existe na nossa base de dados, cria uma conta primeiro!", "Atenção" );
    		}

    	}
		else {
			Dialog.warningDialog("", "Falta-te preencher o username ou a password", "Atenção" );
		}
    }
	/**
	 * Botão para voltar para a pagina anterior
	 * @param event para clicar
	 */
    @FXML
    void voltarStart(ActionEvent event) { // botão que faz voltar para o StartScreen
    	WindowManager.openMainWindow();

    }


}

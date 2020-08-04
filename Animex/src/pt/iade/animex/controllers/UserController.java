package pt.iade.animex.controllers;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import pt.iade.animex.WindowManager;


public class UserController {
	
    @FXML
    private Button IDPesquisar;

    @FXML
    private Button IDContinuar;

    @FXML
    private Button IDVoltar;
    
    @FXML
    void LogOut(ActionEvent event) {  //bot�o que faz sair da conta e voltar ao start do programa
    	WindowManager.openMainWindow();

    }

    @FXML
    void ContinuarVer(ActionEvent event) {	
    	//faz mudar as cores dos bot�es neste caso � o Continuar a ver
    	IDContinuar.setStyle("-fx-background-color: #95310e;");				
    	IDPesquisar.setStyle("-fx-background-color: #0e7295;");
    	IDVoltar.setStyle("-fx-background-color: #0e7295;");

    }

    @FXML
    void Pesquisar(ActionEvent event) {
    	//faz mudar as cores dos bot�es neste caso � o Pesquisar
    	IDPesquisar.setStyle("-fx-background-color: #95310e;");
    	IDContinuar.setStyle("-fx-background-color: #0e7295;");
    	IDVoltar.setStyle("-fx-background-color: #0e7295;");
    	
    	
    	
    }

    @FXML
    void VoltarVer(ActionEvent event) {
    	//faz mudar as cores dos bot�es neste caso � o Voltar a ver
    	IDVoltar.setStyle("-fx-background-color: #95310e;");
    	IDPesquisar.setStyle("-fx-background-color: #0e7295;");
    	IDContinuar.setStyle("-fx-background-color: #0e7295;");

    }

}

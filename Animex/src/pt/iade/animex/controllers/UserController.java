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
    void LogOut(ActionEvent event) {  //botão que faz sair da conta e voltar ao start do programa
    	WindowManager.openMainWindow();

    }

    @FXML
    void ContinuarVer(ActionEvent event) {	
    	//faz mudar as cores dos botões neste caso é o Continuar a ver
    	IDContinuar.setStyle("-fx-background-color: #95310e;");				
    	IDPesquisar.setStyle("-fx-background-color: #0e7295;");
    	IDVoltar.setStyle("-fx-background-color: #0e7295;");

    }

    @FXML
    void Pesquisar(ActionEvent event) {
    	//faz mudar as cores dos botões neste caso é o Pesquisar
    	IDPesquisar.setStyle("-fx-background-color: #95310e;");
    	IDContinuar.setStyle("-fx-background-color: #0e7295;");
    	IDVoltar.setStyle("-fx-background-color: #0e7295;");
    	
    	
    	
    }

    @FXML
    void VoltarVer(ActionEvent event) {
    	//faz mudar as cores dos botões neste caso é o Voltar a ver
    	IDVoltar.setStyle("-fx-background-color: #95310e;");
    	IDPesquisar.setStyle("-fx-background-color: #0e7295;");
    	IDContinuar.setStyle("-fx-background-color: #0e7295;");

    }

}

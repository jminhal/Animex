package pt.iade.animex.controllers;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import pt.iade.animex.WindowManager;


public class UserController {
	private String corAzul = "-fx-background-color: #95310e"; //muda a cor do botão)
	private String corVermelha = "-fx-background-color: #0e7295"; // muda a cor do botão)
	
	
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
    	IDContinuar.setStyle(corAzul);				
    	IDPesquisar.setStyle(corVermelha);
    	IDVoltar.setStyle(corVermelha);
    }
    @FXML
    void Pesquisar(ActionEvent event) {
    	//faz mudar as cores dos botões neste caso é o Pesquisar
    	IDPesquisar.setStyle(corAzul);
    	IDContinuar.setStyle(corVermelha);
    	IDVoltar.setStyle(corVermelha);  	
    }
    @FXML
    void VoltarVer(ActionEvent event) {
    	//faz mudar as cores dos botões neste caso é o Voltar a ver
    	IDVoltar.setStyle(corAzul);
    	IDPesquisar.setStyle(corVermelha);
    	IDContinuar.setStyle(corVermelha);
    	}


}

package pt.iade.animex.controllers;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import pt.iade.animex.WindowManager;



public class SideBarController {
	private String corAzul = "-fx-background-color: #95310e"; //muda a cor do botão)
	private String corVermelha = "-fx-background-color: #0e7295"; // muda a cor do botão)
    @FXML
    private BorderPane SideBarID;

	
    @FXML
    private Button IDPesquisar;

    @FXML
    private Button IDContinuar;
    @FXML
    private AnchorPane IconMod;
    @FXML
    private Button IDVoltar;
    
    @FXML
    private void initialize() {
    	if(LoginController.eMod) {
    		IconMod.setVisible(true);
    		
    	}
    }
    
    @FXML
    void LogOut(ActionEvent event) {  //botão que faz sair da conta e voltar ao start do programa
    	WindowManager.openMainWindow();

    }

    @FXML
    void moderador(ActionEvent event) {
    	WindowManager.openIM();
    	
    }
    
    @FXML
    void Pesquisar(ActionEvent event) {
    	//carrega no centro o fxml, neste caso carrega no SearchScreen

    	WindowManager.loadUI("views/SearchScreen.fxml", new SearchController(), SideBarID);
    	//faz mudar as cores dos botões neste caso é o Pesquisar
    	IDPesquisar.setStyle(corAzul);
    	IDContinuar.setStyle(corVermelha);
    	IDVoltar.setStyle(corVermelha);  	
    }
    
    @FXML
    void ContinuarVer(ActionEvent event) {	
    	//carrega no centro o fxml, neste caso carrega no ContinueScreen
    	WindowManager.loadUI("views/ContinueScreen.fxml", new ContinueController(), SideBarID);
    	//faz mudar as cores dos botões neste caso é o Continuar a ver
    	IDContinuar.setStyle(corAzul);				
    	IDPesquisar.setStyle(corVermelha);
    	IDVoltar.setStyle(corVermelha);
    }
    @FXML
    void VoltarVer(ActionEvent event) {
    	//carrega no centro o fxml, neste caso carrega no BacktoWatchScreen
    	WindowManager.loadUI("views/BacktoWatchScreen.fxml", new BacktoWatchController(), SideBarID);
    	//faz mudar as cores dos botões neste caso é o Voltar a ver
    	IDVoltar.setStyle(corAzul);
    	IDPesquisar.setStyle(corVermelha);
    	IDContinuar.setStyle(corVermelha);
    	}


}

package pt.iade.animex.controllers;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import pt.iade.animex.WindowManager;



public class SideBarController {
	public static boolean continuar=false,voltaraver=false;
	private String corVermelha = "-fx-background-color: #95310e"; //muda a cor do botão)
	private String corAzul = "-fx-background-color: #0e7295"; // muda a cor do botão)
    @FXML
    private BorderPane SideBarID;
    @FXML
    private Button IDPesquisar,IDContinuar,IDVoltar;
    @FXML
    private AnchorPane IconMod;
    @FXML
    private void initialize() {
    	if(LoginController.eMod) {
    		IconMod.setVisible(true);
    	}
    	if(SideBarController.continuar) {
    		WindowManager.loadUI("views/ContinueScreen.fxml", new ContinueController(), SideBarID);
    		IDContinuar.setStyle(corVermelha);
    	}
    	else if(SideBarController.voltaraver) {
    		WindowManager.loadUI("views/BacktoWatchScreen.fxml", new BacktoWatchController(), SideBarID);
    		IDVoltar.setStyle(corVermelha);
    	}
    	else {
    		WindowManager.loadUI("views/SearchScreen.fxml", new SearchController(), SideBarID);
    		IDPesquisar.setStyle(corVermelha);
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
    	IDPesquisar.setStyle(corVermelha);
    	IDContinuar.setStyle(corAzul);
    	IDVoltar.setStyle(corAzul);  	
    }
    @FXML
    void ContinuarVer(ActionEvent event) {	
    	continuar=true;
    	voltaraver=false;
    	//carrega no centro o fxml, neste caso carrega no ContinueScreen
    	WindowManager.loadUI("views/ContinueScreen.fxml", new ContinueController(), SideBarID);
    	//faz mudar as cores dos botões neste caso é o Continuar a ver
    	IDContinuar.setStyle(corVermelha);				
    	IDPesquisar.setStyle(corAzul);
    	IDVoltar.setStyle(corAzul);
    }
    @FXML
    void VoltarVer(ActionEvent event) {
     	continuar=false;
    	voltaraver=true;
    	//carrega no centro o fxml, neste caso carrega no BacktoWatchScreen
    	WindowManager.loadUI("views/BacktoWatchScreen.fxml", new BacktoWatchController(), SideBarID);
    	//faz mudar as cores dos botões neste caso é o Voltar a ver
    	IDVoltar.setStyle(corVermelha);
    	IDPesquisar.setStyle(corAzul);
    	IDContinuar.setStyle(corAzul);
    	}


}

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
    /**
     *Quando este controlador iniciar vai iniciar o initialize
     */
    @FXML
    private void initialize() {
    	//caso seja mod aparece o icon para ir para a secção de moderador
    	if(LoginController.eMod) {
    		IconMod.setVisible(true);
    	}
    	//se o continuar= true vamos carregar fazer load do FXML do continuar a ver 
    	if(continuar) {
    		WindowManager.loadUI("views/ContinueScreen.fxml", new ContinueController(), SideBarID);
    		IDContinuar.setStyle(corVermelha);
    	}
    	//se o voltaraver= true vamos carregar fazer load do FXML do voltaraver a ver 
    	else if(voltaraver) {
    		WindowManager.loadUI("views/BacktoWatchScreen.fxml", new BacktoWatchController(), SideBarID);
    		IDVoltar.setStyle(corVermelha);
    	}
    	//ambos forem falsos vamos carregar fazer load do FXML do procurar 
    	else {
    		WindowManager.loadUI("views/SearchScreen.fxml", new SearchController(), SideBarID);
    		IDPesquisar.setStyle(corVermelha);
    		}
    }
	/**
	 * Botão para sair da conta
	 * @param event para clicar
	 */
    @FXML
    void LogOut(ActionEvent event) {  //botão que faz sair da conta e voltar ao start do programa
    	WindowManager.openMainWindow();

    }
	/**
	 * Botão para ir para a secção de Moderador
	 * @param event para clicar
	 */
    @FXML
    void moderador(ActionEvent event) {
    	WindowManager.openIM();
    	
    }
	/**
	 * Botão para ir para o pesquisar
	 * @param event para clicar
	 */
    @FXML
    void Pesquisar(ActionEvent event) {
    	continuar=false;
    	voltaraver=false;
    	//carrega no centro o fxml, neste caso carrega no SearchScreen
    	WindowManager.loadUI("views/SearchScreen.fxml", new SearchController(), SideBarID);
    	//faz mudar as cores dos botões neste caso é o Pesquisar
    	IDPesquisar.setStyle(corVermelha);
    	IDContinuar.setStyle(corAzul);
    	IDVoltar.setStyle(corAzul);  	
    }
	/**
	 * Botão para ir para o continuar a ver
	 * @param event para clicar
	 */
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
	/**
	 * Botão para ir para o voltar a ver
	 * @param event para clicar
	 */
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

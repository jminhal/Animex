package pt.iade.animex.controllers;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import pt.iade.animex.WindowManager;



public class SideBarController {
	
	public static boolean continuarver=false,voltaraver=false;
	private String corVermelha = "-fx-background-color: #95310e"; //muda a cor do botão)
	private String corAzul = "-fx-background-color: #0e7295"; // muda a cor do botão)
	
    @FXML
    private BorderPane SideBarID;
    @FXML
    private Button btnPesquisar,btnContinuarVer,btnVoltarVer;
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
    	if(continuarver) {
    		WindowManager.loadUI("views/ContinuarVerScreen.fxml", new ContinuarVerController(), SideBarID);
    		btnContinuarVer.setStyle(corVermelha);
    	}
    	//se o voltaraver= true vamos carregar fazer load do FXML do voltaraver a ver 
    	else if(voltaraver) {
    		WindowManager.loadUI("views/VoltarVerScreen.fxml", new VoltarVerController(), SideBarID);
    		btnVoltarVer.setStyle(corVermelha);
    	}
    	//ambos forem falsos vamos carregar fazer load do FXML do procurar 
    	else {
    		WindowManager.loadUI("views/PesquisarScreen.fxml", new PesquisarController(), SideBarID);
    		btnPesquisar.setStyle(corVermelha);
    		}
    }
	/**
	 * Botão para sair da conta
	 * @param event para clicar
	 */
    @FXML
    void LogOut(ActionEvent event) {  //botão que faz sair da conta e voltar ao start do programa
    	continuarver=false;
    	voltaraver=false;
    	WindowManager.openMainWindow();

    }
	/**
	 * Botão para ir para a secção de Moderador
	 * @param event para clicar
	 */
    @FXML
    void moderador(ActionEvent event) {
    	WindowManager.openModerador();
    	
    }
	/**
	 * Botão para ir para o pesquisar
	 * @param event para clicar
	 */
    @FXML
    void pesquisar(ActionEvent event) {
    	continuarver=false;
    	voltaraver=false;
    	//carrega no centro o fxml, neste caso carrega no SearchScreen
    	WindowManager.loadUI("views/PesquisarScreen.fxml", new PesquisarController(), SideBarID);
    	//faz mudar as cores dos botões neste caso é o Pesquisar
    	btnPesquisar.setStyle(corVermelha);
    	btnContinuarVer.setStyle(corAzul);
    	btnVoltarVer.setStyle(corAzul);  	
    }
	/**
	 * Botão para ir para o continuar a ver
	 * @param event para clicar
	 */
    @FXML
    void continuarVer(ActionEvent event) {	
    	continuarver=true;
    	voltaraver=false;
    	//carrega no centro o fxml, neste caso carrega no ContinueScreen
    	WindowManager.loadUI("views/ContinuarVerScreen.fxml", new ContinuarVerController(), SideBarID);
    	//faz mudar as cores dos botões neste caso é o Continuar a ver
    	btnContinuarVer.setStyle(corVermelha);				
    	btnPesquisar.setStyle(corAzul);
    	btnVoltarVer.setStyle(corAzul);
    }
	/**
	 * Botão para ir para o voltar a ver
	 * @param event para clicar
	 */
    @FXML
    void voltarVer(ActionEvent event) {
     	continuarver=false;
    	voltaraver=true;
    	//carrega no centro o fxml, neste caso carrega no BacktoWatchScreen
    	WindowManager.loadUI("views/VoltarVerScreen.fxml", new VoltarVerController(), SideBarID);
    	//faz mudar as cores dos botões neste caso é o Voltar a ver
    	btnVoltarVer.setStyle(corVermelha);
    	btnPesquisar.setStyle(corAzul);
    	btnContinuarVer.setStyle(corAzul);
    	}


}

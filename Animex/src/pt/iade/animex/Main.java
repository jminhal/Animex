package pt.iade.animex;

import javafx.application.Application;
import javafx.stage.Stage;
import pt.iade.animex.models.daos.DBConnector;

/**
 *Descri��o:Atualmente ver um anime � bastante f�cil, porem ao fim de algum tempo a ver anime, acabamos por perder a 
 *no��o do que � que j� vimos (terminamos �Ver novamente�) e o que se encontra por terminar de ver (encontramos a ver 
 *no momento �continuar a ver�). Dai sai a minha motiva��o para criar esta aplica��o, a minha aplica��o faria o tracking
 *do que � que j� vimos e o que nos encontramos a ver. Esta aplica��o ter� uma base de dados onde os utilizadores poder�o
 *pesquisar pelos seus animes.
 * @author JorgeMinhalma
 *
 * 
 */ 

public class Main extends Application {
/**
 * Quando a aplica��o inicia, este metodo vai conectar � base de dados
 * e vai chamar o metodo criado no WindowManager para carregar a pagina de Login.
 * @param primaryStage  Stage
 */
	@Override
	public void start(Stage primaryStage) {
		DBConnector.abrirConexao();							//Conectar com a base de dados
		WindowManager.setPrimaryStage(primaryStage);		//Vai chamar o metodo criado primaryStage
		WindowManager.openMainWindow();						//abre a primeira janela do windowmanager
	}
	/**
	 * 
	 * @param args faz lauch da aplicacao
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
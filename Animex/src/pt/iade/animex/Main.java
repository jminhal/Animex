package pt.iade.animex;

import javafx.application.Application;
import javafx.stage.Stage;
import pt.iade.animex.models.daos.DBConnector;

/**
 *Descrição:Atualmente ver um anime é bastante fácil, porem ao fim de algum tempo a ver anime, acabamos por perder a 
 *noção do que é que já vimos (terminamos “Ver novamente”) e o que se encontra por terminar de ver (encontramos a ver 
 *no momento “continuar a ver”). Dai sai a minha motivação para criar esta aplicação, a minha aplicação faria o tracking
 *do que é que já vimos e o que nos encontramos a ver. Esta aplicação terá uma base de dados onde os utilizadores poderão
 *pesquisar pelos seus animes.
 * @author JorgeMinhalma
 *
 * 
 */ 

public class Main extends Application {
/**
 * Quando a aplicação inicia, este metodo vai conectar à base de dados
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
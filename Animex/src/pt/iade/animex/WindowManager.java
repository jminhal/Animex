package pt.iade.animex;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import pt.iade.animex.controllers.VoltarVerController;
import pt.iade.animex.controllers.ContinuarVerController;
import pt.iade.animex.controllers.InfoAnimeController;
import pt.iade.animex.controllers.TrackingController;
import pt.iade.animex.controllers.LoginController;
import pt.iade.animex.controllers.MainController;
import pt.iade.animex.controllers.RegisterController;
import pt.iade.animex.controllers.PesquisarController;
import pt.iade.animex.controllers.SideBarController;
import pt.iade.animex.controllers.ModeradorController;
/**
 * Esta classe vai servir para carregar um nova janela com o respetivo controlador
 * e tambem fazer o load de um FXML dentro de um mesmo cenario.
 */
public class WindowManager {
	/**
	 * Definir o primaryStage 
	 * @param primaryStage stage
	 */
	private static Stage primaryStage;
	public static void setPrimaryStage(Stage primaryStage) {
		WindowManager.primaryStage = primaryStage;
	}
	/**
	 * Metodo vai servir para abrir o StartScreen.
	 */
	public static void openMainWindow() {//função que chama o primeiro fxml
		openWindow("views/StartScreen.fxml",
				primaryStage,new MainController());
		primaryStage.show();
	}
	/**
	 * Metodo vai servir para abrir a vista do user.
	 */
	public static void openUserPage() {   //função que chama a vista do user
		openWindow("views/SideBarScreen.fxml",
				primaryStage,new SideBarController());
		primaryStage.show();
	}
	/**
	 * Metodo vai servir para abrir o pagina de registo.
	 */
	public static void openRegister() {  // função que chama a pagina de registo
		openWindow("views/RegisterScreen.fxml",
				primaryStage,new RegisterController());
		primaryStage.show();
	}
	/**
	 * Metodo vai servir para abrir a interface do Moderador.
	 */
	public static void openModerador() {  // função que chama a pagina de interface do Moderador
		openWindow("views/ModeradorScreen.fxml",
				primaryStage,new ModeradorController()); 
		primaryStage.show();
	}
	/**
	 * Metodo vai servir para abrir o Login.
	 */
	public static void openLogin() {   //função que chama o Login
		openWindow("views/LoginScreen.fxml",
				primaryStage,new LoginController());
		primaryStage.show();
	}
	/**
	 * Metodo vai servir para abrir o voltar a ver.
	 */
	public static void openVoltarVer() {   //função que chama a pagina do voltar a ver
		openWindow("views/VoltarVerScreen.fxml",
				primaryStage,new VoltarVerController());
		primaryStage.show();
	}
	/**
	 * Metodo vai servir para abrir o pesquisar.
	 *
	 */
	public static void openPesquisar() {   //função que chama a pagina do pesquisar
		openWindow("views/PesquisarScreen.fxml",
				primaryStage,new PesquisarController());
		primaryStage.show();
	}
	/**
	 * Metodo vai servir para abrir o continuar a ver.
	 *
	 */
	public static void openContinuarVer() {  //função que chama a pagina do continuar a ver
		openWindow("views/ContinuarVerScreen.fxml",
				primaryStage,new ContinuarVerController());
		primaryStage.show();
	}
	
	/**
	 * Metodo vai servir para abrir o pagina do infoAnime.
	 *
	 */
	public static void openinfoAnime() {  //função que chama a pagina do infoAnime
		openWindow("views/InfoAnimeScreen.fxml",
				primaryStage,new InfoAnimeController());
		primaryStage.show();
	}
	/**
	 * Metodo vai servir para abrir a listview.
	 *
	 */
	public static void openTracking() {  //função que chama a pagina do listview
		openWindow("views/TrackingScreen.fxml",
				primaryStage,new TrackingController());
		primaryStage.show();
	}

	/**
	 * 	 * Declaracao do metodo para abrir nova janela com o controlador
	 * @param viewPath link do fxml
	 * @param window janela
	 * @param controller controlador
	 */
	public static void openWindow(String viewPath, Stage window, 
			Object controller) {
		try {
			Parent root = createNewNodeTree(viewPath, controller);
			Scene scene = new Scene(root);
			scene.getStylesheets().add(Main.class.getResource("application.css").toExternalForm());
			window.setScene(scene);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * 
	 *Metedo que vai adicionar o cenario(FXML) ao controlador
	 */
	public static Parent createNewNodeTree(String viewPath, Object controller) throws IOException {
		FXMLLoader loader = new FXMLLoader(
				Main.class.getResource(viewPath));
		loader.setController(controller);;
		Parent root = loader.load();
		return root;
	}
	/**
	 * Metodo que vai servir para fazer o load de um FXML dentro de um mesmo scene
	 * Vai ser preciso do nome do FXML, controller e do borderPane
	 * @param viewPath local da janela
	 * @param controller controlador da janela
	 * @param pane borderPane da janela
	 */
	public static void loadUI(String viewPath, Object controller, BorderPane pane) {
		AnchorPane root = null;
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource(viewPath));// vai buscar o "link"
			loader.setController(controller);  // define o controllador 
			root = loader.load();//dá load
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		pane.setCenter(root);
	}

}
	

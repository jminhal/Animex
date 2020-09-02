package pt.iade.animex;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import pt.iade.animex.controllers.BacktoWatchController;
import pt.iade.animex.controllers.ContinueController;
import pt.iade.animex.controllers.InfoAnimeController;
import pt.iade.animex.controllers.ListController;
import pt.iade.animex.controllers.LoginController;
import pt.iade.animex.controllers.MainController;
import pt.iade.animex.controllers.RegisterController;
import pt.iade.animex.controllers.SearchController;
import pt.iade.animex.controllers.SideBarController;
import pt.iade.animex.controllers.MIController;

public class WindowManager {

	private static Stage primaryStage;
	public static void setPrimaryStage(Stage primaryStage) {
		WindowManager.primaryStage = primaryStage;
	}
	public static void openMainWindow() {//função que chama o primeiro fxml
		openWindow("views/StartScreen.fxml",
				primaryStage,new MainController());
		primaryStage.show();
	}
	public static void openUserPage() {   //função que chama a vista do user
		openWindow("views/SideBarScreen.fxml",
				primaryStage,new SideBarController());
		primaryStage.show();
	}
	public static void openRegister() {  // função que chama a pagina de registo
		openWindow("views/RegisterScreen.fxml",
				primaryStage,new RegisterController());
		primaryStage.show();
	}
	public static void openIM() {  // função que chama a pagina de interface do Moderador
		openWindow("views/MIScreen.fxml",
				primaryStage,new MIController()); 
		primaryStage.show();
	}
	public static void openLogin() {   //função que chama a pagina principal do user, após dar login
		openWindow("views/LoginScreen.fxml",
				primaryStage,new LoginController());
		primaryStage.show();
	}
	public static void openBacktoWatch() {   //função que chama a pagina do voltar a ver
		openWindow("views/BacktoWatchScreen.fxml",
				primaryStage,new BacktoWatchController());
		primaryStage.show();
	}
	public static void openSearch() {   //função que chama a pagina do pesquisar
		openWindow("views/SearchScreen.fxml",
				primaryStage,new SearchController());
		primaryStage.show();
	}
	public static void openContinue() {  //função que chama a pagina do continuar a ver
		openWindow("views/ContinueScreen.fxml",
				primaryStage,new ContinueController());
		primaryStage.show();
	}
	public static void openinfoAnime() {  //função que chama a pagina do infoAnime
		openWindow("views/InfoAnimeScreen.fxml",
				primaryStage,new InfoAnimeController());
		primaryStage.show();
	}
	public static void openlist() {  //função que chama a pagina do infoAnime
		openWindow("views/ListScreen.fxml",
				primaryStage,new ListController());
		primaryStage.show();
	}
	public static void openSceneInWindow(String viewPath, Stage window,
			Object controller) {
		try {
			Parent root = createNewNodeTree(viewPath, controller);
			window.getScene().setRoot(root);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
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
	public static Parent createNewNodeTree(String viewPath, Object controller) throws IOException {
		FXMLLoader loader = new FXMLLoader(
				Main.class.getResource(viewPath));
		loader.setController(controller);;
		Parent root = loader.load();
		return root;
	}
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
	

package pt.iade.animex;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pt.iade.animex.controllers.LoginController;
import pt.iade.animex.controllers.MainController;
import pt.iade.animex.controllers.ModeradorController;
import pt.iade.animex.controllers.RegisterController;
import pt.iade.animex.controllers.UserController;


public class WindowManager {

	private static Stage primaryStage;

	public static void setPrimaryStage(Stage primaryStage) {
		WindowManager.primaryStage = primaryStage;
	}



	
	public static void openMainWindow() {
		openWindow("views/StartScreen.fxml",
				primaryStage,new MainController());
		primaryStage.show();
	}
	
	public static void openUserPage() {   //função que chama a vista do user
		openWindow("views/UserScreen.fxml",
				primaryStage,new UserController());
		primaryStage.show();
	}
	public static void openRegister() {  // função que chama a pagina de registo
		openWindow("views/RegisterScreen.fxml",
				primaryStage,new RegisterController());
		primaryStage.show();
	}
	public static void openModerador() {  // função que chama a pagina de registo
		openWindow("views/ModeradorScreen.fxml",
				primaryStage,new ModeradorController()); 
		primaryStage.show();
	}
	
	public static void openIM() {  // função que chama a pagina de interface do Moderador
		openWindow("views/ModeradorScreen.fxml",
				primaryStage,new ModeradorController()); 
		primaryStage.show();
	}
	public static void openLogin() {   //função que chama a pagina principal do user, após dar login
		openWindow("views/LoginScreen.fxml",
				primaryStage,new LoginController());
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
	
	
}
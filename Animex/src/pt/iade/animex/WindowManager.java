package pt.iade.animex;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pt.iade.animex.controllers.MainController;


public class WindowManager {

	private static Stage primaryStage;

	public static void setPrimaryStage(Stage primaryStage) {
		WindowManager.primaryStage = primaryStage;
	}


	public static void backToMainWindow() {
		openSceneInWindow("views/mainView.fxml",
				primaryStage,new MainController());
	}
	
	
	public static void openMainWindow() {
		openWindow("views/StartUp.fxml",
				primaryStage,new MainController());
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
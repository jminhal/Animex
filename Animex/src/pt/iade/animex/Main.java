package pt.iade.animex;

import javafx.application.Application;
import javafx.stage.Stage;
import pt.iade.animex.models.daos.DBConnector;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		DBConnector.abrirConexao();
		WindowManager.setPrimaryStage(primaryStage);
		WindowManager.openMainWindow();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
package pt.iade.animex.models;



import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * Class resposavel para a criação de popouts
 */
public class Dialog {
	
	/**
	 * Dialog de warning
	 * @param title titulo do warning
	 * @param text texto do warning
	 */
	public static void warningDialog(String title, String text) {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle(title);
		alert.setContentText(text);

		alert.showAndWait();
		
	}
	
	/**
	 * Dialog de information
	 * @param title titulo do information
	 * @param text texto do information
	 */
	public static void informationDialog(String title, String text) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(title);
		alert.setContentText(text);

		alert.showAndWait();
	}
	
	/**
	 * Dialog de error
	 * @param title titulo do error
	 * @param text texto do error
	 */
	public static void error(String title, String text) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle(title);
		alert.setContentText(text);

		alert.showAndWait();
	}

}
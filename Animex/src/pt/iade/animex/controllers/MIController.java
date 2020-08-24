package pt.iade.animex.controllers;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import pt.iade.animex.WindowManager;
import pt.iade.animex.models.AnimeGenre;
import pt.iade.animex.models.Dialog;
import pt.iade.animex.models.daos.MIDAO;




public class MIController {
    private BufferedImage bufferedImage;
    
    @FXML
	private void initialize() { 
    	genre.getItems().addAll(AnimeGenre.values());
    	
    }
    @FXML
    private ComboBox<AnimeGenre> genre;

    @FXML
    private TextField nome,autor,episodes,score,synopsis,link,seasons;
    @FXML
    private DatePicker data;
    

	@FXML 
    void CarregarImagem(ActionEvent event) {      // botão para procurar a imagem no pc

		FileChooser fileChooser = new FileChooser();
        
        //Set extension filter
        FileChooser.ExtensionFilter extFilterPNG = 
                new FileChooser.ExtensionFilter("PNG files (*.PNG)", "*.PNG");
        FileChooser.ExtensionFilter extFilterpng = 
                new FileChooser.ExtensionFilter("png files (*.png)", "*.png");
        fileChooser.getExtensionFilters()
                .addAll(extFilterPNG, extFilterpng);

        //Show open file dialog
        File file = fileChooser.showOpenDialog(null);
        
        if (file != null) {
        	try {
            	bufferedImage = ImageIO.read(file);
            } catch (IOException ex) {	
            }
        }
    }
    @FXML
    void Confirmar(ActionEvent event) {  // botão para confimar o upload da imagem do anime
    	
    	if(!nome.getText().isEmpty() && !autor.getText().isEmpty() && !link.getText().isEmpty() &&
    			data.getValue()!=null && !score.getText().isEmpty()&&  !episodes.getText().isEmpty() &&
    			genre.getValue()!=null && !synopsis.getText().isEmpty()&& !seasons.getText().isEmpty()) { 
			try {
				//Vai converter a imagem que o utilizador fez upload para uma byte array
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				ImageIO.write(bufferedImage, "png", baos);
				baos.flush();
				byte[] imageInByte = baos.toByteArray();
				baos.close();
				//Vai adicionar o jogo na base de dados
				MIDAO.addAnime(nome.getText(), autor.getText(), data.getValue().toString(),Float.valueOf(score.getText()),
	    				Integer.valueOf(episodes.getText()),Integer.valueOf(seasons.getText()),String.valueOf(genre.getSelectionModel().getSelectedItem()), 
	    				synopsis.getText(), link.getText(),imageInByte);
			} catch (IOException e) {
				e.printStackTrace();
			}
    		
    		Dialog.warningDialog("", "Anime adicionado com sucesso!", "Anime Adicionado" );
    		
    	}
    	else {
			Dialog.warningDialog("", "Preencha todos os campos anteriores!", "Atenção!" );

    		
    	}
    	

    
    }

    @FXML
    void LogOut(ActionEvent event) {	// botão para sair da conta e volta para o start
    	WindowManager.openMainWindow();

    }


    @FXML
    void VoltarAnimeX(ActionEvent event) {	// botão para voltar para o ModeradorScreen
    	WindowManager.openUserPage();

    }
	

}

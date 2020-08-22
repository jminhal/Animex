package pt.iade.animex.controllers;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import pt.iade.animex.WindowManager;
import pt.iade.animex.models.Dialog;
import pt.iade.animex.models.daos.AdicionarJogosDAO;
import pt.iade.animex.models.daos.CategoriaJogosDAO;

public class MIController {
	/* @FXML
	private void initialize() {
    
    	//Adicionar Items na comboBox da Categoria
    	CategoriaJogosDAO.loadCategoriasJogos(categoriaJogo);
    	
    }*/
    @FXML
    void CarregarImagem(ActionEvent event) {	// botão para procurar a imagem no pc

    }

    @FXML
    void Confirmar(ActionEvent event) {  // botão para confimar o upload da imagem do anime
/*
    	//Vai verificar se todos os parametros estao preenchidos
    			if (imagem.getImage() != null && !imagem.getText().isEmpty() && !categoriaJogo.getSelectionModel().isEmpty() 
    					&& !devJogo.getText().isEmpty() && dataJogo.getValue() != null) {
    				
    				try {
    					//Vai converter a imagem que o utilizador fez upload para uma byte array
    					ByteArrayOutputStream baos = new ByteArrayOutputStream();
    					ImageIO.write(bufferedImage, "png", baos);
    					baos.flush();
    					byte[] imageInByte = baos.toByteArray();
    					baos.close();
    					//Vai adicionar o jogo na base de dados
    					AdicionarJogosDAO.addJogo(nomeJogo.getText(), dataJogo.getValue().toString(), categoriaJogo.getSelectionModel().getSelectedItem(), devJogo.getText(), imageInByte);
    				} catch (IOException e) {
    					e.printStackTrace();
    				}
    				
    				Dialog.warningDialog("Jogo adicionado", nomeJogo.getText() + " jogo adicionado com sucesso!");
    				
    			} 
    			else {
    				Dialog.warningDialog("Atenção!", "Preencha todos os campos anteriores!");
    				
    			}
    	    }*/
    }

    @FXML
    void LogOut(ActionEvent event) {	// botão para sair da conta e volta para o start
    	WindowManager.openMainWindow();

    }


    @FXML
    void VoltarAnimeX(ActionEvent event) {	// botão para voltar para o ModeradorScreen
    	WindowManager.openModerador();

    }
	

}

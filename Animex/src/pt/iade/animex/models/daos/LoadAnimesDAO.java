package pt.iade.animex.models.daos;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.util.Callback;
import pt.iade.gamestats.models.Jogo;

/**
 * Class responsavel por todas as queries para carregar os Jogos.
 */
public class LoadJogosDAO {
	animes(nome,autor,data,score,episodes,seasons,genre,synopsis,link,imagem)
	public static int idJogo = 0;
	
	public static void loadJogo(String jogoPesquisado, ListView<Jogo> listview, AnchorPane adicionarJogo) {
		ObservableList<Jogo> jogoLists = FXCollections.observableArrayList();
		
		try {
			//%or% Finds any values that have "or" in any position
			PreparedStatement statement = DBConnector.getConnection().prepareStatement("select * from jogos WHERE nome LIKE ?");
			statement.setString(1, jogoPesquisado + "%");
			ResultSet results = statement.executeQuery();
			while(results.next()){
				
				int idJogo = results.getInt("jogoID");
				String nomeJogo = results.getString("nome");
				String data = results.getString("data");
                String categoria = results.getString("categoria");
                   String desenvolvedor = results.getString("desenvolvedor");
                InputStream imagem = results.getBinaryStream("imagem");
                byte[] bytesImagem = getBytesFromInputStream(imagem);
				
				jogoLists.add(new Jogo(idJogo, bytesImagem, nomeJogo, data, categoria, desenvolvedor));
			}
			
			listview.setCellFactory(new Callback<ListView<Jogo>,ListCell<Jogo>>() {

				@Override
				public ListCell<Jogo> call(ListView<Jogo> arg0) {
					ListCell<Jogo> cell = new ListCell<Jogo>() {
						@Override
						protected void updateItem(Jogo jogo, boolean btl) {
							super.updateItem(jogo, btl);
							if (jogo != null) {
								
								Image img = new Image(new ByteArrayInputStream(jogo.getUrlImagem()));
								ImageView imgview = new ImageView(img);
								imgview.setFitHeight(100);
								imgview.setFitWidth(80);
								
								Button btnAdicionar = new Button("adicionar");
								btnAdicionar.setOnAction(new EventHandler<ActionEvent>() {
						            @Override  //Metodo para abrir a janela de adicionar jogo na Biblioteca, Arquivo ou Lista de desejos
						            public void handle(ActionEvent event) {  
						            	
						            	adicionarJogo.setVisible(true);
						            	idJogo = jogo.getId();
						            }
						        });
								
								 // Vai criar uma Box para colocar a imagem, nome e botao no centro do lado esquerdo
			                    HBox hBox = new HBox(5);
			                    hBox.setAlignment(Pos.CENTER_LEFT);
			
			                    hBox.getChildren().addAll(
			                    		imgview,
			                            new Label(jogo.getNome()), btnAdicionar);
			                    
			                    setGraphic(hBox);
								
							}
						}
					};
					return cell;
				}
				
			});
			listview.setItems(jogoLists);
		}
		catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	

}
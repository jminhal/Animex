package pt.iade.animex.models.daos;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
import javafx.scene.layout.HBox;
import javafx.util.Callback;
import pt.iade.animex.WindowManager;
import pt.iade.animex.models.Anime;
/**
 * Class responsavel por todas as queries para carregar os Animes.
 */

public class LoadAnimeDAO {
	public static int anime_id = 0;
	public static void loadAnime(String procurarAnime,ListView<Anime> ListViewAnimes) {
			
		
		ObservableList<Anime> animeList = FXCollections.observableArrayList();

	
		try {
			//%or% Finds any values that have "or" in any position
			PreparedStatement statement = DBConnector.getConnection()
					.prepareStatement("select * from Animes WHERE nome LIKE ?");
			statement.setString(1, procurarAnime + "%");
			ResultSet results = statement.executeQuery();
			while(results.next()){
				
				
				
				
				int anime_id = results.getInt("anime_id");
				String nome= results.getString("nome");
				String link= results.getString("link");
				String data= results.getString("data");
				int episodes = results.getInt("episodes");
				float score = results.getFloat("score");
				int seasons = results.getInt("seasons");
				String autor= results.getString("autor");
				String synopsis= results.getString("synopsis");
				String genre = results.getString("genre");
                InputStream imagem = results.getBinaryStream("imagem");
                byte[] imagem1 = getBytesFromInputStream(imagem);
                
                animeList.add(new Anime(anime_id,nome,link,data,episodes,score,seasons,autor,synopsis,genre,imagem1));

			}
			
			ListViewAnimes.setCellFactory(new Callback<ListView<Anime>,ListCell<Anime>>() {

				@Override
				public ListCell<Anime> call(ListView<Anime> arg0) {
					ListCell<Anime> cell = new ListCell<Anime>() {
						@Override
						protected void updateItem(Anime anime, boolean btl) {
							super.updateItem(anime, btl);
							if (anime != null) {
								
								Image img = new Image(new ByteArrayInputStream(anime.getImagem()));
								ImageView imgview = new ImageView(img);
								imgview.setFitHeight(80);
								imgview.setFitWidth(50);
								
								Button btnAdicionar = new Button("Mais informação");
								btnAdicionar.setOnAction(new EventHandler<ActionEvent>() {
						            @Override  //Metodo para abrir a janela de adicionar jogo na Biblioteca, Arquivo ou Lista de desejos
						            public void handle(ActionEvent event) {  
						            	anime_id = anime.getAnime_id();
						            	WindowManager.openinfoAnime();
						            }
						        });
								
								 // Vai criar uma Box para colocar a imagem, nome e botao no centro do lado esquerdo

								HBox hBox = new HBox(5);
			                    hBox.setAlignment(Pos.CENTER_LEFT); 	
			
			                    hBox.getChildren().addAll(
			                    		imgview,
			                            new Label(anime.getNome()),
			                    		new Label("",btnAdicionar));

			                    
			                    setGraphic(hBox);
			                    
							}
						}
					};
					return cell;
				}
				
			});
			ListViewAnimes.setItems(animeList);
		}
		catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void loadAnimeContinue(int user_id, String animePesquisado, ListView<Anime> listview) {
		ObservableList<Anime> animeList = FXCollections.observableArrayList();
		
		try {
			//%or% Finds any values that have "or" in any position
			PreparedStatement statement = DBConnector.getConnection().prepareStatement("select A.anime_id, A.nome,A.autor, A.data, A.score, A.episodes, A.seasons, A.genre, A.synopsis, A.link, A.imagem from animes A, continuarver C where A.anime_id = C.anime_id and C.user_id = ? and A.nome like ?");
			statement.setInt(1, user_id);
			statement.setString(2, animePesquisado + "%");
			ResultSet results = statement.executeQuery();
			while(results.next()){
				
				int anime_id = results.getInt("anime_id");
				String nome= results.getString("nome");
				String link= results.getString("link");
				String data= results.getString("data");
				int episodes = results.getInt("episodes");
				float score = results.getFloat("score");
				int seasons = results.getInt("seasons");
				String autor= results.getString("autor");
				String synopsis= results.getString("synopsis");
				String genre = results.getString("genre");
                InputStream imagem = results.getBinaryStream("imagem");
                byte[] imagem1 = getBytesFromInputStream(imagem);
                
                animeList.add(new Anime(anime_id,nome,link,data,episodes,score,seasons,autor,synopsis,genre,imagem1));
			}
			
			listview.setCellFactory(new Callback<ListView<Anime>,ListCell<Anime>>() {

				@Override
				public ListCell<Anime> call(ListView<Anime> arg0) {
					ListCell<Anime> cell = new ListCell<Anime>() {
						@Override
						protected void updateItem(Anime anime, boolean btl) {
							super.updateItem(anime, btl);
							if (anime != null) {
								
								Image img = new Image(new ByteArrayInputStream(anime.getImagem()));
								ImageView imgview = new ImageView(img);;
								imgview.setFitHeight(80);
								imgview.setFitWidth(50);
								
								Button btnAdicionar = new Button("Mais informação");
								btnAdicionar.setOnAction(new EventHandler<ActionEvent>() {
						            @Override  //Metodo para abrir a janela de adicionar jogo na Biblioteca, Arquivo ou Lista de desejos
						            public void handle(ActionEvent event) {  
						            	
						              	anime_id = anime.getAnime_id();
						            	WindowManager.openinfoAnime();
						            }
						        });
								
								 

								HBox hBox = new HBox(5);
			                    hBox.setAlignment(Pos.CENTER_LEFT); 	
			
			                    hBox.getChildren().addAll(
			                    		imgview,
			                            new Label(anime.getNome()),
			                    		new Label("",btnAdicionar));

			                    
			                    setGraphic(hBox);
								
							}
						}
					};
					return cell;
				}
				
			});
			listview.setItems(animeList);
		}
		catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void loadAnimeBacktoWatch(int user_id, String animePesquisado, ListView<Anime> listview) {
		ObservableList<Anime> animeList = FXCollections.observableArrayList();
		
		try {
			//%or% Finds any values that have "or" in any position
			PreparedStatement statement = DBConnector.getConnection().prepareStatement("select A.anime_id, A.nome,A.autor, A.data, A.score, A.episodes, A.seasons, A.genre, A.synopsis, A.link, A.imagem from animes A, voltarver B where A.anime_id = B.anime_id and B.user_id = ? and A.nome like ?");
			statement.setInt(1, user_id);
			statement.setString(2, animePesquisado + "%");
			ResultSet results = statement.executeQuery();
			while(results.next()){
				
				int anime_id = results.getInt("anime_id");
				String nome= results.getString("nome");
				String link= results.getString("link");
				String data= results.getString("data");
				int episodes = results.getInt("episodes");
				float score = results.getFloat("score");
				int seasons = results.getInt("seasons");
				String autor= results.getString("autor");
				String synopsis= results.getString("synopsis");
				String genre = results.getString("genre");
                InputStream imagem = results.getBinaryStream("imagem");
                byte[] imagem1 = getBytesFromInputStream(imagem);
                
                animeList.add(new Anime(anime_id,nome,link,data,episodes,score,seasons,autor,synopsis,genre,imagem1));
			}
			
			listview.setCellFactory(new Callback<ListView<Anime>,ListCell<Anime>>() {

				@Override
				public ListCell<Anime> call(ListView<Anime> arg0) {
					ListCell<Anime> cell = new ListCell<Anime>() {
						@Override
						protected void updateItem(Anime anime, boolean btl) {
							super.updateItem(anime, btl);
							if (anime != null) {
								
								Image img = new Image(new ByteArrayInputStream(anime.getImagem()));
								ImageView imgview = new ImageView(img);;
								imgview.setFitHeight(80);
								imgview.setFitWidth(50);
								
								Button btnAdicionar = new Button("Mais informação");
								btnAdicionar.setOnAction(new EventHandler<ActionEvent>() {
						            @Override  //Metodo para abrir a janela de adicionar jogo na Biblioteca, Arquivo ou Lista de desejos
						            public void handle(ActionEvent event) {  
						            	
						              	anime_id = anime.getAnime_id();
						            	WindowManager.openinfoAnime();
						            }
						        });
								
								 

								HBox hBox = new HBox(5);
			                    hBox.setAlignment(Pos.CENTER_LEFT); 	
			
			                    hBox.getChildren().addAll(
			                    		imgview,
			                            new Label(anime.getNome()),
			                    		new Label("",btnAdicionar));

			                    
			                    setGraphic(hBox);
								
							}
						}
					};
					return cell;
				}
				
			});
			listview.setItems(animeList);
		}
		catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void addAnimeBacktoWatch(int user_id, int anime_id) {
		try {
			//Vai verificar se o utilizador ja tem esse jogo adicionado na biblioteca
			PreparedStatement statement = DBConnector.getConnection()
					.prepareStatement("select anime_id from voltarver where anime_id = ? and user_id = ?");
			statement.setInt(1, anime_id);
			statement.setInt(2, user_id);
			ResultSet results = statement.executeQuery();
			//Se o jogador nao tiver esse jogo ja adicionado na bilioteca vai adiciona-lo
			if (!results.next()) {
				
				//Vai fazer o insert do jogo na biblioteca
				PreparedStatement statement2 = DBConnector.getConnection()
						.prepareStatement("INSERT INTO voltarver (anime_id, user_id) VALUES (?,?)");
				statement2.setInt(1, anime_id);
				statement2.setInt(2, user_id);
				statement2.executeUpdate();
				System.out.print("sdas");
				
				//Dialog.informationDialog("Jogo Adicionado!", "Jogo adicionado na biblioteca com sucesso!");
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void addAnimeContinue(int user_id, int anime_id) {
		try {
			//Vai verificar se o utilizador ja tem esse jogo adicionado na biblioteca
			PreparedStatement statement = DBConnector.getConnection()
					.prepareStatement("select anime_id from continuarver where anime_id = ? and user_id = ?");
			statement.setInt(1, anime_id);
			statement.setInt(2, user_id);
			ResultSet results = statement.executeQuery();
			//Se o jogador nao tiver esse jogo ja adicionado na bilioteca vai adiciona-lo
			if (!results.next()) {
				
				//Vai fazer o insert do jogo na biblioteca
				PreparedStatement statement2 = DBConnector.getConnection()
						.prepareStatement("INSERT INTO continuarver (anime_id, user_id) VALUES (?,?)");
				statement2.setInt(1, anime_id);
				statement2.setInt(2, user_id);
				statement2.executeUpdate();
				System.out.print("sdsad");
				
				//Dialog.informationDialog("Jogo Adicionado!", "Jogo adicionado na biblioteca com sucesso!");
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	public static byte[] getBytesFromInputStream(InputStream is) throws IOException {


    	ByteArrayOutputStream os = new ByteArrayOutputStream(); 
    	byte[] buffer = new byte[0xFFFF];
    	for (int len = is.read(buffer); len != -1; len = is.read(buffer)) { 
    		os.write(buffer, 0, len);
    	}
    	return os.toByteArray();
    }
	public static ArrayList<Anime> getInfoAnime(int animeID) {
		ArrayList<Anime> animeList = new ArrayList<Anime>();

		try {
			//%or% Finds any values that have "or" in any position
			PreparedStatement statement = DBConnector.getConnection().prepareStatement("select * from Animes WHERE anime_id= ?");
			statement.setInt(1, animeID );
			ResultSet results = statement.executeQuery();
			if(results.next()){
				
				
				
				
				int anime_id = results.getInt("anime_id");
				String nome= results.getString("nome");
				String link= results.getString("link");
				String data= results.getString("data");
				int episodes = results.getInt("episodes");
				float score = results.getFloat("score");
				int seasons = results.getInt("seasons");
				String autor= results.getString("autor");
				String synopsis= results.getString("synopsis");
				String genre = results.getString("genre");
                InputStream imagem = results.getBinaryStream("imagem");
                byte[] imagem1 = getBytesFromInputStream(imagem);
                
                animeList.add(new Anime(anime_id,nome,link,data,episodes,score,seasons,autor,synopsis,genre,imagem1));

			}
			
			
		
		
		}
		catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return animeList;
		
	 }
	}

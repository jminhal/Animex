package pt.iade.animex.controllers;


import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import pt.iade.animex.models.Anime;
import pt.iade.animex.models.daos.LoadAnimeDAO;

public class SearchController {

    /**
	 * ID da lable de procurar anime
	 */
    @FXML
    private TextField ProcurarAnime;
    /**
	 * ID lista de Animes
	 */
    @FXML
    private ListView<Anime> ListViewAnimes;
    /**
     *Quando este controlador iniciar vai iniciar o initialize
     *Vai carregar os Animes que est�o na base de dados para a listview e se o utilizador escrever 
     *alguma coisa na barra de pesquisa vai s� aparecer os jogos come�ados pelas letras.
     */
    @FXML
	private void initialize() { 
    	//Vai carregar todos os Animes na listview
		LoadAnimeDAO.loadAnime(ProcurarAnime.getText(),ListViewAnimes);
		ProcurarAnime.textProperty().addListener((observable, oldValue, newValue) -> {
			//Quando escreve alguma coisa na barra de pesquisa vai atualizar a listview
	    	//e vai aparecer os Animes comecados com as letras que o utilizador colocou na barra de procura
    		LoadAnimeDAO.loadAnime(newValue, ListViewAnimes);
    	});

	}
    




    
}




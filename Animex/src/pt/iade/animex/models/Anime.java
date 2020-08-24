package pt.iade.animex.models;

import java.util.ArrayList;

public class Anime {
	
	public static ArrayList<Anime> jogoCache = new ArrayList<Anime>();
	
	private int anime_id;
	private byte[] imagem;
	private String nome;
	private String link;
	private String data;
	private int episodes;
	private float score;
	private int seasons;
	private String autor;
	private String synopsis;
	private String genre;

	

	public Anime(int anime_id, byte[] imagem, String nome, String link, String data, int episodes, float score,
			int seasons, String autor, String synopsis, String genre) {
		this.anime_id = anime_id;
		this.imagem = imagem;
		this.nome = nome;
		this.link = link;
		this.data = data;
		this.episodes = episodes;
		this.score = score;
		this.seasons = seasons;
		this.autor = autor;
		this.synopsis = synopsis;
		this.genre = genre;
	}



	public int getAnime_id() {
		return anime_id;
	}



	public byte[] getImagem() {
		return imagem;
	}



	public String getNome() {
		return nome;
	}



	public String getLink() {
		return link;
	}



	public String getData() {
		return data;
	}



	public int getEpisodes() {
		return episodes;
	}



	public float getScore() {
		return score;
	}



	public int getSeasons() {
		return seasons;
	}



	public String getAutor() {
		return autor;
	}



	public String getSynopsis() {
		return synopsis;
	}



	public String getGenre() {
		return genre;
	}
	
}

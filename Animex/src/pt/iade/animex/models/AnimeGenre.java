package pt.iade.animex.models;

public enum AnimeGenre {

	MYSTERY("Mystery"),
	AFICTION("Adventure-Fiction"),
	DFANTASY("Dark-Fantasy"),;
	private final String AnimeGenre;
	
	private AnimeGenre(String AnimeGenre) {
		this.AnimeGenre = AnimeGenre;
	}

	public String getAnimeGenre() {
		return AnimeGenre;
	}
	
	
}

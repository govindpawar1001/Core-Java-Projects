package MusicLibrary;

public class Song {
	
	private String title;
	private String artist;
	private int duration;
	private String generic;
	private String lang;
	public Song(String title, String artist, int duration, String generic, String lang) {
		super();
		this.title = title;
		this.artist = artist;
		this.duration = duration;
		this.generic = generic;
		this.lang = lang;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getGeneric() {
		return generic;
	}
	public void setGeneric(String generic) {
		this.generic = generic;
	}
	public String getLang() {
		return lang;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
	@Override
	public String toString() {
		return "Song [title=" + title + ", artist=" + artist + ", duration=" + duration + ", generic=" + generic
				+ ", lang=" + lang + "]";
	}
	
	
	

}

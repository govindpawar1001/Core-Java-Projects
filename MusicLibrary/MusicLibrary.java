package MusicLibrary;

import java.util.ArrayList;
import java.util.List;

public class MusicLibrary {

	private String playlistname;
	private List<Song> songs;
	
	
	public MusicLibrary(String playlistname) {
		super();
		this.playlistname = playlistname;
		songs=new ArrayList<Song>();
		
	}
	
	
	public void addSong(Song song) {
		songs.add(song);
		System.out.println("Song Added Successfully");
		
	}
	
	public void removeSong(String removeSong) {
	    boolean removed = songs.removeIf(s -> s.getTitle().equalsIgnoreCase(removeSong));
	    if (removed) {
	        System.out.println(removeSong + " removed successfully.");
	    } else {
	        System.out.println("not found in playlist.");
	    }
	}

	
	
	public String getPlaylistname() {
		return playlistname;
	}
	public void setPlaylistname(String playlistname) {
		this.playlistname = playlistname;
	}
	public List<Song> getSongs() {
		return songs;
	}
	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}


	public void playSong(Song song) {

		for (Song s: songs) {
			if(s.getTitle().equalsIgnoreCase(song.getTitle())) {
				System.out.println(s.getTitle()+" is playing now ....."+" "+s.getArtist()+" "+s.getDuration());
				try {
					Thread.sleep(5000);
					return ;
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		System.out.println("Song Not Found");
	}





	
	
	
	

}

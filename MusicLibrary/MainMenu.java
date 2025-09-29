package MusicLibrary;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.linkcode.in.list;

public class MainMenu {
	
    private static Scanner sc = new Scanner(System.in);
    static List<Song> globalLibrary = new ArrayList<Song>();

    public static void initializeGlobalLibrary() {
        globalLibrary.add(new Song(" Sundari ", " Sanju ", 3, " romantic ", " marathi "));
        globalLibrary.add(new Song(" Saiyara", "Kishor Kumar", 6, "romantic", "hindi"));
        globalLibrary.add(new Song(" Dhun", "Arjit", 3, "romantic", "hindi"));
        globalLibrary.add(new Song(" Shape of You", "Ed Sheeran", 7, "pop", "english"));
        globalLibrary.add(new Song(" Kala Chasma", "Amar", 3, "party", "hindi"));
        globalLibrary.add(new Song(" Wajle Ki Bara", "Bella Shende", 3, "lavni", "marathi"));
    }

    public static void main(String[] args) {
        initializeGlobalLibrary();

        System.out.print("Enter Playlist Name: ");
        MusicLibrary library = new MusicLibrary(sc.next());

        boolean flag = true;
        do {
            System.out.println("\n=== MUSIC LIBRARY  ===");
            System.out.println("1. Add Song");
            System.out.println("2. View All Songs");
            System.out.println("3. Play a Song");
            System.out.println("4. Remove a Song");
            System.out.println("5. Filter by Artist");
            System.out.println("6. Filter by Genre");
            System.out.println("7. Filter by Duration");
            System.out.println("8. View all Global Songs");
            System.out.println("9. Sort By Title");
            System.out.println("10.Exit");
            System.out.print("Enter your Choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    globalLibrary.forEach(val -> System.out.println(val.getTitle()));
                    
                    System.out.print("Enter Song Name to Add: ");
                    sc.nextLine();
                    String songName = sc.nextLine();
                    
                    Song song = findSongByName(songName);
                    if (song != null) {
                        library.addSong(song);
                    } else {
                        System.out.println("Song not found ");
                    }
                }
                case 2 -> {
                   library.getSongs().forEach(val ->  System.out.println(val.getTitle() + " by " + val.getArtist() +  " : " + val.getDuration() + " Min"));
                }
                
              case 3->{
            	  System.out.println("Enter a Song :");
            	  sc.nextLine();
            	  String songname=sc.nextLine();
            	  Song song=findSongByName(songname);
            	  library.playSong(song);
              }
                
                case 4 -> {
                    if (library.getSongs().isEmpty()) {
                        System.out.println("Playlist is empty.");
                    } else {
                        library.getSongs().forEach(val -> System.out.println(val.getTitle()));
                        System.out.print("Enter a song to remove: ");
                        sc.nextLine();
                        String removeSong = sc.nextLine();
                        library.removeSong(removeSong);
                    }
                }

                case 5->{
                	System.out.println("Enter Artist Name :");
                	sc.nextLine();
                	String name=sc.nextLine();
                	List<Song> songs= filterByArtist(name);
                	songs.forEach(val->System.out.println(val.getTitle()+" , "+val.getArtist()+val.getDuration()));
                }
                
                case 6->{
                	System.out.println("Enter a Genere");
                	sc.nextLine();
                	String name=sc.nextLine();
                	List<Song> songs=filterByGenere(name);
                	songs.forEach(val->System.out.println(val.getTitle()+" , "+val.getArtist()+val.getDuration()));

                	
                }
                case 7->{
                	System.out.println("Enter min Time :");
                	int min=sc.nextInt();
                	System.out.println("Enter max Time :");
                	int max=sc.nextInt();
                	
                	List<Song> songs=filterByDuration(min, max);
                	songs.forEach(val->System.out.println(val.getTitle()+" , "+val.getArtist()));
                }
                case 8->{
                	globalLibrary.forEach(val->System.out.println(val.getTitle()+val.getArtist()+val.getGeneric()+val.getDuration()+" min "));
                }

                
                case 9->{
                	System.out.println("before sorting");
                	sc.nextLine();
                	globalLibrary.forEach(val->System.out.println(val.getTitle()));
                	sortSongByTitle();
                	System.out.println("After sorting");

                	globalLibrary.forEach(val->System.out.println(val.getTitle()));
                }
                case 10 -> {
                    flag = false;
                    System.out.println("Exit Successfully");
                    
                }
                default -> System.out.println(" Invalid Choice. Try again...");
            }
        } while (flag);
    }
    
    

    private static List<Song> filterByDuration(int min, int max) {
		return (List<Song>) globalLibrary.stream().filter(val->val.getDuration()>=min&&val.getDuration()<=max).collect(Collectors.toList());
    	
		
	}

	private static List<Song> filterByGenere(String name) {
		return globalLibrary.stream().filter(val->val.getGeneric().equalsIgnoreCase(name)).collect(Collectors.toList());
	}

	private static List<Song> filterByArtist(String name) {
    	
		return globalLibrary.stream().filter(val->val.getArtist().equalsIgnoreCase(name)).collect(Collectors.toList());
	}

	private static Song findSongByName(String songName) {
        for (Song s : globalLibrary) {
            if (s.getTitle().equalsIgnoreCase(songName)) {
                return s;
            }
        }
        return null;
    }
	
	
	public static void sortSongByTitle() {
		globalLibrary.sort((s1,s2)->s1.getTitle().compareToIgnoreCase(s2.getTitle()));
	}
	
}

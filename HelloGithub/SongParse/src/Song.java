import java.util.Scanner;

public class Song {
	String year;
	String rank;
	String artist;
	String title;
	
	public static Song parse(String s) {
		Scanner in = new Scanner(s).useDelimiter("\t");
		Song newSong = new Song();
		newSong.year = in.next();
		newSong.rank = in.next();
		newSong.artist = in.next();
		newSong.title = in.next();
		return newSong;
	}
	
	public String getYear() {
		return year;
	}
	
	public String getRank() {
		return rank;
	}
	
	public String getArtist() {
		return artist;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String toString() {
		return year+"\t"+rank+"\t"+artist+"\t"+title;
	}
}

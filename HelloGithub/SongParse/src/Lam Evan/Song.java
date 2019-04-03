import java.util.Scanner;

public class Song {
	int year;
	int rank;
	String artist;
	String title;
	
	public static Song parse(String s) {
		Scanner in = new Scanner(s).useDelimiter("\t");
		Song newSong = new Song();
		newSong.year = in.nextInt();
		newSong.rank = in.nextInt();
		newSong.artist = in.next();
		newSong.title = in.next();
		return newSong;
	}
	
	public int getYear() {
		return year;
	}
	
	public int getRank() {
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

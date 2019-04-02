import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;

public class SongCollection {
	private ArrayList<Song> songs = new ArrayList<>();
	
	public SongCollection(ArrayList<Song> songs) {
		this.songs = songs;
	}
	//different filters sequential
	public void filterYear(Range r) throws FileNotFoundException {
		for (int i = 0; i < songs.size(); i++) {
			if (r.contains(songs.get(i).getYear())) {
			} else {
				songs.remove(i);
				i--;
			}
		}
	}

	public void filterRank(Range r) throws FileNotFoundException {
		for (int i = 0; i < songs.size(); i++) {
			if (r.contains(songs.get(i).getRank())) {
			} else {
				songs.remove(i);
				i--;
			}
		}
	}

	public void filterArtist(String r) throws FileNotFoundException {
		for (int i = 0; i < songs.size(); i++) {
			if (songs.get(i).getArtist().contains(r)) {
			} else {
				songs.remove(i);
				i--;
			}
		}
	}

	public void filterTitle(String r) throws FileNotFoundException {
		for (int i = 0; i < songs.size(); i++) {
			if (songs.get(i).getTitle().contains(r)) {
			} else {
				songs.remove(i);
				i--;
			}
		}

	}
	
	public void sortYear() {
		selectionSort("year");
	}
	
	public void sortRank() {
		selectionSort("rank");
	}
	
	public void sortArtist() {
		selectionSort("artist");
	}
	
	public void sortTitle() {
		selectionSort("title");
	}
	//selection sort sort
	public void selectionSort(String pick) {
		for (int i = 0; i < songs.size(); i++) {
			int min = i;
			for (int j = i + 1; j < songs.size(); j++) {
				if (pick.equals("year")) {
					if (songs.get(j).getYear() < songs.get(min).getYear()) {
						min = j;
					}
				} else if(pick.equals("rank")) {
					if (songs.get(j).getRank() < songs.get(min).getRank()) {
						min = j;
					}
				} else if(pick.equals("artist")) {
					if (songs.get(j).getArtist().compareTo(songs.get(min).getArtist()) < 0) {
						min = j;
					}
				} else if(pick.equals("title")) {
					if (songs.get(j).getTitle().compareTo(songs.get(min).getTitle()) < 0) {
						min = j;
					}
				}
			}
			Song temp = songs.get(i);
			songs.set(i, songs.get(min));
			songs.set(min, temp);
		}
	}
	public void output(PrintStream out) {
		for (Song n : songs) {
			out.println(n.toString());
		}
		System.out.println(songs.size() + " matches found!");
	}
	
	public void copyArrayList(ArrayList<Song> aL1, ArrayList<Song> aL2) {
		aL1.clear();
		int i = 0;
		for(; i < aL2.size(); i++) {
			aL1.add(aL2.get(i));
		}

	}
}

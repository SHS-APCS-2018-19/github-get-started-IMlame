import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class GazillionSongs {
	static ArrayList<Song> songs = new ArrayList<>();

	public static void main(String args[]) throws FileNotFoundException {
		ArrayList<String> rawr = new ArrayList<>();
		rawr.add("hehexd");
		rawr.add("hehexd");
		rawr.add("hehexd");
		System.out.println(rawr);
		/*SongCollection finalList = new SongCollection(songs);
		System.out.println("Hello!\tWhat file would you like to process?");
		Scanner input = new Scanner(System.in);
		File inFile = new File(input.nextLine());
		if (!inFile.exists()) {
			System.out.println("Invalid input file. Reenter...");
			inFile = new File(input.nextLine());
		}
		Scanner in = new Scanner(inFile);//input file
		System.out.println("What file would you like to output to?");
		File outFile = new File(input.nextLine());//output file

		int cont = 0;
		while (outFile.exists() && cont == 0) {
			System.out.println(
					"File already exists. Would you like to replace it?\n(1) To replace\n(2) To input a new file name");
			int temp = input.nextInt();
			if (temp == 1) {
				cont = 1;
			}
			if (temp == 2) {
				System.out.println("waiting...");
				outFile = new File(input.next());
			}
		}
		System.out.println("Done.");
		PrintStream out = new PrintStream(outFile);
		//add all songs
		while (in.hasNextLine()) {
			songs.add(Song.parse(in.nextLine()));
		}
		int end = 0;
		int finish = 0;
		//finish when all valid inputs parsed and inputed
		while (finish == 0) {
			String title, artist, rank, year, filter;
			title = artist = rank = year = filter = "";
			System.out.println("Filters? -title<title>, -artist<artist>, -year<range>, -rank<rank>");
			int retry = 1;
			while (retry == 1) {
				Scanner newIn = new Scanner(System.in);
				Scanner temp = new Scanner(newIn.nextLine());
				end = 0;
				while (temp.hasNext() && end != 1) {
					filter = temp.next();
					if (!filter.contains("<") || !filter.contains(">")) {
						System.out.println("invalid input");
						title = artist = year = rank = "";
						while (temp.hasNext()) {
							temp.next();
						}
						retry = 1;
						System.out.println("new input?");
						//parse title, artist, year, rank
					} else if (filter.toLowerCase().contains("-title")) {
						filter = filter.substring(filter.indexOf('<') + 1, filter.indexOf('>'));
						title = filter;
						System.out.println(filter);
						retry = 0;
					} else if (filter.toLowerCase().contains("-artist")) {
						filter = filter.substring(filter.indexOf('<') + 1, filter.length() - 1);
						artist = filter;
						System.out.println(filter);
						retry = 0;
					} else if (filter.toLowerCase().contains("-year")) {
						filter = filter.substring(filter.indexOf('<') + 1, filter.length() - 1);
						year = filter;
						System.out.println(filter);
						Scanner test = new Scanner(filter).useDelimiter("-");
						if (Range.validYear(test)) {
							retry = 0;
						} else {
							//reset and ask for input again
							System.out.println("invalid year range\nnew filters?");
							title = artist = year = rank = "";
							while (temp.hasNext()) {
								temp.next();
							}
							retry = 1;
						}
					} else if (filter.toLowerCase().contains("-rank")) {
						filter = filter.substring(filter.indexOf('<') + 1, filter.length() - 1);
						rank = filter;
						System.out.println(filter);
						Scanner test = new Scanner(filter).useDelimiter("-");
						if (Range.validRank(test)) {
							retry = 0;
						} else {
							//reset and ask for input again
							System.out.println("invalid rank range\nnew filters?");
							title = artist = year = rank = "";
							while (temp.hasNext()) {
								temp.next();
							}
							retry = 1;
						}
					} else {
						System.out.println("invalid input");
						title = artist = year = rank = "";
						while (temp.hasNext()) {
							temp.next();
						}
						retry = 1;
						System.out.println("new input?");
					}
				}
			}
			//filter calls
			if (!year.equals("")) {
				finalList.filterYear(Range.parse(year));
			}
			if (!rank.equals("")) {
				finalList.filterRank(Range.parse(rank));
			}
			if (!artist.equals("")) {
				finalList.filterArtist(artist);
			}
			if (!title.equals("")) {
				finalList.filterTitle(title);
			}

			System.out.println("How would you like it sorted? (\"year\", \"rank\", \"artist\", \"title\", \"bypass\")");
			//invalid input test
			int end1 = 0;
			String sort = "";
			while (end1 == 0) {
				sort = input.next();
				if (sort.equals("year") || sort.equals("rank") || sort.equals("artist") || sort.equals("title")|| sort.equals("bypass")) {
					end1 = 1;
				} else {
					System.out.println("invalid option. pick again!");
				}
			}
			//input for sort
			if (sort.toLowerCase().contains("year")) {
				finalList.sortYear();
				System.out.println("sorted by year");
			} else if (sort.toLowerCase().contains("rank")) {
				finalList.sortRank();
				System.out.println("sorted by rank");
			} else if (sort.toLowerCase().contains("artist")) {
				finalList.sortArtist();
				System.out.println("sorted by artist");
			} else if (sort.toLowerCase().contains("title")) {
				finalList.sortTitle();
				System.out.println("sorted by title");
			} else if (sort.toLowerCase().contains("bypass")) {
				finalList.sortTitle();
				System.out.println("sorted by... nothing?");
			}
			System.out.println("end? y/n");
			String ends = input.next();
			if (ends.equals("y")) {
				finish = 1;
			}
		}
		//end
		System.out.println("outputting...");
		finalList.output(out);
		System.out.println("Finished.");
	}
	*/
	}

}

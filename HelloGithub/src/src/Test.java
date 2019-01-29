package src;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String phrase = "here is the word";
		int psn = phrase.indexOf("e");
		while(psn >=0) {
			System.out.print(psn + " ");
			phrase = phrase.substring(psn + 1);
			System.out.println(phrase);
			psn = phrase.indexOf("e");
		}
	}

}

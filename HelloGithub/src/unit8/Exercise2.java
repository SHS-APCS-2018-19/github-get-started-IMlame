import java.util.Scanner;

public class Exercise2 {

	public static void main(String[] args) {
		System.out.println(palindrome("rawwar"));
	}
	public static boolean palindrome(String input) {
		if(input.length() <= 1) {
			return true; 
		} else {
			return (input.substring(0, 1).equals(input.substring(input.length()-1)) && palindrome(input.substring(1, input.length()-1)));
		}
			
	}
}

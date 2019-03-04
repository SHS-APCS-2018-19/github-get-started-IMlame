import java.util.Scanner;

public class Exercise1 {

	public static void main(String[] args) {
		System.out.println(reverse("S"));
	}

	public static String reverse(String rev) {
		if(rev.equals("")) {
			return "";
		}
		if(rev.equals(null)) {
			return null;
		}
		Scanner decode = new Scanner(rev).useDelimiter("&");
		if (!rev.contains("&") && !rev.contains("#")) {
			rev += "&" + 0 + "&" + (rev.length());
			return reverse(rev);
		} else if (rev.contains("#")) {
			return rev.substring(0, rev.length() - 1);

		} else {
			String temp = decode.next();
			char end = temp.charAt(temp.length() - 1);
			int count = decode.nextInt();
			int total = decode.nextInt();
			if (count == total) {
				return temp;
			}
			rev = temp.substring(0, count) + end + temp.substring(count, temp.length() - 1);
			count++;
			rev += "&" + count + "&" + total;
			System.out.println(rev);
			return reverse(rev);
		}	
	}

}

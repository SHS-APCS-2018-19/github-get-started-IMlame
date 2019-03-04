
public class Recursionex1 {
	public static void main(String[] args) {
		System.out.println(reverse("SUSAN"));
	}

	public static String reverse(String rev) {
		if(rev.length() <=1) {
			return rev;
		} else {
			return reverse(rev.substring(1)) + rev.charAt(0);
		}
	}
}

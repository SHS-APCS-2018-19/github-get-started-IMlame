package unit7;

import java.util.Arrays;

public class test {

	public static void main(String[] args) {
		String[] a = {"hi","dab"};
		String[] b = a.clone();
		a[0] = "dab";
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));

	}

}

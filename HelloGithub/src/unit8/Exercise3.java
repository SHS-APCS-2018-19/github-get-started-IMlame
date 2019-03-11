package unit8;
public class Exercise3 {

	public static void main(String[] args) {
		System.out.println(fibonacci(4));
	}

	public static int fibonacci(int num) {
		if (num <= 0) {
			return 0;
		} else if(num == 1) {
			return 1;
		} else {
		return fibonacci(num - 1) + fibonacci(num - 2);
		}
	}
}

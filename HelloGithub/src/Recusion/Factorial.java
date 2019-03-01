package Recusion;


public class Factorial {
	public static void main(String[] args) {
		System.out.println(factorial(5,1));
	}
	public static int factorial(int n, int total) {
		if(n == 1 || n == 0) {
			return total;
		} else {
			total*= (n);
			return factorial(n-1, total);
		}
		
	}
}


public class Exercise4 {

	public static void main(String[] args) {
		System.out.println(GCD(234024,324));
	}
	public static int GCD(int num1, int num2) {
		if(num1 % num2 == 0) {
			return num2;
		} else {
			return GCD(num2,num1%num2);
		}
	}
}

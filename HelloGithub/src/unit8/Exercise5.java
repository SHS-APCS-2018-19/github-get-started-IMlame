
public class Exercise5 {

	public static void main(String[] args) {
		int target = 13;
		int[] arr = {1,3,5,7,10,13};
		System.out.println(binarySearch(arr, target, 0, arr.length-1));
	}
	public static int binarySearch(int[] arr, int target, int min, int max) {
		if(target > arr[max]) {
			return -1;
		} else {
			if(target < arr[((min+max)/2)]) {
				return(binarySearch(arr, target, min, (min+max)/2-1));
			} else if(target > arr[((min+max)/2)]) {
				return(binarySearch(arr, target, (min+max)/2+1, max));
			} else {
				return (min+max)/2;
			}
		}
	}

}

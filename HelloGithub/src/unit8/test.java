package unit8;

import java.util.ArrayList;
import java.util.List;

public class test {
	public static void main(String args[]) {
		String[] colors = {"m","d","c"};
		List<String> colorList = new ArrayList<String>();
		
		for(int i = colors.length -1; i >= 0; i--) {
			colorList.add(i, colors[i]);
		}
		System.out.println(colorList);
	}
}

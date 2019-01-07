package src;

import java.util.ArrayList;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		ArrayList<SetGetConstruct> listAllInfo = new ArrayList<SetGetConstruct>();
		SetGetConstruct[] arrayInfo = null;
		Scanner in = new Scanner(System.in);
		while (1 == 1) {
			System.out.println("1. new info");
			System.out.println("2. print out all info");
			String input = in.next();
			if(input.equals("1")) {
				listAllInfo.add(SetGetConstruct.createInfo());
				arrayInfo = listAllInfo.toArray(new SetGetConstruct[listAllInfo.size()]);
			}
			if(input.equals("2")) {
				for(int i = 0; i < arrayInfo.length; i++) {
					System.out.println(arrayInfo[i]);
				}
			}
		}
	}

}

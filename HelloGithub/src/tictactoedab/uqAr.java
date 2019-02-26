
public class uqAr {
	String[][] nextStep;
	int done = 0;
	int row = -0;
	int column = -0;
	public static uqAr make(String[][] currentStep) {
//		String[][] nextStep = new String[currentStep.length][currentStep[0].length];
		uqAr nextBoard = new uqAr();
		String[][] temp = new String[currentStep.length][currentStep[0].length];
		for(int i = 0; i < currentStep.length; i++) {
			for(int j = 0; j < currentStep[i].length; j++) {
				temp[i][j] = currentStep[i][j];
			}
		}
		nextBoard.nextStep = temp;
		return nextBoard;
	}
}

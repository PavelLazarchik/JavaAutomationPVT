package core;

public class Massive {
	
	public void printMassiveAsLine(int[] anyMassive1) {
		for(int i = 0; i < anyMassive1.length; i++) {
			System.out.print(anyMassive1[i]);
		}
	}
	
	public  void getSumOfElements(int[] anyMassive2) {
		System.out.println();
		int sum = 0;
		for(int i = 0; i<anyMassive2.length; i++) {
			sum = sum + anyMassive2[i];
			
		}
		System.out.println(sum);
	}
	
	public void multiptyBy3(int[] anyMassive3) {
		for (int i = 0; i< anyMassive3.length; i++) {
			System.out.print(anyMassive3[i] * 3);
		}
	}

}

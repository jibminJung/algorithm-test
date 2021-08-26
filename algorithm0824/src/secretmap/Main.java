package secretmap;

public class Main {
	static int n;
	static int[] arr1 = {9, 20, 28, 18, 11};
	static int[] arr2 = {30, 1, 21, 17, 28};
	public static void main(String[] args) {
		String[] arr3 = new String[n];
		
		for (int i = 0; i < n; i++) {
			arr3[i] = String.format("%"+n+"s",Integer.toBinaryString(arr1[i]|arr2[i])).replace("0"," ").replace("1", "#");
		}
		
	}

}

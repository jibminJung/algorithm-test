package dartgame;


public class Main {
	static String dartResult = "1S2D*3T";

	public static void main(String[] args) {
		String score = "";
		int[] arr = new int[3];
		int temp = 0;
		int j = 0;
		int ans = 0;

		for (int i = 0; i < dartResult.length(); i++) {
			char c = dartResult.charAt(i);
			if (c == 'S' || c == 'D' || c == 'T') {
				temp = Integer.parseInt(score);
				score = "";
				if (c == 'D') {
					temp = temp * temp;
				} else if (c == 'T') {
					temp = temp * temp * temp;
				}
				arr[j] = temp;
				j++;
			} else if (c == '#' || c == '*') {
				if (c == '#') {
					arr[j - 1] = arr[j - 1] * -1;
				} else {
					arr[j - 1] = arr[j - 1] * 2;
					if (j > 1) {
						arr[j - 2] = arr[j - 2] * 2;
					}
				}
			} else {
				score = score + c;
			}
		}

		for(int e:arr) {
			ans+=e;
		}
		System.out.println(ans);
	}

}

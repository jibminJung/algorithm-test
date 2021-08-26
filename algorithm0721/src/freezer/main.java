package freezer;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int target = Math.abs(M - N);
		int count = 0;
		count += target / 10;
		target = target % 10;

		switch (target) {
		case 1:
		case 5:
			count = count + 1;
			break;
		case 2:
		case 4:
		case 6:
		case 9:
			count = count + 2;
			break;
		case 3:
		case 7:
		case 8:
			count = count + 3;
			break;
		
		}
		System.out.println(count);

	}

}

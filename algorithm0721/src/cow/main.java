package cow;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class main {

	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		String bush = sc.next();
		sc.close();
		Queue<Character> list = new LinkedList<>();
		int numberOfFront = 0;
		int count =0;

		for (int i = 0; i < bush.length() - 1; i++) {
			if (bush.charAt(i) == '(' && bush.charAt(i + 1) == '(') {
				list.offer('T');
			} else if (bush.charAt(i) == ')' && bush.charAt(i + 1) == ')') {
				list.offer('F');
				numberOfFront++;
			}
		}

		while(!list.isEmpty()&&numberOfFront>0) {
			char c = list.poll();
			
			if(c=='T') {
				count = count + numberOfFront;
			}else {
				numberOfFront--;
			}
		}
		System.out.println(count);
	}

}

package kroatia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] exp = br.readLine().toCharArray();
		int total = exp.length;

		for (int i = 1; i < exp.length; i++) {
			if ((exp[i] == '-')) {
				if (exp[i - 1] == 'c' || exp[i - 1] == 'd') {
					total -= 1;
				}
			} else if (exp[i] == '=') {
				if (exp[i - 1] == 'c' || exp[i - 1] == 's') {
					total -= 1;
				}
				if (i > 1) {
					if (exp[i - 2] == 'd' && exp[i - 1] == 'z') {
						total -= 2;
					} else if (exp[i - 1] == 'z') {
						total -= 1;
					}
				} else {
					if (exp[i - 1] == 'z')
						total -= 1;
				}
			} else if (exp[i] == 'j' && (exp[i - 1] == 'l' || exp[i - 1] == 'n')) {
				total -= 1;
			}

		}
		System.out.println(total);

	}

}

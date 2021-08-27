package nexpression;

import java.util.HashSet;

public class Main {
	static int N=5;
	static int number=12;

	public static void main(String[] args) {

		HashSet<Integer>[] hs = new HashSet[9];
		int answer = -1;
		for (int i = 0; i < hs.length; i++) {
			hs[i] = new HashSet<Integer>();
			hs[i].add(makeNnumber(N, i));
		}

		for (int i = 1; i < hs.length; i++) {
			for (int j = 1; j < i; j++) {
				for(int x:hs[j]) {
					for(int y:hs[i-j]) {
						hs[i].add(x+y);
						hs[i].add(x*y);
						hs[i].add(x-y);
						if(y!=0) {
							hs[i].add(x/y);
						}
					}
				}
			}
			if(hs[i].contains(number)) {
				answer = i;
				break;
			}
		}
		System.out.println(answer);

	}

	static int makeNnumber(int n, int x) {
		String s = "0";
		String c = String.valueOf(n);
		for (int i = 0; i < x; i++) {
			s = s + c;
		}
		return Integer.parseInt(s);
	}

}

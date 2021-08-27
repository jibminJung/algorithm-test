package Hanoi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int count = 0;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		hanoi(1,2,3,n);
		System.out.println(count);
		System.out.println(sb);
	}

	static void hanoi(int from, int mid, int to, int n) {
		if (n == 1) {
			sb.append(from).append(' ').append(to).append('\n');
			count++;
			return;
		}
		hanoi(from, to, mid, n - 1);
		hanoi(from, mid, to, 1);
		hanoi(mid, from, to, n - 1);
	}

}

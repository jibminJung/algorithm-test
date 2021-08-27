package dnq2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			String[] st = br.readLine().split("");
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st[j]);
			}
		}
		dnq(0,0,n);
		System.out.println(sb);
	}
	static void dnq(int x, int y, int n) {
		if(check(x,y,n)) {
			sb.append(arr[x][y]);
			return;
		}
		int temp = n/2;
		sb.append("(");
		dnq(x,y,temp);
		dnq(x,y+temp,temp);
		dnq(x+temp,y,temp);
		dnq(x+temp,y+temp,temp);
		sb.append(")");
		
	}
	static boolean check(int x, int y, int n) {
		int std = arr[x][y];
		for (int i = x; i < n+x; i++) {
			for (int j = y; j < n+y; j++) {
				if(arr[i][j]!=std) return false;
			}
		}
		
		return true;
	}
}

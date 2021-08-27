package dnq3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int minus1 = 0;
	static int zero = 0;
	static int one = 0;
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dnq(0,0,n);
		System.out.println(minus1);
		System.out.println(zero);
		System.out.println(one);
		
	}
	static void dnq(int x, int y, int n) {
		if(check(x,y,n)) {
			if(arr[x][y]==1) {
				one++;
			}else if(arr[x][y]==0){
				zero++;
			}else {
				minus1++;
			}
			return;
		}
		int new_size = n/3;
		for (int i = x; i < x+n; i = i+new_size) {
			for (int j = y; j < y+n; j = j+new_size) {
				dnq(i,j,new_size);
			}
		}
//		dnq(x,y,new_size);
//		dnq(x,y+new_size,new_size);
//		dnq(x,y+(2*new_size),new_size);
//		
//		dnq(x+new_size,y,new_size);
//		dnq(x+new_size,y+new_size,new_size);
//		dnq(x+new_size,y+(2*new_size),new_size);
//		
//		dnq(x+(2*new_size),y,new_size);
//		dnq(x+(2*new_size),y+new_size,new_size);
//		dnq(x+(2*new_size),y+(2*new_size),new_size);
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

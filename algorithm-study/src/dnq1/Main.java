package dnq1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	static int white = 0;
	static int blue = 0;
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
		System.out.println(white);
		System.out.println(blue);
		
	}
	static int dnq(int x, int y, int n) {
		if(n==1) {
			if(arr[x][y]==1) {
				blue++;
			}else {
				white++;
			}
			return arr[x][y];
		}
		
		int temp = dnq(x,y,n/2) + dnq(x+ n/2, y, n/2)+ dnq(x, y + n/2, n/2)+dnq(x+ n/2, y+n/2, n/2);
		if(temp == 4) {
			blue -=3;
			return 1;
		}else if(temp ==0) {
			white -=3;
			return 0;
		}else {
			return temp;
		}
		
		
	}

}

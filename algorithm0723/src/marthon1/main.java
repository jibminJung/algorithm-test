package marthon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class main {
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr=new int[n][2];
		
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			
		}
		int baseDistance = 0;
		for (int i = 0; i < n-1; i++) {
			baseDistance += dist(i,i+1);
		}
		int ans = Integer.MAX_VALUE;
		for (int i = 1; i < n-1; i++) {
			int newDistance = baseDistance - dist(i - 1, i) - dist(i, i + 1) + dist(i - 1, i + 1);
			if (newDistance < ans)
				ans = newDistance;
		}
		System.out.println(ans);
		
	}
	public static int dist(int x, int y) {
		return Math.abs(arr[x][0] - arr[y][0]) + Math.abs(arr[x][1] - arr[y][1]);
	}

}

package knapsack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int[][] arr= new int[n+1][2];
		long[][] dp = new long[n+1][w+1];
		for (int i = 1; i < arr.length; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j <= w; j++) {
				dp[i][j] = dp[i-1][j];
				if(j-arr[i][0]>=0) {
					dp[i][j] = Math.max(dp[i][j], dp[i-1][j-arr[i][0]]+arr[i][1]);
				}
			}
		}
		long ans = 0;
		for (int i = 0; i <=w; i++) {
			ans = Math.max(ans, dp[n][i]);
		}
		System.out.println(ans);
		
	}

}

package milklove;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class main {
	static int n,m;
	static int[] milkPerGold,stock;
	static long[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		milkPerGold = new int[n+1];
		stock = new int[n+1];
		dp = new long[n+1][m+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < milkPerGold.length; i++) {
			milkPerGold[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < stock.length; i++) {
			stock[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[i].length; j++) {
				dp[i][j] = dp[i-1][j];
				int buy =0;
				for (long milk = 0; milk <= stock[i] && buy<=j; milk=milk+milkPerGold[i],buy++) {
					dp[i][j] = Math.max(dp[i-1][j-buy]+milk,dp[i][j]);
				}
			}
		}
		long ans = 0;
		for (int i = 1; i < dp[n].length; i++) {
			ans = Math.max(ans, dp[n][i]);
		}
		System.out.println(ans);
	}

}

package bookstore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int cash = Integer.parseInt(st.nextToken());
		int[] price = new int[n + 1];
		int[] page = new int[n + 1];
		long[][] dp = new long[n + 1][cash + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < price.length; i++) {
			price[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < page.length; i++) {
			page[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[i].length; j++) {
				dp[i][j] = dp[i-1][j];
				if(j-price[i]>=0) {
					dp[i][j] = Math.max(dp[i-1][j-price[i]]+page[i],dp[i][j]);
				}
			}
		}
		
		long ans =0;
		for (int i = 1; i < dp[n].length; i++) {
			ans = Math.max(ans, dp[n][i]);
		}
		System.out.println(ans);
	}

}

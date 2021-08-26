package coinmake;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int[] coins = new int[x];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < x; i++) {
			coins[i] = Integer.parseInt(st.nextToken());
		}
		int[] dp = new int[n+1];
		for (int i = 0; i < dp.length; i++) {
			dp[i]= -1;
		}
		dp[0]=0;
		for (int i = 1; i < dp.length; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < coins.length; j++) {
				int temp =i-coins[j];
				if(temp<0) continue;
				if(dp[temp]==-1) continue;
				min = Math.min(dp[temp]+1,min);
			}
			if(min!=Integer.MAX_VALUE) {
				dp[i] = min;
			}
		}
		System.out.println(dp[n]);
		
	}

}

package hotchoco;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n+2];
		int[] dp = new int[n+2];
		
		for (int i = 1; i <=n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		dp[1] = arr[1];
		dp[2] = dp[1]+arr[2];
		for (int i = 3; i <=n; i++) {
			dp[i] =  Math.max(Math.max(dp[i-2], dp[i-3]+arr[i-1])+arr[i],dp[i-1]);
		}
		System.out.println(dp[n]);
	}

}

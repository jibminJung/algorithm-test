package tile2n2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n+2];
		dp[0]=0;
		dp[1]= 1;
		dp[2] =3;
		for (int i = 3; i < dp.length; i++) {
			dp[i] = (dp[i-2]*2 + dp[i-1])%10007;
		}
		System.out.println(dp[n]);
		
	}

}

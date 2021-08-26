package numberbreakdown;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class main {
	static int[] dt;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int target = Integer.parseInt(st.nextToken());
		dt = new int[target + 1];
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		dt[0] = 1;
		for (int i = 1; i <= target; i++) {
			dt[i] = 0;
			for (int j = 0; j < arr.length; j++) {
				if(i-arr[j]>=0) {
					dt[i] += dt[i - arr[j]];
					dt[i] %= 1000000007;
				}
				
			}
		}

		System.out.println(dt[target]);

	}

}

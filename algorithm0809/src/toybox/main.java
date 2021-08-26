package toybox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class main {
	static int n,k;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new int[k];
		for (int i = 0; i < k; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		long l = 1;
		long r = 1000000000 - 1;
		while (l < r) {
			long mid = (l + r) / 2;
			if (chk(mid)) {
				r = mid;
			} else {
				l = mid + 1;
			}
		}
		System.out.println(l);
	}

	static boolean chk(long x) {
		long sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += (arr[i] + x - 1) / x;
			if (sum > n) {
				return false;
			}
		}
		return true;
	}
}

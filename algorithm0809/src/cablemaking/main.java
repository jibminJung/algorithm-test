package cablemaking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class main {

	static int n;
	static int m;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		long l = 1;
		long r = Integer.MAX_VALUE;
		while (l < r) {
			long mid = (l + r + 1) / 2;
			if (chk(mid)) {
				l = mid;
			} else {
				r = mid - 1;
			}
		}
		System.out.println(l);
	}

	static boolean chk(long x) {
		long sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i] / x;
		}
		if (sum >= m) {
			return true;
		}
		return false;
	}

}

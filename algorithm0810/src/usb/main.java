package usb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class main {
	static int n, m;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		long l = 1;
		long r = 1000000000;
		while (l < r) {
			long mid = (l + r) / 2;
			if (chk(mid)) {
				r=mid;
			} else {
				l=mid+1;
			}
		}
		System.out.println(l);
	}

	static boolean chk(long x) {
		int cnt = 0;
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > x) {
				return false;
			}
			if (sum + arr[i] > x) {
				sum = arr[i];
				cnt++;
			}else if(sum + arr[i] == x) {
				sum = 0;
				cnt++;
			}else {
				sum = sum + arr[i];
			}
		}
		if (sum > 0) {
			cnt++;
		}

		if (cnt <= m) {
			return true;
		}
		return false;
	}
}

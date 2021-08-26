package router;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class main {
	static int n, c;
	static ArrayList<Integer> arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		arr = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(arr);

		long l = 0;
		long r = 1000000000;
		while (l < r) {
			long mid = (l + r + 1) / 2;
			if (chk(mid)) {
				l = mid;
			} else {
				r = mid -1;
			}
		}
		System.out.println(l);
	}

	static boolean chk(long x) {
		int now = arr.get(0);
		int cnt =1;
		for (int i = 0; i < n; i++) {
			if(arr.get(i)>=now+x) {
				now = arr.get(i);
				cnt++;
			}
		}
		if(cnt>=c) {
			return true;
		}
		return false;
	}
}

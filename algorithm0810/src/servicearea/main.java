package servicearea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class main {
	static int n, m,len;
	static ArrayList<Integer> arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		len = Integer.parseInt(st.nextToken());
		arr = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(arr);

		long l = 0;
		long r = len;
		while (l < r) {
			long mid = (l + r) / 2;
			if (chk(mid)) {
				r = mid;
			} else {
				l = mid +1;
			}
		}
		System.out.println(l);
	}

	static boolean chk(long x) {
		int now = 0;
		int cnt =0;
		for (int i = 0; i < n; i++) {
			int tmp = arr.get(i)-now;
			cnt+= (tmp-1)/x;
			now = arr.get(i);
		}
		cnt+= (len-now-1)/x;
		if(cnt<=m) {
			return true;
		}
		return false;
	}
}

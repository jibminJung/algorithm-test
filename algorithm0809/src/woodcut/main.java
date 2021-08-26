package woodcut;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class main {
	static int n;
	static int m;
	static int[] tree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		tree = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
		}

		
		int l=0;
		int r = 1000000000;
		while(l<r) {
			int mid = (l+r+1)/2;
			if(chk(mid)) {
				l=mid;
			}else {
				r=mid-1;
			}
		}
		
		System.out.println(l);
	}
	static boolean chk(int x) {
		long sum =0;
		for (int i = 0; i < tree.length; i++) {
			if(tree[i]>x) {
				sum += (tree[i]-x);
			}
		}
		if(sum>=m) {
			return true;
		}
		return false;
	}
}

package icecut;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class main {
	static int n;
	static int m;
	static int[] ice;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		ice = new int[m];
		for (int i = 0; i < m; i++) {
			ice[i] = Integer.parseInt(br.readLine());
		}
		int l = 0;
		int r = 1000000000;
		while(l<r) {
			int mid = (l+r+1)/2;
			if(chk(mid)) {
				l = mid;
			}else {
				r=mid-1;
			}
		}
		System.out.println(l);
		
		
	}
	static boolean chk(int x) {
		if(x==0) {
			return true;
		}
		long sum =0;
		for (int i = 0; i < ice.length; i++) {
			sum += ice[i]/x;
		}
		if(sum>n) {
			return true;
		}
		return false;
	}
	
}

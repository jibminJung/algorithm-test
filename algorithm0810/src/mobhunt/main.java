package mobhunt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class main {
	static int n,k;
	static ArrayList<Integer> arr = new ArrayList<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		for (int i = 0; i < n; i++) {
			arr.add(Integer.parseInt(br.readLine()));
		}
		Collections.sort(arr);
		
		int l = 0;
		int r = 1000000000;
		while(l<r) {
			int mid = (l+r)/2;
			if(chk(mid)) {
				r=mid;
			}else {
				l=mid+1;
			}
		}
		System.out.println(l);
	}
	static boolean chk(int x) {
		int to = -1;
		int cnt =0;
		for (int i = 0; i < arr.size(); i++) {
			if(arr.get(i)<=to) {
				continue;
			}
			to = arr.get(i) + (2*x);
			cnt++;
		}
		if(cnt<=k) {
			return true;
		}
		return false;
	}
}

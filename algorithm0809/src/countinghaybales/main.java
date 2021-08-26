package countinghaybales;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		ArrayList<Integer> arr = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			arr.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(arr);
		arr.add(Integer.MAX_VALUE);
		
		for (int i = 0; i < q; i++) {
			st = new StringTokenizer(br.readLine());
			int a =Integer.parseInt(st.nextToken());
			int b =Integer.parseInt(st.nextToken());
			
			int l =0, r=n;
			while(l<r) {
				int mid = (l+r)/2;
				if(arr.get(mid)<a) {
					l = mid+1;
				}else if(arr.get(mid)>=a) {
					r =mid;
				}
			}
			
			int ai = l;
			
			l =0; r=n;
			while(l<r) {
				int mid = (l+r)/2;
				if(arr.get(mid)<=b) {
					l = mid+1;
				}else if(arr.get(mid)>b) {
					r =mid;
				}
			}
			int bi = l;
			
			sb.append(bi-ai).append('\n');
		}
		
	System.out.println(sb);	
	}
	

}

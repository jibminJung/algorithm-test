package findnumber;

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
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			int target= Integer.parseInt(st.nextToken());
			int l =0;
			int r = n-1;
			
			while(l<r) {
				int mid = (l+r)/2;
				if(arr[mid]<target) {
					l = mid+1;
				}else if(arr[mid]>target) {
					r=mid-1;
				}else if(arr[mid]==target) {
					l = mid;
					break;
				}
			}
			if(arr[l]==target) {
				sb.append(1).append('\n');
			}else {
				sb.append(0).append('\n');
			}
		}
		System.out.println(sb);
	}

}

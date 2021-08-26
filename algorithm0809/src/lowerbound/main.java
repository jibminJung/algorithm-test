package lowerbound;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr= new int[n+1];
		for (int i = 1; i <=n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int k = Integer.parseInt(br.readLine());
		int l = 1, r = n;
		while(l<r) {
			int mid = (l+r)/2;
			if(arr[mid]>k) {
				r = mid;
			}else if(arr[mid]<k) {
				l=mid+1;
			}else if(arr[mid]==k) {
				r=mid;
			}
		}
		System.out.println(arr[n]<k?n+1:l);
		
	}
}

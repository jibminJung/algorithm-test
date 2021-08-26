package insertionsort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class main {

	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sb.append(arr[i]).append(" ");
		}
		sb.append('\n');
		
		for (int i = 1; i < arr.length; i++) {
			int j = i;
			while(j>=1&&arr[j-1]>arr[j]) {
				swap(j-1,j);
				j--;
				for (int k = 0; k < arr.length; k++) {
					sb.append(arr[k]).append(" ");
				}
				sb.append('\n');
			}
		}
		System.out.println(sb);
		
	}
	static void swap(int idx1, int idx2) {
		int temp = arr[idx2];
		arr[idx2] = arr[idx1];
		arr[idx1] = temp;
	}
}

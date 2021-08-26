package nm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class main {
	static int n,m;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr= new int[m+1];
		dfs(1,1);
		System.out.println(sb);
		
	}
	static void dfs(int k, int d) {
		if(d==m+1) {
			for (int i = 1; i < arr.length; i++) {
				sb.append(arr[i]).append(' ');
			}
			sb.append('\n');
			return;
		}
		for (int i = k; i+(m-d) <=n; i++) {
				arr[d]= i;
				dfs(i+1,d+1);
		}
		
		
	}
}

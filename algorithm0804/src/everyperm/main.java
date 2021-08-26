package everyperm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main {
	static int n;
	static int[] arr;
	static boolean[] visit;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n+1];
		visit = new boolean[n+1];
		dfs(1);
		System.out.println(sb);
		
	}
	static void dfs(int d) {
		if(d==n+1) {
			for (int i = 1; i < arr.length; i++) {
				sb.append(arr[i]).append(' ');
			}
			sb.append('\n');
		}
		for (int i = 1; i <= n; i++) {
			if(visit[i]) continue;
			visit[i]=true;
			arr[d] = i;
			dfs(d+1);
			visit[i]=false;
			arr[d] = 0;
		}
	}
	
}

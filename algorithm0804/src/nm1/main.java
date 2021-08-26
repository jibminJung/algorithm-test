package nm1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class main {
	static int n,m;
	static boolean[] visit;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		visit = new boolean[n+1];
		arr= new int[m+1];
		dfs(1);
		System.out.println(sb);
		
	}
	static void dfs(int d) {
		if(d==m+1) {
			for (int i = 1; i < arr.length; i++) {
				sb.append(arr[i]).append(' ');
			}
			sb.append('\n');
			return;
		}
		for (int i = 1; i <=n; i++) {
			if(!visit[i]) {
				arr[d]= i;
				visit[i]=true;
				dfs(d+1);
				visit[i] =false;
			}
		}
		
		
	}
}

package loopy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main {
	static int[] arr;
	static boolean[] visit;
	static int cnt;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr =new int[n+1];
		visit = new boolean[n+1];
		cnt=0;
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		for (int i = 1; i <= n; i++) {
			dfs(i);
		}
		System.out.println(cnt);
		
		
	}
	static void dfs(int i) {
		if(visit[i]) {
			return;
		}
		if(arr[i]==0) {
			cnt++;
			return;
		}
		visit[i] = true;
		dfs(arr[i]);

		visit[i] = false;
	}

}

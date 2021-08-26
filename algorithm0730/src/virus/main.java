package virus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class main {
	
	static ArrayList<ArrayList<Integer>> gl;
	static boolean[] chk;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		gl = new ArrayList<>();
		chk = new boolean[n+1];
		for (int i = 0; i <= n; i++) {
			gl.add(new ArrayList<Integer>());
		}
		for (int i = 0; i <m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			gl.get(from).add(to);
			gl.get(to).add(from);
		}
		dfs(1);
		int cnt = 0;
		for (int i = 2; i < chk.length; i++) {
			if(chk[i]) {
				cnt++;
			}
		}
		System.out.println(cnt);
		
	}
	
	static void dfs(int i) {
		chk[i] = true;
		for (int y:gl.get(i)) {
			if(!chk[y]) {
				dfs(y);
			}
		}
	}
}

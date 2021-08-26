package bipartite;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class main {
	static boolean pos = true;
	static int[] color;
	static ArrayList<ArrayList<Integer>> arr;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		arr = new ArrayList<>();
		color = new int[n+1];
		for (int i = 0; i <= n; i++) {
			arr.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr.get(a).add(b);
			arr.get(b).add(a);
		}
		for (int i = 1; i <= n; i++) {
			if(color[i]==0) dfs(i,1);
		}
		System.out.println(pos?"YES":"NO");
	}
	static void dfs(int i, int c) {
		color[i] =c;
		for(int y:arr.get(i)) {
			if(color[y]==color[i]) pos=false;
			if(color[y]==0) {
				dfs(y,3-c);
			}
		}
	}

}

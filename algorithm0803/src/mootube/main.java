package mootube;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class main {

	static boolean[] visit;
	static int cnt;
	static ArrayList<ArrayList<Integer>> arr, usado;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		arr = new ArrayList<>();
		usado = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			arr.add(new ArrayList<Integer>());
			usado.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < n-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			arr.get(b).add(a);
			usado.get(b).add(r);
			arr.get(a).add(b);
			usado.get(a).add(r);
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int ki = Integer.parseInt(st.nextToken());
			int vi = Integer.parseInt(st.nextToken());
			visit = new boolean[n+1];
			cnt=0;
			dfs(ki,vi,1000000000);
			sb.append(cnt-1).append('\n');
		}
		System.out.println(sb);
	}
	
	static void dfs(int ki,int vi, int min) {
		if(min<ki) return;
		if(visit[vi]) return;
		visit[vi] = true;
		cnt++;
		for (int i = 0; i < arr.get(vi).size(); i++) {
			int to = arr.get(vi).get(i);
			int related = usado.get(vi).get(i);
			if(!visit[to]) {
				dfs(ki,to,Math.min(related,min));
			}
		}
		
		
	}

}

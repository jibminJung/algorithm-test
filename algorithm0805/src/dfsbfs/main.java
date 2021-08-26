package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class main {
	static int n, m, v;
	static boolean[] visit;
	static ArrayList<ArrayList<Integer>> arr;
	static Queue<Integer> q;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());
		visit = new boolean[n + 1];
		arr = new ArrayList<>();
		for (int i = 0; i < n + 1; i++) {
			arr.add(new ArrayList<Integer>());
		}
		q = new LinkedList<>();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr.get(a).add(b);
			arr.get(b).add(a);
		}
		for (int i = 1; i < n + 1; i++) {
			Collections.sort(arr.get(i));
		}
		dfs(v);
		sb.append('\n');
		visit = new boolean[n + 1];
		bfs(v);
		System.out.println(sb);

	}

	static void dfs(int v) {
		visit[v] = true;
		sb.append(v).append(' ');
		for (int y : arr.get(v)) {
			if (!visit[y]) {
				dfs(y);
			}
		}
	}

	static void bfs(int v) {
		q.offer(v);
		visit[v] = true;
		while (!q.isEmpty()) {
			int a = q.poll();
			sb.append(a).append(' ');
			for (int y : arr.get(a)) {
				if (!visit[y]) {
					visit[y] = true;
					q.offer(y);
				}
			}
		}
	}

}

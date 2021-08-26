package heightcompare;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class main {
	static boolean[] visit;
	static int cnt;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		ArrayList<ArrayList<Integer>> up = new ArrayList<>();
		ArrayList<ArrayList<Integer>> down = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			up.add(new ArrayList<Integer>());
			down.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			up.get(a).add(b);
			down.get(b).add(a);
		}
		int ans = 0;

		for (int i = 1; i <= n; i++) {
			visit = new boolean[n + 1];
			cnt = 0;
			dfs(i, up);
			dfs(i, down);
			if (cnt == n)
				ans++;

		}
		System.out.println(ans);

	}

	static void dfs(int i, ArrayList<ArrayList<Integer>> arr) {
		if (visit[i] == false) {
			cnt++;
		}
		visit[i] = true;
		for (int y : arr.get(i)) {
			if (!visit[y]) {
				dfs(y, arr);
			}
		}
	}

}

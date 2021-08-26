package childishfight;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class main {
	static boolean[] visit;
	static ArrayList<ArrayList<Integer>> same,diff;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		same = new ArrayList<>();
		diff = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			same.add(new ArrayList<Integer>());
			diff.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			char c = st.nextToken().charAt(0);
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(c=='S') {
				same.get(a).add(b);
				same.get(b).add(a);
			}else {
				diff.get(a).add(b);
				diff.get(b).add(a);
			}
		}
		int cnt=0;
		visit = new boolean[n+1];
		for (int i = 1; i <= n; i++) {
			if(visit[i])continue;
			cnt++;
			dfs(i);
		}
		
		System.out.print(Integer.toBinaryString((int)Math.pow(2, cnt)));
		
	}
	static void dfs(int i) {
		if(visit[i]) {
			return;
		}
		visit[i] = true;
		for(int y:same.get(i)) {
			if(!visit[y]) {
				dfs(y);
			}
		}
		for(int y:diff.get(i)) {
			if(!visit[y]) {
				dfs(y);
			}
		}
		
	}
}

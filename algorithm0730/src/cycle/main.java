package cycle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class main {
	static int[] visited;
	static int n,p,ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		p = Integer.parseInt(st.nextToken());
		visited = new int[1001];
		ans = 0;
		dfs(n,1);
		System.out.println(ans);
	}
	static void dfs(int x,int round) {
		if(visited[x]==0) {
			visited[x]=round;
			dfs((x*n)%p,round+1);
		}else {
			ans = round -visited[x];
		}
	}

}

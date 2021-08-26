package cheeze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class main {
	static int n,m,cheese;
	static int[][] map,visited;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visited = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==1) cheese++;
			}
		}
		int ans=0;
		while(cheese>0) {
			ans++;
			visited = new int[n][m];
			dfs(0,0);
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if(map[i][j]==1&&visited[i][j]>1) {
						map[i][j]=0;
						cheese--;
					}
				}
			}
		}
		System.out.println(ans);
	}
	static void dfs(int x, int y) {
		visited[x][y] = -1;
		for (int k = 0; k < 4; k++) {
			int nx = x+dx[k];
			int ny = y+dy[k];
			if(nx<0||nx>=n||ny<0||ny>=m) {
				continue;
			}
			if(map[nx][ny]==1) {
				visited[nx][ny]++;
			}else if(map[nx][ny]==0&&visited[nx][ny]==0) {
				dfs(nx,ny);
			}
			
			
		}
	}

}

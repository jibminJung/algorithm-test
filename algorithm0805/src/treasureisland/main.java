package treasureisland;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class main {
	static int n, m;
	static int max = Integer.MIN_VALUE;
	static char[][] map;
	static int[][] count;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static Queue<Integer[]> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(map[i][j]=='W') continue;
				bfs(i,j);
			}
		}
		System.out.println(max-1);

	}

	static void bfs(int startx, int starty) {// (x,y)에서 시작하는 bfs
		count = new int[n][m];
		q.offer(new Integer[] { startx, starty });
		count[startx][starty] = 1;
		while (!q.isEmpty()) {
			Integer[] temp = q.poll();
			int x = temp[0];
			int y = temp[1];
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx<0||nx>=n||ny<0||ny>=m) {
					continue;
				}
				if(map[nx][ny]=='L'&&count[nx][ny]==0) {
					q.offer(new Integer[] {nx,ny});
					count[nx][ny] = count[x][y]+1;
					if(count[nx][ny]>max) max = count[nx][ny];
				}
			}
		}
	}

}

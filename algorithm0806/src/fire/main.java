package fire;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class main {
	static int n, m, sx, sy;
	static StringTokenizer st;
	static char[][] map;
	static int[][] firedist, dist;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		while (tc-- > 0) {
			st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			map = new char[n][m];
			firedist = new int[n][m];
			dist = new int[n][m];
			for (int i = 0; i < n; i++) {
				map[i] = br.readLine().toCharArray();
			}
			Queue<Integer[]> q = new LinkedList<>();
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (map[i][j] == '@') {
						sx = i;
						sy = j;
						map[i][j] = '.';
					} else if (map[i][j] == '*') {
						q.offer(new Integer[] { i, j });
						firedist[i][j] = 1;
						map[i][j] = '.';
					}
				}
			}
			while (!q.isEmpty()) {
				Integer[] temp = q.poll();
				int x = temp[0];
				int y = temp[1];
				for (int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
						continue;
					}
					if (map[nx][ny] == '.' && firedist[nx][ny] == 0) {
						q.offer(new Integer[] { nx, ny });
						firedist[nx][ny] = firedist[x][y] + 1;
					}

				}
			}

			q.offer(new Integer[] { sx, sy });
			dist[sx][sy] = 1;
			int ans = Integer.MAX_VALUE;
			boolean flag=false;
			while (!q.isEmpty()) {
				Integer[] temp = q.poll();
				int x = temp[0];
				int y = temp[1];
				for (int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
						ans = Math.min(ans, dist[x][y] + 1);
						flag = true;
						continue;
					}
					if (map[nx][ny] == '.' && dist[nx][ny] == 0
							&& (firedist[nx][ny] == 0 || firedist[nx][ny] > dist[x][y] + 1)) {
						q.offer(new Integer[] { nx, ny });
						dist[nx][ny] = dist[x][y] + 1;
					}

				}
			}
			System.out.println(flag?ans-1:"IMPOSSIBLE");
		}
	}
}

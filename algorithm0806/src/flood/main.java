package flood;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class main {
	static int[][] waterDist;
	static char[][] map;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		map = new char[r][c];
		waterDist = new int[r][c];

		Integer[] start= {};
		Integer[] end= {};

		for (int i = 0; i < r; i++) {
			map[i] = br.readLine().toCharArray();
		}
		Queue<Integer[]> q = new LinkedList<>();
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (map[i][j] == '*') {
					q.offer(new Integer[] { i, j });
					waterDist[i][j] = 1;
				} else if (map[i][j] == 'S') {
					start = new Integer[] { i, j };
				} else if (map[i][j] == 'D') {
					end = new Integer[] { i, j };

				}

			}
		}
		while (!q.isEmpty()) {//물부터의 거리
			Integer[] t = q.poll();
			int tx = t[0];
			int ty = t[1];
			for (int k = 0; k < 4; k++) {
				int ntx = tx + dx[k];
				int nty = ty + dy[k];
				if (ntx < 0 || ntx >= r || nty < 0 || nty >= c) {
					continue;
				}
				if (waterDist[ntx][nty] == 0 && map[ntx][nty] != 'X') {
					q.offer(new Integer[] { ntx, nty });
					waterDist[ntx][nty] = waterDist[tx][ty]+1;
				}
			}
		}
		int[][] wDist = new int[r][c];
		//start부터 시작
		q.offer(start);
		wDist[start[0]][start[1]] = 1;
		while (!q.isEmpty()) {//물부터의 거리
			Integer[] t = q.poll();
			int tx = t[0];
			int ty = t[1];
			for (int k = 0; k < 4; k++) {
				int ntx = tx + dx[k];
				int nty = ty + dy[k];
				if (ntx < 0 || ntx >= r || nty < 0 || nty >= c) {
					continue;
				}
				if (wDist[ntx][nty] == 0 && map[ntx][nty] != 'X'&&(waterDist[ntx][nty]==0||waterDist[ntx][nty]>wDist[tx][ty]+1)) {
					q.offer(new Integer[] { ntx, nty });
					wDist[ntx][nty] = wDist[tx][ty]+1;
				}
			}
		}
		int ans = wDist[end[0]][end[1]];
		System.out.println(ans==0?"KAKTUS":ans-1);
		

	}

}

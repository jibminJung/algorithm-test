package maze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class main {
	static Integer[] start = {}, dyna = {}, goal = {};
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	static int n, m;
	static char[][] map;
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
				if (map[i][j] == 'S') {
					start = new Integer[] { i, j };
				} else if (map[i][j] == 'D') {
					dyna = new Integer[] { i, j };
				} else if (map[i][j] == 'G') {
					goal = new Integer[] { i, j };
				}
			}
		}
		// s에서 바로 g로 가는 경우
		int[][] startDist = getDistArray(start);
		// s에서 g까지 바로
		int stog = startDist[goal[0]][goal[1]];

		// d에 들렀다가 가는 경우, s부터 d의 거리 + d부터 g까지 벽을 꺠고 가는 거리
		int stod = startDist[dyna[0]][dyna[1]]; // s에서 d로 가는 거리

		// d부터 출발
		int[][] dynaDist = getDistArray(dyna);

		// g부터 출발
		int[][] goalDist = getDistArray(goal);

		int dtog = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (dynaDist[i][j] == 0 || goalDist[i][j] == 0) {
					continue;
				}
				int temp = dynaDist[i][j] + goalDist[i][j] - 1;
				dtog = Math.min(dtog, temp);
			}
		}
		int ans = 0;

		if (stog==0 &&stod == 0) {
			ans = -1;
		} else if(stog!=0 &&stod==0){
			ans = stog-1;
		}else if(stog==0 && stod!=0) {
			if(dtog==Integer.MAX_VALUE) {
				ans = -1;
			}else {
				ans = stod+dtog-2;
			}
		}else {
			if(dtog==Integer.MAX_VALUE) {
				ans = stog-1;
			}else {
				ans = Math.min(stog-1,stod+dtog-2);
			}
		}
		System.out.println(ans);

	}

	static int[][] getDistArray(Integer[] startPoint) {
		int[][] dist = new int[n][m];
		q.offer(startPoint);
		dist[startPoint[0]][startPoint[1]] = 1;
		while (!q.isEmpty()) {
			Integer[] t = q.poll();
			int tx = t[0];
			int ty = t[1];
			for (int k = 0; k < 4; k++) {
				int ntx = tx + dx[k];
				int nty = ty + dy[k];
				if (ntx < 0 || ntx >= n || nty < 0 || nty >= m) {
					continue;
				}
				if (dist[ntx][nty] == 0) {
					dist[ntx][nty] = dist[tx][ty] + 1;
					if (map[ntx][nty] != '#') {
						q.offer(new Integer[] { ntx, nty });
					}
				}
			}
		}
		return dist;
	}
}

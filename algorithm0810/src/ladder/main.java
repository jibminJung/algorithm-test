package ladder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class main {
	static int n, m;
	static int[][] arr;
	static boolean[][] visit;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		visit = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int l = 0;
		int r = 1000000000;
		while (l < r) {
			int mid = (l + r) / 2;
			if (bfs(mid)) {
				r = mid;
			} else {
				l = mid+1;
			}
		}
		System.out.println(l);
	}

	static boolean bfs(int x) {
		Queue<Integer[]> q = new LinkedList<>();
		visit = new boolean[n][m];
		q.offer(new Integer[] {0,0});
		visit[0][0] =true;
		while(!q.isEmpty()) {
			Integer[] temp = q.poll();
			int tx = temp[0];
			int ty = temp[1];
			for (int i = 0; i < 4; i++) {
				int ntx = tx+dx[i];
				int nty = ty+dy[i];
				if(ntx<0||ntx>=n||nty<0||nty>=m) {
					continue;
				}
				if(!visit[ntx][nty]&&(arr[ntx][nty]-arr[tx][ty]<=x)) {
					q.offer(new Integer[] {ntx,nty});
					visit[ntx][nty] = true;
				}
			}
		}
		
		return visit[n-1][m-1];
	}
}

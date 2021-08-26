package wallbreak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class main {
	static int[][] map, dist1, dist2;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		map = new int[n + 1][m + 1];
		dist1 = new int[n + 1][m + 1];
		dist2 = new int[n + 1][m + 1];

		for (int i = 1; i <= n; i++) {
			String input = br.readLine();
			for (int j = 1; j <= m; j++) {
				map[i][j] = (int)(input.charAt(j - 1) - '0');
			}
		}

		Queue<Integer[]> q = new LinkedList<>();
		q.offer(new Integer[] { 1, 1 });
		dist1[1][1] = 1;
		while (!q.isEmpty()) {
			Integer[] t = q.poll();
			int tx = t[0], ty = t[1];
			for (int i = 0; i < 4; i++) {
				int ntx = tx+dx[i];
				int nty = ty+dy[i];
				if(ntx<1||ntx>n||nty<1||nty>m) {
					continue;
				}
				if(dist1[ntx][nty]==0) {
					dist1[ntx][nty] = dist1[tx][ty]+1;
					if(map[ntx][nty]==0) {
						q.offer(new Integer[] {ntx,nty});
					}
				}
			}
		}
		q.offer(new Integer[] { n, m });
		dist2[n][m] = 1;
		while (!q.isEmpty()) {
			Integer[] t = q.poll();
			int tx = t[0], ty = t[1];
			for (int i = 0; i < 4; i++) {
				int ntx = tx+dx[i];
				int nty = ty+dy[i];
				if(ntx<1||ntx>n||nty<1||nty>m) {
					continue;
				}
				if(dist2[ntx][nty]==0) {
					dist2[ntx][nty] = dist2[tx][ty]+1;
					if(map[ntx][nty]==0) {
						q.offer(new Integer[] {ntx,nty});
					}
				}
			}
		}
		int ans = Integer.MAX_VALUE;
		for (int i =1; i <=n; i++) {
			for (int j = 1; j <=m; j++) {
				if(dist1[i][j]==0||dist2[i][j]==0) continue;
				int temp = dist1[i][j] + dist2[i][j] -1;
				ans = Math.min(ans, temp);
				
			}
			
		}
		
		if(ans==Integer.MAX_VALUE) ans=-1;
		System.out.println(ans);

	}

}

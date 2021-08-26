package tomato;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class main {
	static int[] dx = {0,-1,0,1};
	static int[] dy = {1,0,-1,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n= Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][m];
		int[][] count = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		Queue<Integer[]> q = new LinkedList<>();
		for (int i = 0; i <n; i++) {
			for (int j = 0; j <m; j++) {
				if(map[i][j]==1) {
					q.offer(new Integer[] {i,j});
					count[i][j] = 1;
				}
			}
		}
		int lastx=0;
		int lasty=0;
		while(!q.isEmpty()) {
			Integer[] t = q.poll();
			int tx = t[0];
			int ty = t[1];
			for (int i = 0; i < 4; i++) {
				int ntx = tx+dx[i];
				int nty = ty+dy[i];
				if(ntx<0||ntx>=n||nty<0||nty>=m) {
					continue;
				}
				if(count[ntx][nty]==0&&map[ntx][nty]==0) {
					count[ntx][nty]=count[tx][ty]+1;
					q.offer(new Integer[] {ntx,nty});
					lastx = ntx;
					lasty = nty;
				}
			}
		}
		boolean flag =false;
		for (int i = 0; i <n; i++) {
			for (int j = 0; j <m; j++) {
				if(map[i][j]==0&&count[i][j]==0) {
					flag =true;
					break;
				}
			}
		}
		System.out.println(flag?-1:count[lastx][lasty]-1);
	}
}

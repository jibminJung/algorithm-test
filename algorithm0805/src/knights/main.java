package knights;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class main {
	static StringTokenizer st;
	static int[] dx = {2,2,-2,-2,1,1,-1,-1};
	static int[] dy = {1,-1,1,-1,2,-2,2,-2};
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		while (tc--> 0) {
			int l = Integer.parseInt(br.readLine());
			int[][] map = new int[l][l];
			Integer[] start, end;
			st = new StringTokenizer(br.readLine());
			start = new Integer[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
			st = new StringTokenizer(br.readLine());
			end = new Integer[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
			Queue<Integer[]> q = new LinkedList<>();
			q.offer(start);
			map[start[0]][start[1]] = 1;
			while(!q.isEmpty()) {
				Integer[] t = q.poll();
				int tx = t[0];
				int ty = t[1];
				if(tx==end[0]&&ty==end[1]) break;
				for (int i = 0; i < 8; i++) {
					int ntx = tx + dx[i];
					int nty = ty + dy[i];
					if(ntx<0||ntx>=l||nty<0||nty>=l) {
						continue;
					}
					if(map[ntx][nty]==0) {
						map[ntx][nty] = map[tx][ty]+1;
						q.offer(new Integer[] {ntx,nty});
					}
				}
			}
			sb.append(map[end[0]][end[1]]-1).append('\n');
		}
		System.out.println(sb);
	}

}

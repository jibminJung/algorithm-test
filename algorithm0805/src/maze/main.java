package maze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class main {
	static int[][] arr;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		arr= new int[n+1][m+1];
		Queue<Integer[]> q = new LinkedList<>();
		int[][] dist = new int[n+1][m+1];
		for (int i = 0; i < n; i++) {
			String[] input = br.readLine().split("");
			for (int j = 0; j < m; j++) {
				arr[i+1][j+1] = Integer.parseInt(input[j]);
			}
		}
		q.offer(new Integer[] {1,1});
		dist[1][1] = 1;
		while(!q.isEmpty()) {
			Integer[] temp = q.poll();
			int x = temp[0];
			int y = temp[1];
			for (int i = 0; i < 4; i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(nx<1||nx>n||ny<1||ny>m) {
					continue;
				}
				if(arr[nx][ny]==1&&dist[nx][ny]==0) {
					dist[nx][ny] = dist[x][y] +1;
					q.offer(new Integer[] {nx,ny});
				}
			}
		}
		System.out.println(dist[n][m]!=0?dist[n][m]:-1);
		
		
	}

}

package loadrestriction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class main {
	static int n, m,start,end;
	static int[][] arr;
	static boolean[] visit;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n+1][n+1];
		visit = new boolean[n+1];
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int loadable = Integer.parseInt(st.nextToken());
			arr[a][b] = Math.max(arr[a][b], loadable);
			arr[b][a] = Math.max(arr[b][a], loadable);
		}
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());

		int l = 0;
		int r = 1000000000;
		while (l < r) {
			int mid = (l + r+1) / 2;
			if (bfs(mid)) {
				l = mid;
			} else {
				r=mid-1;
			}
		}
		System.out.println(l);
	}

	static boolean bfs(int x) {
		Queue<Integer> q = new LinkedList<>();
		visit = new boolean[n+1];
		q.offer(start);
		visit[start] =true;
		while(!q.isEmpty()) {
			int temp = q.poll();
			for (int i = 1; i < arr[temp].length; i++) {
				if(arr[temp][i]==0)continue;
				
				if(!visit[i]&&arr[temp][i]>=x) {
					q.offer(i);
					visit[i] = true;
				}
			}
		}
		
		return visit[end];
	}
}

package eobuba;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a, b, p, n, m;
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		p = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
		for (int i = 0; i < n + 1; i++) {
			arr.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			arr.get(n1).add(n2);
			arr.get(n2).add(n1);
		}
		Queue<Integer> q;
		int[] startPoint = new int[] { 1, 2, n };
		int[][] dist = new int[n + 1][3];
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			q = new LinkedList<>();
			int start = startPoint[i];
			dist[start][i] = 1;
			q.offer(start);
			while (!q.isEmpty()) {
				int x = q.poll();
				for (int y : arr.get(x)) {
					if (dist[y][i] == 0) {
						dist[y][i] = dist[x][i] + 1;
						q.offer(y);
					}
				}
			}
		}
		for (int i = 1; i < dist.length; i++) {
			if (dist[i][0] == 0 || dist[i][1] == 0 || dist[i][2] == 0) {
				continue;
			}
			int temp = (dist[i][0]-1) * a + (dist[i][1]-1) * b + (dist[i][2]-1) * p;
			if(ans>temp) ans =temp;
		}

		System.out.println(ans);
	}
	

}

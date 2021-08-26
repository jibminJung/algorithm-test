package chonsu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class main {
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
		int[] count = new int[n+1];
		for (int i = 0; i < n + 1; i++) {
			arr.add(new ArrayList<Integer>());
		}
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr.get(a).add(b);
			arr.get(b).add(a);
		}
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		count[start] = 1;
		while(!q.isEmpty()) {
			int x = q.poll();
			if(x==end) break;
			for(int y:arr.get(x)) {
				if(count[y]==0) {
					q.offer(y);
					count[y] = count[x] +1;
				}
			}
		}
		System.out.println(count[end]-1);
		
	}

}

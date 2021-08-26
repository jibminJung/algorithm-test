package josephus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		Queue<Integer> q = new LinkedList<Integer>();
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			q.offer(i);
		}
		while(!q.isEmpty()) {
			for (int i = 0; i <m-1; i++) {
				q.offer(q.poll());
			}
			sb.append(q.poll()).append(" ");
			
		}
		System.out.println(sb);
	}

}

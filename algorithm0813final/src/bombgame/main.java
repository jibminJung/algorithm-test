package bombgame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int k = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		int timeLimit = 210;
		Queue<Integer> q = new LinkedList<>();
		for (int i = k; i <= 8; i++) {
			q.offer(i);
		}
		for (int i = 1; i < k; i++) {
			q.offer(i);
		}
		while (n-- > 0) {
			st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			char z = st.nextToken().charAt(0);
			if(timeLimit-time<=0) {
				break;
			}
			timeLimit -= time;
			if (z == 'T') {
				int e = q.poll();
				q.offer(e);
			}

		}
		System.out.println(q.poll());

	}

}

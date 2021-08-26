package portal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int from = Integer.parseInt(st.nextToken());
		int to = Integer.parseInt(st.nextToken());
		Queue<Integer> q = new LinkedList<>();
		Integer[] count = new Integer[200001];
		q.offer(from);
		count[from] = 0;
		while (!q.isEmpty()) {
			int a = q.poll();
			if(a==to)break;
			if (2*a<200000&&count[2 * a] == null) {
				count[2 * a] = count[a] + 1;
				q.offer(2*a);
			}
			if (a+1<200000&&count[a+1] == null) {
				count[a+1] = count[a] + 1;
				q.offer(a+1);
			}
			if (a-1>=0&&count[a-1] == null) {
				count[a-1] = count[a] + 1;
				q.offer(a-1);
			}
		}
		System.out.println(count[to]);

	}
}

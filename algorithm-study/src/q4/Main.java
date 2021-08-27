package q4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());

		while (tc-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int doc = Integer.parseInt(st.nextToken());
			int ti = Integer.parseInt(st.nextToken());

			Queue<Integer> q = new LinkedList<>();

			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < doc; i++) {
				q.add(Integer.parseInt(st.nextToken()));
			}
			int max = maxq(q);
			while (true) {
				if (q.peek() == max) {
					if (ti == 0) {
						System.out.println(doc - q.size() + 1);
						break;
					} else {
						q.poll();
						max = maxq(q);
						ti--;
					}
				} else {
					if (ti == 0) {
						q.add(q.poll());
						ti = q.size() - 1;
					} else {
						q.add(q.poll());
						ti--;
					}
				}
			}
		}

	}

	static int maxq(Queue<Integer> q) {
		int max = 0;
		for (int i = 0; i < q.size(); i++) {
			int temp = q.poll();
			if (temp > max)
				max = temp;
			q.offer(temp);
		}
		return max;
	}

}

package pq1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>(new absComp());
		StringBuilder sb = new StringBuilder();
		while (n-- > 0) {
			int order = Integer.parseInt(br.readLine());
			if (order == 0) {
				Integer temp = pq.poll();
				if (temp == null) {
					sb.append("0").append('\n');
				} else {
					sb.append(temp).append('\n');
				}
			} else {
				pq.offer(order);
			}

		}
		System.out.println(sb);
	}

	static class absComp implements Comparator<Integer> {

		@Override
		public int compare(Integer o1, Integer o2) {
			Integer o1Abs = Math.abs(o1);
			Integer o2Abs = Math.abs(o2);
			if (o1Abs == o2Abs) {
				return o1 - o2;

			}
			return o1Abs - o2Abs;

		}

	}

}

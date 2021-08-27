package dq2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		LinkedList<Integer> dq = new LinkedList<>();

		for (int i = 1; i <= n; i++) {
			dq.offer(i);
		}

		int[] target = new int[k];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < k; i++) {
			target[i] = Integer.parseInt(st.nextToken());
		}

		int count = 0;
		for (int i = 0; i < target.length; i++) {
			int target_index = dq.indexOf(target[i]);
			int half_index;

			if (dq.size() % 2 == 0) {
				half_index = dq.size() / 2 - 1;
			}else {
				half_index = dq.size() /2;
			}

			if (target_index <= half_index) {
				for (int j = 0; j < target_index; j++) {
					dq.offer(dq.pollFirst());
					count++;
				}
			} else {
				for (int j = 0; j < dq.size() - target_index; j++) {
					dq.addFirst(dq.pollLast());
					count++;
				}
			}
			dq.pollFirst();

		}
		System.out.println(count);

	}

}

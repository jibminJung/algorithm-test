package dq3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int tc = Integer.parseInt(br.readLine());
		while (tc-- > 0) {
			StringBuilder sb = new StringBuilder();
			
			String orders = br.readLine();
			int numbers = Integer.parseInt(br.readLine());
			LinkedList<Integer> dq = new LinkedList<>();
			st = new StringTokenizer(br.readLine(),"[],");

			for (int i = 0; i < numbers; i++) {
				dq.offer(Integer.parseInt(st.nextToken()));
			}
			boolean reversed = false;
			boolean error = false;
			for (char c : orders.toCharArray()) {
				if (c == 'R') {
					reversed = !reversed;
				} else {
					if (!reversed) {
						if (dq.pollFirst() == null) {
							error = true;
							break;
						}
					} else {
						if (dq.pollLast() == null) {
							error = true;
							break;
						}
					}
				}
			}
			if (error) {
				System.out.println("error");
			} else {
				sb.append("[");
				if (dq.size() > 0) {
					if (reversed) {
						sb.append(dq.pollLast());
						while(!dq.isEmpty()) {
							sb.append(",").append(dq.pollLast());
						}

					} else {
						sb.append(dq.pollFirst());
						while(!dq.isEmpty()) {
							sb.append(",").append(dq.pollFirst());
						}

					}
				}
				sb.append("]");
				System.out.println(sb);

			}

		}

	}

}

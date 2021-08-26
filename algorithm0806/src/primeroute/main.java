package primeroute;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class main {
	static int from, to;
	static int[] prime;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		prime = new int[10000];
		for (int i = 2; i < 100; i++) {
			if (prime[i]==1) {
				continue;
			}
			for (int j = 2 * i; j <prime.length; j += i) {
				prime[j] = 1;
			}
		}

		int tc = Integer.parseInt(br.readLine());
		while (tc-- > 0) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			int[] count = new int[10000];
			Queue<Integer> q = new LinkedList<>();
			q.offer(from);
			count[from] = 1;
			while (!q.isEmpty()) {
				int x = q.poll();
				for (int y : getList(x)) {
					if (count[y] == 0) {
						count[y] = count[x] + 1;
						q.offer(y);
					}
				}
			}
			if(count[to]==0) {
				sb.append("Impossible").append('\n');
			}else {
				sb.append(count[to]-1).append('\n');
			}

		}
		System.out.println(sb);
	}

	static ArrayList<Integer> getList(int x) {
		ArrayList<Integer> arr = new ArrayList<>();
		for (int i = 1; i < 10; i++) {
			int temp = (x % 1000) + i * 1000;
			if (prime[temp]==0 && temp != x)
				arr.add(temp);
		}
		for (int i = 0; i < 10; i++) {
			int temp = ((x / 1000) * 1000) + (x % 100) + (i * 100);
			if (prime[temp]==0 && temp != x)
				arr.add(temp);
		}
		for (int i = 0; i < 10; i++) {
			int temp = ((x / 100) * 100) + (x % 10) + (i * 10);
			if (prime[temp]==0 && temp != x)
				arr.add(temp);
		}
		for (int i = 0; i < 10; i++) {
			int temp = ((x / 10) * 10) + i;
			if (prime[temp]==0 && temp != x)
				arr.add(temp);
		}

		return arr;

	}
}

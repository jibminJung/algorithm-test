package q3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		Queue<Integer> q = new LinkedList<>();
		
		for (int i = 1; i <= n; i++) {
			q.offer(i);
		}
		
		System.out.print("<");
		while(!(q.size()==1)) {
			for (int i = 1; i < k; i++) {
				q.offer(q.poll());
			}
			System.out.print(q.poll()+", ");
		}
		System.out.print(q.poll() + ">");
	}

}

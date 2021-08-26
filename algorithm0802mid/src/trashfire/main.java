package trashfire;

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
		int n = Integer.parseInt(st.nextToken());
		int len = Integer.parseInt(st.nextToken());
		int sum = 0;
		long burn = 0;
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i <n; i++) {
			int input = Integer.parseInt(br.readLine());
			q.offer(input);
			sum = sum+ input;
			while(sum>=len+q.peek()) {
				int temp = q.poll();
				sum -=temp;
				burn += temp;
			}
		}
		System.out.println(burn);
	}

}

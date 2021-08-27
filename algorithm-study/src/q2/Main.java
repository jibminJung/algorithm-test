package q2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= n; i++) {
			q.add(i);
		}
		while(true) {
			int temp = q.poll();
			Integer next = q.poll();
			if(next!=null) {
				q.offer(next);
			}else {
				System.out.println(temp);
				break;
			}
		}
		
	}
	

}

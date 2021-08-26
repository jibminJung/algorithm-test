package minheap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class main {

	public static void main(String[] args) throws IOException{
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		while(n-->0) {
			int a = Integer.parseInt(br.readLine());
			if(a==0) {
				if(pq.isEmpty()) {
					sb.append(0).append('\n');
				}else {
					sb.append(pq.poll()).append('\n');
				}
			}else {
				pq.offer(a);
			}
			
		}
		System.out.println(sb);
	}

}

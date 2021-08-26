package filemerge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> arr = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			arr.offer(Integer.parseInt(br.readLine()));
		}
		int ans = 0;
		while(arr.size()>1) {
			int a = arr.poll();
			int b= arr.poll();
			ans += a+b;
			arr.offer(a+b);
		}
		
		System.out.println(ans);
	}

}

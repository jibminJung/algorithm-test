package classroomassgin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		ArrayList<Integer[]> arr = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			arr.add(new Integer[] {start,end});
		}
		Collections.sort(arr,new Comparator<Integer[]>() {

			@Override
			public int compare(Integer[] o1, Integer[] o2) {
				return o1[0].compareTo(o2[0]);
			}
				
		});
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			Integer[] tmp = arr.get(i);
			if(pq.isEmpty()||pq.peek()>tmp[0]) {
				pq.offer(tmp[1]);
			}else {
				pq.poll();
				pq.offer(tmp[1]);
			}
		}
		System.out.println(pq.size());
		
	}

}

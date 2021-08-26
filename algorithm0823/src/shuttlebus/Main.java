package shuttlebus;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	static int n, t, m;
	static String[] timetable= {"09:00", "09:00", "09:00", "09:00"};
	static int answer;

	public static void main(String[] args) {
		Queue<Integer> bus = new LinkedList<>();
		PriorityQueue<Integer> crew = new PriorityQueue<>();
		
		n=2;t=1;m=2;//test case
		
		for (String s : timetable) {
			crew.offer(str2int(s));
		}
		for (int i = 0; i < n; i++) {
			bus.offer(540 + i * t);
		}
		while (bus.size() > 1 && crew.size() != 0) {
			int ride = 0;
			int busTime = bus.peek();
			while(crew.peek()<=busTime&&ride<m) {
				crew.poll();
				ride++;
			}
			bus.poll();
		}
		if (crew.size() >= m) {
			for (int i = 0; i < m; i++) {
				answer = crew.poll() - 1;
			}
			answer = Math.min(answer, bus.peek());
		} else {
			answer = bus.peek();
		}
		
		System.out.println(int2str(answer));

	}

	static int str2int(String x) {
		String[] str = x.split(":");
		int h = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		return h * 60 + m;

	}
	static String int2str(int x) {
		int h = x/60;
		int m = x%60;
		return String.format("%02d:%02d", h,m);
	}
}

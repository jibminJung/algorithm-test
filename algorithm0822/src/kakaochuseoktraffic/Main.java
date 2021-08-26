package kakaochuseoktraffic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
	static String[] lines;

	public static void main(String[] args) {
		ArrayList<Double[]> arr = new ArrayList<>();
		for (String line : lines) {
			arr.add(convert(line));
		}

		Collections.sort(arr, new Comparator<Double[]>() {
			@Override
			public int compare(Double[] o1, Double[] o2) {
				return (int) (o1[0] - o2[0]);
			}
		});

		PriorityQueue<Double[]> pq = new PriorityQueue<Double[]>(new Comparator<Double[]>() {
			@Override
			public int compare(Double[] o1, Double[] o2) {
				return (int) (o1[1] - o2[1]);
			}
		});

		int max = 0;
		for (Double[] f : arr) {
			while (!pq.isEmpty() && f[0] - 1 >= pq.peek()[1]) {
				pq.poll();
			}
			pq.offer(f);
			max = Math.max(max, pq.size());
		}

		Collections.sort(arr, new Comparator<Double[]>() {
			@Override
			public int compare(Double[] o1, Double[] o2) {
				return (int) (o2[1] - o1[1]);
			}
		});
		pq = new PriorityQueue<Double[]>(new Comparator<Double[]>() {
			@Override
			public int compare(Double[] o1, Double[] o2) {
				return (int) (o2[0] - o1[0]);
			}
		});
		for (Double[] f : arr) {
			while (!pq.isEmpty() && f[1] - 1 <= pq.peek()[0]) {
				pq.poll();
			}
			pq.offer(f);
			max = Math.max(max, pq.size());
		}
		

	}

	static Double[] convert(String x) {
		String[] temp = x.split(" ");
		int h = Integer.parseInt(temp[1].substring(0, 2));
		int m = Integer.parseInt(temp[1].substring(3, 5));
		double s = Double.parseDouble(temp[1].substring(6, 12));
		double p = Double.parseDouble(temp[2].replace("s", ""));

		Double[] result = new Double[2];
		result[1] = h * 60 * 60 + m * 60 + s;
		result[0] = result[1] - p + 0.001;
		return result;
	}
}

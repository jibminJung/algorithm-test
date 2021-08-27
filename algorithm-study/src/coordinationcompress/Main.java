package coordinationcompress;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int[] numbers;
	static HashSet<Integer> hs = new HashSet<Integer>();
	static List<Integer> sorted;
	static HashMap<Integer, Integer> hm = new HashMap<>();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		numbers = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int k = Integer.parseInt(st.nextToken());
			numbers[i] = k;
			hs.add(k);
		}
		sorted = new ArrayList<Integer>(hs);
		Collections.sort(sorted);
		for (int i = 0; i < sorted.size(); i++) {
			hm.put(sorted.get(i), i);
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i <n; i++) {
			sb.append(hm.get(numbers[i])).append(' ');
		}
		System.out.print(sb);
		
	}
	

}

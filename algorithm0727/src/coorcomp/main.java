package coorcomp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashSet<Integer> hs = new HashSet<>();
		HashMap<Integer, Integer> hm = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		String[] str = br.readLine().split(" ");
		int[] nums = new int[str.length];
		for (int i = 0; i < str.length; i++) {
			nums[i] = Integer.parseInt(str[i]);
			hs.add(nums[i]);
		}
		ArrayList<Integer> list = new ArrayList<>(hs);
		Collections.sort(list);
		int idx = 0;
		for (int e : list) {
			hm.put(e, idx++);
		}
		for (int i = 0; i < nums.length; i++) {
			sb.append(hm.get(nums[i])).append(" ");
		}
		System.out.println(sb);

	}

}

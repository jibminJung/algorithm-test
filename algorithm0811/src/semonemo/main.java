package semonemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] nums = new int [n+1][n+1];
		for (int i = 1; i < nums.length; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j < i+1; j++) {
				nums[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int ans = Integer.MIN_VALUE;
		for (int i = 1; i < nums.length; i++) {
			for (int j = 1; j < i+1; j++) {
				nums[i][j] = Math.max(nums[i-1][j-1], nums[i-1][j])+nums[i][j];
				ans = Math.max(nums[i][j], ans);
			}
		}
		System.out.println(ans);
	}

}

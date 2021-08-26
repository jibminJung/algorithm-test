package complex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class main {
	static int n;
	static int[][] map;
	static boolean[][] chk;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int cnt =0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		chk = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			String[] in = br.readLine().split("");
			for (int j = 0; j <n; j++) {
				map[i][j]=Integer.parseInt(in[j]);
			}
		}
		
		ArrayList<Integer> arr = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(map[i][j]==1&&chk[i][j]==false) {
					cnt = 0;
					dfs(i,j);
					arr.add(cnt);
				}
			}
		}
		Collections.sort(arr);
		StringBuilder sb = new StringBuilder();
		for (int i:arr) {
			sb.append(i).append('\n');
		}
		System.out.println(arr.size());
		System.out.println(sb);
	}
	static void dfs(int i ,int j) {
		chk[i][j] = true;
		cnt++;
		for (int k = 0; k < 4; k++) {
			int newx = i+dx[k];
			int newy = j+dy[k];
			if(newx<0||newx>=n||newy<0||newy>=n) {
				continue;
			}
			if(chk[newx][newy]==false&&map[newx][newy]==1) {
				dfs(newx,newy);
			}
			
		}
	}

}

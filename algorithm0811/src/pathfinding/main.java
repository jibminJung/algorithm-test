package pathfinding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main {
	static int[][] dt;
	static char[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		map = new char[n + 1][n + 1];
		dt = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			String input = br.readLine();
			for (int j = 1; j <=n; j++) {
				map[i][j] = input.charAt(j-1);
			}
		}
		if (map[1][1] == '.') {
			dt[1][1] = 1;
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == 1 && j == 1) {
					continue;
				}
				dt[i][j] = 0;
				if (map[i][j] == '*') {
					continue;
				}
				dt[i][j] = (dt[i-1][j]+dt[i][j-1])%1000000007;

			}
		}
		System.out.println(dt[n][n]);
	}

}

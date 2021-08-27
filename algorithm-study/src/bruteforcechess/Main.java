package bruteforcechess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean[][] filter = new boolean[8][8];
	static boolean[][] board;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		makeFilter();
		board = new boolean[x][y];
		for (int i = 0; i < x; i++) {
			String line = br.readLine();
			for (int j = 0; j < y; j++) {
				board[i][j] = ((line.charAt(j)=='W') ? true : false);
			}
		}
		int min = 64;
		for (int i = 0; i <= x - 8; i++) {
			for (int j = 0; j <= y - 8; j++) {
				min = Math.min(min, check(i, j));
			}
		}
		System.out.println(min);

	}

	static int check(int x, int y) {
		int count = 0;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (filter[i][j] != board[x + i][y + j])
					count++;
			}
		}
		if (count > 64 - count)
			count = 64 - count;

		return count;
	}

	static void makeFilter() {
		boolean tf = false;
		for (int i = 0; i < filter.length; i++) {
			for (int j = 0; j < filter.length; j++) {
				filter[i][j] = tf;
				tf = !tf;
			}
			tf = !tf;
		}
	}

}

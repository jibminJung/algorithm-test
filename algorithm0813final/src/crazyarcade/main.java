package crazyarcade;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class main {
	static int h, w;
	static int[][] map, bomb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		h = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		map = new int[h + 1][w + 1];
		bomb = new int[h + 1][w + 1];
		for (int i = 1; i <= h; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= w; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		int startx = Integer.parseInt(st.nextToken())+1;
		int starty = Integer.parseInt(st.nextToken())+1;
		
		for (int i = 1; i < map.length; i++) {
			for (int j = 1; j < map[i].length; j++) {
				if (map[i][j] == 0)
					continue;
				for (int k = 1; k < w + 1; k++) {
					if (k >= j - map[i][j] && k <= j + map[i][j]) {
						bomb[i][k] = -1;
					}
				}
				for (int k = 1; k < h + 1; k++) {
					if (k >= i - map[i][j] && k <= i + map[i][j]) {
						bomb[k][j] = -1;
					}
				}
			}
		}
		int ans = Integer.MAX_VALUE;
		for (int i = 1; i < bomb.length; i++) {
			for (int j = 1; j < bomb[i].length; j++) {
				if(bomb[i][j]!=-1) {
					ans = Math.min(Math.abs(i-startx)+Math.abs(j-starty), ans);
				}
			}
		}
		
		System.out.println(ans==Integer.MAX_VALUE?-1:ans);

	}

}

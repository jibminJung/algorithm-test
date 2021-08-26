package sudoku;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class main {
	static StringBuilder sb= new StringBuilder();
	static int[][] map = new int[9][9];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 9; i++) {
			String[] temp = br.readLine().split(" ");
			for (int j = 0; j < 9; j++) {
				map[i][j] = Integer.parseInt(temp[j]);
			}
		}
		dfs(0,0);
		System.out.println("Not Possible");
		
	}
	static void dfs(int x, int y) {
		if(x==9) {
			dfs(0,y+1);
			return;
		}
		if(y==9) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(map[i][j]).append(' ');
				}
				sb.append('\n');
			}
			System.out.println(sb);
			System.exit(0);
		}
		if(map[x][y]!=0) {
			dfs(x+1,y);
			return;
		}
		HashSet<Integer> hs =new HashSet<>();
		for (int i = 0; i < 9; i++) {
			hs.add(map[x][i]);
			hs.add(map[i][y]);
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				hs.add(map[((x/3)*3)+i][((y/3)*3)+j]);
			}
		}
		
		for (int i = 1; i <= 9; i++) {
			if(hs.contains(i)) {
				continue;
			}
			map[x][y] = i;
			dfs(x+1,y);
			map[x][y] = 0;
		}
		
	}
	
}

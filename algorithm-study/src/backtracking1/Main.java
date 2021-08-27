package backtracking1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean[] arr;
	static int[] numbers;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		arr = new boolean[x];
		numbers = new int[y];
		dfs(x,y,0);
		
	}
	static void dfs(int x, int y, int depth) {
		if(depth == y) {
			for (int number : numbers) {
				System.out.print(number + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = 0; i < x; i++) {
			if(!arr[i]) {
				arr[i]=true;
				numbers[depth] = i+1;
				dfs(x,y,depth+1);
				
				arr[i]=false;
			}
		}
		
	}

}

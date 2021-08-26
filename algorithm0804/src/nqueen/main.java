package nqueen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main {
	static int n;
	static int ans =0;
	static int[] arr;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n+1];
		dfs(1);
		System.out.println(ans);
	}
	static void dfs(int x) {
		if(x==n+1) {
			ans++;
			return;
		}
		for (int i = 1; i <=n; i++) {
			boolean pos = true;
			for (int j = 1; j < x; j++) {
				if(i==arr[j]||j-arr[j]==x-i||j+arr[j]==x+i) {
					pos = false;
				}
			}
			if(pos) {
				arr[x]=i;
				dfs(x+1);
				arr[x]=0;
			}
		}
		
		
	}

}

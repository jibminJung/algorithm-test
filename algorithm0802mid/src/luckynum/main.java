package luckynum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class main {
	static int n,cnt;
	static int[] num;
	static String[] numStr;
	static boolean[] visited,used;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		numStr = new String[n];
		num = new int[n];
		visited = new boolean[n];
		used = new boolean[n];
		cnt=0;
		
		for (int i = 0; i < n; i++) {
			numStr[i] = st.nextToken();
			int sumnum = 0;
			for (int j = 0; j < numStr[i].length(); j++) {
				sumnum += numStr[i].charAt(j)-'0';
				
			}
			if(sumnum%3==0) {
				used[i] = true;
				cnt++;
			}
			num[i] = sumnum;
		}
		for (int i = 2; i <= n; i++) {
			dfs(0,0,i);
		}
		System.out.println(cnt);
		
		
	}
	static void dfs(int start, int depth, int r) {
		if(depth==r) {
			int temp =0;
			
			for (int i = 0; i < num.length; i++) {
				if(visited[i]) temp+= num[i];
				if(visited[i]&&used[i]) return;
			}
			if(temp%3==0) {
				cnt++;
				for (int i = 0; i < visited.length; i++) {
					if(visited[i]) used[i] = true;
				}
			}
			return;
		}
		for (int i=start; i<n; i++) {
	        if (visited[i] != true && used[i]!=true) {
	            visited[i] = true;
	            dfs(start+1,depth + 1, r);
	            visited[i] = false;
	        }
	    }
	}
}

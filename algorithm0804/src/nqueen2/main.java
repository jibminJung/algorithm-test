package nqueen2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main {
	static int n;
	static int ans =0;
	static boolean[] ver,diag1,diag2;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		ver = new boolean[n+1];
		diag1 = new boolean[2*n+1];
		diag2= new boolean[2*n+1];
		dfs(1);
		System.out.println(ans);
	}
	static void dfs(int x) {
		if(x==n+1) {
			ans++;
			return;
		}
		for (int i = 1; i <=n; i++) {
			if(ver[i]||diag1[x+i]||diag2[x-i+n]) continue;
			ver[i]=diag1[x+i]=diag2[x-i+n]=true;
			dfs(x+1);
			ver[i]=diag1[x+i]=diag2[x-i+n]=false;
		}
		
		
	}
}

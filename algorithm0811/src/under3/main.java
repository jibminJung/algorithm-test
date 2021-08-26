package under3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main {
	static int[] dt = new int[12];
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		while(tc-->0) {
			int x = Integer.parseInt(br.readLine());
			sb.append(dp(x)).append('\n');
		}
		System.out.println(sb);
		  
		  
	}
	static int dp(int x) {
		if(dt[x]!=0) {
			return dt[x];
		}
		if(x==1||x==2) {
			return dt[x] = x;
		}
		if(x==3) {
			return dt[x] = 4;
		}
		
		return dt[x] = dp(x-1)+dp(x-2)+dp(x-3);
		
	}

}

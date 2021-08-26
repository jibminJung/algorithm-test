package inequal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class main {
	static int n;
	static long max = 0;
	static long min = 9876543210L;
	static char[] sign;
	static int[] number;
	static boolean[] num = new boolean[10];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		sign = new char[n];
		number = new int[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i <n; i++) {
			sign[i] = st.nextToken().charAt(0);
		}
		dfs(0,-1);

		System.out.println(String.format("%0" + (n+1) + "d", max));
		System.out.println(String.format("%0" + (n+1) + "d", min));
	}
	static void dfs(int d,int prev) {
		if(d==n+1) {
			String temp="";
			for (int i = 0; i < number.length; i++) {
				temp += number[i];
			}
			max = Math.max(Long.parseLong(temp), max);
			min = Math.min(Long.parseLong(temp), min);
			return;
		}
		if(d==0) {
			for (int i = 0; i < 10; i++) {
				if(num[i]) continue;
				num[i] = true;
				number[d] = i;
				dfs(d+1,i);
				num[i] = false;
			}
		}else {
			if(sign[d-1]=='<') {
				for (int i = prev+1; i < num.length; i++) {
					if(num[i]) continue;
					num[i] = true;
					number[d] = i;
					dfs(d+1,i);
					num[i] = false;
				}
			}else {
				for (int i = prev-1; i >=0; i--) {
					if(num[i]) continue;
					num[i] = true;
					number[d] = i;
					dfs(d+1,i);
					num[i] = false;
				}
			}
		}
		
	}
	
}

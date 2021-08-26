package makezero;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main {
	static int[] arr;
	static char[] op;
	static int n;
	static char[] ops = {' ','+','-'};
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr= new int[n];
		op = new char[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i+1;
			op[i] = ' ';
		}
		op[n-1]= '=';
		dfs(0);
		
		
		System.out.println(sb);
	}
	
	static void dfs(int d) {
		if(d==n-1) {
			if(calc()==0) {
				for (int i = 0; i < arr.length-1; i++) {
					sb.append(arr[i]).append(op[i]);
				}
				sb.append(arr[n-1]).append('\n');
			}
			return;
		}
		for (int i = 0; i < 3; i++) {
			op[d] = ops[i];
			dfs(d+1);
		}
		
	}
	static int calc() {
		String a = "";
		for (int i = 0; i < arr.length; i++) {
			a= a+String.valueOf(arr[i]);
			a= a+String.valueOf(op[i]);
		}
		a= a.replaceAll(" ", "");
		String temp ="";
		int sum =0;
		for (int i = 0; i < a.length(); i++) {
			char c = a.charAt(i);
			if(c=='+'||c=='-'||c=='=') {
				sum += Integer.parseInt(temp);
				temp=String.valueOf(c);
			}else {
				temp+=c;
			}
		}
		return sum;
	}
}

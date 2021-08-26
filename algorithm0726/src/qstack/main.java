package qstack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class main {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		Stack<Integer> s1 = new Stack<Integer>();
		Stack<Integer> s2 = new Stack<Integer>();
		int m = Integer.parseInt(br.readLine());
		while(m-->0) {
			st= new StringTokenizer(br.readLine());
			if(st.nextToken().equals("a")) {
				int e = Integer.parseInt(st.nextToken());
				s1.push(e);
			}else {
				if(s2.empty()) {
					while(!s1.empty()) {
						int e = s1.pop();
						s2.push(e);
						sb.append(e).append(" ");
					}
					sb.append('\n');
				}else {
					s2.pop();
				}
			}
			
		}
		System.out.println(sb);
	}

}

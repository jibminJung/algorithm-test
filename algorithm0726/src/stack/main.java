package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<Integer>();
		int size = 0;
		while(true) {
			st = new StringTokenizer(br.readLine());
			String o = st.nextToken();
			if(o.equals("push")) {
				int e = Integer.parseInt(st.nextToken());
				sb.append(e).append('\n');
				stack.push(e);
				size++;
			}else if(o.equals("top")) {
				if(size==0) {
					sb.append(-1).append('\n');
				}else {
					Integer e = stack.peek();
					sb.append(e).append('\n');
				}
			}else if(o.equals("pop")) {
				if(size==0) {
					sb.append(-1).append('\n');
				}else {
					sb.append(stack.pop()).append('\n');
					size--;
				}
			}else if(o.equals("size")) {
				sb.append(size).append('\n');
			}else if(o.equals("empty")) {
				boolean empty = stack.empty();
				if(empty) {
					sb.append(1).append('\n');
				}else {
					sb.append(0).append('\n');
				}
			}else {
				break;
			}
		}
		System.out.println(sb);
		
	}

}

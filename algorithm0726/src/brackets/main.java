package brackets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> st = new Stack<Character>();
		boolean flag = true;
		String s = br.readLine();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(c=='(') {
				st.push('(');
			}else {
				if(st.empty()) {
					flag = false;
					break;
				}else {
					char k = st.pop();
					if(k!='(') {
						flag=false;
						break;
					}
				}
			}
		}
		if(st.empty()&&flag) {
			System.out.println(":)");
		}else {
			System.out.println(":(");
		}
		
	}

}

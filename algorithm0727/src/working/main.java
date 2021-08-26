package working;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TreeSet<String> ts = new TreeSet<String>();
		int n = Integer.parseInt(br.readLine());
		while(n-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			String io = st.nextToken();
			if(io.equals("enter")) {
				ts.add(name);
			}else {
				ts.remove(name);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(ts.size()).append('\n');
		for(String name:ts) {
			sb.append(name).append('\n');
		}
		System.out.println(sb);
	}
}

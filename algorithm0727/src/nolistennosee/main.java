package nolistennosee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String,Integer> hm = new HashMap<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		while(n-->0) {
			String name = br.readLine();
			hm.put(name, hm.getOrDefault(name, 0)+1);
		}
		while(m-->0) {
			String name = br.readLine();
			hm.put(name, hm.getOrDefault(name, 0)+1);
		}
		int cnt=0;
		for(String name:hm.keySet()) {
			int i = hm.get(name);
			if(i>1) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}

}

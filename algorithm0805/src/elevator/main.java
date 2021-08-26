package elevator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class main {
	static Integer[] floor;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n, a, b, u, d;
		n = Integer.parseInt(st.nextToken());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		u = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		floor = new Integer[n+1];
		Queue<Integer> q = new LinkedList<>();
		q.offer(a);
		floor[a] = 0;
		while(!q.isEmpty()) {
			int x = q.poll();
			if(x==b)break;
			if(x+u<=n&&floor[x+u]==null) {
				floor[x+u] = floor[x]+1;
				q.offer(x+u);
			}
			if(x-d>0&&floor[x-d]==null) {
				floor[x-d] = floor[x]+1;
				q.offer(x-d);
			}
		}
		System.out.println(floor[b]!=null?floor[b]:"use the stairs");
		
		

	}

}

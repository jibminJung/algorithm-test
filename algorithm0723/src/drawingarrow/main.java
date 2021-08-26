package drawingarrow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class main {
	static int[][] points;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		points = new int[n][2];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			points[i][0] = Integer.parseInt(st.nextToken());
			points[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int ans = 0;
		for (int i = 0; i < n; i++) {//출발점
			int shortDistance = Integer.MAX_VALUE;
			for (int j = 0; j < n; j++) {//목표점
				if(i==j) continue;
				if(points[i][1]==points[j][1]) {
					int dist = Math.abs(points[i][0]-points[j][0]);
					if(dist<shortDistance) shortDistance = dist;
				}
			}
			ans += shortDistance;
		}
		System.out.println(ans);
		
		
	}

}

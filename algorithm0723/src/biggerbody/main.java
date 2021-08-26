package biggerbody;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] size = new int[n][2];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			size[i][0] = Integer.parseInt(st.nextToken());
			size[i][1] = Integer.parseInt(st.nextToken());
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			int bigger = 0;
			for (int j = 0; j < n; j++) {
				if(i==j)continue;
				if(size[i][0]<size[j][0]&&size[i][1]<size[j][1]) {
					bigger++;
				}
			}
			sb.append(bigger+1).append(" ");
		}
		System.out.println(sb);
	}

}

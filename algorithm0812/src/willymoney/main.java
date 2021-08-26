package willymoney;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class main {
	static int[][] arr,dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new int[n+1][3];
		dp =new int[n+1][3];
		
		for (int i = 1; i < arr.length; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
			arr[i][0] = Math.max(arr[i-1][1],arr[i-1][2])+arr[i][0];
			arr[i][1] = Math.max(arr[i-1][2],arr[i-1][0])+arr[i][1];
			arr[i][2] = Math.max(arr[i-1][0],arr[i-1][1])+arr[i][2];
		}
		System.out.println(Math.max(Math.max(arr[n][0], arr[n][1]), arr[n][2]));
		
		
	}

}

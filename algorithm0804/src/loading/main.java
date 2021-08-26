package loading;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class main {

	static int n,c,max,sum;
	static int[] weight;
	static boolean[] selected;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		c = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		weight = new int[n];
		max =0;
		sum=0;
		for (int i = 0; i < n; i++) {
			weight[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(weight);
		dfs(0);
		System.out.println(max);
		
	}
	static void dfs(int index) {
		if(sum>c) {
			return;
		}
		max = Math.max(sum, max);
		for (int i = index; i < weight.length; i++) {
			if(sum+weight[i]>c)break;
			sum+=weight[i];
			dfs(i+1);
			sum-=weight[i];
		}
	}

}

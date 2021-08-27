package bruteforceM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] cards;
	static int max =0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int noc = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		cards = new int[noc];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < noc; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
		for (int x = 0; x < noc; x++) {
			for (int y = 1; y < noc; y++) {
				for (int z = 2; z < noc; z++) {
					if(x==y||y==z||x==z) continue;
					int sum = cards[x]+cards[y]+cards[z];
					if(sum>max&&sum<=m) max = sum;
				}
			}
		}
		System.out.println(max);
		
	}

}

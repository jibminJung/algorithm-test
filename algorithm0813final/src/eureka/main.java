package eureka;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[] tnum = new int[46];
		for (int i = 0; i < tnum.length; i++) {
			tnum[i] = (i*(i+1))/2;
		}
		int tc = Integer.parseInt(br.readLine());
		while(tc-->0) {
			int target = Integer.parseInt(br.readLine());
			boolean flag = false;
			for (int i = 1; i < tnum.length; i++) {
				for (int j = i; j < tnum.length; j++) {
					for (int k = j; k < tnum.length; k++) {
						if(tnum[i]+tnum[j]+tnum[k]==target) {
							flag = true;
							break;
						}
					}
					if(flag)break;
				}
				if(flag)break;
			}
			if(flag) {
				sb.append(1).append('\n');
			}else {
				sb.append(0).append('\n');
			}
		}
		System.out.println(sb);
	}

}

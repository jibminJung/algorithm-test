package dwarf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] dwarfs = new int[9];
		int sum = 0;
		for (int i = 0; i < 9; i++) {
			dwarfs[i] = Integer.parseInt(br.readLine());
			sum += dwarfs[i];
		}
		
		Arrays.sort(dwarfs);
		
		for (int i = 0; i < dwarfs.length-1; i++) {
			for (int j = i+1; j < dwarfs.length; j++) {
				if(sum-(dwarfs[i]+dwarfs[j])==100) {//i³­ÀïÀÌ¿Í j³­ÀïÀÌ¸¦ »« °ÍÀÌ 100ÀÌ¸é
					for (int k = 0; k < dwarfs.length; k++) {
						if(k==i||k==j)continue;
						System.out.println(dwarfs[k]);
					}
				}
			}
		}
		
		
	}
}

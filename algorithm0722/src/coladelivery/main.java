package coladelivery;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int answer = -1;
		for (int i = 0; i*3 <= N; i++) {
			for (int j = 0; j*5 <= N; j++) {
				int box = 0;
				if(N==i*3+j*5) {
					box = i+j;
					if(answer==-1||box<answer) {
						answer = box;
					}
				}
			}
		}
		System.out.println(answer);
		
		
	}

}

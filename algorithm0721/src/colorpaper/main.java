package colorpaper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class main {
	static int[][] papers;
	static boolean[][] drawingPaper = new boolean[100][100];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		papers = new int[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			papers[i][0] = Integer.parseInt(st.nextToken());
			papers[i][1] = Integer.parseInt(st.nextToken());
			for (int j = papers[i][0]; j < papers[i][0]+10; j++) {
				for (int j2 = papers[i][1]; j2 < papers[i][1]+10; j2++) {
					drawingPaper[j][j2] = true;
				}
			}
		}
		int cnt = 0;
		for (int i = 0; i < drawingPaper.length; i++) {
			for (int j = 0; j < drawingPaper.length; j++) {
				if(drawingPaper[i][j]) cnt++;
			}
		}
		System.out.println(cnt);
		
	}

}

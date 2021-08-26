package decalcomani;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class main {

public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		char[][] pic = new char[a][b];
		char[][] bigPic = new char[2*a][2*b];
		
		
		for (int i = 0; i < a; i++) {
			pic[i] = br.readLine().toCharArray();
		}
		
		st = new StringTokenizer(br.readLine());
		int errorx = Integer.parseInt(st.nextToken());
		int errory = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < bigPic.length; i++) {
			for (int j = 0; j < bigPic[i].length; j++) {
				int x,y;
				if(i>=a) {
					x = 2*a-i-1;
				}else {
					x = i;
				}
				if(j>=b) {
					y = 2*b-j-1;
				}else {
					y = j;
				}
				bigPic[i][j] = pic[x][y];
				
			}
		}
		
		if(bigPic[errorx-1][errory-1]=='#') {
			bigPic[errorx-1][errory-1]='.';
		}else {
			bigPic[errorx-1][errory-1]='#';
		}
		
		StringBuilder sb= new StringBuilder();
		for (int i = 0; i < bigPic.length; i++) {
			for (int j = 0; j < bigPic[i].length; j++) {
				sb.append(bigPic[i][j]);
			}
			sb.append('\n');
		}
		
		System.out.println(sb);
	}

}

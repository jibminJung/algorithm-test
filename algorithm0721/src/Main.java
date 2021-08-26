import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static char[][] image;
	static char[][] newImage;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		image = new char[n][m];
		for (int i = 0; i < n; i++) {
			char[] row = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				image[i][j] = row[j];
			}
		}
		
		int zoom = Integer.parseInt(br.readLine());
		newImage = new char[n*zoom][m*zoom];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				for (int x = 0; x < zoom; x++) {
					for (int y = 0; y < zoom; y++) {
						newImage[i*zoom+x][j*zoom+y] = image[i][j];
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < newImage.length; i++) {
			for (int j = 0; j < newImage[0].length; j++) {
				sb.append(newImage[i][j]);
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}

}

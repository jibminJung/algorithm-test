package friends4block;

public class Main {
	static int m, n;
	static String[] board= {"CCBDE", "AAADE", "AAABF", "CCBBF"};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		m=4;
		n=5;
		
		char[][] map = new char[m][n];
		for(int i =0;i<m;i++) {
			for(int j=0;j<n;j++) {
				map[i][j] = board[i].charAt(j);
			}
		}
		char[][] board2 = new char[n][m]; 
		for (int i = 0; i < n; i++) {
			String s = "";
			for (int j = m-1; j >= 0; j--) {
				s = s+map[j][i];
			}
			board2[i]=s.toCharArray();
		}
		
		
		boolean flag = true;
		int cnt =0;
		while(flag) {
			flag = false;
			boolean[][] chk = new boolean[n][m];
			
			for (int line = 0; line < board2.length-1; line++) {
				for(int i=0,j=0;i<board2[line].length-1&&j<board2[line+1].length-1;i++,j++) {
					if(board2[line][i]==' ') continue;
					if(board2[line][i]==board2[line+1][j]&&
							board2[line][i]==board2[line][i+1]&&
							board2[line+1][j]==board2[line+1][j+1]) {
						chk[line][i]=chk[line][i+1]=chk[line+1][j]=chk[line+1][j+1]=true;
						flag=true;
					}
				}
			}
			for (int i = 0; i < chk.length; i++) {
				for (int j = 0; j < chk[i].length; j++) {
					if(chk[i][j]) {
						board2[i][j] = ' ';
						//¹Ù²Ù´Â °¹¼ö ¼¼±â
						cnt++;
					}
				}
			}
			
			
			//map¿¡¼­ º¯°æ ÈÄ ¹ØÀ¸·Î ¶¯°ÜÁÜ
			for (int i = 0; i < board2.length; i++) {
				board2[i] = String.valueOf(board2[i]).replaceAll(" ", "").toCharArray();
			}
			
			
		}
		System.out.println(cnt);
	}

}

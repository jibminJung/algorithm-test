package kakao2020_stringcompression;


public class Main {
	static String s="ababcdcdababcdcd";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int shortest  = s.length();
		
		for (int k = 1; k <= s.length()/2; k++) {
			String ss="";
			int cnt=0;
			int i=0;
			int j=k;
			String temp=s.substring(i,j);
			while(i<s.length()&&j<=s.length()) {
				String current = s.substring(i, j);
				if(temp.equals(current)) {
					cnt++;
				}else {
					ss+=(cnt==1?"":String.valueOf(cnt))+temp;
					temp=current;
					cnt=1;
				}
				i+=k;
				j+=k;
			}
			ss+=(cnt==1?"":String.valueOf(cnt))+temp;
			ss+=s.substring(i);
			shortest = Math.min(shortest, ss.length());
		}
		System.out.println(shortest);
	}

}

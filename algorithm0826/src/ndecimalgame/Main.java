package ndecimalgame;

public class Main {
	public static void main(String[] args) {
		int n=16;
		int t =16;
		int m =2;
		int p =1;
		int turn =0;
		int current=0;
		String answer ="";
		while(t>0) {
			String num = convert(current++,n); 
			for (int i = 0; i < num.length(); i++) {
				if(turn++%m==p-1 && t>0) {
					answer+=num.charAt(i);
					t--;
				}
			}
		}
		System.out.println(answer);
	}
	
	static String convert(int number,int n) {
		if(number==0) return "0";
		StringBuilder sb = new StringBuilder();
		while(number>0) {
			
			sb.append(ten2a(number,n));
			number /=n;
		}
		return sb.reverse().toString();
		
	}
	static String ten2a(int number,int n) {
		int val =number%n;
		if(val<10) {
			return String.valueOf(number%n);
		}else if(val==10) {
			return "A";
		}else if(val==11) {
			return "B";
		}else if(val==12) {
			return "C";
		}else if(val==13) {
			return "D";
		}else if(val==14) {
			return "E";
		}else {
			return "F";
		}
	}
}

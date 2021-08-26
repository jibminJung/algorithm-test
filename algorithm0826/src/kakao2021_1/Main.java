package kakao2021_1;

public class Main {

	public static void main(String[] args) {
		String s="onefivenine";
		String[] strArr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for(int i = 0; i < strArr.length; i++) {
            s = s.replaceAll(strArr[i], Integer.toString(i));
        }
		System.out.println(s);
		
	}

}

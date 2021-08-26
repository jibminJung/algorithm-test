package autocompletion;

import java.util.Arrays;
import java.util.HashMap;

public class Main {
	static String[] words= {"go","gone","guild"};
	static HashMap<Integer,String> hm = new HashMap<>();
	public static void main(String[] args) {
		Arrays.sort(words);
		for (int i = 0; i < words.length; i++) {
			hm.put(i, words[i]);
		}
		int answer =0;
		for (int i = 0; i < words.length; i++) {
			System.out.println(search(i));
			answer += search(i);
		}
		System.out.println(answer);
	}
	static int search(int i) {
		if(i==0) {
			return compare(i,i+1);
		}else if(i==hm.size()-1) {
			return compare(i,i-1);
		}else {
			return Math.max(compare(i,i+1), compare(i,i-1));
		}
	}
	
	static int compare(int i, int j) {
		String str1 = hm.get(i);
		String str2 = hm.get(j);
		int cnt =0;
		for (int k = 0; k < str1.length()&&k<str2.length(); k++) {
			if(str1.charAt(k)==str2.charAt(k)) {
				cnt++;
			}else {
				break;
			}
		}
		
		if(!(cnt==str1.length())) {
			cnt++;
		}
		return cnt;
		
	}

}

package newsclustering;

import java.util.HashMap;

public class Main {
	static String str1, str2;
	public static void main(String[] args) {
		HashMap<String,Integer> hm1 = new HashMap<>();
		HashMap<String,Integer> hm2 = new HashMap<>();
		str1 = "french";
		str2 = "FRANCE";
		for (int i = 0; i < str1.length()-1; i++) {
			String temp = str1.substring(i, i+2);
			temp = temp.toLowerCase();
			if(!temp.matches("[a-zA-Z]*")) {
				continue;
			}
			hm1.put(temp, hm1.getOrDefault(temp, 0)+1);
		}
		for (int i = 0; i < str2.length()-1; i++) {
			String temp = str2.substring(i, i+2);
			temp = temp.toLowerCase();
			if(!temp.matches("[a-zA-Z]*")) {
				continue;
			}
			hm2.put(temp, hm2.getOrDefault(temp, 0)+1);
		}
		
		double inter =0;
		double union =0;
		for(String key:hm1.keySet()) {
			inter += Math.min(hm1.get(key),hm2.getOrDefault(key, 0));
			hm2.put(key, Math.max(hm1.get(key), hm2.getOrDefault(key, 0)));
		}
		for(int i:hm2.values()) {
			union +=i;
		}
		int answer = (int)((inter/union) * 65536);
		System.out.println(answer);
	}

}

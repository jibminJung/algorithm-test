package compression;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
	static String msg="TOBEORNOTTOBEORTOBEORNOT";
	public static void main(String[] args) {
		int idx =1;
		int i=0;
		int j=1;
		ArrayList<Integer> arr = new ArrayList<>();
		HashMap<String,Integer> hm = new HashMap<>();
		for (char k = 'A'; k <= 'Z'; k++) {
			hm.put(String.valueOf(k), idx++);
		}
		while(j<=msg.length()) {
			if(hm.containsKey(msg.substring(i, j))) {
				j++;
			}else {
				hm.put(msg.substring(i, j), idx++);
				arr.add(hm.get(msg.substring(i, j-1)));
				i=j-1;
			}
		}
		arr.add(hm.get(msg.substring(i, j-1)));

		int[] answer = new int[arr.size()];
		int s=0;
		for(int e:arr) {
			answer[s++]=e;
		}
	}

}

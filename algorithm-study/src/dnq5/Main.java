package dnq5;

import java.util.HashMap;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, Integer> hm = new HashMap<String,Integer>();
		hm.put("aa", 1);
		hm.put("bb", 3);
		hm.put("cc", 0);
		hm.put("aa", 5);
		
		System.out.println(hm.size());
	}

}

package cache;

import java.util.HashMap;
import java.util.TreeSet;

public class Main {
	static int cacheSize=2;
	static String[] cities= {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
	
	public static void main(String[] args) {
		int answer =0;
		HashMap<String,Integer> hm = new HashMap<>();
		TreeSet<Integer> ts = new TreeSet<>();
		ts.pollFirst();
		for(int i =0; i<cities.length;i++) {
			String in = cities[i].toLowerCase();
			
			if(hm.containsKey(in)) {//cache hit
				ts.remove(hm.get(in));
				hm.put(in, i);
				ts.add(i);
				answer +=1;
			}else {//cache miss
				hm.put(in, i);
				ts.add(i);
				if(hm.size()>cacheSize) {
					int oldIdx = ts.pollFirst();
					hm.remove(cities[oldIdx].toLowerCase());
				}
				answer+=5;
			}
		}
		System.out.println(answer);
		
	}

}

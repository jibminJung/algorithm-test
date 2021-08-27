package sand2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class gemShopping {
	public static void main(String[] args) {
		String[] gems = { "DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA" };
		System.out.println(solution(gems)[0] + " " + solution(gems)[1]);
	}

	static HashMap<String, Integer> hm = new HashMap<String, Integer>();
	static HashSet<String> hs = new HashSet<String>();
	static Queue<String> q = new LinkedList<String>();
	static int startPoint = 0;
	static int length = Integer.MAX_VALUE;

	public static int[] solution(String[] gems) {
            for(String g : gems){
                hs.add(g);
            }
            
            int start = 0;
            for(int i = 0; i<gems.length;i++){
                String gem = gems[i];
                hm.put(gem, hm.getOrDefault(gem,0)+1);
                q.offer(gem);
                
                while(true){
                    String first = q.peek();
                    if(hm.get(first)>1){
                        q.poll();
                        hm.put(first, hm.get(first)-1);
                        startPoint = startPoint +1;
                    }else{
                        break;
                    }
                }
                if(hm.size()==hs.size() && length>q.size()){
                    length = q.size();
                    start = startPoint;
                }
                
                
            }
            int[] answer = {start+1, start+length};
            return answer;
        }
}

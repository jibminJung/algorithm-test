package kakaoopenchat;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
	static HashMap<String,String> hm = new HashMap<>();
	public static void main(String[] args) {
		String[] record= {};
		for(String s:record) {
			char c = s.charAt(0);
			if(c =='E'||c=='C') {
				String[] id = s.split(" ");
				hm.put(id[1], id[2]);
			}
		}
		ArrayList<String> arr =new ArrayList<>();
		for(String s:record) {
			char c = s.charAt(0);
			if(c =='E') {
				String uid = s.split(" ")[1];
				arr.add(hm.get(uid) + "���� ���Խ��ϴ�.");
			}else if(c=='L') {
				String uid = s.split(" ")[1];
				arr.add(hm.get(uid) + "���� �������ϴ�.");
			}
		}
		String[] answer =arr.toArray(new String[arr.size()]);
		
	}

}

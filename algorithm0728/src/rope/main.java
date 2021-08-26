package rope;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> arr = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			arr.add(Integer.parseInt(br.readLine()));
		}
		Collections.sort(arr,Comparator.reverseOrder());
		
		int max = 0;
		for (int i = 0; i < arr.size(); i++) {
			if(max<arr.get(i)*(i+1)) {
				max = arr.get(i)*(i+1);
			}
		}
		System.out.println(max);
		
	}

}

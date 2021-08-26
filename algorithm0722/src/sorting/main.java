package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr= new int[1000001];
		StringBuilder sb= new StringBuilder();	
		for (int i = 0; i <n; i++) {
			arr[Integer.parseInt(br.readLine())]++;
		}
		for (int i = 0; i < arr.length; i++) {
			while(arr[i]>0) {
				sb.append(i).append('\n');
				arr[i]--;
			}
		}
		System.out.println(sb);
		
	}

}

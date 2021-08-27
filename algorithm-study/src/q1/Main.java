package q1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
	static int[] queue = new int[2000000];
	static int front = 0;
	static int back = 0;
	static int size = 0;

	static void push(int e) {
		queue[back++] = e;
		size++;
	}

	static void pop() {
		if (size==0) {
			sb.append(-1).append('\n');
			return;
		}
		sb.append(queue[front++]).append('\n');
		size--;
	}

	static void size() {
		sb.append(size).append('\n');
	}

	static void empty() {
		sb.append((size==0) ? 1 : 0).append('\n');
	}

	static void front() {
		if (size==0) {
			sb.append(-1).append('\n');
			return;
		}
		sb.append(queue[front]).append('\n');
	}

	static void back() {
		if (size==0) {
			sb.append(-1).append('\n');
			return;
		}
		sb.append(queue[back-1]).append('\n');
	}
	
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		while (n-- > 0) {
			String[] orders = br.readLine().split(" ");
			switch (orders[0]) {
			case "push": push(Integer.parseInt(orders[1]));
				break;
			case "pop": pop();
				break;
			case "size":
				size();
				break;
			case "empty":
				empty();
				break;
			case "front":
				front();
				break;
			case "back":
				back();
				break;

			}
		}
		System.out.println(sb);
	}
}


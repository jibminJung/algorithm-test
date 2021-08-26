package kakao2019_crane;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
	static int[][] board={{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
	static int[] moves={1,5,3,5,1,2,1,4};
	static ArrayList<Queue<Integer>> arr = new ArrayList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = board.length;
		for (int i = 0; i <n; i++) {
			arr.add(new LinkedList<Integer>());
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(board[i][j]!=0) {
					arr.get(j).offer(board[i][j]);
				}
			}
		}
		int answer=0;
		Stack<Integer> basket = new Stack<>();
		for (int i = 0; i < moves.length; i++) {
			Integer picked = arr.get(moves[i]-1).poll();
			if(picked==null) continue;
			if(basket.isEmpty()||basket.peek()!=picked) {
				basket.push(picked);
			}else {
				basket.pop();
				answer +=2;
			}
		}
		System.out.println(answer);
		
	}

}

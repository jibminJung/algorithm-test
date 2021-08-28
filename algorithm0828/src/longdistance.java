import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class longdistance {
    public static void main(String[] args) {
        int n = 6;
        int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};


        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            arr.add(new ArrayList<Integer>());
        }

        for (int[] ints : edge) {
            int from = ints[0];
            int to = ints[1];
            arr.get(from).add(to);
            arr.get(to).add(from);
        }
        Queue<Integer> q = new LinkedList<>();
        int[] dist = new int[n + 1];
        int maxDistance =0;
        q.offer(1);
        dist[1] = 1;
        while (!q.isEmpty()) {
            int temp = q.poll();
            for (int y : arr.get(temp)) {
                if(dist[y]!=0) continue;
                dist[y] = dist[temp]+1;
                maxDistance = Math.max(maxDistance,dist[y]);
                q.offer(y);
            }
        }
        int answer =0;
        for(int distance:dist){
            if(distance==maxDistance) answer++;
        }
        System.out.println(answer);

    }
}

import java.util.Collections;
import java.util.LinkedList;

public class disccontrol {
    public static void main(String[] args) {
        int[][] jobs = {{0,3},{1,9},{2,6}};
        LinkedList<Job> arr = new LinkedList<>();
        for (int[] job :jobs) {
            arr.add(new Job(job[0],job[1]));
        }
        Collections.sort(arr);
        int totalJob = arr.size();
        int end =0;
        int loadTime =0;
        while(!arr.isEmpty()){
            if(arr.getFirst().start>=end){
                end = arr.getFirst().start+arr.getFirst().len;
                loadTime += arr.getFirst().len;
                arr.removeFirst();
            }else{
                Job shortest = new Job(0,Integer.MAX_VALUE);
                for (Job j:arr) {
                    if(j.start>=end) break;
                    if(j.len<=shortest.len){
                        shortest=j;
                    }
                }
                end += shortest.len;
                loadTime += end - shortest.start;
                arr.remove(shortest);
            }
        }
        System.out.println(loadTime/totalJob);
    }

}

class Job implements Comparable<Job> {
    int start;
    int len;

    Job(int start, int len) {
        this.start = start;
        this.len = len;
    }

    @Override
    public int compareTo(Job o) {
        if(this.start!=o.start){
            return this.start-o.start;
        }else{
            return this.len-o.len;
        }
    }
}

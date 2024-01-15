import java.util.ArrayList;
import java.util.Collections;

public class JobSequence {
     static class Job{
            int deadline;
            int profit;
            int id;
            public Job(int i,int d,int p){
                id=i;
                deadline=d;
                profit=p;
            }
        }
    public static void main(String[] args) {
       
        int jobInfo[][]={{4,20},{1,10},{1,40},{1,30}};
        ArrayList<Job> jobs=new ArrayList<>();
        for(int i=0;i<jobInfo.length;i++){
            jobs.add(new Job(i, jobInfo[i][0], jobInfo[i][1]));
        }
        // ascending order of profit 
        // Collections.sort(jobs,(a,b)->a.profit-b.profit);
        // descending order 
        Collections.sort(jobs,(a,b)->b.profit-a.profit);
        ArrayList<Integer>seq=new ArrayList<>();
        int time=0;
        for(int i=0;i<jobs.size();i++){
            Job curr=jobs.get(i);
            if(curr.deadline>time){
                seq.add(curr.id);
                time++;
            }
        }
        System.out.println("max jobs: "+seq.size());
        System.out.println(seq);
    }
}

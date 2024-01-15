import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class JobsSequencing {
    static class Job {
        int deadline;
        int profit;
        int id;

        public Job(int id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the number of jobs: ");
        int n = sc.nextInt();

        ArrayList<Job> jobs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for Job " + (i + 1));
            System.out.print("Deadline: ");
            int deadline = sc.nextInt();
            System.out.print("Profit: ");
            int profit = sc.nextInt();
            jobs.add(new Job(i, deadline, profit));
        }

        Collections.sort(jobs, (obj1, obj2) -> obj2.profit - obj1.profit);
        ArrayList<Integer> seq = new ArrayList<>();
        int time = 0;
        
        for (int i = 0; i < jobs.size(); i++) {
            Job curr = jobs.get(i);
            if (curr.deadline > time) {
                seq.add(curr.id);
                time++;
            }
        }
        
        // print the sequence
        System.out.println("Maximum Jobs: " + seq.size());
        System.out.print("Job Sequence: ");
        for (int i = 0; i < seq.size(); i++) {
            System.out.print(seq.get(i) + " ");
        }
        System.out.println();
        sc.close();
    }
}

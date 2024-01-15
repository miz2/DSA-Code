import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ActivitySelection {
    public static void main(String[] args) {
        int start[]={1, 0, 1, 4, 2, 5, 3, 4};
        int end[]={3, 4, 2, 6, 9, 8, 5, 5};

        // sorting 
        int activities[][]=new int[start.length][3];
        for(int i=0;i<start.length;i++){
            activities[i][0]=i;
            activities[i][1]=start[i];
            activities[i][2]=end[i];
        }
        Arrays.sort(activities,Comparator.comparingDouble(o->o[2]));
            // end time basis sorted 

            int maxAct=0;
            ArrayList<Integer> ans=new ArrayList<>();

            // 1st activity 
            maxAct=1;
            ans.add(activities[0][0]);
            int lastEnd=activities[0][2];
            for(int i=1;i<end.length;i++){
                if(activities[i][1]>=lastEnd){
                    // select activity 
                    maxAct++;
                    // adding the index to the answer 
                    ans.add(activities[i][0]);
                    lastEnd=activities[i][2];
                }
            }
            System.out.println("max activities="+maxAct);
            System.out.println(ans);
    }
}

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {
    public static void main(String[] args) {
        // int val[]={1, 2, 3, 4,5,12, 32, 40, 30,50};
        // int weight[]={1, 2, 3, 4 , 5,4, 8, 2, 6,1};
        // int W=10;
        int val[]={30,40,45,77,90};
        int weight[]={5,10,15,22,25};
        int W=60;
        double ratio[][]=new double[val.length][2];
        // oth col => index;1st col = ratio
        for(int i=0;i<val.length;i++){
            ratio[i][0]=i;
            ratio[i][1]=val[i]/(double)weight[i];
        }
        Arrays.sort(ratio,Comparator.comparing(o->o[1]));
        // for descending order
        int capacity=W;
        int finalVal=0;
        for(int i=ratio.length-1;i>=0;i--){
            int idx=(int)ratio[i][0];
            if(capacity>=weight[idx]){
                finalVal+=val[idx];
                capacity-=weight[idx];
            }
            else{
                // include fractional 
                finalVal+=(ratio[i][1]*capacity);
                capacity=0;
                break;
            }
        }
        System.out.println("Final Value:"+finalVal);
    }
}

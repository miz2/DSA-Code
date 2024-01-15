import java.util.ArrayList;

public class MostFrequent {
    public static int mf(ArrayList <Integer> num,int key){
        int result[]=new int[1000];
        for(int i=0;i<num.size();i++){
            if(num.get(i)==key){
                result[num.get(i+1)-1]++;
            }
        }
        int max=Integer.MIN_VALUE;
        int ans=0;
        for(int i=0;i<1000;i++){
            if(result[i]>max){
                max=result[i];
                ans=i+1;
            }
        }
        // for(int i=0;i<result.length;i++){
        //     System.out.print(result[i] +" ");
        // }
        return ans;
    }
    public static void main(String[] args) {
        ArrayList <Integer> num=new ArrayList<>();
        num.add(2);
         num.add(2);
          num.add(2);
           num.add(2);
            num.add(3);
        System.out.println(mf(num, 2));
    }
}

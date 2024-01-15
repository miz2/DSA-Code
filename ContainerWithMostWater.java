import java.util.ArrayList;

public class ContainerWithMostWater {
    public static int bruteMethod(ArrayList <Integer> height){
    int maxWater=0;
    // TC: O(n^2)
        for(int i=0;i<height.size();i++){
            for(int j=i+1;j<height.size();j++){
                int ht=Math.min(height.get(i), height.get(j));
                int wid=j-i;
                int currwater=ht*wid;
                maxWater=Math.max(maxWater, currwater);
            }
        }
        return maxWater;
}
public static int twoPointer(ArrayList <Integer> height){
    int maxWater=0;
    int lp=0;
    int rp=height.size()-1;
    while(lp<rp){
        // calculate the water area
        int ht=Math.min(height.get(lp), height.get(rp));
        int wid=rp-lp;
        int currwater=wid*ht;
        maxWater=Math.max(maxWater, currwater);
        // updating the pointers
        if(height.get(lp)<height.get(rp)){
            lp++;
        }
        else{
            rp--;
        }
    }
    return maxWater;
}
    public static void main(String[] args) {
        ArrayList <Integer> height=new ArrayList<>();
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);
        System.out.println(bruteMethod(height));
        //  int height[]={4,2,0,6,3,2,5};
        ArrayList <Integer> height2=new ArrayList<>();
        height2.add(4);
        height2.add(2);
        height2.add(0);
        height2.add(6);
        height2.add(3);
        height2.add(2);
        height2.add(5);
        System.out.println(bruteMethod(height2));
        System.out.println(twoPointer(height));
    }
}

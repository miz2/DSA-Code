import java.util.ArrayList;

public class PairSum {
        public static boolean brute(ArrayList <Integer> pair,int target){
            for(int i=0;i<pair.size();i++){
                for(int j=i+1;j<pair.size();j++){
                    if(pair.get(i)+pair.get(j)==target){
                        return true;
                    }
                }
            }
            return false;
        }
        public static boolean twoPointer(ArrayList <Integer> pair,int target){
            int lp=0,rp=pair.size()-1;
            while(lp!=rp){
                if(pair.get(lp)+pair.get(rp)==target){
                    return true;
                }
                if(pair.get(lp)+pair.get(rp)<target){
                    lp++;
                }
                else{
                    rp--;
                }
            }
            return false;
        }
        public static boolean pairsum2(ArrayList<Integer> pair, int target) {
    int pivot = -1;
    int n = pair.size();
    
    // Find the breaking point
    for (int i = 0; i < pair.size(); i++) {
        if (pair.get(i) > pair.get((i + 1) % n)) {
            pivot = i;
            break;
        }
        pivot = 0; // If the array is already sorted, there is no breaking point
    }
    
    int lp = (pivot + 1) % n;
    int rp = pivot;
    
    while (lp != rp) {
        // Case 1
        if (pair.get(lp) + pair.get(rp) == target) {
            return true;
        }
        
        if (pair.get(lp) + pair.get(rp) < target) {
            lp = (lp + 1) % n;
        } else {
            rp = (n + rp - 1) % n;
        }
    }
    
    return false;
}


       public static void main(String[] args) {
        ArrayList <Integer> pair=new ArrayList<>();
        pair.add(1);
        pair.add(2);
        pair.add(3);
        pair.add(4);
        pair.add(5);
        pair.add(6);
        System.out.println(pair);
        System.out.println(brute(pair, 5));
        System.out.println(twoPointer(pair, 0));
        ArrayList <Integer> p=new ArrayList<>();
        p.add(11);
        p.add(15);
        p.add(6);
        p.add(8);
        p.add(9);
        p.add(10);
        System.out.println(p);
        System.out.println(pairsum2(p, 16));
    }
 
}
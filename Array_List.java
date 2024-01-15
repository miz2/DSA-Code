import java.util.ArrayList;
import java.util.Collections;

public class Array_List {
    public static void swap(ArrayList<Integer> list,int i1,int i2){
    int temp=list.get(i1);
    list.set(i1,list.get(i2));
    list.set(i2, temp);
}
    public static void main(String[] args) {
        ArrayList <Integer> arr=new ArrayList<>();
        arr.add(1);
        arr.add(34);
        arr.add(356);
        arr.add(2,57);
        arr.add(4, 45);
        System.out.println(arr);
        // get
        System.out.println(arr.get(1));
        // delete
        arr.remove(2);
        System.out.println(arr);

        // set 
        arr.set(1, 56);
        System.out.println(arr);
        System.out.println(arr.contains(56));
        System.out.println(arr.size());

        // iterating the arraylist 
        for(int i=0;i<arr.size();i++){
            System.out.println(arr.get(i));
        }
        for(int i=arr.size()-1;i>=0;i--){
            System.out.print(arr.get(i)+" ");
        }
        System.out.println();

        // maximum in arraylist 
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.size();i++){
            // if(max<arr.get(i)){
            //     max=arr.get(i);
            // }
            max=Math.max(max, arr.get(i));
        }
        System.out.println(max);

        // swapping 
        int i1=1,i2=3;
        System.out.println(arr);
        swap(arr, i1, i2);
        System.out.println(arr);
        // ascending order 
        Collections.sort(arr);
        System.out.println(arr);
        //descending order
        Collections.sort(arr, Collections.reverseOrder());
        System.out.println(arr);
    }
}

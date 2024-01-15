import java.util.*;
public class NextGreaterElem {
    public static void main(String[] args) {
        int arr[]={6,8,0,1,3};
        Stack <Integer> s=new Stack<>();
        int nextG[]=new int[arr.length];
        for(int i=arr.length-1;i>=0;i--){
            // while
            while(!s.empty() &&arr[s.peek()]<=arr[i]){
                s.pop();
            }
            if(s.empty()){
                nextG[i]=-1;
            }
            else{
                nextG[i]=arr[s.peek()];
            }
            s.push(i);
        }

        for(int i=0;i<nextG.length;i++){
            System.out.print(nextG[i]+" ");
        }
    }
}

public class Rev_array {
    public static void Reverse(int arr[]){
        int low=0,end=arr.length-1;
        while(low<end){
            int temp=arr[end];
            arr[end]=arr[low];
            arr[low]=temp;
            low++;
            end--;
        }
    }
    public static void main(String[] args) {
        int num[] = { 2, 4, 5,6, 7 ,20, 67 };
        // for(int i=0;i<num.length;i++){
        //     System.out.print(" "+ num[i]);
        // }
        Reverse(num);
        for(int i=0;i<num.length;i++){
            System.out.print( " "+num[i]+" ");
        }
    }
}

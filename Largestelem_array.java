public class Largestelem_array {
    public static int getLargest(int arr[]){
        int largest=Integer.MIN_VALUE;
        int smallest=Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            if(largest<arr[i]){
                largest=arr[i];
            }
            if(smallest>arr[i]){
                smallest=arr[i];
            }
        }
        System.out.println("Smallest value"+smallest);
        return largest;
        
    }
    public static void main(String[] args) {
        int arr[]={2,6,8,5,34};
        int x=getLargest(arr);
        System.out.println("Largest num in array: "+x);
        }
}

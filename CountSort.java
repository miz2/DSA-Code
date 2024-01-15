public class CountSort {
    // function for printing the Array
    public static void printArray(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(" "+arr[i]);
        }
    }
    // function for counting sort
    public static void countSort(int arr[]){
        int largest=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            largest=Math.max(largest, arr[i]);
        }
        // make the counting array
        int count[]=new int[largest+1];
        for(int i=0;i<arr.length;i++){
            count[arr[i]]++;
        }
        // sorting 
        int j=0;
       
        for(int i=0;i<count.length;i++){
            while(count[i]>0){
                arr[j]=i;
                j++;
                // decrease the frequency
                count[i]--;
            }
        }
    }

    public static void main(String[] args) {
        int arr[]={0, 2,3,5,6,0,1,3,3,2,4,5,8, 4, 7, 9, 1, 1, 7};
        System.out.println("Before Sorting-->");
        printArray(arr);
        System.out.println();
        System.out.println("After Sorting-->");
        countSort(arr);
        printArray(arr);
    }
}

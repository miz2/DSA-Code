public class Sorting {
    public static void Bubble(int arr[]){
        for(int i=0;i<arr.length-1;i++){
            boolean swapped=false;
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    swapped=true;
                }
            }
            if(swapped==false){
                break;
            }
        }
    }
    public static void selection(int arr[]){
        for(int i=0;i<arr.length-1;i++){
            int minPos=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[minPos]>arr[j]){
                    minPos=j;
                }
            }
            // swap
            int temp=arr[minPos];
            arr[minPos]=arr[i];
            arr[i]=temp;
        }
    }
    public static void insertionSort(int arr[]){
        for(int i=1;i<arr.length;i++){
            int cur=arr[i];
            int prev=i-1;
            // find the correct position to insert 
            while(prev>=0 && arr[prev]>cur){
                arr[prev+1]=arr[prev];
                prev--;
            }
            // insertion
            arr[prev+1]=cur;
        }
    }
    public static void countingSort(int arr[]){
        int largest=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            largest=Math.max(largest, arr[i]);
        }
        int count[]=new int[largest+1];
        for(int i=0;i<arr.length;i++){
            count[arr[i]]++;
        }
        // sorting 
        int j=0;
       
        for(int i=0;i<count.length;i++){
            System.out.println("value of i"+i);
            while(count[i]>0){
                arr[j]=i;
                System.out.println("value of i:"+i);
                j++;
                // decrease the frequency
                count[i]--;
            }
        }
    }
    public static void printArray(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(" "+arr[i]);
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        int price[]={7,1,5,3,6,4};
        int co[]={1,4,1,3,2,4,3,7};
        printArray(price);
        Bubble(price);
        System.out.println("Using Bubble Sort");
        printArray(price);
        System.out.println("Using Selection Sort");
        printArray(price);
        System.out.println("Using Insertion Sort");
        insertionSort(price);
        printArray(price);
        System.out.println("Using Counting Sort");
        countingSort(co);
        
        printArray(co);
        // countingSort(price);
        // printArray(price);
    }
}

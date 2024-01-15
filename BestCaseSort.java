public class BestCaseSort {
    public static void printArray(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(" "+arr[i]);
        }
    }
    public static void bubbleSort(int arr[]){
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
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        System.out.println("Before Sorting-->");
        printArray(arr);
        System.out.println();
        System.out.println("After Sorting-->");
        bubbleSort(arr);
        printArray(arr);
    }
}

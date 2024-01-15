public class PairsArray {
    public static void Pair(int arr[]){
        int tp=0;
        for(int i=0;i<arr.length;i++){
            int current=arr[i];
            for(int j=i+1;j<arr.length;j++){
                System.out.println("("+current+","+arr[j] +")");
                tp++;
            }
        }
        System.out.println("Total Pairs"+tp);
    }
    public static void main(String[] args) {
        int num[] = { 2, 4, 5,6, 7 ,20, 67 };
        Pair(num);

    }
}

public class SubArray {
    public static void Sub(int arr[]) {
        int ts=0;
        for (int i = 0; i < arr.length; i++) {
            int start=i;
            for (int j = i; j < arr.length; j++) {
                int end=j;
                int sum=0;
                for(int k=start;k<=end;k++){
                    System.out.print(arr[k]+" ");
                    sum += arr[k];
                }
                System.out.print("=> Sum: " + sum);
                ts++;
                System.out.println();
            }
            System.out.println();
            
        }
        System.out.println("Total Subarrays"+ts);
    }

    public static void main(String[] args) {
        int num[] = { 2, 4, 5, 6, 7, 20, 67 };
        Sub(num);
    }
}

public class BinarySearch {
    public static int BS(int arr[], int n,int start,int end) {
        
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == n) {
                return mid;
            }
            if (arr[mid] < n) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // array must be sorted before applying binary search 

        int num[] = { 2, 4, 5,6, 7 ,20, 67 };
        
        int key =20;
        int start = 0;
        int end = num.length - 1;
        int x = BS(num, key,start,end);
        System.out.println(x);
    }
}

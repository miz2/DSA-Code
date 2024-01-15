public class MaxSubArraySum {
    public static void Meth1(int arr[]){
        int sum=0;
         int max_sum=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            int start=i;
            for(int j=i;j<arr.length;j++){
                int end=j;
                sum=0;
                for(int k=start;k<=end;k++){
                    sum+=arr[k];
                }
                System.out.println(sum);
                if(max_sum<sum){
                    max_sum=sum;
                }
            }
        }
        System.out.println("Max_Sum: "+max_sum);
    }
    public static void preFix(int arr[]){
        int sum=0;
        int max_sum=Integer.MIN_VALUE;
        int prefix[]=new int[arr.length];
        prefix[0]=arr[0];

        for(int i=1;i<prefix.length;i++){
            prefix[i]=prefix[i-1]+arr[i];
        }
        for(int i=0;i<arr.length;i++){
            int start=i;
            for(int j=i;j<arr.length;j++){
                int end=j;
                sum= start==0 ?prefix[end]:prefix[end]-prefix[start-1];
            }
            if(max_sum<sum){
                    max_sum=sum;
                }
        }
        System.out.println("Using prefix array: "+max_sum);
    }
    public static void Kadane(int arr[]){
        int allNegative=0;
        int max_sum=Integer.MIN_VALUE;
        int cur_sum=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<0){
                allNegative++;
            }
        }
        System.out.println("Negative Numbers in array: "+allNegative);
        for(int i=0;i<arr.length;i++){
            if(allNegative==arr.length){
                // int lar=Integer.MIN_VALUE;
                if(max_sum<arr[i]){
                    max_sum=arr[i];
                }
            }
            else{
            cur_sum+=arr[i];
            if(cur_sum<0){
                cur_sum=0;
            }
            max_sum=Math.max( cur_sum,max_sum);
            }
            
        }
        System.out.println("Max Subarray Sum Using Kadane's:"+max_sum);
    }
    public static void main(String[] args) {
        int arr[]={1,-2,6,-1,3};
        int numbers[]={-2,-3,4,-1,-2,1,5,-3};
        int n[]={-5,-20,-10,-2,-6};
        Meth1(arr);
        preFix(arr);
        Kadane(numbers);
        Kadane(n);
        int arr3[]={-1};
        Kadane(arr3);
    }
}

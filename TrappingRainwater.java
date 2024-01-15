public class TrappingRainwater {
    public static int trappedRain(int arr[]){
        // calculate left max boundary
        
        int left_max[]=new int[arr.length];
        left_max[0]=arr[0];
        for(int i=1;i<arr.length;i++){
            left_max[i]=Math.max(arr[i], left_max[i-1]);
        }
        // calculate right max boundary
        int right_max[]=new int[arr.length];
        right_max[right_max.length-1]=arr[arr.length-1];
        for(int i=arr.length-2;i>=0;i--){
            right_max[i]=Math.max(arr[i], right_max[i+1]);
        }
        // loop
        int tw=0;
        for(int i=0;i<arr.length;i++){
             // waterLevel=min(left,right)
            int waterlevel=Math.min(left_max[i], right_max[i]);
            // tw=waterlevel-arr[i]
            tw+=waterlevel-arr[i];
        }
       
        
        return tw;

    }
    public static void main(String[] args) {
        int height[]={4,2,0,6,3,2,5};
       System.out.println("Trapped Rain "+trappedRain(height)); 
    }
}

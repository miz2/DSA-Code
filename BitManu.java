public class BitManu {
    public static boolean isPower2(int n){
        return (n&(n-1))==0;
    }
    public static int countSetBits(int n){
        int count=0;
        while(n>0){
            if((n&1)!=0){
                count++;
            }
            n=n>>1;
        }
        return count;
    }
    // public static int addOne(int x){
    //     return -(-x - 1);
    // }
    public static void UctoLc(){
        for(char ch='A';ch<='Z';ch++){
            System.out.println((char)(ch|' '));
        }
    }
    public static void main(String[] args) {
        System.out.println(5 &6);
        System.out.println(5|6);
        System.out.println(5^6);
        System.out.println(~0);
        System.out.println(5<<2);
        System.out.println(6>>1);
        System.out.println(isPower2(15));
        System.out.println(countSetBits(16));
        // System.out.println(addOne(5));
        UctoLc();
    }
}

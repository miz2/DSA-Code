public class BitOpr {
    public static void oddEven(int n){
        int bitmask=1;
        if((n & bitmask)==0){
            System.out.println("even number");
        }
        else{
            System.out.println("odd number");
        }
    }
    public static int getIthBit(int n,int i){
        int bitmask=1<<i;
        if((n& bitmask)==0){
            return 0;
        }
        else{
            return 1;
        }
    }
    public static int clearIth(int n,int i){
        int bitmask=~(1<<i);
        return n& bitmask;
    }
    public static int setIthbit(int n,int i){
        int bitmask=1<<i;
        return n|bitmask;
    }
    public static int updateIthbit(int n,int i,int val){
        // if(val==0){
        //     return clearIth(n, i);
        // }
        // else{
        //     return setIthbit(n, i);
        // }
        // new approach 
        n=clearIth(n, i);
        int bitmask=val<<i;
        return n|bitmask;
    }
    public static int clearIbit(int n,int i){
        int bitmask=(~0)<<i;
        return n & bitmask;
    }
    public static int clearrange(int n,int i,int j){
        int a =((~0<<(j+1)));
        int b=(1<<i)-1;
        int bitmask=a|b;
        return n &bitmask;
    }
    public static void main(String[] args) {
        int x=9;
        oddEven(x);
        oddEven(14);
        System.out.println(getIthBit(10, 3));
        System.out.println(setIthbit(10, 2));
        System.out.println(clearIth(10, 1));
        System.out.println(updateIthbit(10, 2, 1));
        System.out.println(clearIbit(15, 2));
        System.out.println(clearrange(10, 2, 4));
    }
}

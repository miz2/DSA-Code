public class FastExponentiation {
    public static int exp(int a,int e){
        int ans=1;
        while(e>0){
            if((e&1)!=0){
                ans=ans*a;

            }
            a=a*a;
            e=e>>1;
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(exp(3,5));
    }
}

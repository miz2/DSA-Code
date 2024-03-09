public class Basic_Rec {
    static void traverse(int n){
        if(n==0){
            return;
        }
        traverse(n-1);
        System.out.println(n);
    }
    static void reverse(int n){
        if(n==0){
            // System.out.println("0");
            System.out.println(n);
            return ;
        }
        System.out.println(n);
        reverse(n-1);
    }
    public static void main(String[] args) {
        traverse(6);
        reverse(8);
    }
}

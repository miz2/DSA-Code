import java.util.Scanner;

public class FibbonaciRec {
    public static int fibbonaci(int n) {
        if(n<0){
            System.out.println("Enter a Non Negative Number->>");
            return -1;
        }
        if (n == 0 || n == 1) {
            return n;
        }
        int fnm1 = fibbonaci(n - 1);
        int fnm2 = fibbonaci(n - 2);
        int fn = fnm1 + fnm2;
        return fn;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Number:");
        int n=sc.nextInt();
        int result=fibbonaci(n);
        if (result != -1) {
            System.out.println("F(" + n + ") = " + result);
        }
        sc.close();
        
    }
}

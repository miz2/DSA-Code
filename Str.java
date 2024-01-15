import java.util.Scanner;

public class Str {
    public static void letters(String str){
        for(int i=0;i<str.length();i++){
            System.out.print(str.charAt(i)+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        char arr[]={'a','b','c'};
        String s1="abcd";
        String s2=new String("xyz@#$$");
        System.out.println(s2);
        Scanner sc=new Scanner(System.in);
        // String name;
        // name =sc.nextLine();
        // System.out.println(name);
        System.out.println(s1.length());
        System.out.println(arr);
        // concatenation
        String fin="Ravi";
        String lan="Kumar";
        String fn=fin+" "+lan;
        System.out.println(fn);

        // charAt method
        System.out.println(fn.charAt(0));
        letters(fn);
        String st1="Tony";
        String st2="Tony";
        String st3=new String("Tony");
        if(st1==st2){
            System.out.println("equal");
        }
        else{
            System.out.println("not equal");
        }
         if(st1==st3){
            System.out.println("equal");
        }
        else{
            System.out.println("not equal");
        }
        System.out.println(st1.equals(st3));

        sc.close();
    }
}

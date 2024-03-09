import java.util.Scanner;

public class Count {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int count=0;
        int n=sc.nextInt();
		int temp=n;
		while(temp!=0){
			temp/=10;
			count++;
		}
        temp=n;
        System.out.println(count);
        System.out.println(temp);
        sc.close();
    }
    
}

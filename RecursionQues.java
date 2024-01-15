public class RecursionQues {
    static String digits[]={"zero","one","two","three","four","five","six","seven","eight","nine"};
    public static void occurence(int arr[],int key,int i){
        int len=arr.length;
        if(i==len){
            return;
        }
        if(arr[i]==key){
            System.out.print(i+" ");
        }
        occurence(arr, key, i+1);
    }
    public static void digittoeng(int n){
        if(n==0){
            return;
        }
        int lastdigit=n%10;
        digittoeng(n/10);
        System.out.print(digits[lastdigit]+ " ");
    }
    public static int lenString(String str){
        if(str.length()==0){
            return 0;
        }
        return 1+ lenString(str.substring(1));
    }
    public static int countSub(String str,int i,int j,int n){
        if(n==1){
            return 1;

        }
        if(n<=0){
            return 0;
        }
        int res=countSub(str, i+1, j, n-1)+ countSub(str, i, j-1, n-1)-countSub(str, i+1, j-1, n-2);
        if(str.charAt(i)==str.charAt(j)){
            res++;
        }
        return res;
    }
    public static void towerofHanoi(int n,String start,String helper ,String end){
        if(n==1){
            System.out.println("transfer disk "+n +" from "+start+" to "+end);
            return;
        }
        // step 1 :transfer n-1 disks to helper so start has only one left using end as helper
        towerofHanoi(n-1, start, end, helper);
        System.out.println("transfer disk "+n +" from "+start+" to "+end);
        towerofHanoi(n-1, helper, start, end);

    }
    public static void main(String[] args) {
        // ques 1
        int arr[]={2,4,5,6,2,3,2};
        occurence(arr, 2, 0);
        // ques 2
        digittoeng(2019);
        // ques 3
        String str="abcde";
        System.out.println(lenString(str));

        // ques 4
        String s2="abcab";
        int n=s2.length();
        System.out.println(countSub(s2, 0, n-1, n)); 
        towerofHanoi(4, "S", "H", "D");
    }
}

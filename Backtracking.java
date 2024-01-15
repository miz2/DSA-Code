public class Backtracking {
    public static void changeArray(int arr[], int i, int val) {
        // base case
        if (i == arr.length) {
            printArray(arr);
            return;
        }
        // recursion kaam
        arr[i] = val;
        // upar jaate time
        changeArray(arr, i + 1, val + 1);
        // neeche wapas jab aaega
        arr[i] = arr[i] - 2;
    }

    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i]);
            // System.out.println();
        }
    }

    public static void findSubset(String str, String ans, int i) {
        // base case
        if (i == str.length()) {
            if (ans.length() == 0) {
                System.out.println("\u03A6");
            } else {
                System.out.println(ans);
            }

            return;
        }
        // recursion
        // two choices :yes/no
        // yes
        findSubset(str, ans + str.charAt(i), i + 1);
        // no choice
        findSubset(str, ans, i + 1);
    }
    public static void permutation(String str,String ans){
        // base case
        if(str.length()==0){
            System.out.println(ans);
            return;
        }
        // recursion
        for(int i=0;i<str.length();i++){
            char curr=str.charAt(i);
            String Newstr=str.substring(0,i) +str.substring(i+1);
            permutation(Newstr, ans+curr);
        }
    }
    public static void main(String[] args) {
        // ques 1:
        // int arr[]=new int[5];
        // changeArray(arr, 0, 1);
        // System.out.println();
        // printArray(arr);

        // ques 2 :string subsets

        // String str = "abc";
        // findSubset(str, new String(""), 0);
        // ques 3 :Permutation

        String str="abc";
        permutation(str, "");
    }
}

public class Recursion {
    public static void descending(int n) {
        System.out.println(n);
        if (n > 1) {
            descending(n - 1);
        } else {
            return;
        }
    }

    public static void ascending(int n) {
        if (n == 1) {
            System.out.println(n);
            return;
        }
        ascending(n - 1);
        System.out.println(n);
    }

    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        // int fnm1=factorial(n-1);
        int fn = n * factorial(n - 1);
        return fn;
    }

    public static int sum(int n) {
        if (n == 1) {
            return 1;
        }
        int fn = n + sum(n - 1);
        return fn;
    }

    public static int fibbonaci(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int fnm1 = fibbonaci(n - 1);
        int fnm2 = fibbonaci(n - 2);
        int fn = fnm1 + fnm2;
        return fn;
    }

    public static boolean isSorted(int arr[], int i) {
        if (i == arr.length - 1) {
            return true;
        }
        if (arr[i] > arr[i + 1]) {
            return false;
        }
        return isSorted(arr, i + 1);
    }

    public static int firstOccurence(int arr[], int key, int i) {
        if (i == arr.length) {
            return -1;
        }
        if (arr[i] == key) {
            return i;
        }
        return firstOccurence(arr, key, i + 1);
    }

    public static int lastOccurence(int arr[], int key, int i) {
        if (i == arr.length) {
            return -1;
        }
        int isFound = lastOccurence(arr, key, i + 1);

        if (isFound == -1 && arr[i] == key) {
            return i;
        }
        // check with self
        return isFound;
    }

    public static int exp(int x, int n) {
        if (n == 0) {
            return 1;
        }
        return x * exp(x, n - 1);
    }

    public static int expOptimise(int x, int n) {
        if (n == 0) {
            return 1;
        }
        int o = expOptimise(x, n / 2);
        int half = o * o;
        if (n % 2 != 0) {
            half = x * half;
        }
        return half;
    }

    public static int tilling(int n) {
        // floor size is 2xn
        // base case
        if (n == 0 || n == 1) {
            return 1;
        }
        // work
        // vertical
        int fnm1 = tilling(n - 1);
        // horizontal
        int fnm2 = tilling(n - 2);
        int totalways = fnm1 + fnm2;
        return totalways;


        // return tilling(n-1) +tilling(n-2);
    }

    public static void removeDup(String str, int idx, StringBuilder newStr, boolean map[]) {
        if (idx == str.length()) {
            System.out.println(newStr);
            return;
        }
        // kaam
        char curr = str.charAt(idx);
        if (map[curr - 'a'] == true) {
            // duplicate
            removeDup(str, idx + 1, newStr, map);
        } else {
            map[curr - 'a'] = true;
            removeDup(str, idx + 1, newStr.append(curr), map);
        }
    }

    public static void printBinStr(int n, int lp, String str) {
        // kaam
        // if(lp==0){
        // // put 0
        // printBinStr(n-1, 0, str.append("0"));
        // // put 1 in the string
        // printBinStr(n-1, 1, str.append("1"));
        // }
        // else{
        // printBinStr(n-1, 0, str.append("0"));
        // }

        // or
        // base case
        if (n == 0) {
            System.out.println(str);
            return;
        }
        // kaam

        printBinStr(n - 1, 0, str + "0");
        if (lp == 0) {
            printBinStr(n - 1, 1, str + "1");
        }
    }

    public static void withoutzero(int n, int lp, String str) {
        if (n == 0) {
            System.out.println(str);
            return;
        }
        withoutzero(n - 1, 1, str + "1");
        if (lp == 1) {
            withoutzero(n - 1, 0, str + "0");
        }
    }

    public static void withoutConse(int n, int lp, String str) {
        if (n == 0) {
            System.out.println(str);
            return;
        }
        if (lp == 0) {
            withoutConse(n - 1, 1, str + "1");
        } else {
            withoutConse(n - 1, 0, str + "0");
        }
    }

    public static int friendsPairing(int n) {
        // choice to be single or pair
        if (n == 1 || n == 2) {
            return n;
        }
        // int fnm1=friendsPairing(n-1);
        // int fnm2=friendsPairing(n-2);
        // int pairways=(n-1)*fnm2;
        // int totalways=fnm1+pairways;
        // return totalways;

        return friendsPairing(n - 1) + (n - 1) * friendsPairing(n - 2);

    }

    public static void main(String[] args) {
        // descending(5);
        // ascending(10);
        // System.out.println(factorial(5));
        // System.out.println(sum(10));
        // System.out.println(fibbonaci(24));
        // System.out.println(fibbonaci(25));
        // System.out.println(fibbonaci(26));
        // System.out.println(fibbonaci(27));

        // is sorted
        // int arr[]={1,2,3,4};
        // System.out.println(isSorted(arr, 0));

        // is occurence
        // int arr[]={2,6,4,2,4,6};
        // System.out.println(firstOccurence(arr, 6, 0));
        // System.out.println(lastOccurence(arr, 6, 0));

        // exponention
        // System.out.println(exp(5,2));
        // System.out.println(expOptimise(8, 3));

        // tilling
        // System.out.println(tilling(5));

        // remove duplicate in string

        // String str="chhahlaiyeshuurukartehai";
        // removeDup(str, 0, new StringBuilder(""), new boolean[26]);

        // binary strings

        // printBinStr(3, 0, new String(""));
        // withoutzero(3, 0, new String(""));
        // withoutConse(5, 0, new String(""));
        System.out.println(friendsPairing(3));
    }
}

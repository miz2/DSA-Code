import java.util.*;

public class MaxAreaHistogram {
    public static void maxArea(int arr[]) {
        int maxarea = 0;
        int nsl[] = new int[arr.length];
        int nsr[] = new int[arr.length];
        // calculating nsr
        Stack<Integer> s = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!s.empty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if (s.empty()) {
                nsr[i] = arr.length;
            } else {
                // top
                nsr[i] = s.peek();
            }
            s.push(i);
        }

        // nsl
        // empty the stack
        s = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!s.empty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if (s.empty()) {
                nsl[i] = -1;
            } else {
                // top
                nsl[i] = s.peek();
            }
            s.push(i);
        }
        // current area

        // width=j-i-1=nsr[i]-nsl[i]-1
        for (int i = 0; i < arr.length; i++) {
            int height = arr[i];
            int width = nsr[i] - nsl[i] - 1;
            int currArea = height * width;
            maxarea = Math.max(currArea,maxarea);
        }
        System.out.println("Max Area in Histogram " + maxarea);
    }

    public static void main(String[] args) {
        int arr[] = { 2, 1, 5, 6, 2, 3 };
        maxArea(arr);
    }
}

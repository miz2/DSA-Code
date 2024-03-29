import java.util.*;
public class ZigZag
{ 
    public static int R = 5, C = 4; 

    public static void diagonalOrder(int[][] arr, int n, int m) 
    { 
        // Create a 2D ArrayList to store the diagonals
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>(n+m-1); 
        
        // Initialize the inner ArrayLists for each diagonal
        for(int i = 0; i < n + m - 1; i++) 
        { 
            ans.add(new ArrayList<Integer>()); 
        } 

        // Fill the ans ArrayList with elements from the original array in diagonal order
        for (int i = 0; i < n; i++) 
        { 
            for (int j = 0; j < m; j++) 
            { 
                (ans.get(i+j)).add(arr[i][j]); 
            } 
        } 

        // Print the diagonals in reverse order
        for (int i = 0; i < ans.size(); i++) 
        { 
            for (int j = ans.get(i).size() - 1; j >= 0; j--) 
            { 
                System.out.print(ans.get(i).get(j) + " "); 
            } 
            System.out.println(); 
        } 
        for (int i = 0; i < ans.size(); i++) 
        { 
            for (int j = 0;j<ans.get(i).size();j++) 
            { 
                System.out.print(ans.get(i).get(j) + " "); 
            } 
            System.out.println(); 
        } 
    } 

    // Driver code 
    public static void main (String[] args) { 
        int n = 5, m = 4; 
        int[][] arr={ 
            { 1, 2, 3, 4 }, 
            { 5, 6, 7, 8 }, 
            { 9, 10, 11, 12 }, 
            { 13, 14, 15, 16 }, 
            { 17, 18, 19, 20 }, 
        }; 

        // Function call to print diagonals
        diagonalOrder(arr, n, m); 
    } 
} 

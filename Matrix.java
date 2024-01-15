import java.util.Scanner;

public class Matrix {
    public static boolean search(int mat[][],int key){
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
               if(mat[i][j]==key){
                System.out.println("Found at index ("+ i +","+j+")");
                return true;
               }
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        int matrix[][]=new int [3][2];
        Scanner sc=new Scanner(System.in);
        int n=3,m=2;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.println("Enter Value: ");
                matrix[i][j]=sc.nextInt();
            }
        }
        System.out.println("Output");
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        search(matrix, 8);
        sc.close();
        System.out.println(matrix.length);
        System.out.println(matrix[0].length);
    }
}

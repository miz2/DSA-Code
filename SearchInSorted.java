public class SearchInSorted {
    public static boolean staircaseSearch1(int mat[][],int key){
        int row=0, col=mat[0].length-1;
        while(row<mat.length && col>=0){
            if(mat[row][col]==key){
                System.out.println("found at "+row+col);
                return true;
            }
            else if(key<mat[row][col]){
                col--;
            }
            else{
                row++;
            }
        }
         System.out.println("Not found");
        return false;
    }
    public static boolean staircaseSearch2(int mat[][],int key){
        int row=mat.length-1,col=0;
        while(col<mat[0].length && row>=0){
            if(mat[row][col]==key){
                System.out.println("found at "+row +","+col);
                return true;
            }
            else if(key<mat[row][col]){
                row--;
            }
            else{
                col++;
            }
        }
        System.out.println("Not found");
        return false;
    }
    public static void main(String[] args) {
        int matrix[][]={{10,20,30,40},{15,25,35,45},{27,29,37,48},{32,33,39,50}};
        int key=33;
        int k2=15;
        staircaseSearch1(matrix, key);
        staircaseSearch2(matrix, k2);
    }
}

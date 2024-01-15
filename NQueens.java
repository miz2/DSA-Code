public class NQueens {
    public static boolean isSafe(char board[] [],int row,int col){
        // vertical up same column and value of i gets decreased
        for(int i=row-1;i>=0;i--){
            if(board[i][col]=='Q'){
                return false;
            }
        }

        // diagonal left up
        for(int i=row-1,j=col-1;i>=0&&j>=0;i--,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        // diagonal right up

        for(int i=row-1,j=col+1;i>=0 && j<board.length;i--,j++){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }
    public static void nqueen(char board[][],int row){
        // base
        if(row==board.length){
            printBoard(board);
            count++;
            return;
        }
        // column loop
        for(int j=0;j<board.length;j++){
            if(isSafe(board,row,j)){
                 board[row][j]='Q';
            // function call
            nqueen(board, row+1);
            // backtracking 
            board[row][j]='x';
            }
           
        }
        
    }
    public static boolean Onesolution(char board[][],int row){
        // base
        if(row==board.length){
            printBoard(board);
            count++;
            return true;
        }
        // column loop
        for(int j=0;j<board.length;j++){
            if(isSafe(board,row,j)){
                 board[row][j]='Q';
            // function call
            if(Onesolution(board, row+1)){
                return true;
            }
            // backtracking 
            board[row][j]='x';
            }
           
        }
        return false;
    }
    public static void printBoard(char arr[][]){
        System.out.println("------ChessBoard-------");
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    static int count=0;
    public static void main(String[] args) {
        int n=4;
        char board[][]=new char [n][n];
        // initialize
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='x';
            }
        }
        // nqueen(board, 0);
        // System.out.println("Total solutions:"+count);
        // for one solution
        System.out.println("-------------------");
        if(Onesolution(board, 0)){
            System.out.println("solution possible");
            printBoard(board);
        }
        else{
            System.out.println("not possible");
        }
    }
}

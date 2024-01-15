// public class RatInaMaze {
//      public static void printSudoku(int arr[][]){
        
//         for(int i=0;i<arr.length;i++){
//             for(int j=0;j<arr.length;j++){
//                 System.out.print(arr[i][j]+" ");
//             }
//             System.out.println();
//         }
//     }
//     public static boolean isSafe(int maze[][],int x,int y){
//         return (x>=0 && x<maze.length && y>=0 && y<maze.length && maze[x][y]==1);
//     }
//     public static boolean path(int maze[][],int i,int j,int sol[][]){
        
//         if(i==maze.length-1 && j==maze.length && maze[i][j]==1){
//             sol[i][j]=1;
//             return true;
//         }
//         // check if they are valid or not 
//         if(isSafe(maze, i, j)==true){
//             if(sol[i][j]==1)
//                 return false;
//             sol[i][j]=1;
            
//         }
//         return false;
//     }
//     public static void main(String[] args) {
//         int maze[][]={{1,0,0,0},{1,1,0,1},{0,1,0,0},{1,1,1,1}};

//     }
// }

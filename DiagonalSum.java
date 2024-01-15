public class DiagonalSum {
    public static int DSum(int mat[][]){
        int sum=0;
        // for(int i=0;i<mat.length;i++){
        //     for(int j=0;j<mat[0].length;j++){
        //         if(i==j){
        //             sum +=mat[i][j];
        //         }
        //         if(i+j==mat.length-1){
        //             sum+=mat[i][j];
        //         }
        //     }
        // }
        for(int i=0;i<mat.length;i++){
            // pd
            sum+=mat[i][i];
            // sd
            if(i!=mat.length-1-i){
                sum+=mat[i][mat.length-i-1];
            }
            
        }
        return sum;
    }
    public static void main(String[] args) {
        int matrix[][]={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        System.out.println(DSum(matrix));
    }
}

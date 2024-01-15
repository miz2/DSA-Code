public class LinearSearch {
    public static int Ls(int n[],int key){
        for(int i=0;i<n.length;i++){
            if(n[i]==key){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int num[]={2,4,5,10,7,9,7,5,67,12};
    int key=10;
   int s= Ls(num, key);
   System.out.println("at index :"+s);
    }
    
}

public class ArrayCreate {
    public static void update(int marks[],int nc){
        nc=6;
        for(int i=0;i<marks.length;i++){
            marks[i]+=1;
        }
    }
    public static void main(String[] args) {
        int marks[]={56,67,89};
        int nc=10;
        update(marks,nc);
        System.out.println("value of nc "+nc);
        for(int i=0;i<marks.length;i++){
            System.out.println(marks[i]);
        }
    }
}
 
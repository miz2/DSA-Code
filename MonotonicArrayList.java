import java.util.ArrayList;

public class MonotonicArrayList {
    public static boolean mono(ArrayList <Integer> pair){
        boolean inc=true;
        boolean dec=true;
        for(int i=0;i<pair.size()-1;i++){
            if(pair.get(i)>pair.get(i+1)){
                inc=false;
            }
            if(pair.get(i)<pair.get(i+1)){
                dec=false;
            }
        }
        return inc||dec;
    }
    public static void main(String[] args) {
         ArrayList <Integer> pair=new ArrayList<>();
         pair.add(1);
         pair.add(2);
          pair.add(2);
         pair.add(3);
         System.out.println(mono(pair));
    }
}

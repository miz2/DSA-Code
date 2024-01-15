import java.util.Arrays;
import java.util.Comparator;

public class MaxLengthChain {
    public static void main(String[] args) {
        int pair[][]={{5,24},{39,60},{5,28},{27,40},{50,90}};
        // sorting 
        Arrays.sort(pair,Comparator.comparingDouble(o->o[1]));
        int chainlen=1;
        int chainend=pair[0][1];
        for(int i=1;i<pair.length;i++){
            if(pair[i][0]>chainend){
                chainlen++;
                chainend=pair[i][1];
            }
        }
        System.out.println("Max Chain Length"+chainlen);
    }
}

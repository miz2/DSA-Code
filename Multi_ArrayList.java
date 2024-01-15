import java.util.ArrayList;

public class Multi_ArrayList {
    public static void main(String[] args) {
        ArrayList <ArrayList <Integer>> mainList=new ArrayList<>();
        ArrayList <Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        mainList.add(list);
        ArrayList <Integer> list2 =new ArrayList<>();
        list2.add(34);
        list2.add(56);
        mainList.add( list2);
        System.out.println(mainList);

        // traversal
        for(int i=0;i<mainList.size();i++){
            ArrayList <Integer> currList=mainList.get(i);
            for(int j=0;j<currList.size();j++){
                System.out.print(currList.get(j)+" ");
            }
            System.out.println();
        }

        // usingloop
        ArrayList <ArrayList <Integer>> ml=new ArrayList<>();
        ArrayList <Integer> l1=new ArrayList<>();
        ArrayList <Integer> l2=new ArrayList<>();
        ArrayList <Integer> l3=new ArrayList<>();

        for(int i=1;i<=5;i++){
            l1.add(i*1);
            l2.add(i*2);
            l3.add(i*3);
        }
        ml.add(l1);
        ml.add(l2);
        ml.add(l3);
        System.out.println(ml);

        // traversal
        // using nested loops
       for(int i=0;i<ml.size();i++){
            ArrayList <Integer> cl=ml.get(i);
            for(int j=0;j<cl.size();j++){
                System.out.print(cl.get(j)+" ");
            }
            System.out.println();
        }
    }
}

import java.util.LinkedList;

public class LLJCF {
    public static void main(String[] args) {
        LinkedList <Integer> l =new LinkedList<>();
        l.addLast(1);
        l.addLast(2);
        l.addFirst(0);
        System.out.println(l);
        l.remove(0);
        System.out.println(l);
        l.removeAll(l);
        System.out.println(l);
    }
}

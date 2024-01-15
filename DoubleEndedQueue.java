import java.util.*;
public class DoubleEndedQueue {
    public static void main(String[] args) {
        Deque <Integer> dq=new LinkedList<>();
        dq.addFirst(34);
        dq.addFirst(78);
        dq.addLast(87);
        System.out.println(dq);
        System.out.println(dq.getFirst());
        System.out.println(dq.getLast());
        dq.removeFirst();
        dq.removeLast();
        System.out.println(dq);
        
    }
}

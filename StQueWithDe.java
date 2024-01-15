import java.util.*;
public class StQueWithDe {
    static class StackD{
        Deque <Integer> dq=new LinkedList<>();
        public void push(int data){
            dq.addLast(data);
        } 
        public int pop(){
            return dq.removeLast();
        }
        public int peek(){
            return dq.getLast();
        }
    }
    static class QueueD{
         Deque <Integer> dq=new LinkedList<>();
          public void add(int data){
            dq.addLast(data);
        } 
        public int remove(){
            return dq.removeFirst();
        }
        public int peek(){
            return dq.getFirst();
        }

    }
    public static void main(String[] args) {
        StackD sd=new StackD();
        sd.push(0);
        sd.push(56);
        sd.push(90);
        System.out.println("peek="+sd.peek());
        QueueD qd=new QueueD();
         qd.add(0);
         qd.add(98);
         qd.add(65);
        System.out.println("peek="+qd.peek());

    }
}

import java.util.*;

public class QueueImplement {
    static class QueueA {
        static int arr[];
        static int size;
        static int rear;

        QueueA(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
        }

        public boolean isEmpty() {
            return rear == -1;
        }

        // add function
        public void add(int data) {
            if (rear == size - 1) {
                System.out.println("Queue is full");
                return;
            }
            rear = rear + 1;
            arr[rear] = data;
        }

        public int remove() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            int front = arr[0];
            for (int i = 0; i < rear; i++) {
                arr[i] = arr[i + 1];
            }
            rear = rear - 1;
            return front;
        }

        public int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return arr[0];
        }
    }

    static class CQueue {
        static int arr[];
        static int size;
        static int rear;
        static int front;

        CQueue(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
            front = -1;
        }

        public boolean isEmpty() {
            return rear == -1 && front == -1;
        }

        public boolean isFull() {
            return (rear + 1) % size == front;
        }

        public void add(int data) {
            if (isFull()) {
                System.out.println("Cqueue is full");
                return;
            }

            if (isEmpty()) {
                front = 0;
            }

            rear = (rear + 1) % size;
            arr[rear] = data;
        }

        public int remove() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            int result = arr[front];

            // last element
            if (rear == front) {
                rear = front = -1;
            } else {
                front = (front + 1) % size;
            }
            return result;
        }

        public int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return arr[front];
        }
    }

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class QueueL {
        static Node head = null;
        static Node tail = null;

        public boolean isEmpty() {
            return head == null && tail == null;
        }

        // no need of is full as this is LL
        public void add(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        public int remove() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            int front = head.data;
            // single element
            if (tail == head) {
                tail = head = null;
            } else {
                head = head.next;
            }
            return front;
        }

        public int peek() {
            return head.data;
        }
    }

    static class QueueS {
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        public boolean isEmpty() {
            return s1.isEmpty();
        }

        // add
        public void add(int data) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            s1.push(data);

            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }

        // remove
        public int remove() {
            if (isEmpty()) {
                System.out.println("empty");
                return -1;
            }
            return s1.pop();
        }

        public int peek() {
            if (isEmpty()) {
                System.out.println("empty");
                return -1;
            }
            return s1.peek();
        }
    }
    // static class QueueS2{
    // static Stack<Integer> s1=new Stack<>();
    // static Stack<Integer> s2=new Stack<>();
    // public boolean isEmpty(){
    // return s1.isEmpty();
    // }
    // public void add(int data){
    // s1.push(data);
    // }
    // public int remove(){

    // }
    // }

    static class StackQ {
        static Queue<Integer> q1 = new LinkedList<>();
        static Queue<Integer> q2 = new LinkedList<>();

        public boolean isEmpty() {
            return q1.isEmpty() && q2.isEmpty();
        }

        public void push(int data) {
            if (!q1.isEmpty()) {
                q1.add(data);
            } else {
                q2.add(data);
            }
        }

        public int pop() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            int top = -1;
            // case 1
            if (!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    top = q1.remove();
                    if (q1.isEmpty()) {
                        break;
                    }
                    q2.add(top);
                }
                
            } 
             // case 2
            else {
                while(!q2.isEmpty()){
                    top=q2.remove();
                    if(q2.isEmpty()){
                        break;
                    }
                    q1.add(top);
                }
            }
            return top;
        }
        public int peek(){
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            int top = -1;
            // case 1
            if (!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    top = q1.remove();
                    q2.add(top);
                }
                
            } 
             // case 2
            else {
                while(!q2.isEmpty()){
                    top=q2.remove();
                    q1.add(top);
                }
            }
            return top;
        }
    }

    public static void main(String[] args) {
        // implement using cicular queue or array
        // CQueue q=new CQueue(5);
        // QueueL q=new QueueL();

        // using stl
        // or we may use ArrayDeque
        // Queue<Integer> q=new LinkedList<>();

        // using 2 stacks

        QueueS q = new QueueS();
        q.add(4);
        q.add(7);
        q.add(4);
        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }

        // stack using 2 queue 
System.out.println("stack using 2 queue");
        StackQ sq=new StackQ();
        sq.push(0);
        sq.push(34);
        sq.push(3);
        while(!sq.isEmpty()){
            System.out.println(sq.peek());
            sq.pop();
        }
    }
}

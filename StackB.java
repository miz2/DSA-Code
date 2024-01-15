import java.util.*;
public class StackB {
    static class StackA {
        static ArrayList<Integer> list = new ArrayList<>();

        public boolean isEmpty() {
            return list.size() == 0;
        }

        // push
        public void push(int data) {
            list.add(data);
        }

        // pop
        public int pop() {
            if (isEmpty() == true) {
                return -1;
            }
            int top = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            return top;
        }

        // peek
        public int peek() {
            if (isEmpty() == true) {
                return -1;
            }
            int top = list.get(list.size() - 1);
            return top;
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

static class StackL {
    Node head = null;

    public boolean isEmpty() {
        return head == null;
    }

    public void push(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public int pop() {
        if (isEmpty()) {
            return -1;
        }
        int top = head.data;
        head = head.next;
        return top;
    }

    public int peek() {
        if (isEmpty()) {
            return -1;
        }
        return head.data;
    }
}

public static void main(String[] args) {
    // StackL s = new StackL();
    Stack<Integer> s=new Stack <>();
    s.push(1);
    s.push(2);
    s.push(3);
    while (!s.isEmpty()) {
        System.out.println(s.peek());
        s.pop();
    }
}
}
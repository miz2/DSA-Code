
public class LL {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    // methods add() remove() print() search()
    public void addFirst(int data) {
        // step 1 create new node
        Node newNode = new Node(data);
        size++;
        // empty ll
        if (head == null) {
            head = tail = newNode;
            return;
        }

        // step 2:newNode next =head
        // linking
        newNode.next = head;
        // step3:change head
        head = newNode;

    }

    public void addLast(int data) {

        // step 1 create new node
        Node newNode = new Node(data);
        size++;
        // empty ll
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public void addAtIndex(int data, int index) {

        if (index == 0) {
            addFirst(data);
            return;
        }

        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;
        while (i < index - 1) {
            temp = temp.next;
            i++;
        }
        // i=index-1 temp ->prev
        newNode.next = temp.next;
        temp.next = newNode;

    }

    public void traversal() {
        if (head == null) {
            System.out.println("empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public int removeFirst() {

        if (size == 0) {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int removeLast() {
        if (size == 0) {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        Node prev = head;
        for (int i = 0; i < size - 2; i++) {
            prev = prev.next;
        }
        int val = prev.next.data; // or tail.data
        prev.next = null;
        size--;
        tail = prev;
        return val;
    }

    public int iterativeSearch(int key) {
        int i = 0;
        Node temp = head;
        if (size == 0) {
            System.out.println("Ll is empty");
            return -1;
        }
        while (temp != null) {
            if (temp.data == key) {
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }

    public int helper(Node head, int key) {
        // base case
        if (head == null) {
            return -1;
        }
        // kaam
        if (head.data == key) {
            return 0;
        }
        int idx = helper(head.next, key);
        if (idx == -1) {
            // if not found
            return -1;
        }
        // original head changes hence add 1
        return idx + 1;
    }

    public int recursiveSearch(int key) {
        return helper(head, key);
    }

    public void reverse() {
        Node prev = null;
        Node curr = tail = head;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public void deletefromnth(int n) {
        size--;
        // calculate size
        int sz = 0;
        Node temp = head;
        while (temp != head) {
            temp = temp.next;
            sz++;
        }
        if (n == size) {
            // remove 1st
            head = head.next;
            return;
        }
        // size-n
        int i = 1;
        int find = sz - n;
        Node prev = head;
        while (i < find) {
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return;
    }

    // slow fast approach
    public Node findMidNode(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // slow is middle node
        return slow;
    }

    public boolean checkPallindrome() {
        if (head == null || head.next == null) {
            return true;
        }
        // step 1 find mid
        Node midNode = findMidNode(head);
        // step 2 reverse 2nd half
        Node prev = null;
        Node curr = midNode;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        // right half head
        Node right = prev;
        // check left and right half
        Node left = head;
        while (right != null) {
            if (left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    public static boolean cycle() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void removeCycle() {
        // detect cycle
        Node slow = head;
        Node fast = head;
        boolean cycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                cycle = true;
                break;
            }
        }

        if (cycle == false) {
            return;
        }
        // reinitialize value of slow and finding meeting point
        slow = head;
        Node prev = null;
        // prev will get the meeting point
        while (slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }
        // removing the cycle
        prev.next = null;
    }
    private Node getMid(Node head){
        Node slow=head;
        Node fast=head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    private Node merge(Node head1,Node head2){
        Node mergedLL=new Node(-1);
        Node temp=mergedLL;
        while(head1!=null && head2!=null){
            if(head1.data<=head2.data){
                temp.next=head1;
                head1=head1.next;
                temp=temp.next;
            }
            else{
                temp.next=head2;
                head2=head2.next;
                temp=temp.next;
            }
        }
        while(head1!=null){
            temp.next=head1;
            head1=head1.next;
            temp=temp.next;
        }
        while(head2!=null){
            temp.next=head2;
            head2=head2.next;
            temp=temp.next;
        }
        return mergedLL.next;
    }
    public Node mergeSort(Node head){
        if(head==null || head.next==null){
            return head;
        }
        // find middle 
        Node mid=getMid(head);
        // left and right half 
        Node rightHead=mid.next;
        mid.next=null;
       Node newLeft= mergeSort(head);
       Node newright= mergeSort(rightHead);
        // merge
        return merge(newLeft,newright);
    }
    public void zigZag(){
        // find middle
        Node slow=head;
        Node fast=head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        Node mid=slow;
        // reverse 2nd half 
        Node curr=mid.next;
        Node prev=null;
        // breaking the ll
        Node next;
        mid.next=null;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        Node left=head;
        Node right=prev;
        Node nl,nr;
        while(left!=null && right!=null){
            nl=left.next;
            left.next=right;
            nr=right.next;
            right.next=nl;
            left=nl;
            right=nr;
        }
        // alternate merge 
    }
    public static void main(String[] args) {
        // LL l=new LL();
        // l.traversal();
        // l.addFirst(1);
        // l.traversal();
        // l.addFirst(2);
        // l.traversal();
        // l.addLast(4);
        // l.traversal();
        // l.addLast(3);
        // l.traversal();
        // l.addAtIndex(34, 2);
        // l.traversal();
        // System.out.println("size of Linked list"+size);
        // l.removeFirst();
        // l.traversal();
        // System.out.println(l.iterativeSearch(1));
        // System.out.println(l.recursiveSearch(1));
        // l.removeLast();
        // l.traversal();
        // l.reverse();
        // l.traversal();

        // for cycle :or not
        // head = new Node(1);
        // Node temp=new Node(2);
        // head.next = temp;
        // head.next.next = new Node(3);
        // head.next.next.next = temp;
        // // 1-2-3-2
        // System.out.println(cycle());
        // removeCycle();
        //  System.out.println(cycle());

        //  sorted LL
        // LL l=new LL();
        // l.addFirst(1);
        // l.addFirst(3);
        // l.addFirst(4);
        // l.addFirst(2);
        // l.addFirst(5);
        // l.traversal();
        // // l.head=l.mergeSort(l.head);
      
        // l.traversal();

        // zig zag ll
        LL l=new LL();
        l.addFirst(5);
        l.addFirst(4);
        l.addFirst(3);
        l.addFirst(2);
        l.addFirst(1);
        l.traversal();
        l.zigZag();
        l.traversal();
    }
}

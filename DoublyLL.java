public class DoublyLL {
    public class Node{
        int data;
        Node next;
        Node prev;
        public Node(int data){
            this.data=data;
            this.next=null;
            this.prev=null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;

    // add 
    public void addFirst(int data){
        Node newNode=new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return;
        }
        newNode.next=head;
        head.prev=newNode;
        head=newNode;
    }
    public void traversal(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"<->");
            temp=temp.next;
        }
        System.out.println("null");
    }
    public int removeFirst(){
       
        if(head==null){
            System.out.println("DLL is empty");
            return Integer.MIN_VALUE;
        }
        if(size==1){
            int val=head.data;
            head=null;
            tail=null;
             size--;
            return val;
            
        }
        int val=head.data;
        head=head.next;
        head.prev=null;
         size--;
        return val;
    }
   public void reverse(){
    Node curr=head;
    Node prev=null;
    Node next;
    while(curr!=null){
        next=curr.next;
        curr.next=prev;
        curr.prev=next;
        prev=curr;
        curr=next;

    }
    head=prev;
   }
    public static void main(String[] args) {
        DoublyLL dll=new DoublyLL();
        dll.addFirst(34);
        dll.addFirst(45);
        dll.traversal();
        // System.out.println(size);
        // dll.removeFirst();
         dll.traversal();
        System.out.println(size);
        dll.reverse();
        dll.traversal();
    }
}

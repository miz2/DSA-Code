import java.util.ArrayList;

public class MirrorBST {
    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data=data;
            this.left=this.right=null;
        }
    }
    public static Node createMirror(Node root){
        if(root==null){
            return null;
        }
        Node leftMirror=createMirror(root.left);
        Node rightMirror=createMirror(root.right);
        root.left=rightMirror;
        root.right=leftMirror;
        return root;

    }
    public static void preOrder(Node root){
        if(root==null){
            return;
        }
        System.out.println(root.data);
        preOrder(root.left);
        preOrder(root.right);
    }
    public static Node sortedArrToBST(int arr[],int start,int end){
        if(start>end){
            return null;
        }
        int mid=(start+end)/2;
        Node root=new Node(arr[mid]);
        // left subtree
        root.left=sortedArrToBST(arr, start, mid-1);
        root.right=sortedArrToBST(arr, mid+1, end);
        return root;
    }
    public static Node createBST(ArrayList<Integer> inorder,int st,int end){
         if(st>end){
            return null;
        }
        int mid=(st+end)/2;
        Node root=new Node(inorder.get(mid));
        root.left=createBST(inorder, st, mid-1);
        root.right=createBST(inorder, mid+1, end);
        return root;
    }
    public static void getinOrder(Node root,ArrayList <Integer> inorder){
        if(root==null){
            return;
        }
        getinOrder(root.left, inorder);
        inorder.add(root.data);
        getinOrder(root.right, inorder);
    }
    public static Node balanceBST(Node root){
        // inorder seqeunce 

        ArrayList <Integer>inorder=new ArrayList<>();
        getinOrder(root, inorder);
        // sorted inorder to bst 
         root=createBST(inorder, 0, inorder.size()-1);
        return root;
    }
    static class Info{
        boolean isBST;
        int size;
        int min;
        int max;
        public Info(boolean isBST,int size,int min,int max){
            this.isBST=isBST;
            this.size=size;
            this.min=min;
            this.max=max;
        }
    }
    public static int maxBST=0;
    public static Info largestBST(Node root){
        if(root==null){
            return new Info(true,0,Integer.MAX_VALUE,Integer.MIN_VALUE);
        }
        Info leftInfo=largestBST(root.left);
        Info rightInfo=largestBST(root.right);
        int size=leftInfo.size+rightInfo.size+1;
        int min=Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));
        int max=Math.max(root.data, Math.max(leftInfo.max, rightInfo.max));
        if(root.data<=leftInfo.max||root.data>=rightInfo.min){
            return new Info(false, size, min, max);
        }
        if(leftInfo.isBST && rightInfo.isBST){
            maxBST=Math.max(maxBST, size);
            return new Info(true, size, min, max);
        }
        return new Info(false, size, min, max);
    }
    public static void main(String[] args) {
        // mirror of bst
        // Node root=new Node(8);
        // root.left=new Node(5);
        // root.right=new Node(10);
        // root.left.left=new Node(3);
        // root.left.right=new Node(6);
        // root.right.right=new Node(11);
        // root=createMirror(root);
        // preOrder(root);
        // ques 2
        // sorted array to bst 

        // int arr[]={3,5,6,8,10,11,12};
        // Node root2=sortedArrToBST(arr, 0, arr.length-1);
        // preOrder(root2);

        // ques 3
         Node root3=new Node(8);
        root3.left=new Node(6);
        root3.left.left=new Node(5);
        root3.left.left.left=new Node(3);

        root3.right=new Node(10);
        root3.right.right=new Node(11);
        root3.right.right.right=new Node(12);
       root3= balanceBST(root3);
       preOrder(root3);

    //    ques 4 

    Node root4=new Node(50);
    root4.left=new Node(30);
    root4.left.left=new Node(5);
    root4.left.right=new Node(20);
    root4.right=new Node(60);
    root4.right.left=new Node(45);
    root4.right.right=new Node(70);
    root4.right.right.left=new Node(65);
    root4.right.right.right=new Node(80);
   Info info=largestBST(root4);
   System.out.println(info);
   System.out.println("largest size of bst:"+maxBST);
    }
}

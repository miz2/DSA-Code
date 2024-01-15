import java.util.ArrayList;

public class BST {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
        }
    }
    public static Node insert(Node root,int val){
        if(root==null){
            root=new Node(val);
            return root;
        }
        if(root.data>val){
            // left subtree
           root.left= insert(root.left, val);
        }
        else{
            root.right=insert(root.right, val);
        }
        return root;
    }
    public static void inOrder(Node root){
        if(root==null){
            return;
        }
        inOrder(root.left);
        System.out.println(root.data+" ");
        inOrder(root.right);
    }
    public static boolean search(Node root,int key){
        if(root==null){
            return false;
        }
        if(root.data==key){
            return true;
        }
        if(root.data>key){
           return search(root.left, key);
        }
        else{
          return search(root.right, key); 
        }

    }
    public static Node delete(Node root,int val){
        if(root.data<val){
            root.right=delete(root.right, val);
        }
        else if(root.data>val){
            root.left=delete(root.left, val);
        }
        else{
            // case 1
            if(root.left==null && root.right==null){
                return null;
            }
            // case 2
            if(root.right==null){
                return root.left;
            }
            else if(root.left==null){
                return root.right;
            }
            // case 3
           Node IS= findINOrderSucc(root.right);
           root.data=IS.data;
          root.right= delete(root.right, val);

        }
        return root;
    }
    public static Node findINOrderSucc(Node root){
        while(root.left!=null){
            root=root.left;
        }
        return root;
    }
    public static void printRange(Node root, int k1, int k2) {
        if (root == null) {
            return;
        }
    
        if (root.data >= k1 && root.data <= k2) {
            printRange(root.left, k1, k2);
            System.out.print(root.data + " ");
            printRange(root.right, k1, k2);
        } else if (root.data < k1) {
            printRange(root.left, k1, k2);
        } else {
            printRange(root.right, k1, k2);
        }
    }
    public static void printRootToLeaf(Node root, ArrayList <Integer> path){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            System.out.println(path);
        }
        path.add(root.data);
        printRootToLeaf(root.left, path);
        printRootToLeaf(root.right, path);
        path.remove(path.size()-1);
    }
    public static boolean isValid(Node root,Node min,Node max){
        if(root==null){
            return true;
        }
        if(min!=null && root.data<=min.data){
            return false;
        }
        else if(max!=null && root.data>=max.data){
            return false;
        }
        return isValid(root.left, min, root) && isValid(root.right, root, max);
    }
    
    public static void main(String[] args) {
        int values[]={5,1,3,4,2,7};
        int valu[]={8,5,3,1,4,6,10,11,14};
        Node root=null;
        Node root2=null;
        for(int i=0;i<values.length;i++){
            root=insert(root, values[i]);
        }
        inOrder(root);
        System.out.println(search(root, 5));
        for(int i=0;i<valu.length;i++){
            root2=insert(root2, valu[i]);
        }
        delete(root2, 1);
        inOrder(root2);
        System.out.println();
        printRange(root2, 5, 12);
        System.out.println("Printing all paths to root");
        printRootToLeaf(root2, new ArrayList<>());
        System.out.println(isValid(root2, null, null));
        
    }
}

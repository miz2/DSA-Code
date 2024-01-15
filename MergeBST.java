import java.util.ArrayList;

public class MergeBST {
    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data=data;
            this.left=this.right=null;
        }
    }
     public static void getinOrder(Node root,ArrayList <Integer> inorder){
        if(root==null){
            return;
        }
        getinOrder(root.left, inorder);
        inorder.add(root.data);
        getinOrder(root.right, inorder);
    }
    public static Node createBST(ArrayList <Integer> arr,int st,int end){
        if(st>end){
            return null;
        }
        int mid=(st+end)/2;
        Node root=new Node(arr.get(mid));
        root.left=createBST(arr, st, mid-1);
        root.right=createBST(arr, mid+1, end);
        return root;
    }
    public static Node mergeBST(Node root1, Node root2) {
        // get Inorder for root1
        ArrayList<Integer> arr1 = new ArrayList<>();
        getinOrder(root1, arr1);
        ArrayList<Integer> arr2 = new ArrayList<>();
        getinOrder(root2, arr2);
    
        // merge
        int i = 0, j = 0;
        ArrayList<Integer> finalArr = new ArrayList<>();
        while (i < arr1.size() && j < arr2.size()) {
            if (arr1.get(i) <= arr2.get(j)) {
                finalArr.add(arr1.get(i));
                i++;
            } else {
                finalArr.add(arr2.get(j));
                j++;
            }
        }
        // Add remaining elements from arr1, if any
        while (i < arr1.size()) {
            finalArr.add(arr1.get(i));
            i++;
        }
        // Add remaining elements from arr2, if any
        while (j < arr2.size()) {
            finalArr.add(arr2.get(j));
            j++;
        }
    
        // sorted arraylist to BST
        return createBST(finalArr, 0, finalArr.size() - 1);
    }
    
    public static void preOrder(Node root){
        if(root==null){
            return;
        }
        System.out.println(root.data);
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void main(String[] args) {
        Node root1=new Node(2);
        root1.left=new Node(1);
        root1.right=new Node(4);
        Node root2=new Node(9);
        root2.left=new Node(3);
        root2.right=new Node(12);
        Node root=mergeBST(root1, root2);
        preOrder(root);

    }
}

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeImp {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {
        static int index = -1;

        public Node buildTree(int nodes[]) {
            index++;
            if (nodes[index] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[index]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }
    }

    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.data);
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static void postOrder(Node root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    public static void level(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            Node curr = q.remove();
            if (curr == null) {
                System.out.println();
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                System.out.print(curr.data + " ");
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
        }
    }

    public static int countNodes(Node root) {
        if (root == null) {
            return 0;
        }
        int lf = countNodes(root.left);
        int rf = countNodes(root.right);
        return lf + rf + 1;
    }

    public static int sumOfNodes(Node root) {
        if (root == null) {
            return 0;
        }
        int ls = sumOfNodes(root.left);
        int rs = sumOfNodes(root.right);
        return ls + rs + root.data;
    }

    public static int heightofTree(Node root) {
        if (root == null) {
            return 0;
        }
        int lh = heightofTree(root.left);
        int rh = heightofTree(root.right);
        int myHeight = Math.max(lh, rh) + 1;
        return myHeight;
    }

    public static int diameter(Node root) {
        if (root == null) {
            return 0;
        }
        int d1 = diameter(root.left);
        int d2 = diameter(root.right);
        int d3 = heightofTree(root.left) + heightofTree(root.right) + 1;
        return Math.max(d1, Math.max(d2, d3));
    }

    static class treeInfo {
        int ht;
        int diam;

        treeInfo(int ht, int diam) {
            this.ht = ht;
            this.diam = diam;
        }
    }

    public static treeInfo diameterOp(Node root) {
        if (root == null) {
            return new treeInfo(0, 0);
        }
        treeInfo left = diameterOp(root.left);
        treeInfo right = diameterOp(root.right);

        int myHeight = Math.max(left.ht, right.ht) + 1;
        int d1 = left.diam;
        int d2 = right.diam;
        int d3 = left.ht + right.ht + 1;
        int mydiam = Math.max(Math.max(d1, d2), d3);
        treeInfo myinf = new treeInfo(myHeight, mydiam);
        return myinf;
    }

    public static boolean isIdentical(Node root, Node subroot) {
        if (root == null && subroot == null) {
            return true;
        }
        // if one is null but other is not null
        if (root == null || subroot == null) {
            return false;
        }
        // check for right and left
        if (root.data == subroot.data) {
            return isIdentical(root.left, subroot.left) && isIdentical(root.right, subroot.right);
        }
        return false;
    }

    public static boolean isSubtree(Node root, Node subroot) {
        if (subroot == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        if (root.data == subroot.data) {
            if (isIdentical(root, subroot)) {
                return true;
            }
        }
        // if not true goto either left or right subtree
        return isSubtree(root.left, subroot) || isSubtree(root.right, subroot);
    }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        Node r1=  new Node(1);
        r1.left=new Node(2);
        r1.right=new Node(3);
        r1.left.left=new Node(4);
        r1.left.right=new Node(5);
        r1.right.left=new Node(6);
        r1.right.right=new Node(7);
        Node subRoot = new Node(2);
        subRoot.left=new Node(4);
        subRoot.right=new Node(5);
        System.out.println(root.data);
        System.out.println("Pre order traversal");
        preOrder(root);
        preOrder(subRoot);
        System.out.println("In order traversal");
        inOrder(root);
        System.out.println();
        System.out.println("Post order traversal");
        postOrder(root);
        System.out.println();
        System.out.println("Level order traversal");
        level(root);
        System.out.println("Total Nodes: " + countNodes(root));
        System.out.println("Sum of all Nodes:" + sumOfNodes(root));
        System.out.println("Height of tree:" + heightofTree(root));
        System.out.println("Diameter of tree:" + diameter(root));
        System.out.println("Diamter of tree:" + diameter(root));
        System.out.println("IS Subtree or not:"+isSubtree(r1, subRoot));
    }
}

package BinaryTree;


public class BinarySearchTree {

    private TreeNode root;
    
    private class TreeNode {
        private int data;
        private TreeNode left;
        private TreeNode right;
        
        public TreeNode(int data) {
            this.data = data;
        }
    }
    
    // Insert a value in a Binary Search  (Recursion Method) 
    public void insert(int value) {
        root = insert(root, value);
    }
    // Recursive method for inserting node to the binary search tree
    public TreeNode insert(TreeNode root, int value) {
        if(root == null) {
            root = new TreeNode(value);
            return root;
        }
        if (value < root.data) {
            root.left = insert(root.left, value);
        } else {
            root.right = insert(root.right, value);
        }
        return root;
    }

    // Inorder travesing

    public void inOrder() {
        inOrder(root);
    }

    public void preOrder() {
        preOrder(root);
    }

    // Search
    public TreeNode search(int key){
        return search(root, key);
    }

    // isValid
    public boolean isValid(int min, int max){
        return isValid(root, min, max);
    }

    public void inOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public void preOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public TreeNode search(TreeNode root, int key) {
        if(root == null || root.data == key) {
            return root;
        }
        if (key < root.data) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }
    }

    // Validate binary search tree
    boolean isValid(TreeNode root, long min, long max) {
        if(root == null) {
            return true;
        }
        if(root.data <= min || root.data >= max) {
            return false;
        }
        boolean left = isValid(root.left, min, root.data);
        if(left) {
            boolean right = isValid(root.right, root.data, max);
            return right;
        }
        return false; 
    }
    
    public static void main(String[] args){
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(20);
        bst.insert(15);
        bst.insert(25);
        bst.insert(10);
        bst.insert(18);
        bst.insert(22);
        bst.insert(30);
        bst.insert(40);
        bst.preOrder();

        // if(null != bst.search(10)) {
        //     System.out.println("Key is found");
        // } else{
        //     System.out.println("Key is not found");
        // }
        
        // boolean isValid = (bst.isValid(10, 30 ));
        // if (isValid){
        //     System.out.println("The binary search tree is valid");
        // } else {
        //     System.out.println("The binary search tree is not valid");
        // }
        

    }
}

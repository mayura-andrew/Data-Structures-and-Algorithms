package BinaryTree;

import java.util.Stack;

public class BinaryTree {

    private  TreeNode root;

    private class TreeNode{
        private TreeNode left;
        private TreeNode right;
        private int data; // genetic type

        public TreeNode(int data) {
            this.data = data;
        }
    }

    public void createBinaryTree() {
        TreeNode first = new TreeNode(9);
        TreeNode second = new TreeNode(2);
        TreeNode third = new TreeNode(3);
        TreeNode fourth = new TreeNode(4);
        TreeNode fifth = new TreeNode(5);

        root = first; // root ---> first
        first.left = second;
        first.right = third;  // second <---- first ----> third

        second.left = fourth;
        second.right = fifth;
    }


    // Recursive PreOrder traversal of a Binary Tree
    // public void preOrder(TreeNode root) {
    //     if(root == null) {
    //         return;
    //     }
    //     System.out.print(root.data + " ");
    //     preOrder(root.left);
    //     preOrder(root.right);
    // }

    // Iterative Preorder traversal of a Binary Tree

    public void preOrder() {
        if(root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            System.out.print(temp.data + " ");
            if(temp.right != null) {
                stack.push(temp.right);
            }
            if(temp.left != null) {
                stack.push(temp.left);
            } 
        }
    }

    // Recursive inorder traveral of Ba=inary tree
    // public void inOrder(TreeNode root) {
    //     if(root == null) {
    //         return;
    //     }
    //     inOrder(root.left);
    //     System.out.print(root.data + " ");
    //     inOrder(root.right);
    // }


    // Iterative Inorder traversal of a Binary Tree
    public void inOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;

        while(!stack.isEmpty() || temp != null) {
            if(temp != null) {
                stack.push(temp);
                temp = temp.left;
            } else {
                temp = stack.pop();
                System.out.print(temp.data + " ");
                temp = temp.right;
            }
        }
    }

    // Post Order Recursive Traversal

    public void postOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    // Iterative Postorder Traversal of a Binary Tree
    public void postOrder() {
        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<>();

        while(current != null || !stack.isEmpty()){
            if(current != null) {
                stack.push(current);
                current = current.left;
            } else {
                TreeNode temp = stack.peek().right;
                if(temp == null) {
                    temp = stack.pop();
                    System.out.print(temp.data + " ");
                    while (!stack.isEmpty() && temp == stack.peek().right) {
                        temp = stack.pop();
                        System.out.print(temp.data + " "); 
                    } 
                } else {
                        current = temp;
                }
            }
        }
    }


    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.createBinaryTree();
        //   bt.preOrder();
        //   bt.inOrder(bt.root);
        //   bt.postOrder(bt.root);
        bt.postOrder();
    }
}

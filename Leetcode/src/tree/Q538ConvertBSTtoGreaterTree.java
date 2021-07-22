package tree;

import structures.TreeNode;

import java.util.Stack;

public class Q538ConvertBSTtoGreaterTree {

    int sum = 0;

    /**
     * Method 2: recursion
     *
     * Results: runtime 0ms beats 100.00% memory 38.7mb beats 40.26%
     * */
    public TreeNode convertBST2(TreeNode root) {
        recursion(root);
        return root;
    }

    private void recursion(TreeNode node){
        if(node != null){
            recursion(node.right);
            node.val = sum + node.val;
            sum = node.val;
            recursion(node.left);
        }
    }


    /**
     * Method 1: reverse inorder traversal
     *
     * Results: runtime 3ms beats 5.11% memory 38.8 beats 19.21%
     * */
    public TreeNode convertBST(TreeNode root) {
        int sum = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.right;
            } else {
                TreeNode cur = stack.pop();
                sum += cur.val;
                cur.val = sum;
                node = cur.left;
            }
        }
        return root;
    }
}

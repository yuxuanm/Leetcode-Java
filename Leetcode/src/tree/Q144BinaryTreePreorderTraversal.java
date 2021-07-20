package tree;


import structures.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q144BinaryTreePreorderTraversal {

    /**
     * Method 1: use stack, iteration
     *
     * Results: runtime 0ms beats 100% memory 36.6 mb beats 69.86%
     * */
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null)
            return new ArrayList<Integer>();
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node;
        stack.add(root);
        while (!stack.isEmpty()) {
            node = stack.pop();
            res.add(node.val);
            if (node.right != null)
                stack.add(node.right);
            if (node.left != null)
                stack.add(node.left);
        }
        return res;

    }
}

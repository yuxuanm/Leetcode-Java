package array;

import structures.TreeNode;

public class Q543DiameterofBinaryTree {
    int max = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        Q543DiameterofBinaryTree q543DiameterofBinaryTree = new Q543DiameterofBinaryTree();
        int res = q543DiameterofBinaryTree.diameterOfBinaryTree(root);
        System.out.println(res);
    }

    /**
     * Method 1: recursion, DFS
     *
     * results: runtime 0ms beats 100% memory 38.3mb beats 54.82%
     * */
    public int diameterOfBinaryTree(TreeNode root) {
        getDepth(root);
        return max;
    }

    private int getDepth(TreeNode node) {
        if (node == null) // end condition
            return -1;
        int leftDepth = getDepth(node.left) + 1;
        int rightDepth = getDepth(node.right) + 1;
        int nodeDepth = leftDepth + rightDepth;
        int maxBranch = leftDepth>rightDepth? leftDepth:rightDepth;
        max = nodeDepth > max ? nodeDepth : max;
        return maxBranch;
    }
}

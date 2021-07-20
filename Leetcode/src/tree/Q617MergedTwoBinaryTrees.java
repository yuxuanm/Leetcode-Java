package tree;

import structures.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Q617MergedTwoBinaryTrees {

    /**
     * Method1: recursive
     * <p>
     * runtime : 0ms beats 100% memory 38.6mb beats 71.2%.
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null)
            return root2;
        if (root2 == null)
            return root1;

        TreeNode res = new TreeNode(root1.val + root2.val);
        res.left = mergeTrees(root1.left, root2.left);
        res.right = mergeTrees(root1.right, root2.right);
        return res;
    }

    /**
     * Method2: BFS
     * use three queues, one stores merged nodes, one stores left tree, and last one stores right tree
     * <p>
     * Results: runtime 1ms beats 39.81% memory 38.4mb beats 90.86%
     */
    public TreeNode mergeTrees2(TreeNode root1, TreeNode root2) {
        if (root1 == null)
            return root2;
        if (root2 == null)
            return root1;

        Queue<TreeNode> queue = new LinkedList<TreeNode>(); // merged tree nodes
        Queue<TreeNode> queue1 = new LinkedList<TreeNode>(); // nodes from root1
        Queue<TreeNode> queue2 = new LinkedList<TreeNode>(); // nodes from root2
        TreeNode res = new TreeNode(root1.val + root2.val);
        queue.add(res);
        queue1.add(root1);
        queue2.add(root2);
        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            TreeNode node1 = queue1.poll(), node2=queue2.poll(), node = queue.poll();
            TreeNode left1 = node1.left, left2 = node2.left, right1 = node1.right, right2 = node2.right;
            if (node1 != null && node2 != null) {
                if (left1 != null && left2 != null) {
                    TreeNode node_l = new TreeNode(left1.val + left2.val);
                    node.left = node_l;
                    queue.add(node_l);
                    queue1.offer(left1);
                    queue2.offer(left2);
                } else if (left1 == null)
                    node.left = left2;
                else if (left2 == null)
                    node.left = left1;

            } else if (node1 == null) {
                node.left = node2.left;
            } else if (node2 == null) {
                node.left = node1.left;
            }

            if (node1 != null || node2 != null) {
                if (right1 != null && right2 != null) {
                    TreeNode node_r = new TreeNode(right1.val + right2.val);
                    node.right = node_r;
                    queue.offer(node_r);
                    queue1.offer(right1);
                    queue2.offer(right2);
                } else if (right1 == null)
                    node.right = right2;
                else if (right2 == null)
                    node.right = right1;
            } else if (node1 == null)
                node.right = node2.right;
            else if (node2 == null)
                node.right = node1.right;

        }
        return res;
    }
}

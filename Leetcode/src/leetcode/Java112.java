package leetcode;

public class Java112 {
	public static void main(String[] args) {
//		Integer[] array = new Integer[]{5,4,8,11,null,13,4,7,2,null,null,null,1};
		
		Integer[] array = new Integer[]{-2,null,-3};
		TreeNode root = convert(array);
		System.out.println(hasPathSum(root,-5));
	}
	public static boolean hasPathSum(TreeNode root,int sum) {
		int cur=0;
		return hasPathSum(root,sum,cur);
	}
	
	public static boolean hasPathSum(TreeNode root, int sum,int cur) {
		if (root == null)
			return false;
		cur += root.val;
		if (root.left == null && root.right == null && cur != sum)
			return false;
		if (cur == sum&&root.left==null&&root.right==null)
			return true;
		return hasPathSum(root.left, sum,cur) || hasPathSum(root.right, sum,cur);
	}

	public static TreeNode convert(Integer[] array) {
        int floor = 0, count = 0;
        TreeNode[] treeNodes = new TreeNode[array.length];
        while (array != null && count < array.length) {
            int start = (int) Math.pow(2, floor) - 1;
            int end = (int) Math.pow(2, floor + 1) - 1;
            if (end > array.length) {
                end = array.length;
            }
            for (int i = start; i < end; i++) {
                if (array[i] != null) {
                    treeNodes[i] = new TreeNode(array[i]);
                } else {
                    treeNodes[i] = null;
                }
                if (i > 0) {
                    int parent = (i - 1) / 2;
                    if (parent >= 0) {
                        TreeNode pNode = treeNodes[parent];
                        if (pNode != null) {
                            if (i % 2 == 1) {
                                pNode.left = treeNodes[i];
                            } else {
                                pNode.right = treeNodes[i];
                            }
                        }
                    }
                }
                count++;
            }
            floor++;
        }
        return treeNodes[0];
    }


}

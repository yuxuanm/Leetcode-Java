package leetcode;

public class Java101 {
	public static void main(String[] args) {
		String a = "leftright";
		String b = a.replace("left", "");
		System.out.println(b);
	
		TreeNode101 root = new TreeNode101(1);

	}
}

class TreeNode101 {
	int val;
	TreeNode101 left;
	TreeNode101 right;

	TreeNode101(int x) {
		val = x;
	}
}
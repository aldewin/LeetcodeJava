package easy;

/**
 * 112. Path Sum
 *
 * https://leetcode.com/problems/path-sum/
 */

public class PathSum {
    public static void main(String[] args) {

    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return root.val == sum;
        }
        return hasPathSum(root.left, sum - root.val) ||
                hasPathSum(root.right, sum - root.val);
    }
}

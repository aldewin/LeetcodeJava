package medium; /**
 * 102. Binary Tree Level Order Traversal
 *
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 */

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(50, new TreeNode(25), new TreeNode(75));
        TreeNode node2 = new TreeNode(200, null, new TreeNode(250));
        TreeNode root = new TreeNode(100, node1, node2);
        System.out.println(levelOrder(root));
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<TreeNode> s1 = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        s1.add(root);
        while (!s1.isEmpty()) {
            int length = s1.size();
            for (int i = 0; i < length; i++) {
                TreeNode n = s1.poll();
                list.add(n.val);
                if (n.left != null)
                    s1.add(n.left);
                if (n.right != null)
                    s1.add(n.right);
            }
            if (!list.isEmpty())
                res.add(new ArrayList<>(list));
            list.clear();
        }
        return res;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {

    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


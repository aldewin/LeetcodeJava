package medium; /**
 * 103. Binary Tree Zigzag Level Order Traversal
 *
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        TreeNode root = new TreeNode(3, node1, node2);
        System.out.println(zigzagLevelOrder(root));

    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;
        Stack<TreeNode> s1 = new Stack<>(); // Left to Right
        Stack<TreeNode> s2 = new Stack<>(); // Right to Left
        s1.push(root);
        List<Integer> list = new ArrayList<>();
        while (!s1.isEmpty() || !s2.isEmpty()) {
            while (!s1.isEmpty()) {
                TreeNode n = s1.pop();
                list.add(n.val);
                if (n.left != null)
                    s2.push(n.left);
                if (n.right != null)
                    s2.push(n.right);
            }
            if (!list.isEmpty())
                result.add(new ArrayList<>(list));
            list.clear();
            while (!s2.isEmpty()) {
                TreeNode n = s2.pop();
                list.add(n.val);
                if (n.right != null)
                    s1.push(n.right);
                if (n.left != null)
                    s1.push(n.left);
            }
            if (!list.isEmpty())
                result.add(new ArrayList<>(list));
            list.clear();
        }
        return result;
    }

}


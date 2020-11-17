package medium; /**
 * 116. Populating Next Right Pointers in Each Node
 *
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 */

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode {
    public static void main(String[] args) {
        Node node7 = new Node(7);
        Node node6 = new Node(6, null, null, node7);
        Node node5 = new Node(5, null, null, node6);
        Node node4 = new Node(4, null, null, node5);
        Node node3 = new Node(3, node6, node7, null);
        Node node2 = new Node(2, node4, node5, node3);
        Node root = new Node(1, node2, node3,null);
        System.out.println(connect(root));
    }

    public static Node connect(Node root) {
        if (root == null)
            return null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node == null && queue.isEmpty())
                return root;
            if (node == null)
                queue.add(null);
            else {
                node.next = queue.peek();
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
        }
        return root;
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

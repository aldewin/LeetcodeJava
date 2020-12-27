package easy;

/**
 * 141. Linked List Cycle
 *
 * https://leetcode.com/problems/linked-list-cycle/
 */

public class LinkedListCycle {
    public static void main(String[] args) {

    }

    public static boolean hasCycle(ListNode head) {
        if (head == null)
            return false;

        ListNode fast = head;
        ListNode slow = head;
        while (true) {
            if (fast == null || fast.next == null)
                return false;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)
                return true;
        }
    }
}

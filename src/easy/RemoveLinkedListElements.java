package easy;

/**
 * 203. Remove Linked List Elements
 *
 * https://leetcode.com/problems/remove-linked-list-elements/
 */

public class RemoveLinkedListElements {
    public static void main(String[] args) {
        ListNode head6 = new ListNode(6);
        ListNode head5 = new ListNode(5, head6);
        ListNode head4 = new ListNode(4, head5);
        ListNode head3 = new ListNode(3, head4);
        ListNode head6_1 = new ListNode(6, head3);
        ListNode head2 = new ListNode(2, head6_1);
        ListNode head1 = new ListNode(1, head2);
        System.out.println(removeElements(head1, 6));
    }

    public static ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val)
            head = head.next;

        if (head == null)
            return null;

        ListNode cur = head;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

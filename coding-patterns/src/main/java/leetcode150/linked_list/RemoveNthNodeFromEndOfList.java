package leetcode150.linked_list;

import leetcode150.ListNode;

public class RemoveNthNodeFromEndOfList {

    public static void main(String args[]) {
        ListNode tn5 = new ListNode(5);
        ListNode tn4 = new ListNode(4, tn5);
        ListNode tn3 = new ListNode(3, tn4);
        ListNode tn2 = new ListNode(2, tn3);
        ListNode tn1 = new ListNode(1, tn2);
        ListNode ln = removeNthFromEnd2(tn1, 2);
        System.out.println(ln);
    }

    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode fast = dummy, slow = dummy;
        while (n-- > 0) {
            fast = fast.next;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) {
            return head;
        }

        // move first node to desired position first, avoid flag and count etc.
        int count = 0;
        ListNode current = head;
        while(count < n) {
            count++;
            current = current.next;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode toDelete = head;
        ListNode toDeletePrev = dummy;

        while(current != null) {

            current = current.next;

            toDelete = toDelete.next;
            toDeletePrev = toDeletePrev.next;

        }

        // remove the one
        toDeletePrev.next = toDelete.next;

        // return head;
        return dummy.next;
    }
}

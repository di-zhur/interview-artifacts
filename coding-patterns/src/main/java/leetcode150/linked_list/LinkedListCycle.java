package leetcode150.linked_list;

import leetcode150.ListNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LinkedListCycle {

    public static void main(String args[]) {
        ListNode tn4 = new ListNode(-4);
        ListNode tn3 = new ListNode(0);
        tn3.next = tn4;
        ListNode tn2 = new ListNode(2);
        tn2.next = tn3;
        ListNode tn1 = new ListNode(3);
        tn1.next = tn2;
        tn4.next = tn2;
        System.out.println(hasCycle(tn1));
    }

    public boolean hasCycle2(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }

        return false;
    }

    public static boolean hasCycle(ListNode head) {

        Set<ListNode> hs = new HashSet<ListNode>();

        ListNode current = head;

        while (current != null) {

            if (hs.contains(current)) {
                return true;
            }

            hs.add(current);
            current = current.next;
        }

        return false;

    }

}

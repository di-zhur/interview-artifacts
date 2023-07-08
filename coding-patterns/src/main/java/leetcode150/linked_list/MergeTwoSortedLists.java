package leetcode150.linked_list;

import leetcode150.ListNode;

public class MergeTwoSortedLists {

    public static void main(String args[]) {
        // list1 = [1,2,4], list2 = [1,3,4]

        ListNode tn33 = new ListNode(4);
        ListNode tn22 = new ListNode(3, tn33);
        ListNode tn11 = new ListNode(1, tn22);

        ListNode tn3 = new ListNode(4);
        ListNode tn2 = new ListNode(2, tn3);
        ListNode tn1 = new ListNode(1, tn2);
        System.out.println(mergeTwoLists2(tn1, tn11));
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (l1 != null || l2 != null) {
            int v1 = l1 == null ? Integer.MAX_VALUE : l1.val;
            int v2 = l2 == null ? Integer.MAX_VALUE : l2.val;

            if (v1 < v2) {
                current.next = new ListNode(v1); // requires extra o(N) space
                l1 = l1.next;
            }
            else {
                current.next = new ListNode(v2);
                l2 = l2.next;
            }

            current = current.next;
        }

        return dummy.next;
    }

    public static ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        curr.next = list1 == null ? list2 : list1;
        return dummy.next;
    }
}

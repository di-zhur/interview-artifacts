package leetcode150.linked_list;

import leetcode150.ListNode;

public class AddTwoNumbers {

    public static void main(String args[]) {
        //l1 = [2,4,3], l2 = [5,6,4]
        ListNode ln_4_2 = new ListNode(4);
        ListNode ln_6 = new ListNode(6, ln_4_2);
        ListNode ln_5 = new ListNode(5, ln_6);


        ListNode ln_3 = new ListNode(3);
        ListNode ln_4 = new ListNode(4, ln_3);
        ListNode ln_2 = new ListNode(2, ln_4);

        ListNode res = addTwoNumbers(ln_2, ln_5);
        System.out.println(res);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode1 = l1;
        ListNode listNode2 = l2;
        ListNode listNode = new ListNode(0);
        ListNode res = listNode;
        int mod = 0;

        while (listNode1 != null || listNode2 != null) {

            int val1 = 0;
            if (listNode1 != null) {
                val1 = listNode1.val;
                listNode1 = listNode1.next;
            }

            int val2 = 0;
            if (listNode2 != null) {
                val2 = listNode2.val;
                listNode2 = listNode2.next;
            }

            int sum = val1 + val2 + mod;
            int val = sum % 10;
            mod = sum == 0 ? 0 : sum / 10;

            listNode.next = new ListNode(val);
            listNode = listNode.next;
        }

        if (mod > 0) {
            listNode.next = new ListNode(1);
        }

        return res.next;
    }

}

package leetcode150.binary_tree_general;

import leetcode150.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SameTree2 {

    public static void main(String args[]) {
        TreeNode tn21l = new TreeNode(2);
        TreeNode tn21r = new TreeNode(3);
        TreeNode tn11 = new TreeNode(1, tn21l, tn21r);
        TreeNode tn2l = new TreeNode(2);
        TreeNode tn2r = new TreeNode(3);
        TreeNode tn1 = new TreeNode(1, tn2l, tn2r);
        System.out.println(isSameTree(tn1, tn11));
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null) {
            return q == null;
        }

        if (q == null) {
            return p == null;
        }

        Stack<TreeNode> sk1 = new Stack<TreeNode>();
        Stack<TreeNode> sk2 = new Stack<TreeNode>();

        sk1.push(p);
        sk2.push(q);

        while (!sk1.isEmpty() && !sk2.isEmpty()) {
            TreeNode current1 = sk1.pop();
            TreeNode current2 = sk2.pop();

            if (current1 == null && current2 == null) {
                continue; // @note: missed both null check
            } else if (current1 == null && current2 != null) {
                return false;
            } else if (current1 != null && current2 == null) {
                return false;
            } else if (current1.val != current2.val) {
                return false;
            }

            sk1.push(current1.left);
            sk2.push(current2.left);

            sk1.push(current1.right);
            sk2.push(current2.right);

        }

        // final check
        if (!sk1.isEmpty() || !sk2.isEmpty()) {
            return false;
        }

        return true;
    }

}

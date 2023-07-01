package leetcode150.binary_tree_general;

import leetcode150.TreeNode;

public class SameTree {

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
        boolean b1 = p != null;
        boolean b2 = q != null;

        if (!b1 && !b2) {
            return true;
        }

        if (b1 && b2) {
            int val1 = p.val;
            int val2 = q.val;

            if (val1 == val2 &&
                    isSameTree(p.left, q.left) &&
                    isSameTree(p.right, q.right)) {
                return true;
            }

            return false;
        }

        return false;
    }

}

package leetcode150.binary_tree_general;

import leetcode150.TreeNode;

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


        return true;
    }

}

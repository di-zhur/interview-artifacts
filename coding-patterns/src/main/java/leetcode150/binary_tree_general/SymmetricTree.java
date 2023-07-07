package leetcode150.binary_tree_general;

import leetcode150.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {

    public static void main(String args[]) {
        TreeNode tn32l = new TreeNode(4);
        TreeNode tn32r = new TreeNode(3);
        TreeNode tn31l = new TreeNode(3);
        TreeNode tn31r = new TreeNode(4);
        TreeNode tn2l = new TreeNode(2, tn31l, tn31r);
        TreeNode tn2r = new TreeNode(2, tn32l, tn32r);
        TreeNode tn1 = new TreeNode(1, tn2l, tn2r);
        System.out.println(isSymmetric(tn1));
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isSymmetric(root.left, root.right);
    }

    private static boolean isSymmetric(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        } else if (node1 != null && node2 == null) {
            return false;
        } else if (node1 == null && node2 != null) {
            return false;
        } else {
            return node1.val == node2.val &&
                    isSymmetric(node1.left, node2.right) &&
                    isSymmetric(node1.right, node2.left);
        }
    }
}

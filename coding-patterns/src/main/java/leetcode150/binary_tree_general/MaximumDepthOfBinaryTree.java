package leetcode150.binary_tree_general;

import leetcode150.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthOfBinaryTree {

    public static void main(String args[]) {
        TreeNode tn3l = new TreeNode(15);
        TreeNode tn3r = new TreeNode(7);
        TreeNode tn2l = new TreeNode(9);
        TreeNode tn2r = new TreeNode(20, tn3l, tn3r);
        TreeNode tn1 = new TreeNode(3, tn2l, tn2r);
        System.out.println(maxDepth(tn1));
    }

    public static int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);// @note: use null as marker for end of level

        int depth = 0;

        while (!q.isEmpty()) {
            TreeNode current = q.poll();

            if (current == null) {

                depth++;
                if (!q.isEmpty()) {
                    q.offer(null);
                }

                continue;
            }

            if (current.left != null) {
                q.offer(current.left);
            }
            if (current.right != null) {
                q.offer(current.right);
            }
        }

        return depth;
    }

}

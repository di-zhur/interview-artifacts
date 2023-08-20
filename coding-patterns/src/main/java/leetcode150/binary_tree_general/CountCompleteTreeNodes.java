package leetcode150.binary_tree_general;

import leetcode150.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class CountCompleteTreeNodes {

    public static void main(String args[]) {
        TreeNode r5 = new TreeNode(1);

        TreeNode r42 = new TreeNode(4, null, r5);
        TreeNode r41 = new TreeNode(13);
        TreeNode r2 = new TreeNode(8, r41, r42);

        TreeNode r31 = new TreeNode(7);
        TreeNode r32 = new TreeNode(2);
        TreeNode r3 = new TreeNode(11, r31, r32);
        TreeNode r1 = new TreeNode(4, r3, null);
        TreeNode root = new TreeNode(5, r1, r2);
        System.out.println(countNodes(root));
    }

    public static int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int counter = 1;

        while (!q.isEmpty()) {
            TreeNode node = q.poll();

            if (node.left != null) {
                counter++;
                q.add(node.left);
            }

            if (node.right != null) {
                counter++;
                q.add(node.right);
            }
        }

        return counter;
    }

}

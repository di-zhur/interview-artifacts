package leetcode150.binary_tree_general;

import leetcode150.TreeNode;

import java.util.LinkedList;
import java.util.Stack;

public class PathSum {

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
        System.out.println(hasPathSum(root, 22));
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        if (targetSum == 0) {
            return false;
        }

        Stack<TreeNode> nodes = new Stack<>();
        Stack<Integer> values = new Stack<>();
        nodes.push(root);
        values.push(root.val);

        while (!nodes.isEmpty()) {
            TreeNode treeNode = nodes.pop();
            int sumValue = values.pop();

            if (treeNode.left == null && treeNode.right == null) {
                if (targetSum == sumValue) {
                    return true;
                }
            }

            if (treeNode.right != null){
                nodes.push(treeNode.right);
                values.push(sumValue + treeNode.right.val);
            }

            if (treeNode.left != null){
                nodes.push(treeNode.left);
                values.push(sumValue + treeNode.left.val);
            }
        }

        return false;
    }

}

package leetcode150.binary_tree_bfs;

import leetcode150.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelsInBinaryTree {

    public static void main(String args[]) {
        TreeNode r4 = new TreeNode(7);
        TreeNode r3 = new TreeNode(15);
        TreeNode r2 = new TreeNode(20, r3, r4);
        TreeNode r1 = new TreeNode(9);
        TreeNode root = new TreeNode(3, r1, r2);
        System.out.println(averageOfLevels(root));
    }

    public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            double count = 0;
            for (int i = 0; i < size; i++) {
                TreeNode tn = q.poll();
                count += tn.val;

                if (tn.left != null) {
                    q.add(tn.left);
                }

                if (tn.right != null) {
                    q.add(tn.right);
                }
            }
            result.add(count/size);
        }

        return result;
    }
}

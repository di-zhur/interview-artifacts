import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.Stack;

public class TreeDFS_SumOfPathNumbers2 {

    public static int findSumOfPathNumbers(TreeNode root) {
        return findRootToLeafPathNumbers(root);
    }



    private static int findRootToLeafPathNumbers(TreeNode root) {
        if (root == null)
            return 0;

        int rootToLeaf = 0, currNumber = 0;
        Deque<Pair<TreeNode, Integer>> stack = new ArrayDeque<>();
        stack.push(new Pair(root, 0));

        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> p = stack.pop();
            root = p.getKey();
            currNumber = p.getValue();

            if (root != null) {
                currNumber = currNumber * 10 + root.val;
                // if it's a leaf, update root-to-leaf sum
                if (root.left == null && root.right == null) {
                    rootToLeaf += currNumber;
                } else {
                    stack.push(new Pair(root.right, currNumber));
                    stack.push(new Pair(root.left, currNumber));
                }
            }
        }
        return rootToLeaf;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        System.out.println("Total Sum of Path Numbers: " + findSumOfPathNumbers(root));
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}

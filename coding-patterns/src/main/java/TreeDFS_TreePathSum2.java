import java.util.Stack;

public class TreeDFS_TreePathSum2 {

    public static boolean hasPath(TreeNode root, int sum) {
        if (root == null)
            return false;

        Stack<TreeNode> treeNodes = new Stack<>();
        treeNodes.push(root);
        int counter = root.val;
        while (!treeNodes.isEmpty()) {
            TreeNode treeNode = treeNodes.pop();
            counter = counter + treeNode.val;
            if (treeNode.left == null && treeNode.right == null) {

                if (counter == sum) {
                    return true;
                }
                counter = root.val;
            }

            if (treeNode.right != null) {
                treeNodes.push(treeNode.right);
            }

            if (treeNode.left != null) {
                treeNodes.push(treeNode.left);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("Tree has path: " + hasPath(root, 23));
        System.out.println("Tree has path: " + hasPath(root, 16));
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

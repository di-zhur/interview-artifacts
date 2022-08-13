public class Pair<T, T1> {
    private final TreeDFS_SumOfPathNumbers2.TreeNode root;
    private final int i;

    public Pair(TreeDFS_SumOfPathNumbers2.TreeNode root, int i) {
        this.root = root;
        this.i = i;
    }

    public TreeDFS_SumOfPathNumbers2.TreeNode getKey() {
        return root;
    }

    public int getValue() {
        return i;
    }
}

package leetcode;

import java.util.*;

public class LineReflection_356 {

    public static void main(String[] args) {
        System.out.println(addStrings("456", "78"));
        //summaryRanges(new int[] {0,1,2,4,5,7});
        //System.out.println(isReflected(new int[][]{{6, 6}, {-6, 6}, {-6, 6}, {-6, 6}}));
    }

    public String reverseWords(String s) {

        return new StringBuilder(s).reverse().toString();
    }

      public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }


    public static int rangeSumBST(TreeNode root, int low, int high) {
        var result = 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            int val = node.val;
            if (val >= low && val <= high) {
                result = result + val;
            }

            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }
        }

        return result;
    }

    public static String addStrings(String num1, String num2) {
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();
        String result = "";
        int carry = 0;
        for (int i = 0; i < num1.length() || i < num2.length(); i ++) {
            int c1 = 0;
            int c2 = 0;
            if (i < num1.length()) {
                c1 = num1.charAt(i) - '0';
            }
            if (i < num2.length()) {
                c2 = num2.charAt(i) - '0';
            }
            int sum = c1 + c2 + carry;
            int digit = sum % 10;
            carry = sum / 10;
            result = digit + result;
        }
        if (carry != 0) {
            result = carry + result;
        }
        return result;
    }

    public static List<String> summaryRanges(int[] nums) {
        List<String> res = new LinkedList<String>();
        if (nums.length == 0) {
            return res;
        }
        int start = -1;
        int end = -1;
        for (int i = 0; i < nums.length; i ++) {
            if (i == 0) {
                start = nums[i];
                end = nums[i];
            }
            else {
                if (nums[i] == end + 1) {
                    end = nums[i];
                }
                else {
                    process(res, start, end);
                    start = nums[i];
                    end = nums[i];
                }
            }
        }
        process(res, start, end);
        return res;
    }

    private static void process(List<String> res, int start, int end) {
        if (start == end) {
            res.add(start + "");
        }
        else {
            res.add(start + "->" + end);
        }
    }
    public static boolean isReflected(int[][] points) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        Set<String> set = new HashSet<>();
        for (int[] point : points) {
            max = Math.max(max, point[0]);
            min = Math.min(min, point[0]);
            set.add(point[0] + "," + point[1]);
        }

        int sum = max + min;
        for (int[] point : points) {
            String reflection = (sum - point[0]) + "," + point[1];
            if (!set.contains(reflection)) {
                return false;
            }
        }

        return true;
    }

}

package leetcode150.sliding_window;

public class MinimumSizeSubarraySum {

    public static void main(String args[]) {
        System.out.println(minSubArrayLen(7, new int[] { 2, 3, 1, 2, 4, 3 }));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int minSize = Integer.MAX_VALUE;
        int outerIdx = -1;
        int innerIdx = -1;

        for (outerIdx = 0; outerIdx < nums.length; ++outerIdx) {
            int sum = 0;
            for (innerIdx = outerIdx; innerIdx < nums.length; ++innerIdx) {
                sum += nums[innerIdx];

                if (sum >= target) {
                    minSize = Math.min(minSize, innerIdx - outerIdx + 1);
                    break;
                }
            }
        }

        if (minSize == Integer.MAX_VALUE) {
            return 0;
        }

        return minSize;
    }
}

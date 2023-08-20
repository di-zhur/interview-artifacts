package leetcode150.intervals;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public static void main(String args[]) {

        List<String> list = summaryRanges(new int[] { 0,1,2,4,5,7 });
        System.out.println(list.size());
    }

    public static List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        for (int i = 0, j, n = nums.length; i < n; i = j + 1) {
            j = i;
            while (j + 1 < n && nums[j + 1] == nums[j] + 1) {
                ++j;
            }
            ans.add(f(nums, i, j));
        }
        return ans;
    }

    private static String f(int[] nums, int i, int j) {
        return i == j ? nums[i] + "" : String.format("%d->%d", nums[i], nums[j]);
    }
}

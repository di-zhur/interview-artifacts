package leetcode150.array_string;

import java.util.*;

public class RemoveDuplicatesFromSortedArray {

    public static void main(String args[]) {
        int[] nums = new int[] { 0,0,1,1,1,2,2,3,3,4 };
        int count = removeDuplicates(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(count);
    }

    public static int removeDuplicates(int[] nums) {
        int i = 0;
        for (int num : nums) {
            if (1 > i || nums[i - 1] != num) {
                nums[i] = num;
                i = i + 1;
            }
        }
        return i;
    }

}

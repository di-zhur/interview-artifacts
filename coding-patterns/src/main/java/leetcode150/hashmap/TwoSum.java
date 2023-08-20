package leetcode150.hashmap;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String args[]) {
        System.out.println(twoSum(new int[] { 2,7,11,15}, 9));
    }

    private static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> store = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            int key = target - val;
            if (store.containsKey(key)) {
                int index = store.get(key);
                return new int[] { index, i };
            } else {
                store.put(val, i);
            }


        }

        return new int[] { -1, -1};
    }
}

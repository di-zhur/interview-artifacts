import java.util.HashMap;

public class TwoPointers_PairWithTargetSum {

    public static void main(String[] args) {
        int[] result = search1(new int[] { 1, 2, 3, 4, 6 }, 6);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
        result = search1(new int[] { 2, 5, 9, 11 }, 11);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");

        result = search1(new int[] { 1, 2, 3, 4, 6 }, 6);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
        result = search1(new int[] { 2, 5, 9, 11 }, 11);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
    }

    public static int[] search1(int[] arr, int targetSum) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int currentSum = arr[left] + arr[right];
            if (currentSum == targetSum)
                return new int[] { left, right }; // found the pair

            if (targetSum > currentSum)
                left++; // we need a pair with a bigger sum
            else
                right--; // we need a pair with a smaller sum
        }
        return new int[] { -1, -1 };
    }

    public static int[] search2(int[] arr, int targetSum) {
        HashMap<Integer, Integer> nums = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int o1 = arr[i];
            int o2 = targetSum - o1;
            if (nums.containsKey(o2)) {
                int o3 = nums.get(o2);
                return new int[] { o3, i };
            } else {
                nums.put(o1, i);
            }
        }
        return new int[] { -1, -1 };
    }
}

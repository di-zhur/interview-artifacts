import java.util.HashMap;

public class TwoPointers_PairWithTargetSum {

    public static void main(String[] args) {
        int[] result = search(new int[] { 1, 2, 3, 4, 6 }, 6);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
        result = search(new int[] { 2, 5, 9, 11 }, 11);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
    }


    public static int[] search(int[] arr, int targetSum) {
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

package leetcode150.two_pointers;

public class ValidPalindrome {

    public static void main(String args[]) {
        System.out.println(isPalindrome("race a car"));
    }

    public static boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }

        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            char c1 = s.charAt(start);
            char c2 = s.charAt(end);

            if (c1 != c2) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }
}

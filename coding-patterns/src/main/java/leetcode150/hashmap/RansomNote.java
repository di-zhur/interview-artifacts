package leetcode150.hashmap;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {

    public static void main(String args[]) {
        System.out.println(canConstruct("aa", "aab"));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {

        int len = magazine.length();

        Map<Character, Integer> store = new HashMap<>();
        for (int i = 0; i < len; i++) {
            char c = magazine.charAt(i);

            if (store.containsKey(c)) {
                int count = store.get(c);
                store.put(c, ++count);
            } else {
                store.put(c, 1);
            }
        }

        int len2 = ransomNote.length();
        for (int i = 0; i < len2; i++) {
            char c = ransomNote.charAt(i);
            if (store.containsKey(c)) {
                int count = store.get(c);
                if (count == 0) {
                    return false;
                }
                store.put(c, --count);
            } else {
                return false;
            }
        }

        return true;
    }

}

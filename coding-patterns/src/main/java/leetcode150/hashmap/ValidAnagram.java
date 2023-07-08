package leetcode150.hashmap;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

    public static void main(String args[]) {
        System.out.println(isAnagram("anagram", "nagaram"));
    }

    public static boolean isAnagram(String s, String t) {
        Map<Character, Integer> store = new HashMap<>();
        for (var c : s.toCharArray()) {
            if (store.containsKey(c)) {
                int count = store.get(c);
                store.put(c, ++count);
            } else {
                store.put(c, 1);
            }
        }

        for (var c : t.toCharArray()) {
            if (store.containsKey(c)) {
                int count = store.get(c);
                if (count == 0) {
                    return false;
                }

                count = count - 1;
                if (count == 0) {
                    store.remove(c);
                } else {
                    store.put(c, count);
                }
            } else {
                return false;
            }
        }

        return store.isEmpty();
    }
}

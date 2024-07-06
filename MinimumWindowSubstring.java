import java.util.*;
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int l = 0, r = 0, cnt = 0, sindex = -1, minlen = Integer.MAX_VALUE;
        HashMap<Character, Integer> mpp = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            mpp.put(t.charAt(i), mpp.getOrDefault(t.charAt(i), 0) + 1);
        }

        while (r < s.length()) {
            char ch = s.charAt(r);

            // If the character is in t and its count in the hashmap is greater than 0, increase cnt
            if (mpp.containsKey(ch)) {
                if (mpp.get(ch) > 0) {
                    cnt++;
                }
                // Decrease the count in the hashmap
                mpp.put(ch, mpp.get(ch) - 1);
            }

            // When all characters of t are matched (cnt == t.length())
            while (cnt == t.length()) {
                // Update the minimum length and starting index of the substring
                if (r - l + 1 < minlen) {
                    minlen = r - l + 1;
                    sindex = l;
                }

                // Try to contract the window from the left
                char leftChar = s.charAt(l);
                if (mpp.containsKey(leftChar)) {
                    mpp.put(leftChar, mpp.get(leftChar) + 1);
                    // If a character count goes above 0, it means we need more of this character
                    if (mpp.get(leftChar) > 0) {
                        cnt--;
                    }
                }
                l++;
            }

            r++;
        }

        // If sindex is not updated, return empty string
        return sindex == -1 ? "" : s.substring(sindex, sindex + minlen);
    }
}

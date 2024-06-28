import java.util.*;
public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int right = 0;
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        int maxCharOccurrence = 0;
        int maxLength = 0;

        while (right < n) {
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            maxCharOccurrence = Math.max(maxCharOccurrence, map.get(ch));

            while (right - left + 1 - maxCharOccurrence > k) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }

        return maxLength;
    }
}

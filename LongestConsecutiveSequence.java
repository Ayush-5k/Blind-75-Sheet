import java.util.*;
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        int n = nums.length;

        for (int j = 0; j < n; j++) {
            set.add(nums[j]);
        }

        int i = 0;
        int maxLen = 0;
        while (i < n) {
            if (set.contains(nums[i])) {
                if (set.contains(nums[i] - 1)) {
                    i++;
                    continue;
                } else {
                    int val = nums[i];
                    int count = 0;
                    while(set.contains(val)) {
                        set.remove(val);
                        count++;
                        val++;
                    }
                    maxLen = Math.max(maxLen, count);
                }
            }
            i++;
        }
        return maxLen;
    }
}

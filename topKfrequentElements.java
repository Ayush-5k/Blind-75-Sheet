import java.util.*;
public class topKfrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;

        // Build frequency map
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Bucket sort on frequencies
        List<Integer>[] numberOfTimesElemOccurs = new List[n + 1];
        for (int i = 0; i < numberOfTimesElemOccurs.length; i++) {
            numberOfTimesElemOccurs[i] = new ArrayList<>();
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            numberOfTimesElemOccurs[entry.getValue()].add(entry.getKey());
        }

        // Gather the top k frequent elements
        int[] ans = new int[k];
        int j = 0;
        for (int i = n; i >= 0; i--) {
            if (!numberOfTimesElemOccurs[i].isEmpty()) {
                while (!numberOfTimesElemOccurs[i].isEmpty() && j < k) {
                    ans[j++] = numberOfTimesElemOccurs[i].remove(numberOfTimesElemOccurs[i].size() - 1);
                }
            }
            if (j >= k) break;
        }

        return ans;
    }
}

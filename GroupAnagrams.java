import java.util.*;
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap<Character, Integer>, List<String>> map = new HashMap<>();
        int n = strs.length;

        for (int i = 0; i < n; i++) {
            String s = strs[i];
            HashMap<Character, Integer> charCountMap = new HashMap<>();
            for (char ch : s.toCharArray()) {
                charCountMap.put(ch, charCountMap.getOrDefault(ch, 0) + 1);
            }
            if (!map.containsKey(charCountMap)) {
                map.put(charCountMap, new ArrayList<>());
            }
            map.get(charCountMap).add(s);
        }

        return new ArrayList<>(map.values());
    }
}

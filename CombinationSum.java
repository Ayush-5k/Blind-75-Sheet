import java.util.*;
public class CombinationSum {
    public void comb(int ind, int[] arr, int target, List<Integer> current, List<List<Integer>> result, int sum) {
        if (sum == target) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (ind == arr.length || sum > target) {
            return;
        }

        current.add(arr[ind]);
        comb(ind, arr, target, current, result, sum + arr[ind]);
        current.remove(current.size() - 1);

        comb(ind + 1, arr, target, current, result, sum);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        comb(0, candidates, target, new ArrayList<>(), ans, 0);
        return ans;
    }
}

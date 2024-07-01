import java.util.*;

public class MergeIntervals {
    class Pair {
        int first;
        int second;
        public Pair(int f, int s) {
            this.first = f;
            this.second = s;
        }
    }
    public int[][] merge(int[][] intervals) {

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            if(a.first != b.first) {
                return a.first - b.first;
            } else {
                return a.second-b.second;
            }
        });
        int n = intervals.length;

        for (int i = 0; i < n; i++) {
            pq.add(new Pair(intervals[i][0], intervals[i][1]));
        }

        Pair initial = pq.poll();
        int prevStart = initial.first;
        int prevEnd = initial.second;

        while (!pq.isEmpty()) {

            Pair curr = pq.poll();
            int currStart = curr.first;
            int currEnd = curr.second;

            if (prevEnd >= currStart) {
                prevEnd = Math.max(currEnd, prevEnd);
            } else {
                ArrayList<Integer> arr = new ArrayList<>();
                arr.add(prevStart);
                arr.add(prevEnd);
                ans.add(new ArrayList<>(arr));
                prevStart = currStart;
                prevEnd = currEnd;
            }
        }

        int m = ans.size();
        int[][] finalAns = new int[m + 1][2];
        for (int i = 0; i < m; i++) {
            finalAns[i][0] = ans.get(i).get(0);
            finalAns[i][1] = ans.get(i).get(1);
        }
        finalAns[m][0] = prevStart;
        finalAns[m][1] = prevEnd;

        return finalAns;
    }
}

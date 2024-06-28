import java.util.*;
class Pair {
    int start;
    int end;
    int diff;
    public Pair(int s, int e, int d) {
        this.start = s;
        this.end = e;
        this.diff = d;
    }
}
public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) ->{
            if (a.end == b.end) {
                return a.diff - b.diff;
            } else {
                return a.end - b.end;
            }
        });

        int n = intervals.length;
        for (int i = 0; i < n; i++) {
            pq.add(new Pair(intervals[i][0], intervals[i][1], intervals[i][1] - intervals[i][0]));
        }
        int prev = -50001;
        int count = 0;
        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            if (curr.start < prev) {
                count++;
            } else{
                prev = curr.end;
            }

        }
        return count;
    }
}

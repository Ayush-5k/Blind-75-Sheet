import java.util.*;
public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;


        int x = newInterval[0];
        int y = newInterval[1];

        // if (x == 0 && y == 0) {
        //     if (intervals[0][0] != 0 &&)
        // }

        ArrayList<int[]> arr = new ArrayList<>();

        int i = 0;
        int prevStart = 0;
        int prevEnd = 0;
        int toInsertStart = -1;
        int toInsertEnd = -1;
        boolean flag = false;

        while (i < n) {

            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];



            if (!flag && x >= currStart && x <= currEnd) {
                toInsertStart = currStart;
                flag = true;
                if (y <= currEnd) {
                    return intervals;
                } else {
                    continue;
                }
            } else if (!flag && x < currStart && !flag){
                toInsertStart = x;
                flag = true;
            } else if(!flag){
                arr.add(intervals[i]);
            }

            if (flag && y >= currStart && y <= currEnd) {
                toInsertEnd = currEnd;
                int[] in = new int[2];
                in[0] = toInsertStart;
                in[1] = toInsertEnd;
                arr.add(in);
                i++;
                break;
            } else if (flag && y < currStart) {
                toInsertEnd = y;
                int[] in = new int[2];
                in[0] = toInsertStart;
                in[1] = toInsertEnd;
                arr.add(in);
                arr.add(intervals[i]);
                i++;
                break;
            }
            i++;
        }
        while (i < n) {
            arr.add(intervals[i]);
            i++;
        }
        if (toInsertStart != -1 && toInsertEnd == -1) {
            int[] in = new int[2];
            in[0] = toInsertStart;
            in[1] = y;
            arr.add(in);
        }
        if (toInsertStart == -1 && toInsertEnd == -1) {
            int[] in = new int[2];
            in[0] = x;
            in[1] = y;
            arr.add(in);
        }
        int[][] ans = new int[arr.size()][2];
        for (int j = 0; j < arr.size(); j++) {
            ans[j] = arr.get(j);
        }
        return ans;
    }
}

import java.util.*;
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            arr.add(new ArrayList<>());
        }

        int n = prerequisites.length;
        int[] indegree = new int[numCourses];

        for (int i = 0; i < n; i++) {
            int src = prerequisites[i][1];
            int des = prerequisites[i][0];

            arr.get(src).add(des);
            indegree[des]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) q.add(i);
        }
        int count = 0;
        while (!q.isEmpty()) {
            int curr = q.poll();
            count++;
            for (int it : arr.get(curr)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    q.add(it);
                }
            }
        }
        if (count == numCourses) return true;
        return false;
    }
}

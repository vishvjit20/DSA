import java.util.*;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer> graph[] = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int row[] : prerequisites) {
            int u = row[0], v = row[1];
            graph[u].add(v);
        }

        int indeg[] = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            for (int nbr : graph[i]) {
                indeg[nbr]++;
            }
        }
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indeg[i] == 0)
                q.add(i);
        }

        while (!q.isEmpty()) {
            int rem = q.remove();
            count++;
            for (int nbr : graph[rem]) {
                indeg[nbr]--;
                if (indeg[nbr] == 0) {
                    q.add(nbr);
                }
            }
        }

        return count == numCourses;
    }
}

import java.util.LinkedList;
import java.util.Queue;

public class SnakesAndLadders {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int arr[] = new int[n * n];
        int i = n - 1, j = 0, inc = 1;
        int idx = 0;
        while (idx < n * n) {
            arr[idx++] = board[i][j];
            if (inc == 1 && j == n - 1) {
                inc = -1;
                i--;
            } else if (inc == -1 && j == 0) {
                inc = 1;
                i--;
            } else
                j += inc;
        }

        Queue<Integer> q = new LinkedList<>();
        int val = arr[0] > -1 ? arr[0] - 1 : 0;
        int totalSteps = 0;
        q.add(val);
        boolean visited[] = new boolean[n * n];
        visited[val] = true;
        while (q.size() > 0) {
            int cnt = q.size();
            while (cnt-- > 0) {
                int rem = q.remove();
                if (rem == n * n - 1) {
                    return totalSteps;
                }
                for (int next = rem + 1; next <= Math.min(rem + 6, n * n - 1); next++) {
                    int dest = arr[next] == -1 ? next : arr[next] - 1;
                    if (!visited[dest]) {
                        visited[dest] = true;
                        q.add(dest);
                    }
                }
            }
            totalSteps++;
        }
        return -1;
    }
}

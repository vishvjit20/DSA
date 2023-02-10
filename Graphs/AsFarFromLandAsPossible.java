import java.util.*;

class AsFarFromLandAsPossible {
    class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int maxDistance(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int dist = -1;
        Queue<Pair> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1)
                    q.add(new Pair(i, j));
            }
        }

        int dirs[][] = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };
        if (q.size() == 0 || q.size() == n * m)
            return -1;

        while (q.size() > 0) {
            dist++;
            int size = q.size();
            while (size-- > 0) {
                Pair rem = q.remove();
                for (int i = 0; i < 4; i++) {
                    int nx = rem.x + dirs[i][0];
                    int ny = rem.y + dirs[i][1];
                    if (nx >= 0 && ny >= 0 && nx < n && ny < m && grid[nx][ny] != 1) {
                        grid[nx][ny] = 1;
                        q.add(new Pair(nx, ny));
                    }
                }
            }
        }

        return dist;
    }
}

import java.util.*;

public class KnightMoves {
    class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int knight(int A, int B, int C, int D, int E, int F) {
        int x1 = C - 1, y1 = D - 1, x2 = E - 1, y2 = F - 1;

        int dirs[][] = { { 1, 2 }, { 1, -2 }, { -1, 2 }, { -1, -2 }, { 2, 1 }, { 2, -1 }, { -2, 1 }, { -2, -1 } };
        boolean visited[][] = new boolean[A][B];
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x1, y1));
        int count = 0;
        visited[x1][y1] = true;

        while (q.size() > 0) {
            int size = q.size();
            while (size-- > 0) {
                Pair rem = q.remove();

                if (rem.x == x2 && rem.y == y2) {
                    return count;
                }

                for (int i = 0; i < 8; i++) {
                    int ni = rem.x + dirs[i][0], nj = rem.y + dirs[i][1];
                    if (ni >= 0 && nj >= 0 && ni < A && nj < B && !visited[ni][nj]) {
                        q.add(new Pair(ni, nj));
                        visited[ni][nj] = true;
                    }
                }
            }
            count++;
        }

        return -1;
    }
}

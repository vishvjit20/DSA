
import java.util.*;

public class NoOfIslands2 {
    class Point {
        int x;
        int y;

        Point(int a, int b) {
            x = a;
            y = b;
        }
    }

    int parent[];
    int rank[];

    int find(int x) {
        if (parent[x] == x)
            return x;
        int res = find(parent[x]);
        parent[x] = res;
        return res;
    }

    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        List<Integer> res = new ArrayList<>();
        parent = new int[n * m];
        rank = new int[n * m];

        if (operators.length == 0)
            return res;

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        int count = 0;
        int mat[][] = new int[n][m];
        int dirs[][] = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

        for (Point op : operators) {
            int i = op.x, j = op.y;
            if (mat[i][j] == 1) {
                res.add(count);
                continue;
            }

            mat[i][j] = 1;
            count++;
            for (int k = 0; k < 4; k++) {
                int ni = i + dirs[k][0];
                int nj = j + dirs[k][1];

                if (ni >= 0 && ni < n && nj >= 0 && nj < m && mat[ni][nj] == 1) {
                    int sc = i * m + j;
                    int nc = ni * m + nj;
                    int ls = find(sc);
                    int ln = find(nc);

                    if (ls != ln) {
                        if (rank[ls] > rank[ln])
                            parent[ln] = ls;
                        else if (rank[ls] < rank[ln])
                            parent[ls] = ln;
                        else {
                            parent[ls] = ln;
                            rank[ln]++;
                        }
                        count--;
                    }
                }
            }
            res.add(count);
        }

        return res;
    }
}

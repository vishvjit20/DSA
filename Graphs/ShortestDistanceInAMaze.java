import java.util.*;

public class ShortestDistanceInAMaze {
    class Node {
        int x, y, cnt;
        Direction dir;

        public Node(int x, int y, int cnt, Direction dir) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.dir = dir;
        }
    }

    enum Direction {
        UP(-1, 0), DOWN(1, 0), RIGHT(0, 1), LEFT(0, -1);

        int x, y;

        Direction(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    class Visited {
        Map<Direction, Boolean> direction = new HashMap<>();

        public Visited() {
            for (Direction d : Direction.values()) {
                direction.put(d, false);
            }
        }
    }

    private boolean isValid(int[][] grid, int u, int v, Direction dir) {
        int n = grid.length;
        int m = grid[0].length;
        if (dir == Direction.LEFT && (v - 1 == -1 || grid[u][v - 1] == 1)) {
            return true;
        }
        if (dir == Direction.RIGHT && (v + 1 == m || grid[u][v + 1] == 1)) {
            return true;
        }
        if (dir == Direction.UP && (u - 1 == -1 || grid[u - 1][v] == 1)) {
            return true;
        }
        if (dir == Direction.DOWN && (u + 1 == n || grid[u + 1][v] == 1)) {
            return true;
        }

        return false;
    }

    public int solve(int[][] grid, int[] start, int[] end) {
        int n = grid.length;
        int m = grid[0].length;

        Visited[][] visited = new Visited[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = new Visited();
            }
        }

        int res = Integer.MAX_VALUE;
        Queue<Node> q = new LinkedList<>();
        for (Direction d : Direction.values()) {
            int x = start[0] + d.x;
            int y = start[1] + d.y;
            if (x >= 0 && x < n && y >= 0 && y < m && grid[x][y] == 0) {
                q.add(new Node(x, y, 1, d));
            }
        }

        while (!q.isEmpty()) {
            Node rem = q.remove();
            int x = rem.x, y = rem.y, cnt = rem.cnt;
            Direction dir = rem.dir;

            if (x == end[0] && y == end[1] && isValid(grid, x, y, dir)) {
                res = Math.min(cnt, res);
                continue;
            }

            visited[x][y].direction.put(dir, true);

            int nx = x + dir.x;
            int ny = y + dir.y;
            if (nx >= 0 && nx < n && ny >= 0 && ny < m && grid[nx][ny] == 0 && !visited[nx][ny].direction.get(dir)) {
                q.add(new Node(nx, ny, cnt + 1, dir));
            } else {
                for (Direction d : Direction.values()) {
                    if (d == dir)
                        continue;
                    int x1 = x + d.x;
                    int y1 = y + d.y;
                    if (x1 >= 0 && x1 < n && y1 >= 0 && y1 < m && grid[x1][y1] == 0
                            && !visited[x1][y1].direction.get(d)) {
                        q.add(new Node(x1, y1, cnt + 1, d));
                    }
                }
            }
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }
}

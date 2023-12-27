package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_14940 {
    static StringTokenizer st;
    static StringBuilder sb;
    static int n, m;
    static int startX;
    static int startY;
    static int[][] arr;
    static int[][] dist;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        dist = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 2) {
                    arr[i][j] = num;
                    startX = j;
                    startY = i;
                } else {
                    arr[i][j] = num;
                }
            }
        }

        bfs(startX, startY);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                if (!visited[i][j] && arr[i][j] == 1)
                    sb.append(-1 + " ");
                else
                    sb.append(dist[i][j] + " ");
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        visited[y][x] = true;
        q.add(new Point(x, y));

        while (!q.isEmpty()) {
            Point current = q.poll();

            for (int i = 0; i < 4; i++) {
                int nX = current.x + dx[i];
                int nY = current.y + dy[i];

                if (nX < 0 || nX >= m || nY < 0 || nY >= n) continue;
                if (visited[nY][nX]) continue;
                if (arr[nY][nX] == 0) continue;

                q.add(new Point(nX, nY));
                visited[nY][nX] = true;
                dist[nY][nX] = dist[current.y][current.x] + 1;
            }
        }

    }
}

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

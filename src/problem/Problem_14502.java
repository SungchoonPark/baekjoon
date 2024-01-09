package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem_14502 {
    static StringTokenizer st;
    static StringBuilder sb;
    static int[][] array;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static List<MapPoint> virusPoints;
    static int maxSafeArea;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        array = new int[n][m];
        virusPoints = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
                if (array[i][j] == 2) {
                    virusPoints.add(new MapPoint(i, j));
                }
            }
        }

        dfs(0);

        System.out.println(maxSafeArea);
    }

    static void dfs(int wallNum) {
        if (wallNum == 3) {
            bfs();
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (array[i][j] == 0) {
                    array[i][j] = 1;
                    dfs(wallNum + 1);
                    array[i][j] = 0;
                }
            }
        }
    }

    static void bfs() {
        Queue<MapPoint> q = new LinkedList<>(virusPoints);
        int[][] virusMap = new int[n][m];

        for (int i = 0; i < n; i++) {
            virusMap[i] = Arrays.copyOf(array[i], m);
        }

        while (!q.isEmpty()) {
            MapPoint point = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && virusMap[nx][ny] == 0) {
                    virusMap[nx][ny] = 2;
                    q.add(new MapPoint(nx, ny));
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (virusMap[i][j] == 0) {
                    cnt++;
                }
            }
        }
        maxSafeArea = Math.max(maxSafeArea, cnt);
    }
}

class MapPoint {
    int x;
    int y;

    public MapPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

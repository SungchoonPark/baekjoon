package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem_7569 {
    static StringTokenizer st;
    static StringBuilder sb;
    static int n, m, h;
    static int[][][] array;
    static List<TomatoPoint> tomatoPoints;
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        array = new int[h][n][m];
        tomatoPoints = new ArrayList<>();

        boolean tmp = false;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    array[i][j][k] = Integer.parseInt(st.nextToken());
                    if (array[i][j][k] == 1) {
                        tomatoPoints.add(new TomatoPoint(i, j, k));
                    }
                    if (array[i][j][k] == 0) {
                        tmp = true;
                    }
                }
            }
        }
        if (!tmp) {
            System.out.println(0);
            return;
        }

        bfs();
        solution();
        System.out.println(sb);
    }

    static void bfs() {
        Queue<TomatoPoint> q = new LinkedList<>(tomatoPoints);

        while (!q.isEmpty()) {
            TomatoPoint ripeTomato = q.poll();

            for (int i = 0; i < 6; i++) {
                int nz = ripeTomato.z + dz[i];
                int nx = ripeTomato.x + dx[i];
                int ny = ripeTomato.y + dy[i];

                if (nz >= 0 && nz < h && nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (array[nz][nx][ny] == 0) {
                        q.add(new TomatoPoint(nz, nx, ny));
                        array[nz][nx][ny] = array[ripeTomato.z][ripeTomato.x][ripeTomato.y] + 1;
                    }
                }
            }
        }
    }

    static void solution() {
        int ripeDay = Integer.MIN_VALUE;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (array[i][j][k] == 0) {
                        sb.append(-1);
                        return;
                    }
                    ripeDay = Math.max(ripeDay, array[i][j][k]);
                }
            }
        }
        sb.append(ripeDay - 1);
    }
}

class TomatoPoint {
    int z;
    int x;
    int y;

    public TomatoPoint(int z, int x, int y) {
        this.z = z;
        this.x = x;
        this.y = y;
    }
}

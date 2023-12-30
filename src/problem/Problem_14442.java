package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_14442 {
    static StringTokenizer st;
    static StringBuilder sb;
    static int[][] array;
    static boolean[][][] visited;
    static int n, m, k;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        array = new int[n][m];
        visited = new boolean[n][m][k + 1];

        for (int i = 0; i < n; i++) {
            String nums = br.readLine();
            for (int j = 0; j < m; j++) {
                array[i][j] = Integer.parseInt(String.valueOf(nums.charAt(j)));
            }
        }

        Graph graph = new Graph(0, 0, 0, 1);
        sb.append(bfs(graph));
        System.out.println(sb);
    }

    public static int bfs(Graph graph) {
        Queue<Graph> q = new LinkedList<>();
        q.add(graph);
        visited[graph.x][graph.y][graph.crashedWallNum] = true;

        while (!q.isEmpty()) {
            Graph currentGraph = q.poll();

            if (currentGraph.x == n - 1 && currentGraph.y == m - 1) return currentGraph.dist;

            for (int i = 0; i < 4; i++) {
                int nx = currentGraph.x + dx[i];
                int ny = currentGraph.y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

                if (array[nx][ny] == 0 && !visited[nx][ny][currentGraph.crashedWallNum]) {
                    visited[nx][ny][currentGraph.crashedWallNum] = true;
                    q.add(new Graph(nx, ny, currentGraph.crashedWallNum, currentGraph.dist + 1));
                } else {
                    if (currentGraph.crashedWallNum < k && !visited[nx][ny][currentGraph.crashedWallNum + 1]) {
                        visited[nx][ny][currentGraph.crashedWallNum + 1] = true;
                        q.add(new Graph(nx, ny, currentGraph.crashedWallNum + 1, currentGraph.dist + 1));
                    }
                }

            }
        }
        return -1;
    }
}


class Graph {
    int x;
    int y;
    int crashedWallNum;
    int dist;

    public Graph(int x, int y, int crashedWallNum, int dist) {
        this.x = x;
        this.y = y;
        this.crashedWallNum = crashedWallNum;
        this.dist = dist;
    }
}
package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_1260 {
    static StringTokenizer st;
    static StringBuilder sb;
    static int n, m, v;
    static int[][] graph;
    static boolean[] visited;
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        graph = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a][b] = graph[b][a] = 1;
        }

        dfs(v);
        sb.append("\n");
        visited = new boolean[n+1];
        bfs(v);
        System.out.println(sb);
    }

    public static void dfs(int start) {
        visited[start] = true;
        sb.append(start + " ");

        for (int i = 0; i < n + 1; i++) {
            if(graph[start][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }

    public static void bfs(int start) {
        queue.add(start);
        visited[start] = true;

        while(!queue.isEmpty()) {
            start = queue.poll();
            sb.append(start + " ");

            for(int i=0; i<n+1; i++) {
                if(graph[start][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}

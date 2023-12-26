package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_11724 {
    static StringTokenizer st;
    static StringBuilder sb;
    static int n, m, result;
    static int[][] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = arr[b][a] = 1;
        }

        for (int i = 1; i < n + 1; i++) {
            if (!visited[i]) {
                dfs(i);
                result++;
            }
        }
        System.out.println(result);
    }

    public static void dfs(int a) {
        visited[a] = true;

        for (int i = 0; i < n + 1; i++) {
            if (arr[a][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }
}

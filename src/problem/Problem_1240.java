package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem_1240 {
    static StringTokenizer st;
    static StringBuilder sb;
    static int n, m;
    static int[][] array;
    static int[][] distance;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        array = new int[n + 1][n + 1];
        distance = new int[n + 1][n + 1];

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());

            array[a][b] = array[b][a] = 1;
            distance[a][b] = distance[b][a] = length;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int startNode = Integer.parseInt(st.nextToken());
            int goalNode = Integer.parseInt(st.nextToken());

            bfs(startNode, goalNode);
        }
        System.out.println(sb);
    }

    static void bfs(int startNode, int goalNode) {
        Queue<Integer> q = new LinkedList<>();
        isVisited = new boolean[n + 1];
        int[] distTmp = new int[n + 1];

        isVisited[startNode] = true;
        q.add(startNode);

        while (!q.isEmpty()) {
            startNode = q.poll();

            for (int i = 1; i < n + 1; i++) {
                if (array[startNode][i] == 1 && !isVisited[i]) {
                    q.add(i);
                    isVisited[i] = true;
                    distTmp[i] = distTmp[startNode] + distance[startNode][i];
                    if (i == goalNode) {
                        sb.append(distTmp[i]).append("\n");
                        return;
                    }
                }
            }
        }
    }
}

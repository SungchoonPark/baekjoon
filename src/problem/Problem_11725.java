package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem_11725 {
    static StringTokenizer st;
    static StringBuilder sb;
    static int n;
    static List<Integer>[] array;
    static boolean[] visited;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        array = new ArrayList[n+1];
        visited = new boolean[n+1];
        parent = new int[n+1];

        for(int i=0; i<n+1; i++) {
            array[i] = new ArrayList<>();
        }

        for(int i=0; i<n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            array[a].add(b);
            array[b].add(a);
        }

        bfs(1);

        for (int i=2; i<n+1; i++) {
            sb.append(parent[i]).append("\n");
        }
        System.out.println(sb);
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.add(start);

        while(!q.isEmpty()) {
            start = q.poll();
            for(int i=0; i<array[start].size(); i++) {
                int a = array[start].get(i);
                if (!visited[a]) {
                    q.add(a);
                    parent[a] = start;
                    visited[a] = true;
                }
            }
        }
    }
}

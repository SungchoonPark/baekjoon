package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem_1240 {
    static StringTokenizer st;
    static StringBuilder sb;
    static int n, m;
    static List<Edge>[] array;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        array = new ArrayList[n+1];

        for(int i=0; i<n+1; i++) {
            array[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());
            array[a].add(new Edge(b, len));
            array[b].add(new Edge(a, len));
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
        Queue<Edge> q = new LinkedList<>();
        isVisited = new boolean[n + 1];

        isVisited[startNode] = true;
        q.add(new Edge(startNode, 0));

        while (!q.isEmpty()) {
            Edge curNode = q.poll();
            if (curNode.next == goalNode) {
                sb.append(curNode.distance).append("\n");
                return;
            }

            for (Edge node : array[curNode.next]) {
                if (!isVisited[node.next]) {
                    q.add(new Edge(node.next, curNode.distance + node.distance));
                    isVisited[node.next] = true;
                }
            }

        }
    }
}

class Edge {
    int next;
    int distance;

    public Edge(int next, int distance) {
        this.next = next;
        this.distance = distance;
    }
}

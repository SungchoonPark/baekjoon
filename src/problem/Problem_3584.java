package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_3584 {
    static StringTokenizer st;
    static StringBuilder sb;
    static int[] parent;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int testNum = Integer.parseInt(br.readLine());

        for(int i=0; i<testNum; i++) {
            int nodeNum = Integer.parseInt(br.readLine());

            parent = new int[nodeNum + 1];
            isVisited = new boolean[nodeNum + 1];

            for(int k=0; k<nodeNum-1; k++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                parent[b] = a;
            }

            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            parentFind(node1, node2);
        }
        System.out.println(sb);
    }

    public static void parentFind(int node1, int node2) {
        while(node1>0) {
            isVisited[node1] = true;
            node1 = parent[node1];
        }

        while(node2>0) {
            if (isVisited[node2]) {
                sb.append(node2).append("\n");
                break;
            }
            node2 = parent[node2];
        }
    }
}

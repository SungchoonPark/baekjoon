package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem_1167 {
    static StringTokenizer st;
    static StringBuilder sb;
    static List<Node>[] array;
    static boolean[] isVisited;
    static int max = 0;
    static int farNode;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int nodeNum = Integer.parseInt(br.readLine());
        array = new ArrayList[nodeNum + 1];
        isVisited = new boolean[nodeNum + 1];
        for (int i = 0; i < nodeNum + 1; i++) {
            array[i] = new ArrayList<>();
        }

        for (int i = 0; i < nodeNum; i++) {
            st = new StringTokenizer(br.readLine());
            int curNode = Integer.parseInt(st.nextToken());

            while (true) {
                int tmp = Integer.parseInt(st.nextToken());
                if (tmp == -1) {
                    break;
                }
                int length = Integer.parseInt(st.nextToken());
                array[curNode].add(new Node(tmp, length));
            }
        }

        dfs(1, 0);

        isVisited = new boolean[nodeNum+1];
//        dfs(farNode, 0);

        System.out.println(max);
    }

    public static void dfs(int x, int len) {
        if (len > max) {
            max = len;
            farNode = x;
        }
        isVisited[x] = true;

        for (int i = 0; i < array[x].size(); i++) {
            Node n = array[x].get(i);
            if (!isVisited[n.next]) {
                dfs(n.next, n.length + len);
                isVisited[n.next] = true;
            }
        }
    }
}

class Node {
    int next;
    int length;

    public Node(int next, int length) {
        this.next = next;
        this.length = length;
    }
}

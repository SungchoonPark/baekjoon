package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem_15971 {
    static StringTokenizer st;
    static StringBuilder sb;
    static int caveNum, roomNum1, roomNum2;
    static boolean[] isVisited;
    static List<Node>[] nodeList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        caveNum = Integer.parseInt(st.nextToken());
        roomNum1 = Integer.parseInt(st.nextToken());
        roomNum2 = Integer.parseInt(st.nextToken());
        isVisited = new boolean[caveNum + 1];

        nodeList = new ArrayList[caveNum+1];
        for(int i=0; i<caveNum+1; i++) {
            nodeList[i] = new ArrayList<>();
        }

        for (int i = 0; i < caveNum - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int room1 = Integer.parseInt(st.nextToken());
            int room2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            nodeList[room1].add(new Node(room2, cost));
            nodeList[room2].add(new Node(room1, cost));

        }

        bfs(roomNum1, roomNum2);
        System.out.println(sb);
    }

    public static void bfs(int start, int end) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(start, 0, 0));
        isVisited[start] = true;

        while (!q.isEmpty()) {
            Node current = q.poll();

            if (current.room1 == end) {
                sb.append(current.totalCost - current.max);
                break;
            }

            for (Node next : nodeList[current.room1]) {
                if (!isVisited[next.room1]) {
                    isVisited[next.room1] = true;
                    q.add(new Node(next.room1, current.totalCost + next.totalCost, Math.max(current.max, next.totalCost)));
                }
            }
        }
    }
}

class Node {
    int room1, totalCost, max;

    public Node(int room1, int totalCost) {
        this.room1 = room1;
        this.totalCost = totalCost;
    }

    public Node(int room1, int totalCost, int max) {
        this.room1 = room1;
        this.totalCost = totalCost;
        this.max = max;
    }
}

package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem_28256 {
    static StringTokenizer st;
    static StringBuilder sb;
    static int[][] array;
    static boolean[][] visited;
    static int cnt;
    static int[][] pos = {{0,1}, {0, -1}, {1, 0}, {-1, 0}};
    static List<Integer> expectList;
    static List<Integer> realList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int testNum = Integer.parseInt(br.readLine());

        while (testNum --> 0) {
            expectList = new ArrayList<>();
            realList = new ArrayList<>();
            array = new int[3][3];
            visited = new boolean[3][3];
            cnt = 1;
            for (int i = 0; i < 3; i++) {
                String chocolate = br.readLine();
                for (int j = 0; j < chocolate.length(); j++) {
                    char c = chocolate.charAt(j);
                    if (c == 'O') {
                        array[i][j] = 1;
                    } else if (c == 'X') {
                        array[i][j] = 0;
                    } else {
                        array[i][j] = -1;
                    }
                }
            }

            st = new StringTokenizer(br.readLine());

            int epNum = Integer.parseInt(st.nextToken());
            for(int i=0; i<epNum; i++) {
                expectList.add(Integer.parseInt(st.nextToken()));
            }

            for(int i=0; i<3; i++) {
                for(int j=0; j<3; j++) {
                    cnt = 1;
                    if(!visited[i][j] && array[i][j] == 1) {
                        int dfsCnt = dfs(i, j);
                        realList.add(dfsCnt);
                    }
                }
            }

            Collections.sort(realList);

            if(Objects.equals(expectList, realList)) {
                sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }
        }

        System.out.println(sb);
    }

    public static int dfs(int x, int y) {
        visited[x][y] = true;
        for(int i=0; i<4; i++) {
            int nx = x + pos[i][0];
            int ny = y + pos[i][1];

            if(nx >= 0 && nx < 3 && ny >= 0 && ny < 3 && !visited[nx][ny] && array[nx][ny] == 1) {
                cnt ++;
                dfs(nx, ny);
            }
        }
        return cnt;
    }
}

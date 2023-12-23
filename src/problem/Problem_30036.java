package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem_30036 {
    static StringTokenizer st;
    static StringBuilder sb;
    static char[] inkWords;
    static char[][] stage;
    static char[] commands;

    static int jumpCnt;
    static int inkAmount;
    static int cX;
    static int cY;
    static int nX;
    static int nY;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        int i = Integer.parseInt(st.nextToken());
        inkWords = new char[i];
        int n = Integer.parseInt(st.nextToken());
        stage = new char[n][n];
        int k = Integer.parseInt(st.nextToken());
        commands = new char[k];

        String inks = br.readLine();
        for (int tmp = 0; tmp < i; tmp++) {
            inkWords[tmp] = inks.charAt(tmp);
        }

        for (int y = 0; y < n; y++) {
            String line = br.readLine();
            for (int x = 0; x < n; x++) {
                if (line.charAt(x) == '@') {
                    cX = x;
                    cY = y;
                }
                stage[y][x] = line.charAt(x);
            }
        }

        String cmds = br.readLine();
        for (int tmp = 0; tmp < k; tmp++) {
            commands[tmp] = cmds.charAt(tmp);
        }

        for (int tmp = 0; tmp < k; tmp++) {
            switch (commands[tmp]) {
                case 'U':
                    nX = cX;
                    nY = cY - 1;
                    if (nY >= 0 && nY < n && stage[nY][nX] == '.') {
                        stage[cY][cX] = '.';
                        cX = nX;
                        cY = nY;
                        stage[cY][cX] = '@';
                    }
                    break;
                case 'D':
                    nX = cX;
                    nY = cY + 1;
                    if (nY >= 0 && nY < n && stage[nY][nX] == '.') {
                        stage[cY][cX] = '.';
                        cX = nX;
                        cY = nY;
                        stage[cY][cX] = '@';
                    }
                    break;
                case 'L':
                    nX = cX - 1;
                    nY = cY;
                    if (nX >= 0 && nX < n && stage[nY][nX] == '.') {
                        stage[cY][cX] = '.';
                        cX = nX;
                        cY = nY;
                        stage[cY][cX] = '@';
                    }
                    break;
                case 'R':
                    nX = cX + 1;
                    nY = cY;
                    if (nX >= 0 && nX < n && stage[nY][nX] == '.') {
                        stage[cY][cX] = '.';
                        cX = nX;
                        cY = nY;
                        stage[cY][cX] = '@';
                    }
                    break;
                case 'j':
                    inkAmount++;
                    break;
                case 'J':
                    jumpCnt++;
                    char inkColor = inkWords[(jumpCnt - 1) % i];

                    for (int tmpY = 0; tmpY < n; tmpY++) {
                        for (int tmpX = 0; tmpX < n; tmpX++) {

                            int re = Math.abs(cY-tmpY) + Math.abs(cX-tmpX);

                            if (re <= inkAmount && stage[tmpY][tmpX] != '.' && stage[tmpY][tmpX] != '@') {
                                if(stage[tmpY][tmpX] == 'R') {
                                }
                                stage[tmpY][tmpX] = inkColor;
                            }
                        }
                    }
                    inkAmount = 0;
                    break;
            }
        }
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                sb.append(stage[y][x]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
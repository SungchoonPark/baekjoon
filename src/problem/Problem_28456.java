package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_28456 {

    static StringTokenizer st;
    static StringBuilder sb;
    static int[][] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        array = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int Q = Integer.parseInt(br.readLine());

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());

            int first = Integer.parseInt(st.nextToken());

            if (first == 1) {
                int row = Integer.parseInt(st.nextToken()) - 1;

                int tmp = array[row][N - 1];
                for (int j = N - 1; j > 0; j--) {
                    array[row][j] = array[row][j - 1];
                }
                array[row][0] = tmp;

            } else {
                // 여기서 시계방향으로 90도 돌리면 됨
                int[][] A = new int[N][N];
                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < N; k++) {
                        int i1 = N - k;

                        A[j][k] = array[N-1-k][j];
                    }
                }
                array = A;
            }
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(array[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}

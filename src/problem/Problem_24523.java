package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem_24523 {
    static StringTokenizer st;
    static StringBuilder sb;
    static int[] array;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        array = new int[N+1];
        result = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<N+1; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int idx = -1;
        for(int i=N; i>0; i--) {
            result[i] = idx;
            if(array[i] != array[i-1]) {
                idx = i;
            }
        }

        for(int i=1; i<N+1; i++) {
            sb.append(result[i]).append(" ");
        }

        System.out.println(sb);
    }
}

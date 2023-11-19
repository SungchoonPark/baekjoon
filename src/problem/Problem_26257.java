package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem_26257 {
    static StringTokenizer st;
    static StringBuilder sb;
    static int[] pointer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        pointer = new int[M];
        int Q = Integer.parseInt(st.nextToken());

        for(int i=0; i<M; i++) {
            pointer[i] = Integer.parseInt(br.readLine());
        }

        for(int i=0; i<Q; i++) {
            st = new StringTokenizer(br.readLine());

            while(st.hasMoreTokens()) {
                String cal = st.nextToken();

                if(cal.equals("reset")) {
                    int num = Integer.parseInt(st.nextToken());
                    pointer[num-1] = 0;
                } else {
                    if(cal.equals("assign")) {
                        int x = Integer.parseInt(st.nextToken());
                        int y = Integer.parseInt(st.nextToken());
                        pointer[x-1] = pointer[y-1];
                    }
                    if (cal.equals("swap")) {
                        int x = Integer.parseInt(st.nextToken());
                        int y = Integer.parseInt(st.nextToken());

                        int tmp = pointer[x-1];
                        pointer[x-1] = pointer[y-1];
                        pointer[y-1] = tmp;
                    }
                }
            }
        }

        int[] resultArray = Arrays.stream(pointer)
                .filter(x -> x > 0)
                .distinct()
                .sorted()
                .toArray();

        for(int i=0; i<resultArray.length; i++) {
            if(resultArray[i] != 0) {
                sb.append(resultArray[i]).append("\n");
            }
        }


        System.out.println(resultArray.length);
        System.out.println(sb);
    }
}

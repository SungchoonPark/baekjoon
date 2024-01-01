package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_27966 {
    static long n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        sb.append(n - 1 + (n - 1) * (n - 2)).append("\n");

        for (int i = 2; i <= n; i++) {
            sb.append(1).append(" ").append(i).append("\n");
        }

        System.out.println(sb);
    }
}

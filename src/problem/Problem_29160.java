package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem_29160 {
    static StringTokenizer st;
    static int totalValue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());

        Map<Integer, PriorityQueue<Integer>> team = new HashMap<>();

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= 11; i++) {
            team.put(i, new PriorityQueue<>(Collections.reverseOrder()));
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int position = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            team.get(position).add(value);
        }

        for (int i = 0; i < k; i++) {
            for (int j = 1; j <= 11; j++) {
                Integer maxValue = team.get(j).peek();
                if (maxValue == null) {
                    continue;
                }
                if (maxValue != 1) {
                    team.get(j).poll();
                    team.get(j).add(maxValue - 1);
                }
            }
        }

        for (int i = 1; i <= 11; i++) {
            Integer maxValue = team.get(i).peek();
            if (maxValue != null) {
                totalValue += maxValue;
            }
        }

        System.out.println(totalValue);
    }
}

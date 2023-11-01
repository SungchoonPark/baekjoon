package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_27160 {
    static StringTokenizer st;
    // STRAWBERRY, BANANA, LIME, PLUM
    static int[] fruit = new int[4];
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tryNum = Integer.parseInt(br.readLine());

        while(tryNum --> 0) {
            st = new StringTokenizer(br.readLine());
            String fruitName = st.nextToken();
            int fruitNum = Integer.parseInt(st.nextToken());

            switch (fruitName) {
                case "STRAWBERRY":
                    fruit[0] += fruitNum;
                    break;
                case "BANANA":
                    fruit[1] += fruitNum;
                    break;
                case "LIME":
                    fruit[2] += fruitNum;
                    break;
                case "PLUM":
                    fruit[3] += fruitNum;
                    break;
            }
        }

        for (int i : fruit) {
            if(i == 5) {
                flag = true;
            }
        }

        if(flag) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }
}

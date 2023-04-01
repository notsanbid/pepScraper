import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        
        long[] dp = new long[n + 1];
        long same = 0;
        long diff = k;
        dp[1] = same + diff;

        for(int i = 2; i < dp.length; i++){
            same = diff; // number of ways in which this fence is painted same as old fence following the rule of not more than 2.
            diff = dp[i - 1] * (k - 1); // number of ways in which this fence can be painted different from old fence.
            dp[i] = same + diff; // number of ways in which this fence can be painted
        }

        System.out.println(dp[n]);
    }
}
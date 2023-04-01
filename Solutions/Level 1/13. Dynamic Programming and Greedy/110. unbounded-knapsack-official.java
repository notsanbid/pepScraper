import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] values = new int[n];
        String str1 = br.readLine();
        for (int i = 0; i < n; i++) {
            values[i] = Integer.parseInt(str1.split(" ")[i]);
        }

        int[] wts = new int[n];
        String str2 = br.readLine();
        for (int i = 0; i < n; i++) {
            wts[i] = Integer.parseInt(str2.split(" ")[i]);
        }

        int cap = Integer.parseInt(br.readLine());

        int[] dp = new int[cap + 1];
        for (int i = 1; i < dp.length; i++) {
           for(int j = 0; j < wts.length; j++){
               int val = values[j];
               int wt = wts[j];

               if(i >= wt){
                   int factor = dp[i - wt] + val;
                   if(factor > dp[i]){
                       dp[i] = factor;
                   }
               }
           }
        }

        System.out.println(dp[cap]);
    }
}
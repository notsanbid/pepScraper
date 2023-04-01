import java.io.*;
import java.util.*;

public class Main {

   public static class Pair{
      int i;
      int j;
      String psf;

      public Pair(int i, int j, String psf){
         this.i = i;
         this.j = j;
         this.psf = psf;
      }
   }
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

        int[][] dp = new int[n + 1][cap + 1];
        for (int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[0].length; j++){
                int val = values[i - 1];
                int wt = wts[i - 1];

                if(j >= wt){
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - wt] + val);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        System.out.println(dp[n][cap]);
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(n,cap,""));
      

        while (q.size() > 0) {
			Pair rp = q.remove();
			if (rp.i == 0 || rp.j == 0) {
				System.out.println(rp.psf);
			} else {
				int exc = dp[rp.i - 1][rp.j];
				int inc = rp.j - wts[rp.i - 1] >= 0 ? (dp[rp.i - 1][rp.j - wts[rp.i - 1]] + values[rp.i - 1]) : Integer.MIN_VALUE;
				
				if (dp[rp.i][rp.j] == inc) {
					q.add(new Pair(rp.i - 1, rp.j - wts[rp.i - 1], (rp.i - 1) + " " + rp.psf));
				}
				if (dp[rp.i][rp.j] == exc) {
					q.add(new Pair(rp.i - 1, rp.j, rp.psf));
				}
			}
		}
    }
}
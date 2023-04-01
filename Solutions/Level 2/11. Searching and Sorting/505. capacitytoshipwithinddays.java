import java.util.*;
import java.io.*;

public class Main {

  public static int shipWithinDays(int[]wt, int days) {
    //write your code here
    int max = 0;
    int sum = 0;

    for (int val : wt) {
      sum += val;
      max = Math.max(val, max);
    }

    if (days == wt.length) {
      return max;
    }

    int lo = max;
    int hi = sum;
    int ans = 0;

    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;

      if (isPossible(wt, mid, days) == true) {
        ans = mid;
        hi = mid - 1;
      }
      else {
        lo = mid + 1;
      }
    }

    return ans;
  }

  public static boolean isPossible(int[]wt, int mid, int days) {
    int d = 1;
    int sum = 0;

    for (int i = 0; i < wt.length; i++) {
      sum += wt[i];

      if (sum > mid) {
        sum = wt[i];
        d++;
      }
    }

    return d <= days;
  }

  public static void main(String[]args) {
    //input work
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    int[]wt = new int[n];

    for (int i = 0; i < n; i++) {
      wt[i] = scn.nextInt();
    }

    int days = scn.nextInt();

    int ans = shipWithinDays(wt, days);
    System.out.println(ans);
  }
}
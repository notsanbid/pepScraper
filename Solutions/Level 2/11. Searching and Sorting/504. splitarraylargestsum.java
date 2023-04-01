import java.util.*;
import java.io.*;

public class Main {

  public static int splitArray(int[]arr, int m) {
    //write your code here
    int max = 0;
    int sum = 0;

    for (int val : arr) {
      sum += val;
      max = Math.max(val, max);
    }

    if (m == arr.length) {
      return max;
    }

    int lo = max;
    int hi = sum;
    int ans = 0;

    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;

      if (isPossible(arr, mid, m) == true) {
        ans = mid;
        hi = mid - 1;
      }
      else {
        lo = mid + 1;
      }
    }

    return ans;
  }

  public static boolean isPossible(int[]nums, int mid, int m) {
    int sc = 1;
    int sum = 0;

    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];

      if (sum > mid) {
        sum = nums[i];
        sc++;
      }
    }

    return sc <= m;
  }

  public static void main(String[]args) {
    //input work
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    int[]arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }

    int m = scn.nextInt();

    int ans = splitArray(arr, m);
    System.out.println(ans);
  }
}
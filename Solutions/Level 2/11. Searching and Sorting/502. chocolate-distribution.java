import java.util.*;
import java.io.*;

public class Main {

  public static int find(int[]arr, int n, int m) {
    Arrays.sort(arr);
    int ans = Integer.MAX_VALUE;

    for (int i = 0; i <= arr.length - m; i++) {
      int minw = arr[i];
      int maxw = arr[i + m - 1];

      if (maxw - minw < ans) {
        ans = maxw - minw;
      }
    }

    return ans;
  }

  public static void main(String[]args) {
    Scanner scn = new Scanner(System.in);
    //input work
    int n = scn.nextInt();
    int[]arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }

    int m = scn.nextInt();
    int ans = find(arr, n, m);

    System.out.println(ans);
  }
}
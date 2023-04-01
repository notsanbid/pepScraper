import java.util.*;
import java.io.*;

public class Main {

  public static ArrayList<Integer>  leaders(int[]arr) {
    ArrayList<Integer>ans = new ArrayList<>();

    int rmax = Integer.MIN_VALUE;

    for (int i = arr.length - 1; i >= 0; i--) {
      if (arr[i] >= rmax) {
        ans.add(arr[i]);
        rmax = arr[i];
      }
    }

    Collections.reverse(ans);
    return ans;
  }


  public static void main(String[]args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[]arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }

    ArrayList<Integer>ans = leaders(arr);

    for (int val : ans) {
      System.out.print(val + " ");
    }
  }
}
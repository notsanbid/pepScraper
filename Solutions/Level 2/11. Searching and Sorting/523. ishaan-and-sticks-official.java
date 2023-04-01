import java.util.*;
import java.io.*;

public class Main {

  public static ArrayList < Integer > solve(int[] arr) {
    HashMap < Integer, Integer > map = new HashMap < > ();

    for (int i = 0; i < arr.length; i++) {
      if (map.containsKey(arr[i]) == true) {
        map.put(arr[i], map.get(arr[i]) + 1);
      }
      else {
        map.put(arr[i], 1);
      }
    }


    int sq = 0;
    int max_area = 0;

    for (int key : map.keySet()) {
      int freq = map.get(key);

      if (freq >= 4) {
        int area = key * key;
        if (area > max_area) {
          max_area = area;
          sq = freq / 4;
        }

      }
    }

    ArrayList < Integer > ans = new ArrayList < > ();

    if (sq > 0) {
      ans.add(max_area);
      ans.add(sq);
    }
    else {
      ans.add(-1);
    }

    return ans;
  }


  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }

    ArrayList < Integer > ans = solve(arr);

    for (int val : ans) {
      System.out.print(val + " ");
    }
  }
}
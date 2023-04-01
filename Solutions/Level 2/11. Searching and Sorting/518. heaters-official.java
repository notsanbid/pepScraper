import java.util.*;
import java.io.*;

public class Main {

  static class Pair {
    int js = -1; //just smaller
    int jl = -1; //just larger

    Pair(int js, int jl) {
      this.js = js;
      this.jl = jl;
    }

    Pair() {

    }
  }

  public static int findRadius(int[]houses, int[]heaters) {
    //write your code here
    int ans = 0;

    Arrays.sort(heaters);

    for (int i = 0; i < houses.length; i++) {
      Pair p = binarySearch(houses[i], heaters);

      int d1 = (p.js == -1) ? Integer.MAX_VALUE : (houses[i] - p.js);
      int d2 = (p.jl == -1) ? Integer.MAX_VALUE : (p.jl - houses[i]);

      int min = Math.min(d1, d2);

      if (ans < min) {
        ans = min;
      }
    }

    return ans;
  }

  public static Pair binarySearch(int house, int[]heaters) {
    Pair p = new Pair();

    int lo = 0;
    int hi = heaters.length - 1;

    while (lo <= hi) {
      int mid = (lo + hi) / 2;

      if (heaters[mid] == house) {
        p.js = heaters[mid];
        p.jl = heaters[mid];
        break;
      }
      else if (heaters[mid] < house) {
        p.js = heaters[mid];
        lo = mid + 1;
      }
      else {
        p.jl = heaters[mid];
        hi = mid - 1;
      }
    }

    return p;
  }

  public static void main(String[]args) {
    //input work
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[]houses = new int[n];

    for (int i = 0; i < n; i++) {
      houses[i] = scn.nextInt();
    }

    int m = scn.nextInt();
    int[]heaters = new int[m];

    for (int i = 0; i < m; i++) {
      heaters[i] = scn.nextInt();
    }

    System.out.println(findRadius(houses, heaters));
  }
}
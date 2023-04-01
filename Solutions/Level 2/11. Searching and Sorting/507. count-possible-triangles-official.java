import java.util.*;
import java.io.*;

public class Main {

  public static int countTriangles(int[]arr) {
    //write your code here
    Arrays.sort(arr);
    int count = 0;

    for (int i = arr.length - 1; i >= 0; i--) {
      int lo = 0;
      int hi = i - 1;

      while (lo <= hi) {
        if (arr[lo] + arr[hi] > arr[i]) {
          count += (hi - lo);
          hi--;
        }
        else {
          lo++;
        }
      }
    }
    return count;
  }

  public static void main(String[]args) {
    //input work
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    int[]arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }

    System.out.println(countTriangles(arr));
  }
}
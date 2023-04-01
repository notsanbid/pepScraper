import java.util.*;
import java.io.*;

public class Main {

  public static int findRow(int[][]mat) {
    //write your code here
    // your code here
    int max = 0;
    int r = 0;

    for (int i = 0; i < mat.length; i++) {
      int count  = binarySearch(mat, i);

      if (count > max) {
        r = i;
        max = count;
      }

    }

    return r;
  }

  public static int binarySearch(int[][]mat, int r) {
    int count = 0;
    int lo = 0;
    int hi = mat[0].length - 1;
    int fi1 = mat[0].length; //first index of 1

    //need to find first index of one
    while (lo <= hi) {
      int mid = (lo + hi) / 2;

      if (mat[r][mid] == 1) {
        fi1 = mid;
        hi = mid - 1;
      }
      else {
        lo = mid + 1;
      }
    }

    count = mat[0].length - fi1;
    return count;
  }

  public static void main(String[]args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int m = scn.nextInt();

    int[][]mat = new int[n][m];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        mat[i][j] = scn.nextInt();
      }
    }

    System.out.println(findRow(mat));
  }
}
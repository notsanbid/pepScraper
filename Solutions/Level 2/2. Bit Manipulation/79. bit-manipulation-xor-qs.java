import java.util.*;

public class Main {
  class Solution {
    public int[] xorQueries(int[] arr, int[][] q) {
      int[] ans = new int[q.length];
      int[] prefXor = new int[arr.length];
      prefXor[0] = arr[0];
      for (int i = 1; i < arr.length; i++) {
        prefXor[i] = arr[i] ^ prefXor[i - 1];
      }

      for (int i = 0; i < q.length; i++) {
        int l = q[i][0];
        int r = q[i][1];
        if (l == 0) ans[i] =  prefXor[r];
        else ans[i] = prefXor[r] ^ prefXor[l - 1];
      }
      return ans;
    }
  }
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

  }
}
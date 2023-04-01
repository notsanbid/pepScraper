import java.io.*;
import java.util.*;

class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  static PrintWriter out = new PrintWriter(System.out);
  /*
  use in for reading input
  use out for printing output
  */

  static int minStart[];
  static int MAXBIT = 20;// 10^5 < 2^20
  static int table[][];

  static void build(int n) {
    table = new int[MAXBIT][n];
    table[0] = minStart;

    for (int j = 1; j < MAXBIT; j++) {
      for (int i = 0; i < n; i++) {
        int par = table[j - 1][i];
        table[j][i] = par == -1 ? par : table[j - 1][par];
      }
    }
  }

  static int cal(int max, int k) {
    int min = max;

    // for(int i=1;i<=k && min > -1;i++){
    //     min = minStart[min];
    // }

    for (int i = MAXBIT; i >= 0 && min > -1; i--) {
      int mask = 1 << i;
      if ((mask & k) > 0) {
        min = table[i][min];
      }
    }

    return max - min;
  }

  static void solve() throws IOException {
    int ar[] = read(in.readLine());// [n, k, s]
    int n = ar[0];
    int k = ar[1];
    int s = ar[2];
    minStart = new int[n];
    int nums[] = read(in.readLine());

    int j = 0, sum = 0;

    for (int i = 0; i < n; i++) {
      sum += nums[i];
      while (sum > s) {
        sum -= nums[j];
        j++;
      }
      minStart[i] = j - 1;
    }
    build(n);
    int max = 0;

    for (int i = nums.length - 1; i >= 0; i--) {
      max = Math.max(max, cal(i, k));
    }
    out.println(max);
  }

  static int[] read(String s) { // n k s
    String inp[] = s.split(" ");
    int ar[] = new int[inp.length];
    for (int i = 0; i < inp.length; i++) {
      ar[i] = Integer.parseInt(inp[i]);
    }
    return ar;
  }

  public static void main(String[] args) throws IOException {

    // write your code here.

    int t = Integer.parseInt(in.readLine());

    while (t-- > 0) {
      solve();
    }
    out.close();
  }
}
import java.util.*;

public class Main {

  // ~~~~~~~~~~~User's Section~~~~~~~~~~~~~
  public static int consecutiveNumbersSum(int n) {
    int ans = 0;
    for (int k = 1; k * (k - 1) < 2 * n; k++) {
      int numerator = n - (k * (k - 1) / 2);
      if (numerator % k == 0)
        ans++;
    }
    return ans;
  }

  // ~~~~~~~~~Input Management~~~~~~~~~~~~~~
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int num = scn.nextInt();
    int res = consecutiveNumbersSum(num);
    System.out.println(res);
  }
}
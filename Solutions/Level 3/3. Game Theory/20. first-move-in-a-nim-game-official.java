import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  static int Solve(int[] arr) {

    int xorarr = 0;
    for (int i = 0; i < arr.length; i++) {
      xorarr = xorarr ^ arr[i];
    }

    if (xorarr == 0) {
      return -1;
    }

    int numberOfWays = 0;

    for (int i = 0; i < arr.length; i++) {
      int requiredCoins = xorarr ^ arr[i];

      if (requiredCoins < arr[i]) {
        numberOfWays++;
      }
    }
    return numberOfWays;
  }

  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int arr[] = new int[n];
    String[] st = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st[i]);
    }
    System.out.println(Solve(arr));
  }
}
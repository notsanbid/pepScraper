import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static String findWinner(int[] arr, int n) {
    int res = 0;

    for (int i = 0; i < n; i++) {
      res ^= arr[i];
    }

    if (res == 0 || n % 2 == 0) {
      return "Alice";
    }

    else {
      return "Bob";
    }
  }

  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    String[] st = br.readLine().split(" ");

    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st[i]);
    }

    System.out.println(findWinner(arr, n));
  }
}
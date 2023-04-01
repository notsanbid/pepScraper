import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static String getWinner(int arr[], int n) {
    int movesA = 0, movesB = 0, movesBoth = 0;

    for (int i = 0; i < n; i++) {

      if (arr[i] % 3 == 0 && arr[i] % 5 == 0) {
        movesBoth++;
      } else if (arr[i] % 3 == 0) {
        movesA++;
      } else if (arr[i] % 5 == 0) {
        movesB++;
      }
    }

    if (movesBoth == 0) {
      if (movesA > movesB) {
        return "ALICE";
      }
      return "BOB";
    }

    if (movesA + 1 > movesB) {
      return "ALICE";
    }
    return "BOB";
  }

  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    String[] st = br.readLine().split(" ");

    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st[i]);
    }

    System.out.println(getWinner(arr, n));
  }
}
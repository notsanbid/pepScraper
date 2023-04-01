import java.util.*;

public class Main {

  // ~~~~~~~~~~~~~User's Section~~~~~~~~~~~~~~
  private static void solveConfiguration(char[] arr, int i, int j) {
    if (arr[i] == 'L' && arr[j] == 'L') {
      for (int k = i + 1; k < j; k++)
        arr[k] = 'L';
    } else if (arr[i] == 'R' && arr[j] == 'R') {
      for (int k = i + 1; k < j; k++)
        arr[k] = 'R';
    } else if (arr[i] == 'L' && arr[j] == 'R') {
      // nothing to do
    } else {
      int diff = j - i;
      if (diff % 2 == 0) {
        int mid = (i + j) / 2;
        for (int k = i + 1; k < mid; k++)
          arr[k] = 'R';

        for (int k = mid + 1; k < j; k++)
          arr[k] = 'L';

      } else {
        int mid = (i + j) / 2;
        for (int k = i + 1; k <= mid; k++)
          arr[k] = 'R';

        for (int k = mid + 1; k < j; k++)
          arr[k] = 'L';

      }
    }
  }

  public static String pushDominoes(String str) {
    char[] arr = new char[str.length() + 2];
    arr[0] = 'L';
    arr[arr.length - 1] = 'R';
    for (int i = 1; i < arr.length - 1; i++) {
      arr[i] = str.charAt(i - 1);
    }
    int j = 0, k = 1;
    while (k < arr.length) {
      while (arr[k] == '.') {
        k++;
      }
      if (k - j > 1)
        solveConfiguration(arr, j, k);
      j = k;
      k++;
    }
    StringBuilder res = new StringBuilder();
    for (int i = 1; i < arr.length - 1; i++) {
      res.append(arr[i]);
    }
    return res.toString();
  }

  // ~~~~~~~~~~~Input Management~~~~~~~~~~~~
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String str = scn.nextLine();
    String res = pushDominoes(str);
    System.out.println(res);
  }
}
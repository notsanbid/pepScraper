import java.util.*;

public class Main {
  public static void solve(int n, int k, String str) {
    char[] arr = str.toCharArray();
    Arrays.sort(arr);

    if (arr[0] != arr[k - 1]) {
      System.out.println(arr[k - 1]);
      return;
    }

    System.out.print(arr[0]);
    if (k < n && arr[k] != arr[n - 1]) {
      for (int i = k; i < n; i++) {
        System.out.print(arr[i] );
      }
    } else {
      for (int i = 0; i < (n - 1) / k; i++) {
        System.out.print(arr[n - 1]);
      }
    }
    System.out.println();
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      String str = sc.next();

      solve(n, k, str);
    }
  }
}
import java.util.Scanner;

public class Main {
  static void ternarySearch(int arr[], int k)
  {
    int l = 0;
    int r = arr.length - 1;
    boolean found = false;

    while (l <= r) {
      int m1 = l + (r - l) / 3;
      int m2 = r - (r - l) / 3;

      if (arr[m1] == k || arr[m2] == k) {
        found = true;
        break;
      }

      if (k < arr[m1]) {
        r = m1 - 1;
      } else if (k > arr[m2]) {
        l = m2 + 1;
      } else {
        l = m1 + 1;
        r = m2 - 1;
      }
    }

    if (found) {
      System.out.println("Found");
    } else {
      System.out.println("Not Found");
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int k = sc.nextInt();

    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    ternarySearch(arr, k);
  }
}
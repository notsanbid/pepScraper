import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws IOException {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] num = new int[n];
    for (int i = 0; i < n; i++) {
      num[i] = scn.nextInt();
    }
    int k = scn.nextInt();
    solve(num, k);
  }

  public static int binarySearch(int arr[], int l, int r, int x)
  {
    if (r >= l)
    {
      int mid = l + (r - l) / 2;

      // If the element is present at
      // one of the middle 3 positions
      if (arr[mid] == x)
        return mid;
      if (mid > l && arr[mid - 1] == x)
        return (mid - 1);
      if (mid < r && arr[mid + 1] == x)
        return (mid + 1);

      // If element is smaller than mid, then
      // it can only be present in left subarray
      if (arr[mid] > x)
        return binarySearch(arr, l, mid - 2, x);

      // Else the element can only be present
      // in right subarray
      return binarySearch(arr, mid + 2, r, x);
    }

    // We reach here when element is
    // not present in array
    return -1;
  }

  public static void solve(int[] arr, int k) {
    System.out.println(binarySearch(arr, 0, arr.length - 1, k));
  }
}
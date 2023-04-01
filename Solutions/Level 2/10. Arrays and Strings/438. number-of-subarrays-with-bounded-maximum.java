import java.util.*;

public class Main {

  public static int numSubarrayBoundedMax(int[] arr, int left, int right) {
    int si = 0;
    int ei = 0;
    int count = 0;
    int prevc = 0;

    while (ei < arr.length) {
      if (arr[ei] >= left && arr[ei] <= right) {
        count += ei - si + 1;
        prevc = ei - si + 1;
      } else if (arr[ei] < left) {
        count += prevc;
      } else {
        prevc = 0;
        si = ei + 1;
      }
      ei++;
    }
    return count;
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }

    int left = scn.nextInt();
    int right = scn.nextInt();

    int count = numSubarrayBoundedMax(arr, left, right);
    System.out.println(count);
  }
}